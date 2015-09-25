package com.github.web.xss;

import java.io.IOException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.util.HtmlUtils;

import com.github.web.xss.XssCheck;


public class XssInterceptor extends HandlerInterceptorAdapter {

  private boolean enabled = true; // 默认为启用

  @SuppressWarnings({"rawtypes", "unchecked"})
  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
      throws IOException, MalformedURLException {
    if (!enabled) { // 禁用后直接返回
      return true;
    }
    if (!(handler instanceof HandlerMethod)) {
      return true;
    }
    HandlerMethod handlerMethod = (HandlerMethod) handler;
    Method method = handlerMethod.getMethod();
    if (!method.isAnnotationPresent(XssCheck.class)) {
      return true;
    }

    Map map = request.getParameterMap();// 获取页面提交到action前参数
    if (map != null && !map.isEmpty()) {
      Set<String> keys = map.keySet();
      Iterator<String> it = keys.iterator();
      while (it.hasNext()) {
        String key = it.next();
        Object t = map.get(key);
        if (t instanceof String) {// 给String转码
          if (t != null) {
            t = HtmlUtils.htmlEscape((String) t);
          }
        }
        if (t instanceof String[]) {// 给String数组转码
          if (t != null) {
            String args[] = (String[]) t;
            String[] tmp = (String[]) t;
            for (int i = 0; i < args.length; i++) {
              args[i] = HtmlUtils.htmlEscape(tmp[i]);// 转码类
            }
            t = args;
          }
        }
        request.setAttribute(key, t);
      }
    }
    return true;
  }
}

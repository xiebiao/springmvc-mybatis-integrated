package com.github.web.xss;

import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.util.HtmlUtils;


public class XssInterceptor extends HandlerInterceptorAdapter {

  private boolean enabled = true;

  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
      Object handler) {
    if (enabled == false) {
      return true;
    }
    if (!(handler instanceof org.springframework.web.method.HandlerMethod)) {
      return true;
    }
    HandlerMethod handlerMethod = (HandlerMethod) handler;
    Method method = handlerMethod.getMethod();
    if (!method.isAnnotationPresent(XssCheck.class)) {
      return true;
    }
    Map map = request.getParameterMap();
    if (map != null && !map.isEmpty()) {
      Set<String> keys = map.keySet();
      Iterator<String> it = keys.iterator();
      while (it.hasNext()) {
        String key = it.next();
        Object t = map.get(key);
        if (t instanceof String) {
          if (t != null) {
            t = HtmlUtils.htmlEscape((String) t);
          }
        }
        if (t instanceof String[]) {
          if (t != null) {
            String args[] = (String[]) t;
            String[] tmp = (String[]) t;
            for (int i = 0; i < args.length; i++) {
              args[i] = HtmlUtils.htmlEscape(tmp[i]);
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

package com.github.web.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author xiebiao
 * @date 10/27/14
 */
public class LoginInterceptor implements HandlerInterceptor {
  private Logger LOG = LoggerFactory.getLogger(LoginInterceptor.class);

  @Override
  public boolean preHandle(javax.servlet.http.HttpServletRequest request,
      javax.servlet.http.HttpServletResponse response, Object handler) throws Exception {
    return false;
  }

  @Override
  public void postHandle(javax.servlet.http.HttpServletRequest request,
      javax.servlet.http.HttpServletResponse response, Object handler, ModelAndView modelAndView)
      throws Exception {
    LOG.debug("postHandle");
  }

  @Override
  public void afterCompletion(javax.servlet.http.HttpServletRequest request,
      javax.servlet.http.HttpServletResponse response, Object handler, Exception ex)
      throws Exception {
    LOG.debug("afterCompletion");
  }
}

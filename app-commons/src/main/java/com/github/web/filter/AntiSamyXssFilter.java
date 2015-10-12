package com.github.web.filter;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;

import com.github.web.utils.WebXssScanUtils;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

public class AntiSamyXssFilter implements Filter {
  private final List<String> excludeKeys = Lists.newArrayList();

  public void destroy() {}

  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
      throws IOException, ServletException {
    chain.doFilter(
        new ParameterRequestWrapper((HttpServletRequest) request, handleRequest(request)),
        response);
  }


  public void init(FilterConfig fConfig) throws ServletException {}

  private Map<String, Object> handleRequest(ServletRequest request) {
    Map map = request.getParameterMap();
    Map params = Maps.newHashMap();
    if (map != null && !map.isEmpty()) {
      Set<String> keys = map.keySet();
      Iterator<String> it = keys.iterator();
      while (it.hasNext()) {
        String key = it.next();
        Object value = map.get(key);
        if (excludeKeys.contains(key)) {
          params.put(key, value);
          continue;
        }
        if (value instanceof String) {
          String _value = (String) value;
          value = WebXssScanUtils.filter((String) value);

        }
        if (value instanceof String[]) {
          if (value != null) {
            String args[] = (String[]) value;
            for (int i = 0; i < args.length; i++) {
              args[i] = WebXssScanUtils.filter(args[i]);
            }
            value = args;
          }
        }
        params.put(key, value);
      }
    }
    return params;
  }

}

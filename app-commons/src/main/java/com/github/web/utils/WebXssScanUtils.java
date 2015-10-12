package com.github.web.utils;

import org.owasp.validator.html.AntiSamy;
import org.owasp.validator.html.CleanResults;
import org.owasp.validator.html.Policy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Strings;

public class WebXssScanUtils {

  private final static Logger log = LoggerFactory.getLogger(WebXssScanUtils.class);
  private static AntiSamy antisamy = null;

  static {
    try {
      log.debug("Loading AntiSamy config:" + WebXssScanUtils.class.getResource("/antisamy.xml"));
      Policy policy = Policy.getInstance(WebXssScanUtils.class.getResource("/antisamy.xml"));
      antisamy = new AntiSamy(policy);
      log.debug("AntiSamy init done!");
    } catch (Exception e) {
      log.error("AntiSamy init error:", e);
    }
  }

  /**
   * 统一的XSS安全漏洞处理，过滤字符串。
   */
  public static String filter(String seq) {
    if (Strings.isNullOrEmpty(seq)) {
      return seq;
    }
    if (antisamy == null) {
      log.error("AntiSamy为 null ,请检查其初始化过程！");
      return seq;
    }
    CleanResults cleanResults = null;
    try {
      cleanResults = antisamy.scan(seq);
      return cleanResults.getCleanHTML();
    } catch (Exception e) {
      log.error("AntiSamy过滤xss关键字出错:", e);
    }
    return seq;
  }

  private String filter(String content, Policy policy) {
    if (antisamy != null && content != null) {
      try {
        CleanResults scanResult = antisamy.scan(content, policy, AntiSamy.SAX);
        if (scanResult != null) {
          return scanResult.getCleanHTML();
        }
      } catch (Exception e) {
        log.error("[Antisamy]scan content error,content:" + content, e);
      }
    }
    return content;
  }

}

package com.github.json;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

public abstract class JsonUtil {

  private static final Logger log = LoggerFactory.getLogger(JsonUtil.class);
  private static ObjectMapper mapper = new ObjectMapper();

  // private static JsonFactory jsonFactory = new JsonFactory();
  static {
    // 设置序列化配置，为null的属性不加入到json中
    mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
    mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

    // mapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.NONE).
    // setVisibility(PropertyAccessor.GETTER, JsonAutoDetect.Visibility.ANY).
    // setVisibility(PropertyAccessor.SETTER, JsonAutoDetect.Visibility.ANY);
  }

  private JsonUtil() {}

  public static String objectToJson(Object o) {
    try {
      return mapper.writeValueAsString(o);
    } catch (Exception e) {
      log.error("write2JsonStr, JsonUtil exception", e);
    }
    return null;
  }

  /**
   * 将json转换为对象 如果对象模版为内部类会出现问题，所以不要使用内部类
   *
   * @param json 要转换的json
   * @param clazz 要映射的类型
   * @return 转换成的目标对象，如果转换失败返回null
   */
  public static <T> T jsonToObject(String json, Class<T> clazz) {
    try {
      return mapper.readValue(json, clazz);
    } catch (Exception e) {
      log.error("json2Object, JsonUtil exception, json is:" + json, e);
    }
    return null;
  }

  /**
   * 将json字符串转换为Map
   *
   * @param json 需要转换为Map的json字符串 {}开头结尾的
   * @return 转换后的map 如果转换失败返回null
   */
  @SuppressWarnings("unchecked")
  public static Map<String, Object> json2Map(String json) {
    try {
      if (Strings.isNullOrEmpty(json)) {
        return Maps.newHashMap();
      }
      return mapper.readValue(json, Map.class);
    } catch (Exception e) {
      log.error("Parse json: {}  ", json);
      log.error("{}", e);
    }
    return Maps.newHashMap();
  }

  /**
   * 将json数组转换为List<Map<String,Object>> json数组格式[{},{}]
   *
   * @param jsonArray 需要转换的json数组
   * @return 转换后的列表 如果转换失败返回null
   */
  public static List<Map<String, Object>> jsonArray2List(String jsonArray) {
    try {
      return mapper.readValue(jsonArray, List.class);
    } catch (Exception e) {
      log.error("jsonArray2List, JsonUtil exception, json is:" + jsonArray, e);
    }
    return Lists.newArrayList();
  }

  /**
   * 将json数组转换为List<T> json数组格式[{},{}]
   *
   * @param json 需要转换的json数组
   * @return 转换后的列表 如果转换失败返回null
   */
  public static <T> List<T> json2List(String json, Class<T> elementType) {
    try {
      JavaType javaType =
          mapper.getTypeFactory().constructCollectionType(ArrayList.class, elementType);
      return mapper.readValue(json, javaType);
    } catch (Exception e) {
      log.error(
          "json2List, JsonUtil exception, json is: " + json + ", elementType is: " + elementType,
          e);
    }
    return Lists.newArrayList();
  }

}

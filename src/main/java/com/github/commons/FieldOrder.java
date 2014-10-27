package com.github.commons;

/**
 * @author xiebiao
 */
public class FieldOrder {

    public enum ORDER {
        ASC, DESC
    }

    String fieldName;
    String order;

    /**
     * 默认为升序
     *
     * @param fieldName
     */
    public FieldOrder(String fieldName) {
        this.fieldName = fieldName;
        this.order = ORDER.ASC.name();
    }

    public FieldOrder(String fieldName, ORDER order1) {
        this.fieldName = fieldName;
        this.order = order1.name();
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(ORDER order) {
        this.order = order.name();
    }
}

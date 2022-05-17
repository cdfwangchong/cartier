package com.ctg.cartier.pojo.dto.base;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.guava.GuavaModule;


import java.text.SimpleDateFormat;
import java.util.Map;

public abstract class AbstractCriteria {
    protected static final ObjectMapper MAPPER = new ObjectMapper();

    public AbstractCriteria() {
    }

    public Map<String, Object> toMap() {
        return (Map)MAPPER.convertValue(this, Map.class);
    }

    static {
        MAPPER.setSerializationInclusion(Include.NON_EMPTY);
        MAPPER.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        MAPPER.registerModule(new GuavaModule());
        MAPPER.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
    }
}

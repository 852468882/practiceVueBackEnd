package com.example.practicevue.common;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class APIRequest {
    private Map<String, String> params = new HashMap<>();
    private Map<String, String> header = new HashMap<>();

    public void addParams(String... keyValues) {
        for (int i = 0; i < keyValues.length; i += 2) {
            this.params.put(keyValues[i], keyValues[i + 1]);
        }

    }

    public void addParam(String key, String value) {
        this.params.put(key, value);
    }

    public void addHeader(String key, String value) {
        this.header.put(key, value);
    }

    public void addHeaders(String... keyValues) {
        for (int i = 0; i < keyValues.length; i += 2) {
            this.header.put(keyValues[i], keyValues[i + 1]);
        }

    }
}
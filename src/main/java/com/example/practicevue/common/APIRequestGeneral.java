package com.example.practicevue.common;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class APIRequestGeneral {
    private Map<String, Object> params = new HashMap<>();
    private Map<String, String> header = new HashMap<>();

    public void addHeaders(String... keyValues) {
        for (int i = 0; i < keyValues.length; i += 2) {
            this.header.put(keyValues[i], keyValues[i + 1]);
        }

    }

}
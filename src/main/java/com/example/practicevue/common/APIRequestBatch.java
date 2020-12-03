package com.example.practicevue.common;

import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
public class APIRequestBatch<T> {
    private List<T> params = new ArrayList<>();
    private Map<String, String> header = new HashMap<>();

    public void addHeaders(String... keyValues) {
        for (int i = 0; i < keyValues.length; i += 2) {
            this.header.put(keyValues[i], keyValues[i + 1]);
        }

    }
}
package com.example.practicevue.common;

import lombok.Data;

@Data
public class APIResponse<T>{
    private String msg;
    private Integer status;
    private T data;

    public APIResponse(String msg, Integer status, T data) {
        this.msg = msg;
        this.status = status;
        this.data = data;
    }

    public static <T> APIResponse<T> ok() {
        return new APIResponse<T>("请求成功", 200, null);
    }
    public static <T> APIResponse<T> created() {
        return new APIResponse<T>("创建成功", 201, null);
    }
    public static <T> APIResponse<T> updated() {
        return new APIResponse<T>("修改成功", 203, null);
    }
    public static <T> APIResponse<T> deleted() {
        return new APIResponse<T>("删除成功", 204, null);
    }

    public static <T> APIResponse<T> success(String msg) {
        return new APIResponse<T>(msg, 200, null);
    }

    public static <T> APIResponse<T> success(T data) {
        return new APIResponse<T>("成功", 200, data);
    }

    public static <T> APIResponse<T> success(String msg, T data) {
        return new APIResponse<T>(msg, 200, data);
    }

    public static <T> APIResponse<T> success(String msg, Integer status, T data) {
        return new APIResponse<T>(msg, status, data);
    }

    public static <T> APIResponse<T> fail() {
        return new APIResponse<T>("失败", 400, null);
    }

    public static <T> APIResponse<T> fail(String msg) {
        return new APIResponse<T>(msg, 400, null);
    }

    public static <T> APIResponse<T> fail(T data) {
        return new APIResponse<T>("失败", 400, data);
    }

    public static <T> APIResponse<T> fail(String msg, Integer status) {
        return new APIResponse<T>(msg, status, null);
    }

    public static <T> APIResponse<T> fail(String msg, T data) {
        return new APIResponse<T>(msg, 400, data);
    }

    public static <T> APIResponse<T> fail(String msg, Integer status, T data) {
        return new APIResponse<T>(msg, status, data);
    }

}
package com.basemodule.interfaces;

public interface Callback<T> {
    void success(T data);

    void fail(String err);
}

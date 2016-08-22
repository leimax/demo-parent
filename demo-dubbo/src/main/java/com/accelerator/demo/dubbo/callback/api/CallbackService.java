package com.accelerator.demo.dubbo.callback.api;

public interface CallbackService {
    
    void addListener(String key, CallbackListener listener);

}

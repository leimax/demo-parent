package com.accelerator.demo.dubbo.generic.api;

public interface IService<P, V> {

    V get(P params);

}

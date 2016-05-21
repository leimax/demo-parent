package com.accelerator.demo.javase.reference;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by 318898 on 2016/5/21.
 */
public class A {

    static Logger logger = LoggerFactory.getLogger(A.class);

    int[] a;

    public A() {
        a = new int[300000000];
    }

    @Override
    protected void finalize() throws Throwable {
        logger.info("对象A被回收！");
        super.finalize();
    }

}

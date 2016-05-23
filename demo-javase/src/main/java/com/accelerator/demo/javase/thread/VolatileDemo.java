package com.accelerator.demo.javase.thread;

public class VolatileDemo {

    private static /*volatile*/ boolean stop = false;

    /**
     *  需要使用-server模式运行
     *  jdk64位默认server模式 32位需要手动指定
     */
    public static void main(String[] args) throws Exception {
        Thread t = new Thread(new Runnable() {
            public void run() {
                int i = 0;
                while (!stop) {
                    i++;
                    //  线程中如果是用同步IO、会改变JMM内存模型
                    // System.out.println("hello");
                }
            }
        });
        t.start();
        Thread.sleep(1000);
        stop = true;
        System.out.println("Stoped Thread");
    }
}

package com.example.demo.commandpattern;

/**
 * @author hwd
 * @version 1.0
 * @since 2022/2/7
 * 命令接收人；由命令接口的实现类维护Receiver实例，并在命令执行时处理相应的任务
 */
public interface CommandReceiver {
    //命令执行者方法A
    void doSomethingA();
    //命令执行者方法B
    void doSomethingB();
}

package com.example.demo.commandpattern;

/**
 * @author hwd
 * @version 1.0
 * @since 2022/2/7
 */
public class ComandReceiverImplA implements CommandReceiver{
    @Override
    public void doSomethingA() {
        System.out.println("A");
    }

    @Override
    public void doSomethingB() {

    }
}

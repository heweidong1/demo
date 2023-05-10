package com.example.demo.commandpattern;

/**
 * @author hwd
 * @version 1.0
 * @since 2022/2/7
 */
public class CommandA implements Command {
    @Override
    public void execute(CommandReceiver receiver) {
        receiver.doSomethingA();
    }
}

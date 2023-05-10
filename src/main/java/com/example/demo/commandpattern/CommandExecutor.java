package com.example.demo.commandpattern;

/**
 * @author hwd
 * @version 1.0
 * @since 2022/2/7
 * 命令执行者
 */
public class CommandExecutor {
    public void execute(Command command) {
        //创建命令执行者可以使用其他设计模式
        command.execute(new ComandReceiverImplA());
    }
}

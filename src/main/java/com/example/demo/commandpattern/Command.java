package com.example.demo.commandpattern;

/**
 * @author hwd
 * @version 1.0
 * @since 2022/2/7
 * 声明执行操作的接口
 */
public interface Command {

    /**
     * 执行命令，参数为命令接收人
     * @param receiver
     */
    void execute(CommandReceiver receiver);
}

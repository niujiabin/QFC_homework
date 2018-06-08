package qfchomework.command;

import com.google.common.base.CharMatcher;
import com.google.common.base.Preconditions;

/**
 * 解析某一个命令
 * Created by yaphetsBin on 2018-06-04.
 */
public class CommandParser {
    /**
     *
     * @param commandString
     * @return
     */
    public Command parse(String commandString) {
        /**
         * 获取命令信息
         */
        String commandStrs = CharMatcher.whitespace().trimAndCollapseFrom(commandString,' ');
        /**
         * 检查命令
         */
        checkCommand(commandStrs);

        return null;
    }

    /**
     * 检查指令是否正确
     * @param commandStrs
     */
    private void checkCommand(String commandStrs) {

        String splits[] = commandStrs.split(" ");

        String commandName = splits[0];//获取指令名称

        checkCommandName(commandName);

    }

    private void checkCommandName(String commandName) {
        //Preconditions.checkState();
    }

}

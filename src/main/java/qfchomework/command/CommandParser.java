package qfchomework.command;

import com.google.common.base.CharMatcher;
import com.google.common.base.Preconditions;

import java.util.Map;

/**
 * 解析某一个命令
 * Created by yaphetsBin on 2018-06-04.
 */
public class CommandParser {

    private Map<String, Command> commandMap;//指令集

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
        Command command = checkAndObtainCommand(commandStrs);
        /**
         * 命令解析
         */
        doParse(command);
        return null;
    }

    /**
     * 处理指令
     *
     * @param command
     */
    private void doParse(Command command) {

        //不同命令处理不同

    }

    /**
     * 检查指令是否正确
     * @param commandStrs
     */
    private Command checkAndObtainCommand(String commandStrs) {

        String splits[] = commandStrs.split(" ");

        String commandName = splits[0];//获取指令名称

        checkCommandName(commandName);

        return null;

    }

    private void checkCommandName(String commandName) {
        //Preconditions.checkState();
    }


    public Map<String, Command> getCommandMap() {
        return commandMap;
    }

    public void setCommandMap(Map<String, Command> commandMap) {
        this.commandMap = commandMap;
    }
}

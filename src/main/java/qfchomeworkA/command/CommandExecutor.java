package qfchomeworkA.command;

/**
 * 执行命令
 * Created by yaphetsBin on 2018-06-07.
 */
public class CommandExecutor {

    /**
     * 解析命令
     */
    public CommandParser commandParser = new CommandParser();

    /**
     *  执行的命令
     */
    public Command command ;


    public void executeCommand(String commandString) {

        command = commandParser.parse(commandString);


    }
}

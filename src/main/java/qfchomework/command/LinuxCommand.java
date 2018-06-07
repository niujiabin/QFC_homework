package qfchomework.command;

/**
 * Created by yaphetsBin on 2018-06-04.
 */
public class LinuxCommand {

    public CommandExecutor commandExecutor = new CommandExecutor();

    /**
     * 执行某一个命令
     * @param commandString
     */
    public void doLinuxCommand(String commandString){
        commandExecutor.executeCommand(commandString);
    }
}

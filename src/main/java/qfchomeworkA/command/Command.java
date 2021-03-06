package qfchomeworkA.command;

import java.util.List;

/**
 * 一个命令包括命令名称、命令参数和命令内容
 * 分别由类
 * CommandName、CommandParameter、CommmandContent承担
 * Created by yaphetsBin on 2018-06-04.
 */
public class Command {

    /**
     * 命令名称
     */
    private CommandName commandName;

    /**
     * 指令参数
     */
    private List<CommandParameter> commandParameter;

    /**
     * 指令内容
     */
    private CommandContent commandContent;


    public void init(){

    }

    public CommandContent getCommandContent() {
        return commandContent;
    }

    public void setCommandContent(CommandContent commandContent) {
        this.commandContent = commandContent;
    }




    public CommandName getCommandName() {
        return commandName;
    }

    public void setCommandName(CommandName commandName) {
        this.commandName = commandName;
    }

    public List<CommandParameter> getCommandParameter() {
        return commandParameter;
    }

    public void setCommandParameter(List<CommandParameter> commandParameter) {
        this.commandParameter = commandParameter;
    }
}

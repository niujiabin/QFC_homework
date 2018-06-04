package qfchomework.command;

/**
 * Created by yaphetsBin on 2018-06-04.
 */
public abstract class AbstractCommander {

    /**
     * 初始化命令
     */
    public abstract void initCommand();

    /**
     * 获取指令
     * @return
     */
    public abstract Command getCommand();

    /**
     * 获取指令参数
     * @return
     */
    public  CommandParameter getCommandParameter(){
         return getCommand().getCommandParameter();
    }

    /**
     * 获取指令内容
     * @return
     */
    public  CommandContent getCommandContent(){
        return getCommand().getCommandContent();
    }

}

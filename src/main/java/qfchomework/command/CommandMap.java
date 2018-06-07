package qfchomework.command;

import java.util.HashMap;

/**
 * 常用指令
 * Created by yaphetsBin on 2018-06-07.
 */
public class CommandMap {

    /**
     * 保存所有指令信息
     */
    public static HashMap<String,Command> commandMap = new HashMap<String, Command>();

    static {
        initProp();
    }

    /**
     * 初始化加载linux命令
     */
    private static void initProp() {

    }
}

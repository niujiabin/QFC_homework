package qfchomeworkA.command;

/**
 * 指令参数
 * Created by yaphetsBin on 2018-06-04.
 */
public class CommandParameter {

    private String name;

    private String value;

    private String combineValue;

    private CommandContent content;

    public String getCombineValue() {
        return combineValue;
    }

    public void setCombineValue(String combineValue) {
        this.combineValue = combineValue;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public CommandContent getContent() {
        return content;
    }

    public void setContent(CommandContent content) {
        this.content = content;
    }
}

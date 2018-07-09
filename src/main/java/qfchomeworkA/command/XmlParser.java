package qfchomeworkA.command;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;


import java.io.File;
import java.util.*;

/**
 * 解析xml配置文件
 * Created by yaphetsBin on 2018-06-14.
 */
public class XmlParser {

    public static String fileName = "linux_command.xml";

    public Map<String, Command> commandMap = new HashMap<String, Command>();//存储指令信息

    /**
     * 加载xml文件
     *
     * @param filename
     * @return
     */
    public Document load(String filename) {

        Document document = null;
        try {
            SAXReader saxReader = new SAXReader();
            document = saxReader.read(new File(this.getClass().getClassLoader().getResource(fileName).getPath())); // 读取XML文件,获得document对象
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return document;
    }

    public void parseDocument(Document document) {
        Element root = document.getRootElement();//Command
        Attribute attribute = root.attribute("id");
        String attributeText = attribute.getText();
        if (attribute.equals("linuxCommand")) {
            //所有指令
            List<Element> list = root.elements();
            for (Element element : list) {
                Command command = parseElement(element);
                commandMap.put(command.getCommandName().getName(), command);
            }
        }
    }

    /**
     * 解析指令元素
     *
     * @param element
     */
    private Command parseElement(Element element) {
        Command command = CommandFactory.createCommand();
        String commandName = element.getName();
        Element paramsElement = element.element("params");
        Attribute prefixAttr = paramsElement.attribute("prefix");
        String prefixStr = prefixAttr.getText();//参数前缀
        List<CommandParameter> params = new ArrayList<CommandParameter>();
        /**
         * 所有参数信息
         */
        List<Element> paramsElements = paramsElement.elements();
        for (Element para : paramsElements) {
            CommandParameter cp = new CommandParameter();//指令参数
            String pName = para.attribute("name").getValue();
            String pValue = para.attribute("value").getValue();
            String combineValue = para.attribute("combinesValue") == null ? "" : para.attribute("combinesValue").getValue();
            cp.setName(pName);
            cp.setValue(pValue);
            cp.setCombineValue(combineValue);
            //指令描述信息
            cp.setContent(new CommandContent(para.element("description").getText()));
            params.add(cp);
        }
        command.setCommandName(new CommandName(commandName));//指令名称
        command.setCommandParameter(params);//指令参数
        return command;
    }
}

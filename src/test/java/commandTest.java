import com.google.common.base.CharMatcher;
import com.google.common.base.Charsets;
import com.google.common.io.Files;
import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.Test;
import qfchomeworkA.command.CounterLine;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * 主要用于测试
 * Created by yaphetsBin on 2018-06-05.
 */
public class commandTest {


    public static void main(String[] args) throws IOException {



    }

    @Test
    public void linuxCommandTest() throws IOException {

        String testFilePath = "D://test.txt";
        File testFile = new File(testFilePath);
        CounterLine counter = new CounterLine();
        Integer readLines = Files.asCharSource(testFile,Charsets.UTF_8).readLines(counter);
        System.out.println(counter.getResult());

    }

    @Test
    public void whitespaceTest(){

        String x = CharMatcher.whitespace().trimAndCollapseFrom("cat  test.text",'1');
        System.out.println(x.split(" ")[0]);
    }

    @Test
    public void getProp() {
        Document document = null;
        try {
            SAXReader saxReader = new SAXReader();
            document = saxReader.read(new File(this.getClass().getClassLoader().getResource("linux_command.xml").getPath())); // 读取XML文件,获得document对象

            Element root = document.getRootElement();//Command
            Attribute attribute = root.attribute("id");
            String attributeText = attribute.getText();
            System.out.println(attributeText);

            if (attributeText.equals("linuxCommand")) {

                //遍历所有指令
                List<Element> list = root.elements();
                for (Element element : list) {

                    String commandName = element.getName();
                    Element paramsElement = element.element("params");

                    System.out.println(paramsElement.attribute("pr1efix").getStringValue());
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
}

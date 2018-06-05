import com.google.common.base.Charsets;
import com.google.common.io.Files;
import org.junit.Test;
import qfchomework.command.CounterLine;

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
}

package qfchomeworkC.questionA;

import com.google.common.base.Charsets;
import com.google.common.io.Files;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * 统计StringUtils有效代码行数
 */
public class Main {
    public static void main(String[] args) throws IOException {
        File testFile = new File(Thread.currentThread().getContextClassLoader().getResource("StringUtils.java").getPath());
        List<String> lines = Files.readLines(testFile, Charsets.UTF_16);
        for (String line : lines) {
            System.out.println(line);
        }
    }
}

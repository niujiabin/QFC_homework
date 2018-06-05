package qfchomework.command;

import com.google.common.io.LineProcessor;

import java.io.IOException;

/**
 * Created by yaphetsBin on 2018-06-05.
 */
public class CounterLine implements LineProcessor<Integer> {


    /**
     * 记录文件行号
     */
    private int rowNumber = 0;

    /**
     * 获取每一行的字符串
     * @param s
     * @return
     * @throws IOException
     */
    public boolean processLine(String s) throws IOException {
        System.out.println(s);
        rowNumber++;
        return true;
    }

    /**
     * 获取最终的结果行数
     * @return
     */
    public Integer getResult() {
        return rowNumber;
    }
}

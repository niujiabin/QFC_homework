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
        List<String> lines = Files.readLines(testFile, Charsets.UTF_8);
        int count =0 ;
        boolean flag = false;//是否进入注释
        for (String line : lines) {
            String strline = line.replace(" ","").trim();
            int length = strline.length();
            //空行
            if (strline.equals("")){
                continue;
            }
            //js注释 //
            else if (length>1 && strline.charAt(0)=='/' && strline.charAt(1)=='/'){
                continue;
            }
            //js 进入多行注释
            else if (length>1 && strline.charAt(0)=='/' && strline.charAt(1)=='*'){
                //进入注释区域
                flag = true;

            }
            //多行注释结束标志
            if (length>1 && strline.charAt(length-1)=='/' && strline.charAt(length-2)=='*'){
                flag = false;
                continue;
            }
            //html注释
            if (length >2 && strline.charAt(0)=='<' && strline.charAt(1)=='!' && strline.charAt(2)=='-' && strline.charAt(3)=='-'){
                flag = true;
            }
            //html多行注释结束
            if (length >2 && strline.charAt(length-1)=='>' && strline.charAt(length-2)=='-' && strline.charAt(length-3)=='-'){
                flag = false;
                continue;
            }
            //有效行数
            if(!flag){
                count++;
                System.out.println(strline);
            }
        }
        File newFile = new File(Thread.currentThread().getContextClassLoader().getResource("validLineCount.txt").getPath());
        Files.write(String.valueOf(count).getBytes(), newFile);

    }
}

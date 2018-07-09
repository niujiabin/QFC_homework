package qfchomeworkA.console;

import javax.swing.*;

/**
 * 控制台终端 用于命令输入
 */
public class ConsoleTerminal {
    public static void main(String[] args) {

        //1.创建一个顶层容器
        JFrame jf = new JFrame("测试窗口");
        jf.setSize(600,600);
        jf.setLayout(null);
        jf.setLocationRelativeTo(null);//把窗口位置设置到屏幕中心
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);//点击窗口关闭按钮 退出程序

        JTextArea jTextArea = new JTextArea();

        //绑定输入事件

        JScrollPane  jsp= new JScrollPane(jTextArea);
        jsp.setBounds(13,10,565,540);
        jsp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        jf.add(jsp);
        jf.setVisible(true);
    }
}

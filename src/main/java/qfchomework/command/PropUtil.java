package qfchomework.command;

import com.google.common.base.Utf8;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sun.nio.cs.StandardCharsets;
import sun.nio.cs.UTF_32;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;
import java.util.regex.Pattern;

/**
 * 加载配置文件
 * Created by yaphetsBin on 2018-06-08.
 */
public class PropUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(PropUtil.class.getName());
    private static final String REGEX_PROPERTIES = "^(.*).xml%";
    private static final Pattern PATTERN_PROPERTIES = Pattern.compile(REGEX_PROPERTIES);
    private static Properties properties = new Properties();
    private static ClassLoader classLoader = getDefaultClassLoader();

    static {
        init();
    }

    /**
     * 初始化配置文件
     */
    private static void init() {

        String classpath = getClassPath();

        if (classpath != null) {
            File baseDir = new File(classpath).getParentFile();
            loadDir(baseDir);
        }

    }

    /**
     * 获取classpath
     *
     * @return
     */
    private static String getClassPath() {
        String classpath = null;
        try {
            classpath = classLoader.getResource("/").getPath();
        } catch (Exception ex) {
            try {
                classpath = classLoader.getResource("").getPath();
            } catch (Exception e) {
                LOGGER.error("classpath 初始化失败：", e);
            }
        }
        return classpath;
    }

    private static Properties getProperties() {
        return properties;
    }

    /**
     * copy from org.springframework.util.ClassUtils
     * 加载默认的类加载器
     *
     * @return
     */
    private static ClassLoader getDefaultClassLoader() {
        ClassLoader cl = null;
        try {
            cl = Thread.currentThread().getContextClassLoader();
        } catch (Exception ex) {
            LOGGER.error("Thread.current()获取ClassLoader出错", ex);
        }
        if (cl == null) {
            cl = PropUtil.class.getClassLoader();
            if (cl == null) {
                try {
                    cl = ClassLoader.getSystemClassLoader();
                } catch (Exception ex) {
                    LOGGER.error("ClassLoader.getSystemClassLoader()获取ClassLoader出错：", ex);
                }
            }
        }
        return cl;
    }

    /**
     * 加载配置文件
     *
     * @param baseDir
     */
    private static void loadDir(File baseDir) {

        if (!baseDir.exists() || !baseDir.isDirectory()) {
            return;
        }
        String tempPath;
        File[] files = baseDir.listFiles();
        for (File file : files) {
            tempPath = file.getAbsolutePath();
            if (PATTERN_PROPERTIES.matcher(tempPath).matches()) {
                load(file);
            } else if (file.isDirectory()) {
                loadDir(file);
            }
        }
    }

    /**
     * 读取配置文件
     *
     * @param file
     */
    private static void load(File file) {
        try {
            InputStream is = new FileInputStream(file);
            InputStreamReader isr = new InputStreamReader(is);
            getProperties().load(isr);
        } catch (Exception ex) {
            throw new RuntimeException("读取配置文件" + file.getName() + "出现异常", ex);
        }
    }


}

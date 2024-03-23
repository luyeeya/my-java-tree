package properties;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 读取 *.properties 文件
 */
public class ReadPropertiesFile {
    public static void main(String[] args) {
        Properties properties = new Properties();
        try (InputStream propertiesStream = ReadPropertiesFile.class.getClassLoader().getResourceAsStream("config.properties")) { // 打开 *.properties 文件流
            properties.load(propertiesStream); // 从流中读取文件内容到 properties 对象中
            System.out.printf("name: %s%n", properties.getProperty("name"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

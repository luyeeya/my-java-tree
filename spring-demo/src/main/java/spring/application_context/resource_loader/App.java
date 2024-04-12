package spring.application_context.resource_loader;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.io.Resource;

import java.io.IOException;

/**
 * 展示 ApplicationContext 获取多种资源的能力（ResourcePatternResolver -> ResourceLoader）
 */
public class App {
    public static void main(String[] args) throws IOException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        // URI
        Resource uriResource = context.getResource("https://www.baidu.com");
        System.out.println("resource: " + uriResource.getURL() + ", contentLength: " + uriResource.contentLength());

        // File
        Resource fileResource = context.getResource("file://D:\\projects\\my-java-tree\\spring-demo\\src\\main\\java\\spring\\ioc\\resource\\App.java");
        System.out.println("resource: " + fileResource.getFilename() + ", contentLength: " + fileResource.contentLength());

        // ClassPath
        Resource classpathResource = context.getResource("classpath:application.properties");
        System.out.println("resource: " + classpathResource.getFilename() + ", contentLength: " + classpathResource.contentLength());

        // 多个资源
        Resource[] resources = context.getResources("classpath:messages_*");
        for (Resource resource : resources) {
            System.out.println("resource: " + resource.getFilename() + ", contentLength: " + resource.contentLength());
        }
    }
}

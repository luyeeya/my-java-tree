package spring.metadata_reader;

import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.ClassMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.SimpleMetadataReaderFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.IOException;


/**
 * 类的元数据读取器 MetadataReader
 */
public class App {
    public static void main(String[] args) throws IOException {
        SimpleMetadataReaderFactory metadataReaderFactory = new SimpleMetadataReaderFactory();
        // 获取元数据读取器
        MetadataReader metadataReader = metadataReaderFactory.getMetadataReader("spring.metadata_reader.UserService");
        // 类的元数据
        ClassMetadata classMetadata = metadataReader.getClassMetadata();
        System.out.println("className = " + classMetadata.getClassName());
        // 类的注解元数据
        AnnotationMetadata annotationMetadata = metadataReader.getAnnotationMetadata();
        System.out.println(annotationMetadata.hasAnnotation(Service.class.getName())); // UserService 上有 @Service 注解：true
        System.out.println(annotationMetadata.hasAnnotation(Component.class.getName())); // UserService 上有 @Service 注解：false
        System.out.println(annotationMetadata.hasMetaAnnotation(Service.class.getName())); // UserService 上有 @Service 元注解：false
        System.out.println(annotationMetadata.hasMetaAnnotation(Component.class.getName())); // UserService 上有 @Component 元注解：true
    }
}

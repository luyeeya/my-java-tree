package spring.type_convert.property_editor;

import org.springframework.beans.factory.config.CustomEditorConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import java.beans.PropertyEditor;
import java.util.HashMap;
import java.util.Map;

@ComponentScan("spring.type_convert.property_editor")
public class AppConfig {

    @Bean
    public CustomEditorConfigurer customEditorConfigurer() {
        CustomEditorConfigurer editorConfigurer = new CustomEditorConfigurer();
        Map<Class<?>, Class<? extends PropertyEditor>> propertyEditorMap = new HashMap<>();
        // Spring 遇到 String 转换成 User 类的情况时，会使用 String2UserPropertyEditor 类
        propertyEditorMap.put(User.class, String2UserPropertyEditor.class);
        editorConfigurer.setCustomEditors(propertyEditorMap);
        return editorConfigurer;
    }

}

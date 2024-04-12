package spring.type_convert.type_converter;

import org.springframework.beans.SimpleTypeConverter;
import org.springframework.beans.TypeConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.support.DefaultConversionService;

@ComponentScan("spring.type_convert.type_converter")
@Configuration
public class AppConfig {

    @Bean
    public TypeConverter typeConverter() {
        SimpleTypeConverter typeConverter = new SimpleTypeConverter();
        DefaultConversionService conversionService = new DefaultConversionService();
        conversionService.addConverter(new Integer2UserConverter());
        // 设置 ConversionService 类型转换器
        typeConverter.setConversionService(conversionService);
        // 设置 PropertyEditor 类型转换器
        typeConverter.registerCustomEditor(User.class, new String2UserPropertyEditor());
        return typeConverter;
    }

}

package spring.type_convert.conversion_service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ConversionServiceFactoryBean;

import java.util.Collections;

@ComponentScan("spring.type_convert.conversion_service")
public class AppConfig {

    /**
     * 注册 ConversionService 的工厂 Bean
     */
    @Bean
    public ConversionServiceFactoryBean conversionService() {
        ConversionServiceFactoryBean conversionServiceFactoryBean = new ConversionServiceFactoryBean();
        conversionServiceFactoryBean.setConverters(Collections.singleton(new String2UserConverter()));
        return conversionServiceFactoryBean;
    }

}

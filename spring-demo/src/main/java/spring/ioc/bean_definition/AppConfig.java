package spring.ioc.bean_definition;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

@ComponentScan(
        basePackages = "spring.ioc.bean_definition",
        excludeFilters = {@ComponentScan.Filter(type = FilterType.REGEX, pattern = "spring.ioc.beandefinition.scan.*")}
)
public class AppConfig {
}

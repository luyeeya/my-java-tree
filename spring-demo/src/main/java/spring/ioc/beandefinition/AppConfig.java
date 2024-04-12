package spring.ioc.beandefinition;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

@ComponentScan(
        basePackages = "spring.ioc.beandefinition",
        excludeFilters = {@ComponentScan.Filter(type = FilterType.REGEX, pattern = "spring.ioc.beandefinition.scan.*")}
)
public class AppConfig {
}

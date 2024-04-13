package spring.ioc.include_exclude_filter;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Service;

@ComponentScan(
        value = "spring.ioc.include_exclude_filter",
        includeFilters = {
                @ComponentScan.Filter(
                        type = FilterType.ASSIGNABLE_TYPE,
                        classes = UserService.class
                )
        },
        excludeFilters = {
                @ComponentScan.Filter(
                        type = FilterType.ANNOTATION,
                        value = Service.class
                )
        }
)
public class AppConfig {
}

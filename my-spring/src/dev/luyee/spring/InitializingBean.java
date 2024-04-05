package dev.luyee.spring;

/**
 * 单个 Bean 处理
 */
public interface InitializingBean {
    void afterPropertiesSet();
}

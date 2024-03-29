package org.chobit.mocko.autoconfigure;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Role;
import org.springframework.core.Ordered;

/**
 * 自启动配置
 *
 * @author rui.zhang
 */
@EnableConfigurationProperties(MockoProperties.class)
@ConditionalOnProperty(name = "mocko.enabled", matchIfMissing = true)
@Configuration(proxyBeanMethods = false)
@Role(BeanDefinition.ROLE_INFRASTRUCTURE)
public class MockoAutoConfiguration {


    @Value("${spring.application.name}")
    private String appName;


    @Bean
    @Role(BeanDefinition.ROLE_INFRASTRUCTURE)
    public MockoPointcutSourceAdvisor mockoPointAdvisor() {
        MockoPointcutSourceAdvisor advisor = new MockoPointcutSourceAdvisor();
        advisor.setAdvice(new MockoInterceptor());
        advisor.setOrder(Ordered.HIGHEST_PRECEDENCE);
        return advisor;
    }
}

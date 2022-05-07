package gt1000.config;

import gt1000.filter.JwtAuthorizationFilter;
import gt1000.filter.MyFilter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
public class FilterConfig {

//    @Bean
//    public FilterRegistrationBean<MyFilter> filer() {
//        log.info("----------------- myfilter -------------");
//        FilterRegistrationBean<MyFilter> bean = new FilterRegistrationBean<>(new MyFilter());
//        bean.addUrlPatterns("/*");
//        return bean;
//    }

    @Bean
    public FilterRegistrationBean<JwtAuthorizationFilter> jwtAuthorizationFilter() {
        log.info("----------------- jwtAuthorizationFilter -------------");
        FilterRegistrationBean<JwtAuthorizationFilter> bean = new FilterRegistrationBean<>(new JwtAuthorizationFilter());
        bean.addUrlPatterns("/*");
        return bean;
    }
}

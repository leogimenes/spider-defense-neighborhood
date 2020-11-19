package spiderdefenseneighborhood.sdnweb.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import spiderdefenseneighborhood.sdnweb.interceptor.LoggingController;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoggingController()).addPathPatterns("/**").excludePathPatterns("/", "/index", "/assets/**", "/webjars/**", "/bootstrap/**", "/novoNumero");
    }
}
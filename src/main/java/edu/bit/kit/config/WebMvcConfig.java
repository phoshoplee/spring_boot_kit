package edu.bit.kit.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

// 정적 자원을 제공하는 클래스
@Configuration
public class WebMvcConfig implements WebMvcConfigurer{
    

    private static final String[] CLASSPATH_RESOURCE_LOCATIONS = {"classpath:/static/",
            "classpath:/public/","classpath:/","classpath:/resources/","classpath:/META-INF/resources/",
            "classpath:/META-INF/resources/webjars/"};
    
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        // path(/)에 해당하는 url mapping 을 kit로 forward
        registry.addViewController("/").setViewName("forward:/index");
        
        // 우선순위를 높게 잡음
        registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
    }
    
    
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**").addResourceLocations(CLASSPATH_RESOURCE_LOCATIONS);
    }
    
    

}

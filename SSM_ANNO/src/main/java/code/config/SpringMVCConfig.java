package code.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

@Configuration
@ComponentScan({"code.controller"})
@EnableWebMvc
public class SpringMVCConfig {
//    @Override
//    protected void addInterceptors(InterceptorRegistry registry) {
//        super.addInterceptors(registry);
//    }
//
//    @Override
//    protected void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
//        super.configureDefaultServletHandling(configurer);
//    }
//
//    @Override
//    protected void configureViewResolvers(ViewResolverRegistry registry) {
//        super.configureViewResolvers(registry);
//    }
}

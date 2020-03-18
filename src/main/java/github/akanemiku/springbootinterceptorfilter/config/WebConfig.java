package github.akanemiku.springbootinterceptorfilter.config;

import github.akanemiku.springbootinterceptorfilter.interceptor.AdminInterceptor;
import github.akanemiku.springbootinterceptorfilter.interceptor.LogInterceptor;
import github.akanemiku.springbootinterceptorfilter.interceptor.OldLoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 对所有url进行拦截
        registry.addInterceptor(new LogInterceptor());

        // Old Login url, no longer use.
        // Use OldURLInterceptor to redirect to a new URL.
        registry.addInterceptor(new OldLoginInterceptor())
                .addPathPatterns("/admin/oldLogin");//设定拦截的url

        // This interceptor apply to URL like /admin/*
        // Exclude /admin/oldLogin
        registry.addInterceptor(new AdminInterceptor())
                .addPathPatterns("/admin/*")//设定拦截的url
                .excludePathPatterns("/admin/oldLogin");//排除拦截的url
    }
}

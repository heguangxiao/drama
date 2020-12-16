/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.htcjsc.web.drama.config;

import java.util.concurrent.TimeUnit;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.CacheControl;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import vn.htcjsc.web.drama.interceptor.AdminInterceptor;
import vn.htcjsc.web.drama.interceptor.LogInterceptor;
import vn.htcjsc.web.drama.interceptor.OldLoginInterceptor;
import vn.htcjsc.web.drama.interceptor.UrlLocaleInterceptor;

/**
 *
 * @author HTC-PC
 */
@Configuration
@EnableWebMvc
public class MyConfig extends WebMvcConfigurerAdapter{
     
    // Cấu hình để sử dụng các file nguồn tĩnh (html, image, ..)
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/css/**").addResourceLocations("/resources/css/").setCacheControl(CacheControl.maxAge(1, TimeUnit.SECONDS).cachePublic());
        registry.addResourceHandler("/images/**").addResourceLocations("/resources/images/").setCacheControl(CacheControl.maxAge(1, TimeUnit.SECONDS).cachePublic());
        registry.addResourceHandler("/img/**").addResourceLocations("/resources/img/").setCacheControl(CacheControl.maxAge(1, TimeUnit.SECONDS).cachePublic());
        registry.addResourceHandler("/js/**").addResourceLocations("/resources/js/").setCacheControl(CacheControl.maxAge(1, TimeUnit.SECONDS).cachePublic());
        registry.addResourceHandler("/controller/**").addResourceLocations("/resources/controller/").setCacheControl(CacheControl.maxAge(1, TimeUnit.SECONDS).cachePublic());
    }
     
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }
 
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        
        UrlLocaleInterceptor localeInterceptor = new UrlLocaleInterceptor();
 
        registry.addInterceptor(localeInterceptor).addPathPatterns("/en/*", "/fr/*", "/vi/*");

//        LocaleChangeInterceptor localeInterceptor = new LocaleChangeInterceptor();
//        localeInterceptor.setParamName("lang");
//
//        registry.addInterceptor(localeInterceptor).addPathPatterns("/*");
        
        // LogInterceptor áp dụng cho mọi URL.
        registry.addInterceptor(new LogInterceptor());

        // Đường dẫn login cũ, không còn sử dụng nữa.
        // Sử dụng OldURLInterceptor để điều hướng tới một URL mới.
        registry.addInterceptor(new OldLoginInterceptor())//
                .addPathPatterns("/admin/oldLogin");

        // Interceptor này áp dụng cho các URL có dạng /admin/*
        // Loại đi trường hợp /admin/oldLogin
        registry.addInterceptor(new AdminInterceptor())//
                .addPathPatterns("/admin/*")//
                .excludePathPatterns("/admin/oldLogin");
        
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.htcjsc.web.drama.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.UrlBasedViewResolver;
import org.springframework.web.servlet.view.tiles3.TilesView;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import vn.htcjsc.web.drama.interceptor.UrlLocaleResolver;

/**
 *
 * @author HTC-PC
 */
@Configuration
@ComponentScan("vn.htcjsc.web.drama.*") 
public class MyContext {
//    @Bean(name = "viewResolver")
//    public InternalResourceViewResolver getViewResolver() {
//        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
//        viewResolver.setPrefix("/WEB-INF/pages/");
//        viewResolver.setSuffix(".jsp");
//        return viewResolver;
//    }

    @Bean(name = "viewResolver")
    public ViewResolver getViewResolver() {
        UrlBasedViewResolver viewResolver = new UrlBasedViewResolver();
 
        // TilesView 3
        viewResolver.setViewClass(TilesView.class);
 
        return viewResolver;
    }
 
    @Bean(name = "tilesConfigurer")
    public TilesConfigurer getTilesConfigurer() {
        TilesConfigurer tilesConfigurer = new TilesConfigurer();
 
        // TilesView 3
        tilesConfigurer.setDefinitions("/tiles/tiles.xml");
 
        return tilesConfigurer;
    }
    
    @Bean(name = "messageSource")
    public MessageSource getMessageResource()  {
        ReloadableResourceBundleMessageSource messageResource= new ReloadableResourceBundleMessageSource();

        // Đọc vào file i18n/messages_xxx.properties
        // Ví dụ: i18n/message_en.properties
        messageResource.setBasename("classpath:i18n/messages");
        messageResource.setDefaultEncoding("UTF-8");
        return messageResource;
    }
    
    @Bean(name = "localeResolver")
    public LocaleResolver getLocaleResolver()  {
        LocaleResolver resolver= new UrlLocaleResolver();
//        CookieLocaleResolver resolver= new CookieLocaleResolver();
//        resolver.setCookieDomain("myLocaleCookie");
//        // 60 phút.
//        resolver.setCookieMaxAge(60*60);
        return resolver;
    }
    
    @Bean(name = "multipartResolver")
    public MultipartResolver getMultipartResolver() {
        CommonsMultipartResolver resover = new CommonsMultipartResolver();
        // 10MB
        resover.setMaxUploadSize(10 * 1024 * 1024); 
        return resover;
    }
}

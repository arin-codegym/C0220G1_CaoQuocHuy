package com.rin.config;

import com.rin.service.CustomerService;
import com.rin.service.ProvinceService;
import com.rin.service.impl.CustomerServiceImpl;
import com.rin.service.impl.ProvinceServiceImpl;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import java.util.Locale;

@Configuration


public class WebMvcConfig implements WebMvcConfigurer  {
    //Khai báo cấu hình bean messageSource, ở đây là mã mẫu khi khai báo bằng annotation trong file cấu hình bằng java.
    //Trong đó, giá trị "message" chính là tên file trong file message.properties.
    @Bean
    public MessageSource messageSource() {
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasename("langue");
      //  messageSource.setBasename("classpath:i18n/langue");
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }
    /*
     bean localeResolver để sử dụng thông tin về bản địa và sử dụng message bundle tương ứng
     Ở đây, ta đã khai báo một localeResolver lấy thông tin về bản địa từ session của người dùng, đồng thời dự phòng sử dụng ngôn ngữ là “en”.
     Bước tiếp theo, trong template, tạo một thẻ anchor đơn giản để gửi request với tham số “lang”
     */
    @Bean
    public LocaleResolver localeResolver() {
        SessionLocaleResolver localeResolver = new SessionLocaleResolver();
       localeResolver.setDefaultLocale(new Locale("en"));
//        localeResolver.setLocaleAttributeName("myAppLocaleSession");
//        localeResolver.setDefaultLocale(Locale.ENGLISH);
        return localeResolver;
    }

//    @Bean(name = "messageSource")
//    public MessageSource getMessageResource()  {
//        ReloadableResourceBundleMessageSource messageResource= new ReloadableResourceBundleMessageSource();
//
//        // Đọc vào file i18n/messages_xxx.properties
//        // Ví dụ: i18n/messages_en.properties
//        messageResource.setBasename("classpath:i18n/langue");
//        messageResource.setDefaultEncoding("UTF-8");
//        return messageResource;
//    }
    //Interceptor này sẽ tự động phân tích tham số lang đi kèm các request để xác định bản địa hiện tại.
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        LocaleChangeInterceptor interceptor = new LocaleChangeInterceptor();
        interceptor.setParamName("lang");
        registry.addInterceptor(interceptor);
    }
    @Bean
    public CustomerService customerService(){
        return new CustomerServiceImpl();
    }

    @Bean
    public ProvinceService provinceService(){
        return new ProvinceServiceImpl();
    }
}

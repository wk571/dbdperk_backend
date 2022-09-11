package com.dbd;

import com.dbd.jwt.JwtAuthenticationFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@EnableEurekaClient
@SpringBootApplication
@EnableFeignClients(basePackages = "com.dbd.client")
public class DBDApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder){
        return builder.sources(DBDApplication.class);
    }

    @Bean
    public FilterRegistrationBean jwtFilter(){
        final FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        //Spring 提供的用来注册filter的类
        JwtAuthenticationFilter filter = new JwtAuthenticationFilter();
        //实例化我们创建的filter类
        registrationBean.setFilter(filter);
        //创建的filter类注册到registrationBean中
        return registrationBean;
        //通过@Bean注解将registrationBean放入Spring容器中
    }

    public static void main(String[] args) {
        SpringApplication.run(DBDApplication.class, args);
    }
}

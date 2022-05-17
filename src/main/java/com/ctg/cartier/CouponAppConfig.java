package com.ctg.cartier;


import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by IntelliJ IDEA.
 *
 * @author : huangdewei
 * Date: 20200527
 * To change this template use File | Settings | File Templates.
 */
@Configuration
@EnableSwagger2
//@EnableAutoConfiguration
public class CouponAppConfig implements WebMvcConfigurer {



//
//    @Resource
//    private CouponAppInterceptor couponAppInterceptor;
//
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(couponAppInterceptor);
//    }



    @Bean
    public Docket createRestApi() {
        //添加header参数
        ParameterBuilder ticketPar = new ParameterBuilder();

        ticketPar.name ("token").description ("user token")
                .modelRef (new ModelRef("string")).parameterType ("header")
                .required (false);
        List<Parameter> pars = new ArrayList();
        pars.add (ticketPar.build ());
        return new Docket(DocumentationType.SWAGGER_2)
                .globalOperationParameters (pars)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.any ())
                .paths(PathSelectors.any())
                .build();
    }


    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("优惠券 RestFul APIs")
                .description("集成Swagger2构建RestFul APIs")
                .version("1.0.0")
                .build();
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }



}

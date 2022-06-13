package org.ldh.web.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @description: Swagger2配置类
 * @author: WhiteCrowZHZ
 * @date: 2022/2/16 7:52
 */

@Configuration
@EnableSwagger2
public class Swagger2 {

    /**
     * 配置swagger2核心配置
     * @return
     */
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2) // 指定api类型为swagger2
                .apiInfo(apiInfo()) // 定义api文档汇总信息
                .select().apis(RequestHandlerSelectors.basePackage("org.ldh.web.controller")) // 指定需要提供文档的Controller类所在的包
                .paths(PathSelectors.any()) // 需要生成文档的接口路径
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("ldh-demo标题")
                .contact(new Contact(
                        "ldh-web-demo",
                        "http://example.com",
                        "574427343@qq.com"))
                .description("ldh-web api 接口描述信息")
                .version("1.0.1")
                .termsOfServiceUrl("http://example.com")
                .build();
    }
}
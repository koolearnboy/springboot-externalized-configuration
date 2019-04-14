package xiaojx.xin;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 测试对于第三方的类，超出我们的控制，我们不能在class上面写@ConfigurationProperties
 * 因此我们在public方法上使用@Bean和@ConfigurationProperties，可以将值绑定到方法返回的对象中
 */
@Getter
@Setter
@Configuration
public class YAML2Bean5 {

    @ConfigurationProperties(prefix = "another.teacher")
    @Bean
    public Teacher teacher(){
        //先构找出对象，然后通过@ConfigurationProperties注解绑定值再放入容器中
        Teacher t = new Teacher();
        System.out.println("teacher before: === "+t);
        return t;
    }
}

@Getter
@Setter
@ToString
class Teacher{
    private Integer age;
    private String sex;
}

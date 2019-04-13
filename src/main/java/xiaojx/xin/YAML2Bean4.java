package xiaojx.xin;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 测试对象的值绑定
 */
@Getter
@Setter
@Component
@ConfigurationProperties(prefix = "other")
public class YAML2Bean4 {
    Student student;

    @Getter
    @Setter
    @ToString
    public static class Student{
        private Integer age;
        private String sex;
        private List<String> roles = new ArrayList<>(Collections.singleton("USER"));
    }
}

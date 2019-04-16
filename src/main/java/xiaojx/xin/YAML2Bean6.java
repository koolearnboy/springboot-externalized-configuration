package xiaojx.xin;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * 24.8.3 Merging Complex Types
 */
@Getter
@Setter
@ToString
@Component
@ConfigurationProperties(prefix = "acme")
@Validated
public class YAML2Bean6 {

    private final List<MyPOJO> list = new ArrayList<MyPOJO>();
    private Map<String,MyPOJO> map;
//    @NotNull
    private String isNull;

    @Getter
    @Setter
    @ToString
    //使用内部类就需要为static 可以直接new MyPOJO对象
    static class MyPOJO{
        private String name;
        private String desc;
    }


}

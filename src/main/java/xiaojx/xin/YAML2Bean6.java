package xiaojx.xin;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

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
public class YAML2Bean6 {

    private List<MyPOJO> list;
    private Map<String,MyPOJO> map;

    @Getter
    @Setter
    @ToString
    class MyPOJO{
        private String name;
        private String desc;
    }


}

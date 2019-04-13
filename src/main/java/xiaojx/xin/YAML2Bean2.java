package xiaojx.xin;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Component
//默认加载application.properties再进行值的绑定注入
public class YAML2Bean2 {
    @Value("${her.uuid}")
    String uuid;
//    @Value("${her.servers}") 集合对象不能注入
    List<String> servers = new ArrayList<>();
}

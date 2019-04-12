package xiaojx.xin;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 测试在不同的profile情况下的属性值的变化
 */
@Getter
@Setter
@Component
public class YAML2Bean3 {
    @Value("${server}")
    String server;
}

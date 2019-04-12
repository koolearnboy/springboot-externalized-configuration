package xiaojx.xin;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@Getter
@Setter
@Component
@ConfigurationProperties(prefix = "my")
//@ConfigurationProperties(prefix = "her")
public class YAML2Bean {
    String uuid;
    List<String> servers;
}

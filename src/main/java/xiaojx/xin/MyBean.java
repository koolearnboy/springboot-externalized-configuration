package xiaojx.xin;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component("myBean")
@Getter
public class MyBean {
    @Autowired
    private Environment environment;

    @Value("${username}")
    private String userName;

    public MyBean(){
        System.out.println("myBean 构造器调用");
        System.out.println("myBean @Auto env:"+environment);
        System.out.println("myBean @Value username:"+userName);
    }
}

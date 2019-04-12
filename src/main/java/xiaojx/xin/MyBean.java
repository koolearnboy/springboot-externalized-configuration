package xiaojx.xin;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component("myBean")
@Getter
//如果配置文件不是名为  application.properties 就需要手动指定,这样 @Value才能找到位置
@PropertySource("classpath:config/myconfig.yml")
public class MyBean {
    /**
     * 自动注入是先调用构造器生成对象,再进行依赖注入的,而且@Component注解将MyBean实例化为Spring中的一个单例的Bean
     * 手动 new MyBean() 中的 Environment 和 userName 是没有值的,为null
     * 只有Spring容器中管理的哪一个单例的Bean是被依赖注入值的
     */
    @Autowired
    private Environment environment;

    @Value("${username}")
    private String userName;

    @Value("${my.uuid}")
    private String uuid;

    /**
     * 根据官方文档24.8的解释
     *  only standard Java Bean properties are considered and binding on static properties is not supported.
     *  说明不支持静态变量的值的绑定
     */
//    @Value("${my.uuid}")
//    private static String uuid2;

    public MyBean(){
        System.out.println("myBean 构造器调用");
        System.out.println("myBean @Auto env:"+environment);
        System.out.println("myBean @Value username:"+userName);
    }
}

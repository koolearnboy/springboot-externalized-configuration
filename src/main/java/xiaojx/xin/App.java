package xiaojx.xin;

import lombok.Getter;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;


@SpringBootApplication
@RestController
@Component("app")
@Getter
public class App implements ApplicationContextAware
{

    @Autowired
    private Environment env;

    @Value("${username}")
    private String userName;



    public App(){
        System.out.println("App 构造器");
        System.out.println("App @Autowired enviroment:"+env);
        System.out.println("App @Value userName:"+userName);
    }
    @RequestMapping("/")
    public String say(@Value("${username}") String name,@Value("${my.uuid}") String uuid){
        return env.getProperty("username")+"===="+userName+"-----"+name+"=="+uuid+"=="+env.getProperty("name");
    }

//    public static void main( String[] args )
//    {
//        Environment environment = SpringApplication.run(App.class,args).getEnvironment();
////        这种方式得到的对象是不会被依赖注入的
////        var bean = new MyBean();
////        System.out.println(environment.getProperty("username"));
////        System.out.println(bean.getUserName());
////        System.out.println(bean.getEnvironment());
//
//
//    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        //通过实现ApplicationContextAware接口,当App实例化完成以后进行回调传入Context
        // 再过去到实例化以后的App Bean,查看其中的值是否被依赖注入
        App app = (App) applicationContext.getBean("app");
        System.out.println("app context 注入值为"+app.getUserName());
        MyBean bean = (MyBean) applicationContext.getBean("myBean");
        System.out.println("myBean context 注入值为"+bean.getUserName());
        System.out.println("myBean context 注入值为"+bean.getUuid());
    }
}

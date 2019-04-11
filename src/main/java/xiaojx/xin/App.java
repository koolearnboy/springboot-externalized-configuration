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

/**
 * Hello world!
 *
 */
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
    public String say(@Value("${username}") String name){
        return env.getProperty("username")+"===="+userName+"-----"+name;
    }

    public static void main( String[] args )
    {
        Environment environment = SpringApplication.run(App.class,args).getEnvironment();
//        var bean = new MyBean();
//        System.out.println(environment.getProperty("username"));
//        System.out.println(bean.getUserName());
//        System.out.println(bean.getEnvironment());

        Thread thread = new Thread(){
            @Override
            public void run() {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
//                WebApplicationContext wac = ContextLoader.getCurrentWebApplicationContext();
//                System.out.println("thread:"+wac.getBean(""));
//                System.out.println("thread:"+App.userName);
            }
        };
        thread.run();
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        App app = (App) applicationContext.getBean("app");

        System.out.println("app context 注入"+app.getUserName());
        MyBean bean = (MyBean) applicationContext.getBean("myBean");
//        System.out.println("myBean context 注入"+bean.getUserName());
    }
}

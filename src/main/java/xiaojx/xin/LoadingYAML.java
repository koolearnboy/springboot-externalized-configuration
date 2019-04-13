package xiaojx.xin;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 通过YAML2Bean加载application.yml的值到YAML2Bean对象中,并放到spring容器
 * 注意YAML2Bean 中的 field需要提供set方法  或者 给field提供初始值才能正确的加载
 * 官方文档有这一句:you either need to provide a setter or initialize it with a mutable value
 */
@SpringBootApplication
@RestController
public class LoadingYAML implements ApplicationContextAware {

    @Autowired
    private YAML2Bean4 yaml2Bean4;
    @Autowired
    private Teacher teacher;

    public static void main(String[] args) {
        SpringApplication.run(LoadingYAML.class,args);
    }

    @RequestMapping("/teacher")
    public String getTeacher(){
        return teacher.toString();
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {

        var bean = (YAML2Bean)applicationContext.getBean("YAML2Bean");
        System.out.println("bean1---"+bean.getServers());
        System.out.println("bean1---"+bean.getUuid());

        var bean2 = (YAML2Bean2)applicationContext.getBean("YAML2Bean2");
        System.out.println("bean2---"+bean2.getServers());
        System.out.println("bean2---"+bean2.getUuid());

        var bean3 = (YAML2Bean3)applicationContext.getBean("YAML2Bean3");
        System.out.println("bean3---"+bean3.getServer());

        var bean4 = (YAML2Bean4)applicationContext.getBean("YAML2Bean4");
        System.out.println("bean4---"+bean4.getStudent());
        // or 通过自动注入
        System.out.println("yaml2Bean4自动注入的方式:"+yaml2Bean4.getStudent());
        System.out.println("yaml2Bean5-teacher自动注入的方式:"+teacher);
    }
}

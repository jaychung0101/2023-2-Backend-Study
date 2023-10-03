package Week3HW;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@Slf4j
@SpringBootApplication
public class Gdsc3rdHwApplication {
    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(Gdsc3rdHwApplication.class, args);

        log.info("---------- 모든 Bean 출력 ----------");
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            Object bean = applicationContext.getBean(beanDefinitionName);
            log.info("name=" + beanDefinitionName + " object=" + bean);
        }

        log.info("---------- ClassA Bean 값 출력----------");
        ClassA classA1 = (ClassA) applicationContext.getBean("classA", ClassA.class);
        ClassA classA2 = (ClassA) applicationContext.getBean("classA", ClassA.class);
        log.info("classA1 = " + classA1);
        log.info("classA2 = " + classA2);
    }
}

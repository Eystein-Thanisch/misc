package quotes;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {
        BeanFactory factory = new ClassPathXmlApplicationContext("/beans.xml");
        Container testContainer = factory.getBean("goodmanQuote",Container.class);
        System.out.println(testContainer.getContent());
        testContainer = factory.getBean("joyceQuote",Container.class);
        System.out.println(testContainer.getContent());
    }

}

package com.zjl.spring.tx;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zjl.spring.tx.model.User;
import com.zjl.spring.tx.service.OuterBean;

public class Main {

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
        OuterBean outerBean = (OuterBean) ctx.getBean("outerBeanImpl");

        /**你能通过控制插入的数据的UserName重复产生异常*/
        User outer = new User();
        outer.setUsername("009");
        outer.setName("zjl");

        User inner = new User();
        inner.setUsername("010");
        inner.setName("zjl");

        /** 选择代码进行注释，完成你想要的测试*/
        outerBean.testRequired(outer, inner);
        // outerBean.testRequiresNew(outer,inner);
        //outerBean.testNested(outer,inner);

    }
}

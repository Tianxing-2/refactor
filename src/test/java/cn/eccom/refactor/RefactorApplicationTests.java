package cn.eccom.refactor;

import cn.eccom.refactor.ch1.service.Prototype;
import cn.eccom.refactor.ch1.util.R;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;


@SpringBootTest
class RefactorApplicationTests {
    @Resource
    Prototype prototype;
    @Test
    public void test(){
        R data = prototype.createStatementData();
        System.out.println(prototype.statement(data));
        System.out.println(prototype.htmlStatement(data));
    }
}

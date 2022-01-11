package org.jeremyross;

import org.apache.camel.ProducerTemplate;
import org.apache.camel.test.spring.junit5.CamelSpringBootTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@CamelSpringBootTest
@SpringBootTest(classes = MyApplication.class)
public class TransactedTest {

    @Autowired
    private ProducerTemplate template;

    @Test
    public void test() {
        template.requestBody("direct:route1", "");
    }
}

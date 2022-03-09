package com.example.spring.cloud.stream.reactive.imperial.functions.problem;

import org.slf4j.*;
import org.springframework.integration.annotation.*;

import java.util.function.*;

@MessageEndpoint("testImperative")
public class TestImperativeFunction implements Consumer<String> {

    private static final Logger LOGGER = LoggerFactory.getLogger(TestImperativeFunction.class);

    private final TestComponent testComponent;

    public TestImperativeFunction(TestComponent testComponent) {
        this.testComponent = testComponent;
    }

    @Override
    public void accept(String s) {
        testComponent.consume(s);
    }
}

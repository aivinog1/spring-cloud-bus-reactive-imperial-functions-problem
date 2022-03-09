package com.example.spring.cloud.stream.reactive.imperial.functions.problem;

import org.slf4j.*;
import org.springframework.stereotype.*;

@Component
public class TestComponent {

    private static final Logger LOGGER = LoggerFactory.getLogger(TestComponent.class);

    public void consume(final String s) {
        LOGGER.info("We got a message: {}!", s);
    }
}

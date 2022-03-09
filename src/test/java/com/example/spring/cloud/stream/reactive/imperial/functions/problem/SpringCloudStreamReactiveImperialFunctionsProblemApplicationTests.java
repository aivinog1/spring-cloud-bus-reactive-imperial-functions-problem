package com.example.spring.cloud.stream.reactive.imperial.functions.problem;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.*;
import org.springframework.cloud.stream.binder.test.*;
import org.springframework.context.annotation.*;
import org.springframework.messaging.support.*;

import static org.mockito.Mockito.*;

@SpringBootTest
@Import(TestChannelBinderConfiguration.class)
class SpringCloudStreamReactiveImperialFunctionsProblemApplicationTests {

    @MockBean
    private TestComponent testComponent;

    @Autowired
    private InputDestination inputDestination;

    @Test
    void contextLoads() {
        var value = 123;
        final String result = String.format("%s-passed", value);
        doNothing().when(testComponent).consume(result);
        inputDestination.send(MessageBuilder.withPayload(value).build(), "first-destination");

        verify(testComponent, only()).consume(result);
        verifyNoMoreInteractions(testComponent);
    }

}

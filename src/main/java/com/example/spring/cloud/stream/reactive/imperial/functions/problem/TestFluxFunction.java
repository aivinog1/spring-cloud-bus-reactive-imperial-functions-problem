package com.example.spring.cloud.stream.reactive.imperial.functions.problem;

import org.springframework.integration.annotation.*;
import reactor.core.publisher.*;

import java.util.function.*;

@MessageEndpoint("testFlux")
public class TestFluxFunction implements Function<Flux<Integer>, Flux<String>> {
    @Override
    public Flux<String> apply(Flux<Integer> stringFlux) {
        return stringFlux.map(s -> String.format("%s-passed", s));
    }
}

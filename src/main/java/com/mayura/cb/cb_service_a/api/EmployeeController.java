package com.mayura.cb.cb_service_a.api;

import com.mayura.cb.cb_service_a.service.ServiceB;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import jakarta.websocket.server.PathParam;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@RestController
@AllArgsConstructor
@Slf4j
public class EmployeeController {

    private final ServiceB serviceB;

    @GetMapping("/data/{id}")
    @CircuitBreaker(name = "circuitBreaker", fallbackMethod = "getMyDataFallback")
    public List<Object> getData(@PathVariable("id") String id) throws Exception {
        return serviceB.getData(id);
    }

    public List<Object> getMyDataFallback(Throwable throwable) {
        log.error("Error while calling the service", throwable);
        return Collections.singletonList("Service B is down");
    }
}

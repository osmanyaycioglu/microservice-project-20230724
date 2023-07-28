package com.training.micro.service.order.resilience;

import io.github.resilience4j.circuitbreaker.CircuitBreaker;
import io.github.resilience4j.circuitbreaker.CircuitBreakerRegistry;
import io.github.resilience4j.retry.Retry;
import io.github.resilience4j.retry.RetryRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class TestStarter implements CommandLineRunner {

    @Autowired
    private TestCallerBean testCallerBean;

    @Autowired
    private RetryRegistry retryRegistry;

    @Autowired
    private CircuitBreakerRegistry circuitBreakerRegistry;

    @Override
    public void run(final String... args) throws Exception {
        Retry         retyXyzLoc      = retryRegistry.retry("retyXyz");

        CircuitBreaker         circuitBreakerLoc = circuitBreakerRegistry.circuitBreaker("kitchencb");
        circuitBreakerLoc.getEventPublisher().onStateTransition(e -> System.out.println("Event : " + e.getStateTransition()));
        for (int i = 0; i < 100; i++) {
            try {
                testCallerBean.begin();
                Thread.sleep(100);
            } catch (Exception eParam) {
                System.out.println("Exception : " + eParam.getClass()
                                                          .getSimpleName());
                ;

                try {
                    Thread.sleep(100);
                } catch (Exception exParam) {
                    throw new RuntimeException(exParam);
                }
            }
            Retry.Metrics retryMetricsLoc = retyXyzLoc.getMetrics();
            System.out.println("wr : " + retryMetricsLoc.getNumberOfFailedCallsWithRetryAttempt()
                               + " swor : " + retryMetricsLoc.getNumberOfSuccessfulCallsWithoutRetryAttempt()
                               + " swr : " + retryMetricsLoc.getNumberOfSuccessfulCallsWithRetryAttempt()
            );
            CircuitBreaker.Metrics cbMetricsLoc      = circuitBreakerLoc.getMetrics();
            System.out.println("State : " + circuitBreakerLoc.getState()
                               + " FaileRate : " + cbMetricsLoc.getFailureRate()
                               + " failed : " + cbMetricsLoc.getNumberOfFailedCalls()
                               + " notPermitted : " + cbMetricsLoc.getNumberOfNotPermittedCalls()
                               + " success : " + cbMetricsLoc.getNumberOfSuccessfulCalls()
                               + " buffered : " + cbMetricsLoc.getNumberOfBufferedCalls()
            );
        }
    }

}

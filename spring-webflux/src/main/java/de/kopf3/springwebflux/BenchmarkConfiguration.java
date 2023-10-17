package de.kopf3.springwebflux;

import org.springframework.aot.hint.annotation.RegisterReflectionForBinding;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@Profile("benchmark")
public class BenchmarkConfiguration implements ApplicationListener<ApplicationStartedEvent> {

    @Override
    public void onApplicationEvent(final ApplicationStartedEvent event) {
        System.exit(0);
    }
}

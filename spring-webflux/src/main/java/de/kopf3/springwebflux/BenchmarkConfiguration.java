package de.kopf3.springwebflux;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aot.hint.annotation.RegisterReflectionForBinding;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@Profile("benchmark")
public class BenchmarkConfiguration implements ApplicationListener<ApplicationStartedEvent> {

    private static final Logger log = LoggerFactory.getLogger("benchmark");

    @Override
    public void onApplicationEvent(final ApplicationStartedEvent event) {
        log.info("Started");
        Runtime.getRuntime().halt(0);
        System.exit(0);
    }
}

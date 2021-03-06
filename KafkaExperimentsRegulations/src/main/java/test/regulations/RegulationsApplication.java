package test.regulations;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.Import;
import org.springframework.web.reactive.config.EnableWebFlux;
import test.common.configuration.EventStoreConfiguration;
import test.common.configuration.MongoConfiguration;
import test.common.service.KafkaEventProcessor;

@SpringBootApplication
@EnableWebFlux
@EnableDiscoveryClient
@EnableBinding(KafkaEventProcessor.class)
@Import({MongoConfiguration.class, RegulationsConfiguration.class, EventStoreConfiguration.class})
@EnableCircuitBreaker
//@ComponentScan(basePackages = {"test.regulations.rest", "test.common.rest"})
public class RegulationsApplication {

    public static void main(String[] args) {
        SpringApplication app =
                new SpringApplication(RegulationsApplication.class);
        app.setWebApplicationType(WebApplicationType.REACTIVE);
        app.run(args);
    }
}

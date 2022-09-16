package tech.jhipster.lite.generator.server.springboot.broker.pulsar.infrastructure.primary;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tech.jhipster.lite.generator.server.springboot.broker.pulsar.application.PulsarApplicationService;
import tech.jhipster.lite.module.domain.resource.JHipsterModuleOrganization;
import tech.jhipster.lite.module.domain.resource.JHipsterModulePropertiesDefinition;
import tech.jhipster.lite.module.domain.resource.JHipsterModuleResource;

@Configuration
class PulsarModuleConfiguration {

  @Bean
  JHipsterModuleResource pulsarModule(PulsarApplicationService pulsar) {
    return JHipsterModuleResource
      .builder()
      .slug("spring-boot-pulsar")
      .propertiesDefinition(JHipsterModulePropertiesDefinition.builder().addBasePackage().addIndentation().build())
      .apiDoc("Spring Boot - Broker", "Add Pulsar dependencies, with testcontainers")
      .organization(JHipsterModuleOrganization.builder().addModuleDependency("spring-boot").build())
      .tags("server", "spring", "spring-boot", "broker")
      .factory(pulsar::buildModule);
  }
}

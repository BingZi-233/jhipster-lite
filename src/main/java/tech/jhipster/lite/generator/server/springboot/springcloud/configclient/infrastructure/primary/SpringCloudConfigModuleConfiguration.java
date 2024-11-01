package tech.jhipster.lite.generator.server.springboot.springcloud.configclient.infrastructure.primary;

import static tech.jhipster.lite.shared.slug.domain.JHLiteFeatureSlug.SERVICE_DISCOVERY;
import static tech.jhipster.lite.shared.slug.domain.JHLiteModuleSlug.SPRING_BOOT_ACTUATOR;
import static tech.jhipster.lite.shared.slug.domain.JHLiteModuleSlug.SPRING_CLOUD;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tech.jhipster.lite.generator.server.springboot.springcloud.configclient.application.SpringCloudConfigClientApplicationService;
import tech.jhipster.lite.module.domain.resource.JHipsterModuleOrganization;
import tech.jhipster.lite.module.domain.resource.JHipsterModulePropertiesDefinition;
import tech.jhipster.lite.module.domain.resource.JHipsterModuleResource;

@Configuration
class SpringCloudConfigModuleConfiguration {

  @Bean
  JHipsterModuleResource springCloudConfigModule(SpringCloudConfigClientApplicationService cloudConfigs) {
    return JHipsterModuleResource.builder()
      .slug(SPRING_CLOUD)
      .propertiesDefinition(JHipsterModulePropertiesDefinition.builder().addProjectBaseName().build())
      .apiDoc("Spring Boot - Spring Cloud", "添加Spring Cloud配置客户端")
      .organization(JHipsterModuleOrganization.builder().feature(SERVICE_DISCOVERY).addDependency(SPRING_BOOT_ACTUATOR).build())
      .tags("server", "spring", "spring-boot", "cloud")
      .factory(cloudConfigs::buildModule);
  }
}

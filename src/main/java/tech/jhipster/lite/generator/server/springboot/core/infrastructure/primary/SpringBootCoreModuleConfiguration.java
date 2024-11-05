package tech.jhipster.lite.generator.server.springboot.core.infrastructure.primary;

import static tech.jhipster.lite.shared.slug.domain.JHLiteFeatureSlug.JAVA_BUILD_TOOL;
import static tech.jhipster.lite.shared.slug.domain.JHLiteModuleSlug.JAVA_BASE;
import static tech.jhipster.lite.shared.slug.domain.JHLiteModuleSlug.SPRING_BOOT;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tech.jhipster.lite.generator.server.springboot.core.application.SpringBootApplicationService;
import tech.jhipster.lite.module.domain.resource.JHipsterModuleOrganization;
import tech.jhipster.lite.module.domain.resource.JHipsterModulePropertiesDefinition;
import tech.jhipster.lite.module.domain.resource.JHipsterModuleResource;

@Configuration
class SpringBootCoreModuleConfiguration {

  @Bean
  JHipsterModuleResource springBootCoreModule(SpringBootApplicationService springBoot) {
    return JHipsterModuleResource.builder()
      .slug(SPRING_BOOT)
      .propertiesDefinition(
        JHipsterModulePropertiesDefinition.builder()
          .addBasePackage()
          .addProjectBaseName()
          .addIndentation()
          .addSpringConfigurationFormat()
          .build()
      )
      .apiDoc("Spring Boot", "初始化Spring Boot项目，包含依赖、应用程序和属性")
      .organization(JHipsterModuleOrganization.builder().addDependency(JAVA_BUILD_TOOL).addDependency(JAVA_BASE).build())
      .tags("server", "spring", "spring-boot")
      .factory(springBoot::buildModule);
  }
}

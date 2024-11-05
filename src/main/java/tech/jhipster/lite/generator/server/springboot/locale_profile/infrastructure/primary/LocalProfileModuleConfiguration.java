package tech.jhipster.lite.generator.server.springboot.locale_profile.infrastructure.primary;

import static tech.jhipster.lite.shared.slug.domain.JHLiteModuleSlug.SPRING_BOOT_LOCAL_PROFILE;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tech.jhipster.lite.generator.server.springboot.locale_profile.application.LocalProfileApplicationService;
import tech.jhipster.lite.module.domain.resource.JHipsterModuleOrganization;
import tech.jhipster.lite.module.domain.resource.JHipsterModulePropertiesDefinition;
import tech.jhipster.lite.module.domain.resource.JHipsterModuleResource;

@Configuration
class LocalProfileModuleConfiguration {

  @Bean
  JHipsterModuleResource localProfile(LocalProfileApplicationService localProfile) {
    return JHipsterModuleResource.builder()
      .slug(SPRING_BOOT_LOCAL_PROFILE)
      .propertiesDefinition(
        JHipsterModulePropertiesDefinition.builder()
          .addBasePackage()
          .addProjectBaseName()
          .addIndentation()
          .addSpringConfigurationFormat()
          .build()
      )
      .apiDoc("Spring Boot", "默认使用Spring本地配置文件进行开发。")
      .organization(JHipsterModuleOrganization.SPRINGBOOT_DEPENDENCY)
      .tags("server", "spring", "spring-boot", "dx")
      .factory(localProfile::buildModule);
  }
}

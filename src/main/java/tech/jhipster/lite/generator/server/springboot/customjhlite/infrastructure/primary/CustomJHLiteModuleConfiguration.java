package tech.jhipster.lite.generator.server.springboot.customjhlite.infrastructure.primary;

import static tech.jhipster.lite.shared.slug.domain.JHLiteModuleSlug.CUSTOM_JHLITE;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tech.jhipster.lite.generator.server.springboot.customjhlite.application.CustomJHLiteApplicationService;
import tech.jhipster.lite.module.domain.resource.JHipsterModuleOrganization;
import tech.jhipster.lite.module.domain.resource.JHipsterModulePropertiesDefinition;
import tech.jhipster.lite.module.domain.resource.JHipsterModuleResource;

@Configuration
class CustomJHLiteModuleConfiguration {

  @Bean
  JHipsterModuleResource customJHLiteModule(CustomJHLiteApplicationService customJHLite) {
    return JHipsterModuleResource.builder()
      .slug(CUSTOM_JHLITE)
      .propertiesDefinition(propertiesDefinition())
      .apiDoc("JHLite", "创建一个自定义的JHLite实例以构建自定义模块")
      .organization(JHipsterModuleOrganization.SPRINGBOOT_DEPENDENCY)
      .tags("server")
      .factory(customJHLite::buildModule);
  }

  private JHipsterModulePropertiesDefinition propertiesDefinition() {
    return JHipsterModulePropertiesDefinition.builder()
      .addBasePackage()
      .addProjectBaseName()
      .addIndentation()
      .addServerPort()
      .addSpringConfigurationFormat()
      .build();
  }
}

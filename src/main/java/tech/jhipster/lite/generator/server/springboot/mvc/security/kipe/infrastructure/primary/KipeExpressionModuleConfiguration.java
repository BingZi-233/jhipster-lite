package tech.jhipster.lite.generator.server.springboot.mvc.security.kipe.infrastructure.primary;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tech.jhipster.lite.generator.server.springboot.mvc.security.kipe.application.KipeApplicationService;
import tech.jhipster.lite.module.domain.resource.JHipsterModuleOrganization;
import tech.jhipster.lite.module.domain.resource.JHipsterModulePropertiesDefinition;
import tech.jhipster.lite.module.domain.resource.JHipsterModuleResource;
import tech.jhipster.lite.shared.slug.domain.JHLiteFeatureSlug;
import tech.jhipster.lite.shared.slug.domain.JHLiteModuleSlug;

@Configuration
class KipeExpressionModuleConfiguration {

  @Bean
  JHipsterModuleResource kipeExpressionModule(KipeApplicationService kipe) {
    return JHipsterModuleResource.builder()
      .slug(JHLiteModuleSlug.KIPE_EXPRESSION)
      .propertiesDefinition(JHipsterModulePropertiesDefinition.builder().addBasePackage().build())
      .apiDoc("Spring Boot - MVC - Security", "为spring security创建一个新的安全表达式：can('action', #element)")
      .organization(JHipsterModuleOrganization.builder().addDependency(JHLiteFeatureSlug.AUTHENTICATION).build())
      .tags("server", "spring", "spring-boot", "authentication")
      .factory(kipe::buildKipeExpressions);
  }
}

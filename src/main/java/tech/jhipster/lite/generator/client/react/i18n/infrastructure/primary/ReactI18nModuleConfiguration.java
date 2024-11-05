package tech.jhipster.lite.generator.client.react.i18n.infrastructure.primary;

import static tech.jhipster.lite.shared.slug.domain.JHLiteFeatureSlug.CLIENT_INTERNATIONALIZATION;
import static tech.jhipster.lite.shared.slug.domain.JHLiteModuleSlug.REACT_CORE;
import static tech.jhipster.lite.shared.slug.domain.JHLiteModuleSlug.REACT_I18N;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tech.jhipster.lite.generator.client.react.i18n.application.ReactI18nApplicationService;
import tech.jhipster.lite.module.domain.resource.JHipsterModuleOrganization;
import tech.jhipster.lite.module.domain.resource.JHipsterModulePropertiesDefinition;
import tech.jhipster.lite.module.domain.resource.JHipsterModuleResource;

@Configuration
class ReactI18nModuleConfiguration {

  @Bean
  JHipsterModuleResource reactI18nModule(ReactI18nApplicationService i18n) {
    return JHipsterModuleResource.builder()
      .slug(REACT_I18N)
      .propertiesDefinition(JHipsterModulePropertiesDefinition.builder().build())
      .apiDoc("Frontend - React", "添加React国际化")
      .organization(JHipsterModuleOrganization.builder().feature(CLIENT_INTERNATIONALIZATION).addDependency(REACT_CORE).build())
      .tags("client", "react", "i18n")
      .factory(i18n::buildModule);
  }
}

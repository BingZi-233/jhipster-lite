package tech.jhipster.lite.generator.client.vue.security.oauth2_keycloak.infrastructure.primary;

import static tech.jhipster.lite.shared.slug.domain.JHLiteFeatureSlug.*;
import static tech.jhipster.lite.shared.slug.domain.JHLiteModuleSlug.*;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tech.jhipster.lite.generator.client.vue.security.oauth2_keycloak.application.VueOAuth2KeycloakApplicationService;
import tech.jhipster.lite.module.domain.resource.JHipsterModuleOrganization;
import tech.jhipster.lite.module.domain.resource.JHipsterModulePropertiesDefinition;
import tech.jhipster.lite.module.domain.resource.JHipsterModuleResource;

@Configuration
class VueOAuth2KeycloakModuleConfiguration {

  @Bean
  JHipsterModuleResource vueOAuth2KeycloakModule(VueOAuth2KeycloakApplicationService oauth2Keycloak) {
    return JHipsterModuleResource.builder()
      .slug(VUE_OAUTH2_KEYCLOAK)
      .propertiesDefinition(JHipsterModulePropertiesDefinition.builder().addIndentation().build())
      .apiDoc("Vue", "将OAuth2 Keycloak身份验证添加到Vue")
      .organization(JHipsterModuleOrganization.builder().feature(VUE_AUTHENTICATION).addDependency(VUE_CORE).build())
      .tags("client", "vue", "auth", "oauth2", "keycloak")
      .factory(oauth2Keycloak::buildModule);
  }
}

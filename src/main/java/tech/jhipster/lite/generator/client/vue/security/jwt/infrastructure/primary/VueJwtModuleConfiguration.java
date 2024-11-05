package tech.jhipster.lite.generator.client.vue.security.jwt.infrastructure.primary;

import static tech.jhipster.lite.shared.slug.domain.JHLiteFeatureSlug.*;
import static tech.jhipster.lite.shared.slug.domain.JHLiteModuleSlug.*;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tech.jhipster.lite.generator.client.vue.security.jwt.application.VueJwtApplicationService;
import tech.jhipster.lite.module.domain.resource.JHipsterModuleOrganization;
import tech.jhipster.lite.module.domain.resource.JHipsterModulePropertiesDefinition;
import tech.jhipster.lite.module.domain.resource.JHipsterModuleResource;

@Configuration
class VueJwtModuleConfiguration {

  @Bean
  JHipsterModuleResource vueJwtModule(VueJwtApplicationService jwt) {
    return JHipsterModuleResource.builder()
      .slug(VUE_JWT)
      .propertiesDefinition(JHipsterModulePropertiesDefinition.builder().addIndentation().build())
      .apiDoc("Vue", "为Vue添加JWT认证")
      .organization(JHipsterModuleOrganization.builder().feature(VUE_AUTHENTICATION).addDependency(VUE_CORE).build())
      .tags("client", "vue", "auth", "jwt")
      .factory(jwt::buildModule);
  }
}

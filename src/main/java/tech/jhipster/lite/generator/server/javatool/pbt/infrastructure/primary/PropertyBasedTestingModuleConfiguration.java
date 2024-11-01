package tech.jhipster.lite.generator.server.javatool.pbt.infrastructure.primary;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tech.jhipster.lite.generator.server.javatool.pbt.application.PropertyBasedTestingApplicationService;
import tech.jhipster.lite.module.domain.resource.JHipsterModuleOrganization;
import tech.jhipster.lite.module.domain.resource.JHipsterModulePropertiesDefinition;
import tech.jhipster.lite.module.domain.resource.JHipsterModuleResource;
import tech.jhipster.lite.shared.slug.domain.JHLiteFeatureSlug;
import tech.jhipster.lite.shared.slug.domain.JHLiteModuleSlug;

@Configuration
class PropertyBasedTestingModuleConfiguration {

  @Bean
  JHipsterModuleResource jqwikModule(PropertyBasedTestingApplicationService propertyBasedTesting) {
    return JHipsterModuleResource.builder()
      .slug(JHLiteModuleSlug.JQWIK)
      .propertiesDefinition(JHipsterModulePropertiesDefinition.builder().build())
      .apiDoc("Advanced testing", "添加jqwik库以进行基于属性的测试")
      .organization(JHipsterModuleOrganization.builder().addDependency(JHLiteFeatureSlug.JAVA_BUILD_TOOL).build())
      .tags("server", "testing")
      .factory(propertyBasedTesting::build);
  }
}

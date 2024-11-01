package tech.jhipster.lite.generator.server.javatool.java_enum.infrastructure.primary;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tech.jhipster.lite.generator.server.javatool.java_enum.application.JavaEnumsApplicationService;
import tech.jhipster.lite.module.domain.resource.JHipsterModuleOrganization;
import tech.jhipster.lite.module.domain.resource.JHipsterModulePropertiesDefinition;
import tech.jhipster.lite.module.domain.resource.JHipsterModuleResource;
import tech.jhipster.lite.shared.slug.domain.JHLiteModuleSlug;

@Configuration
class JavaEnumsModuleConfiguration {

  @Bean
  JHipsterModuleResource javaEnumsModule(JavaEnumsApplicationService javaEnums) {
    return JHipsterModuleResource.builder()
      .slug(JHLiteModuleSlug.JAVA_ENUMS)
      .propertiesDefinition(JHipsterModulePropertiesDefinition.builder().addBasePackage().build())
      .apiDoc("Java", "添加简单的枚举映射器")
      .organization(JHipsterModuleOrganization.builder().addDependency(JHLiteModuleSlug.JAVA_BASE).build())
      .tags("server")
      .factory(javaEnums::buildModule);
  }
}

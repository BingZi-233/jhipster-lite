package tech.jhipster.lite.generator.server.springboot.mvc.internationalized_errors.infrastructure.primary;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tech.jhipster.lite.generator.server.springboot.mvc.internationalized_errors.application.InternationalizedErrorsApplicationService;
import tech.jhipster.lite.module.domain.resource.JHipsterModuleOrganization;
import tech.jhipster.lite.module.domain.resource.JHipsterModulePropertiesDefinition;
import tech.jhipster.lite.module.domain.resource.JHipsterModuleResource;
import tech.jhipster.lite.shared.slug.domain.JHLiteModuleSlug;

@Configuration
class InternationalizedErrorsModuleConfiguration {

  @Bean
  JHipsterModuleResource internationalizedErrorsModule(InternationalizedErrorsApplicationService internationalizedErrors) {
    return JHipsterModuleResource.builder()
      .slug(JHLiteModuleSlug.INTERNATIONALIZED_ERRORS)
      .propertiesDefinition(JHipsterModulePropertiesDefinition.builder().addBasePackage().addProjectBaseName().build())
      .apiDoc("Spring Boot", "为应用程序错误添加国际化")
      .organization(
        JHipsterModuleOrganization.builder()
          .addDependency(JHLiteModuleSlug.JAVA_ENUMS)
          .addDependency(JHLiteModuleSlug.SPRING_BOOT_MVC_EMPTY)
          .build()
      )
      .tags("server", "spring")
      .factory(internationalizedErrors::buildModule);
  }
}

package tech.jhipster.lite.generator.server.javatool.archunit.infrastructure.primary;

import static tech.jhipster.lite.shared.slug.domain.JHLiteFeatureSlug.SPRING_SERVER;
import static tech.jhipster.lite.shared.slug.domain.JHLiteModuleSlug.JAVA_ARCHUNIT;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tech.jhipster.lite.generator.server.javatool.archunit.application.JavaArchUnitApplicationService;
import tech.jhipster.lite.module.domain.resource.JHipsterModuleOrganization;
import tech.jhipster.lite.module.domain.resource.JHipsterModulePropertiesDefinition;
import tech.jhipster.lite.module.domain.resource.JHipsterModuleResource;

@Configuration
class ArchUnitModuleConfiguration {

  @Bean
  JHipsterModuleResource archUnitModule(JavaArchUnitApplicationService archUnit) {
    return JHipsterModuleResource.builder()
      .slug(JAVA_ARCHUNIT)
      .propertiesDefinition(JHipsterModulePropertiesDefinition.builder().addBasePackage().addIndentation().build())
      .apiDoc("Java", "向项目添加六边形拱形单元测试")
      .organization(JHipsterModuleOrganization.builder().addDependency(SPRING_SERVER).build())
      .tags("server", "test")
      .factory(archUnit::buildModule);
  }
}

package tech.jhipster.lite.generator.server.javatool.memoizer.infrastructure.primary;

import static tech.jhipster.lite.shared.slug.domain.JHLiteModuleSlug.JAVA_BASE;
import static tech.jhipster.lite.shared.slug.domain.JHLiteModuleSlug.JAVA_MEMOIZERS;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tech.jhipster.lite.generator.server.javatool.memoizer.application.JavaMemoizersApplicationService;
import tech.jhipster.lite.module.domain.resource.JHipsterModuleOrganization;
import tech.jhipster.lite.module.domain.resource.JHipsterModulePropertiesDefinition;
import tech.jhipster.lite.module.domain.resource.JHipsterModuleResource;

@Configuration
class JavaMemoizersModuleConfiguration {

  @Bean
  JHipsterModuleResource javaMemoizersModule(JavaMemoizersApplicationService javaMemoizers) {
    return JHipsterModuleResource.builder()
      .slug(JAVA_MEMOIZERS)
      .propertiesDefinition(JHipsterModulePropertiesDefinition.builder().addBasePackage().build())
      .apiDoc("Java", "添加简单的备忘录工厂")
      .organization(JHipsterModuleOrganization.builder().addDependency(JAVA_BASE).build())
      .tags("server")
      .factory(javaMemoizers::buildModule);
  }
}

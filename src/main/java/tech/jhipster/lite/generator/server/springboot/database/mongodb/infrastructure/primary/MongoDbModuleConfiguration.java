package tech.jhipster.lite.generator.server.springboot.database.mongodb.infrastructure.primary;

import static tech.jhipster.lite.shared.slug.domain.JHLiteModuleSlug.MONGODB;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tech.jhipster.lite.generator.server.springboot.database.mongodb.application.MongodbApplicationService;
import tech.jhipster.lite.module.domain.resource.JHipsterModuleOrganization;
import tech.jhipster.lite.module.domain.resource.JHipsterModulePropertiesDefinition;
import tech.jhipster.lite.module.domain.resource.JHipsterModuleResource;

@Configuration
class MongoDbModuleConfiguration {

  @Bean
  JHipsterModuleResource mongoDbModule(MongodbApplicationService mongoDb) {
    return JHipsterModuleResource.builder()
      .slug(MONGODB)
      .propertiesDefinition(
        JHipsterModulePropertiesDefinition.builder().addBasePackage().addIndentation().addSpringConfigurationFormat().build()
      )
      .apiDoc("Spring Boot - Database", "添加MongoDB驱动程序和依赖项，以及testcontainers")
      .organization(JHipsterModuleOrganization.SPRINGBOOT_DEPENDENCY)
      .tags("server", "spring", "spring-boot", "database")
      .factory(mongoDb::buildModule);
  }
}

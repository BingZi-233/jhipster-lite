package tech.jhipster.lite.generator.server.springboot.dbmigration.neo4jmigrations.infrastructure.primary;

import static tech.jhipster.lite.shared.slug.domain.JHLiteModuleSlug.NEO4J;
import static tech.jhipster.lite.shared.slug.domain.JHLiteModuleSlug.NEO4J_MIGRATIONS;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tech.jhipster.lite.generator.server.springboot.dbmigration.neo4jmigrations.application.Neo4jMigrationsApplicationService;
import tech.jhipster.lite.module.domain.resource.JHipsterModuleOrganization;
import tech.jhipster.lite.module.domain.resource.JHipsterModulePropertiesDefinition;
import tech.jhipster.lite.module.domain.resource.JHipsterModuleResource;

@Configuration
class Neo4jMigrationsModuleConfiguration {

  @Bean
  JHipsterModuleResource neo4jMigrations(Neo4jMigrationsApplicationService neo4jMigrations) {
    return JHipsterModuleResource.builder()
      .slug(NEO4J_MIGRATIONS)
      .propertiesDefinition(
        JHipsterModulePropertiesDefinition.builder().addBasePackage().addIndentation().addSpringConfigurationFormat().build()
      )
      .apiDoc("Spring Boot - Database Migration", "添加neo4j迁移")
      .organization(JHipsterModuleOrganization.builder().addDependency(NEO4J).build())
      .tags("server", "spring", "spring-boot", "database", "migration", "neo4j")
      .factory(neo4jMigrations::buildModule);
  }
}

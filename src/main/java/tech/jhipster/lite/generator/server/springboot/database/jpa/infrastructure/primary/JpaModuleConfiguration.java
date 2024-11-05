package tech.jhipster.lite.generator.server.springboot.database.jpa.infrastructure.primary;

import static tech.jhipster.lite.shared.slug.domain.JHLiteFeatureSlug.JPA_PERSISTENCE;
import static tech.jhipster.lite.shared.slug.domain.JHLiteModuleSlug.JPA_MARIADB;
import static tech.jhipster.lite.shared.slug.domain.JHLiteModuleSlug.JPA_MSSQL;
import static tech.jhipster.lite.shared.slug.domain.JHLiteModuleSlug.JPA_MYSQL;
import static tech.jhipster.lite.shared.slug.domain.JHLiteModuleSlug.JPA_POSTGRESQL;
import static tech.jhipster.lite.shared.slug.domain.JHLiteModuleSlug.SPRING_BOOT;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tech.jhipster.lite.generator.server.springboot.database.jpa.application.JpaApplicationService;
import tech.jhipster.lite.module.domain.resource.JHipsterModuleOrganization;
import tech.jhipster.lite.module.domain.resource.JHipsterModulePropertiesDefinition;
import tech.jhipster.lite.module.domain.resource.JHipsterModuleResource;

@Configuration
class JpaModuleConfiguration {

  private static final String API_DOC_GROUP = "Spring Boot - Database";

  @Bean
  JHipsterModuleResource postgresqlModule(JpaApplicationService postgresql) {
    return JHipsterModuleResource.builder()
      .slug(JPA_POSTGRESQL)
      .propertiesDefinition(properties())
      .apiDoc(API_DOC_GROUP, "将JPA与Postgresql添加到项目中")
      .organization(organization())
      .tags(tags())
      .factory(postgresql::buildPostgresql);
  }

  @Bean
  JHipsterModuleResource mariaDBModule(JpaApplicationService applicationService) {
    return JHipsterModuleResource.builder()
      .slug(JPA_MARIADB)
      .propertiesDefinition(properties())
      .apiDoc(API_DOC_GROUP, "将JPA与MariaDB添加到项目中")
      .organization(organization())
      .tags(tags())
      .factory(applicationService::buildMariaDB);
  }

  @Bean
  JHipsterModuleResource mySQLModule(JpaApplicationService applicationService) {
    return JHipsterModuleResource.builder()
      .slug(JPA_MYSQL)
      .propertiesDefinition(properties())
      .apiDoc(API_DOC_GROUP, "将JPA与MySQL添加到项目中")
      .organization(organization())
      .tags(tags())
      .factory(applicationService::buildMySQL);
  }

  @Bean
  JHipsterModuleResource msSQLModule(JpaApplicationService applicationService) {
    return JHipsterModuleResource.builder()
      .slug(JPA_MSSQL)
      .propertiesDefinition(properties())
      .apiDoc(API_DOC_GROUP, "将JPA与MsSQL添加到项目中")
      .organization(organization())
      .tags(tags())
      .factory(applicationService::buildMsSQL);
  }

  private static JHipsterModulePropertiesDefinition properties() {
    return JHipsterModulePropertiesDefinition.builder()
      .addBasePackage()
      .addIndentation()
      .addProjectBaseName()
      .addSpringConfigurationFormat()
      .build();
  }

  private static JHipsterModuleOrganization organization() {
    return JHipsterModuleOrganization.builder().feature(JPA_PERSISTENCE).addDependency(SPRING_BOOT).build();
  }

  private static String[] tags() {
    return new String[] { "server", "spring", "spring-boot", "database" };
  }
}

package tech.jhipster.lite.generator.server.sonarqube.infrastructure.primary;

import static tech.jhipster.lite.shared.slug.domain.JHLiteFeatureSlug.CODE_COVERAGE_JAVA;
import static tech.jhipster.lite.shared.slug.domain.JHLiteFeatureSlug.JAVA_BUILD_TOOL;
import static tech.jhipster.lite.shared.slug.domain.JHLiteFeatureSlug.SONAR_QUBE_JAVA;
import static tech.jhipster.lite.shared.slug.domain.JHLiteModuleSlug.SONAR_QUBE_JAVA_BACKEND;
import static tech.jhipster.lite.shared.slug.domain.JHLiteModuleSlug.SONAR_QUBE_JAVA_BACKEND_AND_FRONTEND;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tech.jhipster.lite.generator.server.sonarqube.application.SonarQubeApplicationService;
import tech.jhipster.lite.module.domain.resource.JHipsterModuleOrganization;
import tech.jhipster.lite.module.domain.resource.JHipsterModulePropertiesDefinition;
import tech.jhipster.lite.module.domain.resource.JHipsterModuleResource;

@Configuration
class SonarQubeModuleConfiguration {

  @Bean
  JHipsterModuleResource sonarBackendModule(SonarQubeApplicationService sonar) {
    return JHipsterModuleResource.builder()
      .slug(SONAR_QUBE_JAVA_BACKEND)
      .propertiesDefinition(propertiesDefinition())
      .apiDoc("Sonar", "为Java后端添加Sonar配置以检查代码质量")
      .organization(
        JHipsterModuleOrganization.builder()
          .feature(SONAR_QUBE_JAVA)
          .addDependency(JAVA_BUILD_TOOL)
          .addDependency(CODE_COVERAGE_JAVA)
          .build()
      )
      .tags("server", "sonar")
      .factory(sonar::buildBackendModule);
  }

  @Bean
  JHipsterModuleResource sonarBackendFrontendModule(SonarQubeApplicationService sonar) {
    return JHipsterModuleResource.builder()
      .slug(SONAR_QUBE_JAVA_BACKEND_AND_FRONTEND)
      .propertiesDefinition(propertiesDefinition())
      .apiDoc("Sonar", "为Java后端和前端添加Sonar配置，以检查代码质量")
      .organization(
        JHipsterModuleOrganization.builder()
          .feature(SONAR_QUBE_JAVA)
          .addDependency(JAVA_BUILD_TOOL)
          .addDependency(CODE_COVERAGE_JAVA)
          .build()
      )
      .tags("server", "sonar")
      .factory(sonar::buildBackendFrontendModule);
  }

  private JHipsterModulePropertiesDefinition propertiesDefinition() {
    return JHipsterModulePropertiesDefinition.builder().addProjectName().addProjectBaseName().addIndentation().build();
  }
}

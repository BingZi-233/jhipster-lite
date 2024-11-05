package tech.jhipster.lite.generator.server.javatool.jacoco.infrastructure.primary;

import static tech.jhipster.lite.shared.slug.domain.JHLiteFeatureSlug.CODE_COVERAGE_JAVA;
import static tech.jhipster.lite.shared.slug.domain.JHLiteFeatureSlug.JAVA_BUILD_TOOL;
import static tech.jhipster.lite.shared.slug.domain.JHLiteModuleSlug.JACOCO;
import static tech.jhipster.lite.shared.slug.domain.JHLiteModuleSlug.JACOCO_WITH_MIN_COVERAGE_CHECK;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tech.jhipster.lite.generator.server.javatool.jacoco.application.JacocoApplicationService;
import tech.jhipster.lite.module.domain.resource.JHipsterModuleOrganization;
import tech.jhipster.lite.module.domain.resource.JHipsterModuleResource;

@Configuration
class JacocoModuleConfiguration {

  @Bean
  JHipsterModuleResource jacocoModule(JacocoApplicationService jacoco) {
    return JHipsterModuleResource.builder()
      .slug(JACOCO)
      .withoutProperties()
      .apiDoc("Java", "为代码覆盖率报告添加JaCoCo")
      .organization(JHipsterModuleOrganization.builder().feature(CODE_COVERAGE_JAVA).addDependency(JAVA_BUILD_TOOL).build())
      .tags("server", "tools", "coverage")
      .factory(jacoco::buildJacocoModule);
  }

  @Bean
  JHipsterModuleResource jacocoWithMinCoverageCheckModule(JacocoApplicationService jacoco) {
    return JHipsterModuleResource.builder()
      .slug(JACOCO_WITH_MIN_COVERAGE_CHECK)
      .withoutProperties()
      .apiDoc("Java", "添加JaCoCo以进行代码覆盖率报告和100%覆盖率检查")
      .organization(JHipsterModuleOrganization.builder().feature(CODE_COVERAGE_JAVA).addDependency(JAVA_BUILD_TOOL).build())
      .tags("server", "tools", "coverage")
      .factory(jacoco::buildJacocoWithMinCoverageCheckModule);
  }
}

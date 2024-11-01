package tech.jhipster.lite.generator.server.hexagonaldocumentation.infrastructure.primary;

import static tech.jhipster.lite.shared.slug.domain.JHLiteModuleSlug.APPLICATION_SERVICE_HEXAGONAL_ARCHITECTURE_DOCUMENTATION;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tech.jhipster.lite.generator.server.hexagonaldocumentation.application.HexagonalArchitectureDocumentationApplicationService;
import tech.jhipster.lite.module.domain.resource.JHipsterModuleResource;

@Configuration
class HexagonalArchitectureDocumentationModuleConfiguration {

  @Bean
  JHipsterModuleResource hexagonalArchitectureDocumentationModule(
    HexagonalArchitectureDocumentationApplicationService hexagonalArchitectureDocumentations
  ) {
    return JHipsterModuleResource.builder()
      .slug(APPLICATION_SERVICE_HEXAGONAL_ARCHITECTURE_DOCUMENTATION)
      .withoutProperties()
      .apiDoc("Documentation", "为六边形架构添加文档")
      .standalone()
      .tags("server", "documentation")
      .factory(hexagonalArchitectureDocumentations::buildModule);
  }
}

package tech.jhipster.lite.generator.server.javatool.frontendmaven.infrastructure.primary;

import static tech.jhipster.lite.shared.slug.domain.JHLiteFeatureSlug.CLIENT_CORE;
import static tech.jhipster.lite.shared.slug.domain.JHLiteFeatureSlug.FRONTEND_JAVA_BUILD_TOOL_PLUGIN;
import static tech.jhipster.lite.shared.slug.domain.JHLiteFeatureSlug.SPRING_SERVER;
import static tech.jhipster.lite.shared.slug.domain.JHLiteModuleSlug.FRONTEND_MAVEN_PLUGIN;
import static tech.jhipster.lite.shared.slug.domain.JHLiteModuleSlug.FRONTEND_MAVEN_PLUGIN_CACHE;
import static tech.jhipster.lite.shared.slug.domain.JHLiteModuleSlug.GRADLE_JAVA;
import static tech.jhipster.lite.shared.slug.domain.JHLiteModuleSlug.MAVEN_JAVA;
import static tech.jhipster.lite.shared.slug.domain.JHLiteModuleSlug.NODE_GRADLE_PLUGIN;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tech.jhipster.lite.generator.server.javatool.frontendmaven.application.FrontendJavaBuildToolApplicationService;
import tech.jhipster.lite.module.domain.resource.JHipsterModuleOrganization;
import tech.jhipster.lite.module.domain.resource.JHipsterModulePropertiesDefinition;
import tech.jhipster.lite.module.domain.resource.JHipsterModuleResource;

@Configuration
class FrontendJavaBuildToolModuleConfiguration {

  private static final String[] TAGS = { "server", "tools" };
  private static final String FRONTEND_JAVA_PLUGIN = "Frontend Java Plugin";

  @Bean
  JHipsterModuleResource frontendMavenModule(FrontendJavaBuildToolApplicationService frontendJavaBuildTool) {
    return JHipsterModuleResource.builder()
      .slug(FRONTEND_MAVEN_PLUGIN)
      .propertiesDefinition(JHipsterModulePropertiesDefinition.builder().addBasePackage().addProjectBaseName().addIndentation().build())
      .apiDoc(FRONTEND_JAVA_PLUGIN, "添加前端Maven插件")
      .organization(
        JHipsterModuleOrganization.builder()
          .feature(FRONTEND_JAVA_BUILD_TOOL_PLUGIN)
          .addDependency(SPRING_SERVER)
          .addDependency(CLIENT_CORE)
          .addDependency(MAVEN_JAVA)
          .build()
      )
      .tags(TAGS)
      .factory(frontendJavaBuildTool::buildFrontendMavenModule);
  }

  @Bean
  JHipsterModuleResource frontendMavenCacheModule(FrontendJavaBuildToolApplicationService frontendJavaBuildTool) {
    return JHipsterModuleResource.builder()
      .slug(FRONTEND_MAVEN_PLUGIN_CACHE)
      .propertiesDefinition(JHipsterModulePropertiesDefinition.EMPTY)
      .apiDoc(FRONTEND_JAVA_PLUGIN, "通过计算资源的校验和添加缓存，以避免在连续的maven构建中重建前端。")
      .organization(JHipsterModuleOrganization.builder().addDependency(FRONTEND_MAVEN_PLUGIN).build())
      .tags(TAGS)
      .factory(frontendJavaBuildTool::buildFrontendMavenCacheModule);
  }

  @Bean
  JHipsterModuleResource frontendGradleModule(FrontendJavaBuildToolApplicationService frontendJavaBuildTool) {
    return JHipsterModuleResource.builder()
      .slug(NODE_GRADLE_PLUGIN)
      .propertiesDefinition(JHipsterModulePropertiesDefinition.builder().addBasePackage().addProjectBaseName().addIndentation().build())
      .apiDoc(FRONTEND_JAVA_PLUGIN, "添加node-gradle插件以使用Gradle构建前端")
      .organization(
        JHipsterModuleOrganization.builder()
          .feature(FRONTEND_JAVA_BUILD_TOOL_PLUGIN)
          .addDependency(SPRING_SERVER)
          .addDependency(CLIENT_CORE)
          .addDependency(GRADLE_JAVA)
          .build()
      )
      .tags(TAGS)
      .factory(frontendJavaBuildTool::buildFrontendGradleModule);
  }
}

package tech.jhipster.lite.generator.server.webjars.infrastructure.primary;

import static tech.jhipster.lite.shared.slug.domain.JHLiteModuleSlug.ALPINE_JS_WEBJARS;
import static tech.jhipster.lite.shared.slug.domain.JHLiteModuleSlug.HTMX_WEBJARS;
import static tech.jhipster.lite.shared.slug.domain.JHLiteModuleSlug.SPRING_BOOT_THYMELEAF;
import static tech.jhipster.lite.shared.slug.domain.JHLiteModuleSlug.WEBJARS_LOCATOR;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tech.jhipster.lite.generator.server.webjars.application.WebjarsApplicationService;
import tech.jhipster.lite.module.domain.resource.JHipsterModuleOrganization;
import tech.jhipster.lite.module.domain.resource.JHipsterModulePropertiesDefinition;
import tech.jhipster.lite.module.domain.resource.JHipsterModuleResource;

@Configuration
class WebjarsModuleConfiguration {

  private static final String SERVER_TAG = "server";
  private static final String WEB_TAG = "web";
  private static final String WEBJARS_GROUP = "WebJars";

  @Bean
  public JHipsterModuleResource webjarsLocatorModule(WebjarsApplicationService webjarsModule) {
    return JHipsterModuleResource.builder()
      .slug(WEBJARS_LOCATOR)
      .propertiesDefinition(
        JHipsterModulePropertiesDefinition.builder().addBasePackage().addProjectBaseName().addSpringConfigurationFormat().build()
      )
      .apiDoc(WEBJARS_GROUP, "将webjars定位器添加到项目中")
      .organization(JHipsterModuleOrganization.builder().addDependency(SPRING_BOOT_THYMELEAF).build())
      .tags(SERVER_TAG, WEB_TAG)
      .factory(webjarsModule::buildWebjarsLocatorModule);
  }

  @Bean
  public JHipsterModuleResource webjarsHtmxModule(WebjarsApplicationService webjarsModule) {
    return JHipsterModuleResource.builder()
      .slug(HTMX_WEBJARS)
      .propertiesDefinition(
        JHipsterModulePropertiesDefinition.builder().addBasePackage().addProjectBaseName().addSpringConfigurationFormat().build()
      )
      .apiDoc(WEBJARS_GROUP, "将HTMX webjar添加到项目中")
      .organization(JHipsterModuleOrganization.builder().addDependency(WEBJARS_LOCATOR).build())
      .tags(SERVER_TAG, WEB_TAG)
      .factory(webjarsModule::buildWebjarsHtmxModule);
  }

  @Bean
  public JHipsterModuleResource webjarsAlpineJSModule(WebjarsApplicationService webjarsModule) {
    return JHipsterModuleResource.builder()
      .slug(ALPINE_JS_WEBJARS)
      .propertiesDefinition(
        JHipsterModulePropertiesDefinition.builder().addBasePackage().addProjectBaseName().addSpringConfigurationFormat().build()
      )
      .apiDoc(WEBJARS_GROUP, "将alpine.js webjar添加到项目中")
      .organization(JHipsterModuleOrganization.builder().addDependency(WEBJARS_LOCATOR).build())
      .tags(SERVER_TAG, WEB_TAG)
      .factory(webjarsModule::buildWebjarsAlpineJSModule);
  }
}

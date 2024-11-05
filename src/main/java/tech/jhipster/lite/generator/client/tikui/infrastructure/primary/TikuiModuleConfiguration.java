package tech.jhipster.lite.generator.client.tikui.infrastructure.primary;

import static tech.jhipster.lite.shared.slug.domain.JHLiteFeatureSlug.CLIENT_CORE;
import static tech.jhipster.lite.shared.slug.domain.JHLiteModuleSlug.TIKUI;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tech.jhipster.lite.generator.client.tikui.application.TikuiApplicationService;
import tech.jhipster.lite.module.domain.resource.JHipsterModuleOrganization;
import tech.jhipster.lite.module.domain.resource.JHipsterModuleResource;

@Configuration
class TikuiModuleConfiguration {

  @Bean
  JHipsterModuleResource tikuiModule(TikuiApplicationService tikui) {
    return JHipsterModuleResource.builder()
      .slug(TIKUI)
      .withoutProperties()
      .apiDoc("Frontend", "添加Tikui，一个用于构建样式的模式库")
      .organization(JHipsterModuleOrganization.builder().addDependency(CLIENT_CORE).build())
      .tags("client", "frontend", "tikui")
      .factory(tikui::buildModule);
  }
}

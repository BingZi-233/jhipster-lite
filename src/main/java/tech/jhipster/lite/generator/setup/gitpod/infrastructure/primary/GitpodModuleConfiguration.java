package tech.jhipster.lite.generator.setup.gitpod.infrastructure.primary;

import static tech.jhipster.lite.shared.slug.domain.JHLiteModuleSlug.GITPOD;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tech.jhipster.lite.generator.setup.gitpod.application.GitpodApplicationService;
import tech.jhipster.lite.module.domain.resource.JHipsterModuleResource;

@Configuration
class GitpodModuleConfiguration {

  @Bean
  JHipsterModuleResource gitpodModule(GitpodApplicationService gitPods) {
    return JHipsterModuleResource.builder()
      .slug(GITPOD)
      .withoutProperties()
      .apiDoc("Development environment", "初始化Gitpod配置文件")
      .standalone()
      .tags("setup", "gitpod")
      .factory(gitPods::buildModule);
  }
}

package tech.jhipster.lite.generator.setup.infinitest.infrastructure.primary;

import static tech.jhipster.lite.shared.slug.domain.JHLiteModuleSlug.INFINITEST_FILTERS;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tech.jhipster.lite.generator.setup.infinitest.application.InfinitestApplicationService;
import tech.jhipster.lite.module.domain.resource.JHipsterModuleResource;

@Configuration
class InfinitestModuleConfiguration {

  @Bean
  JHipsterModuleResource infinitestModule(InfinitestApplicationService infinitest) {
    return JHipsterModuleResource.builder()
      .slug(INFINITEST_FILTERS)
      .withoutProperties()
      .apiDoc("Development environment", "为infinitest添加过滤器，这是一个持续测试运行器")
      .standalone()
      .tags("server", "init", "test")
      .factory(infinitest::build);
  }
}

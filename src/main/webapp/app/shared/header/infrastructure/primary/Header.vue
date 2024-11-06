<template>
  <header class="jhlite-header">
    <div class="jhlite-header--slot jhlite-with-theme-switch">
      <router-link class="jhlite-logo" to="/">
        <img class="jhlite-logo--icon" src="../../../../../content/JHipster-Lite-neon-blue.png" alt="JHipster bow tie" width="48" />
        <span class="jhlite-logo--text">JHipster Lite zh_CN</span>
        <span class="jhlite-logo-version--text">{{ version }}</span>
      </router-link>
      <ThemeButtonVue />
    </div>
    <div class="jhlite-header--slot -expand"></div>
    <div class="jhlite-header--slot">
      <nav aria-label="Main navigation">
        <ul class="jhlite-nav">
          <li class="jhlite-nav--item">
            <router-link class="jhlite-nav-item" to="/landscape">
              <span class="jhlite-icon-text">
                <span class="jhlite-icon-text--icon">
                  <IconVue name="map" aria-label="Icon map" title="Module landscape" />
                </span>
                <span class="jhlite-icon-text--text">地图</span>
              </span>
            </router-link>
          </li>
          <li class="jhlite-nav--item">
            <router-link class="jhlite-nav-item" to="/patches">
              <span class="jhlite-icon-text">
                <span class="jhlite-icon-text--icon">
                  <IconVue name="puzzle" aria-label="Icon puzzle" title="Patch list" />
                </span>
                <span class="jhlite-icon-text--text">列表</span>
              </span>
            </router-link>
          </li>
        </ul>
      </nav>
    </div>
  </header>
</template>

<script lang="ts" src="./Header.component.ts"></script>

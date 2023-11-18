<script lang="ts" setup>

import { useProjectStore } from "../stores/ProjectStore";
import EnvironmentList from "./EnvironmentList.vue";
import { ref } from "vue";


let projname = ref("");
let show = ref(false);

function open(projectName: string) {
  projname.value = projectName;
  show.value = true
}

</script>

<template>
  <p>PROJECTS</p>
  <button @click="useProjectStore().load()">LOAD</button>
  <v-list :lines="'one'">
    <v-list-item
        v-for="project in useProjectStore().projects"
        :key="project.name"
        @click="open(project.name)"
    >
      <v-list-item-title>{{ project.name }}</v-list-item-title>
      <v-list-subheader class="ellipsize">{{ project.environments.map(e => e.name).join(", ") }}</v-list-subheader>
      <v-list-item-action>
        <v-icon icon="mdi-arrow-right"/>
      </v-list-item-action>
    </v-list-item>
  </v-list>
  {{ show }}
  <EnvironmentList v-if="show" :project-name="projname"/>
</template>

<style scoped>
.ellipsize {
  text-overflow-ellipsis: true;
}
</style>
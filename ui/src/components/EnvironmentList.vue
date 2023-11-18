<script lang="ts" setup>

import { useProjectStore } from "../stores/ProjectStore";
import CmsKeysTable from "./CmsKeysTable.vue";
import { ref, watch } from "vue";

interface Props {
  projectName: string;
}

const props = defineProps<Props>();

let cmsitems = ref([]);
const show = ref(false);

let items = ref([]);
watch(() => props.projectName, () => {
  items.value = useProjectStore().getEnvironments(props.projectName)
})


function open(environmentName: string) {
  const environment = useProjectStore().getEnvironments(props.projectName).find(e => e.name == environmentName)
  cmsitems.value = environment.keys;
  show.value = true
}
</script>

<template>
  {{ props.projectName }}
  <p>ENVS</p>
  <v-list :lines="'one'">
    <v-list-item
        v-for="environment in items"
        :key="environment.name"
        :title="`${environment.name}`"
        @click="open(environment.name)"
    />
  </v-list>
  <CmsKeysTable v-if="show" :items="cmsitems"/>
</template>

<style scoped>

</style>
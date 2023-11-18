<script lang="ts" setup>

import { CmsKey } from "../stores/ProjectStore";

interface Props {
  items: Array<CmsKey>
}

const props = defineProps<Props>();

</script>

<template>
  <p>CMS</p>
  <v-data-table :items="props.items">
    <template v-slot:item="row">
      <tr>
        <td>{{ row.key }}</td>
        <td>{{ row.value }}</td>
        <v-btn class="mx-2" icon="mdi-delete" variant="plain" @click="console.log('CLICK')">
        </v-btn>
      </tr>
    </template>
  </v-data-table>
</template>

<style scoped>

</style>
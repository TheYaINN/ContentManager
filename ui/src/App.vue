<script setup>
import ProjectList from "./components/ProjectList.vue";

const items = [
  {
    key: "view.test.myspace.com",
    value: "Hier steht meine Werbung" + 10,
    ValidFrom: new Date(2022, 1, 1),
  },
]

</script>

<template>
  <ProjectList/>
</template>

<style scoped>

</style>

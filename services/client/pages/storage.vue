<template>
  <div class="index">
    Warehouse:
    {{ data }}
  </div>
</template>

<script setup>
const { data, pending, error, refresh } = await useAsyncData(
  'storage',
  () => $fetch('/api/storage')
);

</script>

<style scoped>
.index {
  display: flex;
  flex-direction: column;
}
</style>

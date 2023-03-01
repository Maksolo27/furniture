<template>
  <div class="index">
    Orders:
    {{ data }}
  </div>
</template>

<script setup>
const { data, pending, error, refresh } = await useAsyncData(
  'order',
  () => $fetch('/api/order')
);

</script>

<style scoped>
.index {
  display: flex;
  flex-direction: column;
}
</style>

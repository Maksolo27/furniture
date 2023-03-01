<template>
  <div class="index">
    Customers:
    {{ data }}
  </div>
</template>

<script setup>
const { data, pending, error, refresh } = await useAsyncData(
  'buyer',
  () => $fetch('/api/buyer')
);

</script>

<style scoped>
.index {
  display: flex;
  flex-direction: column;
}
</style>

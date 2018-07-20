<template>
  <div class="cat-story">{{count}}</div>
</template>

<script>
export default {
  computed: {
    count () {
      return this.$store.state.count
    }
  }
}
</script>

<style scoped>

</style>

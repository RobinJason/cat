<template>
  <div class="publish">
    <cat-tab></cat-tab>
    <keep-alive>
      <component v-bind:is="currentTabName"></component>
    </keep-alive>
  </div>
</template>

<script>
import catStory from './catStory/catStory'
import findMaster from './findMaster/findMaster'
import catTab from '../common/catTab'
export default {
  data () {
    return {
      currentTabName: 'cat-story'
    }
  },
  components: {
    'cat-story': catStory,
    'find-master': findMaster,
    'cat-tab': catTab
  }
}
</script>

<style scoped>

</style>

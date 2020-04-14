<template>
  <div id="app">
    <Menu></Menu>
    <Play></Play>
  </div>
</template>

<script>
import Menu from './components/Menu.vue'
import Play from './components/Play.vue'

export default {
  name: 'App',
  components: {
    Menu,
    Play
  }
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>

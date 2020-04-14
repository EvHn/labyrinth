<template>
    <div class="Play">
        <button @click="getLevels()">play</button>
        <li v-for="level in levels" :key="level.name">
            <button>{{ level.name }}</button>
        </li>
    </div>
</template>

<script>
import api from './api'

export default {
    name: 'play',

    data() {
        return {
            text: 'play',
            levels: [],
            errors: []
        }
    },
    methods: {
        getLevels() {
            api.levels().then(response => {
                this.levels = response.levels
            }).catch(error => {
                this.errors.push(error)
            })
        }
    }
    
}
</script>
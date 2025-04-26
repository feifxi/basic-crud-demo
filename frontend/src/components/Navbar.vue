<script setup>
import { RouterLink } from 'vue-router'

</script>

<template>
    <header class="flex justify-between bg-black text-white py-4 px-8 gap-3">
        <RouterLink to="/" class="text-xl">Stupid Navbar</RouterLink>

        <nav class="flex gap-3">
            <RouterLink to="/create">Create</RouterLink>
        </nav>
    </header>
</template>

<style scoped></style>
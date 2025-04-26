<script setup>
import { RouterLink } from 'vue-router';

defineProps({
    product: Object,
    deleteProduct: Function
})

</script>

<template>
    <div class="border p-4 rounded-xl shadow-xl">
        <div class="flex gap-3 text-white">
            <RouterLink :to="'/update/' + product.id"  class="bg-green-500 p-3">Edit</RouterLink>
            <button class="bg-red-500 cursor-pointer p-3" @click="() => { deleteProduct(product.id) }">Delete</button>
        </div>
        <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQVI7iew5aWD4H2GJM9_11WawobDoWehGJynw&s" alt=""
            class="size-50 object-cover mb-4">
        <h2 class="text-xl font-bold">{{ 'Product Name : ' + product.name }}</h2>
        <p class="text-lg font-semibold">{{ "Price $" + product.price }}</p>
    </div>
</template>
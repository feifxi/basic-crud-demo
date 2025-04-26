<script setup>
import ProductCard from '@/components/ProductCard.vue';
import { onMounted, onUnmounted, onUpdated, ref } from 'vue';

const BASE_API = import.meta.env.VITE_BASE_API

const products = ref([])
const isLoading = ref(false)

const fetchProducts = async () => {
  isLoading.value = true
  try {
    const res = await fetch(`${BASE_API}/api/products`)
    if (!res.ok) {
      throw new Error('Something went wrong')
    }
    const data = await res.json()
    products.value = data
  } catch (error) {
    console.error('Error fetching products:', error)
  }
  isLoading.value = false
}

const deleteProduct = async (id) => {
  try {
    const res = await fetch(`${BASE_API}/api/products/${id}`, {
      method: 'DELETE'
    }) 
    if (!res.ok) {
      throw new Error('Something went wrong')
    }
    alert('Product deleted successfully')
    await fetchProducts()
  } catch (error) {
    console.error('Error deleting product:', error)
    alert('Error deleting product')
  }
}

onMounted(async () => {
  await fetchProducts()
})
</script>

<template >
  <main v-if="isLoading" class="text-4xl font-bold flex justify-center items-center h-screen">
    Loading...
  </main>

  <main v-else>
    <div class="grid grid-cols-1 sm:grid-cols-3 gap-4 p-4">
      <ProductCard v-for="product of products" 
        :key="product.id"
        :product="product"
        :deleteProduct="deleteProduct"
      />
    </div>
  </main>
</template>

<script setup>
import { onMounted, reactive, ref } from 'vue';
import { useRouter, useRoute } from 'vue-router';

const BASE_API = import.meta.env.VITE_BASE_API
const route = useRoute()
const router = useRouter()
const id = route.params.id

const product = ref({
  name: '',
  price: ''
});

const fetchProduct = async () => {
  try {
    const res = await fetch(`${BASE_API}/api/products/${id}`)
    if (!res.ok) {
      throw new Error('Something went wrong')
    }
    const data = await res.json()
    product.value = data
  } catch (error) {
    console.error('Error fetching product:', error)
  }
}

const submitForm = async (e) => {
  e.preventDefault();
  if (!product.value.name || !product.value.price) {
    alert('Please fill in all fields');
    return;
  }

  try {
    const res = await fetch(`${BASE_API}/api/products/${id}`, {
      method: 'PUT',
      headers: {
        'Content-Type': 'application/json'
      },
      body: JSON.stringify(product.value)
    });
    if (!res.ok) {
      throw new Error('Something went wrong');
    }
    const data = await res.json();
    console.log('Product updated:', data);
    router.push('/'); // Redirect to home page after creating product
  } catch (error) {
    console.error('Error updating product:', error);
    alert('Error updating product. Please try again.');
  }
};

onMounted(async () => {
  await fetchProduct()
})
</script>

<template>
  <main class="p-5">
    <h1 class="text-3xl font-bold text-center">Update Product {{ id }}</h1>
    <form class="flex flex-col gap-4 p-4" @submit="submitForm">
      <input type="text" placeholder="Product Name" class="border p-2 rounded-xl shadow-xl" v-model="product.name" />
      <input type="text" placeholder="Product Price" class="border p-2 rounded-xl shadow-xl" v-model="product.price" />

      <button class="border bg-black text-white p-3 cursor-pointer rounded">Update</button>
    </form>
  </main>
</template>
<script setup>
import { ref, onMounted } from 'vue';
import { useRouter, useRoute } from 'vue-router';
import Navbar from '../components/Navbar.vue';
import axios from 'axios';
const article = ref({
    title: '',
    content: '',
    publication_date: '',
    last_update: ''
});
const router = useRouter();
const createArticle = () => {
    article.publication_date = new Date(article.value.publication_date).toISOString();
    article.last_update = new Date(article.value.last_update).toISOString();

    axios
        .post('http://localhost:8080/articles', article.value)
        .then(() => {
            alert('Article created successfully');

        })
        .catch(error => {
            console.error('Error creating article:', error);
            if (error.response) {
                console.error('Response data:', error.response.data);
            }
        });
};
</script>

<template>
    <main>
        <Navbar />

        <div class="my-5">
            <div class="mx-auto w-50" style="max-width: 100%;">
                <h2 class="text-center mb-3">New Article</h2>
                <form @submit.prevent="createArticle">
                    <div class="form-group mb-3">
                        <label for="title" class="form-label">Title</label>
                        <input id="title" type="text" name="title" class="form-control" placeholder="Article Title" required
                            v-model="article.title" />
                    </div>
                    <div class="form-group mb-3">
                        <label for="content" class="form-label">Content</label>
                        <textarea id="content" name="content" class="form-control" placeholder="Article Content" required
                            v-model="article.content"></textarea>
                    </div>
                    <div class="form-group d-flex justify-content-center align-items-center">
                    <div class="mr-3">
                        <label for="publicationDate" class="form-label">Publication Date</label>
                        <input id="publicationDate" type="date" name="publicationDate" class="form-control" required
                            v-model="article.publication_date" />
                    </div>
                    <div >
                        <label for="lastUpdate" class="form-label">Last Update</label>
                        <input id="lastUpdate" type="date" name="lastUpdate" class="form-control" required
                            v-model="article.last_update" />
                    </div>
                    </div>  
                    <div class="form-group">
                        <input class="btn btn-primary w-100" type="submit" value="Create Article" />
                    </div>
                </form>
            </div>
        </div>
    </main>
</template>


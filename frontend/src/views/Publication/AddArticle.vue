<script setup>
import { ref } from 'vue';
import { useRouter } from 'vue-router';
import Navbar from '@/components/Navbar.vue';
import Footer from '@/components/Footer.vue';
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
        .post('http://localhost:8080/api/createArticle', article.value)
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
        <div class="main-container">
            <div class="page-wrapper">

                <div class="my-5">
                    <div class="mx-auto w-75">
                        <h2 class="text-center mb-4">Create a New Article</h2>
                        <form @submit.prevent="createArticle">
                            <div class="form-group">
                                <label for="title" class="form-label">Title</label>
                                <input id="title" type="text" name="title" class="form-control" placeholder="Article Title"
                                    required v-model="article.title" />
                            </div>
                            <div class="form-group">
                                <label for="content" class="form-label">Content</label>
                                <textarea id="content" name="content" class="form-control" placeholder="Article Content"
                                    required v-model="article.content" rows="16"></textarea>
                            </div>
                            <div class="form-group d-flex justify-content-between">
                                <div class="mr-3">
                                    <label for="publicationDate" class="form-label">Publication Date</label>
                                    <input id="publicationDate" type="date" name="publicationDate" class="form-control"
                                        required v-model="article.publication_date" />
                                </div>
                                <div>
                                    <label for="lastUpdate" class="form-label">Last Update</label>
                                    <input id="lastUpdate" type="date" name="lastUpdate" class="form-control" required
                                        v-model="article.last_update" />
                                </div>
                            </div>
                            <div class="form-group">
                                <button class="btn btn-light bg-light w-100" type="submit">
                                    <i class="bi bi-check-circle"></i> Publish
                                </button>
                            </div>
                        </form>
                    </div>                    
               
                </div>
            </div>
            <Footer />
        </div>
    </main>
</template>

<style scoped>
.main-container {
    position: fixed;
    top: 5rem;
    left: 12rem;
    display: flex;
    flex-direction: column;
    width: 80%;
    padding: 1em;
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.3);
    border-radius: 8px;
}

.page-wrapper {
    display: flex;
    flex-direction: column;
    height: 90vh;
    font-family: 'Courier New', Courier, monospace;
    color: whitesmoke;
    font-size: larger;
    overflow-y: auto;
}

.form-group {
    margin-bottom: 10px;
}

.form-label {
    font-weight: bold;
    font-size: 18px;
}

.form-control {
    border: 2px solid #0096c7;
    border-radius: 5px;
    padding: 10px;
    font-size: 16px;
}

textarea {
    resize: vertical;
}
</style>

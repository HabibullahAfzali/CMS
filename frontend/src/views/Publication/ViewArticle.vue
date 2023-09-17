
<script setup>
import axios from 'axios';
import { ref, onMounted } from 'vue';
import Navbar from '@/components/Navbar.vue';
import Footer from '@/components/Footer.vue';

const articles = ref([]);

const formatDate = (date) => new Date(date).toLocaleDateString();

const truncatedContent = (content) => (content.length > 100 ? content.slice(0, 100) + '...' : content);

const toggleExpand = (article) => {
    article.expanded = !article.expanded;
};

const fetchArticles = async () => {
    try {
        const response = await axios.get('http://localhost:8080/api/getArticles'); 
        articles.value = response.data.map((article) => ({
            ...article,
            expanded: false,
        }));
    } catch (error) {
        console.error('Error fetching articles:', error);
    }
};

onMounted(() => {
    fetchArticles();
});
</script>

<template>
    <div class="page-wrraper">
    <main>
        <Navbar />
        <div class="container mt-5">
            <h2 class="text-center mb-4">Articles</h2>
            <div class="row">
                <div class="col-md-4 mb-4" v-for="article in articles" :key="article.id">
                    <div class="card">
                        <div class="card-body">
                            <h5 class="card-title">{{ article.title }}</h5>
                            <p class="card-text">
                                {{ truncatedContent(article.content) }}
                                <span v-if="article.content.length > 100" class="read-more-link"
                                    @click="toggleExpand(article)">
                                    Read More
                                </span>
                            </p>
                            <p class="card-text">
                                Publication Date: {{ formatDate(article.publication_date) }}
                            </p>
                            <p class="card-text">
                                Last Update: {{ formatDate(article.last_update) }}
                            </p>
                        </div>
                        <div v-if="article.expanded" class="card-footer text-center">
                            <span class="read-more-link" @click="toggleExpand(article)">
                                close
                            </span>
                            <div class="expanded-content">
                                {{ article.content }}
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </main>
    <Footer />
    </div>
</template>

<style scoped>
.card {
    border: 1px solid #2c2a2a;
}

.card-title {
    font-size: 1.2rem;
}

.card-text {
    font-size: 1rem;
}

.read-more-link {
    cursor: pointer;
    color: #007bff;
    text-decoration: underline;
}

.expanded-content {
    margin-top: 10px;
}
</style>
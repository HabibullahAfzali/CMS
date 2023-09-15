
<script>
import axios from 'axios';
import Navbar from '../components/Navbar.vue';

export default {
  components: { Navbar },
    name: 'ArticleList',
    data() {
        return {
            articles: []
        };
    },
    methods: {
        formatDate(date) {
            return new Date(date).toLocaleDateString();
        },
        truncatedContent(content) {
            return content.length > 100 ? content.slice(0, 100) + '...' : content;
        },
        toggleExpand(article) {
            article.expanded = !article.expanded;
        },
        fetchArticles() {
            axios
                .get('http://localhost:8080/articles') // Adjust the URL as needed
                .then(response => {
                    this.articles = response.data.map(article => ({
                        ...article,
                        expanded: false
                    }));
                })
                .catch(error => {
                    console.error('Error fetching articles:', error);
                });
        }
    },
    created() {
        this.fetchArticles();
    }
};
</script>
<template>
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

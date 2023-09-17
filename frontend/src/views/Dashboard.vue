<script setup>
import { ref } from 'vue';
import Navbar from '../components/Navbar.vue'
import Footer from '../components/Footer.vue'

const views = ref([
    {
        title: 'User Details',
        description: 'Display all registered users.',
        route: '/ViewUser',
    },
    {
        title: 'Assign roles to users',
        route: '/roleassign',
    },
    {
        title: 'Articles',
        description: 'All published articles.',
        route: '/Viewarticle',
    },
]);
</script>
<template>
    <div class="page-wrapper">
        <main>
            <Navbar />
            <div class="dashboard">
                <div class="jumbotron jumbotron-fluid text-dark text-center">
                    <div class="container">
                        <h1 class="display-4">Welcome to Your Dashboard</h1>
                        <p class="lead">CMS Control Panel.</p>
                    </div>
                </div>
                <div class="container">
                    <div class="row">
                        <router-link v-for="(view, index) in views" :key="index" :to="view.route" class="col-md-4"
                            style="text-decoration: none;">
                            <div class="card mb-4">
                                <div class="card-body">
                                    <h5 class="card-title">{{ view.title }}</h5>
                                    <p class="card-text">{{ view.description }}</p>
                                </div>
                            </div>
                        </router-link>
                    </div>
                </div>
            </div>
        </main>
        <Footer />
    </div>
</template>

<style scoped>
.dashboard {
    position: relative;
    margin: 4rem;
    padding: 10px;
    font-family: 'Courier New', Courier, monospace;
}



.card {
    margin: 3rem;
    background-color: #48cae4;
    font-family: 'Courier New', Courier, monospace;
    color: black;
    text-align: center;
    text-decoration: none;
    transition: transform 0.3s ease;
    width: 30vh;
    height: 10rem;
    display: flex;
    flex-direction: column;
    justify-content: center;
    border-radius: 5%;
    box-shadow: 0 0 10px #0096c7;
}

.card:hover {
    transform: scale(1.1);
    border: 2px solid rgb(143, 43, 7);
}
</style>

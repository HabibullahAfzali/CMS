<script setup>
import { ref } from 'vue';

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

        <footer>
            <div class="footer-content">
                <div class="footer-icons">
                </div>
                <p>&copy; 2023 CMS. All rights reserved.</p>
            </div>
        </footer>
    </div>
</template>

<style scoped>
.dashboard {
    margin: 4rem;
    padding: 10px;
    font-family: 'Courier New', Courier, monospace;
}



.card {
    margin: 3rem;
    background-color: #0096c7;
    font-family: 'Courier New', Courier, monospace;
    color: white;
    text-align: center;
    text-decoration: none;
    transition: transform 0.3s ease;
    width: 30vh;
    height: 10rem;
    display: flex;
    flex-direction: column;
    justify-content: center;
    border-radius: 5%;
    box-shadow: 0 0 10px whitesmoke;
}

.card:hover {
    transform: scale(1.1);
    border: 2px solid white;
}

.page-wrapper {
    display: flex;
    flex-direction: column;
    min-height: 100vh;
}

footer {
    background-color: #0096c7;
    color: whitesmoke;
    text-align: center;
    height: 6rem;
    padding: 10px 0;
    margin-top: auto;
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.3);
    overflow-y: auto;
}

.footer-content {
    margin:1rem;
    font-family: 'Courier New', Courier, monospace;
    font-size:large;
    display: flex;
    flex-direction: column;
    align-items: center;

}

.footer-icons {
    color: gold;
}

footer p {
    margin: 0;
}</style>

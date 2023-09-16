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
        <header>
            <!-- Header content goes here -->
            <div class="header-content">
                <router-link to="/" class="navbar-brand">
                    <img src="../assets/Images/logo3.jpg" alt="Logo" class="logo-img">
                </router-link>
                <div class="header-icons">
                </div>
            </div>
        </header>

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
    padding: 20px;
}

.logo-img {
    max-height: 45px;
    margin-right: 10px;
    border-radius: 10%;
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.3);
}

.card {
    margin: 2rem;
    background-color: black;
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
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.6);
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

/* Style the header */
header {
    background-color: white;
    border: 2px solid whitesmoke;
    padding: 20px;
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.3);
    border-radius: 8px;
    overflow-y: auto;
}

.header-content {
    display: flex;
    flex-direction: row;
    align-items: center;
}

.logo {
    max-width: 100px;
}

.header-icons {
    margin-top: 10px;
}

footer {
    background-color: white;
    color: black;
    text-align: center;
    padding: 10px 0;
    margin-top: auto;
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.3);
    overflow-y: auto;
    /* Push the footer to the bottom of the page */
}

.footer-content {
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

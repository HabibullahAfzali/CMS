<script setup>
import { ref, computed } from 'vue';
import Navbar from './Navbar.vue'
import Footer from './Footer.vue'
import store from '../store/store';

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
const storeUsert = computed(() =>
    store.state.user
);
</script>
<template>
    <div class="page-wrapper">
        <main>
            <Navbar />
            <div class="dashboard">
                <div class="jumbotron jumbotron-fluid text-dark text-center">
                    <div class="container">
                        <h1 class="display-4">Welcome to Dashboard</h1>
                        <p class="lead">CMS Control Panel.</p>
                    </div>
                     <div v-if="storeUser" class="mt-3">
                <p>User Role:</p>
                <p>{{ storeUser.role }}</p>
            </div>
                </div>
                <div class="container">
                    <div class="row">
                        <router-link v-for="(view, index) in views" :key="index" :to="view.route" class="col-md-4"
                            style="text-decoration: none;">
                            <div class="card mb-4">
                                <div class="card-body">
                                    <h5 class="card-title">{{ view.title }}</h5>
                                    <h6 class="card-text">{{ view.description }}</h6>
                                </div>
                            </div>
                        </router-link>
                    </div>
                </div>
            </div>
        </main>
    </div>
</template>

<style scoped>
.dashboard {
    position: relative;
    margin: 4rem;
    padding: 10px;
    font-family: 'Courier New', Courier, monospace;
}
h1{
    color: whitesmoke;
   
}
p{
     color: whitesmoke;
    font-size: 1.5rem;
}

.page-wrapper::before {
    content: "";
    background-image: url('../assets/Images/dashboard.jpg');
    opacity: 40%;
    position: absolute;
    top: 0;
    left: 0;
    width: 100%;
    height: 100%;
    border-radius: 1rem;
    z-index: -1; /* Place it behind the content */
}

.card {
    margin: 3rem;
    background-color: #00b4d8;
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

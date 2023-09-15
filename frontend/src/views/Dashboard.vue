<script>
import Navbar from '../components/Navbar.vue';
export default {
     name: 'Dashboard',
    components: {
        Navbar
    },
    data() {
        return {
            views: [
                {
                    title: 'User Details',
                    description: 'Display all resgistred users.',
                    route: '/ViewUser'
                },
                {
                    title: 'Add New User',
                    description: 'Click here to resgistred a new user.',
                    route: '/adduser'
                },
                {
                    title: 'Articles',
                    description: 'all published articles.',
                    route: '/Viewarticle'
                },
            ]
        };
    }
};
</script>
<template>
    <main>
        <Navbar />
        <div class="dashboard">
            <div class="jumbotron jumbotron-fluid  text-dark text-center">
                <div class="container">
                    <h1 class="display-4">Welcome to Your Dashboard</h1>
                    <p class="lead">CMS Control Panel.</p>
                </div>
            </div>
            <div class="container">
                <div class="row">
                    <div class="col-md-4" v-for="(view, index) in views" :key="index">
                        <div class="card mb-4">
                            <div class="card-body">
                                <h5 class="card-title">{{ view.title }}</h5>
                                <p class="card-text">{{ view.description }}</p>
                                <router-link :to="view.route" class="btn btn-light">{{ view.title }}</router-link>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </main>
</template>

<style scoped>
.dashboard {
    padding: 20px;
}
.card{
    background-color: black;
    color:white;
    
   
}
</style>

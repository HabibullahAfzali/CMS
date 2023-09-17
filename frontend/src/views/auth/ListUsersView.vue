<script setup>
import { ref, onMounted } from 'vue';
import Navbar from '@/components/Navbar.vue';
import { useRouter } from 'vue-router';
import axios from 'axios';

const registeredUsers = ref([]);
const router = useRouter();

const getUser = onMounted(async () => {
    try {
        const response = await axios.get('http://localhost:8080/api/users');
        registeredUsers.value = response.data.map(user => {

            if (user.profilePicture) {
                user.profilePicture = `http://localhost:8080/Images/${user.profilePicture}`;
            } else {
                user.profilePicture = "";
            }
            return user;
        });
    } catch (error) {
        console.error('Error fetching registered users:', error);
    }
});
const deleteUsers = (id) => {
    axios
        .delete(`http://localhost:8080/api/deleteUser/${id}`)
        .then(() => {
            getUser();
        })
        .catch((error) => {
            console.error('an error occured:', error);
        });
};
</script>
<template>
    <main>
        <Navbar />
        <div class="container mt-5">
            <div class="row justify-content-center">
                <div class="col-md-4 mb-4" v-for="(user, index) in registeredUsers" :key="index">
                    <div class="card">
                        <div class="card-body text-center">
                            <div class="profile-picture">
                                <img :src="user.profilePicture" :alt="user.profilePicture ? '' : user.username"
                                    class="rounded-circle img-fluid" />
                            </div>
                            <h5 class="card-title mt-3">{{ user.username }}</h5>
                            <p class="card-text">{{ user.email }}</p>
                            <p class="card-text">{{ user.roles.map(role => role.name).join(',') }}</p>
                            <div class="mt-3 user-card-buttons">
                                <router-link  class="btn btn-light" tag="button" :to="`/update/${user.id}`">
                                    <i class="bi bi-pencil"></i>
                                </router-link>
                                <button @click="deleteUsers(user.id)" class="btn btn-dark">
                                    <i class="vi bi-trash"></i>
                                </button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </main>
</template>
<style scoped>
.profile-picture {
    width: 120px;
    height: 120px;
    border-radius: 50%;
    overflow: hidden;
    margin: 0 auto;
    border: 3px solid salmon;
    box-shadow: 2px 5px 8px #0096c7;
}

.profile-picture img {
    width: 100%;
    height: 100%;
    object-fit: cover;
}

.card {
    border: none;
    background-color: transparent;
    transition: transform 0.3s ease;
}

.card:hover {
    transform: translateY(-5px);
}

.card-title {
    margin-top: 10px;
    font-size: 1.5rem;
    color: orangered;
    font-family: 'Courier New', Courier, monospace;
}

.card-text {
    font-size: 1.5rem;
    color: orangered;
    font-family: 'Courier New', Courier, monospace;
}
.btn-dark{
    margin-left: 0.5rem;
}
 .user-card-buttons {

  display: none; 
} 

.card:hover .user-card-buttons {
  display: block; 
}
</style>
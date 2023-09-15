<script setup>
import { ref, onMounted } from 'vue';
import Navbar from '../components/Navbar.vue';
import axios from 'axios';

const users = ref([]);
const deleteSuccess = ref(false);
const searchQuery = ref('');

const getUsers = () => {
    axios
        .get('http://localhost:8080/users', {
            params: {
                id: 0,
                firstName: searchQuery.value,
                lastName: searchQuery.value,
                username: searchQuery.value,
            },
        })
        .then((res) => {
            users.value = res.data;
        })
        .catch((error) => {
            console.error('Not able to fetch users:', error);
        });
};

const handleSearchEnter = () => {
    getUsers();
};

const deleteUser = (id) => {
    axios
        .delete(`http://localhost:8080/users/${id}`)
        .then(() => {
            getUsers();
            deleteSuccess.value = true;
            setTimeout(() => {
                deleteSuccess.value = false;
            }, 5000);
        })
        .catch((error) => {
            console.error('Not able to fetch user:', error);
        });
};

onMounted(() => {
    getUsers();
});
</script>
<template>
    <main>
        <Navbar />
        <!-- Table-->
        <div class="container">
            <div class="row ">
                <div class="col-md-12">
                    <p v-if="deleteSuccess" class="alert alert-success">
                        User deleted successfully.
                    </p>
                    <h1 class="text-center">All users</h1>
                    <!--Add button -->
                    <div class="d-flex justify-content-end">
                        <a href="/adduser" class="btn btn-secondary">New user</a>
                    </div>
                    <div class="table-responsive">
                        <table class="table table-hover">
                            <thead>
                                <tr>
                                    <th scope="col">Id</th>
                                    <th scope="col">First Name</th>
                                    <th scope="col">Last Name</th>
                                    <th scope="col">Email</th>
                                    <th scope="col">UserName </th>
                                    <th scope="col">Role</th>
                                    <th scope="col">Action</th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr v-for="user in users" :key="user.id">
                                    <th scope="row">{{ user.id }}</th>
                                    <td>{{ user.firstName }}</td>
                                    <td>{{ user.lastName }}</td>
                                    <td>{{ user.email }}</td>
                                    <td>{{ user.username }}</td>
                                    <td v-if="user.role">{{ user.role.roleName }}</td>
                                    <td v-else></td>

                                    <td>
                                        <a class="btn btn-info" :href="`/edit/${user.id}`">Edit</a>
                                        <button class="btn btn-danger mx-2" @click="deleteUser(user.id)">Delete</button>
                                    </td>
                                </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>

    </main>
</template>


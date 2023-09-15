<script setup>
import { ref, onMounted } from 'vue';
import { useRouter } from 'vue-router';
import Navbar from '../components/Navbar.vue';
import axios from 'axios';
const user = ref( {
    firstName: '',
    lastName: '',
    email: '',
    username: '',
    password: '',
});
            
const roles = ref([]);
const selectedRole = ref("Select_from_list");
const router = useRouter();
const addUser = () => {
    const newUser = { ...user.value, role: { id: selectedRole.value } };
    axios.post('http://localhost:8080/users', newUser)
        .then(() => {
            alert("User Sucessfully added!")
            router.push('/Viewarticle');
        })
        .catch(error => {
            console.error("Not able to add user:", error);
        });
};
const fetchRoles = () => {
    axios.get('http://localhost:8080/roles')
        .then(res => {
            roles.value = res.data;
        }).catch(error => {
            console.error('Role Not found!', error);
        });
};
onMounted(() => {
    fetchRoles();
});
</script>
<template>
    <main>
        <Navbar />
        <div class="my-5">
            <div class="mx-auto w-25 " style="max-width:100%;">
                <h2 class="text-center mb-3">New User</h2>
                <form @submit.prevent="addUser">
                    <div class="row">
                        <div class="col-md-12 form-group mb-3">
                            <label for="firstName" class="form-label">firstName</label>
                            <input id="firstName" type="text" name="name" class="form-control" placeholder="firstName"
                                required v-model="user.firstName">
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-12 form-group mb-3">
                            <label for="lastName" class="form-label">lastName</label>
                            <input id="lastName" type="text" name="lastName" class="form-control" placeholder="lastName"
                                required v-model="user.lastName">
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-12 form-group mb-3">
                            <label for="email" class="form-label">Email</label>
                            <input id="email" type="email" name="email" class="form-control" placeholder="email" required
                                v-model="user.email">
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-12 form-group mb-3">
                            <label for="username" class="form-label">UserName</label>
                            <input id="username" type="text" name="UserName" class="form-control" placeholder="UserName"
                                required v-model="user.username">
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-12 form-group mb-3">
                            <label for="password" class="form-label">Password</label>
                            <input id="password" type="text" name="Password" class="form-control" placeholder="password"
                                required v-model="user.password">
                        </div>
                    </div>
                    <!-- Role Dropdown -->
                    <div class="row">
                        <div class="col-md-12 form-group mb-3">
                            <label for="roleName" class="form-label">Role</label>
                            <select id="roleName" name="roleName" class="form-control" v-model="selectedRole">
                                <option value="Select_from_list" disabled>Select_from_list</option>
                                <option v-for="role in roles" :key="role.id" :value="role.id">{{ role.roleName }}</option>
                            </select>
                        </div>
                    </div>
                    <br><br>
                    <div class="row">
                        <div class="col-md-12 form-group">
                            <input class="btn btn-secondary w-100" type="submit" value="Submit">
                        </div>
                    </div>
                    <div>
                    </div>
                </form>
            </div>
        </div>
    </main>
</template>

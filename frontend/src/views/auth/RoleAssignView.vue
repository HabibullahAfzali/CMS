<script setup>
import { ref, onMounted } from 'vue';
import axios from 'axios';
import { useRouter } from 'vue-router';
import Navbar from '@/components/Navbar.vue';

const users = ref([]);
const roles = ref([]);
const selectedUser = ref("Select_from_list");
const selectedRole = ref("Select_from_list");
const route = useRouter();
const assignRoles = async () => {

    const assignData = {
        userId: selectedUser.value,
        roleId: selectedRole.value,
    };
    console.log("assign data: ", assignData)
    axios.post('http://localhost:8080/api/assign-roles', assignData)
        .then(() => {
            console.log("assign data: ", assignData)
            alert("Role successfully assigned to the user!");
            route.push('/ViewUser');
        })
        .catch(error => {
            console.error("Role Not Assigned:", error);
        });
};

const fetchRoles = () => {
    axios.get('http://localhost:8080/api/roles')
        .then(res => {
            roles.value = res.data;
        }).catch(error => {
            console.error('Roles not found!', error);
        });
};

const fetchUsers = () => {
    axios.get('http://localhost:8080/api/users')
        .then(res => {
            users.value = res.data;
        }).catch(error => {
            console.error('User not found!', error);
        });
};

onMounted(() => {
    fetchRoles();
    fetchUsers();
});
</script>

<template>
    <main>
        <Navbar />
        <div class="container px-4 py-5 px-md-5 text-center text-lg-start my-5"
            style="background-color: #4ed8f4;  border-radius: 20px; box-shadow: 0px 0px 20px rgb(143, 43, 7);">
            <div class="row gx-lg-5 align-items-center mb-5">
                <div class="col-lg-6 mb-5 mb-lg-0"
                    style="z-index: 10; font-family: 'Courier New', Courier, monospace; font-size: large;">
                    <h1 class="my-5 display-5 fw-bold ls-tight" style="color: hsl(218, 81%, 95%)">
                        Here you go! Since after <br />
                        <span style="color: #0096c7">you will have the given rights access</span>
                    </h1>
                    <p class="mb-4 opacity-70"
                        style="color: #eef1f2; font-family: 'Courier New', Courier, monospace; font-size: large;">
                        Pleas take into account all your access reposibilities
                    </p>
                </div>

                <div class="col-lg-6 mb-5 mb-lg-0 position-relative">
                    <div id="radius-shape-1" class="position-absolute rounded-circle shadow-5-strong"></div>
                    <div id="radius-shape-2" class="position-absolute shadow-5-strong"></div>

                    <div class="card bg-glass"
                        style="background-color: #0096c7; opacity:80%; border-radius: 20px; box-shadow: 0px 0px 20px rgb(143, 43, 7); color: #eef1f2; font-family: 'Courier New', Courier, monospace; font-size: large;">
                        <h1 class="mt-3 display-5 fw-bold ls-tight text-center">Authorization <br /><i
                                class="bi bi-shield-check"></i>
                        </h1>
                        <div class="card-body px-4 py-5 px-md-5">
                            <form @submit.prevent="assignRoles">
                                <!-- User Dropdown -->
                                <div class="col-md-12 form-group mb-3">
                                    <label for="username" class="form-label">User</label>
                                    <select id="username" name="username" class="form-control" v-model="selectedUser"
                                        required>
                                        <option value="Select_from_list" disabled>Select_from_list</option>
                                        <option v-for="user in users" :key="user.id" :value="user.id">{{ user.username
                                        }}</option>
                                    </select>
                                </div>
                                <!-- Role Dropdown -->
                                <div class="row">
                                    <div class="col-md-12 form-group mb-3">
                                        <label for="name" class="form-label">Role</label>
                                        <select id="name" name="name" class="form-control" v-model="selectedRole" required>
                                            <option value="Select_from_list" disabled>Select_from_list</option>
                                            <option v-for="role in roles" :key="role.id" :value="role.id">{{ role.name
                                            }}</option>
                                        </select>
                                    </div>
                                </div>
                                <br><br>
                                <div class="row">
                                    <div class="col-md-12 form-group">
                                        <button class="btn btn-info w-100"
                                            :disabled="selectedUser === 'Select_from_list' || selectedRole === 'Select_from_list'">
                                            <i class="bi bi-check-circle"></i>
                                            Submit
                                        </button>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </main>
</template>

<style scoped>
.profile-picture-label {
    display: inline-block;
    width: 120px;
    height: 120px;
    border-radius: 50%;
    background-color: #e2e2df;
    text-align: center;
    line-height: 120px;
    cursor: pointer;
    transition: background-color 0.3s ease;
}

.profile-picture-label i {
    font-size: 36px;
}

.profile-picture-label:hover {
    background-color: #0a6fea;
}</style>
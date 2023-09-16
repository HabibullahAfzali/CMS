<script setup>
import { ref } from 'vue';
import { useRouter } from 'vue-router';
import axios from 'axios';
const route = useRouter();

const user = ref({
    username: '',
    password: ''
});

const loginErrorMessage = ref('');

const login = async (user) => {
    axios.post('http://localhost:8080/login', user)
        .then(() => {
            alert("User successfully logged in!");
            route.push("/dashboard")
        })
        .catch(error => {
            console.error("Login failed:", error);
            loginErrorMessage.value = "Wrong username or password. Please try again.";
        });
};
</script>

<template>
    <main>
        <div class="container px-4 py-5 px-md-5 text-center text-lg-start my-5"
            style="background-color: #4ed8f4;  border-radius: 20px; box-shadow: 0px 0px 20px rgba(0, 0, 0, 0.2);">
            <div class="row gx-lg-5 align-items-center mb-5">
                <div class="col-lg-6 mb-5 mb-lg-0"
                    style="z-index: 10; font-family: 'Courier New', Courier, monospace; font-size: large;">
                    <h1 class="my-5 display-5 fw-bold ls-tight" style="color: hsl(218, 81%, 95%)">
                        Welcome to <br />
                        <span style="color: #0096c7">User Authentication</span>
                    </h1>
                    <p class="mb-4 opacity-80"
                        style="color: #eef1f2; font-family: 'Courier New', Courier, monospace; font-size: large; ">
                        Try to use the Correct UserName and Password
                    </p>
                </div>

                <div class="col-lg-6 mb-5 mb-lg-0 position-relative">
                    <div id="radius-shape-1" class="position-absolute rounded-circle shadow-5-strong"></div>
                    <div id="radius-shape-2" class="position-absolute shadow-5-strong"></div>

                    <div class="card bg-glass"
                        style="background-color: #0096c7; opacity:80%; border-radius: 20px; box-shadow: 0px 0px 20px rgba(0, 0, 0, 0.2); color: #eef1f2; font-family: 'Courier New', Courier, monospace; font-size: large;">
                        <h1 class="mt-3 display-5 fw-bold ls-tight text-center"> <span class="bi bi-person"></span>
                        </h1>
                        <div class="card-body px-4 py-5 px-md-5">
                            <form @submit.prevent="login(user)">
                                <div class="form-outline mb-4">
                                    <input type="text" id="userName" class="form-control center" v-model="user.username" />
                                    <label class="form-label" for="userName">User name</label>
                                </div>
                                <div class="form-outline mb-4">
                                    <input type="password" id="password" class="form-control" v-model="user.password" />
                                    <label class="form-label" for="password">Password</label>
                                </div>
                                <div v-if="loginErrorMessage" class="alert alert-danger">{{ loginErrorMessage }}</div>

                                <button class="btn btn-info w-100" :disabled="!user.username || !user.password">
                                    <i class="bi bi-check-circle"></i>
                                    Submit
                                </button>
                                <div class="text-center">
                                    <br />
                                    <p> Not have an account </p>
                                    <a href="/register"><span class="signup"><i class="bi bi-person-plus"></i> </span></a>
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
.signup {
    color: black;
    font-size: larger;
}

.signup:hover .bi {
    font-size: 1.2em;
    /* Increase the icon size on hover (adjust the value as needed) */
}</style>
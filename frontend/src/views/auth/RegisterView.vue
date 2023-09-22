<script setup>
import { computed, ref } from 'vue';
import axios from 'axios';
import { useRouter } from 'vue-router';

const user = ref({
    username: '',
    email: '',
    password: ''
});
//Form fields filling validation
const isFilled = computed(() => {
    return (
        user.value.username.trim() !== '' &&
        user.value.email.trim() !== '' &&
        user.value.password.trim() !== ''
    )

})

const route = useRouter();
const profilePicture = ref(null);
const selectedImage = ref(null);
const handleProfilePictureUpload = (event) => {
    profilePicture.value = event.target.files[0];
    if (profilePicture.value) {
        const imageUrl = URL.createObjectURL(profilePicture.value);
        selectedImage.value = imageUrl;
    }
}
const signUp = async () => {
    const formData = new FormData();
    for (const key in user.value) {
        formData.append(key, user.value[key]);
    }
    if (profilePicture.value) {
        formData.append('image', profilePicture.value);
    }
    axios.post('http://localhost:8080/api/createUser', formData)
        .then(() => {
            alert("User successfully added!");
            route.push('/viewuser');
        })
        .catch(error => {
            console.error("Not able to add user:", error);
        });
};
</script>
<template>
    <main>
        <div class="container px-3 py-5 px-md-5 text-center text-lg-start my-5 "
            style="background-color: #053970;  border-radius: 20px; box-shadow: 0px 0px 20px rgb(252, 237, 232);">
            <div class="row gx-lg-5 align-items-center mb-5">
                <div class="col-lg-6 mb-5 mb-lg-0"
                    style="z-index: 10; font-family: 'Courier New', Courier, monospace; font-size: large;">
                    <h1 class="my-5 display-5 fw-bold ls-tight" style="color: hsl(218, 81%, 95%)">
                        Welcome! please fill The <br />
                        <span style="color: #c49c9c">Registeration Form</span>
                    </h1>
                    <p class="mb-4 opacity-70"
                        style="color: #eef1f2; font-family: 'Courier New', Courier, monospace; font-size: large;">
                        It's important to note your password
                    </p>
                </div>

                <div class="col-lg-6 mb-5 mb-lg-0 position-relative">
                    <div id="radius-shape-1" class="position-absolute rounded-circle shadow-5-strong"></div>
                    <div id="radius-shape-2" class="position-absolute shadow-5-strong"></div>

                    <div class="card bg-glass"
                        style="background-color: #195ca3; opacity:70%; border-radius: 20px; box-shadow: 0px 0px 20px rgb(252, 237, 232); color: #c49c9c; font-family: 'Courier New', Courier, monospace; font-size: large;">
                        <h1 class="mt-3 display-5 fw-bold ls-tight text-center">
                            <i class="bi bi-person-plus"></i> <br />
                            SignUp
                        </h1>
                        <div class="card-body px-3 py-4 px-md-5">
                            <form @submit.prevent="signUp">
                                <!-- Profile Picture input -->
                                <div class="form-outline mb-4">
                                    <label class="profile-picture-label cursor-pointer" for="profilePictureInput">
                                        <input type="file" @change="handleProfilePictureUpload($event)"
                                            class="form-control d-none" id="profilePictureInput" ref="fileInput" />
                                        <!-- Display either the selected image or an icon -->
                                        <div class="text-center profile-image-container">
                                            <img v-if="selectedImage" :src="selectedImage" alt="Selected Profile Picture"
                                                class="img-fluid mb-3" style="max-width: 200px;" />
                                            <i v-else class="bi bi-person-circle" style="font-size: 36px;"></i>
                                        </div>
                                    </label>
                                </div>
                                <div class="form-outline mb-4">
                                    <input type="text" class="form-control center" placeholder="username"
                                        v-model="user.username" />
                                </div>
                                <div class="form-outline mb-4">
                                    <input type="email" class="form-control" v-model="user.email" placeholder="email" />
                                </div>
                                <div class="form-outline mb-4">
                                    <input type="password" class="form-control" v-model="user.password"
                                        placeholder="password" />
                                </div>
                                <div class="row">
                                    <div class="col-md-12 form-group">
                                        <button class="btn btn-dark w-100" :disabled="!isFilled">
                                            <i class="bi bi-check-circle"></i>
                                            Submit
                                        </button>
                                    </div>
                                </div>
                                <br />
                                <div class="text-center">
                                    <p> Already Have an Account </p>
                                    <a href="/"> <span class="symbol">&#128273;</span></a>
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
.container {
    opacity: 80%;
}

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
}

.symbol {
    font-size: 24px;
    box-shadow: 2px 2px 5px rgba(0, 0, 0, 0.2);
}

.symbol:hover {
    transform: scale(1.1);
    border: 2px solid white;
}
.profile-image-container {
    width: 120px;
    height: 120px;
    border-radius: 50%;
    background-color: #e2e2df;
    text-align: center;
    cursor: pointer;
    transition: background-color 0.3s ease;
}

.profile-image-container img {
    display: inline-block;
    width: 120px;
    height: 120px;
    border-radius: 50%;
    line-height: 120px;
}

.profile-image-container i {
    font-size: 36px;
    color: #000; /* Change the color of the icon as desired */
}


</style>

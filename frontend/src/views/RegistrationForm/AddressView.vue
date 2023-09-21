<script setup>
import { ref } from 'vue';
import axios from 'axios';
import { useRouter } from 'vue-router';

const router = useRouter();

const addressData = ref({
    streetAddress: '',
    city: '',
    state: '',
    postalCode: '',
    country: ''
});

const saveAddress = () => {

    axios
        .post('http://localhost:8080/api/saveAddress', addressData.value)
        .then(() => {
            alert('Address created successfully');
            router.push("/dashboard")

        })
        .catch(error => {
            console.error('Error Occurred!:', error);
            if (error.response) {
                console.error('Response data:', error.response.data);
            }
        });
};

</script>
<template>
    <main>
        <div class="container px-3 py-5 px-md-5 text-center text-lg-start my-5"
           style="background-color: #053970;  border-radius: 20px; box-shadow: 0px 0px 20px rgb(252, 237, 232); opacity: 90%;" >
             <div class="row gx-lg-5 align-items-center mb-5">
                    <div class="col-lg-6 mb-5 mb-lg-0"
                        style="z-index: 10; font-family: 'Courier New', Courier, monospace; font-size: large;">
                        <h1 class="my-5 display-5 fw-bold ls-tight" style="color: hsl(218, 81%, 95%)">
                            Please fill the form with <br />
                            <span style="color: #c49c9c">Current Address</span>
                             <br/> <i class="bi bi-geo-alt"></i>
                        </h1>
                    </div>

                    <div class="col-lg-6 mb-5 mb-lg-0 position-relative">
                        <div id="radius-shape-1" class="position-absolute rounded-circle shadow-5-strong"></div>
                        <div id="radius-shape-2" class="position-absolute shadow-5-strong"></div>

                        <div class="card bg-glass"
                            style="background-color: #195ca3; opacity:80%; border-radius: 20px; box-shadow: 0px 0px 20px rgb(252, 237, 232); color: #c49c9c; font-family: 'Courier New', Courier, monospace; font-size: large;">
                            <h1 class="mt-3 display-5 fw-bold ls-tight text-center">
                                <i class="bi bi-house-door"></i>
                              
                            </h1>
                            <div class="card-body px-3 py-4 px-md-5">
                        <form @submit.prevent="saveAddress">
                            <div class="row">
                                <div class="col-md-12 form-group mb-3">
                                    <input id="streetAddress" type="text" class="form-control" placeholder="Street Address"
                                        required v-model="addressData.streetAddress">
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-12 form-group mb-3">
                                    <input id="city" type="text" class="form-control" placeholder="City" required
                                        v-model="addressData.city">
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-12 form-group mb-3">
                                    <input id="state" type="text" class="form-control" placeholder="State" required
                                        v-model="addressData.state">
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-12 form-group mb-3">
                                    <input id="postalCode" type="text" class="form-control" placeholder="Postal Code"
                                        required v-model="addressData.postalCode">
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-12 form-group mb-3">
                                    <input id="country" type="text" class="form-control" placeholder="Country" required
                                        v-model="addressData.country">
                                </div>
                            </div>
                            <br><br>
                            <div class="form-group">
                                <button class="btn btn-light bg-light w-100" type="submit">
                                    <i class="bi bi-check-circle"></i> Submit
                                </button>
                            </div>
                        </form>
                    </div>
                        </div>
                </div>
            </div>
        </div>
    </main>
</template>

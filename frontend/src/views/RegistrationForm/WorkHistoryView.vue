<script setup>
import { ref } from 'vue';
import axios from 'axios';
import { useRouter } from 'vue-router';

const router = useRouter();

const workHistoryData = ref({
    employer: '',
    jobTitle: '',
    startDate: '',
    endDate: ''
});
const saveWorkHistory = () => {
    axios
        .post('http://localhost:8080/api/saveWorks', workHistoryData.value)
        .then(() => {
            alert('Saved successfully');
            router.push("/address")

        })
        .catch(error => {
            console.error('Error Occurred! :', error);
            if (error.response) {
                console.error('Response data:', error.response.data);
            }
        });
};
</script>

<template>
    <main>
        <div class="container px-3 py-5 px-md-5 text-center text-lg-start my-5 "
            style="background-color: #053970;  border-radius: 20px; box-shadow: 0px 0px 20px rgb(252, 237, 232); opacity: 90%;" >
            <div class="row gx-lg-5 align-items-center mb-5">
                <div class="col-lg-6 mb-5 mb-lg-0"
                    style="z-index: 10; font-family: 'Courier New', Courier, monospace; font-size: large;">
                    <h1 class="my-5 display-5 fw-bold ls-tight" style="color: hsl(218, 81%, 95%)">
                        Your Recent Work <br />
                        <span style="color: #c49c9c">Experience</span>
                    </h1>
                    <p class="mb-4 opacity-70"
                        style="color: #eef1f2; font-family: 'Courier New', Courier, monospace; font-size: large;">
                        fill the form with the last jobs info
                    </p>
                </div>

                <div class="col-lg-6 mb-5 mb-lg-0 position-relative">
                    <div id="radius-shape-1" class="position-absolute rounded-circle shadow-5-strong"></div>
                    <div id="radius-shape-2" class="position-absolute shadow-5-strong"></div>

                    <div class="card bg-glass"
                        style="background-color: #195ca3; opacity:80%; border-radius: 20px; box-shadow: 0px 0px 20px rgb(252, 237, 232); color: #c49c9c; font-family: 'Courier New', Courier, monospace; font-size: large;">
                        <h1 class="mt-3 display-5 fw-bold ls-tight text-center">
                           <i class="bi bi-briefcase"></i>
                        </h1>
                        <div class="card-body px-3 py-4 px-md-5">
                            <form @submit.prevent="saveWorkHistory">
                                <div class="row">
                                    <div class="col-md-12 form-group mb-3">
                                        <input id="employer" type="text" class="form-control" placeholder="Employer Name"
                                            required v-model="workHistoryData.employer">
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-md-12 form-group mb-3">
                                        <input id="jobTitle" type="text" class="form-control" placeholder="Job Title"
                                            required v-model="workHistoryData.jobTitle">
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-md-12 form-group mb-3">
                                        <label for="startDate" class="form-label">Start Date</label>
                                        <input id="startDate" type="date" class="form-control" placeholder="Start Date"
                                            required v-model="workHistoryData.startDate">
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-md-12 form-group mb-3">
                                         <label for="endDate" class="form-label">End Date</label>
                                        <input id="endDate" type="date" class="form-control" placeholder="End Date" required
                                            v-model="workHistoryData.endDate">
                                    </div>
                                </div>
                                <br><br>
                                <div class="form-group">
                                    <button class="btn btn-light bg-light w-100" type="submit">
                                        <i class="bi bi-check-circle"></i> Next
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

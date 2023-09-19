<script setup>
import { ref } from 'vue';
import axios from 'axios';

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
        <div class="my-5">
            <div class="mx-auto w-25" style="max-width: 100%;">
                <h2 class="text-center mb-3">Work History</h2>
                <form @submit.prevent="saveWorkHistory">
                    <div class="row">
                        <div class="col-md-12 form-group mb-3">
                            <label for="employer" class="form-label">Employer</label>
                            <input id="employer" type="text" class="form-control" placeholder="Employer Name" required
                                v-model="workHistoryData.employer">
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-12 form-group mb-3">
                            <label for="jobTitle" class="form-label">Job Title</label>
                            <input id="jobTitle" type="text" class="form-control" placeholder="Job Title" required
                                v-model="workHistoryData.jobTitle">
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-12 form-group mb-3">
                            <label for="startDate" class="form-label">Start Date</label>
                            <input id="startDate" type="date" class="form-control" placeholder="Start Date" required
                                v-model="workHistoryData.startDate">
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
                            <i class="bi bi-check-circle"></i> Submit
                        </button>
                    </div>
                </form>
            </div>
        </div>
    </main>
</template>

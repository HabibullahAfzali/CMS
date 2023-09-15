<script setup>
import { ref, defineEmits } from 'vue';

const workHistoryData = ref({
    employerName: '',
    jobTitle: '',
    startDate: '',
    endDate: ''
});
const { emit } = defineEmits(['next-step']);
const nextStep = () => {
    const newInfo = { ...workHistoryData.value };
    emit('next-step', newInfo);
};
</script>

<template>
    <main>
        <div class="my-5">
            <div class="mx-auto w-25" style="max-width: 100%;">
                <h2 class="text-center mb-3">Work History</h2>
                <form @submit.prevent="nextStep">
                    <div class="row">
                        <div class="col-md-12 form-group mb-3">
                            <label for="employerName" class="form-label">Employer</label>
                            <input id="employerName" type="text" class="form-control" placeholder="Employer Name" required
                                v-model="workHistoryData.employerName">
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
                    <div>
                    </div>
                </form>
            </div>
        </div>
    </main>
</template>

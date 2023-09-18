<script setup>
import { ref, defineEmits } from 'vue';

const educationData = ref({
    institution: '',
    degree: '',
    fieldOfStudy: '',
    startDate: '',
    graduationDate: '',
});
const { emit } = defineEmits(['next-step']);

const nextStep = () => {
    const newInfo = { ...educationData.value };
    emit('next-step', newInfo);
};
</script>
<template>
    <main>
        <div class="my-5">
            <div class="mx-auto w-25" style="max-width: 100%;">
                <h2 class="text-center mb-3">Education</h2>
                <form @submit.prevent="nextStep">
                    <div class="row">
                        <div class="col-md-12 form-group mb-3">
                            <label for="institutionName" class="form-label">Institution</label>
                            <input id="institutionName" type="text" class="form-control" placeholder="Institution Name"
                                required v-model="educationData.institution">
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-12 form-group mb-3">
                            <label for="degreeName" class="form-label">Degree</label>
                            <input id="degreeName" type="text" class="form-control" placeholder="Degree Name" required
                                v-model="educationData.degree">
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-12 form-group mb-3">
                            <label for="fieldOfStudy" class="form-label">Field of Study</label>
                            <input id="fieldOfStudy" type="text" class="form-control" placeholder="Field of Study" required
                                v-model="educationData.fieldOfStudy">
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-12 form-group mb-3">
                            <label for="startDate" class="form-label">Start Date</label>
                            <input id="startDate" type="date" class="form-control" placeholder="Start Date" required
                                v-model="educationData.startDate">
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-12 form-group mb-3">
                            <label for="graduationDate" class="form-label">Graduation Date</label>
                            <input id="graduationDate" type="date" class="form-control" placeholder="Graduation Date"
                                required v-model="educationData.graduationDate">
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

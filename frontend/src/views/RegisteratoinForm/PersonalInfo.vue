
<script setup>
import { ref, defineProps, onMounted } from 'vue';
import axios from 'axios';


const { formData, activeStep } = defineProps(['formData', 'activeStep']);
const personalInfoData = ref('');
const emit = defineEmits();

const selectedGender = ref("Select_from_list");
const selectedMaritalStatus = ref("Select_from_list");
const selectedNationality = ref("Select_from_list");

const genders = ref([]); // Define the genders ref
const maritalstatus = ref([]); // Define the maritalstatus ref
const nationalities = ref([]); // Define the nationalities ref

const fetchGender = async () => {
    try {
        const res = await axios.get('http://localhost:8080/api/genders');
        genders.value = res.data;
    } catch (error) {
        console.error('gender Not found!', error);
    }
};

const fetchNationality = async () => {
    try {
        const res = await axios.get('http://localhost:8080/api/nationalities');
        nationalities.value = res.data;
    } catch (error) {
        console.error('Nationality Not found!', error);
    }
};

const fetchMaritalStatus = async () => {
    try {
        const res = await axios.get('http://localhost:8080/api/status');
        maritalstatus.value = res.data;
    } catch (error) {
        console.error('MaritalStatus Not found!', error);
    }
};

const nextStep = () => {
    const newInfo = {
        ...personalInfoData,
        gender: { id: selectedGender.value },
        nationality: { id: selectedNationality.value },
        maritalStatus: { id: selectedMaritalStatus.value },
    };

    emit('next-step', newInfo);
};

onMounted(() => {
    fetchGender();
    fetchMaritalStatus();
    fetchNationality();
});
</script>

<template>
  <div>
    <h2 class="text-center mb-3">Personal Information</h2>
    <form @submit.prevent="nextStep">
     <div class="row">
                <div class="col-md-12 form-group mb-3">
                    <label for="identityNumber" class="form-label">NIE/NID</label>
                    <input id="identityNumber" type="text" class="form-control" placeholder="identityNumber" required
                        v-model="personalInfoData.identityNumber" />
                </div>
            </div>
            <div class="row">
                <div class="col-md-12 form-group mb-3">
                    <label for="firstName" class="form-label">firstName</label>
                    <input id="firstName" type="text" class="form-control" placeholder="firstName" required
                        v-model="personalInfoData.firstName" />
                </div>
            </div>
            <div class="row">
                <div class="col-md-12 form-group mb-3">
                    <label for="lastName" class="form-label">lastName</label>
                    <input id="lastName" type="text" class="form-control" placeholder="lastName" required
                        v-model="personalInfoData.lastName" />
                </div>
            </div>
            <div class="row">
                <div class="col-md-12 form-group mb-3">
                    <label for="dateOfBirth" class="form-label">dateOfBirth</label>
                    <input id="dateOfBirth" type="date" class="form-control" placeholder="dateOfBirth" required
                        v-model="personalInfoData.dateOfBirth" />
                </div>
            </div>
            <div class="row">
                <div class="col-md-12 form-group mb-3">
                    <label for="email" class="form-label">Email</label>
                    <input id="email" type="email" class="form-control" placeholder="email" required
                        v-model="personalInfoData.emailAddress" />
                </div>
            </div>
            <div class="row">
                <div class="col-md-12 form-group mb-3">
                    <label for="contactNumber" class="form-label">Phone</label>
                    <input id="contactNumber" type="text" class="form-control" placeholder="contactNumber" required
                        v-model="personalInfoData.contactNumber" />
                </div>
            </div>

      <!-- Gender Dropdown -->
      <div class="row">
        <div class="col-md-12 form-group mb-3">
          <label for="gender" class="form-label">Gender</label>
          <select id="gender" class="form-control" v-model="selectedGender">
            <option value="Select_from_list" disabled>Select_from_list</option>
            <option v-for="gender in genders" :key="gender.id" :value="gender.id">{{ gender.name }}</option>
          </select>
        </div>
      </div>
      <div class="row">
        <div class="col-md-12 form-group mb-3">
          <label for="maritalStatus" class="form-label">MaritalStatus</label>
          <select id="maritalStatus" class="form-control" v-model="selectedMaritalStatus">
            <option value="Select_from_list" disabled>Select_from_list</option>
            <option v-for="status in maritalstatus" :key="status.id" :value="status.id">{{ status.name }}</option>
          </select>
        </div>
      </div>
      <div class="row">
        <div class="col-md-12 form-group mb-3">
          <label for="nationality" class="form-label">Nationality</label>
          <select id="nationality" class="form-control" v-model="selectedNationality">
            <option value="Select_from_list" disabled>Select_from_list</option>
            <option v-for="nationality in nationalities" :key="nationality.id" :value="nationality.id">{{ nationality.name }}</option>
          </select>
        </div>
      </div>
      <br /><br />
      <div>
        <button class="btn btn-primary" type="submit">Next</button>
      </div>
    </form>
  </div>
</template>

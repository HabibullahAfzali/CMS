
<script setup>
  import {ref, onMounted} from 'vue';
  import {useRouter} from 'vue-router';
  import axios from 'axios';
  const PersonalInfo = ref({
    identityNumber: '',
  firstName: '',
  lastName: '',
  dateOfBirth: '',
  contactNumber: '',
  emailAddress: ''
});
  const genders = ref([]);
  const nationalities = ref([]);
  const maritalstatus = ref([]);
  const selectedGender = ref("Select_from_list");
  const selectedMaritalStatus = ref("Select_from_list");
  const selectedNationality = ref("Select_from_list");
  const router = useRouter();
const savePersonalInfo = () => {
    const newInfo = {
    ...PersonalInfo.value,
    gender: {id: selectedGender.value },
  nationality: {id: selectedNationality.value },
  maritalStatus: {id: selectedMaritalStatus.value },
    };
  axios.post('http://localhost:8080/api/savePersonalInfo', newInfo)
        .then(() => {
    alert("Successfully Saved!");
  router.push('/');
        })
        .catch(error => {
    console.log(newInfo);
  console.error("An error occurred:", error);
  console.error("Status code:", error.response.status);
  console.error("Response data:", error.response.data);
        });
};
const fetchGender = () => {
    axios.get('http://localhost:8080/api/genders')
      .then(res => {
        genders.value = res.data;
      }).catch(error => {
        console.error('gender Not found!', error);
      });
};
const fetchNationality = () => {
    axios.get('http://localhost:8080/api/nationalities')
      .then(res => {
        nationalities.value = res.data;
      }).catch(error => {
        console.error('Nationality Not found!', error);
      });
};
const fetchMaritalStatus = () => {
    axios.get('http://localhost:8080/api/maritalStatus')
      .then(res => {
        maritalstatus.value = res.data;
      }).catch(error => {
        console.error('MaritalStatus Not found!', error);
      });
};
onMounted(() => {
    fetchGender();
  fetchMaritalStatus();
  fetchNationality();
});
</script>

<template>
  <main>
    <div class="my-5">
      <div class="mx-auto w-25" style="max-width: 100%;">
        <h2 class="text-center mb-3">Personal Information</h2>
        <form @submit.prevent="savePersonalInfo">
          <div class="row">
            <div class="col-md-12 form-group mb-3">
              <label for="identityNumber" class="form-label">NIE/NID</label>
              <input id="identityNumber" type="text" class="form-control" placeholder="identityNumber" required
                v-model="PersonalInfo.identityNumber" />
            </div>
          </div>
          <div class="row">
            <div class="col-md-12 form-group mb-3">
              <label for="firstName" class="form-label">firstName</label>
              <input id="firstName" type="text" class="form-control" placeholder="firstName" required
                v-model="PersonalInfo.firstName" />
            </div>
          </div>
          <div class="row">
            <div class="col-md-12 form-group mb-3">
              <label for="lastName" class="form-label">lastName</label>
              <input id="lastName" type="text" class="form-control" placeholder="lastName" required
                v-model="PersonalInfo.lastName" />
            </div>
          </div>
          <div class="row">
            <div class="col-md-12 form-group mb-3">
              <label for="dateOfBirth" class="form-label">dateOfBirth</label>
              <input id="dateOfBirth" type="date" class="form-control" placeholder="dateOfBirth" required
                v-model="PersonalInfo.dateOfBirth" />
            </div>
          </div>
          <div class="row">
            <div class="col-md-12 form-group mb-3">
              <label for="email" class="form-label">Email</label>
              <input id="email" type="email" class="form-control" placeholder="email" required
                v-model="PersonalInfo.emailAddress" />
            </div>
          </div>
          <div class="row">
            <div class="col-md-12 form-group mb-3">
              <label for="contactNumber" class="form-label">Phone</label>
              <input id="contactNumber" type="text" class="form-control" placeholder="contactNumber" required
                v-model="PersonalInfo.contactNumber" />
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
                <option v-for="nationality in nationalities" :key="nationality.id" :value="nationality.id">{{
                  nationality.name
                }}</option>
              </select>
            </div>
          </div>
          <br /><br />
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

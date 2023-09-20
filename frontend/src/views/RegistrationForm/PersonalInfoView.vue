<script setup>
import { ref, onMounted } from 'vue';
import { useRouter } from 'vue-router';
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
    gender: { id: selectedGender.value },
    nationality: { id: selectedNationality.value },
    maritalStatus: { id: selectedMaritalStatus.value },
  };
  axios.post('http://localhost:8080/api/savePersonalInfo', newInfo)
    .then(() => {
      alert("Successfully Saved!");
      router.push('/education');
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
    <div class="container px-3 py-5 px-md-5 text-center text-lg-start my-5 "
      style="background-color: #0096c7;  border-radius: 20px; box-shadow: 0px 0px 20px rgb(143, 43, 7);">
      <div class="row gx-lg-5 align-items-center mb-5">
        <div class="col-lg-6 mb-5 mb-lg-0"
          style="z-index: 10; font-family: 'Courier New', Courier, monospace; font-size: large;">
          <h1 class="my-5 display-5 fw-bold ls-tight" style="color: hsl(218, 81%, 95%)">
            Fill the Form based on <br />
            <span style="color: #000">Your Id Card <i class="bi bi-info-circle"></i>
            </span>
          </h1>
        </div>

        <div class="col-lg-6 mb-5 mb-lg-0 position-relative">
          <div id="radius-shape-1" class="position-absolute rounded-circle shadow-5-strong"></div>
          <div id="radius-shape-2" class="position-absolute shadow-5-strong"></div>

          <div class="card bg-glass"
            style="background-color: #00b4d8; opacity:80%; border-radius: 20px; box-shadow: 0px 0px 20px rgb(143, 43, 7); color: #000; font-family: 'Courier New', Courier, monospace; font-size: large;">
            <h1 class="mt-3 display-5 fw-bold ls-tight text-center">
              <i class="bi bi-person"></i>
            </h1>
            <div class="card-body px-3 py-4 px-md-5">
              <form @submit.prevent="savePersonalInfo">
                <div class="row">
                  <div class="col-md-12 form-group mb-3">
                    <input id="identityNumber" type="text" class="form-control" placeholder="identityNumber" required
                      v-model="PersonalInfo.identityNumber" />
                  </div>
                </div>
                <div class="row">
                  <div class="col-md-12 form-group mb-3">
                    <input id="firstName" type="text" class="form-control" placeholder="firstName" required
                      v-model="PersonalInfo.firstName" />
                  </div>
                </div>
                <div class="row">
                  <div class="col-md-12 form-group mb-3">
                   <input id="lastName" type="text" class="form-control" placeholder="lastName" required
                      v-model="PersonalInfo.lastName" />
                  </div>
                </div>
                <div class="row">
                  <div class="col-md-12 form-group mb-3">
                    Date of Birth <input id="dateOfBirth" type="date" class="form-control" required
                      v-model="PersonalInfo.dateOfBirth" />
                  </div>
                </div>
                <div class="row">
                  <div class="col-md-12 form-group mb-3">
                    <input id="email" type="email" class="form-control" placeholder="email" required
                      v-model="PersonalInfo.emailAddress" />
                  </div>
                </div>
                <div class="row">
                  <div class="col-md-12 form-group mb-3">
                    <input id="contactNumber" type="text" class="form-control" placeholder="contactNumber" required
                      v-model="PersonalInfo.contactNumber" />
                  </div>
                </div>

                <!-- Gender Dropdown -->
                <div class="row">
                  <div class="col-md-12 form-group mb-3">
                   Gender <select id="gender" class="form-control" v-model="selectedGender">
                      <option value="Select_from_list" disabled>Select_from_list</option>
                      <option v-for="gender in genders" :key="gender.id" :value="gender.id">{{ gender.name }}</option>
                    </select>
                  </div>
                </div>
                <div class="row">
                  <div class="col-md-12 form-group mb-3">
                   Marital Status <select id="maritalStatus" class="form-control" v-model="selectedMaritalStatus">
                      <option value="Select_from_list" disabled>Select_from_list</option>
                      <option v-for="status in maritalstatus" :key="status.id" :value="status.id">{{ status.name }}
                      </option>
                    </select>
                  </div>
                </div>
                <div class="row">
                  <div class="col-md-12 form-group mb-3">
                   Nationality <select id="nationality" class="form-control" v-model="selectedNationality">
                      <option value="Select_from_list" disabled>Select_from_list</option>
                      <option v-for="nationality in nationalities" :key="nationality.id" :value="nationality.id">{{
                        nationality.name
                      }}</option>
                    </select>
                  </div>
                </div>
                <br />
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

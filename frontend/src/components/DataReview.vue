<script>
import { ref, onMounted, computed } from 'vue';
import DataService from '@/services/DataService';

export default {
    setup() {
        const personalInfo = ref([]);
        const educationData = ref([]);
        const workHistoryData = ref([]);
        const addressData = ref([]);

        onMounted(async () => {
            try {
                // Fetch Personal Info data
                const personalResponse = await DataService.getPersonalInfo('listPersonalInfo');
                personalInfo.value = personalResponse.data;

                // Fetch Education data
                const educationResponse = await DataService.getEducation('educationList');
                educationData.value = educationResponse.data;

                // Fetch Work History data
                const workHistoryResponse = await DataService.getWrodks('worksList');
                workHistoryData.value = workHistoryResponse.data;

                // Fetch Address data
                const addressResponse = await DataService.getAddress('listAddress');
                addressData.value = addressResponse.data;
            } catch (error) {
                console.error('Error fetching data:', error);
            }
        });
         // Calculate age based on date of birth
        const calculateAge = (dateOfBirth) => {
            const today = new Date();
            const birthDate = new Date(dateOfBirth);
            const age = today.getFullYear() - birthDate.getFullYear();
            const monthDiff = today.getMonth() - birthDate.getMonth();

            if (monthDiff < 0 || (monthDiff === 0 && today.getDate() < birthDate.getDate())) {
                return age - 1;
            } else {
                return age;
            }
        };
        
        const personalInfoWithAge = computed(() => {
            return personalInfo.value.map(info => ({
                ...info,
                age: calculateAge(info.dateOfBirth),
            }));
        });

        return {
            personalInfo:personalInfoWithAge,
            educationData,
            workHistoryData,
            addressData,
        };
    },
};
</script>
<template>
    <main>
        <div class="container px-3 py-5 px-md-5 text-center text-lg-start my-5 ">
            <div class="row gx-lg-5 align-items-center mb-5">
                <div class="scrollable-section">
                     <h1>Personal Information</h1>
                    <table class="table table-bordered table-hover">
                        <thead>
                            <tr>
                                <th>NIE</th>
                                <th>FirstName</th>
                                <th>LastName</th>
                                <th>Gender</th>
                                <th>Age</th>
                                <th>Nationality</th>
                                <th>Phone</th>
                                <th>Email</th>

                            </tr>
                        </thead>
                        <tbody>
                            <template v-for="(info, index) in personalInfo"> <tr :key="info.id" v-if="index < 5">
                                <td>{{ info.identityNumber }}</td>
                                <td>{{ info.firstName }}</td>
                                <td>{{ info.lastName }}</td>
                                <td>{{ info.gender.name }}</td>
                                <td>{{ info.age }}</td>
                                <td>{{ info.nationality.name }}</td>
                                <td>{{ info.contactNumber }}</td>
                                <td>{{ info.emailAddress }}</td>
                                </tr>
                            </template>
                        </tbody>
                    </table>
                </div>
               
                <div class="scrollable-section">
                        <h1>Education</h1>
                    <table class="table table-bordered table-hover">
                        <thead>
                            <tr>
                                <th>Institution</th>
                                <th>Degree</th>
                                <th>Field</th>
                                <th>Start-Date</th>
                                <th>Graduation-Date</th>
                            </tr>
                        </thead>
                        <tbody>
                            <template v-for="(education, index) in educationData">
                                <tr :key="education.id" v-if="index < 5">
                                <td>{{ education.institution }}</td>
                                <td>{{ education.degree }}</td>
                                <td>{{ education.fieldOfStudy }}</td>
                                <td>{{ education.startDate }}</td>
                                <td>{{ education.graduationDate }}</td>
                                </tr>
                            </template>
                        </tbody>
                    </table>
                </div>
                <div class="scrollable-section">
                    <h1>Work Experience</h1>
                    <table class="table table-bordered table-hover">
                        <thead>
                            <tr>
                                <th>Employer</th>
                                <th>Job Tilte</th>
                                <th>Start-Date</th>
                                <th>End-Date</th>
                            </tr>
                        </thead>
                        <tbody>
                            <template v-for="(works, index) in workHistoryData"> <tr :key="works.id" v-if="index < 5">
                                <td>Employer{{ works.employer }}</td>
                                <td>JobTitle{{ works.jobTitle }}</td>
                                <td>Start-Dag{{ works.startDate }}</td>
                                <td>End-Date{{ works.endDate }}</td>
                                </tr>   
                            </template>
                        </tbody>
                    </table>
                </div>
                <div class="scrollable-section">
                      <h1>Address</h1>
                    <table class="table table-bordered table-hover">
                        <thead>
                            <tr>
                                <th>Street</th>
                                <th>City </th>
                                <th>State</th>
                                <th>Postal Code</th>
                                <th>Country</th>
                            </tr>
                        </thead>
                        <tbody>
                        <template v-for="(addr ,index) in addressData"> <tr :key="addr.id" v-if="index < 5">
                            <td>{{ addr.streetAddress }}</td>
                            <td>{{ addr.city }}</td>
                            <td>{{ addr.state }}</td>
                            <td>{{ addr.postalCode }}</td>
                            <td>{{ addr.country }}</td>
                            </tr>
                        </template>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </main>
</template>

<style scoped>
.container {

    background-color: #053970;
    border-radius: 20px;
    box-shadow: 0px 0px 20px rgb(252, 237, 232);
    opacity: 90%;
    z-index: 10;
    font-family: 'Courier New', Courier, monospace;
    font-size: large;
    color: hsl(218, 81%, 95%);
}

.scrollable-section {
    max-height: 200px;
    overflow-y: auto;
    position: relative;
}
.scrollable-section h1{
    position: sticky;
    top:0;
    z-index: 2;
     background-color: #053970;
}
.scrollable-section th{
    position: sticky;
    top:0;
    z-index: 2;
    opacity: 50%;
}

th{
    font-size: larger;
}
.header{
    position: sticky;
}
</style>

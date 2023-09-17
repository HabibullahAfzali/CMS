<script setup>
import { ref, defineEmits } from 'vue';

const addressData = ref({
    streetAddress: '',
    city: '',
    state: '',
    postalCode: '',
    country: ''
});
const { emit } = defineEmits(['next-step']);
const nextStep = () => {
    const newInfo = { ...addressData.value };
    emit('next-step', newInfo);
};
</script>

<template>
    <main>
        <div class="my-5">
            <div class="mx-auto w-25" style="max-width: 100%;">
                <h2 class="text-center mb-3">Address</h2>
                <form @submit.prevent="nextStep">
                    <div class="row">
                        <div class="col-md-12 form-group mb-3">
                            <label for="streetAddress" class="form-label">Street Address</label>
                            <input id="streetAddress" type="text" class="form-control" placeholder="Street Address" required
                                v-model="addressData.streetAddress">
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-12 form-group mb-3">
                            <label for="city" class="form-label">City</label>
                            <input id="city" type="text" class="form-control" placeholder="City" required
                                v-model="addressData.city">
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-12 form-group mb-3">
                            <label for="state" class="form-label">State</label>
                            <input id="state" type="text" class="form-control" placeholder="State" required
                                v-model="addressData.state">
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-12 form-group mb-3">
                            <label for="postalCode" class="form-label">Postal Code</label>
                            <input id="postalCode" type="text" class="form-control" placeholder="Postal Code" required
                                v-model="addressData.postalCode">
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-12 form-group mb-3">
                            <label for="country" class="form-label">Country</label>
                            <input id="country" type="text" class="form-control" placeholder="Country" required
                                v-model="addressData.country">
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

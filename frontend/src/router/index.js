import { createRouter, createWebHistory } from "vue-router";
import Login from "../views/auth/LoginView.vue";
import dashboard from "../components/Dashboard.vue";
import dataReview from "../components/DataReview.vue";
import createUser from "../views/auth/RegisterView.vue";
import viewUser from "../views/auth/ListUsersView.vue";
import updateUser from "../views/auth/UpdateUserView.vue";
import assignRole from "../views/auth/RoleAssignView.vue";
import address from "../views/RegistrationForm/AddressView.vue";
import viewArticle from "../views/Publication/ViewArticle.vue";
import addArticle from "../views/Publication/AddArticle.vue";
import education from "../views/RegistrationForm/EducationView.vue";
import workHistory from "../views/RegistrationForm/WorkHistoryView.vue";
import personalInfo from "../views/RegistrationForm/PersonalInfoView.vue";

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: "/",
      name: "",
      component: Login,
    },
    {
      path: "/register",
      name: "register",
      component: createUser,
    },
    {
      path: "/roleassign",
      name: "roleassgin",
      component: assignRole,
      meta: { requiredRole: "ADMIN" },
    },
    {
      path: "/ViewUser",
      name: "ViewUser",
      component: viewUser,
    },
    {
      path: "/update/:id",
      name: "edit",
      component: updateUser,
    },
    {
      path: "/addarticle",
      name: "addarticle",
      component: addArticle,
    },
    {
      path: "/Viewarticle",
      name: "View",
      component: viewArticle,
    },
    {
      path: "/dashboard",
      name: "dashboard",
      component: dashboard,
    },
    {
      path: "/personalInfo",
      name: "PersonalInfo",
      component: personalInfo,
    },
    {
      path: "/education",
      name: "EducationView",
      component: education,
    },
    {
      path: "/workhistory",
      name: "WorkView",
      component: workHistory,
    },
    {
      path: "/address",
      name: "AddressView",
      component: address,
    },
    {
      path: "/datareview",
      name: "dataReview",
      component: dataReview,
    },
  ],
});

export default router;

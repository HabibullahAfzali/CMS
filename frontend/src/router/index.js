import { createRouter, createWebHistory } from "vue-router";
import Login from "../views/auth/LoginView.vue";

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
      component: () => import("../views/auth/RegisterView.vue"),
    },
    {
      path: "/roleassign",
      name: "roleassgin",
      component: () => import("../views/auth/RoleAssignView.vue"),
    },
    {
      path: "/ViewUser",
      name: "ViewUser",
      component: () => import("../views/auth/ListUsersView.vue"),
    },
    {
      path: "/update/:id",
      name: "edit",
      component: () => import("../views/auth/UpdateUserView.vue"),
    },
    {
      path: "/addarticle",
      name: "addarticle",
      component: () => import("../views/Publication/AddArticle.vue"),
    },
    {
      path: "/Viewarticle",
      name: "View",
      component: () => import("../views/Publication/ViewArticle.vue"),
    },
    {
      path: "/dashboard",
      name: "dashboard",
      component: () => import("../components/Dashboard.vue"),
    },
    {
      path: "/address",
      name: "AddressView",
      component: () => import("../views/RegistrationForm/AddressView.vue"),
    },
    {
      path: "/education",
      name: "EducationView",
      component: () => import("../views/RegistrationForm/EducationView.vue"),
    },
    {
      path: "/personalInfor",
      name: "PersonalInfo",
      component: () => import("../views/RegistrationForm/PersonalInfoView.vue"),
    },
    {
      path: "/workhistory",
      name: "AddressView",
      component: () => import("../views/RegistrationForm/WorkHistoryView.vue"),
    },
  ],
});

export default router;

import { createRouter, createWebHistory } from "vue-router";
import Login from "../views/LoginView.vue";

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
      component: () => import("../views/RegisterView.vue"),
    },
    {
      path: "/roleassign",
      name: "roleassgin",
      component: () => import("../views/RoleAssignView.vue"),
    },
    {
      path: "/ViewUser",
      name: "ViewUser",
      component: () => import("../views/ListUsersView.vue"),
    },
    {
      path: "/edit/:id",
      name: "edit",
      component: () => import("../views/UpdateUser.vue"),
    },
    {
      path: "/addarticle",
      name: "addarticle",
      component: () => import("../views/AddArticle.vue"),
    },
    {
      path: "/Viewarticle",
      name: "View",
      component: () => import("../views/ViewArticle.vue"),
    },
    {
      path: "/dashboard",
      name: "dashboard",
      component: () => import("../views/Dashboard.vue"),
    },
  ],
});

export default router;

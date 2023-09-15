import { createRouter, createWebHistory } from "vue-router";
import Dashboard from "../views/Dashboard.vue";

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: "/",
      name: "",
      component: Dashboard,
    },
    {
      path: "/adduser",
      name: "adduser",
      component: () => import("../views/AddUser.vue"),
    },
    {
      path: "/ViewUser",
      name: "ViewUser",
      component: () => import("../views/ViewUser.vue"),
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
  ],
});

export default router;

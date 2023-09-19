import { createStore } from "vuex";

const store = createStore({
  state: {
    user: null, // This will hold user information, including roles
  },
  mutations: {
    setUser(state, user) {
      state.user = user;
    },
  },
  actions: {
    login({ commit }, userData) {
      // Simulate a login API call and set user data in the store
      // Replace this with your actual login logic
      // For example, call your backend API to authenticate the user
      // and retrieve user data, including roles
      const user = { username: userData.username, roles: userData.roles };
      commit("setUser", user);
    },
  },
  getters: {
    isLoggedIn: (state) => !!state.user,
    userRoles: (state) => (state.user ? state.user.roles : []),
  },
});

export default store;

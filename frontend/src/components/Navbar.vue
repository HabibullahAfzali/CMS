<template>
    <main>
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
            <div class="container-fluid">
                 <router-link to="/" class="navbar-brand">
              <img src="../assets/Images/logo3.jpg" alt="Logo" class="logo-img">
            </router-link>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
                    data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false"
                    aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                        <router-link to="/" exact class="nav-link" exact-active-class="active">Home</router-link>
                        <router-link to="/adduser" class="nav-link" exact-active-class="active">Add</router-link>
                        <router-link to="/ViewUser" class="nav-link" exact-active-class="active">Users</router-link>
                        <router-link to="/addarticle" class="nav-link" exact-active-class="active">New Article</router-link>
                        <router-link to="/forproccess" class="nav-link" exact-active-class="active">RegistrationForm</router-link>
                    </ul>
                </div>
            </div>
        </nav>
    </main>
</template>

<style scoped>
.navbar-nav .nav-link.active {
    color: #fff;
}
.logo-img {
  max-height: 40px; /* Adjust as needed */
  margin-right: 10px;
  border-radius: 10%;
}
</style>
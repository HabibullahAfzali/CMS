<template>
    <main>
        <nav class="navbar navbar-expand-lg navbar-dark" style=" font-family: 'Courier New', Courier, monospace; font-size: 20px;">
        
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
                        <router-link to="/register" class="nav-link" exact-active-class="active">New account</router-link>
                        <router-link to="/personalInfo" class="nav-link" exact-active-class="active">Registration-Form</router-link>
                    </ul>
                </div>
            </div>
        </nav>
    </main>
</template>

<style scoped>
.navbar{
      border-bottom: 5px dotted hsl(207, 86%, 48%);
}


.navbar-nav .nav-link:hover {
    font-weight: bold;
    transform: scale(1.1);
}

.logo-img {
    transition: transform 0.3s ease;
    max-height: 60px;
    margin-right: 10px;
    border-radius: 10%;
    overflow: hidden;
}
.logo-img:hover{
    transform: scale(1.1);
}
</style>

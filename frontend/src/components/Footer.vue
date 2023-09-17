<template>
   <div class="page-wrapper">
          <footer>
            <div class="footer-content">
              <div class="footer-icons">
              </div>
              <p>&copy; 2023 CMS. All rights reserved.</p>
            </div>
          </footer>
        </div>
</template>
<style scoped>
.page-wrapper {
    display: flex;
    flex-direction: column;
    min-height: 100vh;
}
footer {
    background-color: #48cae4;
    color: whitesmoke;
    text-align: center;
    height: 6rem;
    padding: 10px 0;
    margin-top: auto;
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.3);
    overflow-y: auto;
}

.footer-content {
    margin: 1rem;
    font-family: 'Courier New', Courier, monospace;
    font-size: large;
    display: flex;
    flex-direction: column;
    align-items: center;

}

.footer-icons {
    color: gold;
}

footer p {
    margin: 0;
}
</style>
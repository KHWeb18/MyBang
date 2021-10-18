<template>
  <div class="home">
    <div id="header">
      <router-link :to="{ name: 'Home' }"
              class="nav-link"
              active-class="active">
          Home
      </router-link>
      <router-link :to="{ name: 'MainPage' }"
              class="nav-link"
              active-class="active">
          MainPage
      </router-link>
      <router-link :to="{ name: 'MemberRegisterPage' }"
              class="nav-link"
              active-class="active">
          회원가입
      </router-link>
    </div>
  </div>
</template>

<script>

  export default {
    name: 'Home',
    components: {
    },
  }
</script>

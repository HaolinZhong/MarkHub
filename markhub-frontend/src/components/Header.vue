<template>
  <div class="m-content">
    <h3>Welcome to Mark Hub!</h3>
    <div class="block">
      <div class="block">
        <el-avatar :size="50" :src="user.avatar"></el-avatar>
      </div>
      <div>{{user.name}}</div>
      <div class="maction">
        <span>
          <el-link href="/blogs">Homepage</el-link>
        </span>
        <el-divider direction="vertical"></el-divider>
        <span>
          <el-link type="success" href="/blog/add">New Blog</el-link>
        </span>

        <el-divider direction="vertical"></el-divider>
        <span v-show="!hasLogin">
          <el-link type="primary" @click="login">Login</el-link>
        </span>
        <span v-show="hasLogin">
          <el-link type="danger" @click="logout">Logout</el-link>
        </span>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "Header"
  , data () {
    return {
      user: {
        name: 'please login',
        avatar: 'https://cube.elemecdn.com/3/7c/3ea6beec64369c2642b92c6726f1epng.png'
      },
      hasLogin: false
    }
  },
  methods: {
    logout () {
      const _this = this
      _this.$axios.get("/logout", {
        headers: {
          "Authorization": localStorage.getItem("token")
        }
      }).then(res => {
        _this.$store.commit("REMOVE_INFO")
        _this.$router.push("/login")
      })
    },
    login () {
      this.$router.push("/login")
    }
  },
  // get user info when created
  created () {
    if (this.$store.getters.getUser && this.$store.getters.getUser.name) {
      this.user.name = this.$store.getters.getUser.name
      this.user.avatar = this.$store.getters.getUser.avatar
      this.hasLogin = true;
    } else {
      this.$store.commit("REMOVE_INFO")
    }
  }
}
</script>

<style>

@import url('https://fonts.googleapis.com/css2?family=Lato:wght@700&display=swap');

.m-content {
  max-width: 960px;
  margin: 0 auto;
  text-align: center;
  font-family: 'Lato', sans-serif;
}
.maction {
}
</style>

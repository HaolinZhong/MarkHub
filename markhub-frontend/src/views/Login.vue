<template>
  <div>
    <el-container>
      <el-header>
        <img class="mlogo" src="../assets/mylogo.png" alt="logo pic" />
      </el-header>
      <el-main>
        <el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm">
          <el-form-item label="Username" prop="username" style="margin-right: 15%">
            <el-input v-model="ruleForm.username"></el-input>
          </el-form-item>
          <el-form-item label="Password" prop="password" style="margin-right: 15%">
            <el-input v-model="ruleForm.password" show-password></el-input>
          </el-form-item>
          <el-form-item>
            <el-button type="primary" @click="submitForm('ruleForm')">Login</el-button>
            <el-button @click="register">
              <router-link :to="{name: 'Register'}" style="text-decoration: none">
                Register
              </router-link>
            </el-button>
            <el-button
              style="margin-right: 20%"
            >
              <router-link :to="{name: 'Blogs'}" style="text-decoration: none">
                Guests View
              </router-link>
            </el-button>
          </el-form-item>
        </el-form>
      </el-main>
    </el-container>
  </div>
</template>

<script>
export default {
  name: "Login",
  data () {
    return {
      ruleForm: {
        username: '',
        password: ''
      },
      rules: {
        username: [
          { required: true, message: 'Please enter your username', trigger: 'blur' },
          { min: 3, max: 15, message: 'Length should be between 3 and 15 characters', trigger: 'blur' }

        ],
        password: [
          { required: true, message: 'Please enter your password', trigger: 'blur' }
        ]
      }
    };
  },
  methods: {
    submitForm (formName) {
      this.$refs[formName].validate((valid) => {
        if (valid) {
          this.$axios.post("/login", this.ruleForm).then(res => {
            const jwt = res.headers['authorization'];
            const userInfo = res.data.data
            // set jwt & userInfo in store
            this.$store.commit("SET_TOKEN", jwt);
            this.$store.commit("SET_USERINFO", userInfo);
            this.$router.push("/blogs");
          })
        } else {
          return false;
        }
      });
    }
  }
}
</script>



<style scoped>


.el-container {
  padding-top: 10%;
}

.el-header {
  color: #333;
  text-align: center;
  line-height: 60px;
}

.el-main {
  /* background-color: #e9eef3; */
  color: #333;
  text-align: center;
  line-height: 160px;
}

.mlogo {
  height: 80%;
  margin-top: 5px;
}

.demo-ruleForm {
  max-width: 500px;
  margin: 0 auto;
}
</style>

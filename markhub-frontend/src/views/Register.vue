<template>
  <div>
    <el-container>
      <el-header>
        <img class="mlogo" src="../assets/mylogo.png" alt="logo pic" />
      </el-header>
      <el-main>
        <el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm">
          <el-form-item label="Username" prop="username" style="margin-right: 15%">
            <el-input v-model="ruleForm.username" placeholder="enter your user name"></el-input>
          </el-form-item>
          <el-form-item label="Avatar Link" prop="avatar" style="margin-right: 15%">
            <el-input v-model="ruleForm.avatar" placeholder="(optional) enter the link to your avatar image"></el-input>
          </el-form-item>
          <el-form-item label="Password" prop="password" style="margin-right: 15%">
            <el-input v-model="ruleForm.password" show-password placeholder="enter your password"></el-input>
          </el-form-item>
          <el-form-item label="Confirm" prop="confPassword" style="margin-right: 15%">
            <el-input v-model="ruleForm.confPassword" show-password placeholder="confirm your password"></el-input>
          </el-form-item>
          <el-form-item>
            <el-button type="primary" @click="submitForm('ruleForm')">
              Register
            </el-button>
            <el-button
              style="margin-right: 25%"
            >
              <router-link :to="{name: 'Login'}" style="text-decoration: none">
                Back to Login
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
  name: "Register",
  data () {
    return {
      ruleForm: {
        username: '',
        password: '',
        confPassword: '',
        avatar: '',
      },
      rules: {
        username: [
          { required: true, message: 'Please enter your username', trigger: 'blur' },
          { min: 3, max: 15, message: 'Length should be between 3 and 15 characters', trigger: 'blur' }

        ],
        password: [
          { required: true, message: 'Please enter your password', trigger: 'blur' }
        ],
        confPassword: [
          { required: true, message: 'Please confirm your password', trigger: 'blur'}
        ]
      }
    };
  },
  methods: {
    submitForm (formName) {
      this.$refs[formName].validate((valid) => {
        if (valid) {
          this.$axios.post("/user/create", this.ruleForm).then(res => {
            this.$message({
              type: 'success',
              message: "Successfully Registered!"
            });
            this.$router.push("/login");
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

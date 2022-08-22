<template>
  <div>
    <Header/>
    <div class="m-content">
      <el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm">

        <el-form-item label="Title" prop="title">
          <el-input v-model="ruleForm.title"></el-input>
        </el-form-item>

        <el-form-item label="Abstract" prop="description">
          <el-input type="textarea" v-model="ruleForm.description"></el-input>
        </el-form-item>

        <el-form-item label="Content" prop="content">
          <mavon-editor
            v-model="ruleForm.content"
            placeholder="This editor supports Markdown syntax. Enter your content..."
            language="en"
          />
        </el-form-item>

        <el-form-item>
          <el-button type="primary" @click="submitForm('ruleForm')" v-text="isNew? 'Create':'Edit'"></el-button>
          <el-button @click="resetForm('ruleForm')">Reset</el-button>
        </el-form-item>
      </el-form>
    </div>
  </div>

</template>

<script>
import Header from "../components/Header";

export default {
  name: "BlogEdit.vue",
  components: {Header},
  data() {
    return {
      isNew: !this.$route.params.blogId,
      ruleForm: {
        id: '',
        title: '',
        userId: '',
        description: '',
        content: ''
      },
      rules: {
        title: [
          {required: true, message: 'Please enter the title', trigger: 'blur'},
          {min: 3, max: 50, message: 'Title length should be between 3 to 15 characters', trigger: 'blur'}
        ],

        description: [
          {required: true, message: 'Please enter the abstract', trigger: 'blur'},
        ],
        content: [
          {required: true, message: 'Please enter the content', trigger: 'blur'},
        ]
      }
    }
  },
  methods: {
    submitForm (formName) {
      this.$refs[formName].validate((valid) => {
        if (valid) {

          if (this.isNew) {
            this.$axios.post('/blog/create', this.ruleForm, {
              headers: {
                "Authorization": localStorage.getItem("token")
              }
            }).then(res => {
              this.$alert('Blog Created!', 'Result', {
                confirmButtonText: 'OK',
                callback: action => {
                  this.$router.push("/blogs")
                }
              });
            })
          } else {
            this.$axios.post('/blog/edit', this.ruleForm, {
              headers: {
                "Authorization": localStorage.getItem("token")
              }
            }).then(res => {
              this.$alert('Blog Edited!', 'Result', {
                confirmButtonText: 'OK',
                callback: action => {
                  this.$router.push("/blogs")
                }
              });
            })
          }
        } else {
          return false;
        }
      });
    },
    resetForm (formName) {
      this.$refs[formName].resetFields();
    }
  },
  created() {
    const blogId = this.$route.params.blogId
    if (blogId) {
      this.$axios.get("/blog/get/" + blogId).then(res => {
        const blog = res.data.data
        this.ruleForm.id = blog.id
        this.ruleForm.userId=blog.userId
        this.ruleForm.title = blog.title
        this.ruleForm.description = blog.description
        this.ruleForm.content = blog.content
      })
    }
  },
}
</script>

<style scoped>
.m-content {
  margin-top: 20px;
  text-align: center;
}
</style>

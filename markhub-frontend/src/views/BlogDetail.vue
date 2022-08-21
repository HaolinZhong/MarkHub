<template>
  <div>
    <Header/>
    <div class="blog">

      <h2>
        {{ blog.title }}
      </h2>
      <div id="editBtnDiv">
        <el-button
          type="primary"
          @click="editBlog"
          v-if="isCreator"
        >Edit
        </el-button>
      </div>

      <el-divider/>
      <div class="markdown-body" v-html="blog.content"/>
    </div>
  </div>
</template>

<script>
import '../assets/github-markdown-light.css'
import Header from "../components/Header"
import MarkdownIt from "markdown-it"

const md = new MarkdownIt()

export default {
  name: "BlogDetail.vue",
  components: {Header},
  data() {
    return {
      blog: {
        id: '',
        title: '',
        content: '',
        description: ''
      },
      isCreator: false
    }
  },
  methods: {
    editBlog() {
      this.$router.push(`${this.blog.id}/edit`)
    }
  },
  created() {
    const blogId = this.$route.params.blogId
    if (blogId) {
      this.$axios.get("/blog/get/" + blogId).then(res => {
        const blog = res.data.data
        this.blog.id = blog.id
        this.blog.title = blog.title
        this.blog.description = blog.description
        this.blog.content = md.render(blog.content)
        this.isCreator = (blog.userId === this.$store.getters.getUser.id)
      })
    }
  }
}
</script>


<style scoped>
@import url('https://fonts.googleapis.com/css2?family=Lato:wght@700&display=swap');

.blog {
  margin: 50px auto;
  box-shadow: 0 2px 12px 0 rgba(0, 0, 0, 0.1);
  width: 70%;
  min-height: 700px;
  padding: 50px;
}

#editBtnDiv {
  display: inline;
  float: right;
}

.markdown-body {
  margin-top: 50px;
}

h2 {
  font-family: 'Lato', sans-serif;
  display: inline;
}


</style>

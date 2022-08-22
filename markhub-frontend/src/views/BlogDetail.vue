<template>
  <div>
    <Header/>
    <div class="blog">

      <div style="display: flex; vertical-align: center">
        <h1>
          {{ blog.title }}
        </h1>
        <div id="editBtnDiv" style="margin-left: auto; justify-content: flex-end; margin-top: 20px">
          <el-button
            type="primary"
            @click="editBlog"
            v-if="isCreator"
            plain
            icon="el-icon-edit"
            circle
          />
          <el-button
            type="danger"
            @click="deleteBlog"
            v-if="isCreator"
            plain
            icon="el-icon-delete"
            circle
          />
        </div>
      </div>


      <div class="creatorInfo">
        <el-avatar :size="40" :src="creator.avatar"></el-avatar>
        <h3 v-text="creator.name" id="author"/>
        <p v-text="`published on ${blog.createdAt}`" id="date"></p>
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
        description: '',
        createdAt: ''
      },
      creator: {
        avatar: '',
        name: ''
      },
      isCreator: false
    }
  },
  methods: {
    editBlog() {
      this.$router.push(`${this.blog.id}/edit`)
    },
    deleteBlog() {
      const blogId = this.$route.params.blogId
      if (blogId) {
        this.$confirm('The blog will be deleted permanently. Are you sure?', 'Warning', {
          confirmButtonText: 'Confirm',
          cancelButtonText: 'Cancel',
          type: 'warning'
        }).then(() => {
          this.$axios.post(`/blog/delete/${blogId}`, null, {
            headers: {
              "Authorization": localStorage.getItem("token")
            }
          }).then(res => {
            this.$message({
              type: 'success',
              message: res.data.data
            });
            this.$router.push("/blogs")
          })

        }).catch(() => {

          this.$message({
            type: 'info',
            message: 'Operation Cancelled'
          });
        });
      }
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
        this.blog.createdAt = blog.createdAt
        this.blog.content = md.render(blog.content)
        this.isCreator = this.$store.getters.getUser && (blog.userId === this.$store.getters.getUser.id)

        this.$axios.get(`/user/get?id=${blog.userId}`).then(res => {
          const creator = res.data.data
          this.creator.avatar = creator.avatar
          this.creator.name = creator.name
        })

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


.markdown-body {
  margin-top: 50px;
}

h1 {
  font-family: 'Lato', sans-serif;
}

.creatorInfo {
  font-family: 'Lato', sans-serif;
  padding-top: 30px;
  vertical-align: center;
  display: flex;
  align-items: center;
  margin-bottom: 0;
}

#author {
  margin-left: 10px;
  justify-content: start;
}

#date {
  justify-content: flex-end;
  margin-left: auto;
}


</style>

<template>
  <div>
    <Header />
    <div class="block">
      <el-header>
        <el-input
          @keyup.enter.native="search"
          v-model="searchTitle"
          class="m-search"
          placeholder="press ENTER to search for blogs according to title"
          prefix-icon="el-icon-search"
        />
      </el-header>
      <el-timeline>
        <el-timeline-item :timestamp="blog.createdAt" placement="top" v-for="(blog,key) in blogs" :key=key>
          <el-card>
            <h2>
              <router-link :to="{name: 'BlogDetail', params: {blogId: blog.id}}" class="blog-title">
                {{blog.title}}
              </router-link>
              <el-button
                v-if="currentUser && currentUser == blog.userId"
                @click="deleteBlog(blog.id)"
                style="float: right;"
                type="danger"
                plain
                icon="el-icon-delete"
                circle
              />

              <router-link :to="{name: 'BlogEdit',params:{blogId: blog.id}}">
                <el-button
                  v-if="currentUser && currentUser == blog.userId"
                  style="float: right; margin-right: 10px"
                  type="primary"
                  plain
                  icon="el-icon-edit"
                  circle
                />
              </router-link>
            </h2>
            <p>{{blog.description}}</p>
          </el-card>
        </el-timeline-item>

      </el-timeline>

      <el-pagination class="mage"
                     background
                     layout="prev, pager, next"
                     :current-page="currentPage"
                     :page-size="pageSize"
                     :total="total"
                     @current-change=page>
      </el-pagination>
    </div>
  </div>
</template>

<script>
import Header from "../components/Header";

export default {
  name: "Blogs.vue",
  components: {Header},
  data () {
    return {
      blogs: {},
      currentPage: 1,
      total: 0,
      pageSize: 5,
      searchTitle: '',
      currentUser: null
    }
  },
  methods: {
    page (currentPage) {
      this.$axios.get("/blog/list?page=" + currentPage).then(res => {
        const data = res.data.data
        this.blogs = data.rows
        this.currentPage = data.currentPage
        this.pageSize = data.pageSize
        this.total = data.total
      })
    },

    deleteBlog(id) {
        this.$confirm('The blog will be deleted permanently. Are you sure?', 'Warning', {
          confirmButtonText: 'Confirm',
          cancelButtonText: 'Cancel',
          type: 'warning'
        }).then(() => {
          this.$axios.post(`/blog/delete/${id}`, null, {
            headers: {
              "Authorization": localStorage.getItem("token")
            }
          }).then(res => {
            this.$message({
              type: 'success',
              message: res.data.data
            });
            location.reload();
          })

        }).catch(() => {
          this.$message({
            type: 'info',
            message: 'Operation Cancelled'
          });
        });
    },

    search(){
      this.$axios.get("/blog/findByTitle?title=" + this.searchTitle).then(res => {
        const data = res.data.data
        this.blogs = data.rows
        this.currentPage = data.currentPage
        this.pageSize = data.pageSize
        this.total = data.total
      })
    },

  },
  created () {
    this.page(1)
    if (this.$store.getters.getUser) {
      this.currentUser = this.$store.getters.getUser.id
    }
  }
}
</script>

<style scoped>
@import url('https://fonts.googleapis.com/css2?family=Lato:wght@700&display=swap');
.block {
  margin-top: 20px;
  margin-left: 300px;
  margin-right: 350px;
}

.mage {
  margin-top: 50px;
  text-align: center;
}

.m-search{
  max-width: 60%;
  margin-left: 24%;
}

.blog-title {
  font-family: 'Lato', sans-serif;
  text-decoration: none;
}

.el-card {
  text-transform: capitalize;
}

</style>

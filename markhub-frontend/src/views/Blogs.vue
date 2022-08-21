<template>
  <div>
    <Header />
    <div class="block">
      <el-timeline>
        <el-timeline-item :timestamp="blog.createdAt" placement="top" v-for="(blog,key) in blogs" :key=key>
          <el-card>
            <h2>
              <router-link :to="{name: 'BlogDetail', params: {blogId: blog.id}}" class="blog-title">
                {{blog.title}}
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
      pageSize: 5
    }
  },
  methods: {
    page (currentPage) {
      const _this = this
      _this.$axios.get("/blog/list?page=" + currentPage).then(res => {
        const data = res.data.data
        _this.blogs = data.rows
        _this.currentPage = data.currentPage
        _this.pageSize = data.pageSize
        _this.total = data.total
      })
    }
  },
  created () {
    this.page(1)
  }
}
</script>

<style scoped>
@import url('https://fonts.googleapis.com/css2?family=Lato:wght@700&display=swap');
.block {
  margin: 20px 300px;
}

.mage {
  margin-top: 50px;
  text-align: center;
}

.blog-title {
  font-family: 'Lato', sans-serif;
  text-decoration: none;
}

.el-card {
  text-transform: capitalize;
}

</style>

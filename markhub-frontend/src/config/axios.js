import axios from 'axios'
import Element from 'element-ui'
import store from '../store';
import router from '../router'

// default baseUrl
axios.defaults.baseURL= "http://localhost:8081/";

// request interceptor
axios.interceptors.request.use(config => {
  return config
})

// response interceptor
axios.interceptors.response.use(response=>{
    let res = response.data;
    if(res.status == "success"){
      return response
    }else{
      Element.Message.error(res.data.errMsg, {duration : 2*1000})
      return Promise.reject(res.data.errMsg)
    }

  },error=>{
    if (error.response.data) {
      error.message = error.response.data.msg
      console.log(error.message)
    }
    Element.Message.error(error.message)
    return Promise.reject(error)
  }

)

import axios from 'axios'
import Element from 'element-ui'
import store from '../store';
import router from '../router'

let s = window.location.toString();
let s1 = s.substr(7,s.length);
let s2 = s1.indexOf("/");
s = s.substr(0,8+s2);
const a = "http://localhost:8081/";

// default baseUrl
axios.defaults.baseURL= a

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
    if(error.response.status == 401){
      store.commit('REMOVE_INFO')
      router.push("/login")
    }
    Element.Message.error(error.message)

    return Promise.reject(error)
  }

)

import Vue from 'vue'
import Vuex from 'vuex';

Vue.use(Vuex)

export default new Vuex.Store({
  // state is a global variable that can be accessed by other pages
  state: {
    token: '', // localStorage.getItem("token")
    // get user info from sessionStorage by deserialization
    userInfo: JSON.parse(sessionStorage.getItem("userInfo"))
  },
  mutations: {
    SET_TOKEN:(state,token)=>{
      state.token=token
      localStorage.setItem("token",token)
    },
    SET_USERINFO:(state,userInfo)=>{
      state.userInfo=userInfo
      // sessionStorage can only store string, so we use serialization
      sessionStorage.setItem("userInfo", JSON.stringify(userInfo))
    },
    REMOVE_INFO:(state)=>{
      state.token = '';
      state.userInfo = {};
      localStorage.setItem("token",'')
      sessionStorage.setItem("userInfo", JSON.stringify(''))
    }
  },
  getters: {
    getUser: state=>{
      return state.userInfo;
    },
    getToken: state=>{
      return state.token;
    }
  },
  actions: {

  },
  modules: {

  }
})


import {
  // Login
  FETCH_USER_INFO,
  FETCH_SESSION,
  FETCH_MEMBER_LIST,
  FETCH_MEMBER,

  // 매물 게시판
  FETCH_PRODUCT_LIST,
  FETCH_PRODUCT,
  FETCH_VILLA_LIST,
  FETCH_VILLA,
  FETCH_OFFICETEL_LIST,
  FETCH_OFFICETEL,
  FETCH_ONEROOM_LIST,
  FETCH_ONEROOM,

  // 찜하기
  FETCH_LIKED_PRODUCT_LIST,
  FETCH_PRODUCT_INFO,

  // 사업자별 매물등록구분
  FETCH_AGENT_VILLA,
  FETCH_AGENT_OFFICETEL,
  FETCH_AGENT_ONEROOM,
  FETCH_GONGZI_LIST,
  FETCH_GONGZI,
  FETCH_SOGAE_LIST,
  FETCH_SOGAE,

  //뉴스 크롤링
  CRAWL_START,
} from "./mutation-types";

import axios from "axios";
import cookies from "vue-cookies";

export default {
  fetchUserInfo({ commit }, userId) {
    return axios
      .get(`http://localhost:7777/member/mypage/${userId}`)
      .then((res) => {
        console.log(res.data);
        cookies.set("session", res.data.userId);
        commit(FETCH_USER_INFO, res.data);
      });
  },
  fetchSession({ commit }, session) {
    commit(FETCH_SESSION, session);
  },
  fetchMemberList({ commit }) {
    return axios.get("http://localhost:7777/member/memberlists").then((res) => {
      commit(FETCH_MEMBER_LIST, res.data);
    });
  },
  fetchMember({ commit }, memberNo) {
    return axios.get(`http://localhost:7777/member/${memberNo}`).then((res) => {
      commit(FETCH_MEMBER, res.data);
    });
  },
  // 매물 게시판
  fetchProductList({ commit }) {
    return axios.get("http://localhost:7777/product/list").then((res) => {
      commit(FETCH_PRODUCT_LIST, res.data);
    });
  },
  fetchProduct({ commit }, productNo) {
    return axios
      .get(`http://localhost:7777/product/${productNo}`)
      .then((res) => {
        commit(FETCH_PRODUCT, res.data);
      });
  },
  fetchVillaList({ commit }) {
    return axios.get("http://localhost:7777/villa/lists").then((res) => {
      commit(FETCH_VILLA_LIST, res.data);
    });
  },
  fetchVilla({ commit }, villaNo) {
    return axios.get(`http://localhost:7777/villa/${villaNo}`).then((res) => {
      commit(FETCH_VILLA, res.data);
    });
  },
  fetchOneroomList({ commit }) {
    return axios.get("http://localhost:7777/oneroom/lists").then((res) => {
      commit(FETCH_ONEROOM_LIST, res.data);
    });
  },
  fetchOneroom({ commit }, oneroomNo) {
    return axios
      .get(`http://localhost:7777/oneroom/${oneroomNo}`)
      .then((res) => {
        commit(FETCH_ONEROOM, res.data);
      });
  },
  fetchOfficetelList({ commit }) {
    return axios.get("http://localhost:7777/officetel/lists").then((res) => {
      commit(FETCH_OFFICETEL_LIST, res.data);
    });
  },
  fetchOfficetel({ commit }, officetelNo) {
    return axios
      .get(`http://localhost:7777/officetel/${officetelNo}`)
      .then((res) => {
        commit(FETCH_OFFICETEL, res.data);
      });
  },
  // 찜하기
  fetchLikedProductList({ commit }, payload) {
    return axios
      .get(`http://localhost:7777/product/likedProductList/${payload}`)
      .then((res) => {
        //alert(JSON.stringify(res.data))
        commit(FETCH_LIKED_PRODUCT_LIST, res.data);
      });
  },
  fetchProductInfo({ commit }, payload) {
    return axios
      .get(`http://localhost:7777/product/getProductInfo/${payload}`)
      .then((res) => {
        commit(FETCH_PRODUCT_INFO, res.data);
      });
  },
  // 사업자별 매물등록구분
  fetchAgentVilla({ commit }, agentId) {
    return axios
      .get(`http://localhost:7777/villa/list/${agentId}`)
      .then((res) => {
        commit(FETCH_AGENT_VILLA, res.data);
      });
  },
  fetchAgentOfficetel({ commit }, agentId) {
    return axios
      .get(`http://localhost:7777/officetel/list/${agentId}`)
      .then((res) => {
        commit(FETCH_AGENT_OFFICETEL, res.data);
      });
  },
  fetchAgentOneroom({ commit }, agentId) {
    return axios
      .get(`http://localhost:7777/oneroom/list/${agentId}`)
      .then((res) => {
        commit(FETCH_AGENT_ONEROOM, res.data);
      });
  },
  fetchGongziList({ commit }) {
    return axios.get("http://localhost:7777/gongzi/list").then((res) => {
      commit(FETCH_GONGZI_LIST, res.data);
    });
  },
  fetchGongzi({ commit }, gongziNo) {
    return axios.get(`http://localhost:7777/gongzi/${gongziNo}`).then((res) => {
      commit(FETCH_GONGZI, res.data);
    });
  },
  fetchSogaeList({ commit }) {
    return axios.get("http://localhost:7777/sogae/list").then((res) => {
      commit(FETCH_SOGAE_LIST, res.data);
    });
  },
  fetchSogae({ commit }, sogaeNo) {
    return axios.get(`http://localhost:7777/sogae/${sogaeNo}`).then((res) => {
      commit(FETCH_SOGAE, res.data);
    });
  },

  // 뉴스 크롤링
  async crawlFind({ commit }) {
    commit(CRAWL_START, "data");
    // axios.get("http://localhost:7777/" + `${category}`).then(({ data }) => {
    //   commit(CRAWL_START, data);

    //   // if (window.location.pathname !== '/daumNewsCrawler') {
    //   //     router.push('/daumNewsCrawler')
    //   // }
    // });
  },
};

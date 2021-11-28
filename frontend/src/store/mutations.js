import {
  // Login
  USER_LOGIN,
  FETCH_USER_INFO,
  FETCH_SESSION,
  FETCH_MEMBER_LIST,
  FETCH_MEMBER,

  // 매물게시판
  FETCH_PRODUCT_LIST,
  FETCH_PRODUCT,
  FETCH_GONGZI,
  FETCH_GONGZI_LIST,
  FETCH_VILLA_LIST,
  FETCH_VILLA,
  FETCH_OFFICETEL_LIST,
  FETCH_OFFICETEL,
  FETCH_ONEROOM_LIST,
  FETCH_ONEROOM,
  FETCH_AGENT_VILLA,
  FETCH_AGENT_ONEROOM,
  FETCH_AGENT_OFFICETEL,
  FETCH_SOGAE,
  FETCH_SOGAE_LIST,
  // 뉴스 크롤링
  CRAWL_START,
} from "./mutation-types";

export default {
  [USER_LOGIN](state, isLogin) {
    state.isLogin = isLogin;
    console.log("isLogin: " + isLogin);
  },
  [FETCH_USER_INFO](state, userInfo) {
    state.userInfo = userInfo;
    console.log(userInfo);
  },
  [FETCH_SESSION](state, session) {
    state.session = session;
  },
  [FETCH_MEMBER_LIST](state, members) {
    state.members = members;
  },
  [FETCH_MEMBER](state, member) {
    state.member = member;
  },
  [FETCH_PRODUCT_LIST](state, products) {
    state.products = products;
  },
  [FETCH_PRODUCT](state, product) {
    state.product = product;
  },

  [FETCH_GONGZI_LIST](state, gongzis) {
    state.gongzis = gongzis;
  },
  [FETCH_GONGZI](state, gongzi) {
    state.gongzi = gongzi;
  },

  [FETCH_VILLA_LIST](state, villas) {
    state.villas = villas;
  },
  [FETCH_VILLA](state, villa) {
    state.villa = villa;
  },
  [FETCH_ONEROOM_LIST](state, oneroomList) {
    state.oneroomList = oneroomList;
  },
  [FETCH_ONEROOM](state, oneroom) {
    state.oneroom = oneroom;
  },
  [FETCH_OFFICETEL_LIST](state, officetelList) {
    state.officetelList = officetelList;
  },
  [FETCH_OFFICETEL](state, officetel) {
    state.officetel = officetel;
  },
  [FETCH_AGENT_VILLA](state, agentVilla) {
    state.agentVilla = agentVilla;
  },
  [FETCH_AGENT_ONEROOM](state, agentOneroom) {
    state.agentOneroom = agentOneroom;
  },
  [FETCH_AGENT_OFFICETEL](state, agentOfficetel) {
    state.agentOfficetel = agentOfficetel;
  },
  [FETCH_SOGAE_LIST](state, sogaes) {
    state.sogaes = sogaes;
  },
  [FETCH_SOGAE](state, sogae) {
    state.sogae = sogae;
  },

  [CRAWL_START](state, payload) {
    state.lists = payload;
  },
};

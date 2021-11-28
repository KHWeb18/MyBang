import Vue from "vue";
import VueRouter from "vue-router";
import Home from "../views/Home.vue";
import MainPage from "../views/MainPage.vue";
import Mypage from "@/views/member/Mypage";
import MemberRegisterPage from "@/views/member/MemberRegisterPage";
import MemberLoginPage from "@/views/member/MemberLoginPage";
import FindUserId from "@/components/member/FindUserId";
import FindUserPw from "@/components/member/FindUserPw";
import ModifyPassword from "@/components/member/ModifyPassword";
import BrokerRegister from "@/views/BrokerRegister";
import HostPage from "@/views/HostPage";
import RoomMateList from "../views/roommate/List";
import RoomMateModify from "../views/roommate/Modify";
import RoomMateDetail from "../views/roommate/Detail";
import ProductRegisterPage from "@/views/product/ProductRegisterPage";
import ProductListPage from "@/views/product/ProductListPage";
import ProductReadPage from "@/views/product/ProductReadPage";
import ProductModifyPage from "@/views/product/ProductModifyPage";

import VillaRegisterPage from "@/views/villa/VillaRegisterPage";
import VillaReadPage from "@/views/villa/VillaReadPage";
import VillaModifyPage from "@/views/villa/VillaModifyPage";

import OfficetelRegisterPage from "@/views/officetel/OfficetelRegisterPage";
import OfficetelReadPage from "@/views/officetel/OfficetelReadPage";

import OneroomRegisterPage from "@/views/oneroom/OneroomRegisterPage";
import OneroomListPage from "@/views/oneroom/OneroomListPage";
import OneroomReadPage from "@/views/oneroom/OneroomReadPage";

// Map
import Villa from "@/views/map/Villa";
import Oneroom from "@/views/map/Oneroom";
import Officetel from "@/views/map/Officetel";

import GongziListPage from "@/views/gongzi/GongziListPage";
import GongziRegisterPage from "@/views/gongzi/GongziRegisterPage.vue";
import GongziReadPage from "@/views/gongzi/GongziReadPage.vue";
import GongziModifyPage from "@/views/gongzi/GongziModifyPage";

import SogaeListPage from "@/views/sogae/SogaeListPage";
import SogaeRegisterPage from "@/views/sogae/SogaeRegisterPage.vue";
import SogaeReadPage from "@/views/sogae/SogaeReadPage.vue";
import SogaeModifyPage from "@/views/sogae/SogaeModifyPage";

// 부동산 뉴스
import News from "@/views/News";

import BrokerHouseListPage from "@/views/broker/BrokerHouseListPage";

import KakaoLoginPage from "@/views/KakaoLoginPage";

Vue.use(VueRouter);

const routes = [
  {
    path: "/",
    name: "Home",
    component: Home,
  },
  {
    path: "/main",
    name: "MainPage",
    component: MainPage,
  },
  {
    path: "/mypage",
    name: "Mypage",
    component: Mypage,
  },
  {
    path: "/member/create",
    name: "MemberRegisterPage",
    components: {
      default: MemberRegisterPage,
    },
    props: {
      default: true,
    },
  },
  {
    path: "/login",
    name: "MemberLoginPage",
    components: {
      default: MemberLoginPage,
    },
  },
  {
    path: "/findUserId",
    name: "FindUserId",
    component: FindUserId,
  },
  {
    path: "/findUserPw",
    name: "FindUserPw",
    component: FindUserPw,
  },
  {
    path: "/modifyPassword",
    name: "ModifyPassword",
    component: ModifyPassword,
  },
  {
    path: "/registerInfo",
    name: "BrokerRegister",
    component: BrokerRegister,
  },
  {
    path: "/hostPage",
    name: "HostPage",
    component: HostPage,
  },
  {
    path: "/roommate",
    name: "RoomMateList",
    component: RoomMateList,
  },
  {
    path: "/roommate/create",
    name: "RoomMateCreate",
    component: RoomMateModify,
  },
  {
    path: "/roommate/modify/:id",
    name: "RoomMateModify",
    component: RoomMateModify,
  },
  {
    path: "/roommate/detail/:id",
    name: "RoomMateDetail",
    component: RoomMateDetail,
  },
  {
    path: "/product/register",
    name: "ProductRegisterPage",
    components: {
      default: ProductRegisterPage,
    },
  },
  {
    path: "/product/list",
    name: "ProductListPage",
    component: ProductListPage,
  },
  {
    path: "/product/:productNo",
    name: "ProductReadPage",
    components: {
      default: ProductReadPage,
    },
    props: {
      default: true,
    },
  },
  {
    path: "/product/:productNo/edit",
    name: "ProductModifyPage",
    components: {
      default: ProductModifyPage,
    },
    props: {
      default: true,
    },
  },

  {
    path: "/villa",
    name: "Villa",
    component: Villa,
  },
  {
    path: "/oneroom",
    name: "Oneroom",
    component: Oneroom,
  },
  {
    path: "/officetel",
    name: "Officetel",
    component: Officetel,
  },

  {
    path: "/gongzi/create",
    name: "GongziRegisterPage",
    components: {
      default: GongziRegisterPage,
    },
  },
  {
    path: "/gongzi/read",
    name: "GongziReadPage",
    components: {
      default: GongziReadPage,
    },
  },
  {
    path: "/gongzi",
    name: "GongziListPage",
    components: {
      default: GongziListPage,
    },
  },
  {
    path: "/gongzi/modify",
    name: "GongziModifyPage",
    components: {
      default: GongziModifyPage,
    },
  },

  {
    path: "/villa/register",
    name: "VillaRegisterPage",
    components: {
      default: VillaRegisterPage,
    },
  },
  {
    path: "/villa/read",
    name: "VillaReadPage",
    components: {
      default: VillaReadPage,
    },
    props: {
      default: true,
    },
  },
  {
    path: "/villa/:villaNo/edit",
    name: "VillaModifyPage",
    components: {
      default: VillaModifyPage,
    },
    props: {
      default: true,
    },
  },
  {
    path: "/broker/list",
    name: "BrokerHouseListPage",
    component: BrokerHouseListPage,
  },
  {
    path: "/officetel/register",
    name: "OfficetelRegisterPage",
    component: OfficetelRegisterPage,
  },
  {
    path: "/officetel/:officetelNo",
    name: "OfficetelReadPage",
    components: {
      default: OfficetelReadPage,
    },
    props: {
      default: true,
    },
  },
  {
    path: "/oneroom/register",
    name: "OneroomRegisterPage",
    components: {
      default: OneroomRegisterPage,
    },
  },
  {
    path: "/oneroom/list",
    name: "OneroomListPage",
    component: OneroomListPage,
  },
  {
    path: "/oneroom/:oneroomNo",
    name: "OneroomReadPage",
    components: {
      default: OneroomReadPage,
    },
    props: {
      default: true,
    },
  },
  {
    path: "/sogae/create",
    name: "SogaeRegisterPage",
    components: {
      default: SogaeRegisterPage,
    },
  },
  {
    path: "/sogae/read",
    name: "SogaeReadPage",
    components: {
      default: SogaeReadPage,
    },
  },
  {
    path: "/sogae",
    name: "SogaeListPage",
    components: {
      default: SogaeListPage,
    },
  },
  {
    path: "/sogae/modify",
    name: "SogaeModifyPage",
    components: {
      default: SogaeModifyPage,
    },
  },

  // 부동산 뉴스
  {
    path: "/news",
    name: "News",
    component: News,
  },
  {
    path: "KakaoLogin",
    name: "KakaoLoginPage",
    components: {
      default: KakaoLoginPage,
    },
  },
];

const router = new VueRouter({
  mode: "history",
  base: process.env.BASE_URL,
  routes,
});

export default router;

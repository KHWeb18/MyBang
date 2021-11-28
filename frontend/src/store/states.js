export default {
  // Login
  isAuth: false,
  isLogin: false,
  userInfo: [],
  session: [],
  members: [],
  member: null,

  idRules: [
    (id) => !!id || "아이디를 입력해주세요!",
    (id) =>
      /^[a-zA-Z0-9]*$/.test(id) || "아이디는 영문 + 숫자만 입력 가능합니다.",
    (id) =>
      !(id && id.length >= 15) || "아이디는 15자 이상 입력할 수 없습니다.",
  ],
  pwRules: [(pw) => !!pw || "비밀번호를 입력해주세요!"],
  nameRules: [(name) => !!name || "이름을 입력해주세요!"],
  ageRules: [(birth) => !!birth || "생일을 입력해주세요!"],
  sexRules: [(gender) => !!gender || "성별을 입력해주세요!"],
  emailRules: [
    (email) => !!email || "이메일을 입력해주세요!",
    (email) => /.+@.+/.test(email) || "이메일 형식으로 입력해주세요.",
  ],
  phoneRules: [(phone) => !!phone || "전화번호를 입력해주세요!"],

  // 매물게시판
  products: [],
  product: null,
  villas: [],
  villa: null,

  officetelList: [],
  officetel: null,

  oneroomList: [],
  oneroom: null,

  // 찜하기
  likedProductList: [],

  gongzis: [],
  gongzi: null,
  lists: [],

  sogaes: [],
  sogae: null,
  sogaeList: [],

  // 회원 매물등록 구분
  agentVilla: [],
  agentOneroom: [],
  agentOfficetel: [],
};

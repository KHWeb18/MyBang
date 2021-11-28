<template>
  <v-container>
    <h2 align="center">소개할게요</h2>
    <sogae-list :sogaes="sogaes" />
    <v-btn @click="sogaeRegister">소개할게요글 작성</v-btn>
  </v-container>
</template>

<script>
import SogaeList from "@/components/sogae/SogaeList.vue";
import { mapState, mapActions } from "vuex";

export default {
  name: "SogaeListPage",
  components: {
    SogaeList,
  },
  data() {
    return {};
  },
  computed: {
    ...mapState(["sogaes"]),
  },
  mounted() {
    this.fetchSogaeList();
  },
  methods: {
    ...mapActions(["fetchSogaeList"]),
    sogaeRegister() {
      this.$router.push({ name: "SogaeRegisterPage" });
    },
  },
};
</script>

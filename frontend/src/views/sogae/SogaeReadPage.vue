<template>
  <v-container>
    <h2 align="center">소개할게요</h2>
    <sogae-read />
  </v-container>
</template>

<script>
import SogaeRead from "@/components/sogae/SogaeRead.vue";
import { mapActions } from "vuex";

export default {
  name: "SogaeReadPage",
  components: {
    SogaeRead,
  },
  data() {
    return {
      sogaeNo: null,
    };
  },
  mounted() {
    this.sogaeNo = this.$route.query.sogaeNo;
    this.fetchSogae(this.sogaeNo);
  },
  methods: {
    ...mapActions(["fetchSogae"]),
  },
};
</script>

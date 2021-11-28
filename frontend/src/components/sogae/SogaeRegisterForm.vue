<template>
  <v-sheet>
    <v-card class="pa-5 my-5" color="grey lighten-4">
      <v-text-field v-model="title" label="제목" solo></v-text-field>
      <v-textarea
        v-model="description"
        label="내용"
        height="400"
        solo
      ></v-textarea>
      <v-card-actions>
        <v-btn @click="goBack" class="white">취소</v-btn>
        <v-spacer></v-spacer>
        <v-btn @click="register" class="white">등록</v-btn>
      </v-card-actions>
    </v-card>
  </v-sheet>
</template>

<script>
import { mapState } from "vuex";

export default {
  name: "SogaeRegisterForm",
  data() {
    return {
      sogaeNo: null,
      title: null,
      writer: null,
      description: null,
    };
  },
  computed: {
    ...mapState(["userInfo"]),
  },
  mounted() {
    this.writer = this.userInfo.userId;
  },
  methods: {
    register() {
      const { sogaeNo, title, writer, description } = this;
      this.$emit("submit", { sogaeNo, title, writer, description });
    },
    goBack() {
      this.$router.go(-1);
    },
  },
};
</script>

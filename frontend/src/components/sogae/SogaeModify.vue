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
        <v-btn @click="modifySogae" class="white">수정</v-btn>
      </v-card-actions>
    </v-card>
  </v-sheet>
</template>

<script>
import axios from "axios";
import { mapState } from "vuex";

export default {
  data() {
    return {
      title: null,
      description: null,
    };
  },
  computed: {
    ...mapState(["sogae"]),
  },
  mounted() {
    this.title = this.sogae.title;
    this.description = this.sogae.description;
  },
  methods: {
    modifySogae() {
      const { title, description } = this;

      axios
        .patch(`http://localhost:7777/sogae/${this.sogae.sogaeNo}`, {
          title,
          description,
        })
        .then(() => {
          alert("소개할게요글 수정이 완료되었습니다.");

          this.$router.push({
            name: "SogaeReadPage",
            query: { sogaeNo: this.sogae.sogaeNo },
          });
        });
    },
    goBack() {
      this.$router.go(-1);
    },
  },
};
</script>

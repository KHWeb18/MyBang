<template>
  <v-container>
    <h2 align="center">공지사항 작성</h2>
    <gongzi-register-form @submit="onSubmit" />
  </v-container>
</template>

<script>
import GongziRegisterForm from "@/components/gongzi/GongziRegisterForm";
import axios from "axios";

export default {
  name: "GongziRegisterPage",
  components: {
    GongziRegisterForm,
  },
  methods: {
    onSubmit(payload) {
      const { title, writer, description } = payload;

      axios
        .post("http://localhost:7777/gongzi/register", {
          title,
          writer,
          description,
        })
        .then(() => {
          alert("공지사항 등록이 완료되었습니다.");
          this.$router.push({
            name: "GongziListPage",
          });
        })
        .catch((res) => {
          alert(res.response.data.message);
        });
    },
  },
};
</script>

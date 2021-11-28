<template>
  <v-container>
    <h2 align="center">소개할게요 작성</h2>
    <sogae-register-form @submit="onSubmit" />
  </v-container>
</template>

<script>
import SogaeRegisterForm from "@/components/sogae/SogaeRegisterForm";
import axios from "axios";

export default {
  name: "SogaeRegisterPage",
  components: {
    SogaeRegisterForm,
  },
  methods: {
    onSubmit(payload) {
      const { title, writer, description } = payload;

      axios
        .post("http://localhost:7777/sogae/register", {
          title,
          writer,
          description,
        })
        .then(() => {
          alert("소개할게요글 등록이 완료되었습니다.");
          this.$router.push({
            name: "SogaeListPage",
          });
        })
        .catch((res) => {
          alert(res.response.data.message);
        });
    },
  },
};
</script>

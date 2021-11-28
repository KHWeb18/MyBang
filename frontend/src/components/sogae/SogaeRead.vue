<template>
  <v-sheet>
    <v-card class="pa-3 my-5" color="grey lighten-4">
      <v-row>
        <v-col cols="12" md="11">
          <v-text-field v-model="title" solo readonly></v-text-field>
        </v-col>
        <v-col cols="12" md="1">
          <v-menu offset-y>
            <template v-slot:activator="{ on, attrs }">
              <v-btn class="mt-1" v-on="on" v-bind="attrs" icon>
                <v-icon>mdi-dots-vertical</v-icon>
              </v-btn>
            </template>
            <v-list>
              <v-list-item @click="modifySogae">
                수정
              </v-list-item>
              <v-list-item @click="dialog = true">
                삭제
              </v-list-item>
            </v-list>
          </v-menu>
        </v-col>
      </v-row>

      <v-textarea v-model="description" height="400" solo readonly></v-textarea>

      <v-card-actions>
        <div>
          <v-card-text class="caption my-n3"
            >작성자 {{ sogae.writer }}</v-card-text
          >
          <v-card-text class="caption mt-n6"
            >작성일자 {{ sogae.createdDate }}</v-card-text
          >
        </div>

        <v-spacer></v-spacer>
        <v-btn @click="sogaeList" class="white">목록</v-btn>
      </v-card-actions>
    </v-card>

    <v-dialog v-model="dialog" width="400">
      <v-card>
        <v-card-title>정말 삭제하시겠습니까?</v-card-title>
        <v-card-actions>
          <v-btn @click="dialog = false">취소</v-btn>
          <v-spacer></v-spacer>
          <v-btn @click="deleteSogae">확인</v-btn>
        </v-card-actions>
      </v-card>
    </v-dialog>
  </v-sheet>
</template>

<script>
import { mapState } from "vuex";
import axios from "axios";

export default {
  name: "SogaeRead",
  data() {
    return {
      dialog: false,
      title: null,
      description: null,
    };
  },
  computed: {
    ...mapState(["sogae"]),
  },
  mounted() {
    setTimeout(() => {
      this.title = this.sogae.title;
      this.description = this.sogae.description;
    }, 50);
  },
  methods: {
    modifySogae() {
      this.$router.push({ name: "SogaeModifyPage" });
    },
    deleteSogae() {
      axios
        .delete(`http://localhost:7777/sogae/${this.sogae.sogaeNo}`)
        .then(() => {
          alert("소개할게요글 삭제가 완료되었습니다.");
          this.$router.push({ name: "SogaeListPage" });
        })
        .catch((err) => {
          alert(err.response.data.message);
        });
    },
    sogaeList() {
      this.$router.push({ name: "SogaeListPage" });
    },
  },
};
</script>

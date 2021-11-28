<template>
  <v-sheet>
    <v-data-table
      :headers="headerTitle"
      :items="sogaes"
      :items-per-page="10"
      class="elevation-1"
      @click:row="readSogae"
    >
    </v-data-table>
  </v-sheet>
</template>

<script>
export default {
  name: "SogaeList",
  data() {
    return {
      headerTitle: [
        { text: "번호", value: "sogaeNo", width: "30px" },
        { text: "제목", value: "title", width: "300px" },
        { text: "작성자", value: "writer", width: "70px" },
        { text: "작성일자", value: "createdDate", width: "70px" },
      ],
    };
  },
  props: {
    sogaes: {},
  },
  methods: {
    readSogae(sogae) {
      console.log(sogae);
      this.$router.push({
        name: "SogaeReadPage",
        query: { sogaeNo: sogae.sogaeNo },
      });
    },
  },
};
</script>

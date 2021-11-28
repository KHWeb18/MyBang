<template>
  <div>
    <ul>
      <li
        v-for="list in recentSogaes"
        :key="list.index"
        class="ml-n5"
        @click="sogaeRead(list.sogaeNo)"
      >
        {{ list.title }}
      </li>
    </ul>
  </div>
</template>

<script>
import { mapActions, mapState } from "vuex";

export default {
  data() {
    return {
      recentSogaes: [],
    };
  },
  computed: {
    ...mapState(["sogaes"]),
  },
  mounted() {
    if (this.sogaes.length > 5) {
      this.recentSogaes = this.sogaes.slice(0, 5);
    } else {
      this.recentSogaes = this.sogaes;
    }
    console.log(this.recentSogaes);
  },
  methods: {
    ...mapActions(["fetchSogaeList"]),
    sogaeRead(sogaeNo) {
      this.$router.push({ name: "SogaeReadPage", query: { sogaeNo: sogaeNo } });
    },
  },
};
</script>

<style scoped>
ul {
  list-style: none;
  cursor: pointer;
}
li {
  padding: 10px;
}
li:hover {
  background: rgba(220, 220, 220, 0.671);
  transition: all 0.3s ease;
}
</style>

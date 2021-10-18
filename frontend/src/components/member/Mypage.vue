<template>
  <v-container>
    <v-card>
      <v-card-title>
        회원정보를 변경하려면 비밀번호를 입력해주세요.
      </v-card-title>
      <v-text-field label="Id" v-model="id" :rules="idRules"></v-text-field>
    </v-card>
  </v-container>
</template>
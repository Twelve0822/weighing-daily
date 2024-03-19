<script setup lang='ts'>
import { ref } from 'vue'

const activeIndex = ref('1')
const handleSelect = (key: string, keyPath: string[]) => {
  // console.log(key, keyPath)
}
</script>

<template>
  <div class="header-nav">
    
    <el-menu
    :default-active="activeIndex"
    class="el-menu-demo"
    mode="horizontal"
    :ellipsis="false"
    @select="handleSelect"
  >
    <el-menu-item index="0">
      <router-link to="/">LOGO</router-link>
    </el-menu-item>
    <div class="flex-grow" />
    <el-menu-item index="1"><router-link to="/">個人情報</router-link></el-menu-item>
    <el-menu-item index="2"><router-link to="/mes">每日のデータ</router-link></el-menu-item>
    <el-menu-item index="3"><router-link to="/weight">体重履歴</router-link></el-menu-item>
  </el-menu>
  </div>
</template>

<style scoped>

.header-nav{
  width: 100%;
}
.flex-grow {
  flex-grow: 1;
}
a{
  text-decoration: none;
}
</style>
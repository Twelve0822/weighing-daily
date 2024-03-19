<script setup lang='ts'>
import { ElMessage, ElMessageBox } from "element-plus";
import { ref,reactive } from "vue";
const count = ref(0);
const load = () => {
  count.value += 2;
};
const mes = reactive(window.localStorage.getItem("message")?JSON.parse(window.localStorage.getItem("message")):[])
const open = () => {
  ElMessageBox.prompt("データを入力してください", "Tip", {
    confirmButtonText: "入力",
    cancelButtonText: "キャンセル",
    inputPattern: /^.+$/,
    inputErrorMessage: "空欄にしないでください",
  }).then(({ value }) => {
    if (value != "" && value != null) {
      mes.push(value)
      ElMessage({
        type: "success",
        message: "入力成功",
      });
      window.localStorage.setItem("message",JSON.stringify(mes))
    } else {
      ElMessage({
        type: "warning",
        message: "空欄にしないでください",
      });
    }
  });
};
</script>

<template>
  <div class="message">
    <el-button type="primary" round @click="open" style="margin-bottom:15px;">データ入力</el-button>
    <ul v-if="mes.length>0" v-infinite-scroll="load" class="infinite-list" style="overflow: auto">
      <li v-for="i in mes" :key="i" class="infinite-list-item">{{ i }}</li>
    </ul>
    <p v-else style="text-align:center; color: #666;">データが存在しない</p>
  </div>
</template>

<style scoped>
.message {
  margin-top: 100px;
}
.infinite-list {
  height: 450px;
  padding: 0;
  margin: 0;
  list-style: none;
}
.infinite-list .infinite-list-item {
  display: flex;
  align-items: center;
  justify-content: center;
  height: 50px;
  background: var(--el-color-primary-light-9);
  margin: 10px;
  color: var(--el-color-primary);
}
.infinite-list .infinite-list-item + .list-item {
  margin-top: 10px;
}
</style>
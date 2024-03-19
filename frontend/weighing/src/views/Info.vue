<script setup lang='ts'>
import { reactive, ref } from "vue";
import { ElMessage, FormProps } from "element-plus";
import { inject } from "vue";

const labelPosition = ref<FormProps["labelPosition"]>("right");
const infoForm = inject("user").user;
const lformRef = ref();

const update = () => {
  lformRef.value.validate((valid) => {
    if (valid) {
      window.localStorage.setItem("user", JSON.stringify(infoForm));
      ElMessage({
        message: "更新成功",
        type: "success",
      });
    } else {
      console.log("error submit!");
      return false;
    }
  });
};
</script>

<template>
  <div class="info">
    <el-form
      :label-position="labelPosition"
      label-width="auto"
      :model="infoForm"
      style="max-width: 600px"
      ref="lformRef"
    >
      <el-form-item required="true" label="ユーザー名" prop="username">
        <el-input v-model="infoForm.username" />
      </el-form-item>
      <el-form-item required="true" label="パスワード" prop="password">
        <el-input type="password" v-model="infoForm.password" />
      </el-form-item>
      <el-button type="primary" round @click="update">更新</el-button>
    </el-form>
  </div>
</template>

<style scoped>
.info {
  width: 50%;
  margin: 100px auto 0;
}
</style>
<script setup lang='ts'>
import { reactive, ref } from "vue";
import { ElMessage, FormProps, TabsPaneContext } from "element-plus";
import { inject } from "vue";
import { useRouter } from "vue-router";

const router = useRouter();

const labelPosition = ref<FormProps["labelPosition"]>("right");

const loginForm = reactive({
  username: "",
  password: "",
});

const regForm = reactive({
  username: "",
  password: "",
  twopassword: "",
});

const activeName = ref("first");

const handleClick = (tab: TabsPaneContext, event: Event) => {
  console.log(tab, event);
};
const s_user = inject("user");
const lformRef = ref();
console.log(lformRef);
const rformRef = ref();

const login = () => {
  lformRef.value.validate((valid) => {
    console.log(valid);
    if (valid) {
      if (window.localStorage.getItem("user")) {
        let user = JSON.parse(window.localStorage.getItem("user"));
        if (
          user.username == loginForm.username &&
          user.password == loginForm.password
        ) {
          ElMessage({
            message: "ログイン成功",
            type: "success",
          });
          s_user.user = loginForm;
          router.push("/");
        } else {
          ElMessage.error("パスワードエラー");
        }
      } else {
        ElMessage({
          message: "登録してください",
          type: "warning",
        });
      }
    }
  });
};

const reg = () => {
  rformRef.value.validate((valid) => {
    if (valid) {
      window.localStorage.setItem("user", JSON.stringify(regForm));
      ElMessage({
        message: "登録成功",
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
  <div class="login">
    <el-tabs
      type="border-card"
      v-model="activeName"
      class="demo-tabs"
      @tab-click="handleClick"
    >
      <el-tab-pane label="ログイン" name="first">
        <el-form
          :label-position="labelPosition"
          label-width="auto"
          :model="loginForm"
          style="max-width: 600px"
          ref="lformRef"
        >
          <el-form-item required="true" label="ユーザー名" prop="username">
            <el-input v-model="loginForm.username" />
          </el-form-item>
          <el-form-item required="true" label="パスワード" prop="password">
            <el-input type="password" v-model="loginForm.password" />
          </el-form-item>
          <el-button type="primary" round @click="login">ログイン</el-button>
        </el-form>
      </el-tab-pane>
      <el-tab-pane label="登録" name="second">
        <el-form
          :label-position="labelPosition"
          label-width="auto"
          :model="regForm"
          style="max-width: 600px"
          ref="rformRef"
        >
          <el-form-item label="ユーザー名" required="true" prop="username">
            <el-input v-model="regForm.username" />
          </el-form-item>
          <el-form-item label="パスワード" required="true" prop="password">
            <el-input type="password" v-model="regForm.password" />
          </el-form-item>
          <el-form-item label="パスワード確認" required="true" prop="twopassword">
            <el-input type="password" v-model="regForm.twopassword" />
          </el-form-item>
          <el-button type="primary" round @click="reg">ログイン</el-button>
        </el-form>
      </el-tab-pane>
    </el-tabs>
  </div>
</template>

<style scoped>
.login {
  width: 50%;
  margin: 100px auto 0;
}
</style>
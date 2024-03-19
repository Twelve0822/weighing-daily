<script setup lang='ts'>
import { reactive, ref } from "vue";
import { ElMessage, ElTable } from "element-plus";

interface User {
  date: string;
  name: string;
  address: string;
}

const currentRow = ref();
const singleTableRef = ref<InstanceType<typeof ElTable>>();

const handleCurrentChange = (val: User | undefined) => {
  console.log(val);
  currentRow.value = val;
};
const tableData = reactive(
  window.localStorage.getItem("weight")
    ? JSON.parse(window.localStorage.getItem("weight"))
    : []
);
const btnmes = ref("入力");
const dialogFormVisible = ref(false);
const form = reactive({
  id: "",
  weight: "",
  stature: "",
  date: "",
  comment: "",
});
const formRef = ref();
function getUuid() {
  return "xxxxxxxx-xxxx-4xxx-yxxx-xxxxxxxxxxxx".replace(/[xy]/g, function (c) {
    var r = (Math.random() * 16) | 0,
      v = c == "x" ? r : (r & 0x3) | 0x8;
    return v.toString(16);
  });
}
const au = (type) => {
  formRef.value.validate((valid) => {
    let mes;
    if (valid) {
      let date = new Date(form.date);
      form.date =
        date.getFullYear() +
        "-" +
        (date.getMonth() + 1) +
        "-" +
        date.getDate() +
        " " +
        date.getHours() +
        ":" +
        date.getMinutes() +
        ":" +
        date.getSeconds();
      if (type == "add") {
        form.id = getUuid().slice(0, 9);
        tableData.push(reactive({ ...form }));
        mes = btnmes.value;
        dialogFormVisible.value = false;
      }
      if (type == "update") {
        let i;
        tableData.filter(function (item, index) {
          if (item.id == currentRow.value.id) {
            i = index;
          }
        });
        tableData[i] = reactive({ ...form });
        mes = btnmes.value;
        dialogFormVisible.value = false;
      }
      ElMessage({
        message: mes + "成功",
        type: "success",
      });
      window.localStorage.setItem("weight", JSON.stringify(tableData));
    } else {
      console.log("error submit!");
      return false;
    }
  });
};

const update = () => {
  if (!currentRow.value) {
    ElMessage({
      message: "更新するデータをお選びください",
      type: "warning",
    });
    return;
  }
  form.id = currentRow.value.id;
  form.weight = currentRow.value.weight;
  form.stature = currentRow.value.stature;
  form.date = currentRow.value.date;
  form.comment = currentRow.value.comment;
  btnmes.value = "更新";
  dialogFormVisible.value = true;
};

const add = () => {
  btnmes.value = "入力";
  dialogFormVisible.value = true;
};

const del = () => {
  if (!currentRow.value) {
    ElMessage({
      message: "削除するデータをお選びください",
      type: "warning",
    });
    return;
  }
  let i;
  tableData.filter(function (item, index) {
    if (item.id == currentRow.value.id) {
      i = index;
    }
  });
  tableData.splice(i, 1);
  window.localStorage.setItem("weight", JSON.stringify(tableData));
};
</script>

<template>
  <div class="weight">
    <el-table
      v-if="tableData.length > 0"
      ref="singleTableRef"
      :data="tableData"
      highlight-current-row
      style="width: 100%"
      @current-change="handleCurrentChange"
    >
      <!-- <el-table-column type="index" width="50" /> -->
      <el-table-column property="id" label="ID" width="120" />
      <el-table-column property="weight" label="体重" width="120" />
      <el-table-column property="stature" label="身長" width="120" />
      <el-table-column property="date" label="日付" />
      <el-table-column property="comment" label="コメント" width="120" />
    </el-table>
    <p v-else style="text-align: center; color: #666">データが存在しない</p>
    <div style="margin-top: 20px">
      <el-button @click="add">入力</el-button>
      <el-button @click="update">更新</el-button>
      <el-button @click="del">削除</el-button>
    </div>

    <el-dialog v-model="dialogFormVisible" title="操作" width="500">
      <el-form ref="formRef" :model="form">
        <el-form-item
          required="true"
          label="体重"
          label-width="140px"
          prop="weight"
        >
          <el-input v-model="form.weight" autocomplete="off" />
        </el-form-item>
        <el-form-item
          required="true"
          label="身長"
          label-width="140px"
          prop="stature"
        >
          <el-input v-model="form.stature" autocomplete="off" />
        </el-form-item>
        <el-form-item
          required="true"
          label="日付"
          label-width="140px"
          prop="date"
        >
          <el-date-picker
            v-model="form.date"
            type="datetime"
            placeholder="Select date and time"
          />
        </el-form-item>
        <el-form-item
          required="true"
          label="コメント"
          label-width="140px"
          prop="comment"
        >
          <el-input v-model="form.comment" autocomplete="off" />
        </el-form-item>
      </el-form>
      <template #footer>
        <div class="dialog-footer">
          <el-button @click="dialogFormVisible = false">キャンセル</el-button>
          <el-button
            type="primary"
            @click="au(btnmes == '入力' ? 'add' : 'update')"
          >
            {{ btnmes }}
          </el-button>
        </div>
      </template>
    </el-dialog>
  </div>
</template>

<style scoped>
.weight {
  width: 70%;
  margin: 100px auto 0;
}
</style>
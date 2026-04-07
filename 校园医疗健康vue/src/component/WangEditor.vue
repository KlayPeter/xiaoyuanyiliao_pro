<template>
  <div style="border: 1px solid #ccc">
    <!-- Toolbar 组件 -->
    <Toolbar
      style="border-bottom: 1px solid #ccc"
      :editor="editorRef"
      :defaultConfig="defaultToolbarConfig"
      :mode="mode"
    />
    <!-- Editor 组件 -->
    <Editor
      style="height: 500px; overflow-y: hidden;"
      v-model="valueHtml"
      :defaultConfig="editorConfig"
      :mode="mode"
      @onCreated="handleCreated"
    />
  </div>
</template>

<script>
// npm install @wangeditor/editor-for-vue@next --save
import '@wangeditor/editor/dist/css/style.css'; // 引入 CSS
import { shallowRef } from 'vue';
import { Editor, Toolbar } from '@wangeditor/editor-for-vue';

export default {
  name: 'WangEditor',
  components: { Editor, Toolbar },
  props: {
    modelValue: {
      type: String,
      default: '<p>hello</p>', // 默认值
    },
    mode: {
      type: String,
      default: 'default', // 默认模式，可以是 'default' 或 'simple'
    },
    // toolbarConfig: {
    //   type: Object,
    //   default: () => ({}),
    // },
    editorConfig: {
      type: Object,
      default: () => ({ placeholder: '请输入内容...' }),
    },
  },
  data() {
    return {
      editorRef: shallowRef(),
      valueHtml: this.modelValue, // 初始化值为传递进来的 modelValue
      // 去除图片、视频和表情工具栏
      defaultToolbarConfig: {
        toolbarKeys: [
          "bold",
          "underline",
          "italic",
          "through",
          "code",
          "sub",
          "sup",
          "clearStyle",
          "color",
          "bgColor",
          "fontSize",
          "fontFamily",
          "indent",
          "delIndent",
          "justifyLeft",
          "justifyRight",
          "justifyCenter",
          "justifyJustify",
          "lineHeight",
          // "insertImage",
          // "deleteImage",
          // "editImage",
          // "viewImageLink",
          // "imageWidth30",
          // "imageWidth50",
          // "imageWidth100",
          "divider",
          // "emotion",
          "insertLink",
          "editLink",
          "unLink",
          "viewLink",
          "codeBlock",
          "blockquote",
          "headerSelect",
          // "header1",
          // "header2",
          // "header3",
          // "header4",
          // "header5",
          "todo",
          "redo",
          "undo",
          // "fullScreen",
          "enter",
          "bulletedList",
          "numberedList",
          // "insertTable",
          // "deleteTable",
          // "insertTableRow",
          // "deleteTableRow",
          // "insertTableCol",
          // "deleteTableCol",
          // "tableHeader",
          // "tableFullWidth",
          // "insertVideo",
          // "uploadVideo",
          // "editVideoSize",
          // "uploadImage",
          // "codeSelectLang"
        ]
      },
    };
  },
  watch: {
    modelValue(newVal) {
      if (newVal !== this.valueHtml) {
        this.valueHtml = newVal; // 如果父组件传递了新的值，更新子组件的值
      }
    },
    valueHtml(newVal) {
      this.$emit('update:modelValue', newVal); // 当编辑器内容变化时，更新父组件的值
    },
  },
  mounted() {
    // 可以在这里进行一些额外的操作
  },
  beforeUnmount() {
    const editor = this.editorRef;
    if (editor) {
      editor.destroy(); // 销毁编辑器实例
    }
  },
  methods: {
    handleCreated(editor) {
      this.editorRef = editor; // 记录 editor 实例
      console.log(this.editorRef.getAllMenuKeys()); // 输出所有工具栏按钮的键
    },
  },
};
</script>

<style scoped>
/* 可以根据需求进一步定制样式 */
</style>

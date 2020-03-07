var {add}=require("./module")
var Vue=require("./vue.min");
var vue=new Vue({
    el:'#app',
    data:{
        name:"黑马程序员",
        num1:0,
        num2:0,
        result:0,
        size:33,
        url:"http://www.baidu.com"
    },
    methods:{
        change(){
            this.result=add(Number.parseInt(this.num1),Number.parseInt(this.num2));
        }
    }
})
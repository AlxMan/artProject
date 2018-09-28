
//获取本地存储的数据,每次请求都带上
var jwt = localStorage["jwt"];
var name = localStorage["name"];
console.log("输出:"+jwt);
var frm = $('#form');
frm.submit(function (ev) {
  $.ajax({
    headers: {
      Authorization : jwt,
      'name' : name
    },
    type: "post",
    url: "http://127.0.0.1:9987/register",
    data: frm.serialize(),
    success:function(data) {
      console.log(data)
    },
    error:function(data){
      console.log(data)
    }
  });
  ev.preventDefault();
});
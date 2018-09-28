$(document).ready(function () {
  $.ajax({
    type: "GET",
    url: "http://127.0.0.1:9987/book/list/",
    dataType: 'json',
    global: "false",
    success: function (data) {
      for (var i = 0; i < data.length; i++) {
        $('table tbody').append(
            '<tr>' +
            '<td>' + data[i].bookId + '</td>' +
            '<td>' + data[i].name + '</td>' +
            '<td>' + data[i].number + '</td>' +
            '<td><a href="../../book/detail/' + data[i].bookId + '"'
            + '>详情</a> | <a href="../../book/del/' + data[i].bookId + '"'
            + '>删除</a></td>'
            +
            '</tr>'
        );
      }
    }
  })
});
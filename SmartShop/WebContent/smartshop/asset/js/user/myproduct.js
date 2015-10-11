
//var requestOrderMsg = 
//{
//    url:URL,
//    callbackMethod:setOrderData,
//    data:""
//}
var orderMsg = {
    time: "",
    name: "",
    type: "",
    price: "",
    num: "",
    state:"",
    operation: ""
};
$(document).ready(function () {
    //getOrderData();
    setOrderData();

});
function deleteaddress()
{
    alert("hhhhhhhhhhh");
   
}
function getOrderData() {
    var postData = {
        userid: ""
    }
    requestOrderMsg.data = postData;
    getData(requestOrderMsg);
}
function setOrderData() {
    var dataArray = new Array(); //数据对象数组

    orderMsg = new Object();

    orderMsg.time = "20150412";
    orderMsg.name = "高等数学";
    orderMsg.type = "第二版";
    orderMsg.price = "12.8"
    orderMsg.num = "2";
    orderMsg.state="未发货"
    orderMsg.operation =
    "<a href='javascript:void(0)' onclick=' this.parentNode.parentNode.parentNode.removeChild(this.parentNode.parentNode);deleteaddress();'><font color=‘crismon’>删除订单</font></a><br>评论<br>追加评论";
    dataArray.push(orderMsg);

    for (var i = 0; i < 2; i++) {
        orderMsg = new Object();

        orderMsg.time = "20150412";
        orderMsg.name = "高等数学";
        orderMsg.type = "第二版"+i;
        orderMsg.price = "12.8"
        orderMsg.num = "2";
        orderMsg.state = "未发货"
        orderMsg.operation =
        "<a href='javascript:void(0)' onclick=' this.parentNode.parentNode.parentNode.removeChild(this.parentNode.parentNode);deleteaddress();'><font color=‘crismon’>删除订单</font></a><br>评论<br>追加评论";
        dataArray.push(orderMsg);
    }

    $("#table_body tr").not("tr:first").remove(); //清空除第一行之外的表内容

    var sequenceArray = new Array();//序列数组
    sequenceArray[0] = "time";
    sequenceArray[1] = "name";
    sequenceArray[2] = "type";
    sequenceArray[3] = "price";
    sequenceArray[4] = "num";
    sequenceArray[5] = "state";
    sequenceArray[6] = "operation";

    var trLength = dataArray.length;
    var table = document.getElementById("trade");
    for (var i = 0; i < trLength; i++) {
        //if (dataArray[i].flag == 1) {
        //    table.rows[i + 1].cells[4].innerHTML = "<input type='radio'  name='address' value='New'style='width:25px;height:25px;' checked>";
        //}
        //else
        //    table.rows[i + 1].cells[4].innerHTML = "<input type='radio'  name='address' value='New'style='width:25px;height:25px'>";
        for (var j = 0; j < 7; j++)
            table.rows[i + 1].cells[j].innerHTML = dataArray[i][sequenceArray[j]];
        var $tr = $("#trade tr").eq("-1");
        $tr.after("<tr id='last'><td></td><td></td><td></td><td></td><td></td><td></td><td></td></tr>");
    }
    $('#trade tr:last').remove();
}

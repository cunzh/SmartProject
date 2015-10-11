

//var requestAddressMsg = {
//    url: URL_COMMENT_ROOMOWNER,
//    callbackMethod: setAddressData,
//    data: ""
//};

//收货地址
var addressMsg = {
    flag: 0,
    name: "",
    address: "",
    telephone: "",
};

//var requestCartMsg = {
//    url: URL_COMMENT_ROOMOWNER,
//    callbackMethod: setCartData,
//    data: ""
//};

//购物车信息
var cartMsg = {
    flag: 0,
    name: "",
    address: "",
    telephone: "",
};

$(document).ready(function () {

    //getAddressData();//获取用户地址列表
    setAddressData();//删
    $("#newaddress").click(function () {
        window.location.href = '../user/manageAddress.html';
    });

    //getCartData();//获取购物车商品信息
    setCartData();//删
});
function getAddressData() {
    var postData = {
        userid:""
    }
    requestAddressMsg.data = postData;
    getData(requestAddressMsg);
}

//function setOwnerData(data) {   //原函数
    //var dataArray = new Array(); //数据对象数组
    //for (var i = 0; i < data.result.length; i++) {
    //    commentMsg = new Object();

    //    commentMsg.name = data.result[i].name;
    //    commentMsg.rank = data.result[i].rank;
    //    commentMsg.content = data.result[i].content;
    //    commentMsg.time = data.result[i].time;
    //    dataArray.push(commentMsg);
//}
function setAddressData() {
    var dataArray = new Array(); //数据对象数组

    addressMsg = new Object();

    addressMsg.flag = 1;
    addressMsg.name = "老王1";
    addressMsg.address = "湖北省武汉市洪山区珞瑜路1037号华中科技大学沁苑东10学生宿舍";
    addressMsg.telephone = "12345678910"
    dataArray.push(addressMsg);

    for (var i = 0; i < 3; i++) {
        addressMsg = new Object();

        addressMsg.flag = 0;
        addressMsg.name = "老王"+(i+2);
        addressMsg.address = "湖北省武汉市洪山区珞瑜路1037号华中科技大学沁苑东10学生宿舍";
        addressMsg.telephone = "12345678910"
        dataArray.push(addressMsg);
    }

    $("#table_body tr").not("tr:first").remove(); //清空除第一行之外的表内容

    var trLength = dataArray.length;
    var table = document.getElementById("address");
    for (var i = 0; i < trLength; i++) {
        if (dataArray[i].flag == 1) {
            table.rows[i + 1].cells[0].innerHTML = "<input type='radio'  name='address' value='New'style='width:25px;height:25px;' checked>";
        }
        else
            table.rows[i + 1].cells[0].innerHTML = "<input type='radio'  name='address' value='New'style='width:25px;height:25px'>";
      table.rows[i + 1].cells[1].innerHTML = dataArray[i].address + " (" + dataArray[i].name + "收）" + dataArray[i].telephone;
      var $tr = $("#address tr").eq("-1");
      $tr.after("<tr id='last'><td></td><td></td></tr>");
    }
    $('#address tr:last').remove();
    var row = $("<tr></tr>")
    var td1 = "<td width='4%' align='center'><input type='button' id='newaddress' value='使用新地址' /></td>";
    var td2 = "<td align='center'class='inputHeader'>&nbsp</td>"
    row.append(td1);
    row.append(td2);
    $('#address').append(row);
}

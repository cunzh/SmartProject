
//var requestAddressMsg = 
//{
//    url:URL,
//    callbackMethod:setAddressData,
//    data:""
//}
var addressMsg = {
    flag: 0,
    name: "",
    address: "",
    telephone: "",
    operation: ""
};
$(document).ready(function () {
    //getAddressData();
    setAddressData();
  

    $(document).on("click", ".nopay", function () {


       // payid = $(this).parents("tr").find('td:first').text();
        //  var payid = $(this).parents("tr").children("td:eq(0)").text();
        //	alert(payid);
     
        var name = $(this).parents("tr").children("td:eq(0)").text();
        var address = $(this).parents("tr").children("td:eq(1)").text();
        var telephone = $(this).parents("tr").children("td:eq(2)").text();
        $("#popname").attr("value", name);
        document.getElementById("popaddress").value = address;
        $("#poptelephone").attr("value", telephone);
        $('#sign_up').lightbox_me({
            centered: true,
            closeClick: false,
            onLoad: function () {
                $('#sign_up').find('input:last').focus();
            }
        });
    });

    //取消缴费
    $('#cancel').click(function () {
        $('#sign_up').trigger('close');
    });
    $('#button_submmit').click(function () {
        alert("fff");
    });

});
function deleteaddress()
{
    alert("hhhhhhhhhhh");
   
}
function getAddressData() {
    var postData = {
        userid: ""
    }
    requestAddressMsg.data = postData;
    getData(requestAddressMsg);
}
function setAddressData() {
    var dataArray = new Array(); //数据对象数组

    addressMsg = new Object();

    addressMsg.flag = 1;
    addressMsg.name = "老王1";
    addressMsg.address = "湖北省武汉市洪山区珞瑜路1037号华中科技大学沁苑东10学生宿舍";
    addressMsg.telephone = "12345678910"
    addressMsg.operation =
    "<a href='javascript:void(0)'class='nopay'><font color=‘blue’>修改</font></a>||<a href='javascript:void(0)' onclick=' this.parentNode.parentNode.parentNode.removeChild(this.parentNode.parentNode);deleteaddress();'><font color=‘crismon’>删除</font></a>"
    dataArray.push(addressMsg);

    for (var i = 0; i < 2; i++) {
        addressMsg = new Object();
        addressMsg.flag = 0;
        addressMsg.name = "老王" + (i + 2);
        addressMsg.address = "湖北省武汉市洪山区珞瑜路1037号华中科技大学沁苑东10学生宿舍";
        addressMsg.telephone = "12345678910"
        addressMsg.operation =
    "<a href='javascript:void(0)'class='nopay'><font color=‘blue’>修改</font></a>||<a href='javascript:void(0)' onclick=' this.parentNode.parentNode.parentNode.removeChild(this.parentNode.parentNode);deleteaddress();'><font color=‘crismon’>删除</font></a>"
        dataArray.push(addressMsg);
    }

    $("#table_body tr").not("tr:first").remove(); //清空除第一行之外的表内容

    var sequenceArray = new Array();//序列数组
    sequenceArray[0] = "name";
    sequenceArray[1] = "address";
    sequenceArray[2] = "telephone";
    sequenceArray[3] = "operation";

    var trLength = dataArray.length;
    var table = document.getElementById("address");
    for (var i = 0; i < trLength; i++) {
        if (dataArray[i].flag == 1) {
            table.rows[i + 1].cells[4].innerHTML = "<input type='radio'  name='address' value='New'style='width:25px;height:25px;' checked>";
        }
        else
            table.rows[i + 1].cells[4].innerHTML = "<input type='radio'  name='address' value='New'style='width:25px;height:25px'>";
        for (var j = 0; j < 4; j++)
            table.rows[i + 1].cells[j].innerHTML = dataArray[i][sequenceArray[j]];
        var $tr = $("#address tr").eq("-1");
        $tr.after("<tr id='last'><td></td><td></td><td></td><td></td><td></td></tr>");
    }
    $('#address tr:last').remove();
}

function textdown(e) {
    textevent = e;
    if (textevent.keyCode == 8) {
        return;
    }
    if (document.getElementById('textarea').value.length >= 100) {
        alert("大侠，手下留情，此处限字100")
        if (!document.all) {
            textevent.preventDefault();
        } else {
            textevent.returnValue = false;
        }
    }
}
function textup() {
    var s = document.getElementById('textarea').value;
    //判断ID为text的文本区域字数是否超过100个 
    if (s.length > 100) {
        document.getElementById('textarea').value = s.substring(0, 100);
    }
}
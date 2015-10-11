
//var requestAddressMsg = 
//{
//    url:URL,
//    callbackMethod:setAddressData,
//    data:""
//}do
var addressMsg = {
    flag: 0,
    name: "",
    address: "",
    telephone: "",
    operation: "",
    id:""
};

var requestAddMsg = {
    url: URL_ADD_ADDRESS,
    callbackMethod:addAddressData,
    data:""
};
var requestDelMsg = {
    url: URL_DEL_ADDRESS,
    callbackMethod: delAddressData,
    data: ""
};
var requestQueMsg = {
    url: URL_QUE_ADDRESS,
    callbackMethod: setAddressData,
    data:""
};
var flag = 1;
var delId;
$(document).ready(function () {
    getAddressData();
    $("#save").click(function () {
        check();
        if (flag == 0)
           {}
        else
        	{
        	    var state;
		        if(document.getElementById("isDefault").checked){
		            state = true;
		        }
		        else
		        	state = false;  
		        var postData = {
		            "address.name":document.getElementById("name").value,
		            "address.address": document.getElementById("cmbProvince").value + document.getElementById("cmbCity").value +
		            document.getElementById("cmbArea").value + document.getElementById("textarea").value,
		            "address.telephone": document.getElementById("telephone").value,
		            "address.isDefault": state
		        }
		        requestAddMsg.data = postData;
		        getData(requestAddMsg);
        	}
    });
    //修改弹出框
    $(document).on("click", ".nopay", function () {
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
    //删除链接
    $(document).on("click", ".del", function () {
       var delId = $(this).parents("tr").children("td:eq(4)").text();
 	   var postData = {
 			   id:delId
 	    };
 	   requestDelMsg.data=postData;
 	   getData(requestDelMsg);
    });
    
    //取消修改
    $('#cancel').click(function () {
        $('#sign_up').trigger('close');
    });
    $('#button_submmit').click(function () {
        alert("等待后台");
    });
})
function check() {
    if (document.getElementById("name").value == "") {
        alert("收货人姓名不能为空");
        flag = 0;
        return;
    }
    if (document.getElementById("textarea").value == "建议您如实填写收货地址，例如街道名称，门牌号码，楼层和房间号等信息") {
        alert("收货人详细地址不能为空");
        flag = 0;
        return;
    }
    if (document.getElementById("telephone").value == "非常重要，请认真填写") {
        alert("收货人手机号码不能为空");
        flag = 0;
        return;
    }
}
function changedef(){
	var chkObjs = document.getElementsByName("isdef");
	var defId;
    for(var i=0;i<chkObjs.length;i++){
        if(chkObjs[i].checked){
        	defId=chkObjs[i].value;
            break;
        }
    }
    alert(defId+"id号，，后台待开发");
}

function getAddressData() {
    var postData = {
    }
    requestQueMsg.data = postData;
    getData(requestQueMsg);
}

    function setAddressData(data)
    {
      var dataArray=new Array(); //数据对象数组
      for(var i=0;i<data.result.length;i++)
      {
      addressMsg = new Object();
      addressMsg.flag = data.result[i].isdefault;
      addressMsg.name = data.result[i].name;
      addressMsg.address = data.result[i].address
      addressMsg.telephone = data.result[i].telephone
    addressMsg.operation =
    "<a href='javascript:void(0)'class='nopay'><font color=‘blue’>修改</font></a>||" +
    "<a href='javascript:void(0)' class='del'onclick=' this.parentNode.parentNode.parentNode.removeChild" +
    "(this.parentNode.parentNode);deleteaddress();'><font color=‘crismon’>删除</font></a>"
      addressMsg.id = data.result[i].id;
      dataArray.push(addressMsg);
      }

    $("#table_body tr").not("tr:first").remove(); //清空除第一行之外的表内容

    var sequenceArray = new Array();//序列数组
    sequenceArray[0] = "name";
    sequenceArray[1] = "address";
    sequenceArray[2] = "telephone";
    sequenceArray[3] = "operation";
    sequenceArray[4] = "id";
  
    var trLength = dataArray.length;
    var table = document.getElementById("address");
    for (var i = 0; i < trLength; i++) {
        if (dataArray[i].flag == true) {
            table.rows[i + 1].cells[5].innerHTML = "<input type='radio'  name='isdef' value='"+dataArray[i].id+"'style='width:25px;height:25px;' onclick='changedef()' checked>";
        }
        else
            table.rows[i + 1].cells[5].innerHTML = "<input type='radio'   name='isdef' value='"+dataArray[i].id+"'style='width:25px;height:25px'onclick='changedef()'>";
        for (var j = 0; j < 5; j++)
            table.rows[i + 1].cells[j].innerHTML = dataArray[i][sequenceArray[j]];
        var $tr = $("#address tr").eq("-1");
        $tr.after("<tr id='last'><td></td><td></td><td></td><td></td><td style='display:none;'></td><td></td></tr>");
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

function addAddressData(result) {
    if (result.success == true)
        alert("添加新地址成功");
    else
        alert("添加新地址失败！"+result.type);
}

function delAddressData(result) {
    if (result.success == true)
        alert("删除地址成功");
    else
        alert("删除地址失败！"+result.type);
}
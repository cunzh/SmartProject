
var addressMsg = {
	    flag: 0,
	    name: "",
	    address: "",
	    telephone: "",
	    operation: "",
	    id:""
	};

var requestQueMsg = {
	    url: URL_QUE_ADDRESS,
	    callbackMethod: setAddressData,
	    data: ""
	};


$(document).ready(function () {

	getAddressData();
    $("#newaddress").click(function () {
        window.location.href = '../user/manageAddress.html';
    });
  
    setCartData();
    document.getElementById("sum").value = parseFloat(document.getElementById("price").innerText) * parseInt(document.getElementById("num").value);

    if (document.getElementById("num").value == 1) {
        var sub = document.getElementById("sub");
        sub.disabled = true;
    }
    $("#add").click(function () {
        document.getElementById("num").value = parseInt(document.getElementById("num").value) + 1;
        document.getElementById("sum").value = parseFloat(document.getElementById("price").innerText) * parseInt(document.getElementById("num").value);
        if (document.getElementById("num").value != 1) {
            var sub = document.getElementById("sub");
            sub.disabled = false;
        }
    });
    $("#sub").click(function () {
        document.getElementById("num").value = parseInt(document.getElementById("num").value) - 1;
        document.getElementById("sum").value = parseFloat(document.getElementById("price").innerText) * parseInt(document.getElementById("num").value);
        if (document.getElementById("num").value == 1) {
            var sub = document.getElementById("sub");
            sub.disabled = true;
        }
    });
    $("#submit").click(function () {
         alert("提交");//提交
    });

});

function OnInput(event) {
    document.getElementById("sum").value = parseFloat(document.getElementById("price").innerText) * parseInt(document.getElementById("num").value);
}

function getAddressData() {
    var postData = {
    }
    requestQueMsg.data = postData;
    getData(requestQueMsg);
}

function setAddressData(data) {
  var dataArray = new Array(); //数据对象数组
  for (var i = 0; i < data.result.length; i++) {
          addressMsg = new Object();
          addressMsg.flag = data.result[i].isdefault;
          addressMsg.name = data.result[i].name;
          addressMsg.address = data.result[i].address
          addressMsg.telephone = data.result[i].telephone
          addressMsg.id = data.result[i].id;
          dataArray.push(addressMsg);
  }
  $("#table_body tr").not("tr:first").remove(); //清空除第一行之外的表内容
  $("#table_body tr").not("tr:first").remove(); //清空除第一行之外的表内容
  
      var trLength = dataArray.length;
      var table = document.getElementById("address");
      for (var i = 0; i < trLength; i++) {
          if (dataArray[i].flag == true) {
              table.rows[i + 1].cells[0].innerHTML = "<input type='radio'  name='address' value='New'style='width:25px;height:25px;' checked>";
          }
          else
              table.rows[i + 1].cells[0].innerHTML = "<input type='radio'  name='address' value='New'style='width:25px;height:25px'>";
        table.rows[i + 1].cells[1].innerHTML =  dataArray[i].name;
        
        table.rows[i + 1].cells[2].innerHTML = dataArray[i].address;
        table.rows[i + 1].cells[3].innerHTML = dataArray[i].telephone;
        table.rows[i + 1].cells[4].innerHTML = dataArray[i].id;
        var $tr = $("#address tr").eq("-1");
        $tr.after("<tr id='last'><td></td><td></td><td></td><td></td><td style='display:none;'></td></tr>");
      }
      $('#address tr:last').remove();
//      var row = $("<tr></tr>")
//      var td1 = "<td width='4%' align='center'><input type='button' id='newaddress' class='btn-info btn-md' value='使用新地址' /></td>";
//      var td2 = "<td align='center'class='inputHeader'>&nbsp</td>"
//      row.append(td1);
//      row.append(td2);
//      $('#address').append(row);


}

function setCartData() {
	var url=location.search;
	var Request = new Object();
	if(url.indexOf("?")!=-1)
	{
	   var str = url.substr(1);
	   var strs = str.split("&");
	   for(var i=0;i<strs.length;i++)
	   {
	    Request[strs[i].split("=")[0]]=unescape(strs[ i].split("=")[1]);
	    }
	}
    document.getElementById("shop").innerHTML = Request["shopname"];  
    document.getElementById("name").innerHTML = "<font color='#CC0000'>"+Request["productname"];+"</font>";
    document.getElementById("price").innerHTML = Request["productprice"];
    document.getElementById("attribute").innerHTML = Request["property"];
    document.getElementById("num").value = Request["num"];
}

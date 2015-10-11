
//var requestCommentMsg = {
//    url: URL_COMMENT,
//    callbackMethod: setOwnerData,
//    data: ""
//};
//var requestProductMsg = {
//    url: "localhost:8080/SmartShop/product/getByShop.action",
//    callbackMethod: test,
//    data: ""
//};
var isLoginMsg = {
    url: LOGIN,
    callbackMethod:locationURL,
    data:""
}
var reqProductMsg = {
	    url: URL_QUE_PRODUCT,
	    callbackMethod:setProduct,
	    data:""
	}
var reqShopMsg = {
	    url: URL_QUE_SHOP,
	    callbackMethod:setShop,
	    data:""
	}
var reqProductPropertyMsg = {
	    url: URL_QUE_PRODUCTPROPERTY,
	    callbackMethod:setProductProperty,
	    data:""
	}
var reqProductPropertyValueMsg = {
	    url: URL_QUE_PRODUCTPROPERTYVALUE,
	    callbackMethod:setProductPropertyValue,
	    data:""
	}
var reqCommentMsg={
		url:URL_QUE_PRODUCT_COMMENT,
		callbackMethod:setCommentData,
		data:""
}
//
var commentMsg = {
    name: "",
    rank: "",
    content: "",
    time: "",
};
var shopId;
var productId = 2;
var type;
var userId;
var propertyArray = new Array(); 
var propertyValueArray = new Array(); 
var pvaindex=0;
var shopname;
var productname;
var productprice;
var num;
$(document).ready(function () {
  

    getProduct();//设置商品常规参数，已经完
    
    getProductProperty();
    getProductPropertyValueData();
    
    getShop();
    getComment();
    if (document.getElementById("num").value == 1) {
        var sub = document.getElementById("sub");
        sub.disabled = true;
    }
    $("#add").click(function () {
        document.getElementById("num").value = parseInt(document.getElementById("num").value) + 1;
         if (document.getElementById("num").value != 1) {
            var sub = document.getElementById("sub");
            sub.disabled = false;
        }
    });
    $("#sub").click(function () {
        document.getElementById("num").value = parseInt(document.getElementById("num").value) - 1;
        if (document.getElementById("num").value <= 1) {
            var sub = document.getElementById("sub");
            sub.disabled = true;
        }
    }); 
    $('#etalage').etalage({
        thumb_image_width: 300,
        thumb_image_height: 400,
        source_image_width: 900,
        source_image_height: 1200,
        show_hint: true,
        click_callback: function (image_anchor, instance_id) {
            alert('Callback example:\nYou clicked on an image with the anchor: "' + image_anchor + '"\n(in Etalage instance: "' + instance_id + '")');
        }
    });
});
function buy() {
	 var checked =$("input:checked");
	  if(checked.size()==0){
			alert("需选中商品属性！");
			return;
		}
	num=document.getElementById("num").value;
	var buyArray = new Array(); 
	$(checked).each(function()
	{
		 var value = $(this).val();
		 buyArray.push(value);
	});
	var string="";
	string+="?shopname="+escape(shopname);
	string+="&productname="+escape(productname);
	string+="&productprice="+productprice;
	string+="&num="+num;
	var temp="";
	for(var i=0;i<buyArray.length;i++)
		temp+=buyArray[i]+";";	
	string+="&property="+escape(temp);
	window.location.href="../order/addOrder.html"+string;
}
function isLogin() {
    getData(isLoginMsg);
}
function locationURL(result) {
    if (result.success == true) {
        window.location.href = "../user/myself.html";
    }
    else {
    	if(result.success==false)
    		window.location.href = "../login.html";
    }
}


function getProduct() {
    reqProductMsg.data = {
        productId:productId
    }
    getData2(reqProductMsg);
}
function setProduct(data) {
	document.getElementById("productname").innerHTML = data.name;
	productname=data.name;
	document.getElementById("price").innerHTML= "¥"+data.price;
	productprice=data.price;
	document.getElementById("simple").innerHTML= data.simpleDescription;
	type=2;
	shopId=data.shopId;
	var picArray = new Array(); 
	var picstring="";
	for(var i=0;i<data.images.length;i++)
	{
	picstring = picstring+"<li><img class='etalage_thumb_image' src="+"../../"+data.images[i].url+" class='img-responsive' />" +
	"<img class='etalage_source_image' src="+"../../"+data.images[i].url+" class='img-responsive' title='' /></li>"
	$("#picture").append("<div><br><img src="+"../../"+data.images[i].url+" class='img-responsive' alt=''/></div>");
	}
	$("#etalage").append(picstring);
	$("#complex").append(data.complexDescription);
}
function getShop()
{
	var posdata=
		{
			id:shopId,
		}
	reqShopMsg.data=posdata;
	getData2(reqShopMsg);
}
function setShop(data) {
    document.getElementById("shop").innerHTML = data.name;
    shopname=data.name;
    
    document.getElementById("shoptype").innerHTML = "<li><a href='#.html' data-hover='Company Profile'>" +
    		"所有分类</a></li><li><a href='#.html' data-hover='Company Profile'>衣服</a></li>"
    //document.getElementById("shopowner").innerHTML = "老王";
    document.getElementById("shoprank").innerHTML=data.level;
    document.getElementById("shopdate").innerHTML=data.time;
    document.getElementById("shopinfo").innerHTML=data.description;
    userId=data.userId;
}


function getProductProperty() {
    reqProductPropertyMsg.data = {
    	productTypeId:1
    }
    getData2(reqProductPropertyMsg);
}
function setProductProperty(data)
{	
	for(var i=0;i<data.result.length;i++)
	{
		$("#value").append(" <li class='twt1_desc'><span class='m_1'>"+
				data.result[i].name+":</span><div id="+data.result[i].name+"></div></li>");
		propertyArray.push(data.result[i].id);
		propertyValueArray.push(data.result[i].name);
	}
}
function getProductPropertyValueData() {
	for(var i=0;i<propertyArray.length;i++)
	{
//		alert(propertyArray[i]);
		reqProductPropertyValueMsg.data = {
				productPropertyId:propertyArray[i]
		    }
		getData2(reqProductPropertyValueMsg);
	}
}
function setProductPropertyValue(data)
{
	var string="";
	for(var i=0;i<data.result.length;i++)
	{
		if(i==0)
			string=string+"<input type='radio' name='"+propertyValueArray[pvaindex]
		+"'value='"+data.result[i].name+"'checked/>"+data.result[i].name+"&nbsp;&nbsp;&nbsp;";
		else
			string=string+"<input type='radio' name='"+propertyValueArray[pvaindex]
		+"'value='"+data.result[i].name+"'/>"+data.result[i].name+"&nbsp;&nbsp;&nbsp;";
	}
	$("#"+propertyValueArray[pvaindex]+"").append(string);
	pvaindex++;
}
function getComment()
{
	var posdata=
		{
			"comment.productId":productId,
			"comment.commentTypeId":type
		}
	reqCommentMsg.data=posdata;
	getData2(reqCommentMsg);
}

function setCommentData(data) {
    var dataArray = new Array(); //数据对象数组
    for (var i = 0; i < data.result.length; i++) {
        commentMsg = new Object();
        commentMsg.name = data.result[i].username;
        commentMsg.rank = data.result[i].commentType;
        commentMsg.content = data.result[i].comment;
        commentMsg.time = data.result[i].time;
        dataArray.push(commentMsg);
    }
    var sequenceArray = new Array();//序列数组
    sequenceArray[0] = "name";
    sequenceArray[1] = "rank";
    sequenceArray[2] = "content";
    sequenceArray[3] = "time";

    totalPage = 2;
    $("#comment_tableBody tr").not("tr:first").remove(); //清空除第一行之外的表内容
    addTableBody("comment", dataArray, sequenceArray); //调用公用添加table方法

    $("#comment").dataTable({
        "aLengthMenu": [[8, 16, 32, 64], [8, 16, 32, 64]],
        "bFilter": false,
        "bRetrieve": true,
        "bSort": true,
        "bInfo": false,
        "bJQueryUI": false,
        "iDisplayLength": 8,
        "bPaginate": true,       //翻页功能
        "bLengthChange":false,       //改变每页显示数据数量
        "aaSorting": [[1, "desc"]],//设置第2个元素为默认排序     
        "aoColumnDefs": [{
            "bSortable": false, //指定不支持排序的列  
            "aTargets": [0]
        }],
        "oLanguage": {
            "sZeroRecords": "对不起，查询不到任何相关数据",
            "sInfo": "当前显示 _START_ 到 _END_ 条，共 _TOTAL_ 条记录",
            "sInfoEmpty": "记录数为0",
            "sSearch": "搜索:",
            "sInfoFiltered": "  ，共搜索 _MAX_ 条记录",
            "sLengthMenu": "每页显示 _MENU_ 条记录",
            "oPaginate": {
                "sNext": "下一页",
                "sPrevious": "上一页"
            }
        }
    });
}


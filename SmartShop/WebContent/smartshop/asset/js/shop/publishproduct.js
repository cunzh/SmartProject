var requestProductMsg={
	url: "../../product/add.action",
	callbackMethod:submitInfoResult,
	data:""
};


 var requestProductTypeMsg = {
    url: "../../producttype/get.action",
    callbackMethod: setProductTypeSelect,
    data: ""
};

 
 var requestShopMsg = {
		    url: "../../shop/getByUserId.action",
		    callbackMethod: setShopSelect,
		    data: ""
		};

 var requestProductPropertyMsg = {
    url: "../../productproperty/get.action",
    callbackMethod: setProductPropertySelect,
    data: ""
};
 
var requestProductPropertyValueMsg = {
				    url: "../../propertyvalue/get.action",
				    callbackMethod: setProductPropertyValueSelect,
				    data: ""
				};
		 

var ProductTypeID;

var ProductPropertyID;


$(document).ready(function() {

	getProductTypeData();

	getUserShopData();


	 $("#button_submit").click(function(){ 
	      
	        if($("#product_title").val()==''||$("#product_price").val()==''||$("#product_simple").val()=='')
	        {
	            alert("内容不能为空！");
	        }
	        else
	        {
	          if(confirm("是否确认发布产品？"))
	          {
	              submitProductData();
	          }
	        }  
	    }); 

	//$('#product_type').change(function () {

			    //ProductTypeID = $(this).children('option:selected').val();
					//alert("你所选择的商品类型是："+ProductTypeID);
			   //getProductPropertyData();

			//});

	

});




function getProductTypeData()
{

	getData(requestProductTypeMsg);

}


function setProductTypeSelect(data) { 

//	alert("商品类型默认值"+ProductTypeID);
		   fillSelect2(data,"#product_type");

		}


function getUserShopData()
{
	//登陆之后服务器和浏览器会自动保存usrID，因此不用在手动提供userID
	//var userID="2";
	//var postData = { "id":userID };
	//requestShopMsg.data = postData;
	getData(requestShopMsg);

}


function setShopSelect(data) { 

//	alert("商品类型默认值"+ProductTypeID);
		   fillSelect(data,"#product_shop");

		}

 function getProductPropertyData()
 {
 var postData = {"productPropertyId":ProductTypeID};

	 requestProductPropertyMsg.data = postData;
	 
	getData(requestProductPropertyMsg);
 
 }

 function getProductPropertyData()
 {
	 
 var postData = {"productTypeId":ProductTypeID};

	 requestProductPropertyMsg.data = postData;
	 
	getData(requestProductPropertyMsg);
 
 }


function setProductPropertySelect(data) 
{
	$("#product_property").empty();
	fillSelect(data,"#product_property");
}

function getProductPropertyValueData()
{
	 

var postData = {"productPropertyId":ProductPropertyID};

	 requestProductPropertyValueMsg.data = postData;
	 
	getData(requestProductPropertyValueMsg);

}


function setProductPropertyValueSelect(data) {
	
	//$("#product_property_value").empty();
	document.getElementById('dynamic_value').innerHTML='';
	$("#dynamic_value").append("<label>属性值:</label>");
	
	document.getElementById('property').innerHTML='';
	
	 var dataArray = new Array(); //数据对象数组
	for (var i = 0; i < data.result.length; i++) {
        Msg = new Object();
        Msg.name = data.result[i].name;
        Msg.id = data.result[i].id;
        dataArray.push(Msg);
    }
	
	 for (var i = 0; i < dataArray.length; i++) {
		 $("#property").append("<input type='checkbox' id='"+dataArray[i].id+"' ><label class=''>"+dataArray[i].name+"</label>&nbsp;&nbsp;");
		   //fillSelect(data,"#product_property_value");
		}


function setProductPropertySelect(data) {
	
	//alert("商品属性是"+ProductTypeID);
	$("#product_property").empty();
		   fillSelect(data,"#product_property");
		}

}

//提交报修信息
function submitProductData() {

	 var title = $("#product_title").val();

    var type = $("#product_type").val();

	var property = $("#product_property").val();

	//var propertyvalue = $("#product_property_value").val();


	//var propertyvalue = $("#product_property_value").val();


    var price = $("#product_price").val();

    //var freight = $("#product_freight").val();
    //var address = $("#product_address").val();
    //var content = $("#product_content").val();
   

    var im = $("#imagesid").val();

	var shopId = 3;

//	alert("商品类别是"+type);
//	alert("商品属性是"+property);
//
//	alert("商店号是"+shopId);


   //var formData = {"product.name":title,"product.typeId":type,"product.shopId":shopId,
	   //"propertyValueId":property,"product.price":price "images":im}
	//var uploadForm = $("#uploadForm");
  
    //var sendMsg = uploadForm.serializeArray();
    //var formData={"repair.username":userName,"repair.roomnumber":roomid,"repair.devicename":deviceName,"repair.phone":phonenumber,"repair.description":description};
	//var sendMsg=$.toJSON(repairMsg.data);
    
	var uploadForm = $("#uploadForm");


	var formData = new FormData($("#uploadForm")[0]);

	//alert(formData['repair.devicename']+"ppppp");

	requestProductMsg.data=formData;

	//getData(requestRrepairMsg);

	getDataWithFileUpload(requestProductMsg);
}

function submitInfoResult(result)
{
	if(result.success == true)
	{
		alert("提交信息成功");
	} 
	else
	{
		alert("提交信息失败  " + result.type);
	}
	
}
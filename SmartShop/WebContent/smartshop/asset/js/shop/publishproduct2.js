var requestMsg = {
    url:"../../product/update.action",
    callbackMethod : setData,
    data:""
};
var requestQueryMsg = {
	    url:"../../productshow/getByProductId.action",
	    callbackMethod : setPreData,
	    data:""
	};
 var requestProductTypeMsg = {
    url: "../../producttype/get.action?id=4",
    callbackMethod: setProductTypeSelect,
    data: ""
};

var ProductTypeID = 0;
var productID;
//alert(ProductTypeID);
$(document).ready(function() {
	productID = $.getUrlParam('id')+"";
	getPreData();
	getProductTypeData();
	$("#button_reset").click(function() {
		window.location.href="changeproduct.html"
	});
	
	$("#button_submit").click(function() {
	    var name = document.getElementById("product_title").value;
	    var type = $('#product_type option:selected').val();
	    var price = document.getElementById("product_price").value;
	    var simple=document.getElementById("product_simple").value;
	    var complex=document.getElementById("product_complex").value;  
	    var postData={
	        "product.id":productID,
			"product.name":name,
            "product.type":type,
            "product.price":price,
            "product.simpleDescription":simple,
            "product.complexDescription":complex
		};
			 requestMsg.data = postData;
			 getData(requestMsg);
	});
});
function getPreData()
{
	var posdata={
	"productId":productID
	}
	requestQueryMsg.data=posdata;
	getData(requestQueryMsg);
}
function getProductTypeData()
{
	getData(requestProductTypeMsg);
}
function setProductTypeSelect(data) { 
		   fillSelect2(data,"#product_type");
		}
function setPreData(data)
{
    document.getElementById("product_title").value = data.name;
    document.getElementById("product_type").value = data.typeId;
    document.getElementById("product_price").value = data.price;
    document.getElementById("product_simple").value = data.simpleDescription;
    document.getElementById("product_complex").value = data.complexDescription;
}
function setData(result)
{
	if(result.success == true)
	{
		alert("修改商品信息成功");
	} 
	else
	{
		alert("修改商品信息失败  " + result.type);
	}
	
}

(function($){ $.getUrlParam = function(name) 
    {
        var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
        var r = window.location.search.substr(1).match(reg);
        if (r != null)
            return unescape(r[2]);
        return null;
    }
})(jQuery);
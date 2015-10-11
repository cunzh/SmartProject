var onePageSize=8;   //请求服务器每页数据的大小
var currPage=1;       //当前第几页
var totalPage;     //总页数
var totalcount;   //总条数
var visiblepage=10;   //显示的页面按钮数
var isinit=0;  //判断是否是初始化
var tableID="#shop_table";
var tableBodyID="#shop_tableBody";
var pageid="#pagination";
var currentSpanId="#sp";

	//请求科室信息对象
	var	requestShopMsg ={
		url: "../../shop/getByUserId.action",
		callbackMethod:setShopData,
		data:""
	};
	
	
	$(document).ready(function() {

		getShops();
		
	});
	
	//获得卖家店铺信息
	function getShops(){
		//alert("test");
		var postData={};
		requestShopMsg.data=postData;	
		getData(requestShopMsg);	
	}

	function setShopData(data)
	{	
		var dataArray = new Array(); 
		for(var i=0;i<data.result.length;i++)
		{ 
	 		dataArray[i]=new Array(); 
	 		
	 		dataArray[i][0]=data.result[i].name;
	 		dataArray[i][1]=data.result[i].description;
	 		dataArray[i][2]=data.result[i].time;
	 		
	 		dataArray[i][3]="<a href='#' onclick='checkShopOrder("+data.result[i].id+")' >"+ "查看订单" + "</a>";

		}
				
		$("#shop_tableBody tr").not("tr:first").remove(); //清空除第一行之外的表内容
		addTableBodyV1("shop_table",dataArray); //调用公用添加table方法
		
	}
	
	//查看店铺订单
	function checkShopOrder(shopId){
		//alert("shopID:"+shopId);
		window.location.href="dealwithorder.html?shopId="+shopId;
	}
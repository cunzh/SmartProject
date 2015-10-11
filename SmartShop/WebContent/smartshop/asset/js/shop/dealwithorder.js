 //查看未完成订单
	var requestUnDealOrderMsg={
		url:"../../order/getByShop.action",
		callbackMethod:setUnDealOrder, 
		data:""
	};

	//查看已处理的订单
	var requestFinishedOrderMsg={
		url:"../../order/getByShop.action",
		callbackMethod:"", 
		data:""
	};

	var requestChangeOrderStateMsg={
		url:"",
		callbackMethod:"", 
		data:""
	};
		
		///请求删除订单
	var requestDeleteOrderMsg={
		url:"../../order/delete.action",
		callbackMethod:getFinishedOrder, 
		data:""
	};


		//为处理报修对象
		var UnDealOrderMsg={
			order_number:"",               
			//shop_id:"",                       
			received:"",                      
			//product_id:"",             
			//address:"",        
			//telephone:"",             
			price:"",                
			order_time:"",     
			//number:"",                
			//recipient:"",   
			//information:"",  
		
				information:"" 
		};

		
		var orderFinishedMsg={
			
				order_number:"",               
				//shop_id:"",                       
				received:"",                      
				//product_id:"",             
				//address:"",        
				//telephone:"",             
				price:"",                
				order_time:"",     
				//number:"",                
				//recipient:"",   
				//information:"",  
				dealwith:"",
					information:"" 
/*
订单号
	卖家
	买家
	 交易商品
	交易收货地址 
	买家电话
	交易价格
	订单产生日期 
	商品个数 
	 收件人 
	是否已经接收*/
		};


	var shopID;
    
	var nameArray=new Array();	 ///商品名称
	var numberArray=new Array(); ///商品数量
	var priceArray=new Array();	 ///商品价格

 $(document).ready(function () {

	 shopID=getUrlValue("shopId");
	 
	 getUnDealOrder();
       
    
	$("#UnfinishOrder_tab").click(function() {
		getUnDealOrder();
	});

	$("#FinishedOrder_tab").click(function() {
		//alert("获取最新完成订单");
		getFinishedOrder();
	});


	$(document).on("click",".delete",function(){
		
		var orderNumber = $(this).parents("tr").children("td:eq(0)").text();
	
		var postData={"orderNumber":orderNumber};
			
			requestDeleteOrderMsg.data=postData;
			
			getData(requestDeleteOrderMsg);

	}); 
           
}); 


 	//获得地址栏传递的参数值
	function getUrlValue(name)
	{
		var str=window.location.search;
		//alert(str);
		if (str.indexOf(name)!=-1)
		{
			var pos_start=str.indexOf(name)+name.length+1;
			var pos_end=str.indexOf("&",pos_start);
			if (pos_end==-1)
			{
				return str.substring(pos_start);
			}
			else
			{
				return str.substring(pos_start,pos_end);
			}
		}
		else
		{
			return false;
		}
	}
	
	
	function getUnDealOrder() {
		//alert(shopID);
		var postData={
			"shopId":shopID
		};
		requestUnDealOrderMsg.data=postData;
		requestUnDealOrderMsg.callbackMethod = setUnDealOrder;
		getData(requestUnDealOrderMsg);
		   
	}
	
	function setUnDealOrder(data) {

			var dataArray = new Array(); //数据对象数组
		    for (var i = 0; i < data.result.length; i++) {
		    	UnDealOrderMsg = new Object();

		    	
		        //orderFinishedMsg.shop_id = data.result[i].shopId;
		        if(data.result[i].confirmed==0){
		        	
		        	UnDealOrderMsg.order_number = data.result[i].orderNumber;
		        	UnDealOrderMsg.received="否";
		        	UnDealOrderMsg.price = data.result[i].totalPrice;
		        	UnDealOrderMsg.order_time = data.result[i].orderTime;
				        
				        nameArray[UnDealOrderMsg.order_number]=new Array();    //声明二维，每一个一维数组里面的一个元素都是一个数组；
						numberArray[UnDealOrderMsg.order_number]=new Array();
						priceArray[UnDealOrderMsg.order_number]=new Array();
						
						for(var j=0;j<data.result[i].ordersProducts.length;j++){
							nameArray[UnDealOrderMsg.order_number][j]=data.result[i].ordersProducts[j].productName;
							numberArray[UnDealOrderMsg.order_number][j]=data.result[i].ordersProducts[j].number;
							priceArray[UnDealOrderMsg.order_number][j]=data.result[i].ordersProducts[j].price;
						}

						UnDealOrderMsg.information = "<a href='#' class='delete' onclick='loadDealInfo("+UnDealOrderMsg.order_number+")'>" + "详情" + "</a>";

				        dataArray.push(UnDealOrderMsg);
		        }	        	        

		    	}
		    	
		   
	       

		    var sequenceArray = new Array();//序列数组

		    sequenceArray[0] = "order_number";
		    //sequenceArray[1] = "shop_id";
		    sequenceArray[1] = "received";
		    //sequenceArray[3] = "product_id";
		    //sequenceArray[4] = "telephone";
		    sequenceArray[2] = "price";
		    sequenceArray[3] = "order_time";
			//sequenceArray[7] = "number";
		    //sequenceArray[8] = "recipient";
	
		    sequenceArray[4] = "information";
	

		    totalPage = data.totalPage;
		    $("#undodemandtableBody tr").not("tr:first").remove(); //清空除第一行之外的表内容
		    addTableBody("undodemandtable", dataArray, sequenceArray); //调用公用添加table方法
		   
	}
	
		//标记处理方法
		function signHandledClick(id)
		{
			

		}


		function loadDealInfo(Id)
		{
			
		    var array = new Array(); //数据对象数组
			for (var i = 0; i < nameArray[Id].length; i++) 
			{	
				ProductMsg = new Object();
				var name=nameArray[Id][i];
				var number=numberArray[Id][i];
				var price=priceArray[Id][i];
				//alert(name);
				
				ProductMsg.name=name;
				ProductMsg.number=number;	
				ProductMsg.price=price;	
				
				array.push(ProductMsg);
			}
					
			var sequence= new Array();//序列数组

		    sequence[0] = "name";
		    sequence[1] = "number";
		    sequence[2] = "price";
		    
		    $("#tableBody tr").not("tr:first").remove(); //清空除第一行之外的表内容
		    addTableBody("table", array, sequence); //调用公用添加table方法
		    
			$('#sign_up').lightbox_me({
				centered: true,
				closeClick:false,
				onLoad: function() { 
					$('#sign_up').find('input:last').focus();
				}
		});	
			
			$('#cancel').click(function(){ 		
				$('#sign_up').trigger('close');    
			});

		}

		///已处理订单
		function getFinishedOrder() 
		{
			var postData={
				"shopId":shopID
			};
			requestFinishedOrderMsg.data=postData;
		    requestFinishedOrderMsg.callbackMethod = setDemands2;
		    getData(requestFinishedOrderMsg);
		}
		

		function setDemands2(data) 
		{
		    var dataArray = new Array(); //数据对象数组
		    for (var i = 0; i < data.result.length; i++) {
		        orderFinishedMsg = new Object();

		        orderFinishedMsg.order_number = data.result[i].orderNumber;
		        //orderFinishedMsg.shop_id = data.result[i].shopId;
			        if(data.result[i].confirmed==1){
			        	
			        	orderFinishedMsg.order_number = data.result[i].orderNumber;
			        	orderFinishedMsg.received = "是";
			        	
			        	orderFinishedMsg.price = data.result[i].totalPrice;
				        orderFinishedMsg.order_time = data.result[i].orderTime;
				        
				        nameArray[orderFinishedMsg.order_number]=new Array();    //声明二维，每一个一维数组里面的一个元素都是一个数组；
						numberArray[orderFinishedMsg.order_number]=new Array();
						priceArray[orderFinishedMsg.order_number]=new Array();
						
						for(var j=0;j<data.result[i].ordersProducts.length;j++){
							nameArray[orderFinishedMsg.order_number][j]=data.result[i].ordersProducts[j].productName;
							numberArray[orderFinishedMsg.order_number][j]=data.result[i].ordersProducts[j].number;
							priceArray[orderFinishedMsg.order_number][j]=data.result[i].ordersProducts[j].price;
						}
	
	
				        orderFinishedMsg.dealwith = "<a href='#' class='delete' onclick='deleteOrderClick("+orderFinishedMsg.order_number+")'>" + "删除订单" + "</a>";
				        orderFinishedMsg.information = "<a href='#' class='delete' onclick='loadDealInfo("+orderFinishedMsg.order_number+")'>" + "详情" + "</a>";
	
				        dataArray.push(orderFinishedMsg);
			        	
			        }	        	        
		    	}

		    var sequenceArray = new Array();//序列数组

		    sequenceArray[0] = "order_number";
		    //sequenceArray[1] = "shop_id";
		    sequenceArray[1] = "received";
		    //sequenceArray[3] = "product_id";
		    //sequenceArray[4] = "telephone";
		    sequenceArray[2] = "price";
		    sequenceArray[3] = "order_time";
			//sequenceArray[7] = "number";
		    //sequenceArray[8] = "recipient";
		    sequenceArray[4] = "dealwith";
		    sequenceArray[5] = "information";
	

		    totalPage = data.totalPage;
		    $("#finishdemandtableBody tr").not("tr:first").remove(); //清空除第一行之外的表内容
		    addTableBody("finishdemandtable", dataArray, sequenceArray); //调用公用添加table方法

		   
		}

		//标记处理方法
		function deleteOrderClick(orderNumber)
		{
			var postData={"orderNumber":orderNumber};
			requestDeleteOrderMsg.data=postData;
			getData(requestDeleteOrderMsg);

		}

		function ChangeRepairState()
		{
			getUndoRepairData(); //获取未完成报修信息
		
			getFinishedRepairData();  //获取已完成报修信息
		}


var requestMsg = {
    url:"../../product/getByShop.action",
    callbackMethod : setData,
    data:""
};

var requestProductMsgByType = {
	    url:"../../product/getByType.action",
	    callbackMethod : setData,
	    data:""
	};

var requestShopMsg = {
	    url: "../../shop/getByUserId.action",
	    callbackMethod: setShopSelect,
	    data: ""
	};

var requestProductTypeMsg = {
	    url: "../../producttype/get.action",
	    callbackMethod: setProductTypeSelect,
	    data: ""
	};

var requestQueryMsg = {
    url: "../../productshow/getByProductProperty.action",
    callbackMethod: setData,
    data: ""
};

//var requestProductPropertyMsg = {
//    url: "../../productproperty/get.action",
//    callbackMethod: setProductPropertySelect,
//    data: ""
//};

  
  //商品信息
  var productMsg = {
      name: "",
      simpleDescription: "",
      complexDescription:"",
      price: "",
      type: ""
  };

  var shopID;
  var type;
    $(document).ready(function () {
    	
    	getUserShopData();
        getProductTypeData();
        
        $("#query_button").click(function () {
			shopID = $('#product_shop').children('option:selected').val();
			type = $('#product_type').children('option:selected').val();
			if((shopID!=0)&(type==0))
			{
			   getProductByShopID(shopID)
			}
			else  if((shopID!=0)&(type!=0))
			 	{
			    	getProductByType(shopID,type)
			    }
			else  if(shopID==0)
		 	{
		    	alert("请选择商店！");
		    }
		   
			});
//			$('#product_type').change(function () {
//				
//				ProductTypeID = $(this).children('option:selected').val();
//				alert(ProductTypeID);
//				getProductPropertyData();			
//			});   
    });
    	

    function getUserShopData()
    {
    	//登陆之后服务器和浏览器会自动保存usrID，因此不用在手动提供userID
    	getData(requestShopMsg);
    }
    
    function setShopSelect(data) 
    { 
    	fillSelect(data,"#product_shop");

    }
   ///获取商品类型
	function getProductTypeData() {

	    getData(requestProductTypeMsg);

	}
	
	function setProductTypeSelect(data) {
		fillSelect2(data, "#product_type");
	}
    ///通过SHOPID查询商品
	function getProductByShopID(ID)
    {
		// alert("ID:"+ID);
		var postData={"id":ID};
		requestMsg.data = postData;
		getData(requestMsg);
	}

		  ///通过商品类型查询商品
		function getProductByType(shopID,type)
		{
			 var postData={"shopId":shopID,"typeId":type};
			 requestProductMsgByType.data = postData;
			 getData(requestProductMsgByType);
			
		}
	
//		function getProductPropertyData() {
//		    var postData = { "productTypeId": ProductTypeID };
//		    requestProductPropertyMsg.data = postData;
//		    getData(requestProductPropertyMsg);
//		}
//		function setProductPropertySelect(data) {
//		    $("#product_property").empty();
//		    fillSelect(data, "#product_property");
//		}

	    function setData(data)
        {
          var dataArray=new Array(); //数据对象数组
          for(var i=0;i<data.result.length;i++)
          {
            productMsg=new Object();

            productMsg.name = data.result[i].name;
            productMsg.simpleDescription = data.result[i].simpleDescription;
            productMsg.complexDescription = data.result[i].complexDescription;
            productMsg.price = data.result[i].price;
            productMsg.type = data.result[i].typeId;
        
            dataArray.push(productMsg);
          }

          var sequenceArray=new Array();//序列数组
          sequenceArray[0]="name";
          sequenceArray[1] = "simpleDescription";
          sequenceArray[2] = "complexDescription";
          sequenceArray[3] = "price";
          sequenceArray[4] = "type";

          totalPage=data.totalPage; 
          $("#owner_tableBody tr").not("tr:first").remove(); //清空除第一行之外的表内容
          addTableBody("owner_table",dataArray,sequenceArray); //调用公用添加table方法
      
       
	       $("#owner_table").dataTable({
				    "aLengthMenu": [[8, 16, 32, 64], [8,16, 32, 64]],
				    "bFilter": true,
               "bInfo": false,
				    "bRetrieve": true,
				    "bSort":true,
				    "bJQueryUI": false, 
				    "iDisplayLength":8,
				    "bPaginate":true,       //翻页功能
				    "bLengthChange":true,       //改变每页显示数据数量
				    "aaSorting": [[ 1, "desc" ]],//设置第2个元素为默认排序     
				    "aoColumnDefs" : [{  
			            "bSortable" : false, //指定不支持排序的列  
			               "aTargets" : [0]
			        }], 
				 
				    "oLanguage":{
					    "sZeroRecords":"对不起，查询不到任何相关数据",
					    "sInfo":"当前显示_START_到_END_条，共_TOTAL_条记录",
					    "sInfoEmpty":"记录数为0",
					    "sSearch": "搜索:",
					    "sInfoFiltered": "  ，共搜索 _MAX_ 条记录",
					    "sLengthMenu": "每页显示 _MENU_ 条记录",
					    "oPaginate":{ 
						    "sNext":"下一页",
						    "sPrevious":"上一页"
					    }

				    }
			    });
	    }
	    

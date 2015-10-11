var requestMsg = {
    url:"../../product/getByShop.action?id=3",
    callbackMethod : setData,
    data:""
};
//var requestQueryMsg = {
//    url: "../../product/getByShop.action?id=4",
//    callbackMethod: setQueryData,
//    data: ""
//};
var requestProductTypeMsg = {
    url: "../../producttype/get.action",
    callbackMethod: setProductTypeSelect,
    data: ""
};
var requestProductPropertyMsg = {
    url: "../../productproperty/get.action",
    callbackMethod: setProductPropertySelect,
    data: ""
};
//  var onePageSize=10;   //请求服务器每页数据的大小
//  var currPage=1;       //当前第几页
//  var totalPage;     //总页数
//  var finishedTotalPage;     //总页数
//  var totalcount;   //总条数
//  var visiblepage=10;   //显示的页面按钮数
//  var isinit=0;  //判断是否是初始化
 
  var tableID="#owner_table";
  var tableBodyID="#owner_tableBody";
  var pageid="#pagination";
  var currentSpanId = "#sp";

  
  //已录入楼宇对象
  var productMsg = {
      name: "",
      simpleDescription: "",
      complexDescription:"",
      price: "",
      type: ""
  };

    $(document).ready(function () {
            getProductData();
            getProductTypeData();
			$("#query_button").click(function () {
//			    type = $('#search_client').children('option:selected').val();
//			    getQueryData();
			});
			$('#product_type').change(function () {
				ProductTypeID = $(this).children('option:selected').val();
				getProductPropertyData();			
			});   
    });

		function getProductData()
        {
		    var postData={};
		    requestMsg.data = postData;
		    getData(requestMsg);
		}
		//function getQueryData() {
		//    var postData = {
		//        //"type": type
		//    };
		//    requestQueryMsg.data = postData;
		//    getData(requestQueryMsg);
		//}

		function getProductTypeData() {

		    getData(requestProductTypeMsg);

		}
		function setProductTypeSelect(data) {
		    fillSelect(data, "#product_type");
		}


		function getProductPropertyData() {
		    var postData = { "productPropertyId": ProductTypeID };
		    requestProductPropertyMsg.data = postData;
		    getData(requestProductPropertyMsg);
		}
		function setProductPropertySelect(data) {
		    $("#product_property").empty();
		    fillSelect(data, "#product_property");
		}

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
      
          if (!isinit) {
          
          }
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

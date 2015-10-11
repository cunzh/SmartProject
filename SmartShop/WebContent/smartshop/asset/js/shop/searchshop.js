//请求公告对象
  var requestShopMsg ={
    url: URL_QUERY_SHOP,
    callbackMethod : setShopData,
    data:""
 };
  
//按关键字请求公告对象
  var requestShopByKeywords ={
   // url: URL_QUERY_NOTICE_KEYWORDS,
    callbackMethod : setShopData,
    data:""
 };

  



    var ShopMsg={
		
      title:"" ,
      content:"" ,
      time:"" 
     // author:""
	
    }



$(document).ready(function ()
  {

  // setDatePicker();
    getShopData();

	$("#shop_history_search").click(function(){ 
          
            if($("#shop_keywords").val()=='')
            {
                alert("关键字不能为空！");
            }
            else
            {
              getDataByKeyword();
             
            }  
        }); 
   
  });





    function getShopData()
    {
		//$("#notice_table").dataTable().fnDestroy();//防止重复初始化表格
			//var notice_keywords = $("#notice_keywords").val();

			//var postData={};

			//requestNoticeMsg.callbackMethod=setNoticeData;

			//requestNoticeMsg.data=postData;
			
		
			//getDataWithFileUpload(requestNoticeMsg);
			getData(requestShopMsg);
    }

function getDataByKeyword()
    {

		$("#shop_table").dataTable().fnDestroy();//防止重复初始化表格


			var shop_keywords = $("#shop_keywords").val();

			var postData={keywords: notice_keywords};

			

			requestShopByKeywords.data=postData;
			
			//getDataWithFileUpload(requestNoticeMsg);
			getData(requestShopByKeywords);
    }

  
    function setShopData(data)
    {	
		

      var dataArray=new Array(); //数据对象数组
		
		
      for(var i=0;i<data.result.length;i++)
      {
        ShopMsg=new Object();

		 //NoticeMsg.id =data.result[i].id;
        ShopMsg.title =data.result[i].name;
        ShopMsg.content=data.result[i].description;
       ShopMsg.date=data.result[i].time;
       // NoticeMsg.author=data.result.length;
	 

		//ElectricityMsg.state="<input type='button' class='nopay'  style='color:red;' value='未交' />";

        //NoticeMsg.edit="<a href='#' onclick='editClick("+data.result[i].id+")'>" + "修改" + "</a>";
       // NoticeMsg.dele="<a href='#' onclick='deleClick("+data.result[i].id+")'>" + "删除" + "</a>";
       

        dataArray.push(ShopMsg);
      }
   
      var sequenceArray=new Array();//序列数组
      
	 //sequenceArray[0]=$("<input type='checkbox' >");
	  sequenceArray[0]="title";
      sequenceArray[1]="content";
      sequenceArray[2]="date";
     // sequenceArray[3]="author";
     

      totalPage=data.totalpage; 

		

      $("#shop_tableBody tr").not("tr:first").remove(); //清空除第一行之外的表内容
	
      addTableBody("shop_table",dataArray,sequenceArray); //调用公用添加table方法
      
	  
    //  if (!isinit) {
       // pageChange(requestNoticeMsg,pageid,currentSpanId,totalPage,totalcount,visiblepage,onePageSize,currPage);
       // isinit=1;
     //}


$("#shop_table").dataTable({
				"aLengthMenu": [[8, 16, 32, 64], [8,16, 32, 64]],
				"bFilter":true,
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

	


   //修改
    function editClick(id)
    { 
      alert(id); 
    }

    //删除
    function deleClick(id)
    {
      if(confirm("是否确认删除？"))
        {
          alert(id);
        } 
    }

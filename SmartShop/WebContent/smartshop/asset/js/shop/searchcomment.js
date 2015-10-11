//请求公告对象
  var requestCommentMsg ={
    url: "../../comment/getByProductId.action",
    callbackMethod : setCommentData,
    data:""
 };
  
//按关键字请求公告对象
  var requestCommentByKeywords ={
    url: "",
    callbackMethod : setCommentData,
    data:""
 };

  


   var onePageSize=20;   //请求服务器每页数据的大小
  var currPage=1;       //当前第几页
  var totalPage;     //总页数
  var finishedTotalPage;     //总页数
  var totalcount;   //总条数
  var visiblepage=10;   //显示的页面按钮数
    
  var isinit=0;  //判断是否是初始化
 
 
    var NoticeMsg={
		
      commentType:"" ,
      comment:"" ,
      time:"" ,
      userId:"",
	username:""
	
    }



$(document).ready(function ()
  {

   setDatePicker();
    getCommentData();

	$("#comment_search").click(function(){ 
          
            if($("#comment_keywords").val()=='')
            {
                alert("关键字不能为空！");
            }
            else
            {
              getDataByKeyword();
             
            }  
        }); 
   
  });


function setDatePicker()
	{
        var myDate = new Date();
        var year = myDate.getFullYear();    //获取完整的年份(4位,1970-)
        var month = myDate.getMonth();       //获取当前月份(0-11,0代表1月)
        var data =  myDate.getDate();        //获取当前日(1-31)
        document.getElementById("comment_date").value = year+"-"+(month+1)+"-"+data;

        var ownerIntimeDatePicker="#comment_date";  //家庭成员入住时间
        initDatepicker(ownerIntimeDatePicker);
    }




    function getCommentData()
    {
		$("#comment_table").dataTable().fnDestroy();//防止重复初始化表格
			//var notice_keywords = $("#notice_keywords").val();
			
			var id=2;
			var postData={"id":id};

			

			requestCommentMsg.data=postData;
			
			//getDataWithFileUpload(requestNoticeMsg);
			getData(requestCommentMsg);
    }

function getDataByKeyword()
    {

		$("#comment_table").dataTable().fnDestroy();//防止重复初始化表格


			//var notice_keywords = $("#comment_keywords").val();

			//var postData={keywords: notice_keywords};

			//requestNoticeByKeywords.callbackMethod=setNoticeData;

			//requestNoticeByKeywords.data=postData;
			
			//getDataWithFileUpload(requestNoticeMsg);
			//getData(requestNoticeByKeywords);
    }

  
    function setCommentData(data)
    {
		

      var dataArray=new Array(); //数据对象数组
		
		
      for(var i=0;i<data.result.length;i++)
      {
        NoticeMsg=new Object();

		 //NoticeMsg.id =data.result[i].id;
        NoticeMsg.commentType =data.result[i].commentType;
        NoticeMsg.comment=data.result[i].comment;
        NoticeMsg.time=data.result[i].time;
        NoticeMsg.userId=data.result[i].userId;
		NoticeMsg.username=data.result[i].username;

		//ElectricityMsg.state="<input type='button' class='nopay'  style='color:red;' value='未交' />";

        //NoticeMsg.edit="<a href='#' onclick='editClick("+data.result[i].id+")'>" + "修改" + "</a>";
       // NoticeMsg.dele="<a href='#' onclick='deleClick("+data.result[i].id+")'>" + "删除" + "</a>";
       

        dataArray.push(NoticeMsg);
      }
   
      var sequenceArray=new Array();//序列数组
      
	 //sequenceArray[0]=$("<input type='checkbox' >");
	  sequenceArray[0]="commentType";
      sequenceArray[1]="comment";
      sequenceArray[2]="time";
	  sequenceArray[3]="userId";
      sequenceArray[4]="username";
     

      totalPage=data.totalpage; 

		

      $("#comment_tableBody tr").not("tr:first").remove(); //清空除第一行之外的表内容
	
      addTableBody("comment_table",dataArray,sequenceArray); //调用公用添加table方法
      
	  
    //  if (!isinit) {
       // pageChange(requestNoticeMsg,pageid,currentSpanId,totalPage,totalcount,visiblepage,onePageSize,currPage);
       // isinit=1;
     //}


$("#comment_table").dataTable({
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

	
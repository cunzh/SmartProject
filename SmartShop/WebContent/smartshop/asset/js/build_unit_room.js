

 var requestBuildMsg = {
    url: URL_QUERY_BUILD,
    callbackMethod: setBuildSelect,
    data: ""
};

var requestUnitMsg = {
    url: URL_QUERY_UNIT,
    callbackMethod: setUnitSelect,
    data: ""
};

var requestRoomMsg = {
    url: URL_QUERY_ROOM,
    callbackMethod: setRoomSelect,
    data: ""
};


	var onePageSize=20;   //请求服务器每页数据的大小
	var currPage=1;       //当前第几页
	var totalPage;     //总页数
	var finishedTotalPage;     //总页数
	var totalcount;   //总条数
	var visiblepage=10;   //显示的页面按钮数

	 var isinit=0;  //判断是否是初始化

 




function getBuildData() 
{
		   
	var postData = { pageSize: onePageSize, pageNo: currPage };
	requestBuildMsg.data = postData;
	getData(requestBuildMsg);

}

function getUnitData(buildNo) {
		    var postData = {
		        "buildNo": buildNo
		        };
			
		    requestUnitMsg.data = postData;
		    getData(requestUnitMsg);
		
		}

function getRoomData(buildNo,unitNo) {
		    var postData = {
		        "buildNo": buildNo,
		        "unitNo": unitNo
                //调试使用，需要修改
		        //"buildNo":1,
               // "unitNo":101
		    };
		    requestRoomMsg.data = postData;
		    getData(requestRoomMsg);
		}


		function setBuildSelect(data,id) {
		   fillSelect(data,"#decoration_build");
		}
	
		function setUnitSelect(data,id,id) {
				
			
		    $("#notice_unit").empty();
		    $("#notice_room").empty();

			$("#notice_room").append("<option value='" + 0 + "'>" + "---请选择---" + "</option>");
		  
			fillSelect(data,"#notice_unit");
		}

		function setRoomSelect(data,id) {
		     $("#notice_room").empty();
		    fillSelect(data,"#notice_room");
		}








var requestShopOwner ={
    url:URL_ADD_SHOP ,
    callbackMethod : submitInfoResult,
    data:""
  };
 

 
	$(document).ready(function(){

	
	
		

        $("#button_submmit").click(function(){ 
          
            if($("#shop_name").val()=='' ||$("#shop_description").val()=='')
            {
                alert("内容不能为空！");
            }
            else
            {
              if(confirm("是否确认开店？"))
              {
                  submit_NoticeInfo();
              }
            }  
        }); 

    }); 






	// 初始化select



    function submit_NoticeInfo(){

		var name = $("#shop_name").val();

		var description = $("#shop_description").val();
		//var notice_unit = $("#notice_unit").val();
		//var notice_room = $("#notice_room").val();

		//var notice_author = $("#notice_author").val();

		//var notice_content = $("#notice_content").val();
 
		//var formData = new FormData($("#uploadForm")[0]);

		//alert(document.getElementById("uploadForm").value);

		var formData = {"shop.name":name,"shop.description":description}
			//"notice.content":notice_content,"buildNo":notice_build,"unitNo":notice_unit,"roomNo":notice_room}

		//var urlString=requestNoticeMsg.url;

		//var callBackName=requestNoticeMsg.callbackMethod;

		requestShopOwner.data=formData;



		getData(requestShopOwner);
    }

function submitInfoResult(result)
{
  if(result.success == true)
  {
    alert("提交信息成功");
  
  } 
  else
  {
    alert("提交信息失败" + result.type);
  }
  
}





function initBuiltSelect() {

	// 房号select数据
	var buildid = new Array("0","1","2","3","4","5");

	for (var i = 0; i < buildid.length; i++) {
		$("#notice_build").append(
				"<option value='" + buildid[i] + "'>" + buildid[i] + "</option>");
	}

}
    // 初始化select
function initUnitSelect() {

	// 房号select数据
	var unitid = new Array("00","01","02","03");

	for (var i = 0; i < unitid.length; i++) {
		$("#notice_unit").append(
				"<option value='" + unitid[i] + "'>" + unitid[i] + "</option>");
	
	}

}

 // 初始化select
function initRoomSelect() {

	// 房号select数据
	var roomid = new Array("000","301", "302", "303", "304");

	for (var i = 0; i < roomid.length; i++) {
		$("#notice_room").append(
				"<option value='" + roomid[i] + "'>" + roomid[i] + "</option>");
	}

}
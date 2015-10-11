//请求公告对象
  var requestNoticeMsg ={
    url: "../../producttype/add.action",
    callbackMethod : submitInfoResult,
    data:""
 };
  


$(document).ready(function ()
  {

	$("#type_submmit").click(function(){ 
          
            if($("#type_name").val()=='')
            {
                alert("不能为空！");
            }
            else
            {
              submitProductType();
            }  
        }); 
   
  });



function submitProductType()
    {

			var type = $("#type_name").val();

			var postData={"productType.name": type};

			
			requestNoticeMsg.data=postData;
			
			//getDataWithFileUpload(requestNoticeMsg);
			getData(requestNoticeMsg);
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
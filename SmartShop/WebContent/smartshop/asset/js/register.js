var requestRegisterMsg ={
    url: "../user/register.action",
    callbackMethod : submitInfoResult,
    data:""
  };
 


	$(document).ready(function(){

		//initBuiltSelect();
		//initUnitSelect();
		//initRoomSelect(); // 初始化房号select
	
	
		

        $("#register_button").click(function(){ 
          
            if($("#register_username").val()=='' ||$("#register_password").val()==''||$("#register_telephone").val()=='')
            {
                alert("内容不能为空！");
            }
            else
            {
              if(confirm("是否确认注册？"))
              {
                  submit_UserInfo();
              }
            }  
        }); 

    }); 





	// 初始化select



    function submit_UserInfo(){

		var name = $("#register_username").val();

		var pass = $("#register_password").val();
		var tele = $("#register_telephone").val();
		
	
		var formData = {"user.username":name,"user.password":pass,"user.telephone":tele}


		requestRegisterMsg.data=formData;



		getData(requestRegisterMsg);
    }

function submitInfoResult(result)
{
  if(result.success == true)
  {
    alert("注册成功");
  
  } 
  else
  {
    alert("注册失败" + result.type);
  }
  
}






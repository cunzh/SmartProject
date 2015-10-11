var requestApkMsg ={
    url: "../../android/upload.action",
    callbackMethod : submitInfoResult,
    data:""
  };
 

$(document).ready(function(){
	
	//setDate();

        $("#button_submit").click(function(){ 
          
            if($("#apk_name").val()=='' ||$("#apk_discription").val()=='')
            {
                alert("内容不能为空！");
            }
            else
            {
              if(confirm("是否确认上传文件？"))
              {
                  submit_ApkInfo();
              }
            }  
        }); 

    }); 


function setDate()
{
    var myDate = new Date();
    var year = myDate.getFullYear();    //获取完整的年份(4位,1970-)
    var month = myDate.getMonth();       //获取当前月份(0-11,0代表1月)
    var data =  myDate.getDate();        //获取当前日(1-31)
    document.getElementById("apk_date").value = year+"-"+(month+1)+"-"+data;

    //var ownerIntimeDatePicker="#apk_date";  
    //initDatepicker(ownerIntimeDatePicker);
}




    function submit_ApkInfo(){

		var version = $("#apk_version").val();

		var feature = $("#apk_feature").val();
		
 
		//var formData = new FormData($("#uploadForm")[0]);

		//alert(document.getElementById("uploadForm").value);

		var formData = {"version":version,"features":feature}

		//var urlString=requestNoticeMsg.url;

		//var callBackName=requestNoticeMsg.callbackMethod;

		//requestNoticeMsg.data=formData;



		//getData(requestNoticeMsg);
		

		var formData = new FormData($("#uploadForm")[0]);

		//alert(formData['repair.devicename']+"ppppp");

		requestApkMsg.data=formData;

		//getData(requestRrepairMsg);

		getDataWithFileUpload(requestApkMsg);
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


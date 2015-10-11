
var requestChangeUserMsg = 
{
    url:URL_CHANGE_USER,
    callbackMethod:setChangeData,
    data:""
}
var password;
var telephone;
$(document).ready(function () {
    $("#changeUserInfo").click(function(){    
        password = document.getElementById("password").value;
        telephone = document.getElementById("telephone").value;
        if(password==""||telephone=="")
        {
        	alert("用户密码不能为空！");
        	return;
        }
        else
        {
        	getChangeData();
        	setOrderData();
        }
    });
});

function getChangeData() {
    var postData = {
        "user.password": password,
        "user.telephone": telephone
    }
    requestChangeUserMsg.data = postData;
    getData(requestChangeUserMsg);
}
function setChangeData(result) {
    if (result.seccess = true)
        alert("修改个人信息成功！");
    else
        alert("修改个人信息失败！");
}

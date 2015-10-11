//请求楼宇对象
  var requestpropertyValueMsg ={
    url: "../../propertyvalue/add.action",
    callbackMethod : submitInfoResult,
    data:""
  };
  var requestpropertyValueMsg1 ={
    url: "../../propertyvalue/get.action",
    callbackMethod : setpropertyValueData,
    data:""
 };
 var requestproductpropertyMsg1 ={
    url: "../../productproperty/get.action",
    callbackMethod : setproductpropertyData,
    data:""
 };
  
  var onePageSize=10;   //请求服务器每页数据的大小
  var currPage=1;       //当前第几页
  var totalPage;     //总页数
  var finishedTotalPage;     //总页数
  var totalcount;   //总条数
  var visiblepage=10;   //显示的页面按钮数
    
  var isinit=0;  //判断是否是初始化
 
  var tableID="#notice_table";
  var tableBodyID="#notice_tableBody";
  var pageid="#pagination";
  var currentSpanId="#sp"; 
  //已录入商品类别对象
    var propertyValueMsg={
      propertyValue_Product_property_id:"" ,
      propertyValue_name:"" 
    }

function initProductPropertySelect() {

    // select数据
    var Propert = new Array("尺寸", "颜色");

    for (var i = 0; i < Propert.length; i++) {
        $("#propertyValue_Product_property_id").append(
                "<option value='" + Propert[i] + "'>" + Propert[i] + "</option>");
    }

}


$(document).ready(function ()
  {
    initProductPropertySelect();
    getpropertyValueData();
    //tableHandle(notice_table);
    $("#button_add").click(function () {

        if ($("#propertyValue_Product_property_id").val() == ''|| $("#propertyValue_name").val() == '' ) {
            alert("内容不能为空！");
        }
        else {
            if (confirm("是否确认发表通告？")) {
                submitpropertyValueData();
            }
        }
    });
  });


//提交商品属性信息
function submitpropertyValueData() {
  var Product_property_id = $("#propertyValue_Product_property_id").val();
  var name = $("#propertyValue_name").val();
  
  //var formData = new FormData($("#uploadForm")[0]);
  var formData = {"propertyValue.Product_property_id":Product_property_id,"propertyValue.name":name}
  
  requestpropertyValueMsg.data=formData;

  alert(Product_property_id+ " " +name+ " " );

  getData(requestpropertyValueMsg);
  
}


function submitInfoResult(result)
{
  if(result.success == true)
  {
    alert("提交信息成功");
    getpropertyValueData();
  } 
  else
  {
    alert("提交信息失败" + result.type);
  }
  
}

//获取已录入的商品类别信息
    function getpropertyValueData()
    {
      var postData={pageSize:onePageSize,pageNo:currPage};
      requestpropertyValueMsg1.callbackMethod=setpropertyValueData;
      requestpropertyValueMsg1.data=postData;
      requestpropertyValueMsg.url="../../propertyvalue/get.action";
      
      getData(requestpropertyValueMsg1);
    }
  //显示已录入的属性信息
    function setpropertyValueData(data)
    {
      
      var dataArray=new Array(); //数据对象数组
      for(var i=0;i<data.result.length;i++)
      {
        propertyValueMsg=new Object();
        propertyValueMsg.Product_property_id=data.result[i].Product_property_id;
        propertyValueMsg.name =data.result[i].name;
        productTypeMsg.edit="<a href='javascript:void(0)' onclick=' this.parentNode.parentNode.parentNode.removeChild(this.parentNode.parentNode);deleteaddress();'><font color=‘crismon’>删除</font></a><a href='#' onclick='editClick("+data.result[i].id+")'>" + "修改" + "</a>";

        dataArray.push(propertyValueMsg);
      }
      

      var sequenceArray=new Array();//序列数组
      sequenceArray[0]="propertyValue_Product_property_id";
      sequenceArray[1]="propertyValue_name";
      sequenceArray[2]="edit";
      
      totalPage=data.totalPage; 
      $("#notice_tableBody tr").not("tr:first").remove(); //清空除第一行之外的表内容

      addTableBody("notice_table",dataArray,sequenceArray); //调用公用添加table方法
      
      if (!isinit) {
        pageChange(requestpropertyValueMsg1,pageid,currentSpanId,totalPage,totalcount,visiblepage,onePageSize,currPage);
        isinit=1;
      }

    }

    function updateRequestObj(num)
    {
      var postDataString={pageSize:onePageSize,pageNo:num};
      requestpropertyValueMsg1.data=postDataString;
      return requestpropertyValueMsg1;
    }


     
    function updatePostString(num)
    {
      var postDataString="{pageSize:"+onePageSize+",pageNo:"+num+"}";

      return postDataString;
    }

   /* function edit(id,data)
    {

      for(var i=0;i<data.result.length;i++)
      {
        if(data.result[i].id==id)
        {
          document.getElementById("buildnum").value=data.result[i].number;
          document.getElementById("buildtype").value=data.result[i].type;
          document.getElementById("buildname").value=data.result[i].name;
          document.getElementById("location").value=data.result[i].address;
          document.getElementById("manage").value=data.result[i].manager;
          document.getElementById("structure").value=data.result[i].struct;
          document.getElementById("direction").value=data.result[i].orientation;
          document.getElementById("complatetime").value=data.result[i].completiondate;
          document.getElementById("demo").value=data.result[i].remarks;
        }
      }
        
    }*/

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

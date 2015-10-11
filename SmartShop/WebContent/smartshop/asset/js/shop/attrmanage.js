//请求楼宇对象
  var requestproductpropertyMsg ={
    url: "../../productproperty/add.action",
    callbackMethod : submitInfoResult,
    data:""
  };
  var requestproductpropertyMsg1 ={
    url: "../../productproperty/get.action",
    callbackMethod : setproductpropertyData,
    data:""
 };
 var requestproductTypeMsg1 ={
    url: "../../producttype/get.action",
    //callbackMethod : setproductTypeData,
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
    var productpropertyMsg={
      productproperty_productTypeId:"" ,
      productproperty_name:"" 
    }
  function getproductTypeData1()
    {
      var postData={pageSize:onePageSize,pageNo:currPage};
      requestproductTypeMsg1.callbackMethod=setproductTypeData1;
      requestproductTypeMsg1.data=postData;
      requestproductTypeMsg.url="../../producttype/get.action";
      
      getData(requestproductTypeMsg1);
    }
  function setproductTypeData1(data)
    {
      
      for(var i=0;i<data.result.length;i++)
      {
         $("#productproperty_productTypeId").append(
        "<option value='" +data.result[i].name + "'>" +data.result[i].name + "</option>");
    
      }

    }
function initProductTypeSelect() {

    var producttype = new Array("电器", "书籍", "其他");

   // getproductTypeData();
    for (var i = 0; i < producttype.length; i++) {
        $("#productproperty_productTypeId").append(
        "<option value='" +producttype[i] + "'>" +producttype[i] + "</option>");
   }

}


$(document).ready(function ()
  {
    initProductTypeSelect();
    getproductpropertyData();
    //tableHandle(notice_table);
    $("#button_add").click(function () {

        if ($("#productproperty_productTypeId").val() == ''|| $("#productproperty_name").val() == '' ) {
            alert("内容不能为空！");
        }
        else {
            if (confirm("是否确认发表通告？")) {
                submitproductpropertyData();
            }
        }
    });
  });


//提交商品属性信息
function submitproductpropertyData() {
  var productTypeId = $("#productproperty_productTypeId").val();
  name = $("#productproperty_name").val();
  
  //var formData = new FormData($("#uploadForm")[0]);
  var formData = {"productproperty.productTypeId":productTypeId,"productproperty.name":name}

  requestproductpropertyMsg.data=formData;

  alert(productTypeId+ " " +name+ " " );

  getData(requestproductpropertyMsg);
  
}


function submitInfoResult(result)
{
  if(result.success == true)
  {
    alert("提交信息成功");
    getproductpropertyData();
  } 
  else
  {
    alert("提交信息失败" + result.type);
  }
  
}

//获取已录入的商品类别信息
    function getproductpropertyData()
    {
      var postData={pageSize:onePageSize,pageNo:currPage};
      requestproductpropertyMsg1.callbackMethod=setproductpropertyData;
      requestproductpropertyMsg1.data=postData;
      requestproductpropertyMsg.url="../../productproperty/get.action";
      
      getData(requestproductpropertyMsg1);
    }
  //显示已录入的属性信息
    function setproductpropertyData(data)
    {
      
      var dataArray=new Array(); //数据对象数组
      for(var i=0;i<data.result.length;i++)
      {
        productpropertyMsg=new Object();
        productpropertyMsg.productTypeId=data.result[i].productTypeId;
        productpropertyMsg.name =data.result[i].name;
        productTypeMsg.edit="<a href='javascript:void(0)' onclick=' this.parentNode.parentNode.parentNode.removeChild(this.parentNode.parentNode);deleteaddress();'><font color=‘crismon’>删除</font></a><a href='#' onclick='editClick("+data.result[i].id+")'>" + "修改" + "</a>";

        dataArray.push(productpropertyMsg);
      }
      

      var sequenceArray=new Array();//序列数组
      sequenceArray[0]="productproperty_productTypeId";
      sequenceArray[1]="productproperty_name";
      sequenceArray[2]="edit";
      
      totalPage=data.totalPage; 
      $("#notice_tableBody tr").not("tr:first").remove(); //清空除第一行之外的表内容

      addTableBody("notice_table",dataArray,sequenceArray); //调用公用添加table方法
      
      if (!isinit) {
        pageChange(requestproductpropertyMsg1,pageid,currentSpanId,totalPage,totalcount,visiblepage,onePageSize,currPage);
        isinit=1;
      }

    }

    function updateRequestObj(num)
    {
      var postDataString={pageSize:onePageSize,pageNo:num};
      requestproductpropertyMsg1.data=postDataString;
      return requestproductpropertyMsg1;
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

//请求楼宇对象
  var requestproductTypeMsg ={
    url: "../../producttype/add.action",
    callbackMethod : submitInfoResult,
    data:""
  };
  var requestproductTypeMsg1 ={
    url: "../../producttype/get.action",
    callbackMethod : setproductTypeData,
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
    var productTypeMsg={
      productType_name:"" 
    }


$(document).ready(function ()
  {
    getproductTypeData();
    //tableHandle(notice_table);
    $("#button_add").click(function () {

        if ($("#productType_name").val() == '' ) {
            alert("内容不能为空！");
        }
        else {
            if (confirm("是否确认添加？")) {
                submitproductTypeData();
            }
        }
    });
  });


//提交商品类别信息
function submitproductTypeData() {
  var name = $("#productType_name").val();
  
  //var formData = new FormData($("#uploadForm")[0]);
  var formData = {"productType.name":name}
  
  requestproductTypeMsg.data=formData;

  alert(name+ " "  );

  getData(requestproductTypeMsg);
  
}


function submitInfoResult(result)
{
  if(result.success == true)
  {
    alert("提交信息成功");
    getproductTypeData();
  } 
  else
  {
    alert("提交信息失败" + result.type);
  }
  
}

//获取已录入的商品类别信息
    function getproductTypeData()
    {
      var postData={pageSize:onePageSize,pageNo:currPage};
      requestproductTypeMsg1.callbackMethod=setproductTypeData;
      requestproductTypeMsg1.data=postData;
      requestproductTypeMsg.url="../../producttype/get.action";
      
      getData(requestproductTypeMsg1);
    }
  //显示已录入的信息
    function setproductTypeData(data)
    {
      
      var dataArray=new Array(); //数据对象数组
      for(var i=0;i<data.result.length;i++)
      {
        productTypeMsg=new Object();
        productTypeMsg.productType_name =data.result[i].name;
        productTypeMsg.edit="<a href='javascript:void(0)' onclick=' this.parentNode.parentNode.parentNode.removeChild(this.parentNode.parentNode);deleteaddress();'><font color=‘crismon’>删除</font></a><a href='#' onclick='editClick("+data.result[i].id+")'>" + "修改" + "</a>";

        dataArray.push(productTypeMsg);
      }
      

      var sequenceArray=new Array();//序列数组
      sequenceArray[0]="productType_name";
      sequenceArray[1]="edit";
      totalPage=data.totalPage; 
      $("#notice_tableBody tr").not("tr:first").remove(); //清空除第一行之外的表内容

      addTableBody("notice_table",dataArray,sequenceArray); //调用公用添加table方法
      
      if (!isinit) {
        pageChange(requestproductTypeMsg1,pageid,currentSpanId,totalPage,totalcount,visiblepage,onePageSize,currPage);
        isinit=1;
      }

    }

    function updateRequestObj(num)
    {
      var postDataString={pageSize:onePageSize,pageNo:num};
      requestproductTypeMsg1.data=postDataString;
      return requestproductTypeMsg1;
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

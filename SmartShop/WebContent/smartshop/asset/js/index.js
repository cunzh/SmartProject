var requestProductTypeMsg = {
    url: "../producttype/get.action",
    callbackMethod:  addProductType,
    data: ""
};

var requestMsg = {
	    url:"../product/getByShop.action",
	    callbackMethod : addProductList,
	    data:""
	};

$(document).ready(function () {
	 
	addHomePic();///一定要先添加主页滚动物品
	 
	///然后再写主页滚动函数
	$("#slider").responsiveSlides({
      	auto: true,
      	nav: true,
      	speed: 500,
        namespace: "callbacks",
        pager: true
      });


	getProductTypeData();///获取商品类型
	getProductByShopID();
   
}); 

function  addHomePic() 
{
	var picUrl="asset/images/banner3.jpg";
	var dd = "智慧商城";
	$("#slider").append(" <li><img src='" + picUrl + "' class='img-responsive' alt=''/>" +
		        "<div class='banner_desc'>"+
					"<h1>" + dd + "</h1>" +
					"<h2>FashionPress the name of the of hi class fashion Web FreePsd.</h2>"+
				"</div>"+"</li>"
			);
	
	var picUrl="asset/images/banner2.jpg";
	var dd = "智慧商城";
		$("#slider").append(" <li><img src='" + picUrl + "' class='img-responsive' alt=''/>" +
		        "<div class='banner_desc'>"+
					"<h1>" + dd + "</h1>" +
					"<h2>FashionPress the name of the of hi class fashion Web FreePsd.</h2>"+
				"</div></li>");
		
}

function getProductTypeData()
{

	getData(requestProductTypeMsg);

}


function  addProductType(data){
	
    for (var i = 0; i < data.result.length; i++) {
        Msg = new Object();
        Msg.name = data.result[i].typeName;
        Msg.id = data.result[i].id;
        
        var picUrl="asset/images/f_menu.png";
        var type = data.result[i].typeName;
        $("#productType").append("<li class='item1'>"+"<a href='#'>"+"<img class='arrow-img' src='"+picUrl+"' alt=''/>"+ type +
        	"</a>"+
        					"<ul class='cute'>"+
        						"<li class='subitem1'>"+
        	"<a href='#'>"+
        	"生活用品"+" </a></li></ul></li>"
        		);
    }
    
    ////实现商品分类的收缩功能
    var menu_ul = $('.menu > li > ul'),
    menu_a  = $('.menu > li > a');
    menu_ul.hide();
    menu_a.click(function(e) {
	    e.preventDefault();
	    if(!$(this).hasClass('active')) {
		    menu_a.removeClass('active');
		    menu_ul.filter(':visible').slideUp('normal');
		    $(this).addClass('active').next().stop(true,true).slideDown('normal');
	    } 
	    else {
		     $(this).removeClass('active');
		     $(this).next().stop(true,true).slideUp('normal');
	    }
    });

}

function getProductByShopID()
{
	/// 通过ShopID获取商品，此处把ID号写成固定的了，不合适需要更改
	var postData={"id":24};
	requestMsg.data = postData;
	getData(requestMsg);
}

///动态添加商品
function  addProductList(data)
{
	
    for(var i=0;i<data.result.length;i++)
    {
         //productMsg=new Object();

         //productMsg.name = data.result[i].name;
    	 // productMsg.simpleDescription = data.result[i].simpleDescription;
         //productMsg.complexDescription = data.result[i].images.url;
         //productMsg.price = data.result[i].price;
         //productMsg.type = data.result[i].typeId;
    	   
    	 ///把相对地址转换为绝对地址
    	   
    	 //获取当前网址，如： http://localhost:8083/uimcardprj/share/meun.jsp
         var curWwwPath=window.document.location.href;
         //获取主机地址之后的目录，如： uimcardprj/share/meun.jsp
         var pathName=window.document.location.pathname;
         var pos=curWwwPath.indexOf(pathName);
         //获取主机地址，如： http://localhost:8083
         var localhostPaht=curWwwPath.substring(0,pos);
         //获取带"/"的项目名，如：/uimcardprj
         var projectName=pathName.substring(0,pathName.substr(1).indexOf('/')+1);
          
         var picUrl=localhostPaht+projectName+"/"+data.result[i].images[0].url;

         var price = data.result[i].price;
       
         //picUrl="../images/product/-439693412/1921100220690_1000.jpg";
       
     	var productName = data.result[i].name;
     	$("#productList").append(
     		 "<div class='top_grid2'>"+
     	
     		      "<div class='col-md-4 top_grid1-box1'><a href=''>"+
     		     	"<div class='grid_1'>"+
     		     	  "<div class='b-link-stroke b-animate-go  thickbox'>"+
     			        "<img src='"+picUrl+"' class='img-responsive' alt=''/> </div>"+
     		     	 " <div class='grid_2'>"+
     		     	  	"<p>"+productName+"</p>"+
     		     	  	"<ul class='grid_2-bottom'>"+
     		     	  		"<li class='grid_2-left'><p>"+price+"</p></li>"+
     		     	  		"<li class='grid_2-right'><div class='btn btn-primary btn-normal btn-inline ' target='_self' title='Get It'>Get It</div></li>"+
     		     	  		"<div class='clearfix'> </div>"+
     		     	  	"</ul></div></div></a></div><div>"
     			);
       }
       
//	var picUrl="asset/images/p1.jpg";
//	var product = "智慧商城";
//	$("#productList").append(
//		 "<div class='top_grid2'>"+
//	
//		      "<div class='col-md-4 top_grid1-box1'><a href='single.html'>"+
//		     	"<div class='grid_1'>"+
//		     	  "<div class='b-link-stroke b-animate-go  thickbox'>"+
//			        "<img src='"+picUrl+"' class='img-responsive' alt=''/> </div>"+
//		     	 " <div class='grid_2'>"+
//		     	  	"<p>"+product+"</p>"+
//		     	  	"<ul class='grid_2-bottom'>"+
//		     	  		"<li class='grid_2-left'><p>99元</p></li>"+
//		     	  		"<li class='grid_2-right'><div class='btn btn-primary btn-normal btn-inline ' target='_self' title='Get It'>Get It</div></li>"+
//		     	  		"<div class='clearfix'> </div>"+
//		     	  	"</ul></div></div></a></div><div>"
//			);
//			var picUrl="asset/images/p2.jpg";
//	var product = "智慧商城";
//			$("#productList").append(
//		 "<div class='top_grid2'>"+
//	
//		      "<div class='col-md-4 top_grid1-box1'><a href='single.html'>"+
//		     	"<div class='grid_1'>"+
//		     	  "<div class='b-link-stroke b-animate-go  thickbox'>"+
//			        "<img src='"+picUrl+"' class='img-responsive' alt=''/> </div>"+
//		     	 " <div class='grid_2'>"+
//		     	  	"<p>"+product+"</p>"+
//		     	  	"<ul class='grid_2-bottom'>"+
//		     	  		"<li class='grid_2-left'><p>79元</p></li>"+
//		     	  		"<li class='grid_2-right'><div class='btn btn-primary btn-normal btn-inline ' target='_self' title='Get It'>Get It</div></li>"+
//		     	  		"<div class='clearfix'> </div>"+
//		     	  	"</ul></div></div></a></div><div>"
//			);
//	
}
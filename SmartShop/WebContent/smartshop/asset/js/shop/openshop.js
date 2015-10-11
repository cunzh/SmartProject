	var flag=true;
$(document).ready(function () {



        var menu_ul = $('.menu > li > ul'),menu_a  = $('.menu > li > a');
		
        menu_ul.hide();
        
        menu_a.click(function(e) {
			        e.preventDefault();
			        if(!$(this).hasClass('active')) {
			            menu_a.removeClass('active');
			            menu_ul.filter(':visible').slideUp('normal');
			            $(this).addClass('active').next().stop(true,true).slideDown('normal');
			        } else {
			            $(this).removeClass('active');
			            $(this).next().stop(true,true).slideUp('normal');
			        }
			    });


///图片浏览
 $("#slider").responsiveSlides({
      	auto: true,
      	nav: true,
      	speed: 500,
        namespace: "callbacks",
        pager: true,
      });



    //addPruduct();



	var winHeight = parseInt(document.documentElement.clientHeight)-60;// 客户端浏览器高度
	
		document.getElementById("mainframe").height = winHeight + "px";
	     

});




function addPruduct() {

    var ID = "First";

    $("#productList").append(
    "<div class='top_grid2' id='" + ID + "'>" +
     "</div>"
    );


    var url = "single.html";
    var picUrl = "";
    var discript = "动态添加物品描述";
    var price = 33.66;



    $("#" + ID + "").append(
                   "<div class='col-md-4 top_grid1-box1'>" +
                        "<a href=" + url + ">" +
	     	                "<div class='grid_1'>" +
	     		                 "<div class='b-link-stroke b-animate-go  thickbox'>" +
		                            "<img src='" + picUrl + "'class='img-responsive' alt=''/>" +
                                 "</div>" +
	     	                     "<div class='grid_2'>" +
	     	  	                    "<p>" + discript + "</p>" +
	     	  	                     "<ul class='grid_2-bottom'>" +
	     	  		                     "<li class='grid_2-left'><p>" + price + "</p></li>" +
	     	  		                     " <li class='grid_2-right'><div class='btn btn-primary btn-normal btn-inline ' target='_self' title='Get It'>Get It</div></li>" +
	     	  		                     "<div class='clearfix'> </div>" +
	     	  	                    " </ul>" +
	     	                    " </div>" +
	     	                "</div>" +
	                    "</a>" +
                     "</div>"
             );

}

function addSlider(){

var picUrl1="asset/images/banner3.jpg";
var d1="动态添加首页滚动图片.";
var d2="FashionPress the name of the of hi class fashion Web FreePsd.";

$("#slider").append(

	       " <li><img src='"+picUrl1+"' class='img-responsive' alt=''/>"+
	        "<div class='banner_desc'>"+
				"<h1>"+d1+"</h1>"+
				"<h2>"+d2+"</h2>"+
			"</div>"+
	       " </li>"
	 
      )

      var picUrl2="asset/images/banner2.jpg";
var d3="动态添加首页滚动图片.";
var d4="FashionPress the name of the of hi class fashion Web FreePsd.";

$("#slider").append(

	       " <li><img src='"+picUrl2+"' class='img-responsive' alt=''/>"+
	        "<div class='banner_desc'>"+
				"<h1>"+d3+"</h1>"+
				"<h2>"+d4+"</h2>"+
			"</div>"+
	       " </li>"
      )
}



	  /*
		window.onload=function(){ 
			
	        var username=getvalue("username");
	        alert(USERNAME);

		} 
    */



	function menuManage()
        {
        	if(flag==true)
	       	{
	       			//alert(flag);
	       	
				document.getElementById("mainframe").width="97%";
				
					//document.getElementById("hide_menu").id="show_menu";
				flag=false;
	       	}
	       	else
	       	{
	       	
				document.getElementById("mainframe").width="85%";
				
				flag=true;
	       	}
        }


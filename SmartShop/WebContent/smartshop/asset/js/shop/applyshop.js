
	$(document).ready(function(){//这个就是jQuery ready ，它就像C语言的main 所有操作包含在它里面 
		
        $("#applyshop").click(function(){ 
          
              if(confirm("是否确认开店？"))
              {
                  applyshop();
              }
              
        }); 
	}); 

	  

		
		//表单的提交
		function applyshop()
		{
		  window.location.href="shopowner.html";
	


		 }


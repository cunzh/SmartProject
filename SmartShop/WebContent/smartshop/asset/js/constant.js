/**
本文件中所有常量为全局使用
只要在使用的html页面引用本文件，就可以直接调用
*/
	/** 服务器IP */
	var HTTP = "";		//IP地址
	/** 服务器IP */
	var IP = "";		//IP地址
	/** 服务器端口 */
	var PORT = "";				//端口
	/** 程序名 */
	var NAME = "../../";		//目录名
	/** 用户登录 {request{name,password} ,reponse{{success,telephone,room,name,id}}} */
	var LOGIN = HTTP+IP+PORT+NAME+"userManage/login.action";		//登录地址
	/** 用户注销 {} */
	var LOGOUT = HTTP+IP+PORT+NAME+"userManage/logout.action";	//注销地址

	var URL_CHANGE_USER = HTTP + IP + PORT + NAME + "user/update.action";  //修改用户字段
	
	

	///////////////////////////////注册////////////////////////////////////////////////////////////////////////
	/** 注册  {
		request:{
					},
		response:{
					}
		} 
	*/
	var URL_REGISTER_USER = HTTP+IP+PORT+NAME+"user/register.action";//注册

	///////////////////////////////开店////////////////////////////////////////////////////////////////////////
	/** 开店  {
		request:{
					},
		response:{
					}
		} 
	*/
	var URL_ADD_SHOP = HTTP+IP+PORT+NAME+"shop/add.action";//开店

	
	///////////////////////////////查询店铺////////////////////////////////////////////////////////////////////////
	/** 查询店铺  {
		request:{
					},
		response:{
					}
		} 
	*/
	var URL_QUERY_SHOP = HTTP+IP+PORT+NAME+"shop/getByName.action";//查询店铺


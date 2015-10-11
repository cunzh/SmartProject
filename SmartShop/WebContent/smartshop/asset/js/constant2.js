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
	var LOGIN = HTTP+IP+PORT+NAME+"user/login.action";		//登录地址
	/** 用户注销 {} */
	var LOGOUT = HTTP+IP+PORT+NAME+"user/logout.action";	//注销地址

	var URL_CHANGE_USER = HTTP + IP + PORT + NAME + "user/update.action";  //修改用户字段
	var URL_LOGOUT_USER = HTTP + IP + PORT + NAME + "user/logout.action";  //退出登录
	
	
	var URL_ADD_ADDRESS = HTTP + IP + PORT + NAME + "user/addAddress.action";  //添加用户地址字段
	var URL_DEL_ADDRESS = HTTP + IP + PORT + NAME + "user/deleteAddress.action";  //删除用户地址字段
	var URL_QUE_ADDRESS = HTTP + IP + PORT + NAME + "user/getAddress.action";  //查询用户地址字段
	
	
	var URL_QUE_PRODUCT = HTTP + IP + PORT + NAME + "productshow/getByProductId.action";//查询商品信息
	var URL_QUE_PRODUCTPROPERTY = HTTP + IP + PORT + NAME + "productproperty/get.action";//查询商品属性名称
	var URL_QUE_PRODUCTPROPERTYVALUE = HTTP + IP + PORT + NAME + "propertyvalue/get.action";//查询商品属性值
	var URL_QUE_SHOP = HTTP + IP + PORT + NAME + "shop/getByShopId.action"  //查询店铺信息
	var URL_QUE_PRODUCT_COMMENT = HTTP + IP + PORT + NAME + "comment/getByCommentType.action"  //查询评价
	///////////////////////////////用户报修管理////////////////////////////////////////////////////////////////////////
	
	var URL_ADD_SHOP = HTTP+IP+PORT+NAME+"shop/add.action";//开店

	var URL_QUERY_SHOP = HTTP+IP+PORT+NAME+"shop/add.action";//开店


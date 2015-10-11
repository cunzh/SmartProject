package hust.shop.action;

import java.util.Date;

import hust.shop.params.OrderParam;


public class OrderAction extends BaseActionSupport<OrderParam>{

	private hust.shop.service.IOrderService orderService;
	
	public String submit() {
//		java.util.List<hust.shop.pojo.Orders> orders = parameters.getOrders();
//		if (orders == null) {
//			return setJSONObject(com.smartcommunity.util.JSONUtil.getFalseJsonObject("订单为空"));
//		}
//		for (hust.shop.pojo.Orders order : orders) {
//			order.setOrderTime(new Date());
//			order.setOrderNumber(com.smartcommunity.util.RandomUtil.getRandomNumber());
//			order.setUserId((Integer) getHttpSession().getAttribute(com.smartcommunity.util.ConstantPool.SESSION_USER_ID));
//		}
//		com.smartcommunity.util.LogUtil.log("" + order.getOrdersProducts().get(1).getId());
//		com.smartcommunity.util.LogUtil.log("" + order.getOrdersProducts().get(1).getNumber());
//		order.setOrderNumber(com.smartcommunity.util.RandomUtil.getRandomNumber());
//		order.setOrderTime(new Date());
//		order.setUserId((Integer) getHttpSession().getAttribute(com.smartcommunity.util.ConstantPool.SESSION_USER_ID));
		return setJSONObject( orderService.submit((Integer) getHttpSession().getAttribute(com.smartcommunity.util.ConstantPool.SESSION_USER_ID), parameters.getProductIds(), parameters.getProductNumbers(), parameters.getAddress(), parameters.getTelephone(), parameters.getRecipient()) );
				
	}
	public String delete() {

		return setJSONObject(orderService.delete(parameters.getOrderNumber()) );
	}
	public String get() {

		return setJSONObject(orderService.get((Integer) getHttpSession().getAttribute(com.smartcommunity.util.ConstantPool.SESSION_USER_ID)) );
	}
	
	/**
	 * 卖家根据店铺id获得店铺的订单
	 * @return
	 */
	public String getByShop(){
		
		return setJSONObject(orderService.getByShop(parameters.getShopId()));
	}

	public hust.shop.service.IOrderService getOrderService() {
		return orderService;
	}

	public void setOrderService(hust.shop.service.IOrderService orderService) {
		this.orderService = orderService;
	}
}

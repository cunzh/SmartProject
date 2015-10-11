/**
 * 
 */
package hust.shop.service;

import java.io.File;
import java.util.List;

import hust.shop.pojo.Image;
import hust.shop.pojo.Orders;
import hust.shop.pojo.Product;

import com.alibaba.fastjson.JSONObject;

/**
 * 订单管理接口
 * @version 创建时间:2015年4月5日
 * @author yangjunlei
 */
  
public interface IOrderService {

	/** 
	 * 提交订单
	 * @param order
	 * @return
	 */
	public JSONObject submit(List<Orders> orders,List<Integer> propertyValues);

	public JSONObject submit(Orders orders);
	public JSONObject submit(Integer userId,List<Integer> productIds,List<Integer> productNumbers,String address,String telephone,String recipient);
	
	/** 
	 * 删除订单 
	 * @param orderNumber
	 * @return
	 */
	public JSONObject delete(String orderNumber);
	/**
	 * 查看订单
	 * @param userId
	 * @return
	 */
	public JSONObject get(Integer userId);
	
	public JSONObject getByShop(Integer shopId);
	
	public JSONObject getByProductId(Integer productId);
}

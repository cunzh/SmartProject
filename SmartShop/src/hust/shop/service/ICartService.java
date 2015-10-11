/**
 * 
 */
package hust.shop.service;

import hust.shop.pojo.Cart;

import com.alibaba.fastjson.JSONObject;

/**
 * @version 创建时间:2015年4月13日
 * @author Huynh
 */
public interface ICartService {

	public JSONObject add(Cart cart);
	public JSONObject delete(Integer id);
	public JSONObject get(Integer pageNo,Integer pageSize,Integer userId);
	public JSONObject update(Cart cart);
}

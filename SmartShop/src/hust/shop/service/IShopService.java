/**
 * 
 */
package hust.shop.service;

import hust.shop.pojo.Shop;
import hust.shop.pojo.ShopExample;

import com.alibaba.fastjson.JSONObject;

/**
 * @version 创建时间:2015年4月3日
 * @author Huynh
 */
public interface IShopService {

	/**
	 * 查询指定卖家的所有店铺 不分页
	 * @version 创建时间: 2015年4月3日
	 * @author Huynh
	 * @param userId
	 * @return
	 */
	public JSONObject getByUserId(Integer userId);
	
	/**
	 * 模糊查询指定名称店铺 分页
	 * @version 创建时间: 2015年4月3日
	 * @author Huynh
	 * @param pageNo
	 * @param pageSize
	 * @param name
	 * @return
	 */
	public JSONObject getByName(Integer pageNo,Integer pageSize,String name);
	
	/**
	 * 添加店铺 开店 同时将用户变为卖家
	 * @version 创建时间: 2015年4月3日
	 * @author Huynh
	 * @param shop
	 * @return
	 */
	public JSONObject add(Shop shop);
	
	/**
	 * 更新店铺
	 * @version 创建时间: 2015年4月3日
	 * @author Huynh
	 * @param shop
	 * @return
	 */
	public JSONObject update(Shop shop);
	
	/**
	 * 关闭店铺
	 * @version 创建时间: 2015年4月3日
	 * @author Huynh
	 * @param id
	 * @return
	 */
	public JSONObject close(Integer id);

	/**
	 * 通过 id 查询店铺
	 * @author yangjunlei
	 * @param id
	 * @return
	 */
	public JSONObject getByShopId(Integer id);
}

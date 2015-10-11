package hust.shop.service;

import com.alibaba.fastjson.JSONObject;

public interface IProductPropertyValueService {

	/**
	 * 添加商品属性值
	 * @param propertyId
	 * @param name
	 * @return
	 */
	public JSONObject add(Integer propertyId,String name);
	/**
	 * 删除商品属性值
	 * @param id
	 * @return
	 */
	public JSONObject delete(Integer id);
	/**
	 * 更新商品属性值
	 * @param id
	 * @param name
	 * @return
	 */
	public JSONObject update(Integer id, String name);
	/**
	 * 查询商品属性值
	 * @param propertyId
	 * @return
	 */
	public JSONObject get(Integer propertyId);
}

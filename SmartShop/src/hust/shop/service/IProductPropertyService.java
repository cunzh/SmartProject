package hust.shop.service;

import com.alibaba.fastjson.JSONObject;
/**
 * 商品属性与商品值管理
 * @author yangjunlei
 *
 */
public interface IProductPropertyService {
	/**
	 * 添加商品属性
	 * @param typeId
	 * @param name
	 * @return
	 */
	public JSONObject add(Integer typeId,String name);
	/**
	 * 删除商品属性
	 * @param id
	 * @return
	 */
	public JSONObject delete(Integer id);
	/**
	 * 修改商品属性名
	 * @param id
	 * @param name
	 * @return
	 */
	public JSONObject update(Integer id, String name);
	/**
	 * 查找特定类别的商品属性
	 * @param typeId
	 * @return
	 */
	public JSONObject get(Integer typeId);
}

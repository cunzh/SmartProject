/**
 * 
 */
package hust.shop.service;

import hust.shop.pojo.ProductType;
import hust.shop.pojo.Shop;
import hust.shop.pojo.ShopExample;

import com.alibaba.fastjson.JSONObject;

/**
 * @version 创建时间:2015年4月8日
 * @author Huynh
 */
public interface IProductTypeService {

	/**
	 * 查询所有商品类别 分页
	 * @version 创建时间: 2015年4月8日
	 * @author Huynh
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public JSONObject get(Integer pageNo,Integer pageSize);
	
	/**
	 * 添加商品类别
	 * @version 创建时间: 2015年4月8日
	 * @author Huynh
	 * @param productType
	 * @return
	 */
	public JSONObject add(ProductType productType);
	
	/**
	 * 更新商品类别
	 * @version 创建时间: 2015年4月8日
	 * @author Huynh
	 * @param productType
	 * @return
	 */
	public JSONObject update(ProductType productType);
	
	/**
	 * 删除商品类别
	 * @version 创建时间: 2015年4月8日
	 * @author Huynh
	 * @param id
	 * @return
	 */
	public JSONObject delete(Integer id);
}

/**
 * 
 */
package hust.shop.service;

import java.io.File;
import java.util.Date;
import java.util.List;

import hust.shop.pojo.Image;
import hust.shop.pojo.Product;

import com.alibaba.fastjson.JSONObject;

/**
 * 搜索商品接口
 * @version 创建时间:2015年4月6日
 * @author yangjunlei
 */
  
public interface ISearchService {
	/**
	 * 由商品 id 查找指定商品
	 * @param productedId
	 * @return
	 */
	public JSONObject getByProductId(Integer productedId);
	/**
	 * 由商品类型查找商品
	 * @param productedTypeId
	 * @return
	 */
	public JSONObject getByProductType(Integer productTypeId,Integer pageNo, Integer pageSize) ;
	/**
	 * 由商品属性查找商品
	 * @param productPropertyId
	 * @return
	 */
	public JSONObject getByProductProperty(Integer productPropertyId,Integer pageNo, Integer pageSize) ;
	/**
	 * 通过关键字查找
	 * @param keywords
	 * @return
	 */
	public JSONObject getByKeywords(String keywords,Integer pageNo,Integer pageSize) ;
}

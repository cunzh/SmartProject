/**
 * 
 */
package hust.shop.service;

import java.io.File;
import java.util.List;

import hust.shop.pojo.Image;
import hust.shop.pojo.Product;

import com.alibaba.fastjson.JSONObject;

/**
 * 商品管理 接口
 * @version 创建时间:2015年4月2日
 * @author Huynh
 */
  
public interface IProductService {

	/**
	 * 添加商品 需要将图片添加到image表中
	 * @version 创建时间: 2015年4月3日
	 * @author Huynh
	 * @param product
	 * @param images 图片文件
	 * @param imagesFileName 图片名称
	 * @param imagesContentType 类型
	 * @return
	 */
	public JSONObject add(Product product,Integer propertyValueId,List<File> images,List<String> imagesFileName, List<String> imagesContentType);
	
	/**
	 * 删除指定商品 包括该商品的所有图片
	 * 与商品关联的属性值
	 * @version 创建时间: 2015年4月3日
	 * @author Huynh
	 * @param id 商品id
	 * @return
	 */
	public JSONObject delete(Integer id);
	
	
	/**
	 * 批量删除照片
	 * @version 创建时间: 2015年4月4日
	 * @author Huynh
	 * @param ids 要删除的图片的id集合
	 * @param urls 要删除图片的地址
	 * @return
	 */
	public JSONObject deleteImages(List<Integer> ids,List<String> urls);
	/**
	 * 更新商品 不包括图片属性 图片属性只能删除 无法修改
	 * @version 创建时间: 2015年4月3日
	 * @author Huynh
	 * @param product
	 * @return
	 */
	public JSONObject update(Product product);
	
	/**
	 * 查询指定店铺所有商品 分页
	 * @version 创建时间: 2015年4月3日
	 * @author Huynh
	 * @param shopId
	 * @return
	 */
	public JSONObject getByShop(Integer pageNo,Integer pageSize,Integer shopId);
	
	/**
	 * 查询指定店铺 指定类型商品 分页
	 * @version 创建时间: 2015年4月3日
	 * @author Huynh
	 * @param shopId 店铺id
	 * @param typeId 商品类型id
	 * @return
	 */
	public JSONObject getByType(Integer pageNo,Integer pageSize,Integer shopId,Integer typeId);
	
	/**
	 * 查询指定店铺 指定类型 指定属性值商品 分页
	 * @version 创建时间: 2015年4月3日
	 * @author Huynh
	 * @param pageNo 
	 * @param pageSize
	 * @param shopId 店铺id
	 * @param typeId 类型id
	 * @param propertyValueId 属性值id
	 * @return
	 */
	public JSONObject getByProperty(Integer pageNo,Integer pageSize,Integer shopId,Integer typeId,Integer propertyValueId);
	public JSONObject getPropertyValue(Integer productId);
}

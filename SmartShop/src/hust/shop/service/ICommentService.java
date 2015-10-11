/**
 * 
 */
package hust.shop.service;

import hust.shop.pojo.Comment;

import com.alibaba.fastjson.JSONObject;

/**
 * 商品评价模块 接口
 * @version 创建时间:2015年4月8日
 * @author Huynh
 */
public interface ICommentService {

	/**
	 * 添加商品评价
	 * @version 创建时间: 2015年4月8日
	 * @author Huynh
	 * @param comment
	 * @return
	 */
	public JSONObject add(Comment comment);
	
	/**
	 * 获取指定商品的所有评价 按时间排序
	 * @version 创建时间: 2015年4月8日
	 * @author Huynh
	 * @param pageNo
	 * @param pageSize
	 * @param productId
	 * @return
	 */
	public JSONObject getByProductId(Integer pageNo,Integer pageSize,Integer productId);
	
	/**
	 * 获取指定商品指定评价类型的评价 如 好评或者差评
	 * @version 创建时间: 2015年4月8日
	 * @author Huynh
	 * @param pageNo
	 * @param pageSize
	 * @param productId
	 * @param commentTypeId
	 * @return
	 */
	public JSONObject getByCommentType(Integer pageNo,Integer pageSize,Integer productId,Integer commentTypeId);
	/**
	 * 修改评价
	 * @version 创建时间: 2015年4月8日
	 * @author Huynh
	 * @param comment
	 * @return
	 */
	public JSONObject update(Comment comment);
	
	/**
	 * 删除评价
	 * @version 创建时间: 2015年4月8日
	 * @author Huynh
	 * @param id
	 * @return
	 */
	public JSONObject delete(Integer id);
	
	/**
	 * 追加评价
	 * @version 创建时间: 2015年4月8日
	 * @author Huynh
	 * @param commentId
	 * @param appendContent 追加内容
	 * @return
	 */
	public JSONObject append(Integer commentId,String appendContent);
}

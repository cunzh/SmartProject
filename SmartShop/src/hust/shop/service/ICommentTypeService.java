/**
 * 
 */
package hust.shop.service;

import hust.shop.pojo.CommentType;

import com.alibaba.fastjson.JSONObject;

/**
 * 评价类别模块 接口
 * @version 创建时间:2015年4月8日
 * @author Huynh
 */
public interface ICommentTypeService {

	/**
	 * 添加评价类型
	 * @version 创建时间: 2015年4月10日
	 * @author Huynh
	 * @param commentType
	 * @return
	 */
	public JSONObject add(CommentType commentType);
	
	/**
	 * 修改类型
	 * @version 创建时间: 2015年4月10日
	 * @author Huynh
	 * @param id
	 * @param typeName
	 * @return
	 */
	public JSONObject update(CommentType commentType);
	/**
	 * 删除类型
	 * @version 创建时间: 2015年4月10日
	 * @author Huynh
	 * @param id
	 * @return
	 */
	public JSONObject delete(Integer id);
	/**
	 * 查询评价类型
	 * @version 创建时间: 2015年4月10日
	 * @author Huynh
	 * @return
	 */
	public JSONObject get();
}

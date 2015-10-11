/**
 * 
 */
package hust.shop.service;

import hust.shop.pojo.Collect;
import hust.shop.pojo.CommentType;

import com.alibaba.fastjson.JSONObject;

/**
 * 收藏模块 接口
 * @version 创建时间:2015年4月8日
 * @author Huynh
 */
public interface ICollectService {
	/**
	 * 添加收藏
	 * @version 创建时间: 2015年4月8日
	 * @author Huynh
	 * @param collect
	 * @return
	 */
	public JSONObject add(Collect collect);
	
	/**
	 * 删除收藏
	 * @version 创建时间: 2015年4月10日
	 * @author Huynh
	 * @param userId
	 * @param shopId
	 * @return
	 */
	public JSONObject delete(Integer userId,Integer shopId);
	
	/**
	 * 查询收藏 分页
	 * @version 创建时间: 2015年4月8日
	 * @author Huynh
	 * @param pageNo
	 * @param pageSize
	 * @param userId
	 * @return
	 */
	public JSONObject get(Integer pageNo,Integer pageSize,Integer userId);
}

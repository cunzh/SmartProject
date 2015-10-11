/**
 * 
 */
package hust.shop.service.impl;

import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.smartcommunity.util.JSONUtil;

import hust.shop.mapper.CommentTypeMapper;
import hust.shop.pojo.CommentType;
import hust.shop.pojo.CommentTypeExample;
import hust.shop.service.ICommentTypeService;

/**
 * @version 创建时间:2015年4月10日
 * @author Huynh
 */
public class CommentTypeServiceImpl implements ICommentTypeService {

	private CommentTypeMapper commentTypeMapper;
	
	public CommentTypeMapper getCommentTypeMapper() {
		return commentTypeMapper;
	}

	public void setCommentTypeMapper(CommentTypeMapper commentTypeMapper) {
		this.commentTypeMapper = commentTypeMapper;
	}

	@Override
	public JSONObject add(CommentType commentType) {
		if (commentType == null) {
			return null;
		}
		return JSONUtil.setResult(commentTypeMapper.insertSelective(commentType));
	}

	@Override
	public JSONObject update(CommentType commentType) {
		if (commentType == null) {
			return null;
		}
		return JSONUtil.setResult(commentTypeMapper.updateByPrimaryKeySelective(commentType));
	}

	@Override
	public JSONObject delete(Integer id) {
		if (id == null ) {
			return null;
		}
		return JSONUtil.setResult(commentTypeMapper.deleteByPrimaryKey(id));
	}

	@Override
	public JSONObject get() {
		List<CommentType> commentTypes = commentTypeMapper.selectByExample(new CommentTypeExample());
		return JSONUtil.setResult(commentTypes);
	}

}

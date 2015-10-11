/**
 * 
 */
package hust.shop.service.impl;

import java.util.Date;

import com.alibaba.fastjson.JSONObject;
import com.smartcommunity.util.JSONUtil;

import edu.hust.smartcommunity.paginator.domain.PageBounds;
import edu.hust.smartcommunity.paginator.domain.PageList;
import hust.shop.mapper.CommentMapper;
import hust.shop.pojo.Comment;
import hust.shop.pojo.CommentExample;
import hust.shop.service.ICommentService;

/**
 * 商品评价模块 接口实现
 * @version 创建时间:2015年4月8日
 * @author Huynh
 */
public class CommentServiceImpl implements ICommentService {

	private CommentMapper commentMapper;
	
	public CommentMapper getCommentMapper() {
		return commentMapper;
	}

	public void setCommentMapper(CommentMapper commentMapper) {
		this.commentMapper = commentMapper;
	}

	@Override
	public JSONObject add(Comment comment) {
		comment.setTime(new Date());
		return JSONUtil.setResult(commentMapper.insertSelective(comment));
	}

	@Override
	public JSONObject getByProductId(Integer pageNo, Integer pageSize,
			Integer productId) {
		if (pageNo == null) {
			pageNo = 1;
		}
		if (pageSize == null) {
			pageSize = 10;
		}
		PageBounds pageBounds = new PageBounds(pageNo,pageSize);
		CommentExample example = new CommentExample();
		CommentExample.Criteria criteria = example.createCriteria();
		criteria.andProductIdEqualTo(productId);
		PageList<Comment> comments = commentMapper.selectByPage(example, pageBounds);
		if (comments!=null && comments.size()<1) {
			return JSONUtil.getFalseJsonObject("没有满足条件的记录");
		}
		return JSONUtil.setResult(comments);
	}
	
	@Override
	public JSONObject getByCommentType(Integer pageNo, Integer pageSize,
			Integer productId, Integer commentTypeId) {
		if (pageNo == null) {
			pageNo = 1;
		}
		if (pageSize == null) {
			pageSize = 10;
		}
		PageBounds pageBounds = new PageBounds(pageNo,pageSize);
		CommentExample example = new CommentExample();
		CommentExample.Criteria criteria = example.createCriteria();
		criteria.andProductIdEqualTo(productId);
		criteria.andCommentTypeIdEqualTo(commentTypeId);
		PageList<Comment> comments = commentMapper.selectByPage(example, pageBounds);
		if (comments!=null && comments.size()<1) {
			return JSONUtil.getFalseJsonObject("没有满足条件的记录");
		}
		return JSONUtil.setResult(comments);
	}

	@Override
	public JSONObject update(Comment comment) {
		return JSONUtil.setResult(commentMapper.updateByPrimaryKeySelective(comment));
	}

	@Override
	public JSONObject delete(Integer id) {
		return JSONUtil.setResult(commentMapper.deleteByPrimaryKey(id));
	}

	@Override
	public JSONObject append(Integer commentId, String appendContent) {
		Comment comment = new Comment();
		comment.setId(commentId);
		comment.setAppend(appendContent);
		comment.setAppendTime(new Date());
		return JSONUtil.setResult(commentMapper.updateByPrimaryKeySelective(comment));
	}

}

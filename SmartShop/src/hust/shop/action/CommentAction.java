/**
 * 
 */
package hust.shop.action;

import hust.shop.params.CommentParam;
import hust.shop.pojo.Comment;
import hust.shop.service.ICommentService;

import javax.servlet.http.HttpSession;

import com.smartcommunity.util.JSONUtil;

/**
 * @version 创建时间:2015年4月8日
 * @author Huynh
 */
public class CommentAction extends BaseActionSupport<CommentParam>{

	private ICommentService commentService;

	public ICommentService getCommentService() {
		return commentService;
	}

	public void setCommentService(ICommentService commentService) {
		this.commentService = commentService;
	}
	
	public String add(){
		HttpSession session = getHttpSession();
		if (session == null || session.getAttribute("id") == null) {
			return setJSONObject(JSONUtil.getFalseJsonObject("您未登录"));
		}
		Comment comment = parameters.getComment();
		System.out.println("productId-->"+comment.getProductId());
		comment.setUserId((Integer)session.getAttribute("id"));
		return setJSONObject(commentService.add(parameters.getComment()));
	}
	
	public String getByProductId(){
		return setJSONObject(commentService.getByProductId(parameters.getPageNo(), parameters.getPageSize()	, parameters.getId()));
	}
	
	public String getByCommentType(){
		return setJSONObject(commentService.getByCommentType(parameters.getPageNo(), parameters.getPageSize(), parameters.getComment().getProductId(), parameters.getComment().getCommentTypeId()));
	}
	
	public String update(){
		return setJSONObject(commentService.update(parameters.getComment()));
	}
	
	public String delete(){
		return setJSONObject(commentService.delete(parameters.getId()));
	}
	
	public String append(){
		return setJSONObject(commentService.append(parameters.getId(), parameters.getAppendContent()));
	}
}

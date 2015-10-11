/**
 * 
 */
package hust.shop.action;

import hust.shop.pojo.CommentType;
import hust.shop.service.ICommentTypeService;

/**
 * @version 创建时间:2015年4月10日
 * @author Huynh
 */
public class CommentTypeAction extends BaseActionSupport<CommentType>{

	private ICommentTypeService commentTypeService;

	public ICommentTypeService getCommentTypeService() {
		return commentTypeService;
	}

	public void setCommentTypeService(ICommentTypeService commentTypeService) {
		this.commentTypeService = commentTypeService;
	}
	
	public String add(){
		return setJSONObject(commentTypeService.add(parameters));
	}
	
	public String update(){
		return setJSONObject(commentTypeService.update(parameters));
	}
	
	public String delete(){
		return setJSONObject(commentTypeService.delete(parameters.getId()));
	}
	
	public String get(){
		return setJSONObject(commentTypeService.get());
	}
}

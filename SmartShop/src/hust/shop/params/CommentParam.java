/**
 * 
 */
package hust.shop.params;

import hust.shop.pojo.Comment;

/**
 * @version 创建时间:2015年4月8日
 * @author Huynh
 */
public class CommentParam {

	private Integer pageNo;
	private Integer pageSize;
	private Comment comment;
	private Integer id;
	private String appendContent;
	public Integer getPageNo() {		
		return pageNo;
	}
	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public Comment getComment() {
		return comment;
	}
	public void setComment(Comment comment) {
		this.comment = comment;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getAppendContent() {
		return appendContent;
	}
	public void setAppendContent(String appendContent) {
		this.appendContent = appendContent;
	}
	
}

/**
 * 
 */
package hust.shop.params;

import hust.shop.pojo.Cart;

/**
 * @version 创建时间:2015年4月13日
 * @author Huynh
 */
public class CartParam {

	private Cart cart;
	private Integer id;
	private Integer pageNo;
	private Integer pageSize;
	private Integer productId;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
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
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	public Cart getCart() {
		return cart;
	}
	public void setCart(Cart cart) {
		this.cart = cart;
	}
	
	
	
}

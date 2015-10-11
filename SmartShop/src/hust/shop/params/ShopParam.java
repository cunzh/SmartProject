/**
 * 
 */
package hust.shop.params;

import hust.shop.pojo.Shop;

/**
 * @version 创建时间:2015年4月3日
 * @author Huynh
 */
public class ShopParam {

	private Integer id;
	private Shop shop;
	private Integer pageNo;
	private Integer pageSize;
	private String name;//搜索店铺关键字
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Shop getShop() {
		return shop;
	}
	public void setShop(Shop shop) {
		this.shop = shop;
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
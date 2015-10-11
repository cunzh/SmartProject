/**
 * 
 */
package hust.shop.params;

import hust.shop.pojo.Collect;

/**
 * @version 创建时间:2015年4月8日
 * @author Huynh
 */
public class CollectParam {

	private Integer pageNo;
	private Integer pageSize;
	private Collect collect;
	private Integer id;
	private Integer shopId;
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
	public Collect getCollect() {
		return collect;
	}
	public void setCollect(Collect collect) {
		this.collect = collect;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getShopId() {
		return shopId;
	}
	public void setShopId(Integer shopId) {
		this.shopId = shopId;
	}
	
	
}

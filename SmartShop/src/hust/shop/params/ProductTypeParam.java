/**
 * 
 */
package hust.shop.params;

import hust.shop.pojo.ProductType;

/**
 * @version 创建时间:2015年4月8日
 * @author Huynh
 */
public class ProductTypeParam {

	private ProductType productType;
	private Integer id;
	private Integer pageNo;
	private Integer pageSize;
	public ProductType getProductType() {
		return productType;
	}
	public void setProductType(ProductType productType) {
		this.productType = productType;
	}
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
	
}

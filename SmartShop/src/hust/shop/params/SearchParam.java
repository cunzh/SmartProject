package hust.shop.params;


import hust.shop.pojo.User;

public class SearchParam {

	private Integer productId;
	private Integer pageNo;
	private Integer pageSize;
	private Integer productTypeId;
	private Integer productPropertyId;
	private String name;



	public Integer getPageNo() {
		if (pageNo == null) 
			pageNo = 1;
		return pageNo;
	}

	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}

	public Integer getPageSize() {
		if (pageSize == null) 
			pageSize = 10;
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

	public Integer getProductTypeId() {
		return productTypeId;
	}

	public void setProductTypeId(Integer productTypeId) {
		this.productTypeId = productTypeId;
	}

	public Integer getProductPropertyId() {
		return productPropertyId;
	}

	public void setProductPropertyId(Integer productPropertyId) {
		this.productPropertyId = productPropertyId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}

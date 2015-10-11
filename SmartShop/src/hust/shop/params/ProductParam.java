/**
 * 
 */
package hust.shop.params;

import hust.shop.pojo.Product;

import java.io.File;
import java.util.List;


/**
 * 商品参数
 * @version 创建时间:2015年4月3日
 * @author Huynh
 */
public class ProductParam {
	private Integer pageSize;	// 每页大小
	private Integer pageNo;	// 页号
	private Product product;
	private Integer id;
	private Integer shopId;
	private Integer typeId;
	private Integer propertyValueId;
	private String shopName;//商品所在的店铺名
    private List<File> images ;  // 用于上传图片
    private List<String> imagesFileName ;  
    private List<String> imagesContentType ;
    private List<Integer> ids;
    private List<String > urls;
    
	public List<Integer> getIds() {
		return ids;
	}
	public void setIds(List<Integer> ids) {
		this.ids = ids;
	}
	public List<String> getUrls() {
		return urls;
	}
	public void setUrls(List<String> urls) {
		this.urls = urls;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public Integer getPageNo() {
		return pageNo;
	}
	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	
	public String getShopName() {
		return shopName;
	}
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getPropertyValueId() {

		com.smartcommunity.util.LogUtil.log(" yang" + propertyValueId);
		return propertyValueId;
	}
	public void setPropertyValueId(Integer propertyValueId) {
		this.propertyValueId = propertyValueId;
	}
	public List<File> getImages() {
		return images;
	}
	
	public Integer getShopId() {
		return shopId;
	}
	public void setShopId(Integer shopId) {
		this.shopId = shopId;
	}
	public Integer getTypeId() {
		return typeId;
	}
	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}
	public void setImages(List<File> images) {
		this.images = images;
	}
	public List<String> getImagesFileName() {
		return imagesFileName;
	}
	public void setImagesFileName(List<String> imagesFileName) {
		this.imagesFileName = imagesFileName;
	}
	public List<String> getImagesContentType() {
		return imagesContentType;
	}
	public void setImagesContentType(List<String> imagesContentType) {
		this.imagesContentType = imagesContentType;
	}
    
    
}

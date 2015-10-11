package hust.shop.pojo;

import java.util.List;
import java.util.Date;

public class Product {

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column product.id
	 * @mbggenerated  Fri Apr 10 15:07:57 CST 2015
	 */
	private Integer id;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column product.shop_id
	 * @mbggenerated  Fri Apr 10 15:07:57 CST 2015
	 */
	private Integer shopId;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column product.name
	 * @mbggenerated  Fri Apr 10 15:07:57 CST 2015
	 */
	private String name;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column product.type_id
	 * @mbggenerated  Fri Apr 10 15:07:57 CST 2015
	 */
	private Integer typeId;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column product.price
	 * @mbggenerated  Fri Apr 10 15:07:57 CST 2015
	 */
	private Float price;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column product.simple_description
	 * @mbggenerated  Fri Apr 10 15:07:57 CST 2015
	 */
	private String simpleDescription;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column product.complex_description
	 * @mbggenerated  Fri Apr 10 15:07:57 CST 2015
	 */
	private String complexDescription;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column product.datetime
	 * @mbggenerated  Fri Apr 10 15:07:57 CST 2015
	 */
	private Date datetime;
	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column product.id
	 * @return  the value of product.id
	 * @mbggenerated  Fri Apr 10 15:07:57 CST 2015
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column product.id
	 * @param id  the value for product.id
	 * @mbggenerated  Fri Apr 10 15:07:57 CST 2015
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column product.shop_id
	 * @return  the value of product.shop_id
	 * @mbggenerated  Fri Apr 10 15:07:57 CST 2015
	 */
	public Integer getShopId() {
		return shopId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column product.shop_id
	 * @param shopId  the value for product.shop_id
	 * @mbggenerated  Fri Apr 10 15:07:57 CST 2015
	 */
	public void setShopId(Integer shopId) {
		this.shopId = shopId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column product.name
	 * @return  the value of product.name
	 * @mbggenerated  Fri Apr 10 15:07:57 CST 2015
	 */
	public String getName() {
		return name;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column product.name
	 * @param name  the value for product.name
	 * @mbggenerated  Fri Apr 10 15:07:57 CST 2015
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column product.type_id
	 * @return  the value of product.type_id
	 * @mbggenerated  Fri Apr 10 15:07:57 CST 2015
	 */
	public Integer getTypeId() {
		return typeId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column product.type_id
	 * @param typeId  the value for product.type_id
	 * @mbggenerated  Fri Apr 10 15:07:57 CST 2015
	 */
	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column product.price
	 * @return  the value of product.price
	 * @mbggenerated  Fri Apr 10 15:07:57 CST 2015
	 */
	public Float getPrice() {
		return price;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column product.price
	 * @param price  the value for product.price
	 * @mbggenerated  Fri Apr 10 15:07:57 CST 2015
	 */
	public void setPrice(Float price) {
		this.price = price;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column product.simple_description
	 * @return  the value of product.simple_description
	 * @mbggenerated  Fri Apr 10 15:07:57 CST 2015
	 */
	public String getSimpleDescription() {
		return simpleDescription;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column product.simple_description
	 * @param simpleDescription  the value for product.simple_description
	 * @mbggenerated  Fri Apr 10 15:07:57 CST 2015
	 */
	public void setSimpleDescription(String simpleDescription) {
		this.simpleDescription = simpleDescription;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column product.complex_description
	 * @return  the value of product.complex_description
	 * @mbggenerated  Fri Apr 10 15:07:57 CST 2015
	 */
	public String getComplexDescription() {
		return complexDescription;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column product.complex_description
	 * @param complexDescription  the value for product.complex_description
	 * @mbggenerated  Fri Apr 10 15:07:57 CST 2015
	 */
	public void setComplexDescription(String complexDescription) {
		this.complexDescription = complexDescription;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column product.datetime
	 * @return  the value of product.datetime
	 * @mbggenerated  Fri Apr 10 15:07:57 CST 2015
	 */
	public Date getDatetime() {
		return datetime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column product.datetime
	 * @param datetime  the value for product.datetime
	 * @mbggenerated  Fri Apr 10 15:07:57 CST 2015
	 */
	public void setDatetime(Date datetime) {
		this.datetime = datetime;
	}

	private List<Image> images;
	public List<Image> getImages() {
		return images;
	}

	public void setImages(List<Image> images) {
		this.images = images;
	}
	
	private String type;
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
}
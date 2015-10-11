package hust.shop.pojo;

import java.util.Date;

public class Cart {

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column cart.id
	 * @mbggenerated  Fri Apr 17 10:24:05 CST 2015
	 */
	private Integer id;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column cart.user_id
	 * @mbggenerated  Fri Apr 17 10:24:05 CST 2015
	 */
	private Integer userId;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column cart.product_id
	 * @mbggenerated  Fri Apr 17 10:24:05 CST 2015
	 */
	private Integer productId;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column cart.num
	 * @mbggenerated  Fri Apr 17 10:24:05 CST 2015
	 */
	private Integer num;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column cart.product_description
	 * @mbggenerated  Fri Apr 17 10:24:05 CST 2015
	 */
	private String productDescription;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column cart.total_price
	 * @mbggenerated  Fri Apr 17 10:24:05 CST 2015
	 */
	private Float totalPrice;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column cart.datetime
	 * @mbggenerated  Fri Apr 17 10:24:05 CST 2015
	 */
	private Date datetime;

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column cart.id
	 * @return  the value of cart.id
	 * @mbggenerated  Fri Apr 17 10:24:05 CST 2015
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column cart.id
	 * @param id  the value for cart.id
	 * @mbggenerated  Fri Apr 17 10:24:05 CST 2015
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column cart.user_id
	 * @return  the value of cart.user_id
	 * @mbggenerated  Fri Apr 17 10:24:05 CST 2015
	 */
	public Integer getUserId() {
		return userId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column cart.user_id
	 * @param userId  the value for cart.user_id
	 * @mbggenerated  Fri Apr 17 10:24:05 CST 2015
	 */
	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column cart.product_id
	 * @return  the value of cart.product_id
	 * @mbggenerated  Fri Apr 17 10:24:05 CST 2015
	 */
	public Integer getProductId() {
		return productId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column cart.product_id
	 * @param productId  the value for cart.product_id
	 * @mbggenerated  Fri Apr 17 10:24:05 CST 2015
	 */
	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column cart.num
	 * @return  the value of cart.num
	 * @mbggenerated  Fri Apr 17 10:24:05 CST 2015
	 */
	public Integer getNum() {
		return num;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column cart.num
	 * @param num  the value for cart.num
	 * @mbggenerated  Fri Apr 17 10:24:05 CST 2015
	 */
	public void setNum(Integer num) {
		this.num = num;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column cart.product_description
	 * @return  the value of cart.product_description
	 * @mbggenerated  Fri Apr 17 10:24:05 CST 2015
	 */
	public String getProductDescription() {
		return productDescription;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column cart.product_description
	 * @param productDescription  the value for cart.product_description
	 * @mbggenerated  Fri Apr 17 10:24:05 CST 2015
	 */
	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column cart.total_price
	 * @return  the value of cart.total_price
	 * @mbggenerated  Fri Apr 17 10:24:05 CST 2015
	 */
	public Float getTotalPrice() {
		return totalPrice;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column cart.total_price
	 * @param totalPrice  the value for cart.total_price
	 * @mbggenerated  Fri Apr 17 10:24:05 CST 2015
	 */
	public void setTotalPrice(Float totalPrice) {
		this.totalPrice = totalPrice;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column cart.datetime
	 * @return  the value of cart.datetime
	 * @mbggenerated  Fri Apr 17 10:24:05 CST 2015
	 */
	public Date getDatetime() {
		return datetime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column cart.datetime
	 * @param datetime  the value for cart.datetime
	 * @mbggenerated  Fri Apr 17 10:24:05 CST 2015
	 */
	public void setDatetime(Date datetime) {
		this.datetime = datetime;
	}
}
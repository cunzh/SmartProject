package hust.shop.pojo;

import java.util.Date;
import java.util.List;

public class Collect {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column collect.id
     *
     * @mbggenerated Tue Apr 07 19:01:45 CST 2015
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column collect.user_id
     *
     * @mbggenerated Tue Apr 07 19:01:45 CST 2015
     */
    private Integer userId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column collect.shop_id
     *
     * @mbggenerated Tue Apr 07 19:01:45 CST 2015
     */
    private Integer shopId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column collect.datetime
     *
     * @mbggenerated Tue Apr 07 19:01:45 CST 2015
     */
    private Date datetime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column collect.id
     *
     * @return the value of collect.id
     *
     * @mbggenerated Tue Apr 07 19:01:45 CST 2015
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column collect.id
     *
     * @param id the value for collect.id
     *
     * @mbggenerated Tue Apr 07 19:01:45 CST 2015
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column collect.user_id
     *
     * @return the value of collect.user_id
     *
     * @mbggenerated Tue Apr 07 19:01:45 CST 2015
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column collect.user_id
     *
     * @param userId the value for collect.user_id
     *
     * @mbggenerated Tue Apr 07 19:01:45 CST 2015
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column collect.shop_id
     *
     * @return the value of collect.shop_id
     *
     * @mbggenerated Tue Apr 07 19:01:45 CST 2015
     */
    public Integer getShopId() {
        return shopId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column collect.shop_id
     *
     * @param shopId the value for collect.shop_id
     *
     * @mbggenerated Tue Apr 07 19:01:45 CST 2015
     */
    public void setShopId(Integer shopId) {
        this.shopId = shopId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column collect.datetime
     *
     * @return the value of collect.datetime
     *
     * @mbggenerated Tue Apr 07 19:01:45 CST 2015
     */
    public Date getDatetime() {
        return datetime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column collect.datetime
     *
     * @param datetime the value for collect.datetime
     *
     * @mbggenerated Tue Apr 07 19:01:45 CST 2015
     */
    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }
}
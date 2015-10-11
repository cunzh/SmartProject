package hust.shop.mapper;

import hust.shop.pojo.OrdersProduct;
import hust.shop.pojo.OrdersProductExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrdersProductMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table orders_product
     *
     * @mbggenerated Fri Apr 17 15:59:21 CST 2015
     */
    int countByExample(OrdersProductExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table orders_product
     *
     * @mbggenerated Fri Apr 17 15:59:21 CST 2015
     */
    int deleteByExample(OrdersProductExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table orders_product
     *
     * @mbggenerated Fri Apr 17 15:59:21 CST 2015
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table orders_product
     *
     * @mbggenerated Fri Apr 17 15:59:21 CST 2015
     */
    int insert(OrdersProduct record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table orders_product
     *
     * @mbggenerated Fri Apr 17 15:59:21 CST 2015
     */
    int insertSelective(OrdersProduct record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table orders_product
     *
     * @mbggenerated Fri Apr 17 15:59:21 CST 2015
     */
    List<OrdersProduct> selectByExample(OrdersProductExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table orders_product
     *
     * @mbggenerated Fri Apr 17 15:59:21 CST 2015
     */
    OrdersProduct selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table orders_product
     *
     * @mbggenerated Fri Apr 17 15:59:21 CST 2015
     */
    int updateByExampleSelective(@Param("record") OrdersProduct record, @Param("example") OrdersProductExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table orders_product
     *
     * @mbggenerated Fri Apr 17 15:59:21 CST 2015
     */
    int updateByExample(@Param("record") OrdersProduct record, @Param("example") OrdersProductExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table orders_product
     *
     * @mbggenerated Fri Apr 17 15:59:21 CST 2015
     */
    int updateByPrimaryKeySelective(OrdersProduct record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table orders_product
     *
     * @mbggenerated Fri Apr 17 15:59:21 CST 2015
     */
    int updateByPrimaryKey(OrdersProduct record);
}
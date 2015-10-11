package hust.shop.mapper;

import hust.shop.pojo.PropertyValue;
import hust.shop.pojo.PropertyValueExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PropertyValueMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table property_value
	 * @mbggenerated  Tue Apr 07 19:01:45 CST 2015
	 */
	int countByExample(PropertyValueExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table property_value
	 * @mbggenerated  Tue Apr 07 19:01:45 CST 2015
	 */
	int deleteByExample(PropertyValueExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table property_value
	 * @mbggenerated  Tue Apr 07 19:01:45 CST 2015
	 */
	int deleteByPrimaryKey(Integer id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table property_value
	 * @mbggenerated  Tue Apr 07 19:01:45 CST 2015
	 */
	int insert(PropertyValue record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table property_value
	 * @mbggenerated  Tue Apr 07 19:01:45 CST 2015
	 */
	int insertSelective(PropertyValue record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table property_value
	 * @mbggenerated  Tue Apr 07 19:01:45 CST 2015
	 */
	List<PropertyValue> selectByExample(PropertyValueExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table property_value
	 * @mbggenerated  Tue Apr 07 19:01:45 CST 2015
	 */
	PropertyValue selectByPrimaryKey(Integer id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table property_value
	 * @mbggenerated  Tue Apr 07 19:01:45 CST 2015
	 */
	int updateByExampleSelective(@Param("record") PropertyValue record,
			@Param("example") PropertyValueExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table property_value
	 * @mbggenerated  Tue Apr 07 19:01:45 CST 2015
	 */
	int updateByExample(@Param("record") PropertyValue record,
			@Param("example") PropertyValueExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table property_value
	 * @mbggenerated  Tue Apr 07 19:01:45 CST 2015
	 */
	int updateByPrimaryKeySelective(PropertyValue record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table property_value
	 * @mbggenerated  Tue Apr 07 19:01:45 CST 2015
	 */
	int updateByPrimaryKey(PropertyValue record);
	/** add_y */
	List<PropertyValue> getPropertyValue(@Param("example") PropertyValueExample propertyValueExample,edu.hust.smartcommunity.paginator.domain.PageBounds pageBounds);
	List<PropertyValue> getPropertyValue(@Param("example") PropertyValueExample propertyValueExample);
	/** addend_y */
}
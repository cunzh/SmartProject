package hust.shop.mapper;

import hust.shop.pojo.Collect;
import hust.shop.pojo.CollectExample;
import hust.shop.pojo.Shop;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import edu.hust.smartcommunity.paginator.domain.PageBounds;
import edu.hust.smartcommunity.paginator.domain.PageList;

public interface CollectMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table collect
     *
     * @mbggenerated Tue Apr 07 19:01:45 CST 2015
     */
    int countByExample(CollectExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table collect
     *
     * @mbggenerated Tue Apr 07 19:01:45 CST 2015
     */
    int deleteByExample(CollectExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table collect
     *
     * @mbggenerated Tue Apr 07 19:01:45 CST 2015
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table collect
     *
     * @mbggenerated Tue Apr 07 19:01:45 CST 2015
     */
    int insert(Collect record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table collect
     *
     * @mbggenerated Tue Apr 07 19:01:45 CST 2015
     */
    int insertSelective(Collect record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table collect
     *
     * @mbggenerated Tue Apr 07 19:01:45 CST 2015
     */
    List<Collect> selectByExample(CollectExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table collect
     *
     * @mbggenerated Tue Apr 07 19:01:45 CST 2015
     */
    Collect selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table collect
     *
     * @mbggenerated Tue Apr 07 19:01:45 CST 2015
     */
    int updateByExampleSelective(@Param("record") Collect record, @Param("example") CollectExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table collect
     *
     * @mbggenerated Tue Apr 07 19:01:45 CST 2015
     */
    int updateByExample(@Param("record") Collect record, @Param("example") CollectExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table collect
     *
     * @mbggenerated Tue Apr 07 19:01:45 CST 2015
     */
    int updateByPrimaryKeySelective(Collect record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table collect
     *
     * @mbggenerated Tue Apr 07 19:01:45 CST 2015
     */
    int updateByPrimaryKey(Collect record);
    
    PageList<Shop> selectByPage(Integer id,PageBounds pageBounds);
}
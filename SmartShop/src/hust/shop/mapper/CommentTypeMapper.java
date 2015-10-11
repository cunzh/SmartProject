package hust.shop.mapper;

import hust.shop.pojo.CommentType;
import hust.shop.pojo.CommentTypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CommentTypeMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table comment_type
     *
     * @mbggenerated Wed Apr 08 12:26:24 CST 2015
     */
    int countByExample(CommentTypeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table comment_type
     *
     * @mbggenerated Wed Apr 08 12:26:24 CST 2015
     */
    int deleteByExample(CommentTypeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table comment_type
     *
     * @mbggenerated Wed Apr 08 12:26:24 CST 2015
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table comment_type
     *
     * @mbggenerated Wed Apr 08 12:26:24 CST 2015
     */
    int insert(CommentType record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table comment_type
     *
     * @mbggenerated Wed Apr 08 12:26:24 CST 2015
     */
    int insertSelective(CommentType record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table comment_type
     *
     * @mbggenerated Wed Apr 08 12:26:24 CST 2015
     */
    List<CommentType> selectByExample(CommentTypeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table comment_type
     *
     * @mbggenerated Wed Apr 08 12:26:24 CST 2015
     */
    CommentType selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table comment_type
     *
     * @mbggenerated Wed Apr 08 12:26:24 CST 2015
     */
    int updateByExampleSelective(@Param("record") CommentType record, @Param("example") CommentTypeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table comment_type
     *
     * @mbggenerated Wed Apr 08 12:26:24 CST 2015
     */
    int updateByExample(@Param("record") CommentType record, @Param("example") CommentTypeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table comment_type
     *
     * @mbggenerated Wed Apr 08 12:26:24 CST 2015
     */
    int updateByPrimaryKeySelective(CommentType record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table comment_type
     *
     * @mbggenerated Wed Apr 08 12:26:24 CST 2015
     */
    int updateByPrimaryKey(CommentType record);
}
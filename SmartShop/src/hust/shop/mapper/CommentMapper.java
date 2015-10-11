package hust.shop.mapper;

import hust.shop.pojo.Comment;
import hust.shop.pojo.CommentExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import edu.hust.smartcommunity.paginator.domain.PageBounds;
import edu.hust.smartcommunity.paginator.domain.PageList;

public interface CommentMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table comment
	 * @mbggenerated  Wed Apr 08 13:21:24 CST 2015
	 */
	int countByExample(CommentExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table comment
	 * @mbggenerated  Wed Apr 08 13:21:24 CST 2015
	 */
	int deleteByExample(CommentExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table comment
	 * @mbggenerated  Wed Apr 08 13:21:24 CST 2015
	 */
	int deleteByPrimaryKey(Integer id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table comment
	 * @mbggenerated  Wed Apr 08 13:21:24 CST 2015
	 */
	int insert(Comment record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table comment
	 * @mbggenerated  Wed Apr 08 13:21:24 CST 2015
	 */
	int insertSelective(Comment record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table comment
	 * @mbggenerated  Wed Apr 08 13:21:24 CST 2015
	 */
	List<Comment> selectByExample(CommentExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table comment
	 * @mbggenerated  Wed Apr 08 13:21:24 CST 2015
	 */
	Comment selectByPrimaryKey(Integer id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table comment
	 * @mbggenerated  Wed Apr 08 13:21:24 CST 2015
	 */
	int updateByExampleSelective(@Param("record") Comment record,
			@Param("example") CommentExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table comment
	 * @mbggenerated  Wed Apr 08 13:21:24 CST 2015
	 */
	int updateByExample(@Param("record") Comment record,
			@Param("example") CommentExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table comment
	 * @mbggenerated  Wed Apr 08 13:21:24 CST 2015
	 */
	int updateByPrimaryKeySelective(Comment record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table comment
	 * @mbggenerated  Wed Apr 08 13:21:24 CST 2015
	 */
	int updateByPrimaryKey(Comment record);

	PageList<Comment> selectByPage(CommentExample example,PageBounds pageBounds);
	PageList<Comment> selectByExample(CommentExample example,PageBounds pageBounds);
}
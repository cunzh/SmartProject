/**
 * 
 */
package hust.shop.service;

import hust.shop.pojo.Address;
import hust.shop.pojo.Shop;
import hust.shop.pojo.ShopExample;
import hust.shop.pojo.User;

import com.alibaba.fastjson.JSONObject;

/**
 * @version 创建时间:2015年4月3日
 * @author yangjunlei
 */
public interface IUserService {

	/**
	 * 用户注册
	 * @version 创建时间: 2015年4月3日
	 * @author yangjunlei
	 * @param user
	 * @return
	 */
	public JSONObject register(User user);
	
	/**
	 * 用户登陆
	 * @param name 用户名或电话号
	 * @param password
	 * @return
	 */
	public JSONObject login(String name, String password);
	/**
	 * 已经登陆 重新查询用户信息
	 * @param Id
	 * @return
	 */
	public JSONObject logined(Integer id);
	
	/**
	 * 修改用户信息
	 * @version 创建时间: 2015年4月3日
	 * @author yangjunlei
	 * @param user 修改用户名或密码
	 * @return
	 */
	public JSONObject update(User user);
	
	/**
	 * 用户登出
	 * @author yangjunlei
	 * @return
	 */
	public JSONObject logout();
	
	/**
	 * 添加收货地址
	 * @version 创建时间: 2015年4月3日
	 * @author yangjunlei
	 * @param address
	 * @return
	 */
	public JSONObject addAddress(Address address);
	/**
	 * 修改收货地址
	 * @param address
	 * @return
	 */
	public JSONObject updateAddress(Address address);
	/**
	 * 删除收货地址
	 * @param id
	 * @return
	 */
	public JSONObject deleteAddress(Integer userId,Integer id);
	/**
	 * 查询收货地址
	 * @param id 用户 id
	 * @return
	 */
	public JSONObject getAddress(Integer id);
}

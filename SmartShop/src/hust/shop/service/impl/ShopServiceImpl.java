/**
 * 
 */
package hust.shop.service.impl;

import java.util.Date;
import java.util.List;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.smartcommunity.util.JSONUtil;

import edu.hust.smartcommunity.paginator.domain.PageBounds;
import edu.hust.smartcommunity.paginator.domain.PageList;
import hust.shop.mapper.ShopMapper;
import hust.shop.mapper.UserMapper;
import hust.shop.pojo.Shop;
import hust.shop.pojo.ShopExample;
import hust.shop.pojo.User;
import hust.shop.service.IShopService;

/**
 * 店铺模块 实现
 * @version 创建时间:2015年4月3日
 * @author Huynh 
 */
public class ShopServiceImpl implements IShopService {

	private ShopMapper shopMapper;
	private UserMapper userMapper;
	
	public ShopMapper getShopMapper() {
		return shopMapper;
	}

	public void setShopMapper(ShopMapper shopMapper) {
		this.shopMapper = shopMapper;
	}

	public UserMapper getUserMapper() {
		return userMapper;
	}

	public void setUserMapper(UserMapper userMapper) {
		this.userMapper = userMapper;
	}

	@Override
	public JSONObject getByUserId(Integer userId) {
		JSONObject result = null;
		if (userId == null) {
			result = JSONUtil.getJsonObject(false);
			JSONUtil.putCause(result, "要查找店铺的卖家id不能为空");
			return result;
		}
		ShopExample shopExample = new ShopExample();
		shopExample.or().andUserIdEqualTo(userId);
		shopExample.setOrderByClause("level desc");
		List<Shop> shops = shopMapper.selectByExample(shopExample);
		if (shops == null) {
			return null;
		}
		JSONArray jsonArray = (JSONArray) JSON.toJSON(shops);
		result = JSONUtil.getJsonObject(true);
		JSONUtil.putResult(result, jsonArray);
		return result;
	}

	@Override
	public JSONObject getByName(Integer pageNo, Integer pageSize, String name) {
		if (pageNo == null) {
			pageNo = 1;
		}
		if (pageSize == null) {
			pageSize = 10;
		}
		PageBounds pageBounds = new PageBounds(pageNo,pageSize);
		ShopExample shopExample = new ShopExample();
		if (name != null && !"".equals(name)) {
			String [] keyStrings = name.split(" ");
			for (String key : keyStrings) {
				String value = "%" +key + "%";
				System.out.println(value);
				shopExample.or().andDescriptionLike(value);
				shopExample.or().andNameLike(value);
			}
		}
		shopExample.setOrderByClause("level desc");
		PageList<Shop> shops = shopMapper.selectByExample(shopExample, pageBounds);
		if (shops == null) {
			return null;
		}
		JSONArray jsonArray = (JSONArray)JSON.toJSON(shops);
		JSONObject result = JSONUtil.getJsonObject(true);
		result.put("totalpage", shops.getPaginator().getTotalPages());
		JSONUtil.putResult(result, jsonArray);
		return result;
	}

	@Override
	public JSONObject add(Shop shop) {
		if (shop == null) {
			return null;
		}
		shop.setTime(new Date());
		int count = shopMapper.insertSelective(shop);
		if (count >0) {
			int userId = shop.getUserId();
			User user = new User();
			user.setId(userId);
			user.setType(true);
			int userCount = userMapper.updateByPrimaryKeySelective(user);
			if (userCount>0) {
				return JSONUtil.getJsonObject(true);
			}
		}
		return null;
	}

	@Override
	public JSONObject update(Shop shop) {
		int count = shopMapper.updateByPrimaryKeySelective(shop);
		if (count >0) {
			return JSONUtil.getJsonObject(true);
		}
		return null;
	}

	@Override
	public JSONObject close(Integer id) {
		return null;
	}

	@Override
	public JSONObject getByShopId(Integer id) {

		Shop shop = shopMapper.selectByPrimaryKey(id);
		if (shop == null) {
			return JSONUtil.getFalseJsonObject("没有要查询的店铺信息");
		}
		JSONObject jsonObject = (JSONObject) JSON.toJSON(shop);
		jsonObject.put(JSONUtil.successString, true);
		return jsonObject;
	}

}

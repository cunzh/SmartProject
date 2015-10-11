package hust.shop.service.impl;

import hust.shop.pojo.Address;
import hust.shop.pojo.User;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.smartcommunity.util.JSONUtil;

public class UserServiceImpl implements hust.shop.service.IUserService{

	private hust.shop.mapper.UserMapper userMapper;
	private hust.shop.mapper.AddressMapper addressMapper;
	@Override
	public JSONObject register(User user) {
		if (user == null) {
			return com.smartcommunity.util.JSONUtil.getFalseJsonObject("用户信息为空");
		}
		userMapper.insertSelective(user);
		return JSONUtil.getJsonObject(true);
	}

	@Override
	public JSONObject login(String name, String password) {
		if (com.smartcommunity.util.TextUtil.isEmpty(name) ||
				com.smartcommunity.util.TextUtil.isEmpty(password)) {
			return JSONUtil.getFalseJsonObject("用户名或密码不能为空");
		}
		User user = userMapper.login(name, password);
		if (user == null) {
			return JSONUtil.getFalseJsonObject("用户名或密码错误");
		}
		JSONObject jsonObject = (JSONObject) com.alibaba.fastjson.JSON.toJSON(user);
		jsonObject.put(JSONUtil.successString, true);
		return jsonObject;
	}

	@Override
	public JSONObject update(User user) {
		if (user == null) {
			return JSONUtil.getFalseJsonObject("更新信息为空");
		}
		userMapper.updateByPrimaryKeySelective(user);
		return JSONUtil.getJsonObject(true);
	}

	@Override
	public JSONObject logout() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JSONObject addAddress(Address address) {
		if (address == null) {
			return JSONUtil.getFalseJsonObject("没有要更新的内容");
		}

		addressMapper.insertSelective(address);
		return JSONUtil.getJsonObject(true);
		
	}

	@org.springframework.transaction.annotation.Transactional
	@Override
	public JSONObject updateAddress(Address address) {
		if (address == null) {
			return JSONUtil.getFalseJsonObject("没有要更新的信息");
		}

		Address addressByQuery = addressMapper.selectByPrimaryKey(address.getId());
		if (addressByQuery == null) {
			return JSONUtil.getFalseJsonObject("没有要更新的地址");
		}
		if (addressByQuery.getUserId() != address.getUserId()) {

			return JSONUtil.getFalseJsonObject("只能更新自己的地址");
		}
		if (address.getIsdefault() == null) {
			addressMapper.updateByPrimaryKeySelective(address);
			return JSONUtil.getJsonObject(true);
		}

		// 如果要将一个地址设为默认地址， 就把原来 的默认地址取消掉
		if (address.getIsdefault() == true) {
			hust.shop.pojo.AddressExample addressExample = new hust.shop.pojo.AddressExample();
			addressExample.or().andIsdefaultEqualTo(true).andUserIdEqualTo(address.getUserId());
			java.util.List<Address> addresses = addressMapper.selectByExample(addressExample);
			for (Address address2 : addresses) {
				address2.setIsdefault(false);
				addressMapper.updateByPrimaryKeySelective(address2);
			}
		}
		addressMapper.updateByPrimaryKey(address);
		
		return JSONUtil.getJsonObject(true);
	}

	@org.springframework.transaction.annotation.Transactional
	@Override
	public JSONObject deleteAddress(Integer userId, Integer id) {
		Address address = addressMapper.selectByPrimaryKey(id);
		if (address == null) {
			return JSONUtil.getFalseJsonObject("没有要删除的地址");
		}
		if (address.getUserId() != userId) {

			return JSONUtil.getFalseJsonObject("只能删除自己的地址");
		}
		addressMapper.deleteByPrimaryKey(id);
		return JSONUtil.getJsonObject(true);
	}

	@Override
	public JSONObject getAddress(Integer userId) {
		hust.shop.pojo.AddressExample addressExample = new hust.shop.pojo.AddressExample();
		addressExample.or().andUserIdEqualTo(userId);
		java.util.List<Address> addresses = addressMapper.selectByExample(addressExample);
		com.alibaba.fastjson.JSONArray jsonArray = (JSONArray) com.alibaba.fastjson.JSON.toJSON(addresses);
		JSONObject jsonObject = JSONUtil.getJsonObject(true);
		JSONUtil.putResult(jsonObject, jsonArray);
		return jsonObject;
	}

	public hust.shop.mapper.UserMapper getUserMapper() {
		return userMapper;
	}

	public void setUserMapper(hust.shop.mapper.UserMapper userMapper) {
		this.userMapper = userMapper;
	}

	public hust.shop.mapper.AddressMapper getAddressMapper() {
		return addressMapper;
	}

	public void setAddressMapper(hust.shop.mapper.AddressMapper addressMapper) {
		this.addressMapper = addressMapper;
	}

	@Override
	public JSONObject logined(Integer id) {

		User user = userMapper.selectByPrimaryKey(id);
		if (user == null) {
			return JSONUtil.getFalseJsonObject("请重新登陆");
		}
		JSONObject jsonObject = (JSONObject) com.alibaba.fastjson.JSON.toJSON(user);
		jsonObject.put(JSONUtil.successString, true);
		return jsonObject;
	}

}

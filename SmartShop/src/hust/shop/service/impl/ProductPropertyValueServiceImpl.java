/**
 * 
 */
package hust.shop.service.impl;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;





import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.smartcommunity.util.JSONUtil;
import com.smartcommunity.util.PathUtil;

import edu.hust.smartcommunity.paginator.domain.PageBounds;
import edu.hust.smartcommunity.paginator.domain.PageList;
import hust.shop.mapper.ImageMapper;
import hust.shop.mapper.ProductMapper;
import hust.shop.pojo.Image;
import hust.shop.pojo.ImageExample;
import hust.shop.pojo.Product;
import hust.shop.pojo.ProductExample;
import hust.shop.service.IProductService;

/**
 * 商品管理 接口实现
 * 
 * @version 创建时间:2015年4月7日
 * @author yangjunlei
 */
public class ProductPropertyValueServiceImpl implements hust.shop.service.IProductPropertyValueService {

	private hust.shop.mapper.PropertyValueMapper propertyValueMapper;
	@Override
	public JSONObject add(Integer typeId, String name) {

		hust.shop.pojo.PropertyValue propertyValue = new hust.shop.pojo.PropertyValue();
		propertyValue.setProductPropertyId(typeId);
		propertyValue.setName(name);
		propertyValue.setDatetime(new Date());
		propertyValueMapper.insertSelective(propertyValue);
		return JSONUtil.getJsonObject(true);
	}

	@Override
	public JSONObject delete(Integer id) {
		propertyValueMapper.deleteByPrimaryKey(id);
		return JSONUtil.getJsonObject(true);
	}

	@Override
	public JSONObject update(Integer id, String name) {
		hust.shop.pojo.PropertyValue propertyValue = new hust.shop.pojo.PropertyValue();
		propertyValue.setId(id);
		propertyValue.setName(name);
		propertyValue.setDatetime(new Date());
		propertyValueMapper.updateByPrimaryKeySelective(propertyValue);
		return JSONUtil.getJsonObject(true);
	}

	@Override
	public JSONObject get(Integer typeId) {
		hust.shop.pojo.PropertyValueExample propertyValueExample = new hust.shop.pojo.PropertyValueExample();
		propertyValueExample.or().andProductPropertyIdEqualTo(typeId);
		List<hust.shop.pojo.PropertyValue> propertyValues = propertyValueMapper.selectByExample(propertyValueExample);
		JSONArray jsonArray = (JSONArray) JSON.toJSON(propertyValues);
		JSONObject jsonObject = JSONUtil.getJsonObject(true);
		JSONUtil.putResult(jsonObject, jsonArray);
		return jsonObject;
	}

	public hust.shop.mapper.PropertyValueMapper getPropertyValueMapper() {
		return propertyValueMapper;
	}

	public void setPropertyValueMapper(hust.shop.mapper.PropertyValueMapper propertyValueMapper) {
		this.propertyValueMapper = propertyValueMapper;
	}

}

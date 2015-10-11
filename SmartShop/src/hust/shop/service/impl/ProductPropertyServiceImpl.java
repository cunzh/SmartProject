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
import hust.shop.pojo.ProductPropertyExample;
import hust.shop.service.IProductService;

/**
 * 商品属性管理 接口实现
 * 
 * @version 创建时间:2015年4月7日
 * @author yangjunlei
 */
public class ProductPropertyServiceImpl implements hust.shop.service.IProductPropertyService {
	private hust.shop.mapper.ProductPropertyMapper productPropertyMapper;
	private hust.shop.mapper.PropertyValueMapper propertyValueMapper;
	@Override
	public JSONObject add(Integer typeId, String name) {

		hust.shop.pojo.ProductProperty productProperty = new hust.shop.pojo.ProductProperty();
		productProperty.setProductTypeId(typeId);
		productProperty.setName(name);
		productProperty.setDatetime(new Date());
		productPropertyMapper.insertSelective(productProperty);
		return JSONUtil.getJsonObject(true);
	}

	@org.springframework.transaction.annotation.Transactional
	@Override
	public JSONObject delete(Integer id) {
		// 删除与商品属性关联的值
		hust.shop.pojo.PropertyValueExample propertyValueExample = new hust.shop.pojo.PropertyValueExample();
		propertyValueExample.or().andProductPropertyIdEqualTo(id);
		List<hust.shop.pojo.PropertyValue> propertyValues = propertyValueMapper.selectByExample(propertyValueExample);
		for (hust.shop.pojo.PropertyValue propertyValue : propertyValues ) {
			propertyValueMapper.deleteByPrimaryKey(propertyValue.getId());
		}
		//  删除商品属性
		productPropertyMapper.deleteByPrimaryKey(id);
		
		return JSONUtil.getJsonObject(true);
	}

	@Override
	public JSONObject update(Integer id, String name) {
		hust.shop.pojo.ProductProperty productProperty = new hust.shop.pojo.ProductProperty();
		productProperty.setId(id);
		productProperty.setName(name);
		productPropertyMapper.updateByPrimaryKeySelective(productProperty);
		return JSONUtil.getJsonObject(true);
	}

	@Override
	public JSONObject get(Integer typeId) {
		ProductPropertyExample productPropertyExample = new ProductPropertyExample();
		productPropertyExample.or().andProductTypeIdEqualTo(typeId);
		List<hust.shop.pojo.ProductProperty> productProperties = productPropertyMapper.selectByExample(productPropertyExample);
		JSONArray jsonArray = (JSONArray) JSON.toJSON(productProperties);
		JSONObject jsonObject = JSONUtil.getJsonObject(true);
		JSONUtil.putResult(jsonObject, jsonArray);
		return jsonObject;
	}

	public hust.shop.mapper.ProductPropertyMapper getProductPropertyMapper() {
		return productPropertyMapper;
	}

	public void setProductPropertyMapper(hust.shop.mapper.ProductPropertyMapper productPropertyMapper) {
		this.productPropertyMapper = productPropertyMapper;
	}

	public hust.shop.mapper.PropertyValueMapper getPropertyValueMapper() {
		return propertyValueMapper;
	}

	public void setPropertyValueMapper(
			hust.shop.mapper.PropertyValueMapper propertyValueMapper) {
		this.propertyValueMapper = propertyValueMapper;
	}

}

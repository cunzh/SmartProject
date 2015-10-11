/**
 * 
 */
package hust.shop.service.impl;

import hust.shop.mapper.ProductMapper;
import hust.shop.pojo.Product;
import hust.shop.pojo.ProductExample;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.smartcommunity.util.JSONUtil;

import edu.hust.smartcommunity.paginator.domain.PageBounds;


/**
 * 商品管理 接口实现
 * 
 * @version 创建时间:2015年4月6日
 * @author yangjunlei
 */
public class SearchServiceImpl implements hust.shop.service.ISearchService {

	private ProductMapper productMapper;
	private hust.shop.mapper.PropertyValueMapper propertyValueMapper;
	private hust.shop.mapper.ProductPropertyValueMapper productPropertyValueMapper;
	@Override
	public JSONObject getByProductId(Integer productedId) {
		if (productedId == null) {
			return com.smartcommunity.util.JSONUtil.getFalseJsonObject("产品 ID 为空");
		}
		Product product = productMapper.selectProductWithImageById(productedId);
		if (product == null) {
			return com.smartcommunity.util.JSONUtil.getFalseJsonObject("要查找的商品不存在");
		}
		JSONObject jsonObject = (JSONObject) com.alibaba.fastjson.JSON.toJSON(product);
		jsonObject.put(com.smartcommunity.util.JSONUtil.successString, true);
		return jsonObject;
	}

	@Override
	public JSONObject getByProductType(Integer productTypeId,Integer pageNo, Integer pageSize) {
		if (productTypeId == null) {
			return com.smartcommunity.util.JSONUtil.getFalseJsonObject("产品类型 ID 为空");
		}
		com.smartcommunity.util.LogUtil.log(""+ productTypeId);
		ProductExample productExample = new hust.shop.pojo.ProductExample();
		productExample.or().andTypeIdEqualTo(productTypeId);
		PageBounds pageBounds = new PageBounds(pageNo,pageSize);
		List<hust.shop.pojo.Product> products = productMapper.selectProductWithImage(productExample, pageBounds);

		JSONArray jsonArray = (JSONArray) com.alibaba.fastjson.JSON.toJSON(products);
		JSONObject jsonObject = JSONUtil.getJsonObject(true);
		JSONUtil.putResult(jsonObject, jsonArray);
		return jsonObject;
	}

	@org.springframework.transaction.annotation.Transactional
	@Override
	public JSONObject getByProductProperty(Integer productPropertyId,Integer pageNo, Integer pageSize) {
		if (productPropertyId == null) {
			return com.smartcommunity.util.JSONUtil.getFalseJsonObject("产品属性 ID 为空");
		}
		hust.shop.pojo.PropertyValueExample propertyValueExample = new hust.shop.pojo.PropertyValueExample();
		propertyValueExample.or().andProductPropertyIdEqualTo(productPropertyId);
		List<hust.shop.pojo.PropertyValue> propertyValues = propertyValueMapper.selectByExample(propertyValueExample);
		List<Integer> list = new java.util.ArrayList<>();
		for (hust.shop.pojo.PropertyValue propertyValue : propertyValues) {
			list.add(propertyValue.getId());
		}
		hust.shop.pojo.ProductPropertyValueExample productPropertyValueExample = new hust.shop.pojo.ProductPropertyValueExample();
		productPropertyValueExample.or().andPropertyValueIdIn(list);
		List<hust.shop.pojo.ProductPropertyValue> productPropertyValues = productPropertyValueMapper.selectByExample(productPropertyValueExample);
		for (hust.shop.pojo.ProductPropertyValue productPropertyValue : productPropertyValues) {
			list.add(productPropertyValue.getProductId());
		}
		
		ProductExample productExample = new hust.shop.pojo.ProductExample();
		productExample.or().andProductIdIn(list);
		PageBounds pageBounds = new PageBounds(pageNo,pageSize);
		List<hust.shop.pojo.Product> products = productMapper.selectProductWithImage(productExample, pageBounds);

		JSONArray jsonArray = (JSONArray) com.alibaba.fastjson.JSON.toJSON(products);
		JSONObject jsonObject = JSONUtil.getJsonObject(true);
		JSONUtil.putResult(jsonObject, jsonArray);
		return jsonObject;
	}

	@Override
	public JSONObject getByKeywords(String keywords,Integer pageNo, Integer pageSize) {

//		if (com.smartcommunity.util.TextUtil.isEmpty(keywords)) {
//			return com.smartcommunity.util.JSONUtil.getFalseJsonObject("请输入关键字");
//		}
		 
		ProductExample productExample = new hust.shop.pojo.ProductExample();
		if (!com.smartcommunity.util.TextUtil.isEmpty(keywords) ) {
			
		productExample.or().andNameLike("%" + keywords + "%");

		}
		PageBounds pageBounds = new PageBounds(pageNo,pageSize);
		List<hust.shop.pojo.Product> products = productMapper.selectProductWithImage(productExample, pageBounds);

		JSONArray jsonArray = (JSONArray) com.alibaba.fastjson.JSON.toJSON(products);
		JSONObject jsonObject = JSONUtil.getJsonObject(true);
		JSONUtil.putResult(jsonObject, jsonArray);
		return jsonObject;
	}

	public ProductMapper getProductMapper() {
		return productMapper;
	}

	public void setProductMapper(ProductMapper productMapper) {
		this.productMapper = productMapper;
	}

	public hust.shop.mapper.PropertyValueMapper getPropertyValueMapper() {
		return propertyValueMapper;
	}

	public void setPropertyValueMapper(hust.shop.mapper.PropertyValueMapper propertyValueMapper) {
		this.propertyValueMapper = propertyValueMapper;
	}

	public hust.shop.mapper.ProductPropertyValueMapper getProductPropertyValueMapper() {
		return productPropertyValueMapper;
	}

	public void setProductPropertyValueMapper(hust.shop.mapper.ProductPropertyValueMapper productPropertyValueMapper) {
		this.productPropertyValueMapper = productPropertyValueMapper;
	}


}

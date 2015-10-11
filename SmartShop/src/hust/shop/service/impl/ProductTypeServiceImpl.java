/**
 * 
 */
package hust.shop.service.impl;

import java.util.Date;
import com.alibaba.fastjson.JSONObject;
import com.smartcommunity.util.JSONUtil;

import edu.hust.smartcommunity.paginator.domain.PageBounds;
import edu.hust.smartcommunity.paginator.domain.PageList;
import hust.shop.mapper.ProductTypeMapper;
import hust.shop.pojo.ProductType;
import hust.shop.pojo.ProductTypeExample;
import hust.shop.service.IProductTypeService;

/**
 * @version 创建时间:2015年4月8日
 * @author Huynh
 */
public class ProductTypeServiceImpl implements IProductTypeService{

	private ProductTypeMapper productTypeMapper;
	
	public ProductTypeMapper getProductTypeMapper() {
		return productTypeMapper;
	}

	public void setProductTypeMapper(ProductTypeMapper productTypeMapper) {
		this.productTypeMapper = productTypeMapper;
	}

	@Override
	public JSONObject get(Integer pageNo, Integer pageSize) {
		if (pageNo == null) {
			pageNo = 1;
		}
		if (pageSize == null) {
			pageSize = 10;
		}
		PageBounds pageBounds = new PageBounds(pageNo,pageSize);
		PageList<ProductType> productTypes = productTypeMapper.selectByExample(new ProductTypeExample(), pageBounds);
		return JSONUtil.setResult(productTypes);
	}

	@Override
	public JSONObject add(ProductType productType) {
		productType.setDatetime(new Date());
		return JSONUtil.setResult(productTypeMapper.insertSelective(productType));
	}

	@Override
	public JSONObject update(ProductType productType) {
		return JSONUtil.setResult(productTypeMapper.updateByPrimaryKeySelective(productType));
	}

	@Override
	public JSONObject delete(Integer id) {
		
		return JSONUtil.setResult(productTypeMapper.deleteByPrimaryKey(id));
	}

}

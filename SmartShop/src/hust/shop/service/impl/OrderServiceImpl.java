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
import hust.shop.pojo.Orders;
import hust.shop.pojo.OrdersExample;
import hust.shop.pojo.OrdersProduct;
import hust.shop.pojo.Product;
import hust.shop.pojo.ProductExample;
import hust.shop.service.IProductService;

/**
 * 商品管理 接口实现
 * 
 * @version 创建时间:2015年4月2日
 * @author Huynh
 */
public class OrderServiceImpl implements hust.shop.service.IOrderService {

	private hust.shop.mapper.OrdersMapper ordersMapper;
	private ProductMapper productMapper;
	private hust.shop.mapper.OrdersPropertyValueMapper ordersPropertyValueMapper;
	private hust.shop.mapper.PropertyValueMapper propertyValueMapper;
	private hust.shop.mapper.ProductPropertyMapper productPropertyMapper;
	private hust.shop.mapper.OrdersProductMapper ordersProductMapper;

	// @Override
	// public JSONObject submit(Orders order,List<Integer> propertyValueIds) {
	// if (order == null) {
	// return JSONUtil.getFalseJsonObject("订单为空");
	// }
	// Product product = productMapper.selectByPrimaryKey(order.getProductId());
	// if (product == null) {
	//
	// return JSONUtil.getFalseJsonObject("下单的商品不存在");
	// }
	// order.setPrice(product.getPrice());
	// order.setShopId(product.getShopId());
	// order.setOrderTime(new Date());
	// order.setProductName(product.getName());
	// int count = ordersMapper.insertSelective(order);
	// if (count > 0 ) {
	// if (propertyValueIds != null && propertyValueIds.size() > 0) {
	// hust.shop.pojo.PropertyValueExample propertyValueExample = new
	// hust.shop.pojo.PropertyValueExample();
	// propertyValueExample.or().andadotIdIn(propertyValueIds);
	// List<hust.shop.pojo.PropertyValue> propertyValues =
	// propertyValueMapper.getPropertyValue(propertyValueExample);
	//
	// hust.shop.pojo.OrdersPropertyValue ordersPropertyValue = new
	// hust.shop.pojo.OrdersPropertyValue();
	// for (hust.shop.pojo.PropertyValue propertyValue : propertyValues) {
	//
	// ordersPropertyValue.setOrderNumber(order.getOrderNumber());
	// ordersPropertyValue.setPropertyValue(propertyValue.getName());
	// ordersPropertyValue.setProperty(propertyValue.getProductProperty().getName());
	// ordersPropertyValueMapper.insertSelective(ordersPropertyValue);
	// }
	// }
	// return JSONUtil.getJsonObject(true);
	// }
	// return JSONUtil.getFalseJsonObject("插入记录失败");
	// }

	@org.springframework.transaction.annotation.Transactional
	@Override
	public JSONObject submit(List<Orders> orders, List<Integer> propertyValues) {

		if (orders == null) {
			return JSONUtil.getFalseJsonObject("订单为空");
		}
		for (Orders order : orders) {
			// 插入订单
			ordersMapper.insertSelective(order);

			List<hust.shop.pojo.OrdersProduct> ordersProducts = order
					.getOrdersProducts();
			// 插入订单中的商品
			for (hust.shop.pojo.OrdersProduct ordersProduct : ordersProducts) {
				ordersProductMapper.insertSelective(ordersProduct);
			}
		}
		return JSONUtil.getJsonObject(true);
	}

	@Override
	public JSONObject delete(String orderNumber) {
		if (orderNumber == null) {
			return JSONUtil.getFalseJsonObject("要删除的订单号为空");
		}
		// ordersMapper.deleteByOrderNumber(orderNumber);//未判断是否删除成功
		return JSONUtil
				.setResult(ordersMapper.deleteByOrderNumber(orderNumber));
	}

	@Override
	public JSONObject get(Integer userId) {
		if (userId == null) {
			return JSONUtil.getFalseJsonObject("用户不存在");
		}
		hust.shop.pojo.OrdersExample ordersExample = new hust.shop.pojo.OrdersExample();
		ordersExample.or().andUserIdEqualTo(userId);
		List<Orders> orders = ordersMapper.getOrders(ordersExample);
		JSONArray jsonArray = (JSONArray) JSON.toJSON(orders);
		JSONObject jsonObject = JSONUtil.getJsonObject(true);
		JSONUtil.putResult(jsonObject, jsonArray);
		return jsonObject;
	}
	
	@Override
	public JSONObject getByShop(Integer shopId) {
		// TODO Auto-generated method stub
		if(shopId == null){
			return JSONUtil.getFalseJsonObject("店铺id不能为空！");
		}
		OrdersExample ordersExample=new OrdersExample();
		ordersExample.or().andShopIdEqualTo(shopId);
		
		List<Orders> orders = ordersMapper.getOrders(ordersExample);
		JSONArray jsonArray = (JSONArray) JSON.toJSON(orders);
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

	public hust.shop.mapper.OrdersMapper getOrdersMapper() {
		return ordersMapper;
	}

	public void setOrdersMapper(hust.shop.mapper.OrdersMapper ordersMapper) {
		this.ordersMapper = ordersMapper;
	}

	public hust.shop.mapper.PropertyValueMapper getPropertyValueMapper() {
		return propertyValueMapper;
	}

	public void setPropertyValueMapper(
			hust.shop.mapper.PropertyValueMapper propertyValueMapper) {
		this.propertyValueMapper = propertyValueMapper;
	}

	public hust.shop.mapper.ProductPropertyMapper getProductPropertyMapper() {
		return productPropertyMapper;
	}

	public void setProductPropertyMapper(
			hust.shop.mapper.ProductPropertyMapper productPropertyMapper) {
		this.productPropertyMapper = productPropertyMapper;
	}

	public hust.shop.mapper.OrdersPropertyValueMapper getOrdersPropertyValueMapper() {
		return ordersPropertyValueMapper;
	}

	public void setOrdersPropertyValueMapper(
			hust.shop.mapper.OrdersPropertyValueMapper ordersPropertyValueMapper) {
		this.ordersPropertyValueMapper = ordersPropertyValueMapper;
	}

	public hust.shop.mapper.OrdersProductMapper getOrdersProductMapper() {
		return ordersProductMapper;
	}

	public void setOrdersProductMapper(
			hust.shop.mapper.OrdersProductMapper ordersProductMapper) {
		this.ordersProductMapper = ordersProductMapper;
	}

	@Override
	public JSONObject submit(Integer userId, List<Integer> productIds,
			List<Integer> productNumbers, String address, String telephone,
			String recipient) {

		if (userId == null) {
			return JSONUtil.getFalseJsonObject("请先登陆");
		}
		ProductExample productExample = new ProductExample();
		productExample.or().andIdIn(productIds);
		List<Product> products = productMapper.selectByExample(productExample);
		java.util.Map<Integer, List<Product>> productBySameShopId = new java.util.HashMap<Integer, List<Product>>();
		/** 将产品根据 shopId 分类 */
		for (Product product : products) {
			Integer shopId = product.getShopId();
			if (!productBySameShopId.containsKey(shopId)) {
				productBySameShopId.put(shopId,
						new java.util.ArrayList<Product>());
			}
			productBySameShopId.get(shopId).add(product);
		}
		List<Orders> ordersList = new java.util.ArrayList<Orders>();
		products.clear();
		for (Integer shopId : productBySameShopId.keySet()) {
			products = productBySameShopId.get(shopId);
			Orders orders = new Orders();
			orders.setAddress(address);
			orders.setOrderNumber(com.smartcommunity.util.RandomUtil
					.getRandomNumber());
			orders.setUserId(userId);
			orders.setOrderTime(new Date());
			orders.setRecipient(recipient);
			orders.setShopId(shopId);
			orders.setTelephone(telephone);
			List<OrdersProduct> ordersProducts = new java.util.ArrayList<OrdersProduct>();
			float totalPrice = 0;
			for (Product product : products) {
				OrdersProduct ordersProduct = new OrdersProduct();
				ordersProduct.setOrderNumber(orders.getOrderNumber());
				ordersProduct.setPrice(product.getPrice());
				ordersProduct.setProductId(product.getId());
				ordersProduct.setProductName(product.getName());
				int index = productIds.indexOf(product.getId());
				ordersProduct.setNumber(productNumbers.get(index));
				totalPrice += ordersProduct.getPrice()
						* ordersProduct.getNumber();
				ordersProducts.add(ordersProduct);
			}
			orders.setTotalPrice(totalPrice);
			orders.setOrdersProducts(ordersProducts);
			ordersList.add(orders);
		}
		submit(ordersList, null);
		JSONArray jsonArray = new JSONArray();
		for (Orders orders : ordersList) {
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("ordernumber", orders.getOrderNumber());
			jsonObject.put("shopid", orders.getShopId());
			jsonArray.add(jsonObject);
		}
		JSONObject jsonObject = JSONUtil.getJsonObject(true);
		JSONUtil.putResult(jsonObject, jsonArray);
		return jsonObject;
	}

	@org.springframework.transaction.annotation.Transactional
	@Override
	public JSONObject submit(Orders orders) {

		if (orders == null) {
			return JSONUtil.getFalseJsonObject("订单为空");
		}
		ordersMapper.insertSelective(orders);

		for (hust.shop.pojo.OrdersProduct ordersProduct : orders
				.getOrdersProducts()) {

			ordersProductMapper.insertSelective(ordersProduct);

		}
		return JSONUtil.getJsonObject(true);
	}

	@Override
	public JSONObject getByProductId(Integer productId) {
		if (productId == null) {
			return JSONUtil.getFalseJsonObject("产品 Id 不能为空");
		}
		hust.shop.pojo.OrdersProductExample ordersProductExample = new hust.shop.pojo.OrdersProductExample();
		ordersProductExample.or().andProductIdEqualTo(productId);
		List<OrdersProduct> ordersProducts = ordersProductMapper.selectByExample(ordersProductExample);
		JSONArray jsonArray = (JSONArray) JSON.toJSON(ordersProducts);
		JSONObject jsonObject = JSONUtil.getJsonObject(true);
		JSONUtil.putResult(jsonObject, jsonArray);
		return jsonObject;
	}

	

}

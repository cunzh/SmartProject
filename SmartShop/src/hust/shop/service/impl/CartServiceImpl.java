/**
 * 
 */
package hust.shop.service.impl;

import java.util.Date;
import java.util.List;

import javax.print.attribute.standard.PagesPerMinute;

import com.alibaba.fastjson.JSONObject;
import com.smartcommunity.util.JSONUtil;

import edu.hust.smartcommunity.paginator.domain.PageBounds;
import edu.hust.smartcommunity.paginator.domain.PageList;
import hust.shop.mapper.CartMapper;
import hust.shop.pojo.Cart;
import hust.shop.pojo.CartExample;
import hust.shop.pojo.CartInfo;
import hust.shop.pojo.Product;
import hust.shop.service.ICartService;

/**
 * @version 创建时间:2015年4月13日
 * @author Huynh
 */
public class CartServiceImpl implements ICartService {

	private CartMapper cartMapper;

	public CartMapper getCartMapper() {
		return cartMapper;
	}

	public void setCartMapper(CartMapper cartMapper) {
		this.cartMapper = cartMapper;
	}

	@Override
	public JSONObject add(Cart cart) {
		if (cart == null) {
			return null;
		}
		// 首先看是否已经存在，如果存在，就更新数量
		CartExample example = new CartExample();
		CartExample.Criteria criteria = example.createCriteria();
		criteria.andUserIdEqualTo(cart.getUserId());
		criteria.andProductIdEqualTo(cart.getProductId());
		criteria.andProductDescriptionEqualTo(cart.getProductDescription());
		int num = cart.getNum();
		List<Cart> carts = cartMapper.selectByExample(example);
		if (carts != null && carts.size() == 1) {// 说明购物车存在该属性商品
			num += carts.get(0).getNum();
			cart.setNum(num);
			return JSONUtil
					.setResult(cartMapper.updateByExampleSelective(cart, example));
		}
		// 如果不存在，添加一条新的记录
		cart.setDatetime(new Date());
		return JSONUtil.setResult(cartMapper.insertSelective(cart));
	}

	@Override
	public JSONObject delete(Integer id) {
		if (id == null) {
			return null;
		}
		return JSONUtil.setResult(cartMapper.deleteByPrimaryKey(id));
	}

	@Override
	public JSONObject get(Integer pageNo, Integer pageSize, Integer userId) {
		if (pageNo == null) {
			pageNo = 1;
		}
		if (pageSize == null) {
			pageSize = 10;
		}
		PageBounds pageBounds = new PageBounds(pageNo, pageSize);
		PageList<CartInfo> products = cartMapper.selectByPage(userId,
				pageBounds);
		return JSONUtil.setResult(products);
	}

	@Override
	public JSONObject update(Cart cart) {
		return JSONUtil.setResult(cartMapper.updateByPrimaryKeySelective(cart));
	}

}

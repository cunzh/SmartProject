/**
 * 
 */
package hust.shop.action;

import javax.servlet.http.HttpSession;

import com.smartcommunity.util.JSONUtil;

import hust.shop.params.CartParam;
import hust.shop.pojo.Cart;
import hust.shop.service.ICartService;

/**
 * @version 创建时间:2015年4月13日
 * @author Huynh
 */
public class CartAction extends BaseActionSupport<CartParam> {

	private ICartService cartService;

	public ICartService getCartService() {
		return cartService;
	}

	public void setCartService(ICartService cartService) {
		this.cartService = cartService;
	}

	public String get() {
		HttpSession session = getHttpSession();
		if (session == null || session.getAttribute("id") == null) {
			return setJSONObject(JSONUtil.getFalseJsonObject("您未登录"));
		}
		return setJSONObject(cartService.get(parameters.getPageNo(),
				parameters.getPageSize(), (Integer) session.getAttribute("id")));
	}

	public String add() {
		Cart cart = parameters.getCart();
		cart.setUserId(getUserId());
		return setJSONObject(cartService.add(cart));
	}

	public String delete() {
		return setJSONObject(cartService.delete(parameters.getId()));
	}

	private Integer getUserId() {
		HttpSession session = getHttpSession();
		if (session == null || session.getAttribute("id") == null) {
			return null;
		}
		return (Integer) session.getAttribute("id");
	}
}

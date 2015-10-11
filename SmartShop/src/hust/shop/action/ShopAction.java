/**
 * 
 */
package hust.shop.action;

import hust.shop.params.ShopParam;
import hust.shop.pojo.Shop;
import hust.shop.service.IShopService;

import javax.servlet.http.HttpSession;

import com.alibaba.fastjson.JSONObject;
import com.smartcommunity.util.ConstantPool;
import com.smartcommunity.util.InputStreamUtil;
import com.smartcommunity.util.JSONUtil;

/**
 * 店铺管理Action
 * 
 * @version 创建时间:2015年4月3日
 * @author Huynh
 */
public class ShopAction extends BaseActionSupport<ShopParam> {

	private static final long serialVersionUID = 5082155667832304649L;
	private IShopService shopService;


	public IShopService getShopService() {
		return shopService;
	}

	public void setShopService(IShopService shopService) {
		this.shopService = shopService;
	}

	public String add() {
		Shop shop = parameters.getShop();
		HttpSession session = getHttpSession();
		if (session == null||(Integer) session.getAttribute("id") == null) {
			return setJSONObject(JSONUtil.getFalseJsonObject("您未登录，请先登录"));
		}
		shop.setUserId((Integer) session.getAttribute("id"));
		return setJSONObject(shopService.add(shop));
	}

	public String close() {
		return setJSONObject(shopService.close(parameters.getId()));
	}

	public String update() {
		return setJSONObject(shopService.update(parameters.getShop()));
	}

	public String getByUserId() {
		Integer id = parameters.getId();
		if (id == null) {
			HttpSession session = getHttpSession();
			id = (Integer) session.getAttribute(ConstantPool.SESSION_USER_ID);
		}
		return setJSONObject(shopService.getByUserId(id));
	}

	public String getByName() {
		return setJSONObject(shopService.getByName(parameters.getPageNo(),
				parameters.getPageSize(), parameters.getName()));
	}
	
	public String getByShopId() {
		return setJSONObject(shopService.getByShopId(parameters.getId()));
	}


}

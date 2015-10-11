/**
 * 
 */
package hust.shop.action;

import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;
import com.opensymphony.xwork2.ActionContext;
import com.smartcommunity.util.JSONUtil;

import hust.shop.params.ProductParam;
import hust.shop.service.IProductService;

/**
 * @version 创建时间:2015年4月5日
 * @author Huynh
 */
public class ProductAction extends BaseActionSupport<ProductParam> {

	private IProductService productService;

	public IProductService getProductService() {
		return productService;
	}

	public void setProductService(IProductService productService) {
		this.productService = productService;
	}

	public String getByShop() {
		return setJSONObject(productService.getByShop(parameters.getPageNo(),
				parameters.getPageSize(), parameters.getId()));
	}

	public String getByType() {
		final Integer shopId = parameters.getShopId();
		final Integer typeId = parameters.getTypeId();
		if (shopId == null || typeId == null) {
			return setJSONObject(JSONUtil.getFalseJsonObject("店铺id或商品类型id不能为空"));
		}
		return setJSONObject(productService.getByType(parameters.getPageNo(),
				parameters.getPageSize(), shopId, typeId));
	}

	public String getByProperty() {
		final Integer shopId = parameters.getShopId();
		final Integer typeId = parameters.getTypeId();
		final Integer propertyValueId = parameters.getPropertyValueId();
		if (shopId == null || typeId == null || propertyValueId == null) {
			return setJSONObject(JSONUtil.getFalseJsonObject("店铺id或商品类型id不能为空"));
		}
		return setJSONObject(productService.getByProperty(
				parameters.getPageNo(), parameters.getPageSize(), shopId,
				typeId, propertyValueId));
	}

	public String add() {

		return setJSONObject(productService.add(parameters.getProduct(),
				parameters.getPropertyValueId(), parameters.getImages(),
				parameters.getImagesFileName(),
				parameters.getImagesContentType()));

	}

	public String update() {
		return setJSONObject(productService.update(parameters.getProduct())); 
	}

	public String delete() {
		return setJSONObject(productService.delete(parameters.getId()));
	}

	public String deleteImages() {
		return setJSONObject(productService.deleteImages(parameters.getIds(),
				parameters.getUrls()));
	}

	public String getPropertyValue() {
		return setJSONObject(productService.getPropertyValue(parameters.getId()));
	}
}

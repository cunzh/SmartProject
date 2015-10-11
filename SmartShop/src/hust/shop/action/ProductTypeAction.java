/**
 * 
 */
package hust.shop.action;

import hust.shop.params.ProductTypeParam;
import hust.shop.service.IProductTypeService;

/**
 * @version 创建时间:2015年4月8日
 * @author Huynh
 */
public class ProductTypeAction extends BaseActionSupport<ProductTypeParam> {

	private IProductTypeService productTypeService;

	public IProductTypeService getProductTypeService() {
		return productTypeService;
	}

	public void setProductTypeService(IProductTypeService productTypeService) {
		this.productTypeService = productTypeService;
	}

	public String add() {
		return setJSONObject(productTypeService
				.add(parameters.getProductType()));
	}

	public String delete() {
		return setJSONObject(productTypeService.delete(parameters.getId()));
	}

	public String update() {
		return setJSONObject(productTypeService.update(parameters
				.getProductType()));
	}

	public String get() {
		return setJSONObject(productTypeService.get(parameters.getPageNo(),
				parameters.getPageSize()));
	}
}

package hust.shop.action;

import java.util.Date;

import hust.shop.params.OrderParam;


public class ProductPropertyAction extends BaseActionSupport<hust.shop.params.ProductPropertyParam>{

	private hust.shop.service.IProductPropertyService productPropertyService;
	
	public String add() {
		return setJSONObject( productPropertyService.add(parameters.getProductTypeId(), parameters.getName()) );
	}
	public String delete() {

		return setJSONObject(productPropertyService.delete(parameters.getId()) );
	}
	public String get() {

		return setJSONObject(productPropertyService.get(parameters.getProductTypeId()) );
	}
	public String update() {

		return setJSONObject(productPropertyService.update(parameters.getId(), parameters.getName()) );
	}
	public hust.shop.service.IProductPropertyService getProductPropertyService() {
		return productPropertyService;
	}
	public void setProductPropertyService(
			hust.shop.service.IProductPropertyService productPropertyService) {
		this.productPropertyService = productPropertyService;
	}

}

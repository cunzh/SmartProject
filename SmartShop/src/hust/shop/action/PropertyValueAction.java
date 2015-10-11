package hust.shop.action;

import java.util.Date;

import hust.shop.params.OrderParam;


public class PropertyValueAction extends BaseActionSupport<hust.shop.params.ProductPropertyValueParam>{

	private hust.shop.service.IProductPropertyValueService productPropertyValueService;
	
	public String add() {
		return setJSONObject( productPropertyValueService.add(parameters.getProductPropertyId(), parameters.getName()) );
	}
	public String delete() {

		return setJSONObject(productPropertyValueService.delete(parameters.getId()) );
	}
	public String get() {

		return setJSONObject(productPropertyValueService.get(parameters.getProductPropertyId()) );
	}
	public String update() {

		return setJSONObject(productPropertyValueService.update(parameters.getId(), parameters.getName()) );
	}

	public hust.shop.service.IProductPropertyValueService getProductPropertyValueService() {
		return productPropertyValueService;
	}
	public void setProductPropertyValueService(
			hust.shop.service.IProductPropertyValueService productPropertyValueService) {
		this.productPropertyValueService = productPropertyValueService;
	}

}

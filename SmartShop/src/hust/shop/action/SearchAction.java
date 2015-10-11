package hust.shop.action;

import java.util.Date;

import hust.shop.params.SearchParam;


public class SearchAction extends BaseActionSupport<SearchParam>{

	private hust.shop.service.ISearchService searchService;
	
	public String getByProductId() {
		return setJSONObject(searchService.getByProductId(parameters.getProductId()));
		
	}
	public String getByProductType() {
		return setJSONObject(searchService.getByProductType(parameters.getProductTypeId(), parameters.getPageNo(), parameters.getPageSize()));
		

	}
	public String getByProductProperty() {
		return setJSONObject(searchService.getByProductProperty(parameters.getProductPropertyId(), parameters.getPageNo(), parameters.getPageSize()) );
		
	}
	public String getByName() {
		return setJSONObject(searchService.getByKeywords(parameters.getName(), parameters.getPageNo(), parameters.getPageSize()) );
		
	}
	public hust.shop.service.ISearchService getSearchService() {
		return searchService;
	}
	public void setSearchService(hust.shop.service.ISearchService searchService) {
		this.searchService = searchService;
	}
}

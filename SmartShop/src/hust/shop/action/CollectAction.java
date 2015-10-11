/**
 * 
 */
package hust.shop.action;

import javax.servlet.http.HttpSession;

import com.smartcommunity.util.JSONUtil;

import hust.shop.params.CollectParam;
import hust.shop.pojo.Collect;
import hust.shop.service.ICollectService;

/**
 * @version 创建时间:2015年4月8日
 * @author Huynh
 */
public class CollectAction extends BaseActionSupport<CollectParam>{

	private ICollectService collectService;

	public ICollectService getCollectService() {
		return collectService;
	}

	public void setCollectService(ICollectService collectService) {
		this.collectService = collectService;
	}
	
	public String get(){
		return setJSONObject(collectService.get(parameters.getPageNo(), parameters.getPageSize(), parameters.getId()));
	}
	
	public String add(){
		HttpSession session = getHttpSession();
		if (session==null  || session.getAttribute("id")==null) {
			return setJSONObject(JSONUtil.getFalseJsonObject("未登录"));
		}
		Collect collect = new Collect();
		collect.setUserId((Integer)session.getAttribute("id"));
		collect.setShopId(parameters.getShopId());
		return setJSONObject(collectService.add(collect));
	}
	
	public String delete(){
		HttpSession session = getHttpSession();
		if (session == null || session.getAttribute("id") == null) {
			return setJSONObject(JSONUtil.getFalseJsonObject("您未登录"));
		}
		
		return setJSONObject(collectService.delete((Integer)session.getAttribute("id"),parameters.getShopId()));
	}
}

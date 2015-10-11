/**
 * 
 */
package hust.shop.service.impl;

import java.util.Date;

import com.alibaba.fastjson.JSONObject;
import com.smartcommunity.util.JSONUtil;

import edu.hust.smartcommunity.paginator.domain.PageBounds;
import edu.hust.smartcommunity.paginator.domain.PageList;
import hust.shop.mapper.CollectMapper;
import hust.shop.mapper.ShopMapper;
import hust.shop.pojo.Collect;
import hust.shop.pojo.CollectExample;
import hust.shop.pojo.Shop;
import hust.shop.service.ICollectService;

/**
 * 收藏模块 接口实现
 * @version 创建时间:2015年4月8日
 * @author Huynh
 */
public class CollectServiceImpl implements ICollectService {

	private CollectMapper collectMapper;
	private ShopMapper shopMapper;
	
	
	public ShopMapper getShopMapper() {
		return shopMapper;
	}

	public void setShopMapper(ShopMapper shopMapper) {
		this.shopMapper = shopMapper;
	}

	public CollectMapper getCollectMapper() {
		return collectMapper;
	}

	public void setCollectMapper(CollectMapper collectMapper) {
		this.collectMapper = collectMapper;
	}

	@Override
	public JSONObject add(Collect collect) {
		if (collect == null) {
			return null;
		}
		//以下是判断添加收藏的店铺是否存在，其实真实场景无需判断
//		int shopId = collect.getShopId();
//		Shop shop = shopMapper.selectByPrimaryKey(shopId);
//		if (shop == null) {
//			return JSONUtil.getFalseJsonObject("该店铺不存在");
//		}
		collect.setDatetime(new Date());
		return JSONUtil.setResult(collectMapper.insertSelective(collect));
	}

	@Override
	public JSONObject delete(Integer userId,Integer shopId) {
		CollectExample example = new CollectExample();
		CollectExample.Criteria criteria = example.createCriteria();
		criteria.andUserIdEqualTo(userId);
		criteria.andShopIdEqualTo(shopId);
		return JSONUtil.setResult(collectMapper.deleteByExample(example));
	}

	@Override
	public JSONObject get(Integer pageNo, Integer pageSize, Integer userId) {
		if (pageNo == null) {
			pageNo = 1;
		}
		if (pageSize == null) {
			pageSize =10;
		}
		PageBounds pageBounds = new PageBounds(pageNo,pageSize);
		PageList<Shop> shops = collectMapper.selectByPage(userId, pageBounds);
		return JSONUtil.setResult(shops);
	}

	
}

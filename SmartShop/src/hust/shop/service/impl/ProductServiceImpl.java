/**
 * 
 */
package hust.shop.service.impl;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.zookeeper.Op.Create;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.smartcommunity.util.JSONUtil;
import com.smartcommunity.util.PathUtil;

import edu.hust.smartcommunity.paginator.domain.PageBounds;
import edu.hust.smartcommunity.paginator.domain.PageList;
import hust.shop.mapper.ImageMapper;
import hust.shop.mapper.ProductMapper;
import hust.shop.mapper.ProductPropertyValueMapper;
import hust.shop.pojo.Image;
import hust.shop.pojo.ImageExample;
import hust.shop.pojo.Product;
import hust.shop.pojo.ProductExample;
import hust.shop.pojo.ProductExample.Criteria;
import hust.shop.pojo.ProductPropertyValue;
import hust.shop.pojo.ProductPropertyValueExample;
import hust.shop.service.IProductService;

/**
 * 商品管理 接口实现
 * 
 * @version 创建时间:2015年4月2日
 * @author Huynh
 */ 
public class ProductServiceImpl implements IProductService {

	private ProductMapper productMapper;
	private ImageMapper imageMapper;
	private ProductPropertyValueMapper productPropertyValueMapper;
	private hust.shop.mapper.PropertyValueMapper propertyValueMapper;

	public ProductPropertyValueMapper getProductPropertyValueMapper() {
		return productPropertyValueMapper;
	}

	public void setProductPropertyValueMapper(
			ProductPropertyValueMapper productPropertyValueMapper) {
		this.productPropertyValueMapper = productPropertyValueMapper;
	}

	public ImageMapper getImageMapper() {
		return imageMapper;
	}

	public void setImageMapper(ImageMapper imageMapper) {
		this.imageMapper = imageMapper;
	}

	public ProductMapper getProductMapper() {
		return productMapper;
	}

	public void setProductMapper(ProductMapper productMapper) {
		this.productMapper = productMapper;
	}

	@org.springframework.transaction.annotation.Transactional
	@Override
	public JSONObject add(Product product, Integer propertyValueId,
			List<File> images, List<String> imagesFileName,
			List<String> imagesContentType) {
		if (product == null) {
			return null;
		}
		product.setDatetime(new Date());
		int count = productMapper.insertSelective(product);
		int productId = product.getId();// 插入成功后会自动将主键id装配到product对象中

		
		if (count > 0 && productId > 0) {// 如果插入成功则插入图片到图片表中
			// 插入商品属性值
			if (propertyValueId != null) {
			ProductPropertyValue productPropertyValue = new ProductPropertyValue();
			productPropertyValue.setProductId(productId);
			productPropertyValue.setPropertyValueId(propertyValueId);
			productPropertyValueMapper.insertSelective(productPropertyValue);// 将记录插入商品属性表
			}
			/** 插入图片 */
			if (images != null && imagesContentType != null
					&& imagesFileName != null) {
				Image image = new Image();
				for (int i = 0; i < images.size(); i++) {
					String imagename = productId + imagesFileName.get(i); // 图片的文件名
					String imagepath = PathUtil.getProductPath(product.getName()); // 图片保存路径
					String realpath = org.apache.struts2.ServletActionContext
							.getServletContext().getRealPath(imagepath);
					System.out.println(realpath);
					/** 插入图片地址到数据库 */
					image.setProductId(productId);
					image.setUrl(imagepath + imagename);
					image.setDatetime(new Date());


					int imageCount = imageMapper.insertSelective(image);// 插入数据库

					if (imageCount > 0) {
						System.out.println("图片写入数据库成功!");
						/** 保存图片到本地 */
						File saveFile = new File(new File(realpath), imagename);
						if (!saveFile.getParentFile().exists())
							saveFile.getParentFile().mkdirs();
						try {
							org.apache.commons.io.FileUtils.copyFile(
									images.get(i), saveFile);
							System.out.println("图片保存成功!地址为 "+saveFile.getAbsolutePath());
						} catch (IOException e) {
							// TODO Auto-generated catch block
							throw new RuntimeException("保存文件 "
									+ saveFile.getPath() + "/"
									+ saveFile.getName() + " 失败 : "
									+ e.getMessage());
						}
					}
				}
			}
			return JSONUtil.getJsonObject(true);
		}
		return null;
 
	}

 
	@Override
	public JSONObject delete(Integer id) {
		
		//先删除商品对应的属性值
		ProductPropertyValueExample productPropertyValueExample = new ProductPropertyValueExample();
		productPropertyValueExample.or().andProductIdEqualTo(id);
		int deletePropertyValueCount = productPropertyValueMapper.deleteByExample(productPropertyValueExample);
//		if (deletePropertyValueCount<1) {
//			return JSONUtil.getFalseJsonObject("删除属性值失败！");
//		}
		
		//再删除商品对应的图片
		ImageExample example = new ImageExample();
		example.or().andProductIdEqualTo(id);
		List<Image> images = imageMapper.selectByExample(example);
		if (images != null && images.size()>0) {//如果有图片就删除对应图片
			if (!removeImagesFromFile(images))
				return JSONUtil.getFalseJsonObject("删除图片失败！");
		}
		
		//最后删除商品
		int count = productMapper.deleteByPrimaryKey(id);
		if (count<1) {
			return JSONUtil.getFalseJsonObject("删除商品失败！");
		}
		return  JSONUtil.getJsonObject(true);
	}

	@Override
	public JSONObject deleteImages(List<Integer> ids, List<String> urls) {
		List<Image> images = new ArrayList<Image>();
		Image image = null;
		final int length = ids.size();
		for (int i = 0; i < length; i++) {// 封装图片
			image = new Image();
			image.setId(ids.get(i));
			image.setUrl(urls.get(i));
			images.add(image);
		}
		if (removeImagesFromFile(images))// 批量删除
			return JSONUtil.getJsonObject(true);
		return null;
	}

	@Override
	public JSONObject update(Product product) {
		int count = productMapper.updateByPrimaryKeySelective(product);
		if (count > 0) {
			return JSONUtil.getJsonObject(true);
		}
		return null;
	}

	@Override
	public JSONObject getByShop(Integer pageNo, Integer pageSize, Integer shopId) {
		ProductExample example = new ProductExample();
		example.or().andShopIdEqualTo(shopId);
		example.setOrderByClause("price desc");
		return getProductAndImage(pageNo, pageSize, example);
	}

	@Override
	public JSONObject getByType(Integer pageNo, Integer pageSize,
			Integer shopId, Integer typeId) {
		ProductExample example = new ProductExample();
		Criteria criteria = example.createCriteria();
		criteria.andShopIdEqualTo(shopId);
		criteria.andTypeIdEqualTo(typeId);
		example.setOrderByClause("price desc");
		return getProductAndImage(pageNo, pageSize, example);
	}

	@Override
	public JSONObject getByProperty(Integer pageNo, Integer pageSize,
			Integer shopId, Integer typeId, Integer propertyValueId) {
		ProductExample example = new ProductExample();
		Criteria criteria = example.createCriteria();
		criteria.andShopIdEqualTo(shopId);
		criteria.andTypeIdEqualTo(typeId);
		example.setOrderByClause("price desc");
		return getProductAndImage(pageNo, pageSize, example);
	}

	// //////////////////////////内部方法///////////////////////////////////////
	/**
	 * 批量删除给定的图片文件
	 * 
	 * @version 创建时间: 2015年4月4日
	 * @author Huynh
	 * @param images
	 * @return true 删除成功
	 */
	private boolean removeImagesFromFile(List<Image> images) {
		if (images == null) {
			return false;
		}
		int count = 0;
		boolean flag = false;
		for (Image image : images) {
			count = imageMapper.deleteByPrimaryKey(image.getId());// 删除数据库中记录
			String realpath = org.apache.struts2.ServletActionContext
					.getServletContext().getRealPath(image.getUrl());
			File file = new File(realpath);
			if (file.exists()) {
				flag = file.delete();
			}
		}
		return (count > 0) && flag;
	}

	/**
	 * 查询商品及图片
	 * 
	 * @version 创建时间: 2015年4月5日
	 * @author Huynh
	 * @param pageNo
	 * @param pageSize
	 * @param example
	 * @return
	 */
	private JSONObject getProductAndImage(Integer pageNo, Integer pageSize,
			ProductExample example) {
		if (pageNo == null) {
			pageNo = 1;
		}
		if (pageSize == null) {
			pageSize = 10;
		}
		JSONObject jsonObject = null;
		PageBounds pageBounds = new PageBounds(pageNo, pageSize);
		PageList<Product> products = productMapper.selectProductWithImage(
				example, pageBounds);
		if (products == null) {
			return null;
		}
		jsonObject = JSONUtil.getJsonObject(true);
		JSONArray jsonArray = (JSONArray) JSON.toJSON(products);
		jsonObject.put("totalpage", products.getPaginator().getTotalPages());
		JSONUtil.putResult(jsonObject, jsonArray);
		return jsonObject;
	}

	@Override
	public JSONObject getPropertyValue(Integer productId) {
		if (productId == null) {
			return JSONUtil.getFalseJsonObject("商品 id 为空");
		}
		ProductPropertyValueExample productPropertyValueExample = new ProductPropertyValueExample();
		productPropertyValueExample.or().andProductIdEqualTo(productId);
		List<ProductPropertyValue> productPropertyValues = productPropertyValueMapper.selectByExample(productPropertyValueExample);
		List<Integer> propertyValueIds = new ArrayList<>();
		for (ProductPropertyValue productPropertyValue : productPropertyValues) {
			propertyValueIds.add(productPropertyValue.getPropertyValueId());
		}
		hust.shop.pojo.PropertyValueExample propertyValueExample = new hust.shop.pojo.PropertyValueExample();
		propertyValueExample.or().andadotIdIn(propertyValueIds);
		List<hust.shop.pojo.PropertyValue> propertyValues = propertyValueMapper.getPropertyValue(propertyValueExample);
		JSONArray jsonArray = (JSONArray) JSON.toJSON(propertyValues);
		JSONObject jsonObject = JSONUtil.getJsonObject(true);
		JSONUtil.putResult(jsonObject, jsonArray);
		return jsonObject;
	}

	public hust.shop.mapper.PropertyValueMapper getPropertyValueMapper() {
		return propertyValueMapper;
	}

	public void setPropertyValueMapper(hust.shop.mapper.PropertyValueMapper propertyValueMapper) {
		this.propertyValueMapper = propertyValueMapper;
	}
}

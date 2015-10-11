package hust.shop.action;

import com.alibaba.fastjson.JSONObject;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.smartcommunity.util.InputStreamUtil;
import com.smartcommunity.util.JSONUtil;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import java.io.InputStream;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by izerui.com on 14-4-30.
 *
 * Action 基类,封装了泛型参数get set 方法
 * 注入spring applicationContext 对象
 *
 * @param <T> 参数类
 */  
public class BaseActionSupport<T> extends ActionSupport implements ModelDriven<T>,
									ApplicationContextAware{
 
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected InputStream inputStream ; 	// 用于返回数据
	private javax.servlet.http.HttpSession httpSession;
	/**
     * 声明的参数类
     * <br/><em>不建议名称修改为param
     * 可能会跟页面param对象冲突,导致通过struts取值机制冲突</em>
     */
    protected T parameters;

    /**
     * spring 上下文
     */
    protected ApplicationContext applicationContext;

    /**
     * 构造参数对象
     */
    public BaseActionSupport() {
        if(parameters==null){
            try {
            	parameters = getParameterizedTypeClass().newInstance();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

	
    private Class<T> getParameterizedTypeClass(){
        // 获取泛型类型
        Type type = getClass().getGenericSuperclass();
        Type[] trueType = ((ParameterizedType) type).getActualTypeArguments();
        return (Class<T>) trueType[0];
    }



    public T getParameters() {
		return parameters;
	}


	public void setParameters(T parameters) {
		this.parameters = parameters;
	}


	@Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    /**
     * 将泛型参数类映射为Struts的默认参数包装对象
     */
    @Override
    public T getModel() {
        return parameters;
    }
	public java.io.InputStream getInputStream() {
		return inputStream;
	}
	public void setInputStream(java.io.InputStream inputStream) {
		this.inputStream = inputStream;
	}

/**
 * 获取HttpSession对象
 * @version 创建时间: 2015年3月22日
 * @author Huynh
 * @return HttpSession
 */
	public javax.servlet.http.HttpSession getHttpSession() {
		if (httpSession != null)
			return httpSession;
		return org.apache.struts2.ServletActionContext.getRequest().getSession();
	}
	/**
	 * 获取 HttpSession 对象
	 * @param create 如果没有 sesseion 指定是否创建会话
	 * @return
	 */
	public javax.servlet.http.HttpSession getHttpSession(boolean create ) {
		if (httpSession != null)
			return httpSession;
		return org.apache.struts2.ServletActionContext.getRequest().getSession(create);
	}

	/**
	 * 获取HttpServletRequest对象
	 * @version 创建时间: 2015年3月22日
	 * @author Huynh
	 * @return HttpServletRequest
	 */
	public HttpServletRequest getHttpServletRequest(){
		return ServletActionContext.getRequest();
	}
	
	public void setHttpSession(javax.servlet.http.HttpSession httpSession) {
		this.httpSession = httpSession;
	}
	
	/**
	 * 将最终json结果对象包装为InputStream；
	 * 一般在action中的方法中直接调用该方法作为返回值
	 * @version 创建时间: 2015年3月23日
	 * @author Huynh
	 * @param jsonObject
	 * @return success
	 */
	protected String setJSONObject(JSONObject jsonObject) {
		if (jsonObject == null) {
			jsonObject = JSONUtil.getJsonObject(false);
			JSONUtil.putCause(jsonObject, "数据操作失败");
		}
		inputStream = InputStreamUtil.getInputStream(jsonObject);
		return SUCCESS;
	}
}
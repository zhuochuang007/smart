package com.zhuochuang.smart.core.util;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

/**
 * 常量工具类
 * @author chuzhisheng
 * @version 1.0
 * @date 2016年5月31日 下午1:59:10
 */
public class PropertyUtil  extends PropertyPlaceholderConfigurer {
   private static Map<String, Object> ctxPropertiesMap;
   private static Properties allProperties = new Properties();

   /**
    * 获取配置文件对象
    * @author chuzhisheng
    * @version 1.0
    * @date 2016年5月31日 下午2:52:29
    * @return
    */
   public static Properties getAllProperties() {
    return allProperties;
   }
   /**
    * 重新配置文件加载方法
    * @author chuzhisheng
    * @version 1.0
    * @date 2016年5月31日 下午1:57:32
    * @param beanFactoryToProcess
    * @param props
    * @throws BeansException
    */
	@Override 
	protected void processProperties(ConfigurableListableBeanFactory beanFactoryToProcess,Properties props) throws BeansException {
		super.processProperties(beanFactoryToProcess, props); 
		allProperties = props;
		ctxPropertiesMap = new HashMap<String, Object>();
		for (Object key : props.keySet()) {
		    String keyStr = key.toString();
		    String value = props.getProperty(keyStr);
		    ctxPropertiesMap.put(keyStr, value);
		}
	}
	
	/**
	 * 获取配置信息
	 * @author chuzhisheng
	 * @version 1.0
	 * @date 2016年5月31日 下午1:58:24
	 * @param name
	 * @return
	 */
	public static Object getProperty(String name) {
		return ctxPropertiesMap.get(name);
	}
	/**
	 * 获取所有配置信息map
	 * @author chuzhisheng
	 * @version 1.0
	 * @date 2016年5月31日 下午1:58:43
	 * @param name
	 * @return
	 */
	public static Map<String, Object> getAllProperty(String name) {
		return ctxPropertiesMap;
	}
}

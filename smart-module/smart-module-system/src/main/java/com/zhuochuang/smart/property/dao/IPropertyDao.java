package com.zhuochuang.smart.property.dao;

import com.zhuochuang.smart.entity.property.Property;

/** 
 * 数据字典配置Dao接口
 * <功能详细描述> 
 * 
 * @author  ouxin 
 * @version  [版本号, 2016年7月4日] 
 */
public interface IPropertyDao
{
    public int createProperty(Property property);
    
    public int updatePropertyById(Property property);
    
    public int deletePropertyById(Property property);
    
    public Property findPropertyById(Property property);
}

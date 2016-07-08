package com.zhuochuang.smart.property.service.impl;

import javax.inject.Inject;
import javax.inject.Named;

import com.zhuochuang.smart.entity.property.Property;
import com.zhuochuang.smart.property.dao.IPropertyDao;
import com.zhuochuang.smart.property.service.IPropertyService;

/** 
 * 数据字典配置实现类
 * <功能详细描述> 
 * 
 * @author  ouxin 
 * @version  [版本号, 2016年7月4日] 
 */
@Named
public class PropertyService implements IPropertyService
{
    
    @Inject
    private IPropertyDao propertyDao;

    @Override
    public void createProperty(Property property)
    {
        propertyDao.createProperty(property);
    }

    @Override
    public void updatePropertyById(Property property)
    {
        propertyDao.updatePropertyById(property);
    }

    @Override
    public void deletePropertyById(Property property)
    {
        propertyDao.deletePropertyById(property);
    }

    @Override
    public Property findPropertyById(Property property)
    {
        return propertyDao.findPropertyById(property);
    }
    
}

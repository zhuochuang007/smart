package com.zhuochuang.smart.entity.property;

import com.zhuochuang.smart.entity.base.BaseEntity;

/** 
 * 数据字典实体
 * <功能详细描述> 
 * 
 * @author  ouxin 
 * @version  [版本号, 2016年7月4日] 
 */
public class Property extends BaseEntity
{

    private static final long serialVersionUID = -3359536798718948471L;
    
    /**
     * 数据字典ID
     */
    private String propertyId;
    
    /**
     * 父ID
     */
    private String parentId;
    
    /**
     * 显示名称
     */
    private String displayName;
    
    /**
     * 名称
     */
    private String name;
    
    /**
     * 值
     */
    private String value;
    
    /**
     * 描述
     */
    private String description;
    
    /**
     * 下标
     */
    private String listIndex;
    
    /**
     * 父路径
     */
    private String parentPath;
    
    /**
     * 状态0:无效1:有效
     */
    private String status;

    public String getPropertyId()
    {
        return propertyId;
    }

    public void setPropertyId(String propertyId)
    {
        this.propertyId = propertyId;
    }

    public String getParentId()
    {
        return parentId;
    }

    public void setParentId(String parentId)
    {
        this.parentId = parentId;
    }

    public String getDisplayName()
    {
        return displayName;
    }

    public void setDisplayName(String displayName)
    {
        this.displayName = displayName;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getValue()
    {
        return value;
    }

    public void setValue(String value)
    {
        this.value = value;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public String getListIndex()
    {
        return listIndex;
    }

    public void setListIndex(String listIndex)
    {
        this.listIndex = listIndex;
    }

    public String getParentPath()
    {
        return parentPath;
    }

    public void setParentPath(String parentPath)
    {
        this.parentPath = parentPath;
    }

    public String getStatus()
    {
        return status;
    }

    public void setStatus(String status)
    {
        this.status = status;
    }
}

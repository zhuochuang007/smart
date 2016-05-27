package com.zhuochuang.smart.entity.base;

import java.io.Serializable;

/** 
 * 基础实体对象
 * <功能详细描述> 
 * 
 * @author  ouxin 
 * @version  [版本号, 2016年5月27日] 
 */
public class BaseEntity implements Serializable
{
    private static final long serialVersionUID = 5696279641845545160L;
    
    /**
     * 创建人ID
     */
    private String createBy;
    
    /**
     * 创建时间
     */
    private String createDate;
    
    /**
     * 更新人ID
     */
    private String updateBy;
    
    /**
     * 更新时间
     */
    private String updateDate;
    
    public String getCreateBy()
    {
        return createBy;
    }
    
    public void setCreateBy(String createBy)
    {
        this.createBy = createBy;
    }
    
    public String getCreateDate()
    {
        return createDate;
    }
    
    public void setCreateDate(String createDate)
    {
        this.createDate = createDate;
    }
    
    public String getUpdateBy()
    {
        return updateBy;
    }
    
    public void setUpdateBy(String updateBy)
    {
        this.updateBy = updateBy;
    }
    
    public String getUpdateDate()
    {
        return updateDate;
    }
    
    public void setUpdateDate(String updateDate)
    {
        this.updateDate = updateDate;
    }
}

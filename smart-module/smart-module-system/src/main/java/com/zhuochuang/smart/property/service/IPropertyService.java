package com.zhuochuang.smart.property.service;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.zhuochuang.smart.entity.property.Property;

/** 
 * 数据字典配置接口
 * <功能详细描述> 
 * 
 * @author  ouxin 
 * @version  [版本号, 2016年7月4日] 
 */
@Path("/property")
@Produces(MediaType.APPLICATION_JSON)
public interface IPropertyService
{
    @POST
    @Path("/create")
    public void createProperty(Property property);
    
    @PUT
    @Path("/update")
    public void updatePropertyById(Property property);
    
    @DELETE
    @Path("/delete/{propertyId}")
    public void deletePropertyById(Property property);
    
    @GET
    @Path("/single/{propertyId}")
    public Property findPropertyById(Property property);
}

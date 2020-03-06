package com.xuecheng.framework.domain.cms.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class QueryPageRequest {
    //定义请求模型QueryPageRequest，此模型作为查询条件类型
    @ApiModelProperty("站点id")
    private String siteId;     //站点id
    @ApiModelProperty("页面ID")
   private String pageId;    //页面ID
    @ApiModelProperty("页面名称")
    private String pageName;      //页面名称
    @ApiModelProperty("别名")
    private String pageAliase;   //别名
    @ApiModelProperty("模版id")
   private String templateId; //模版id
}

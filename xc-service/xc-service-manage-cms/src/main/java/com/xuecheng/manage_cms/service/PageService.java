package com.xuecheng.manage_cms.service;

import com.xuecheng.api.cms.CmsPageControllerApi;
import com.xuecheng.framework.domain.cms.CmsPage;
import com.xuecheng.framework.domain.cms.request.QueryPageRequest;
import com.xuecheng.framework.model.response.CommonCode;
import com.xuecheng.framework.model.response.QueryResponseResult;
import com.xuecheng.framework.model.response.QueryResult;
import com.xuecheng.manage_cms.dao.CmsPageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PageService implements CmsPageControllerApi {

    @Autowired
    private CmsPageRepository cmsPageRepository;

    @Override
    public QueryResponseResult findList(int page, int size, QueryPageRequest queryPageRequest) {
        QueryResult queryResult=new QueryResult();
        if (page<=0){
            page=1;
        }
        if (size<=0){
            size=10;
        }
        Pageable pageable= PageRequest.of(page,size);
        Page<CmsPage> cmsPages = cmsPageRepository.findAll(pageable);
        List<CmsPage> cmsPageList = cmsPages.getContent();
        long totalElements = cmsPages.getTotalElements();
        queryResult.setTotal(totalElements);
        queryResult.setList(cmsPageList);
        return new QueryResponseResult(CommonCode.SUCCESS,queryResult);
    }
}

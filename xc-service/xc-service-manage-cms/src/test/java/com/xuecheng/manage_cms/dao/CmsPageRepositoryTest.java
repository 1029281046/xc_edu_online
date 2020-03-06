package com.xuecheng.manage_cms.dao;

import com.xuecheng.framework.domain.cms.CmsPage;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

@SpringBootTest
@RunWith(SpringRunner.class)
public class CmsPageRepositoryTest {

    @Autowired
    private CmsPageRepository cmsPageRepository;
    //查询全部测试
    public void test(){
        List<CmsPage> list = cmsPageRepository.findAll();
        for (CmsPage cmsPage : list) {
            System.out.println("查询出来的数据----》"+cmsPage);
        }
    }
    
    //分页测试
    @Test
    public void testquery(){
        int Page=0; //起始页
        int size=5; //每页显示的个数
        Pageable pageable= PageRequest.of(Page,size);
       org.springframework.data.domain.Page<CmsPage> all = cmsPageRepository.findAll(pageable);
        System.out.println(all);
    }
    //修改测试
    @Test
    public void updateTest(){
        //先根据ID查询到这个对象
        Optional<CmsPage> cmsPage = cmsPageRepository.findById("5abefd525b05aa293098fca6");
        if (cmsPage.isPresent()){
            //在得到这个对象
            CmsPage cms = cmsPage.get();
            //在进行修改
            cms.setPageAliase("testUpdate");
            //在进行保存
            CmsPage save = cmsPageRepository.save(cms);
            System.out.println(save);
        }
    }

    @Test
    public void TestName(){
        //根据自定义方法pageNam查询
        CmsPage cmsPage = cmsPageRepository.findByPageAliase("testUpdate");
        System.out.println(cmsPage);
    }
}

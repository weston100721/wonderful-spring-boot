package info.zhaoliang.wonderful.controller;

import info.zhaoliang.wonderful.domain.CmsArticle;
import info.zhaoliang.wonderful.response.CommunicationFactory;
import info.zhaoliang.wonderful.response.SimpleResponse;
import info.zhaoliang.wonderful.service.ICmsArticleService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

/**
 * @author zhaoliang
 * @create 2018-09-10
 **/
@Log4j2 @RestController @RequestMapping("/article") public class CmsArticleController {

    @Autowired private ICmsArticleService cmsArticleService;

    /**
     * heart beat.
     *
     * @return string
     */
    @RequestMapping("/test") SimpleResponse home() throws Exception {
        SimpleResponse simpleResponse = CommunicationFactory.createSimpleResponse();
        CmsArticle cmsArticle = new CmsArticle();
        cmsArticle.setId("id");
        cmsArticle.setCategoryId("bbbbbbbbbbbbid");
        cmsArticle.setTitle("");
        cmsArticle.setLink("");
        cmsArticle.setColor("");
        cmsArticle.setImage("");
        cmsArticle.setKeywords("");
        cmsArticle.setDescription("");
        cmsArticle.setWeight(0);
        cmsArticle.setWeightDate(new Date());
        cmsArticle.setHits(0);
        cmsArticle.setPosid("");
        cmsArticle.setCustomContentView("");
        cmsArticle.setCreateBy("");
        cmsArticle.setCreateDate(new Date());
        cmsArticle.setUpdateBy("");
        cmsArticle.setUpdateDate(new Date());
        cmsArticle.setRemarks("");
        cmsArticle.setDelFlag("");
        cmsArticle.setViewConfig("");
        log.info("cmsArticle : {}", cmsArticle.toString());
        cmsArticleService.addArticle(cmsArticle);
        simpleResponse.addData("ok", "Hello World!");
        return simpleResponse;
    }

    /**
     * heart beat.
     *
     * @return string
     */
    @RequestMapping("/articles") SimpleResponse articles() throws Exception {
        SimpleResponse simpleResponse = CommunicationFactory.createSimpleResponse();
        List<CmsArticle> cmsArticles = cmsArticleService.allArticles();
        simpleResponse.addData("data", cmsArticles);
        return simpleResponse;
    }
}

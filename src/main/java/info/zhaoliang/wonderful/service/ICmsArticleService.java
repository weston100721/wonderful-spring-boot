package info.zhaoliang.wonderful.service;

import java.util.List;

import info.zhaoliang.wonderful.domain.CmsArticle;

/**
 * 文章服务接口.
 * 
 * @author zhaoliang
 * @create 2018-09-07
 **/
public interface ICmsArticleService {

    /**
     * 根据id获取文章信息.
     *
     * @param id article id.
     * @return {@linkplain CmsArticle}
     */
    CmsArticle getById(String id);

    /**
     * add article.
     *
     * @param cmsArticle cms article
     * @return boolean
     */
    boolean addArticle(CmsArticle cmsArticle) throws Exception;

    /**
     * 查询所有的文章.
     * 
     * @return 列表.
     */
    List<CmsArticle> allArticles();

    boolean update(CmsArticle cmsArticle);
}

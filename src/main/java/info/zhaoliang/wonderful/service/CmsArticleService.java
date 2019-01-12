package info.zhaoliang.wonderful.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import info.zhaoliang.wonderful.dao.CmsArticleMapper;
import info.zhaoliang.wonderful.domain.CmsArticle;
import info.zhaoliang.wonderful.domain.CmsArticleExample;

/**
 * @author zhaoliang
 * @create 2018-09-07
 **/
@Service
public class CmsArticleService implements ICmsArticleService {

    @Autowired
    CmsArticleMapper cmsArticleMapper;

    @Override
    public CmsArticle getById(String id) {
        return cmsArticleMapper.selectByPrimaryKey(id);
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public boolean addArticle(CmsArticle cmsArticle) throws Exception {
        CmsArticle cmsArticle1 = allArticles().get(0);
        cmsArticle1.setTitle("ccc");
        boolean update = update(cmsArticle1);
        test();

        int insertSelective = cmsArticleMapper.insertSelective(cmsArticle);
        return insertSelective == 1;
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void test() throws Exception {
        throw new Exception("test");
    }

    @Override
    public List<CmsArticle> allArticles() {
        return cmsArticleMapper.selectByExample(new CmsArticleExample());
    }

    @Transactional(propagation = Propagation.NESTED)
    @Override
    public boolean update(CmsArticle cmsArticle) {
        int updateByPrimaryKey = cmsArticleMapper.updateByPrimaryKey(cmsArticle);
        return true;
    }
}

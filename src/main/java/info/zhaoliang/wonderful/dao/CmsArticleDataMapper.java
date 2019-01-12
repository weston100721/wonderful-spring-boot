package info.zhaoliang.wonderful.dao;

import info.zhaoliang.wonderful.domain.CmsArticleData;
import info.zhaoliang.wonderful.domain.CmsArticleDataExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CmsArticleDataMapper {
    long countByExample(CmsArticleDataExample example);

    int deleteByExample(CmsArticleDataExample example);

    int deleteByPrimaryKey(String id);

    int insert(CmsArticleData record);

    int insertSelective(CmsArticleData record);

    List<CmsArticleData> selectByExampleWithBLOBs(CmsArticleDataExample example);

    List<CmsArticleData> selectByExample(CmsArticleDataExample example);

    CmsArticleData selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") CmsArticleData record, @Param("example") CmsArticleDataExample example);

    int updateByExampleWithBLOBs(@Param("record") CmsArticleData record, @Param("example") CmsArticleDataExample example);

    int updateByExample(@Param("record") CmsArticleData record, @Param("example") CmsArticleDataExample example);

    int updateByPrimaryKeySelective(CmsArticleData record);

    int updateByPrimaryKeyWithBLOBs(CmsArticleData record);

    int updateByPrimaryKey(CmsArticleData record);
}
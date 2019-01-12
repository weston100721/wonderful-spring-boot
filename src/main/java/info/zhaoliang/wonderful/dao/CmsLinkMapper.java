package info.zhaoliang.wonderful.dao;

import info.zhaoliang.wonderful.domain.CmsLink;
import info.zhaoliang.wonderful.domain.CmsLinkExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CmsLinkMapper {
    long countByExample(CmsLinkExample example);

    int deleteByExample(CmsLinkExample example);

    int deleteByPrimaryKey(String id);

    int insert(CmsLink record);

    int insertSelective(CmsLink record);

    List<CmsLink> selectByExample(CmsLinkExample example);

    CmsLink selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") CmsLink record, @Param("example") CmsLinkExample example);

    int updateByExample(@Param("record") CmsLink record, @Param("example") CmsLinkExample example);

    int updateByPrimaryKeySelective(CmsLink record);

    int updateByPrimaryKey(CmsLink record);
}
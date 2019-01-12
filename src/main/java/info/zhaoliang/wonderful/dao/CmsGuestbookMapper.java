package info.zhaoliang.wonderful.dao;

import info.zhaoliang.wonderful.domain.CmsGuestbook;
import info.zhaoliang.wonderful.domain.CmsGuestbookExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CmsGuestbookMapper {
    long countByExample(CmsGuestbookExample example);

    int deleteByExample(CmsGuestbookExample example);

    int deleteByPrimaryKey(String id);

    int insert(CmsGuestbook record);

    int insertSelective(CmsGuestbook record);

    List<CmsGuestbook> selectByExample(CmsGuestbookExample example);

    CmsGuestbook selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") CmsGuestbook record, @Param("example") CmsGuestbookExample example);

    int updateByExample(@Param("record") CmsGuestbook record, @Param("example") CmsGuestbookExample example);

    int updateByPrimaryKeySelective(CmsGuestbook record);

    int updateByPrimaryKey(CmsGuestbook record);
}
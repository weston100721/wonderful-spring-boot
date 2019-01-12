package info.zhaoliang.wonderful.dao;

import info.zhaoliang.wonderful.domain.CmsSite;
import info.zhaoliang.wonderful.domain.CmsSiteExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CmsSiteMapper {
    long countByExample(CmsSiteExample example);

    int deleteByExample(CmsSiteExample example);

    int deleteByPrimaryKey(String id);

    int insert(CmsSite record);

    int insertSelective(CmsSite record);

    List<CmsSite> selectByExampleWithBLOBs(CmsSiteExample example);

    List<CmsSite> selectByExample(CmsSiteExample example);

    CmsSite selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") CmsSite record, @Param("example") CmsSiteExample example);

    int updateByExampleWithBLOBs(@Param("record") CmsSite record, @Param("example") CmsSiteExample example);

    int updateByExample(@Param("record") CmsSite record, @Param("example") CmsSiteExample example);

    int updateByPrimaryKeySelective(CmsSite record);

    int updateByPrimaryKeyWithBLOBs(CmsSite record);

    int updateByPrimaryKey(CmsSite record);
}
package info.zhaoliang.wonderful.dao;

import info.zhaoliang.wonderful.domain.SysMdict;
import info.zhaoliang.wonderful.domain.SysMdictExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysMdictMapper {
    long countByExample(SysMdictExample example);

    int deleteByExample(SysMdictExample example);

    int deleteByPrimaryKey(String id);

    int insert(SysMdict record);

    int insertSelective(SysMdict record);

    List<SysMdict> selectByExample(SysMdictExample example);

    SysMdict selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") SysMdict record, @Param("example") SysMdictExample example);

    int updateByExample(@Param("record") SysMdict record, @Param("example") SysMdictExample example);

    int updateByPrimaryKeySelective(SysMdict record);

    int updateByPrimaryKey(SysMdict record);
}
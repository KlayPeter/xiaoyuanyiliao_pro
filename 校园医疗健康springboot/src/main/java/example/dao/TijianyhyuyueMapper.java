package example.dao;

import example.pojo.Tijianyhyuyue;
import example.pojo.TijianyhyuyueExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TijianyhyuyueMapper {
    long countByExample(TijianyhyuyueExample example);

    int deleteByExample(TijianyhyuyueExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Tijianyhyuyue record);

    int insertSelective(Tijianyhyuyue record);

    List<Tijianyhyuyue> selectByExample(TijianyhyuyueExample example);

    Tijianyhyuyue selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Tijianyhyuyue record, @Param("example") TijianyhyuyueExample example);

    int updateByExample(@Param("record") Tijianyhyuyue record, @Param("example") TijianyhyuyueExample example);

    int updateByPrimaryKeySelective(Tijianyhyuyue record);

    int updateByPrimaryKey(Tijianyhyuyue record);
}
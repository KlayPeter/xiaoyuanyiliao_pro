package example.dao;

import example.pojo.Xyyiliaopaibanyuyue;
import example.pojo.XyyiliaopaibanyuyueExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface XyyiliaopaibanyuyueMapper {
    long countByExample(XyyiliaopaibanyuyueExample example);

    int deleteByExample(XyyiliaopaibanyuyueExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Xyyiliaopaibanyuyue record);

    int insertSelective(Xyyiliaopaibanyuyue record);

    List<Xyyiliaopaibanyuyue> selectByExample(XyyiliaopaibanyuyueExample example);

    Xyyiliaopaibanyuyue selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Xyyiliaopaibanyuyue record, @Param("example") XyyiliaopaibanyuyueExample example);

    int updateByExample(@Param("record") Xyyiliaopaibanyuyue record, @Param("example") XyyiliaopaibanyuyueExample example);

    int updateByPrimaryKeySelective(Xyyiliaopaibanyuyue record);

    int updateByPrimaryKey(Xyyiliaopaibanyuyue record);
}
package example.dao;

import example.pojo.Xiaoyuanyisheng;
import example.pojo.XiaoyuanyishengExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface XiaoyuanyishengMapper {
    long countByExample(XiaoyuanyishengExample example);

    int deleteByExample(XiaoyuanyishengExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Xiaoyuanyisheng record);

    int insertSelective(Xiaoyuanyisheng record);

    List<Xiaoyuanyisheng> selectByExample(XiaoyuanyishengExample example);

    Xiaoyuanyisheng selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Xiaoyuanyisheng record, @Param("example") XiaoyuanyishengExample example);

    int updateByExample(@Param("record") Xiaoyuanyisheng record, @Param("example") XiaoyuanyishengExample example);

    int updateByPrimaryKeySelective(Xiaoyuanyisheng record);

    int updateByPrimaryKey(Xiaoyuanyisheng record);
}
package example.dao;

import example.pojo.Xyyiliaoyh;
import example.pojo.XyyiliaoyhExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface XyyiliaoyhMapper {
    long countByExample(XyyiliaoyhExample example);

    int deleteByExample(XyyiliaoyhExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Xyyiliaoyh record);

    int insertSelective(Xyyiliaoyh record);

    List<Xyyiliaoyh> selectByExample(XyyiliaoyhExample example);

    Xyyiliaoyh selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Xyyiliaoyh record, @Param("example") XyyiliaoyhExample example);

    int updateByExample(@Param("record") Xyyiliaoyh record, @Param("example") XyyiliaoyhExample example);

    int updateByPrimaryKeySelective(Xyyiliaoyh record);

    int updateByPrimaryKey(Xyyiliaoyh record);
}
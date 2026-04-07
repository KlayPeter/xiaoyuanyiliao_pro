package example.dao;

import example.pojo.Xyyiliaopaiban;
import example.pojo.XyyiliaopaibanExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface XyyiliaopaibanMapper {
    long countByExample(XyyiliaopaibanExample example);

    int deleteByExample(XyyiliaopaibanExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Xyyiliaopaiban record);

    int insertSelective(Xyyiliaopaiban record);

    List<Xyyiliaopaiban> selectByExample(XyyiliaopaibanExample example);

    Xyyiliaopaiban selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Xyyiliaopaiban record, @Param("example") XyyiliaopaibanExample example);

    int updateByExample(@Param("record") Xyyiliaopaiban record, @Param("example") XyyiliaopaibanExample example);

    int updateByPrimaryKeySelective(Xyyiliaopaiban record);

    int updateByPrimaryKey(Xyyiliaopaiban record);
}
package example.dao;

import example.pojo.Xyyiliaoyaoping;
import example.pojo.XyyiliaoyaopingExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface XyyiliaoyaopingMapper {
    long countByExample(XyyiliaoyaopingExample example);

    int deleteByExample(XyyiliaoyaopingExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Xyyiliaoyaoping record);

    int insertSelective(Xyyiliaoyaoping record);

    List<Xyyiliaoyaoping> selectByExample(XyyiliaoyaopingExample example);

    Xyyiliaoyaoping selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Xyyiliaoyaoping record, @Param("example") XyyiliaoyaopingExample example);

    int updateByExample(@Param("record") Xyyiliaoyaoping record, @Param("example") XyyiliaoyaopingExample example);

    int updateByPrimaryKeySelective(Xyyiliaoyaoping record);

    int updateByPrimaryKey(Xyyiliaoyaoping record);
}
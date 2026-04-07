package example.dao;

import example.pojo.Yiliaoyaopingtixing;
import example.pojo.YiliaoyaopingtixingExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface YiliaoyaopingtixingMapper {
    long countByExample(YiliaoyaopingtixingExample example);

    int deleteByExample(YiliaoyaopingtixingExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Yiliaoyaopingtixing record);

    int insertSelective(Yiliaoyaopingtixing record);

    List<Yiliaoyaopingtixing> selectByExample(YiliaoyaopingtixingExample example);

    Yiliaoyaopingtixing selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Yiliaoyaopingtixing record, @Param("example") YiliaoyaopingtixingExample example);

    int updateByExample(@Param("record") Yiliaoyaopingtixing record, @Param("example") YiliaoyaopingtixingExample example);

    int updateByPrimaryKeySelective(Yiliaoyaopingtixing record);

    int updateByPrimaryKey(Yiliaoyaopingtixing record);
}
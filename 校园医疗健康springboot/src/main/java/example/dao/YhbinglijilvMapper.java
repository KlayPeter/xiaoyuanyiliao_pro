package example.dao;

import example.pojo.Yhbinglijilv;
import example.pojo.YhbinglijilvExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface YhbinglijilvMapper {
    long countByExample(YhbinglijilvExample example);

    int deleteByExample(YhbinglijilvExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Yhbinglijilv record);

    int insertSelective(Yhbinglijilv record);

    List<Yhbinglijilv> selectByExample(YhbinglijilvExample example);

    Yhbinglijilv selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Yhbinglijilv record, @Param("example") YhbinglijilvExample example);

    int updateByExample(@Param("record") Yhbinglijilv record, @Param("example") YhbinglijilvExample example);

    int updateByPrimaryKeySelective(Yhbinglijilv record);

    int updateByPrimaryKey(Yhbinglijilv record);
}
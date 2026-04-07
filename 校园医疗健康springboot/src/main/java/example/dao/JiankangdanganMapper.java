package example.dao;

import example.pojo.Jiankangdangan;
import example.pojo.JiankangdanganExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface JiankangdanganMapper {
    long countByExample(JiankangdanganExample example);

    int deleteByExample(JiankangdanganExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Jiankangdangan record);

    int insertSelective(Jiankangdangan record);

    List<Jiankangdangan> selectByExample(JiankangdanganExample example);

    Jiankangdangan selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Jiankangdangan record, @Param("example") JiankangdanganExample example);

    int updateByExample(@Param("record") Jiankangdangan record, @Param("example") JiankangdanganExample example);

    int updateByPrimaryKeySelective(Jiankangdangan record);

    int updateByPrimaryKey(Jiankangdangan record);
}
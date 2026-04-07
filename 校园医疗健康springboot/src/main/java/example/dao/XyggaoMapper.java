package example.dao;

import example.pojo.Xyggao;
import example.pojo.XyggaoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface XyggaoMapper {
    long countByExample(XyggaoExample example);

    int deleteByExample(XyggaoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Xyggao record);

    int insertSelective(Xyggao record);

    List<Xyggao> selectByExample(XyggaoExample example);

    Xyggao selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Xyggao record, @Param("example") XyggaoExample example);

    int updateByExample(@Param("record") Xyggao record, @Param("example") XyggaoExample example);

    int updateByPrimaryKeySelective(Xyggao record);

    int updateByPrimaryKey(Xyggao record);
}
package example.dao;

import example.pojo.Xytijianshixiang;
import example.pojo.XytijianshixiangExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface XytijianshixiangMapper {
    long countByExample(XytijianshixiangExample example);

    int deleteByExample(XytijianshixiangExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Xytijianshixiang record);

    int insertSelective(Xytijianshixiang record);

    List<Xytijianshixiang> selectByExample(XytijianshixiangExample example);

    Xytijianshixiang selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Xytijianshixiang record, @Param("example") XytijianshixiangExample example);

    int updateByExample(@Param("record") Xytijianshixiang record, @Param("example") XytijianshixiangExample example);

    int updateByPrimaryKeySelective(Xytijianshixiang record);

    int updateByPrimaryKey(Xytijianshixiang record);
}
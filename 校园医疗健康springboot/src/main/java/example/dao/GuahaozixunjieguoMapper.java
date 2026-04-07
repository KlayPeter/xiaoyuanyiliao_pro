package example.dao;

import example.pojo.Guahaozixunjieguo;
import example.pojo.GuahaozixunjieguoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GuahaozixunjieguoMapper {
    long countByExample(GuahaozixunjieguoExample example);

    int deleteByExample(GuahaozixunjieguoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Guahaozixunjieguo record);

    int insertSelective(Guahaozixunjieguo record);

    List<Guahaozixunjieguo> selectByExample(GuahaozixunjieguoExample example);

    Guahaozixunjieguo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Guahaozixunjieguo record, @Param("example") GuahaozixunjieguoExample example);

    int updateByExample(@Param("record") Guahaozixunjieguo record, @Param("example") GuahaozixunjieguoExample example);

    int updateByPrimaryKeySelective(Guahaozixunjieguo record);

    int updateByPrimaryKey(Guahaozixunjieguo record);
}
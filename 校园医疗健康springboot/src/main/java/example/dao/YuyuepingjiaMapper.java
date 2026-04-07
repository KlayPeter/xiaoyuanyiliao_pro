package example.dao;

import example.pojo.Yuyuepingjia;
import example.pojo.YuyuepingjiaExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface YuyuepingjiaMapper {
    long countByExample(YuyuepingjiaExample example);

    int deleteByExample(YuyuepingjiaExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Yuyuepingjia record);

    int insertSelective(Yuyuepingjia record);

    List<Yuyuepingjia> selectByExample(YuyuepingjiaExample example);

    Yuyuepingjia selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Yuyuepingjia record, @Param("example") YuyuepingjiaExample example);

    int updateByExample(@Param("record") Yuyuepingjia record, @Param("example") YuyuepingjiaExample example);

    int updateByPrimaryKeySelective(Yuyuepingjia record);

    int updateByPrimaryKey(Yuyuepingjia record);
}
package example.dao;

import example.pojo.Yuyueduihua;
import example.pojo.YuyueduihuaExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface YuyueduihuaMapper {
    long countByExample(YuyueduihuaExample example);

    int deleteByExample(YuyueduihuaExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Yuyueduihua record);

    int insertSelective(Yuyueduihua record);

    List<Yuyueduihua> selectByExample(YuyueduihuaExample example);

    Yuyueduihua selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Yuyueduihua record, @Param("example") YuyueduihuaExample example);

    int updateByExample(@Param("record") Yuyueduihua record, @Param("example") YuyueduihuaExample example);

    int updateByPrimaryKeySelective(Yuyueduihua record);

    int updateByPrimaryKey(Yuyueduihua record);
}
package example.service;

import example.dao.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import example.pojo.*;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class YuyueduihuaServiceImpl {

    private Logger logger = LoggerFactory.getLogger(YuyueduihuaServiceImpl.class);

    @Autowired
    private YuyueduihuaMapper yuyueduihuaDao;


//====================Json=====================

    public void addYuyueduihuaJson(HttpServletRequest request, HttpSession session,HashMap<String,Object> map_result) {
        logger.info("进入addYuyueduihuaJson方法...");
    }

    //处理预约对话的添加操作
    public void addYuyueduihuaactJson(HttpServletRequest request, HttpSession session,Yuyueduihua yuyueduihua,HashMap<String,Object> map_result) {
        logger.info("进入addYuyueduihuaactJson方法...");

        int state = yuyueduihuaDao.insert(yuyueduihua);
        //根据state判断操作是否成功
        if (state == 0){
            map_result.put("message", "添加预约对话失败");
            return;
        }
        map_result.put("message", "添加预约对话成功");

    }

    //处理预约对话的删除操作
    public void deleteYuyueduihuaJson(HttpServletRequest request, HttpSession session,Integer id,HashMap<String,Object> map_result) {
        logger.info("进入deleteBookJson方法...");

        int state = yuyueduihuaDao.deleteByPrimaryKey(id);
        //根据state判断操作是否成功
        if (state == 0){
            map_result.put("message", "删除预约对话失败");
            return;
        }
        map_result.put("message", "删除预约对话成功");

    }

    public void updateYuyueduihuaJson(HttpServletRequest request, HttpSession session,Integer id,HashMap<String,Object> map_result) {
        logger.info("进入updateYuyueduihuaJson方法...");

        Yuyueduihua yuyueduihua = yuyueduihuaDao.selectByPrimaryKey(id);
        map_result.put("yuyueduihua", yuyueduihua);


    }

    //处理预约对话的修改操作
    public void updateYuyueduihuaactJson(HttpServletRequest request, HttpSession session,Yuyueduihua yuyueduihua,HashMap<String,Object> map_result) {
        logger.info("进入updateYuyueduihuaactJson方法...");

        int state = yuyueduihuaDao.updateByPrimaryKey(yuyueduihua);
        //根据state判断操作是否成功
        if (state == 0){
            map_result.put("message", "修改预约对话失败");
            return;
        }
        map_result.put("message", "修改预约对话成功");
    }

    //处理预约对话的查看操作
    public void yuyueduihuaListJson(HttpServletRequest request, HttpSession session, HashMap<String,Object> map_result) {
        logger.info("进入yuyueduihuaListJosn方法...");

        YuyueduihuaExample yuyueduihuaExample = new YuyueduihuaExample();
        String search = request.getParameter("search");
        if (search == null){
            search = "";
        }
        yuyueduihuaExample.createCriteria().andXyyiliaopaibanyuyueLike("%" + search + "%");
        List<Yuyueduihua> yuyueduihuas = yuyueduihuaDao.selectByExample(yuyueduihuaExample);
        map_result.put("yuyueduihuas", yuyueduihuas);
    }






}

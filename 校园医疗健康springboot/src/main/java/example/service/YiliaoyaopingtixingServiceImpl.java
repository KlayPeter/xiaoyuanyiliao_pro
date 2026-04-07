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
public class YiliaoyaopingtixingServiceImpl {

    private Logger logger = LoggerFactory.getLogger(YiliaoyaopingtixingServiceImpl.class);

    @Autowired
    private YiliaoyaopingtixingMapper yiliaoyaopingtixingDao;


//====================Json=====================

    public void addYiliaoyaopingtixingJson(HttpServletRequest request, HttpSession session,HashMap<String,Object> map_result) {
        logger.info("进入addYiliaoyaopingtixingJson方法...");
    }

    //处理药品采购提醒的添加操作
    public void addYiliaoyaopingtixingactJson(HttpServletRequest request, HttpSession session,Yiliaoyaopingtixing yiliaoyaopingtixing,HashMap<String,Object> map_result) {
        logger.info("进入addYiliaoyaopingtixingactJson方法...");

        int state = yiliaoyaopingtixingDao.insert(yiliaoyaopingtixing);
        //根据state判断操作是否成功
        if (state == 0){
            map_result.put("message", "添加药品采购提醒失败");
            return;
        }
        map_result.put("message", "添加药品采购提醒成功");

    }

    //处理药品采购提醒的删除操作
    public void deleteYiliaoyaopingtixingJson(HttpServletRequest request, HttpSession session,Integer id,HashMap<String,Object> map_result) {
        logger.info("进入deleteBookJson方法...");

        int state = yiliaoyaopingtixingDao.deleteByPrimaryKey(id);
        //根据state判断操作是否成功
        if (state == 0){
            map_result.put("message", "删除药品采购提醒失败");
            return;
        }
        map_result.put("message", "删除药品采购提醒成功");

    }

    public void updateYiliaoyaopingtixingJson(HttpServletRequest request, HttpSession session,Integer id,HashMap<String,Object> map_result) {
        logger.info("进入updateYiliaoyaopingtixingJson方法...");

        Yiliaoyaopingtixing yiliaoyaopingtixing = yiliaoyaopingtixingDao.selectByPrimaryKey(id);
        map_result.put("yiliaoyaopingtixing", yiliaoyaopingtixing);


    }

    //处理药品采购提醒的修改操作
    public void updateYiliaoyaopingtixingactJson(HttpServletRequest request, HttpSession session,Yiliaoyaopingtixing yiliaoyaopingtixing,HashMap<String,Object> map_result) {
        logger.info("进入updateYiliaoyaopingtixingactJson方法...");

        int state = yiliaoyaopingtixingDao.updateByPrimaryKey(yiliaoyaopingtixing);
        //根据state判断操作是否成功
        if (state == 0){
            map_result.put("message", "修改药品采购提醒失败");
            return;
        }
        map_result.put("message", "修改药品采购提醒成功");
    }

    //处理药品采购提醒的查看操作
    public void yiliaoyaopingtixingListJson(HttpServletRequest request, HttpSession session, HashMap<String,Object> map_result) {
        logger.info("进入yiliaoyaopingtixingListJosn方法...");

        YiliaoyaopingtixingExample yiliaoyaopingtixingExample = new YiliaoyaopingtixingExample();
        String search = request.getParameter("search");
        if (search == null){
            search = "";
        }
        yiliaoyaopingtixingExample.createCriteria().andCaigoutLike("%" + search + "%");
        List<Yiliaoyaopingtixing> yiliaoyaopingtixings = yiliaoyaopingtixingDao.selectByExample(yiliaoyaopingtixingExample);
        map_result.put("yiliaoyaopingtixings", yiliaoyaopingtixings);
    }






}

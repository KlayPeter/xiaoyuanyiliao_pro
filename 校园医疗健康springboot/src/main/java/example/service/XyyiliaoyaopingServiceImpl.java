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
public class XyyiliaoyaopingServiceImpl {

    private Logger logger = LoggerFactory.getLogger(XyyiliaoyaopingServiceImpl.class);

    @Autowired
    private XyyiliaoyaopingMapper xyyiliaoyaopingDao;


//====================Json=====================

    public void addXyyiliaoyaopingJson(HttpServletRequest request, HttpSession session,HashMap<String,Object> map_result) {
        logger.info("进入addXyyiliaoyaopingJson方法...");
    }

    //处理校园医疗药品的添加操作
    public void addXyyiliaoyaopingactJson(HttpServletRequest request, HttpSession session,Xyyiliaoyaoping xyyiliaoyaoping,HashMap<String,Object> map_result) {
        logger.info("进入addXyyiliaoyaopingactJson方法...");

        int state = xyyiliaoyaopingDao.insert(xyyiliaoyaoping);
        //根据state判断操作是否成功
        if (state == 0){
            map_result.put("message", "添加校园医疗药品失败");
            return;
        }
        map_result.put("message", "添加校园医疗药品成功");

    }

    //处理校园医疗药品的删除操作
    public void deleteXyyiliaoyaopingJson(HttpServletRequest request, HttpSession session,Integer id,HashMap<String,Object> map_result) {
        logger.info("进入deleteBookJson方法...");

        int state = xyyiliaoyaopingDao.deleteByPrimaryKey(id);
        //根据state判断操作是否成功
        if (state == 0){
            map_result.put("message", "删除校园医疗药品失败");
            return;
        }
        map_result.put("message", "删除校园医疗药品成功");

    }

    public void updateXyyiliaoyaopingJson(HttpServletRequest request, HttpSession session,Integer id,HashMap<String,Object> map_result) {
        logger.info("进入updateXyyiliaoyaopingJson方法...");

        Xyyiliaoyaoping xyyiliaoyaoping = xyyiliaoyaopingDao.selectByPrimaryKey(id);
        map_result.put("xyyiliaoyaoping", xyyiliaoyaoping);


    }

    //处理校园医疗药品的修改操作
    public void updateXyyiliaoyaopingactJson(HttpServletRequest request, HttpSession session,Xyyiliaoyaoping xyyiliaoyaoping,HashMap<String,Object> map_result) {
        logger.info("进入updateXyyiliaoyaopingactJson方法...");

        int state = xyyiliaoyaopingDao.updateByPrimaryKey(xyyiliaoyaoping);
        //根据state判断操作是否成功
        if (state == 0){
            map_result.put("message", "修改校园医疗药品失败");
            return;
        }
        map_result.put("message", "修改校园医疗药品成功");
    }

    //处理校园医疗药品的查看操作
    public void xyyiliaoyaopingListJson(HttpServletRequest request, HttpSession session, HashMap<String,Object> map_result) {
        logger.info("进入xyyiliaoyaopingListJosn方法...");

        XyyiliaoyaopingExample xyyiliaoyaopingExample = new XyyiliaoyaopingExample();
        String search = request.getParameter("search");
        if (search == null){
            search = "";
        }
        xyyiliaoyaopingExample.createCriteria().andDrugnameLike("%" + search + "%");
        List<Xyyiliaoyaoping> xyyiliaoyaopings = xyyiliaoyaopingDao.selectByExample(xyyiliaoyaopingExample);
        map_result.put("xyyiliaoyaopings", xyyiliaoyaopings);
    }






}

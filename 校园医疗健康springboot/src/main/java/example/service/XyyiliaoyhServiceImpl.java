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
public class XyyiliaoyhServiceImpl {

    private Logger logger = LoggerFactory.getLogger(XyyiliaoyhServiceImpl.class);

    @Autowired
    private XyyiliaoyhMapper xyyiliaoyhDao;


//====================Json=====================
        public void xyyiliaoyhIndexJson(HttpServletRequest request, HttpSession session,HashMap<String,Object> map_result) {
            logger.info("进入xyyiliaoyhIndexJson方法...");
        }

        public void xyyiliaoyhUpdateIndexJson(HttpServletRequest request, HttpSession session,Xyyiliaoyh xyyiliaoyh,HashMap<String,Object> map_result) {
            logger.info("进入xyyiliaoyhUpdateIndexJson方法...");

            int state = xyyiliaoyhDao.updateByPrimaryKey(xyyiliaoyh);
            //根据state判断操作是否成功
            if (state == 0){
                map_result.put("message", "更新失败");
                return;
            }
            map_result.put("message", "更新成功");
            //更新服务端session状态
            session.setAttribute("userinfo", xyyiliaoyh);
        }

    public void addXyyiliaoyhJson(HttpServletRequest request, HttpSession session,HashMap<String,Object> map_result) {
        logger.info("进入addXyyiliaoyhJson方法...");
    }

    //处理校园用户的添加操作
    public void addXyyiliaoyhactJson(HttpServletRequest request, HttpSession session,Xyyiliaoyh xyyiliaoyh,HashMap<String,Object> map_result) {
        logger.info("进入addXyyiliaoyhactJson方法...");

        int state = xyyiliaoyhDao.insert(xyyiliaoyh);
        //根据state判断操作是否成功
        if (state == 0){
            map_result.put("message", "添加校园用户失败");
            return;
        }
        map_result.put("message", "添加校园用户成功");

    }

    //处理校园用户的删除操作
    public void deleteXyyiliaoyhJson(HttpServletRequest request, HttpSession session,Integer id,HashMap<String,Object> map_result) {
        logger.info("进入deleteBookJson方法...");

        int state = xyyiliaoyhDao.deleteByPrimaryKey(id);
        //根据state判断操作是否成功
        if (state == 0){
            map_result.put("message", "删除校园用户失败");
            return;
        }
        map_result.put("message", "删除校园用户成功");

    }

    public void updateXyyiliaoyhJson(HttpServletRequest request, HttpSession session,Integer id,HashMap<String,Object> map_result) {
        logger.info("进入updateXyyiliaoyhJson方法...");

        Xyyiliaoyh xyyiliaoyh = xyyiliaoyhDao.selectByPrimaryKey(id);
        map_result.put("xyyiliaoyh", xyyiliaoyh);


    }

    //处理校园用户的修改操作
    public void updateXyyiliaoyhactJson(HttpServletRequest request, HttpSession session,Xyyiliaoyh xyyiliaoyh,HashMap<String,Object> map_result) {
        logger.info("进入updateXyyiliaoyhactJson方法...");

        int state = xyyiliaoyhDao.updateByPrimaryKey(xyyiliaoyh);
        //根据state判断操作是否成功
        if (state == 0){
            map_result.put("message", "修改校园用户失败");
            return;
        }
        map_result.put("message", "修改校园用户成功");
    }

    //处理校园用户的查看操作
    public void xyyiliaoyhListJson(HttpServletRequest request, HttpSession session, HashMap<String,Object> map_result) {
        logger.info("进入xyyiliaoyhListJosn方法...");

        XyyiliaoyhExample xyyiliaoyhExample = new XyyiliaoyhExample();
        String search = request.getParameter("search");
        if (search == null){
            search = "";
        }
        xyyiliaoyhExample.createCriteria().andUsernameLike("%" + search + "%");
        List<Xyyiliaoyh> xyyiliaoyhs = xyyiliaoyhDao.selectByExample(xyyiliaoyhExample);
        map_result.put("xyyiliaoyhs", xyyiliaoyhs);
    }






}

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
public class TijianyhyuyueServiceImpl {

    private Logger logger = LoggerFactory.getLogger(TijianyhyuyueServiceImpl.class);

    @Autowired
    private TijianyhyuyueMapper tijianyhyuyueDao;

            @Autowired
            private XyyiliaoyhMapper xyyiliaoyhDao;

//====================Json=====================

    public void addTijianyhyuyueJson(HttpServletRequest request, HttpSession session,HashMap<String,Object> map_result) {
        logger.info("进入addTijianyhyuyueJson方法...");
                XyyiliaoyhExample xyyiliaoyhExample = new XyyiliaoyhExample();

                List<Xyyiliaoyh> xyyiliaoyhs = xyyiliaoyhDao.selectByExample(xyyiliaoyhExample);

                map_result.put("xyyiliaoyhs", xyyiliaoyhs);
    }

    //处理体检用户预约的添加操作
    public void addTijianyhyuyueactJson(HttpServletRequest request, HttpSession session,Tijianyhyuyue tijianyhyuyue,HashMap<String,Object> map_result) {
        logger.info("进入addTijianyhyuyueactJson方法...");

        int state = tijianyhyuyueDao.insert(tijianyhyuyue);
        //根据state判断操作是否成功
        if (state == 0){
            map_result.put("message", "添加体检用户预约失败");
            return;
        }
        map_result.put("message", "添加体检用户预约成功");

    }

    //处理体检用户预约的删除操作
    public void deleteTijianyhyuyueJson(HttpServletRequest request, HttpSession session,Integer id,HashMap<String,Object> map_result) {
        logger.info("进入deleteBookJson方法...");

        int state = tijianyhyuyueDao.deleteByPrimaryKey(id);
        //根据state判断操作是否成功
        if (state == 0){
            map_result.put("message", "删除体检用户预约失败");
            return;
        }
        map_result.put("message", "删除体检用户预约成功");

    }

    public void updateTijianyhyuyueJson(HttpServletRequest request, HttpSession session,Integer id,HashMap<String,Object> map_result) {
        logger.info("进入updateTijianyhyuyueJson方法...");

        Tijianyhyuyue tijianyhyuyue = tijianyhyuyueDao.selectByPrimaryKey(id);
        map_result.put("tijianyhyuyue", tijianyhyuyue);

                XyyiliaoyhExample xyyiliaoyhExample = new XyyiliaoyhExample();

                List<Xyyiliaoyh> xyyiliaoyhs = xyyiliaoyhDao.selectByExample(xyyiliaoyhExample);

                map_result.put("xyyiliaoyhs", xyyiliaoyhs);

    }

    //处理体检用户预约的修改操作
    public void updateTijianyhyuyueactJson(HttpServletRequest request, HttpSession session,Tijianyhyuyue tijianyhyuyue,HashMap<String,Object> map_result) {
        logger.info("进入updateTijianyhyuyueactJson方法...");

        int state = tijianyhyuyueDao.updateByPrimaryKey(tijianyhyuyue);
        //根据state判断操作是否成功
        if (state == 0){
            map_result.put("message", "修改体检用户预约失败");
            return;
        }
        map_result.put("message", "修改体检用户预约成功");
    }

    //处理体检用户预约的查看操作
    public void tijianyhyuyueListJson(HttpServletRequest request, HttpSession session, HashMap<String,Object> map_result) {
        logger.info("进入tijianyhyuyueListJosn方法...");

        TijianyhyuyueExample tijianyhyuyueExample = new TijianyhyuyueExample();
        String search = request.getParameter("search");
        if (search == null){
            search = "";
        }
        tijianyhyuyueExample.createCriteria().andXytijianshixiangLike("%" + search + "%");
        List<Tijianyhyuyue> tijianyhyuyues = tijianyhyuyueDao.selectByExample(tijianyhyuyueExample);
        map_result.put("tijianyhyuyues", tijianyhyuyues);
    }



            public void xyyiliaoyhAddTijianyhyuyueJson(HttpServletRequest request, HttpSession session,HashMap<String,Object> map_result) {
                logger.info("进入xyyiliaoyhAddTijianyhyuyueJson方法...");
                        XyyiliaoyhExample xyyiliaoyhExample = new XyyiliaoyhExample();

                        List<Xyyiliaoyh> xyyiliaoyhs = xyyiliaoyhDao.selectByExample(xyyiliaoyhExample);

                        map_result.put("xyyiliaoyhs", xyyiliaoyhs);
            }

            //xyyiliaoyh处理体检用户预约的添加操作
            public void xyyiliaoyhAddTijianyhyuyueactJson(HttpServletRequest request, HttpSession session, Tijianyhyuyue tijianyhyuyue,HashMap<String,Object> map_result) {
                logger.info("进入xyyiliaoyhAddTijianyhyuyueactJson方法...");

                //检查是不是已经预约过本次的体检
                TijianyhyuyueExample tijianyhyuyueExample = new TijianyhyuyueExample();
                tijianyhyuyueExample.createCriteria().andXytijianshixiangidEqualTo(tijianyhyuyue.getXytijianshixiangid()).andXyyiliaoyhidEqualTo(tijianyhyuyue.getXyyiliaoyhid());
                List<Tijianyhyuyue> tijianyhyuyues = tijianyhyuyueDao.selectByExample(tijianyhyuyueExample);
                if (tijianyhyuyues.size()>0){
                    map_result.put("message","已预约过");
                    return;
                }

                int state = tijianyhyuyueDao.insert(tijianyhyuyue);
                //根据state判断操作是否成功
                if (state == 0) {
                    map_result.put("message", "添加体检用户预约失败");
                    return;
                }
                map_result.put("message", "预约成功");
            }

            //xyyiliaoyh处理体检用户预约的删除操作
            public void xyyiliaoyhDeleteTijianyhyuyueJson(HttpServletRequest request, HttpSession session, Integer id,HashMap<String,Object> map_result) {
                logger.info("进入xyyiliaoyhDeleteTijianyhyuyueJson方法...");

                int state = tijianyhyuyueDao.deleteByPrimaryKey(id);
                //根据state判断操作是否成功
                if (state == 0) {
                    map_result.put("message", "删除体检用户预约失败");
                    return;
                }
                map_result.put("message", "删除体检用户预约成功");
            }

            public void xyyiliaoyhUpdateTijianyhyuyueJson(HttpServletRequest request, HttpSession session, Integer id,HashMap<String,Object> map_result) {
                logger.info("进入userUpdateBookJson方法...");

                Tijianyhyuyue tijianyhyuyue = tijianyhyuyueDao.selectByPrimaryKey(id);
                map_result.put("tijianyhyuyue", tijianyhyuyue);

                        XyyiliaoyhExample xyyiliaoyhExample = new XyyiliaoyhExample();

                        List<Xyyiliaoyh> xyyiliaoyhs = xyyiliaoyhDao.selectByExample(xyyiliaoyhExample);

                        map_result.put("xyyiliaoyhs", xyyiliaoyhs);

            }

            //xyyiliaoyh处理体检用户预约的修改操作
            public void xyyiliaoyhUpdateTijianyhyuyueactJson(HttpServletRequest request, HttpSession session, Tijianyhyuyue tijianyhyuyue,HashMap<String,Object> map_result) {
                logger.info("进入xyyiliaoyhUpdateTijianyhyuyue方法...");

                int state = tijianyhyuyueDao.updateByPrimaryKey(tijianyhyuyue);
                //根据state判断操作是否成功
                if (state == 0) {
                    map_result.put("message", "修改体检用户预约失败");
                    return;
                }
                map_result.put("message", "修改体检用户预约成功");
            }

            //xyyiliaoyh处理体检用户预约的查看操作
            public void xyyiliaoyhTijianyhyuyueListJson(HttpServletRequest request, HttpSession session,HashMap<String,Object> map_result) {
                logger.info("进入xyyiliaoyh体检用户预约ListJson方法...");
                String search = request.getParameter("search");
                if (search == null){
                    search = "";
                }
                TijianyhyuyueExample tijianyhyuyueExample = new TijianyhyuyueExample();
                tijianyhyuyueExample.createCriteria().andXyyiliaoyhidEqualTo(((Xyyiliaoyh) session.getAttribute("userinfo")).getId()).andXytijianshixiangLike("%"+search+"%");
                List<Tijianyhyuyue> tijianyhyuyues = tijianyhyuyueDao.selectByExample(tijianyhyuyueExample);
                map_result.put("tijianyhyuyues", tijianyhyuyues);
            }



}

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
public class XyyiliaopaibanyuyueServiceImpl {

    private Logger logger = LoggerFactory.getLogger(XyyiliaopaibanyuyueServiceImpl.class);

    @Autowired
    private XyyiliaopaibanyuyueMapper xyyiliaopaibanyuyueDao;

            @Autowired
            private XiaoyuanyishengMapper xiaoyuanyishengDao;
            @Autowired
            private XyyiliaoyhMapper xyyiliaoyhDao;

//====================Json=====================

    public void addXyyiliaopaibanyuyueJson(HttpServletRequest request, HttpSession session,HashMap<String,Object> map_result) {
        logger.info("进入addXyyiliaopaibanyuyueJson方法...");
                XiaoyuanyishengExample xiaoyuanyishengExample = new XiaoyuanyishengExample();

                List<Xiaoyuanyisheng> xiaoyuanyishengs = xiaoyuanyishengDao.selectByExample(xiaoyuanyishengExample);

                map_result.put("xiaoyuanyishengs", xiaoyuanyishengs);
                XyyiliaoyhExample xyyiliaoyhExample = new XyyiliaoyhExample();

                List<Xyyiliaoyh> xyyiliaoyhs = xyyiliaoyhDao.selectByExample(xyyiliaoyhExample);

                map_result.put("xyyiliaoyhs", xyyiliaoyhs);
    }

    //处理校园医疗排班预约的添加操作
    public void addXyyiliaopaibanyuyueactJson(HttpServletRequest request, HttpSession session,Xyyiliaopaibanyuyue xyyiliaopaibanyuyue,HashMap<String,Object> map_result) {
        logger.info("进入addXyyiliaopaibanyuyueactJson方法...");

        int state = xyyiliaopaibanyuyueDao.insert(xyyiliaopaibanyuyue);
        //根据state判断操作是否成功
        if (state == 0){
            map_result.put("message", "添加校园医疗排班预约失败");
            return;
        }
        map_result.put("message", "添加校园医疗排班预约成功");

    }

    //处理校园医疗排班预约的删除操作
    public void deleteXyyiliaopaibanyuyueJson(HttpServletRequest request, HttpSession session,Integer id,HashMap<String,Object> map_result) {
        logger.info("进入deleteBookJson方法...");

        int state = xyyiliaopaibanyuyueDao.deleteByPrimaryKey(id);
        //根据state判断操作是否成功
        if (state == 0){
            map_result.put("message", "删除校园医疗排班预约失败");
            return;
        }
        map_result.put("message", "删除校园医疗排班预约成功");

    }

    public void updateXyyiliaopaibanyuyueJson(HttpServletRequest request, HttpSession session,Integer id,HashMap<String,Object> map_result) {
        logger.info("进入updateXyyiliaopaibanyuyueJson方法...");

        Xyyiliaopaibanyuyue xyyiliaopaibanyuyue = xyyiliaopaibanyuyueDao.selectByPrimaryKey(id);
        map_result.put("xyyiliaopaibanyuyue", xyyiliaopaibanyuyue);

                XiaoyuanyishengExample xiaoyuanyishengExample = new XiaoyuanyishengExample();

                List<Xiaoyuanyisheng> xiaoyuanyishengs = xiaoyuanyishengDao.selectByExample(xiaoyuanyishengExample);

                map_result.put("xiaoyuanyishengs", xiaoyuanyishengs);
                XyyiliaoyhExample xyyiliaoyhExample = new XyyiliaoyhExample();

                List<Xyyiliaoyh> xyyiliaoyhs = xyyiliaoyhDao.selectByExample(xyyiliaoyhExample);

                map_result.put("xyyiliaoyhs", xyyiliaoyhs);

    }

    //处理校园医疗排班预约的修改操作
    public void updateXyyiliaopaibanyuyueactJson(HttpServletRequest request, HttpSession session,Xyyiliaopaibanyuyue xyyiliaopaibanyuyue,HashMap<String,Object> map_result) {
        logger.info("进入updateXyyiliaopaibanyuyueactJson方法...");

        int state = xyyiliaopaibanyuyueDao.updateByPrimaryKey(xyyiliaopaibanyuyue);
        //根据state判断操作是否成功
        if (state == 0){
            map_result.put("message", "修改校园医疗排班预约失败");
            return;
        }
        map_result.put("message", "修改校园医疗排班预约成功");
    }

    //处理校园医疗排班预约的查看操作
    public void xyyiliaopaibanyuyueListJson(HttpServletRequest request, HttpSession session, HashMap<String,Object> map_result) {
        logger.info("进入xyyiliaopaibanyuyueListJosn方法...");

        XyyiliaopaibanyuyueExample xyyiliaopaibanyuyueExample = new XyyiliaopaibanyuyueExample();
        String search = request.getParameter("search");
        if (search == null){
            search = "";
        }
        xyyiliaopaibanyuyueExample.createCriteria().andJianyaowentiLike("%" + search + "%");
        List<Xyyiliaopaibanyuyue> xyyiliaopaibanyuyues = xyyiliaopaibanyuyueDao.selectByExample(xyyiliaopaibanyuyueExample);
        map_result.put("xyyiliaopaibanyuyues", xyyiliaopaibanyuyues);
    }



            public void xiaoyuanyishengAddXyyiliaopaibanyuyueJson(HttpServletRequest request, HttpSession session,HashMap<String,Object> map_result) {
                logger.info("进入xiaoyuanyishengAddXyyiliaopaibanyuyueJson方法...");
                        XiaoyuanyishengExample xiaoyuanyishengExample = new XiaoyuanyishengExample();

                        List<Xiaoyuanyisheng> xiaoyuanyishengs = xiaoyuanyishengDao.selectByExample(xiaoyuanyishengExample);

                        map_result.put("xiaoyuanyishengs", xiaoyuanyishengs);
                        XyyiliaoyhExample xyyiliaoyhExample = new XyyiliaoyhExample();

                        List<Xyyiliaoyh> xyyiliaoyhs = xyyiliaoyhDao.selectByExample(xyyiliaoyhExample);

                        map_result.put("xyyiliaoyhs", xyyiliaoyhs);
            }

            //xiaoyuanyisheng处理校园医疗排班预约的添加操作
            public void xiaoyuanyishengAddXyyiliaopaibanyuyueactJson(HttpServletRequest request, HttpSession session, Xyyiliaopaibanyuyue xyyiliaopaibanyuyue,HashMap<String,Object> map_result) {
                logger.info("进入xiaoyuanyishengAddXyyiliaopaibanyuyueactJson方法...");

                int state = xyyiliaopaibanyuyueDao.insert(xyyiliaopaibanyuyue);
                //根据state判断操作是否成功
                if (state == 0) {
                    map_result.put("message", "添加校园医疗排班预约失败");
                    return;
                }
                map_result.put("message", "添加校园医疗排班预约成功");
            }

            //xiaoyuanyisheng处理校园医疗排班预约的删除操作
            public void xiaoyuanyishengDeleteXyyiliaopaibanyuyueJson(HttpServletRequest request, HttpSession session, Integer id,HashMap<String,Object> map_result) {
                logger.info("进入xiaoyuanyishengDeleteXyyiliaopaibanyuyueJson方法...");

                int state = xyyiliaopaibanyuyueDao.deleteByPrimaryKey(id);
                //根据state判断操作是否成功
                if (state == 0) {
                    map_result.put("message", "删除校园医疗排班预约失败");
                    return;
                }
                map_result.put("message", "删除校园医疗排班预约成功");
            }

            public void xiaoyuanyishengUpdateXyyiliaopaibanyuyueJson(HttpServletRequest request, HttpSession session, Integer id,HashMap<String,Object> map_result) {
                logger.info("进入userUpdateBookJson方法...");

                Xyyiliaopaibanyuyue xyyiliaopaibanyuyue = xyyiliaopaibanyuyueDao.selectByPrimaryKey(id);
                map_result.put("xyyiliaopaibanyuyue", xyyiliaopaibanyuyue);

                        XiaoyuanyishengExample xiaoyuanyishengExample = new XiaoyuanyishengExample();

                        List<Xiaoyuanyisheng> xiaoyuanyishengs = xiaoyuanyishengDao.selectByExample(xiaoyuanyishengExample);

                        map_result.put("xiaoyuanyishengs", xiaoyuanyishengs);
                        XyyiliaoyhExample xyyiliaoyhExample = new XyyiliaoyhExample();

                        List<Xyyiliaoyh> xyyiliaoyhs = xyyiliaoyhDao.selectByExample(xyyiliaoyhExample);

                        map_result.put("xyyiliaoyhs", xyyiliaoyhs);

            }

            //xiaoyuanyisheng处理校园医疗排班预约的修改操作
            public void xiaoyuanyishengUpdateXyyiliaopaibanyuyueactJson(HttpServletRequest request, HttpSession session, Xyyiliaopaibanyuyue xyyiliaopaibanyuyue,HashMap<String,Object> map_result) {
                logger.info("进入xiaoyuanyishengUpdateXyyiliaopaibanyuyue方法...");

                int state = xyyiliaopaibanyuyueDao.updateByPrimaryKey(xyyiliaopaibanyuyue);
                //根据state判断操作是否成功
                if (state == 0) {
                    map_result.put("message", "修改校园医疗排班预约失败");
                    return;
                }
                map_result.put("message", "修改校园医疗排班预约成功");
            }

            //xiaoyuanyisheng处理校园医疗排班预约的查看操作
            public void xiaoyuanyishengXyyiliaopaibanyuyueListJson(HttpServletRequest request, HttpSession session,HashMap<String,Object> map_result) {
                logger.info("进入xiaoyuanyisheng校园医疗排班预约ListJson方法...");
                String search = request.getParameter("search");
                if (search == null){
                    search = "";
                }
                XyyiliaopaibanyuyueExample xyyiliaopaibanyuyueExample = new XyyiliaopaibanyuyueExample();
                xyyiliaopaibanyuyueExample.createCriteria().andXiaoyuanyishengidEqualTo(((Xiaoyuanyisheng) session.getAttribute("userinfo")).getId()).andJianyaowentiLike("%"+search+"%");
                List<Xyyiliaopaibanyuyue> xyyiliaopaibanyuyues = xyyiliaopaibanyuyueDao.selectByExample(xyyiliaopaibanyuyueExample);
                map_result.put("xyyiliaopaibanyuyues", xyyiliaopaibanyuyues);
            }
            public void xyyiliaoyhAddXyyiliaopaibanyuyueJson(HttpServletRequest request, HttpSession session,HashMap<String,Object> map_result) {
                logger.info("进入xyyiliaoyhAddXyyiliaopaibanyuyueJson方法...");
                        XiaoyuanyishengExample xiaoyuanyishengExample = new XiaoyuanyishengExample();

                        List<Xiaoyuanyisheng> xiaoyuanyishengs = xiaoyuanyishengDao.selectByExample(xiaoyuanyishengExample);

                        map_result.put("xiaoyuanyishengs", xiaoyuanyishengs);
                        XyyiliaoyhExample xyyiliaoyhExample = new XyyiliaoyhExample();

                        List<Xyyiliaoyh> xyyiliaoyhs = xyyiliaoyhDao.selectByExample(xyyiliaoyhExample);

                        map_result.put("xyyiliaoyhs", xyyiliaoyhs);
            }

            //xyyiliaoyh处理校园医疗排班预约的添加操作
            public void xyyiliaoyhAddXyyiliaopaibanyuyueactJson(HttpServletRequest request, HttpSession session, Xyyiliaopaibanyuyue xyyiliaopaibanyuyue,HashMap<String,Object> map_result) {
                logger.info("进入xyyiliaoyhAddXyyiliaopaibanyuyueactJson方法...");

                int state = xyyiliaopaibanyuyueDao.insert(xyyiliaopaibanyuyue);
                //根据state判断操作是否成功
                if (state == 0) {
                    map_result.put("message", "添加校园医疗排班预约失败");
                    return;
                }
                map_result.put("message", "添加校园医疗排班预约成功");
            }

            //xyyiliaoyh处理校园医疗排班预约的删除操作
            public void xyyiliaoyhDeleteXyyiliaopaibanyuyueJson(HttpServletRequest request, HttpSession session, Integer id,HashMap<String,Object> map_result) {
                logger.info("进入xyyiliaoyhDeleteXyyiliaopaibanyuyueJson方法...");

                int state = xyyiliaopaibanyuyueDao.deleteByPrimaryKey(id);
                //根据state判断操作是否成功
                if (state == 0) {
                    map_result.put("message", "删除校园医疗排班预约失败");
                    return;
                }
                map_result.put("message", "删除校园医疗排班预约成功");
            }

            public void xyyiliaoyhUpdateXyyiliaopaibanyuyueJson(HttpServletRequest request, HttpSession session, Integer id,HashMap<String,Object> map_result) {
                logger.info("进入userUpdateBookJson方法...");

                Xyyiliaopaibanyuyue xyyiliaopaibanyuyue = xyyiliaopaibanyuyueDao.selectByPrimaryKey(id);
                map_result.put("xyyiliaopaibanyuyue", xyyiliaopaibanyuyue);

                        XiaoyuanyishengExample xiaoyuanyishengExample = new XiaoyuanyishengExample();

                        List<Xiaoyuanyisheng> xiaoyuanyishengs = xiaoyuanyishengDao.selectByExample(xiaoyuanyishengExample);

                        map_result.put("xiaoyuanyishengs", xiaoyuanyishengs);
                        XyyiliaoyhExample xyyiliaoyhExample = new XyyiliaoyhExample();

                        List<Xyyiliaoyh> xyyiliaoyhs = xyyiliaoyhDao.selectByExample(xyyiliaoyhExample);

                        map_result.put("xyyiliaoyhs", xyyiliaoyhs);

            }

            //xyyiliaoyh处理校园医疗排班预约的修改操作
            public void xyyiliaoyhUpdateXyyiliaopaibanyuyueactJson(HttpServletRequest request, HttpSession session, Xyyiliaopaibanyuyue xyyiliaopaibanyuyue,HashMap<String,Object> map_result) {
                logger.info("进入xyyiliaoyhUpdateXyyiliaopaibanyuyue方法...");

                int state = xyyiliaopaibanyuyueDao.updateByPrimaryKey(xyyiliaopaibanyuyue);
                //根据state判断操作是否成功
                if (state == 0) {
                    map_result.put("message", "修改校园医疗排班预约失败");
                    return;
                }
                map_result.put("message", "修改校园医疗排班预约成功");
            }

            //xyyiliaoyh处理校园医疗排班预约的查看操作
            public void xyyiliaoyhXyyiliaopaibanyuyueListJson(HttpServletRequest request, HttpSession session,HashMap<String,Object> map_result) {
                logger.info("进入xyyiliaoyh校园医疗排班预约ListJson方法...");
                String search = request.getParameter("search");
                if (search == null){
                    search = "";
                }
                XyyiliaopaibanyuyueExample xyyiliaopaibanyuyueExample = new XyyiliaopaibanyuyueExample();
                xyyiliaopaibanyuyueExample.createCriteria().andXyyiliaoyhidEqualTo(((Xyyiliaoyh) session.getAttribute("userinfo")).getId()).andJianyaowentiLike("%"+search+"%");
                List<Xyyiliaopaibanyuyue> xyyiliaopaibanyuyues = xyyiliaopaibanyuyueDao.selectByExample(xyyiliaopaibanyuyueExample);
                map_result.put("xyyiliaopaibanyuyues", xyyiliaopaibanyuyues);
            }



}

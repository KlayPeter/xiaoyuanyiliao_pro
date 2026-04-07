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
public class XyyiliaopaibanServiceImpl {

    private Logger logger = LoggerFactory.getLogger(XyyiliaopaibanServiceImpl.class);

    @Autowired
    private XyyiliaopaibanMapper xyyiliaopaibanDao;

            @Autowired
            private XiaoyuanyishengMapper xiaoyuanyishengDao;

//====================Json=====================

    public void addXyyiliaopaibanJson(HttpServletRequest request, HttpSession session,HashMap<String,Object> map_result) {
        logger.info("进入addXyyiliaopaibanJson方法...");
                XiaoyuanyishengExample xiaoyuanyishengExample = new XiaoyuanyishengExample();

                List<Xiaoyuanyisheng> xiaoyuanyishengs = xiaoyuanyishengDao.selectByExample(xiaoyuanyishengExample);

                map_result.put("xiaoyuanyishengs", xiaoyuanyishengs);
    }

    //处理校园医疗排班的添加操作
    public void addXyyiliaopaibanactJson(HttpServletRequest request, HttpSession session,Xyyiliaopaiban xyyiliaopaiban,HashMap<String,Object> map_result) {
        logger.info("进入addXyyiliaopaibanactJson方法...");

        XyyiliaopaibanExample xyyiliaopaibanExample = new XyyiliaopaibanExample();
        xyyiliaopaibanExample.createCriteria().andYuefenEqualTo(xyyiliaopaiban.getYuefen()).andXiaoyuanyishengidEqualTo(xyyiliaopaiban.getXiaoyuanyishengid());
        List<Xyyiliaopaiban> xyyiliaopaibans = xyyiliaopaibanDao.selectByExample(xyyiliaopaibanExample);
        if (xyyiliaopaibans.size()>0){
            map_result.put("message","本月已安排该医生");
            return;
        }
        int state = xyyiliaopaibanDao.insert(xyyiliaopaiban);
        //根据state判断操作是否成功
        if (state == 0){
            map_result.put("message", "添加校园医疗排班失败");
            return;
        }
        map_result.put("message", "添加校园医疗排班成功");

    }

    //处理校园医疗排班的删除操作
    public void deleteXyyiliaopaibanJson(HttpServletRequest request, HttpSession session,Integer id,HashMap<String,Object> map_result) {
        logger.info("进入deleteBookJson方法...");

        int state = xyyiliaopaibanDao.deleteByPrimaryKey(id);
        //根据state判断操作是否成功
        if (state == 0){
            map_result.put("message", "删除校园医疗排班失败");
            return;
        }
        map_result.put("message", "删除校园医疗排班成功");

    }

    public void updateXyyiliaopaibanJson(HttpServletRequest request, HttpSession session,Integer id,HashMap<String,Object> map_result) {
        logger.info("进入updateXyyiliaopaibanJson方法...");

        Xyyiliaopaiban xyyiliaopaiban = xyyiliaopaibanDao.selectByPrimaryKey(id);
        map_result.put("xyyiliaopaiban", xyyiliaopaiban);

                XiaoyuanyishengExample xiaoyuanyishengExample = new XiaoyuanyishengExample();

                List<Xiaoyuanyisheng> xiaoyuanyishengs = xiaoyuanyishengDao.selectByExample(xiaoyuanyishengExample);

                map_result.put("xiaoyuanyishengs", xiaoyuanyishengs);

    }

    //处理校园医疗排班的修改操作
    public void updateXyyiliaopaibanactJson(HttpServletRequest request, HttpSession session,Xyyiliaopaiban xyyiliaopaiban,HashMap<String,Object> map_result) {
        logger.info("进入updateXyyiliaopaibanactJson方法...");

        XyyiliaopaibanExample xyyiliaopaibanExample = new XyyiliaopaibanExample();
        xyyiliaopaibanExample.createCriteria().andYuefenEqualTo(xyyiliaopaiban.getYuefen()).andXiaoyuanyishengidEqualTo(xyyiliaopaiban.getXiaoyuanyishengid());
        List<Xyyiliaopaiban> xyyiliaopaibans = xyyiliaopaibanDao.selectByExample(xyyiliaopaibanExample);
        if (xyyiliaopaibans.size()>0){
            map_result.put("message","本月已安排该医生");
            return;
        }
        int state = xyyiliaopaibanDao.updateByPrimaryKey(xyyiliaopaiban);
        //根据state判断操作是否成功
        if (state == 0){
            map_result.put("message", "修改校园医疗排班失败");
            return;
        }
        map_result.put("message", "修改校园医疗排班成功");
    }

    //处理校园医疗排班的查看操作
    public void xyyiliaopaibanListJson(HttpServletRequest request, HttpSession session, HashMap<String,Object> map_result) {
        logger.info("进入xyyiliaopaibanListJosn方法...");

        XyyiliaopaibanExample xyyiliaopaibanExample = new XyyiliaopaibanExample();
        String search = request.getParameter("search");
        if (search == null){
            search = "";
        }
        xyyiliaopaibanExample.createCriteria().andYuefenLike("%" + search + "%");
        List<Xyyiliaopaiban> xyyiliaopaibans = xyyiliaopaibanDao.selectByExample(xyyiliaopaibanExample);
        map_result.put("xyyiliaopaibans", xyyiliaopaibans);
    }



            public void xiaoyuanyishengAddXyyiliaopaibanJson(HttpServletRequest request, HttpSession session,HashMap<String,Object> map_result) {
                logger.info("进入xiaoyuanyishengAddXyyiliaopaibanJson方法...");
                        XiaoyuanyishengExample xiaoyuanyishengExample = new XiaoyuanyishengExample();

                        List<Xiaoyuanyisheng> xiaoyuanyishengs = xiaoyuanyishengDao.selectByExample(xiaoyuanyishengExample);

                        map_result.put("xiaoyuanyishengs", xiaoyuanyishengs);
            }

            //xiaoyuanyisheng处理校园医疗排班的添加操作
            public void xiaoyuanyishengAddXyyiliaopaibanactJson(HttpServletRequest request, HttpSession session, Xyyiliaopaiban xyyiliaopaiban,HashMap<String,Object> map_result) {
                logger.info("进入xiaoyuanyishengAddXyyiliaopaibanactJson方法...");

                int state = xyyiliaopaibanDao.insert(xyyiliaopaiban);
                //根据state判断操作是否成功
                if (state == 0) {
                    map_result.put("message", "添加校园医疗排班失败");
                    return;
                }
                map_result.put("message", "添加校园医疗排班成功");
            }

            //xiaoyuanyisheng处理校园医疗排班的删除操作
            public void xiaoyuanyishengDeleteXyyiliaopaibanJson(HttpServletRequest request, HttpSession session, Integer id,HashMap<String,Object> map_result) {
                logger.info("进入xiaoyuanyishengDeleteXyyiliaopaibanJson方法...");

                int state = xyyiliaopaibanDao.deleteByPrimaryKey(id);
                //根据state判断操作是否成功
                if (state == 0) {
                    map_result.put("message", "删除校园医疗排班失败");
                    return;
                }
                map_result.put("message", "删除校园医疗排班成功");
            }

            public void xiaoyuanyishengUpdateXyyiliaopaibanJson(HttpServletRequest request, HttpSession session, Integer id,HashMap<String,Object> map_result) {
                logger.info("进入userUpdateBookJson方法...");

                Xyyiliaopaiban xyyiliaopaiban = xyyiliaopaibanDao.selectByPrimaryKey(id);
                map_result.put("xyyiliaopaiban", xyyiliaopaiban);

                        XiaoyuanyishengExample xiaoyuanyishengExample = new XiaoyuanyishengExample();

                        List<Xiaoyuanyisheng> xiaoyuanyishengs = xiaoyuanyishengDao.selectByExample(xiaoyuanyishengExample);

                        map_result.put("xiaoyuanyishengs", xiaoyuanyishengs);

            }

            //xiaoyuanyisheng处理校园医疗排班的修改操作
            public void xiaoyuanyishengUpdateXyyiliaopaibanactJson(HttpServletRequest request, HttpSession session, Xyyiliaopaiban xyyiliaopaiban,HashMap<String,Object> map_result) {
                logger.info("进入xiaoyuanyishengUpdateXyyiliaopaiban方法...");

                int state = xyyiliaopaibanDao.updateByPrimaryKey(xyyiliaopaiban);
                //根据state判断操作是否成功
                if (state == 0) {
                    map_result.put("message", "修改校园医疗排班失败");
                    return;
                }
                map_result.put("message", "修改校园医疗排班成功");
            }

            //xiaoyuanyisheng处理校园医疗排班的查看操作
            public void xiaoyuanyishengXyyiliaopaibanListJson(HttpServletRequest request, HttpSession session,HashMap<String,Object> map_result) {
                logger.info("进入xiaoyuanyisheng校园医疗排班ListJson方法...");
                String search = request.getParameter("search");
                if (search == null){
                    search = "";
                }
                XyyiliaopaibanExample xyyiliaopaibanExample = new XyyiliaopaibanExample();
                xyyiliaopaibanExample.createCriteria().andXiaoyuanyishengidEqualTo(((Xiaoyuanyisheng) session.getAttribute("userinfo")).getId()).andYuefenLike("%"+search+"%");
                List<Xyyiliaopaiban> xyyiliaopaibans = xyyiliaopaibanDao.selectByExample(xyyiliaopaibanExample);
                map_result.put("xyyiliaopaibans", xyyiliaopaibans);
            }



}

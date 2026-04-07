package example.service;

import example.dao.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.mail.MailProperties;
import org.springframework.stereotype.Service;
import example.pojo.*;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class GuahaozixunjieguoServiceImpl {

    private Logger logger = LoggerFactory.getLogger(GuahaozixunjieguoServiceImpl.class);

    @Autowired
    private GuahaozixunjieguoMapper guahaozixunjieguoDao;


//====================Json=====================

    public void addGuahaozixunjieguoJson(HttpServletRequest request, HttpSession session,HashMap<String,Object> map_result) {
        logger.info("进入addGuahaozixunjieguoJson方法...");
    }

    //处理挂号咨询结果的添加操作
    public void addGuahaozixunjieguoactJson(HttpServletRequest request, HttpSession session,Guahaozixunjieguo guahaozixunjieguo,HashMap<String,Object> map_result) {
        logger.info("进入addGuahaozixunjieguoactJson方法...");

        int state = guahaozixunjieguoDao.insert(guahaozixunjieguo);
        //根据state判断操作是否成功
        if (state == 0){
            map_result.put("message", "添加挂号咨询结果失败");
            return;
        }
        map_result.put("message", "添加挂号咨询结果成功");

    }

    //处理挂号咨询结果的删除操作
    public void deleteGuahaozixunjieguoJson(HttpServletRequest request, HttpSession session,Integer id,HashMap<String,Object> map_result) {
        logger.info("进入deleteBookJson方法...");

        int state = guahaozixunjieguoDao.deleteByPrimaryKey(id);
        //根据state判断操作是否成功
        if (state == 0){
            map_result.put("message", "删除挂号咨询结果失败");
            return;
        }
        map_result.put("message", "删除挂号咨询结果成功");

    }

    public void updateGuahaozixunjieguoJson(HttpServletRequest request, HttpSession session,Integer id,HashMap<String,Object> map_result) {
        logger.info("进入updateGuahaozixunjieguoJson方法...");

        Guahaozixunjieguo guahaozixunjieguo = guahaozixunjieguoDao.selectByPrimaryKey(id);
        map_result.put("guahaozixunjieguo", guahaozixunjieguo);


    }

    //处理挂号咨询结果的修改操作
    public void updateGuahaozixunjieguoactJson(HttpServletRequest request, HttpSession session,Guahaozixunjieguo guahaozixunjieguo,HashMap<String,Object> map_result) {
        logger.info("进入updateGuahaozixunjieguoactJson方法...");

        int state = guahaozixunjieguoDao.updateByPrimaryKey(guahaozixunjieguo);
        //根据state判断操作是否成功
        if (state == 0){
            map_result.put("message", "修改挂号咨询结果失败");
            return;
        }
        map_result.put("message", "修改挂号咨询结果成功");
    }

    //处理挂号咨询结果的查看操作
    public void guahaozixunjieguoListJson(HttpServletRequest request, HttpSession session, HashMap<String,Object> map_result) {
        logger.info("进入guahaozixunjieguoListJosn方法...");

        GuahaozixunjieguoExample guahaozixunjieguoExample = new GuahaozixunjieguoExample();
        String search = request.getParameter("search");
        if (search == null){
            search = "";
        }
        guahaozixunjieguoExample.createCriteria().andKaifangtimeLike("%" + search + "%");
        List<Guahaozixunjieguo> guahaozixunjieguos = guahaozixunjieguoDao.selectByExample(guahaozixunjieguoExample);
        map_result.put("guahaozixunjieguos", guahaozixunjieguos);
    }

    @Autowired
    XyyiliaoyaopingMapper xyyiliaoyaopingMapper;


            public void xiaoyuanyishengAddGuahaozixunjieguoJson(HttpServletRequest request, HttpSession session,HashMap<String,Object> map_result) {
                logger.info("进入xiaoyuanyishengAddGuahaozixunjieguoJson方法...");

                List<Xyyiliaoyaoping> xyyiliaoyaopings = xyyiliaoyaopingMapper.selectByExample(new XyyiliaoyaopingExample());
                map_result.put("xyyiliaoyaopings",xyyiliaoyaopings);

            }

            @Autowired
            XyyiliaopaibanyuyueMapper xyyiliaopaibanyuyueMapper;

            //xiaoyuanyisheng处理挂号咨询结果的添加操作
            public void xiaoyuanyishengAddGuahaozixunjieguoactJson(HttpServletRequest request, HttpSession session, Guahaozixunjieguo guahaozixunjieguo,HashMap<String,Object> map_result) {
                logger.info("进入xiaoyuanyishengAddGuahaozixunjieguoactJson方法...");

                Xyyiliaopaibanyuyue xyyiliaopaibanyuyue = xyyiliaopaibanyuyueMapper.selectByPrimaryKey(guahaozixunjieguo.getXyyiliaopaibanyuyueid());
                xyyiliaopaibanyuyue.setState("已开方");
                xyyiliaopaibanyuyueMapper.updateByPrimaryKey(xyyiliaopaibanyuyue);

                int state = guahaozixunjieguoDao.insert(guahaozixunjieguo);
                //根据state判断操作是否成功
                if (state == 0) {
                    map_result.put("message", "添加挂号咨询结果失败");
                    return;
                }
                map_result.put("message", "添加挂号咨询结果成功");
            }

            //xiaoyuanyisheng处理挂号咨询结果的删除操作
            public void xiaoyuanyishengDeleteGuahaozixunjieguoJson(HttpServletRequest request, HttpSession session, Integer id,HashMap<String,Object> map_result) {
                logger.info("进入xiaoyuanyishengDeleteGuahaozixunjieguoJson方法...");

                int state = guahaozixunjieguoDao.deleteByPrimaryKey(id);
                //根据state判断操作是否成功
                if (state == 0) {
                    map_result.put("message", "删除挂号咨询结果失败");
                    return;
                }
                map_result.put("message", "删除挂号咨询结果成功");
            }

            public void xiaoyuanyishengUpdateGuahaozixunjieguoJson(HttpServletRequest request, HttpSession session, Integer id,HashMap<String,Object> map_result) {
                logger.info("进入userUpdateBookJson方法...");

                Guahaozixunjieguo guahaozixunjieguo = guahaozixunjieguoDao.selectByPrimaryKey(id);
                map_result.put("guahaozixunjieguo", guahaozixunjieguo);


            }

            //xiaoyuanyisheng处理挂号咨询结果的修改操作
            public void xiaoyuanyishengUpdateGuahaozixunjieguoactJson(HttpServletRequest request, HttpSession session, Guahaozixunjieguo guahaozixunjieguo,HashMap<String,Object> map_result) {
                logger.info("进入xiaoyuanyishengUpdateGuahaozixunjieguo方法...");

                int state = guahaozixunjieguoDao.updateByPrimaryKey(guahaozixunjieguo);
                //根据state判断操作是否成功
                if (state == 0) {
                    map_result.put("message", "修改挂号咨询结果失败");
                    return;
                }
                map_result.put("message", "修改挂号咨询结果成功");
            }

            //xiaoyuanyisheng处理挂号咨询结果的查看操作
            public void xiaoyuanyishengGuahaozixunjieguoListJson(HttpServletRequest request, HttpSession session,HashMap<String,Object> map_result) {
                logger.info("进入xiaoyuanyisheng挂号咨询结果ListJson方法...");
                String search = request.getParameter("search");
                if (search == null){
                    search = "";
                }
                GuahaozixunjieguoExample guahaozixunjieguoExample = new GuahaozixunjieguoExample();
                guahaozixunjieguoExample.createCriteria().andXiaoyuanyishengidEqualTo(((Xiaoyuanyisheng) session.getAttribute("userinfo")).getId()).andKaifangtimeLike("%"+search+"%");
                List<Guahaozixunjieguo> guahaozixunjieguos = guahaozixunjieguoDao.selectByExample(guahaozixunjieguoExample);
                map_result.put("guahaozixunjieguos", guahaozixunjieguos);
            }
            public void xyyiliaoyhAddGuahaozixunjieguoJson(HttpServletRequest request, HttpSession session,HashMap<String,Object> map_result) {
                logger.info("进入xyyiliaoyhAddGuahaozixunjieguoJson方法...");
            }

            //xyyiliaoyh处理挂号咨询结果的添加操作
            public void xyyiliaoyhAddGuahaozixunjieguoactJson(HttpServletRequest request, HttpSession session, Guahaozixunjieguo guahaozixunjieguo,HashMap<String,Object> map_result) {
                logger.info("进入xyyiliaoyhAddGuahaozixunjieguoactJson方法...");

                int state = guahaozixunjieguoDao.insert(guahaozixunjieguo);
                //根据state判断操作是否成功
                if (state == 0) {
                    map_result.put("message", "添加挂号咨询结果失败");
                    return;
                }
                map_result.put("message", "添加挂号咨询结果成功");
            }

            //xyyiliaoyh处理挂号咨询结果的删除操作
            public void xyyiliaoyhDeleteGuahaozixunjieguoJson(HttpServletRequest request, HttpSession session, Integer id,HashMap<String,Object> map_result) {
                logger.info("进入xyyiliaoyhDeleteGuahaozixunjieguoJson方法...");

                int state = guahaozixunjieguoDao.deleteByPrimaryKey(id);
                //根据state判断操作是否成功
                if (state == 0) {
                    map_result.put("message", "删除挂号咨询结果失败");
                    return;
                }
                map_result.put("message", "删除挂号咨询结果成功");
            }

            public void xyyiliaoyhUpdateGuahaozixunjieguoJson(HttpServletRequest request, HttpSession session, Integer id,HashMap<String,Object> map_result) {
                logger.info("进入userUpdateBookJson方法...");

                Guahaozixunjieguo guahaozixunjieguo = guahaozixunjieguoDao.selectByPrimaryKey(id);
                map_result.put("guahaozixunjieguo", guahaozixunjieguo);


            }

            //xyyiliaoyh处理挂号咨询结果的修改操作
            public void xyyiliaoyhUpdateGuahaozixunjieguoactJson(HttpServletRequest request, HttpSession session, Guahaozixunjieguo guahaozixunjieguo,HashMap<String,Object> map_result) {
                logger.info("进入xyyiliaoyhUpdateGuahaozixunjieguo方法...");

                int state = guahaozixunjieguoDao.updateByPrimaryKey(guahaozixunjieguo);
                //根据state判断操作是否成功
                if (state == 0) {
                    map_result.put("message", "修改挂号咨询结果失败");
                    return;
                }
                map_result.put("message", "修改挂号咨询结果成功");
            }

            //xyyiliaoyh处理挂号咨询结果的查看操作
            public void xyyiliaoyhGuahaozixunjieguoListJson(HttpServletRequest request, HttpSession session,HashMap<String,Object> map_result) {
                logger.info("进入xyyiliaoyh挂号咨询结果ListJson方法...");
                String search = request.getParameter("search");
                if (search == null){
                    search = "";
                }
                GuahaozixunjieguoExample guahaozixunjieguoExample = new GuahaozixunjieguoExample();
                guahaozixunjieguoExample.createCriteria().andXyyiliaoyhidEqualTo(((Xyyiliaoyh) session.getAttribute("userinfo")).getId()).andKaifangtimeLike("%"+search+"%");
                List<Guahaozixunjieguo> guahaozixunjieguos = guahaozixunjieguoDao.selectByExample(guahaozixunjieguoExample);
                map_result.put("guahaozixunjieguos", guahaozixunjieguos);
            }



}

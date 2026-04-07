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
public class YuyuepingjiaServiceImpl {

    private Logger logger = LoggerFactory.getLogger(YuyuepingjiaServiceImpl.class);

    @Autowired
    private YuyuepingjiaMapper yuyuepingjiaDao;


//====================Json=====================

    public void addYuyuepingjiaJson(HttpServletRequest request, HttpSession session,HashMap<String,Object> map_result) {
        logger.info("进入addYuyuepingjiaJson方法...");
    }

    //处理预约评价的添加操作
    public void addYuyuepingjiaactJson(HttpServletRequest request, HttpSession session,Yuyuepingjia yuyuepingjia,HashMap<String,Object> map_result) {
        logger.info("进入addYuyuepingjiaactJson方法...");

        int state = yuyuepingjiaDao.insert(yuyuepingjia);
        //根据state判断操作是否成功
        if (state == 0){
            map_result.put("message", "添加预约评价失败");
            return;
        }
        map_result.put("message", "添加预约评价成功");

    }

    //处理预约评价的删除操作
    public void deleteYuyuepingjiaJson(HttpServletRequest request, HttpSession session,Integer id,HashMap<String,Object> map_result) {
        logger.info("进入deleteBookJson方法...");

        int state = yuyuepingjiaDao.deleteByPrimaryKey(id);
        //根据state判断操作是否成功
        if (state == 0){
            map_result.put("message", "删除预约评价失败");
            return;
        }
        map_result.put("message", "删除预约评价成功");

    }

    public void updateYuyuepingjiaJson(HttpServletRequest request, HttpSession session,Integer id,HashMap<String,Object> map_result) {
        logger.info("进入updateYuyuepingjiaJson方法...");

        Yuyuepingjia yuyuepingjia = yuyuepingjiaDao.selectByPrimaryKey(id);
        map_result.put("yuyuepingjia", yuyuepingjia);


    }

    //处理预约评价的修改操作
    public void updateYuyuepingjiaactJson(HttpServletRequest request, HttpSession session,Yuyuepingjia yuyuepingjia,HashMap<String,Object> map_result) {
        logger.info("进入updateYuyuepingjiaactJson方法...");

        int state = yuyuepingjiaDao.updateByPrimaryKey(yuyuepingjia);
        //根据state判断操作是否成功
        if (state == 0){
            map_result.put("message", "修改预约评价失败");
            return;
        }
        map_result.put("message", "修改预约评价成功");
    }

    //处理预约评价的查看操作
    public void yuyuepingjiaListJson(HttpServletRequest request, HttpSession session, HashMap<String,Object> map_result) {
        logger.info("进入yuyuepingjiaListJosn方法...");

        YuyuepingjiaExample yuyuepingjiaExample = new YuyuepingjiaExample();
        String search = request.getParameter("search");
        if (search == null){
            search = "";
        }
        yuyuepingjiaExample.createCriteria().andXyyiliaopaibanyuyueLike("%" + search + "%");
        List<Yuyuepingjia> yuyuepingjias = yuyuepingjiaDao.selectByExample(yuyuepingjiaExample);
        map_result.put("yuyuepingjias", yuyuepingjias);
    }



            public void xyyiliaoyhAddYuyuepingjiaJson(HttpServletRequest request, HttpSession session,HashMap<String,Object> map_result) {
                logger.info("进入xyyiliaoyhAddYuyuepingjiaJson方法...");
            }

            @Autowired
            XyyiliaopaibanyuyueMapper xyyiliaopaibanyuyueMapper;

            //xyyiliaoyh处理预约评价的添加操作
            public void xyyiliaoyhAddYuyuepingjiaactJson(HttpServletRequest request, HttpSession session, Yuyuepingjia yuyuepingjia,HashMap<String,Object> map_result) {
                logger.info("进入xyyiliaoyhAddYuyuepingjiaactJson方法...");

                Xyyiliaopaibanyuyue xyyiliaopaibanyuyue = xyyiliaopaibanyuyueMapper.selectByPrimaryKey(yuyuepingjia.getXyyiliaopaibanyuyueid());
                xyyiliaopaibanyuyue.setState("已评价");
                xyyiliaopaibanyuyueMapper.updateByPrimaryKey(xyyiliaopaibanyuyue);
                int state = yuyuepingjiaDao.insert(yuyuepingjia);
                //根据state判断操作是否成功
                if (state == 0) {
                    map_result.put("message", "添加预约评价失败");
                    return;
                }
                map_result.put("message", "添加预约评价成功");
            }

            //xyyiliaoyh处理预约评价的删除操作
            public void xyyiliaoyhDeleteYuyuepingjiaJson(HttpServletRequest request, HttpSession session, Integer id,HashMap<String,Object> map_result) {
                logger.info("进入xyyiliaoyhDeleteYuyuepingjiaJson方法...");

                int state = yuyuepingjiaDao.deleteByPrimaryKey(id);
                //根据state判断操作是否成功
                if (state == 0) {
                    map_result.put("message", "删除预约评价失败");
                    return;
                }
                map_result.put("message", "删除预约评价成功");
            }

            public void xyyiliaoyhUpdateYuyuepingjiaJson(HttpServletRequest request, HttpSession session, Integer id,HashMap<String,Object> map_result) {
                logger.info("进入userUpdateBookJson方法...");

                Yuyuepingjia yuyuepingjia = yuyuepingjiaDao.selectByPrimaryKey(id);
                map_result.put("yuyuepingjia", yuyuepingjia);


            }

            //xyyiliaoyh处理预约评价的修改操作
            public void xyyiliaoyhUpdateYuyuepingjiaactJson(HttpServletRequest request, HttpSession session, Yuyuepingjia yuyuepingjia,HashMap<String,Object> map_result) {
                logger.info("进入xyyiliaoyhUpdateYuyuepingjia方法...");

                int state = yuyuepingjiaDao.updateByPrimaryKey(yuyuepingjia);
                //根据state判断操作是否成功
                if (state == 0) {
                    map_result.put("message", "修改预约评价失败");
                    return;
                }
                map_result.put("message", "修改预约评价成功");
            }

            //xyyiliaoyh处理预约评价的查看操作
            public void xyyiliaoyhYuyuepingjiaListJson(HttpServletRequest request, HttpSession session,HashMap<String,Object> map_result) {
                logger.info("进入xyyiliaoyh预约评价ListJson方法...");
                String search = request.getParameter("search");
                if (search == null){
                    search = "";
                }
                YuyuepingjiaExample yuyuepingjiaExample = new YuyuepingjiaExample();
                yuyuepingjiaExample.createCriteria().andXyyiliaoyhidEqualTo(((Xyyiliaoyh) session.getAttribute("userinfo")).getId()).andXyyiliaopaibanyuyueLike("%"+search+"%");
                List<Yuyuepingjia> yuyuepingjias = yuyuepingjiaDao.selectByExample(yuyuepingjiaExample);
                map_result.put("yuyuepingjias", yuyuepingjias);
            }



}

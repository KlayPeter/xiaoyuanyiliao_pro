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
public class YhbinglijilvServiceImpl {

    private Logger logger = LoggerFactory.getLogger(YhbinglijilvServiceImpl.class);

    @Autowired
    private YhbinglijilvMapper yhbinglijilvDao;


//====================Json=====================

    public void addYhbinglijilvJson(HttpServletRequest request, HttpSession session,HashMap<String,Object> map_result) {
        logger.info("进入addYhbinglijilvJson方法...");
    }

    //处理用户病例记录的添加操作
    public void addYhbinglijilvactJson(HttpServletRequest request, HttpSession session,Yhbinglijilv yhbinglijilv,HashMap<String,Object> map_result) {
        logger.info("进入addYhbinglijilvactJson方法...");

        int state = yhbinglijilvDao.insert(yhbinglijilv);
        //根据state判断操作是否成功
        if (state == 0){
            map_result.put("message", "添加用户病例记录失败");
            return;
        }
        map_result.put("message", "添加用户病例记录成功");

    }

    //处理用户病例记录的删除操作
    public void deleteYhbinglijilvJson(HttpServletRequest request, HttpSession session,Integer id,HashMap<String,Object> map_result) {
        logger.info("进入deleteBookJson方法...");

        int state = yhbinglijilvDao.deleteByPrimaryKey(id);
        //根据state判断操作是否成功
        if (state == 0){
            map_result.put("message", "删除用户病例记录失败");
            return;
        }
        map_result.put("message", "删除用户病例记录成功");

    }

    public void updateYhbinglijilvJson(HttpServletRequest request, HttpSession session,Integer id,HashMap<String,Object> map_result) {
        logger.info("进入updateYhbinglijilvJson方法...");

        Yhbinglijilv yhbinglijilv = yhbinglijilvDao.selectByPrimaryKey(id);
        map_result.put("yhbinglijilv", yhbinglijilv);


    }

    //处理用户病例记录的修改操作
    public void updateYhbinglijilvactJson(HttpServletRequest request, HttpSession session,Yhbinglijilv yhbinglijilv,HashMap<String,Object> map_result) {
        logger.info("进入updateYhbinglijilvactJson方法...");

        int state = yhbinglijilvDao.updateByPrimaryKey(yhbinglijilv);
        //根据state判断操作是否成功
        if (state == 0){
            map_result.put("message", "修改用户病例记录失败");
            return;
        }
        map_result.put("message", "修改用户病例记录成功");
    }

    //处理用户病例记录的查看操作
    public void yhbinglijilvListJson(HttpServletRequest request, HttpSession session, HashMap<String,Object> map_result) {
        logger.info("进入yhbinglijilvListJosn方法...");

        YhbinglijilvExample yhbinglijilvExample = new YhbinglijilvExample();
        String search = request.getParameter("search");
        if (search == null){
            search = "";
        }
        yhbinglijilvExample.createCriteria().andJilvtimeLike("%" + search + "%");
        List<Yhbinglijilv> yhbinglijilvs = yhbinglijilvDao.selectByExample(yhbinglijilvExample);
        map_result.put("yhbinglijilvs", yhbinglijilvs);
    }



            public void xyyiliaoyhAddYhbinglijilvJson(HttpServletRequest request, HttpSession session,HashMap<String,Object> map_result) {
                logger.info("进入xyyiliaoyhAddYhbinglijilvJson方法...");
            }

            //xyyiliaoyh处理用户病例记录的添加操作
            public void xyyiliaoyhAddYhbinglijilvactJson(HttpServletRequest request, HttpSession session, Yhbinglijilv yhbinglijilv,HashMap<String,Object> map_result) {
                logger.info("进入xyyiliaoyhAddYhbinglijilvactJson方法...");

                int state = yhbinglijilvDao.insert(yhbinglijilv);
                //根据state判断操作是否成功
                if (state == 0) {
                    map_result.put("message", "添加用户病例记录失败");
                    return;
                }
                map_result.put("message", "添加用户病例记录成功");
            }

            //xyyiliaoyh处理用户病例记录的删除操作
            public void xyyiliaoyhDeleteYhbinglijilvJson(HttpServletRequest request, HttpSession session, Integer id,HashMap<String,Object> map_result) {
                logger.info("进入xyyiliaoyhDeleteYhbinglijilvJson方法...");

                int state = yhbinglijilvDao.deleteByPrimaryKey(id);
                //根据state判断操作是否成功
                if (state == 0) {
                    map_result.put("message", "删除用户病例记录失败");
                    return;
                }
                map_result.put("message", "删除用户病例记录成功");
            }

            public void xyyiliaoyhUpdateYhbinglijilvJson(HttpServletRequest request, HttpSession session, Integer id,HashMap<String,Object> map_result) {
                logger.info("进入userUpdateBookJson方法...");

                Yhbinglijilv yhbinglijilv = yhbinglijilvDao.selectByPrimaryKey(id);
                map_result.put("yhbinglijilv", yhbinglijilv);


            }

            //xyyiliaoyh处理用户病例记录的修改操作
            public void xyyiliaoyhUpdateYhbinglijilvactJson(HttpServletRequest request, HttpSession session, Yhbinglijilv yhbinglijilv,HashMap<String,Object> map_result) {
                logger.info("进入xyyiliaoyhUpdateYhbinglijilv方法...");

                int state = yhbinglijilvDao.updateByPrimaryKey(yhbinglijilv);
                //根据state判断操作是否成功
                if (state == 0) {
                    map_result.put("message", "修改用户病例记录失败");
                    return;
                }
                map_result.put("message", "修改用户病例记录成功");
            }

            //xyyiliaoyh处理用户病例记录的查看操作
            public void xyyiliaoyhYhbinglijilvListJson(HttpServletRequest request, HttpSession session,HashMap<String,Object> map_result) {
                logger.info("进入xyyiliaoyh用户病例记录ListJson方法...");
                String search = request.getParameter("search");
                if (search == null){
                    search = "";
                }
                YhbinglijilvExample yhbinglijilvExample = new YhbinglijilvExample();
                yhbinglijilvExample.createCriteria().andXyyiliaoyhidEqualTo(((Xyyiliaoyh) session.getAttribute("userinfo")).getId()).andJilvtimeLike("%"+search+"%");
                List<Yhbinglijilv> yhbinglijilvs = yhbinglijilvDao.selectByExample(yhbinglijilvExample);
                map_result.put("yhbinglijilvs", yhbinglijilvs);
            }



}

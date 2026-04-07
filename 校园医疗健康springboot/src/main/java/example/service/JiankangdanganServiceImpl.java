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
public class JiankangdanganServiceImpl {

    private Logger logger = LoggerFactory.getLogger(JiankangdanganServiceImpl.class);

    @Autowired
    private JiankangdanganMapper jiankangdanganDao;


//====================Json=====================

    public void addJiankangdanganJson(HttpServletRequest request, HttpSession session,HashMap<String,Object> map_result) {
        logger.info("进入addJiankangdanganJson方法...");
    }

    @Autowired
    TijianyhyuyueMapper tijianyhyuyueMapper;

    //处理健康档案的添加操作
    public void addJiankangdanganactJson(HttpServletRequest request, HttpSession session,Jiankangdangan jiankangdangan,HashMap<String,Object> map_result) {
        logger.info("进入addJiankangdanganactJson方法...");

        Integer yuyueid = Integer.valueOf(request.getParameter("yuyueid"));

        Tijianyhyuyue tijianyhyuyue = tijianyhyuyueMapper.selectByPrimaryKey(yuyueid);
        tijianyhyuyue.setState("已出成绩");
        tijianyhyuyueMapper.updateByPrimaryKey(tijianyhyuyue);

        int state = jiankangdanganDao.insert(jiankangdangan);
        //根据state判断操作是否成功
        if (state == 0){
            map_result.put("message", "添加健康档案失败");
            return;
        }
        map_result.put("message", "添加健康档案成功");

    }

    //处理健康档案的删除操作
    public void deleteJiankangdanganJson(HttpServletRequest request, HttpSession session,Integer id,HashMap<String,Object> map_result) {
        logger.info("进入deleteBookJson方法...");

        int state = jiankangdanganDao.deleteByPrimaryKey(id);
        //根据state判断操作是否成功
        if (state == 0){
            map_result.put("message", "删除健康档案失败");
            return;
        }
        map_result.put("message", "删除健康档案成功");

    }

    public void updateJiankangdanganJson(HttpServletRequest request, HttpSession session,Integer id,HashMap<String,Object> map_result) {
        logger.info("进入updateJiankangdanganJson方法...");

        Jiankangdangan jiankangdangan = jiankangdanganDao.selectByPrimaryKey(id);
        map_result.put("jiankangdangan", jiankangdangan);


    }

    //处理健康档案的修改操作
    public void updateJiankangdanganactJson(HttpServletRequest request, HttpSession session,Jiankangdangan jiankangdangan,HashMap<String,Object> map_result) {
        logger.info("进入updateJiankangdanganactJson方法...");

        int state = jiankangdanganDao.updateByPrimaryKey(jiankangdangan);
        //根据state判断操作是否成功
        if (state == 0){
            map_result.put("message", "修改健康档案失败");
            return;
        }
        map_result.put("message", "修改健康档案成功");
    }

    //处理健康档案的查看操作
    public void jiankangdanganListJson(HttpServletRequest request, HttpSession session, HashMap<String,Object> map_result) {
        logger.info("进入jiankangdanganListJosn方法...");

        JiankangdanganExample jiankangdanganExample = new JiankangdanganExample();
        String search = request.getParameter("search");
        if (search == null){
            search = "";
        }
        jiankangdanganExample.createCriteria().andShijianLike("%" + search + "%");
        List<Jiankangdangan> jiankangdangans = jiankangdanganDao.selectByExample(jiankangdanganExample);
        map_result.put("jiankangdangans", jiankangdangans);
    }



            public void xyyiliaoyhAddJiankangdanganJson(HttpServletRequest request, HttpSession session,HashMap<String,Object> map_result) {
                logger.info("进入xyyiliaoyhAddJiankangdanganJson方法...");
            }

            //xyyiliaoyh处理健康档案的添加操作
            public void xyyiliaoyhAddJiankangdanganactJson(HttpServletRequest request, HttpSession session, Jiankangdangan jiankangdangan,HashMap<String,Object> map_result) {
                logger.info("进入xyyiliaoyhAddJiankangdanganactJson方法...");

                int state = jiankangdanganDao.insert(jiankangdangan);
                //根据state判断操作是否成功
                if (state == 0) {
                    map_result.put("message", "添加健康档案失败");
                    return;
                }
                map_result.put("message", "添加健康档案成功");
            }

            //xyyiliaoyh处理健康档案的删除操作
            public void xyyiliaoyhDeleteJiankangdanganJson(HttpServletRequest request, HttpSession session, Integer id,HashMap<String,Object> map_result) {
                logger.info("进入xyyiliaoyhDeleteJiankangdanganJson方法...");

                int state = jiankangdanganDao.deleteByPrimaryKey(id);
                //根据state判断操作是否成功
                if (state == 0) {
                    map_result.put("message", "删除健康档案失败");
                    return;
                }
                map_result.put("message", "删除健康档案成功");
            }

            public void xyyiliaoyhUpdateJiankangdanganJson(HttpServletRequest request, HttpSession session, Integer id,HashMap<String,Object> map_result) {
                logger.info("进入userUpdateBookJson方法...");

                Jiankangdangan jiankangdangan = jiankangdanganDao.selectByPrimaryKey(id);
                map_result.put("jiankangdangan", jiankangdangan);


            }

            //xyyiliaoyh处理健康档案的修改操作
            public void xyyiliaoyhUpdateJiankangdanganactJson(HttpServletRequest request, HttpSession session, Jiankangdangan jiankangdangan,HashMap<String,Object> map_result) {
                logger.info("进入xyyiliaoyhUpdateJiankangdangan方法...");

                int state = jiankangdanganDao.updateByPrimaryKey(jiankangdangan);
                //根据state判断操作是否成功
                if (state == 0) {
                    map_result.put("message", "修改健康档案失败");
                    return;
                }
                map_result.put("message", "修改健康档案成功");
            }

            //xyyiliaoyh处理健康档案的查看操作
            public void xyyiliaoyhJiankangdanganListJson(HttpServletRequest request, HttpSession session,HashMap<String,Object> map_result) {
                logger.info("进入xyyiliaoyh健康档案ListJson方法...");
                String search = request.getParameter("search");
                if (search == null){
                    search = "";
                }
                JiankangdanganExample jiankangdanganExample = new JiankangdanganExample();
                jiankangdanganExample.createCriteria().andXyyiliaoyhidEqualTo(((Xyyiliaoyh) session.getAttribute("userinfo")).getId()).andShijianLike("%"+search+"%");
                List<Jiankangdangan> jiankangdangans = jiankangdanganDao.selectByExample(jiankangdanganExample);
                map_result.put("jiankangdangans", jiankangdangans);
            }



}

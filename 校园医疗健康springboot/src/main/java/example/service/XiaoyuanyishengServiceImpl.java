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
public class XiaoyuanyishengServiceImpl {

    private Logger logger = LoggerFactory.getLogger(XiaoyuanyishengServiceImpl.class);

    @Autowired
    private XiaoyuanyishengMapper xiaoyuanyishengDao;


//====================Json=====================
        public void xiaoyuanyishengIndexJson(HttpServletRequest request, HttpSession session,HashMap<String,Object> map_result) {
            logger.info("进入xiaoyuanyishengIndexJson方法...");
        }

        public void xiaoyuanyishengUpdateIndexJson(HttpServletRequest request, HttpSession session,Xiaoyuanyisheng xiaoyuanyisheng,HashMap<String,Object> map_result) {
            logger.info("进入xiaoyuanyishengUpdateIndexJson方法...");

            int state = xiaoyuanyishengDao.updateByPrimaryKey(xiaoyuanyisheng);
            //根据state判断操作是否成功
            if (state == 0){
                map_result.put("message", "更新失败");
                return;
            }
            map_result.put("message", "更新成功");
            //更新服务端session状态
            session.setAttribute("userinfo", xiaoyuanyisheng);
        }

    public void addXiaoyuanyishengJson(HttpServletRequest request, HttpSession session,HashMap<String,Object> map_result) {
        logger.info("进入addXiaoyuanyishengJson方法...");
    }

    //处理校园医生的添加操作
    public void addXiaoyuanyishengactJson(HttpServletRequest request, HttpSession session,Xiaoyuanyisheng xiaoyuanyisheng,HashMap<String,Object> map_result) {
        logger.info("进入addXiaoyuanyishengactJson方法...");

        int state = xiaoyuanyishengDao.insert(xiaoyuanyisheng);
        //根据state判断操作是否成功
        if (state == 0){
            map_result.put("message", "添加校园医生失败");
            return;
        }
        map_result.put("message", "添加校园医生成功");

    }

    //处理校园医生的删除操作
    public void deleteXiaoyuanyishengJson(HttpServletRequest request, HttpSession session,Integer id,HashMap<String,Object> map_result) {
        logger.info("进入deleteBookJson方法...");

        int state = xiaoyuanyishengDao.deleteByPrimaryKey(id);
        //根据state判断操作是否成功
        if (state == 0){
            map_result.put("message", "删除校园医生失败");
            return;
        }
        map_result.put("message", "删除校园医生成功");

    }

    public void updateXiaoyuanyishengJson(HttpServletRequest request, HttpSession session,Integer id,HashMap<String,Object> map_result) {
        logger.info("进入updateXiaoyuanyishengJson方法...");

        Xiaoyuanyisheng xiaoyuanyisheng = xiaoyuanyishengDao.selectByPrimaryKey(id);
        map_result.put("xiaoyuanyisheng", xiaoyuanyisheng);


    }

    //处理校园医生的修改操作
    public void updateXiaoyuanyishengactJson(HttpServletRequest request, HttpSession session,Xiaoyuanyisheng xiaoyuanyisheng,HashMap<String,Object> map_result) {
        logger.info("进入updateXiaoyuanyishengactJson方法...");

        int state = xiaoyuanyishengDao.updateByPrimaryKey(xiaoyuanyisheng);
        //根据state判断操作是否成功
        if (state == 0){
            map_result.put("message", "修改校园医生失败");
            return;
        }
        map_result.put("message", "修改校园医生成功");
    }

    //处理校园医生的查看操作
    public void xiaoyuanyishengListJson(HttpServletRequest request, HttpSession session, HashMap<String,Object> map_result) {
        logger.info("进入xiaoyuanyishengListJosn方法...");

        XiaoyuanyishengExample xiaoyuanyishengExample = new XiaoyuanyishengExample();
        String search = request.getParameter("search");
        if (search == null){
            search = "";
        }
        xiaoyuanyishengExample.createCriteria().andUsernameLike("%" + search + "%");
        List<Xiaoyuanyisheng> xiaoyuanyishengs = xiaoyuanyishengDao.selectByExample(xiaoyuanyishengExample);
        map_result.put("xiaoyuanyishengs", xiaoyuanyishengs);
    }



        @Autowired
        XyyiliaopaibanMapper xyyiliaopaibanMapper;

        public void searchXiaoyuanyishengJson(HttpServletRequest request, HttpSession session, String search,HashMap<String,Object> map_result) {
            logger.info("进入searchXiaoyuanyishengJson方法...");

            XiaoyuanyishengExample xiaoyuanyishengExample = new XiaoyuanyishengExample();
            //设置mysql的like搜索
            xiaoyuanyishengExample.createCriteria().andUsernameLike("%" + search + "%");
            // 使用bookDao获得当前搜索的内容
            List<Xiaoyuanyisheng> xiaoyuanyishengs = xiaoyuanyishengDao.selectByExample(xiaoyuanyishengExample);
            map_result.put("xiaoyuanyishengs", xiaoyuanyishengs);

            List<Xyyiliaopaiban> xyyiliaopaibans = xyyiliaopaibanMapper.selectByExample(new XyyiliaopaibanExample());
            map_result.put("xyyiliaopaibans",xyyiliaopaibans);

        }

        public void xiaoyuanyishengDetailsJson(HttpServletRequest request, HttpSession session, Integer id,HashMap<String,Object> map_result) {
            logger.info("进入xiaoyuanyishengDetailsJson方法...");
            // 使用xiaoyuanyishengDao获得对应id的校园医生信息
            Xiaoyuanyisheng xiaoyuanyisheng = xiaoyuanyishengDao.selectByPrimaryKey(id);
            map_result.put("xiaoyuanyisheng", xiaoyuanyisheng);
        }


}

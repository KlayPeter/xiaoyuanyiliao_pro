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
public class XyggaoServiceImpl {

    private Logger logger = LoggerFactory.getLogger(XyggaoServiceImpl.class);

    @Autowired
    private XyggaoMapper xyggaoDao;


//====================Json=====================

    public void addXyggaoJson(HttpServletRequest request, HttpSession session,HashMap<String,Object> map_result) {
        logger.info("进入addXyggaoJson方法...");
    }

    //处理校园公告的添加操作
    public void addXyggaoactJson(HttpServletRequest request, HttpSession session,Xyggao xyggao,HashMap<String,Object> map_result) {
        logger.info("进入addXyggaoactJson方法...");

        int state = xyggaoDao.insert(xyggao);
        //根据state判断操作是否成功
        if (state == 0){
            map_result.put("message", "添加校园公告失败");
            return;
        }
        map_result.put("message", "添加校园公告成功");

    }

    //处理校园公告的删除操作
    public void deleteXyggaoJson(HttpServletRequest request, HttpSession session,Integer id,HashMap<String,Object> map_result) {
        logger.info("进入deleteBookJson方法...");

        int state = xyggaoDao.deleteByPrimaryKey(id);
        //根据state判断操作是否成功
        if (state == 0){
            map_result.put("message", "删除校园公告失败");
            return;
        }
        map_result.put("message", "删除校园公告成功");

    }

    public void updateXyggaoJson(HttpServletRequest request, HttpSession session,Integer id,HashMap<String,Object> map_result) {
        logger.info("进入updateXyggaoJson方法...");

        Xyggao xyggao = xyggaoDao.selectByPrimaryKey(id);
        map_result.put("xyggao", xyggao);


    }

    //处理校园公告的修改操作
    public void updateXyggaoactJson(HttpServletRequest request, HttpSession session,Xyggao xyggao,HashMap<String,Object> map_result) {
        logger.info("进入updateXyggaoactJson方法...");

        int state = xyggaoDao.updateByPrimaryKey(xyggao);
        //根据state判断操作是否成功
        if (state == 0){
            map_result.put("message", "修改校园公告失败");
            return;
        }
        map_result.put("message", "修改校园公告成功");
    }

    //处理校园公告的查看操作
    public void xyggaoListJson(HttpServletRequest request, HttpSession session, HashMap<String,Object> map_result) {
        logger.info("进入xyggaoListJosn方法...");

        XyggaoExample xyggaoExample = new XyggaoExample();
        String search = request.getParameter("search");
        if (search == null){
            search = "";
        }
        xyggaoExample.createCriteria().andXytitleLike("%" + search + "%");
        List<Xyggao> xyggaos = xyggaoDao.selectByExample(xyggaoExample);
        map_result.put("xyggaos", xyggaos);
    }




        public void searchXyggaoJson(HttpServletRequest request, HttpSession session, String search,HashMap<String,Object> map_result) {
            logger.info("进入searchXyggaoJson方法...");

            XyggaoExample xyggaoExample = new XyggaoExample();
            //设置mysql的like搜索
            xyggaoExample.createCriteria().andXytitleLike("%" + search + "%");
            // 使用bookDao获得当前搜索的内容
            List<Xyggao> xyggaos = xyggaoDao.selectByExample(xyggaoExample);
            map_result.put("xyggaos", xyggaos);
        }

        public void xyggaoDetailsJson(HttpServletRequest request, HttpSession session, Integer id,HashMap<String,Object> map_result) {
            logger.info("进入xyggaoDetailsJson方法...");
            // 使用xyggaoDao获得对应id的校园公告信息
            Xyggao xyggao = xyggaoDao.selectByPrimaryKey(id);
            map_result.put("xyggao", xyggao);
        }


}

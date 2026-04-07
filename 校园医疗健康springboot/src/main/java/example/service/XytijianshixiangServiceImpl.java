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
public class XytijianshixiangServiceImpl {

    private Logger logger = LoggerFactory.getLogger(XytijianshixiangServiceImpl.class);

    @Autowired
    private XytijianshixiangMapper xytijianshixiangDao;

    @Autowired
    XiaoyuanyishengMapper xiaoyuanyishengMapper;


//====================Json=====================

    public void addXytijianshixiangJson(HttpServletRequest request, HttpSession session,HashMap<String,Object> map_result) {
        logger.info("进入addXytijianshixiangJson方法...");

        List<Xiaoyuanyisheng> xiaoyuanyishengs = xiaoyuanyishengMapper.selectByExample(new XiaoyuanyishengExample());
        map_result.put("xiaoyuanyishengs",xiaoyuanyishengs);
    }

    //处理校园体检事项的添加操作
    public void addXytijianshixiangactJson(HttpServletRequest request, HttpSession session,Xytijianshixiang xytijianshixiang,HashMap<String,Object> map_result) {
        logger.info("进入addXytijianshixiangactJson方法...");

        int state = xytijianshixiangDao.insert(xytijianshixiang);
        //根据state判断操作是否成功
        if (state == 0){
            map_result.put("message", "添加校园体检事项失败");
            return;
        }
        map_result.put("message", "添加校园体检事项成功");

    }

    //处理校园体检事项的删除操作
    public void deleteXytijianshixiangJson(HttpServletRequest request, HttpSession session,Integer id,HashMap<String,Object> map_result) {
        logger.info("进入deleteBookJson方法...");

        int state = xytijianshixiangDao.deleteByPrimaryKey(id);
        //根据state判断操作是否成功
        if (state == 0){
            map_result.put("message", "删除校园体检事项失败");
            return;
        }
        map_result.put("message", "删除校园体检事项成功");

    }

    public void updateXytijianshixiangJson(HttpServletRequest request, HttpSession session,Integer id,HashMap<String,Object> map_result) {
        logger.info("进入updateXytijianshixiangJson方法...");

        Xytijianshixiang xytijianshixiang = xytijianshixiangDao.selectByPrimaryKey(id);
        map_result.put("xytijianshixiang", xytijianshixiang);

        List<Xiaoyuanyisheng> xiaoyuanyishengs = xiaoyuanyishengMapper.selectByExample(new XiaoyuanyishengExample());
        map_result.put("xiaoyuanyishengs",xiaoyuanyishengs);
    }

    //处理校园体检事项的修改操作
    public void updateXytijianshixiangactJson(HttpServletRequest request, HttpSession session,Xytijianshixiang xytijianshixiang,HashMap<String,Object> map_result) {
        logger.info("进入updateXytijianshixiangactJson方法...");

        int state = xytijianshixiangDao.updateByPrimaryKey(xytijianshixiang);
        //根据state判断操作是否成功
        if (state == 0){
            map_result.put("message", "修改校园体检事项失败");
            return;
        }
        map_result.put("message", "修改校园体检事项成功");
    }

    //处理校园体检事项的查看操作
    public void xytijianshixiangListJson(HttpServletRequest request, HttpSession session, HashMap<String,Object> map_result) {
        logger.info("进入xytijianshixiangListJosn方法...");

        XytijianshixiangExample xytijianshixiangExample = new XytijianshixiangExample();
        String search = request.getParameter("search");
        if (search == null){
            search = "";
        }
        xytijianshixiangExample.createCriteria().andTijiantLike("%" + search + "%");
        List<Xytijianshixiang> xytijianshixiangs = xytijianshixiangDao.selectByExample(xytijianshixiangExample);
        map_result.put("xytijianshixiangs", xytijianshixiangs);
    }



            public void xiaoyuanyishengAddXytijianshixiangJson(HttpServletRequest request, HttpSession session,HashMap<String,Object> map_result) {
                logger.info("进入xiaoyuanyishengAddXytijianshixiangJson方法...");
            }

            //xiaoyuanyisheng处理校园体检事项的添加操作
            public void xiaoyuanyishengAddXytijianshixiangactJson(HttpServletRequest request, HttpSession session, Xytijianshixiang xytijianshixiang,HashMap<String,Object> map_result) {
                logger.info("进入xiaoyuanyishengAddXytijianshixiangactJson方法...");

                int state = xytijianshixiangDao.insert(xytijianshixiang);
                //根据state判断操作是否成功
                if (state == 0) {
                    map_result.put("message", "添加校园体检事项失败");
                    return;
                }
                map_result.put("message", "添加校园体检事项成功");
            }

            //xiaoyuanyisheng处理校园体检事项的删除操作
            public void xiaoyuanyishengDeleteXytijianshixiangJson(HttpServletRequest request, HttpSession session, Integer id,HashMap<String,Object> map_result) {
                logger.info("进入xiaoyuanyishengDeleteXytijianshixiangJson方法...");

                int state = xytijianshixiangDao.deleteByPrimaryKey(id);
                //根据state判断操作是否成功
                if (state == 0) {
                    map_result.put("message", "删除校园体检事项失败");
                    return;
                }
                map_result.put("message", "删除校园体检事项成功");
            }

            public void xiaoyuanyishengUpdateXytijianshixiangJson(HttpServletRequest request, HttpSession session, Integer id,HashMap<String,Object> map_result) {
                logger.info("进入userUpdateBookJson方法...");

                Xytijianshixiang xytijianshixiang = xytijianshixiangDao.selectByPrimaryKey(id);
                map_result.put("xytijianshixiang", xytijianshixiang);


            }

            //xiaoyuanyisheng处理校园体检事项的修改操作
            public void xiaoyuanyishengUpdateXytijianshixiangactJson(HttpServletRequest request, HttpSession session, Xytijianshixiang xytijianshixiang,HashMap<String,Object> map_result) {
                logger.info("进入xiaoyuanyishengUpdateXytijianshixiang方法...");

                int state = xytijianshixiangDao.updateByPrimaryKey(xytijianshixiang);
                //根据state判断操作是否成功
                if (state == 0) {
                    map_result.put("message", "修改校园体检事项失败");
                    return;
                }
                map_result.put("message", "修改校园体检事项成功");
            }

            //xiaoyuanyisheng处理校园体检事项的查看操作
            public void xiaoyuanyishengXytijianshixiangListJson(HttpServletRequest request, HttpSession session,HashMap<String,Object> map_result) {
                logger.info("进入xiaoyuanyisheng校园体检事项ListJson方法...");
                String search = request.getParameter("search");
                if (search == null){
                    search = "";
                }
                XytijianshixiangExample xytijianshixiangExample = new XytijianshixiangExample();
                xytijianshixiangExample.createCriteria().andXiaoyuanyishengidEqualTo(((Xiaoyuanyisheng) session.getAttribute("userinfo")).getId()).andTijiantLike("%"+search+"%");
                List<Xytijianshixiang> xytijianshixiangs = xytijianshixiangDao.selectByExample(xytijianshixiangExample);
                map_result.put("xytijianshixiangs", xytijianshixiangs);
            }

        public void searchXytijianshixiangJson(HttpServletRequest request, HttpSession session, String search,HashMap<String,Object> map_result) {
            logger.info("进入searchXytijianshixiangJson方法...");

            XytijianshixiangExample xytijianshixiangExample = new XytijianshixiangExample();
            //设置mysql的like搜索
            xytijianshixiangExample.createCriteria().andTijiantLike("%" + search + "%");
            // 使用bookDao获得当前搜索的内容
            List<Xytijianshixiang> xytijianshixiangs = xytijianshixiangDao.selectByExample(xytijianshixiangExample);
            map_result.put("xytijianshixiangs", xytijianshixiangs);
        }

        public void xytijianshixiangDetailsJson(HttpServletRequest request, HttpSession session, Integer id,HashMap<String,Object> map_result) {
            logger.info("进入xytijianshixiangDetailsJson方法...");
            // 使用xytijianshixiangDao获得对应id的校园体检事项信息
            Xytijianshixiang xytijianshixiang = xytijianshixiangDao.selectByPrimaryKey(id);
            map_result.put("xytijianshixiang", xytijianshixiang);
        }


}

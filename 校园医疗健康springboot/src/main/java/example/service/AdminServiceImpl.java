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
public class AdminServiceImpl {

    private Logger logger = LoggerFactory.getLogger(AdminServiceImpl.class);

    @Autowired
    private AdminMapper adminDao;


//====================Json=====================
        public void adminIndexJson(HttpServletRequest request, HttpSession session,HashMap<String,Object> map_result) {
            logger.info("进入adminIndexJson方法...");
        }

        public void adminUpdateIndexJson(HttpServletRequest request, HttpSession session,Admin admin,HashMap<String,Object> map_result) {
            logger.info("进入adminUpdateIndexJson方法...");

            int state = adminDao.updateByPrimaryKey(admin);
            //根据state判断操作是否成功
            if (state == 0){
                map_result.put("message", "更新失败");
                return;
            }
            map_result.put("message", "更新成功");
            //更新服务端session状态
            session.setAttribute("userinfo", admin);
        }

    public void addAdminJson(HttpServletRequest request, HttpSession session,HashMap<String,Object> map_result) {
        logger.info("进入addAdminJson方法...");
    }

    //处理管理员的添加操作
    public void addAdminactJson(HttpServletRequest request, HttpSession session,Admin admin,HashMap<String,Object> map_result) {
        logger.info("进入addAdminactJson方法...");

        int state = adminDao.insert(admin);
        //根据state判断操作是否成功
        if (state == 0){
            map_result.put("message", "添加管理员失败");
            return;
        }
        map_result.put("message", "添加管理员成功");

    }

    //处理管理员的删除操作
    public void deleteAdminJson(HttpServletRequest request, HttpSession session,Integer id,HashMap<String,Object> map_result) {
        logger.info("进入deleteBookJson方法...");

        int state = adminDao.deleteByPrimaryKey(id);
        //根据state判断操作是否成功
        if (state == 0){
            map_result.put("message", "删除管理员失败");
            return;
        }
        map_result.put("message", "删除管理员成功");

    }

    public void updateAdminJson(HttpServletRequest request, HttpSession session,Integer id,HashMap<String,Object> map_result) {
        logger.info("进入updateAdminJson方法...");

        Admin admin = adminDao.selectByPrimaryKey(id);
        map_result.put("admin", admin);


    }

    //处理管理员的修改操作
    public void updateAdminactJson(HttpServletRequest request, HttpSession session,Admin admin,HashMap<String,Object> map_result) {
        logger.info("进入updateAdminactJson方法...");

        int state = adminDao.updateByPrimaryKey(admin);
        //根据state判断操作是否成功
        if (state == 0){
            map_result.put("message", "修改管理员失败");
            return;
        }
        map_result.put("message", "修改管理员成功");
    }

    //处理管理员的查看操作
    public void adminListJson(HttpServletRequest request, HttpSession session, HashMap<String,Object> map_result) {
        logger.info("进入adminListJosn方法...");

        AdminExample adminExample = new AdminExample();
        String search = request.getParameter("search");
        if (search == null){
            search = "";
        }
        adminExample.createCriteria().andUsernameLike("%" + search + "%");
        List<Admin> admins = adminDao.selectByExample(adminExample);
        map_result.put("admins", admins);
    }






}

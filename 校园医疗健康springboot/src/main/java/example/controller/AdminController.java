package example.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import example.pojo.*;
import example.service.*;
import example.util.FileUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import java.io.IOException;
import java.util.HashMap;

@Controller()
@RequestMapping("/")
public class AdminController {

private Logger logger = LoggerFactory.getLogger(AdminController.class);

    @Autowired
    AdminServiceImpl adminService;

    //=================Json=======================
        @ResponseBody
        @RequestMapping("adminIndexJson")
        public HashMap adminIndexJson(HttpServletRequest request,HttpServletResponse response,HttpSession session){
            logger.info("请求访问adminIndexJson...");
            HashMap<String, Object> map_result = new HashMap<>();
            //调用服务层
            adminService.adminIndexJson(request, session,map_result);

            return map_result;
        }

        @ResponseBody
        @RequestMapping("adminUpdateIndexJson")
        public HashMap adminUpdateIndexJson(HttpServletRequest request,HttpServletResponse response,HttpSession session,@RequestBody Admin admin){
            logger.info("请求访问adminUpdateIndexJson...");
            HashMap<String, Object> map_result = new HashMap<>();
            //调用服务层
            adminService.adminUpdateIndexJson(request, session, admin,map_result);

            return map_result;
        }


    @ResponseBody
    @RequestMapping("addAdminJson")
    public HashMap addAdminJson(HttpServletRequest request, HttpServletResponse response, HttpSession session){
        logger.info("请求访问addAdminJson...");
        HashMap<String, Object> map_result = new HashMap<>();
        //调用服务层
        adminService.addAdminJson(request, session,map_result);

        return map_result;
    }

    @ResponseBody
    @RequestMapping("addAdminactJson")
    public HashMap addAdminactJson(HttpServletRequest request,HttpServletResponse response,HttpSession session,@RequestBody Admin admin){
        logger.info("请求访问addAdminactJson...");
        HashMap<String, Object> map_result = new HashMap<>();
        //调用服务层
        adminService.addAdminactJson(request, session, admin,map_result);

        return map_result;
    }

    @ResponseBody
    @RequestMapping("deleteAdminJson")
    public HashMap deleteAdminJson(HttpServletRequest request,HttpServletResponse response,HttpSession session,Integer id){
        logger.info("请求访问deleteAdminJson...");
        HashMap<String, Object> map_result = new HashMap<>();
        //调用服务层
        adminService.deleteAdminJson(request, session, id,map_result);

        return map_result;
    }

    @ResponseBody
    @RequestMapping("updateAdminJson")
    public HashMap updateAdminJson(HttpServletRequest request,HttpServletResponse response,HttpSession session,Integer id){
        logger.info("请求访问updateAdminJson...");
        HashMap<String, Object> map_result = new HashMap<>();
        //调用服务层
        adminService.updateAdminJson(request, session,id,map_result);

        return map_result;
    }

    @ResponseBody
    @RequestMapping("updateAdminactJson")
    public HashMap updateAdminactJson(HttpServletRequest request,HttpServletResponse response,HttpSession session,@RequestBody Admin admin){
        logger.info("请求访问updateAdminactJson...");
        HashMap<String, Object> map_result = new HashMap<>();
        //调用服务层
        adminService.updateAdminactJson(request, session, admin,map_result);

        return map_result;
    }

    @ResponseBody
    @RequestMapping("adminListJson")
    public HashMap adminListJson(HttpServletRequest request,HttpServletResponse response,HttpSession session){
        logger.info("请求访问adminListJson...");
        HashMap<String, Object> map_result = new HashMap<>();
        //调用服务层
        adminService.adminListJson(request, session,map_result);

        return map_result;
    }



    // ====================role====================

}

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
public class XiaoyuanyishengController {

private Logger logger = LoggerFactory.getLogger(XiaoyuanyishengController.class);

    @Autowired
    XiaoyuanyishengServiceImpl xiaoyuanyishengService;

    //=================Json=======================
        @ResponseBody
        @RequestMapping("xiaoyuanyishengIndexJson")
        public HashMap xiaoyuanyishengIndexJson(HttpServletRequest request,HttpServletResponse response,HttpSession session){
            logger.info("请求访问xiaoyuanyishengIndexJson...");
            HashMap<String, Object> map_result = new HashMap<>();
            //调用服务层
            xiaoyuanyishengService.xiaoyuanyishengIndexJson(request, session,map_result);

            return map_result;
        }

        @ResponseBody
        @RequestMapping("xiaoyuanyishengUpdateIndexJson")
        public HashMap xiaoyuanyishengUpdateIndexJson(HttpServletRequest request,HttpServletResponse response,HttpSession session,@RequestBody Xiaoyuanyisheng xiaoyuanyisheng){
            logger.info("请求访问xiaoyuanyishengUpdateIndexJson...");
            HashMap<String, Object> map_result = new HashMap<>();
            //调用服务层
            xiaoyuanyishengService.xiaoyuanyishengUpdateIndexJson(request, session, xiaoyuanyisheng,map_result);

            return map_result;
        }


    @ResponseBody
    @RequestMapping("addXiaoyuanyishengJson")
    public HashMap addXiaoyuanyishengJson(HttpServletRequest request, HttpServletResponse response, HttpSession session){
        logger.info("请求访问addXiaoyuanyishengJson...");
        HashMap<String, Object> map_result = new HashMap<>();
        //调用服务层
        xiaoyuanyishengService.addXiaoyuanyishengJson(request, session,map_result);

        return map_result;
    }

    @ResponseBody
    @RequestMapping("addXiaoyuanyishengactJson")
    public HashMap addXiaoyuanyishengactJson(HttpServletRequest request,HttpServletResponse response,HttpSession session,@RequestBody Xiaoyuanyisheng xiaoyuanyisheng){
        logger.info("请求访问addXiaoyuanyishengactJson...");
        HashMap<String, Object> map_result = new HashMap<>();
        //调用服务层
        xiaoyuanyishengService.addXiaoyuanyishengactJson(request, session, xiaoyuanyisheng,map_result);

        return map_result;
    }

    @ResponseBody
    @RequestMapping("deleteXiaoyuanyishengJson")
    public HashMap deleteXiaoyuanyishengJson(HttpServletRequest request,HttpServletResponse response,HttpSession session,Integer id){
        logger.info("请求访问deleteXiaoyuanyishengJson...");
        HashMap<String, Object> map_result = new HashMap<>();
        //调用服务层
        xiaoyuanyishengService.deleteXiaoyuanyishengJson(request, session, id,map_result);

        return map_result;
    }

    @ResponseBody
    @RequestMapping("updateXiaoyuanyishengJson")
    public HashMap updateXiaoyuanyishengJson(HttpServletRequest request,HttpServletResponse response,HttpSession session,Integer id){
        logger.info("请求访问updateXiaoyuanyishengJson...");
        HashMap<String, Object> map_result = new HashMap<>();
        //调用服务层
        xiaoyuanyishengService.updateXiaoyuanyishengJson(request, session,id,map_result);

        return map_result;
    }

    @ResponseBody
    @RequestMapping("updateXiaoyuanyishengactJson")
    public HashMap updateXiaoyuanyishengactJson(HttpServletRequest request,HttpServletResponse response,HttpSession session,@RequestBody Xiaoyuanyisheng xiaoyuanyisheng){
        logger.info("请求访问updateXiaoyuanyishengactJson...");
        HashMap<String, Object> map_result = new HashMap<>();
        //调用服务层
        xiaoyuanyishengService.updateXiaoyuanyishengactJson(request, session, xiaoyuanyisheng,map_result);

        return map_result;
    }

    @ResponseBody
    @RequestMapping("xiaoyuanyishengListJson")
    public HashMap xiaoyuanyishengListJson(HttpServletRequest request,HttpServletResponse response,HttpSession session){
        logger.info("请求访问xiaoyuanyishengListJson...");
        HashMap<String, Object> map_result = new HashMap<>();
        //调用服务层
        xiaoyuanyishengService.xiaoyuanyishengListJson(request, session,map_result);

        return map_result;
    }



    // ====================role====================


        @ResponseBody
        @RequestMapping("searchXiaoyuanyishengJson")
        public HashMap searchXiaoyuanyishengJson(HttpServletRequest request,HttpServletResponse response,HttpSession session,String search){
            logger.info("请求访问searchXiaoyuanyishengJson中....");
            HashMap<String, Object> map_result = new HashMap<>();
            if (search == null){
                search = "";
            }
            xiaoyuanyishengService.searchXiaoyuanyishengJson(request,session,search,map_result);

            return map_result;
        }

        @ResponseBody
        @RequestMapping("xiaoyuanyishengDetailsJson")
        public HashMap xiaoyuanyishengDetailsJson(HttpServletRequest request,HttpServletResponse response,HttpSession session,Integer id){

            logger.info("请求访问xiaoyuanyishengDetailsJson中....");

            HashMap<String, Object> map_result = new HashMap<>();

            xiaoyuanyishengService.xiaoyuanyishengDetailsJson(request,session,id,map_result);

            return map_result;
        }
}

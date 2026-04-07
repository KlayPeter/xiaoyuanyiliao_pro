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
public class XyyiliaoyaopingController {

private Logger logger = LoggerFactory.getLogger(XyyiliaoyaopingController.class);

    @Autowired
    XyyiliaoyaopingServiceImpl xyyiliaoyaopingService;

    //=================Json=======================


    @ResponseBody
    @RequestMapping("addXyyiliaoyaopingJson")
    public HashMap addXyyiliaoyaopingJson(HttpServletRequest request, HttpServletResponse response, HttpSession session){
        logger.info("请求访问addXyyiliaoyaopingJson...");
        HashMap<String, Object> map_result = new HashMap<>();
        //调用服务层
        xyyiliaoyaopingService.addXyyiliaoyaopingJson(request, session,map_result);

        return map_result;
    }

    @ResponseBody
    @RequestMapping("addXyyiliaoyaopingactJson")
    public HashMap addXyyiliaoyaopingactJson(HttpServletRequest request,HttpServletResponse response,HttpSession session,@RequestBody Xyyiliaoyaoping xyyiliaoyaoping){
        logger.info("请求访问addXyyiliaoyaopingactJson...");
        HashMap<String, Object> map_result = new HashMap<>();
        //调用服务层
        xyyiliaoyaopingService.addXyyiliaoyaopingactJson(request, session, xyyiliaoyaoping,map_result);

        return map_result;
    }

    @ResponseBody
    @RequestMapping("deleteXyyiliaoyaopingJson")
    public HashMap deleteXyyiliaoyaopingJson(HttpServletRequest request,HttpServletResponse response,HttpSession session,Integer id){
        logger.info("请求访问deleteXyyiliaoyaopingJson...");
        HashMap<String, Object> map_result = new HashMap<>();
        //调用服务层
        xyyiliaoyaopingService.deleteXyyiliaoyaopingJson(request, session, id,map_result);

        return map_result;
    }

    @ResponseBody
    @RequestMapping("updateXyyiliaoyaopingJson")
    public HashMap updateXyyiliaoyaopingJson(HttpServletRequest request,HttpServletResponse response,HttpSession session,Integer id){
        logger.info("请求访问updateXyyiliaoyaopingJson...");
        HashMap<String, Object> map_result = new HashMap<>();
        //调用服务层
        xyyiliaoyaopingService.updateXyyiliaoyaopingJson(request, session,id,map_result);

        return map_result;
    }

    @ResponseBody
    @RequestMapping("updateXyyiliaoyaopingactJson")
    public HashMap updateXyyiliaoyaopingactJson(HttpServletRequest request,HttpServletResponse response,HttpSession session,@RequestBody Xyyiliaoyaoping xyyiliaoyaoping){
        logger.info("请求访问updateXyyiliaoyaopingactJson...");
        HashMap<String, Object> map_result = new HashMap<>();
        //调用服务层
        xyyiliaoyaopingService.updateXyyiliaoyaopingactJson(request, session, xyyiliaoyaoping,map_result);

        return map_result;
    }

    @ResponseBody
    @RequestMapping("xyyiliaoyaopingListJson")
    public HashMap xyyiliaoyaopingListJson(HttpServletRequest request,HttpServletResponse response,HttpSession session){
        logger.info("请求访问xyyiliaoyaopingListJson...");
        HashMap<String, Object> map_result = new HashMap<>();
        //调用服务层
        xyyiliaoyaopingService.xyyiliaoyaopingListJson(request, session,map_result);

        return map_result;
    }



    // ====================role====================

}

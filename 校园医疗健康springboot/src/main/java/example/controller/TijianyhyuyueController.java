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
public class TijianyhyuyueController {

private Logger logger = LoggerFactory.getLogger(TijianyhyuyueController.class);

    @Autowired
    TijianyhyuyueServiceImpl tijianyhyuyueService;

    //=================Json=======================


    @ResponseBody
    @RequestMapping("addTijianyhyuyueJson")
    public HashMap addTijianyhyuyueJson(HttpServletRequest request, HttpServletResponse response, HttpSession session){
        logger.info("请求访问addTijianyhyuyueJson...");
        HashMap<String, Object> map_result = new HashMap<>();
        //调用服务层
        tijianyhyuyueService.addTijianyhyuyueJson(request, session,map_result);

        return map_result;
    }

    @ResponseBody
    @RequestMapping("addTijianyhyuyueactJson")
    public HashMap addTijianyhyuyueactJson(HttpServletRequest request,HttpServletResponse response,HttpSession session,@RequestBody Tijianyhyuyue tijianyhyuyue){
        logger.info("请求访问addTijianyhyuyueactJson...");
        HashMap<String, Object> map_result = new HashMap<>();
        //调用服务层
        tijianyhyuyueService.addTijianyhyuyueactJson(request, session, tijianyhyuyue,map_result);

        return map_result;
    }

    @ResponseBody
    @RequestMapping("deleteTijianyhyuyueJson")
    public HashMap deleteTijianyhyuyueJson(HttpServletRequest request,HttpServletResponse response,HttpSession session,Integer id){
        logger.info("请求访问deleteTijianyhyuyueJson...");
        HashMap<String, Object> map_result = new HashMap<>();
        //调用服务层
        tijianyhyuyueService.deleteTijianyhyuyueJson(request, session, id,map_result);

        return map_result;
    }

    @ResponseBody
    @RequestMapping("updateTijianyhyuyueJson")
    public HashMap updateTijianyhyuyueJson(HttpServletRequest request,HttpServletResponse response,HttpSession session,Integer id){
        logger.info("请求访问updateTijianyhyuyueJson...");
        HashMap<String, Object> map_result = new HashMap<>();
        //调用服务层
        tijianyhyuyueService.updateTijianyhyuyueJson(request, session,id,map_result);

        return map_result;
    }

    @ResponseBody
    @RequestMapping("updateTijianyhyuyueactJson")
    public HashMap updateTijianyhyuyueactJson(HttpServletRequest request,HttpServletResponse response,HttpSession session,@RequestBody Tijianyhyuyue tijianyhyuyue){
        logger.info("请求访问updateTijianyhyuyueactJson...");
        HashMap<String, Object> map_result = new HashMap<>();
        //调用服务层
        tijianyhyuyueService.updateTijianyhyuyueactJson(request, session, tijianyhyuyue,map_result);

        return map_result;
    }

    @ResponseBody
    @RequestMapping("tijianyhyuyueListJson")
    public HashMap tijianyhyuyueListJson(HttpServletRequest request,HttpServletResponse response,HttpSession session){
        logger.info("请求访问tijianyhyuyueListJson...");
        HashMap<String, Object> map_result = new HashMap<>();
        //调用服务层
        tijianyhyuyueService.tijianyhyuyueListJson(request, session,map_result);

        return map_result;
    }



    // ====================role====================
            @ResponseBody
            @RequestMapping("xyyiliaoyhAddTijianyhyuyueJson")
            public HashMap xyyiliaoyhAddTijianyhyuyueJson(HttpServletRequest request, HttpServletResponse response, HttpSession session){
                logger.info("请求访问addTijianyhyuyueJson...");
                HashMap<String, Object> map_result = new HashMap<>();
                //调用服务层
                tijianyhyuyueService.xyyiliaoyhAddTijianyhyuyueJson(request, session,map_result);

                return map_result;
            }

            @ResponseBody
            @RequestMapping("xyyiliaoyhAddTijianyhyuyueactJson")
            public HashMap xyyiliaoyhAddTijianyhyuyueactJson(HttpServletRequest request,HttpServletResponse response,HttpSession session,@RequestBody Tijianyhyuyue tijianyhyuyue){
                logger.info("请求访问xyyiliaoyhAddTijianyhyuyueactJson...");
                HashMap<String, Object> map_result = new HashMap<>();
                //调用服务层
                tijianyhyuyueService.xyyiliaoyhAddTijianyhyuyueactJson(request, session, tijianyhyuyue,map_result);

                return map_result;
            }

            @ResponseBody
            @RequestMapping("xyyiliaoyhDeleteTijianyhyuyueJson")
            public HashMap xyyiliaoyhDeleteTijianyhyuyueJson(HttpServletRequest request,HttpServletResponse response,HttpSession session,Integer id){
                logger.info("请求访问userDeleteBookJson...");
                HashMap<String, Object> map_result = new HashMap<>();
                //调用服务层
                tijianyhyuyueService.xyyiliaoyhDeleteTijianyhyuyueJson(request, session, id,map_result);

                return map_result;
            }

            @ResponseBody
            @RequestMapping("xyyiliaoyhUpdateTijianyhyuyueJson")
            public HashMap xyyiliaoyhUpdateTijianyhyuyueJson(HttpServletRequest request,HttpServletResponse response,HttpSession session,Integer id){
                logger.info("请求访问xyyiliaoyhUpdateTijianyhyuyueJson...");
                HashMap<String, Object> map_result = new HashMap<>();
                //调用服务层
                tijianyhyuyueService.xyyiliaoyhUpdateTijianyhyuyueJson(request, session,id,map_result);

                return map_result;
            }

            @ResponseBody
            @RequestMapping("xyyiliaoyhUpdateTijianyhyuyueactJson")
            public HashMap xyyiliaoyhUpdateTijianyhyuyueactJson(HttpServletRequest request,HttpServletResponse response,HttpSession session,@RequestBody Tijianyhyuyue tijianyhyuyue){
                logger.info("请求访问xyyiliaoyhUpdateTijianyhyuyueactJson...");
                HashMap<String, Object> map_result = new HashMap<>();
                //调用服务层
                tijianyhyuyueService.xyyiliaoyhUpdateTijianyhyuyueactJson(request, session, tijianyhyuyue,map_result);

                return map_result;
            }

            @ResponseBody
            @RequestMapping("xyyiliaoyhTijianyhyuyueListJson")
            public HashMap xyyiliaoyhTijianyhyuyueListJson(HttpServletRequest request,HttpServletResponse response,HttpSession session){
                logger.info("请求访问xyyiliaoyhTijianyhyuyueListJson...");
                HashMap<String, Object> map_result = new HashMap<>();
                //调用服务层
                tijianyhyuyueService.xyyiliaoyhTijianyhyuyueListJson(request, session,map_result);

                return map_result;
            }

}

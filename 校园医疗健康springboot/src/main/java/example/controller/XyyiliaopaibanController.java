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
public class XyyiliaopaibanController {

private Logger logger = LoggerFactory.getLogger(XyyiliaopaibanController.class);

    @Autowired
    XyyiliaopaibanServiceImpl xyyiliaopaibanService;

    //=================Json=======================


    @ResponseBody
    @RequestMapping("addXyyiliaopaibanJson")
    public HashMap addXyyiliaopaibanJson(HttpServletRequest request, HttpServletResponse response, HttpSession session){
        logger.info("请求访问addXyyiliaopaibanJson...");
        HashMap<String, Object> map_result = new HashMap<>();
        //调用服务层
        xyyiliaopaibanService.addXyyiliaopaibanJson(request, session,map_result);

        return map_result;
    }

    @ResponseBody
    @RequestMapping("addXyyiliaopaibanactJson")
    public HashMap addXyyiliaopaibanactJson(HttpServletRequest request,HttpServletResponse response,HttpSession session,@RequestBody Xyyiliaopaiban xyyiliaopaiban){
        logger.info("请求访问addXyyiliaopaibanactJson...");
        HashMap<String, Object> map_result = new HashMap<>();
        //调用服务层
        xyyiliaopaibanService.addXyyiliaopaibanactJson(request, session, xyyiliaopaiban,map_result);

        return map_result;
    }

    @ResponseBody
    @RequestMapping("deleteXyyiliaopaibanJson")
    public HashMap deleteXyyiliaopaibanJson(HttpServletRequest request,HttpServletResponse response,HttpSession session,Integer id){
        logger.info("请求访问deleteXyyiliaopaibanJson...");
        HashMap<String, Object> map_result = new HashMap<>();
        //调用服务层
        xyyiliaopaibanService.deleteXyyiliaopaibanJson(request, session, id,map_result);

        return map_result;
    }

    @ResponseBody
    @RequestMapping("updateXyyiliaopaibanJson")
    public HashMap updateXyyiliaopaibanJson(HttpServletRequest request,HttpServletResponse response,HttpSession session,Integer id){
        logger.info("请求访问updateXyyiliaopaibanJson...");
        HashMap<String, Object> map_result = new HashMap<>();
        //调用服务层
        xyyiliaopaibanService.updateXyyiliaopaibanJson(request, session,id,map_result);

        return map_result;
    }

    @ResponseBody
    @RequestMapping("updateXyyiliaopaibanactJson")
    public HashMap updateXyyiliaopaibanactJson(HttpServletRequest request,HttpServletResponse response,HttpSession session,@RequestBody Xyyiliaopaiban xyyiliaopaiban){
        logger.info("请求访问updateXyyiliaopaibanactJson...");
        HashMap<String, Object> map_result = new HashMap<>();
        //调用服务层
        xyyiliaopaibanService.updateXyyiliaopaibanactJson(request, session, xyyiliaopaiban,map_result);

        return map_result;
    }

    @ResponseBody
    @RequestMapping("xyyiliaopaibanListJson")
    public HashMap xyyiliaopaibanListJson(HttpServletRequest request,HttpServletResponse response,HttpSession session){
        logger.info("请求访问xyyiliaopaibanListJson...");
        HashMap<String, Object> map_result = new HashMap<>();
        //调用服务层
        xyyiliaopaibanService.xyyiliaopaibanListJson(request, session,map_result);

        return map_result;
    }



    // ====================role====================
            @ResponseBody
            @RequestMapping("xiaoyuanyishengAddXyyiliaopaibanJson")
            public HashMap xiaoyuanyishengAddXyyiliaopaibanJson(HttpServletRequest request, HttpServletResponse response, HttpSession session){
                logger.info("请求访问addXyyiliaopaibanJson...");
                HashMap<String, Object> map_result = new HashMap<>();
                //调用服务层
                xyyiliaopaibanService.xiaoyuanyishengAddXyyiliaopaibanJson(request, session,map_result);

                return map_result;
            }

            @ResponseBody
            @RequestMapping("xiaoyuanyishengAddXyyiliaopaibanactJson")
            public HashMap xiaoyuanyishengAddXyyiliaopaibanactJson(HttpServletRequest request,HttpServletResponse response,HttpSession session,@RequestBody Xyyiliaopaiban xyyiliaopaiban){
                logger.info("请求访问xiaoyuanyishengAddXyyiliaopaibanactJson...");
                HashMap<String, Object> map_result = new HashMap<>();
                //调用服务层
                xyyiliaopaibanService.xiaoyuanyishengAddXyyiliaopaibanactJson(request, session, xyyiliaopaiban,map_result);

                return map_result;
            }

            @ResponseBody
            @RequestMapping("xiaoyuanyishengDeleteXyyiliaopaibanJson")
            public HashMap xiaoyuanyishengDeleteXyyiliaopaibanJson(HttpServletRequest request,HttpServletResponse response,HttpSession session,Integer id){
                logger.info("请求访问userDeleteBookJson...");
                HashMap<String, Object> map_result = new HashMap<>();
                //调用服务层
                xyyiliaopaibanService.xiaoyuanyishengDeleteXyyiliaopaibanJson(request, session, id,map_result);

                return map_result;
            }

            @ResponseBody
            @RequestMapping("xiaoyuanyishengUpdateXyyiliaopaibanJson")
            public HashMap xiaoyuanyishengUpdateXyyiliaopaibanJson(HttpServletRequest request,HttpServletResponse response,HttpSession session,Integer id){
                logger.info("请求访问xiaoyuanyishengUpdateXyyiliaopaibanJson...");
                HashMap<String, Object> map_result = new HashMap<>();
                //调用服务层
                xyyiliaopaibanService.xiaoyuanyishengUpdateXyyiliaopaibanJson(request, session,id,map_result);

                return map_result;
            }

            @ResponseBody
            @RequestMapping("xiaoyuanyishengUpdateXyyiliaopaibanactJson")
            public HashMap xiaoyuanyishengUpdateXyyiliaopaibanactJson(HttpServletRequest request,HttpServletResponse response,HttpSession session,@RequestBody Xyyiliaopaiban xyyiliaopaiban){
                logger.info("请求访问xiaoyuanyishengUpdateXyyiliaopaibanactJson...");
                HashMap<String, Object> map_result = new HashMap<>();
                //调用服务层
                xyyiliaopaibanService.xiaoyuanyishengUpdateXyyiliaopaibanactJson(request, session, xyyiliaopaiban,map_result);

                return map_result;
            }

            @ResponseBody
            @RequestMapping("xiaoyuanyishengXyyiliaopaibanListJson")
            public HashMap xiaoyuanyishengXyyiliaopaibanListJson(HttpServletRequest request,HttpServletResponse response,HttpSession session){
                logger.info("请求访问xiaoyuanyishengXyyiliaopaibanListJson...");
                HashMap<String, Object> map_result = new HashMap<>();
                //调用服务层
                xyyiliaopaibanService.xiaoyuanyishengXyyiliaopaibanListJson(request, session,map_result);

                return map_result;
            }

}

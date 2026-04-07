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
public class XyyiliaoyhController {

private Logger logger = LoggerFactory.getLogger(XyyiliaoyhController.class);

    @Autowired
    XyyiliaoyhServiceImpl xyyiliaoyhService;

    //=================Json=======================
        @ResponseBody
        @RequestMapping("xyyiliaoyhIndexJson")
        public HashMap xyyiliaoyhIndexJson(HttpServletRequest request,HttpServletResponse response,HttpSession session){
            logger.info("请求访问xyyiliaoyhIndexJson...");
            HashMap<String, Object> map_result = new HashMap<>();
            //调用服务层
            xyyiliaoyhService.xyyiliaoyhIndexJson(request, session,map_result);

            return map_result;
        }

        @ResponseBody
        @RequestMapping("xyyiliaoyhUpdateIndexJson")
        public HashMap xyyiliaoyhUpdateIndexJson(HttpServletRequest request,HttpServletResponse response,HttpSession session,@RequestBody Xyyiliaoyh xyyiliaoyh){
            logger.info("请求访问xyyiliaoyhUpdateIndexJson...");
            HashMap<String, Object> map_result = new HashMap<>();
            //调用服务层
            xyyiliaoyhService.xyyiliaoyhUpdateIndexJson(request, session, xyyiliaoyh,map_result);

            return map_result;
        }


    @ResponseBody
    @RequestMapping("addXyyiliaoyhJson")
    public HashMap addXyyiliaoyhJson(HttpServletRequest request, HttpServletResponse response, HttpSession session){
        logger.info("请求访问addXyyiliaoyhJson...");
        HashMap<String, Object> map_result = new HashMap<>();
        //调用服务层
        xyyiliaoyhService.addXyyiliaoyhJson(request, session,map_result);

        return map_result;
    }

    @ResponseBody
    @RequestMapping("addXyyiliaoyhactJson")
    public HashMap addXyyiliaoyhactJson(HttpServletRequest request,HttpServletResponse response,HttpSession session,@RequestBody Xyyiliaoyh xyyiliaoyh){
        logger.info("请求访问addXyyiliaoyhactJson...");
        HashMap<String, Object> map_result = new HashMap<>();
        //调用服务层
        xyyiliaoyhService.addXyyiliaoyhactJson(request, session, xyyiliaoyh,map_result);

        return map_result;
    }

    @ResponseBody
    @RequestMapping("deleteXyyiliaoyhJson")
    public HashMap deleteXyyiliaoyhJson(HttpServletRequest request,HttpServletResponse response,HttpSession session,Integer id){
        logger.info("请求访问deleteXyyiliaoyhJson...");
        HashMap<String, Object> map_result = new HashMap<>();
        //调用服务层
        xyyiliaoyhService.deleteXyyiliaoyhJson(request, session, id,map_result);

        return map_result;
    }

    @ResponseBody
    @RequestMapping("updateXyyiliaoyhJson")
    public HashMap updateXyyiliaoyhJson(HttpServletRequest request,HttpServletResponse response,HttpSession session,Integer id){
        logger.info("请求访问updateXyyiliaoyhJson...");
        HashMap<String, Object> map_result = new HashMap<>();
        //调用服务层
        xyyiliaoyhService.updateXyyiliaoyhJson(request, session,id,map_result);

        return map_result;
    }

    @ResponseBody
    @RequestMapping("updateXyyiliaoyhactJson")
    public HashMap updateXyyiliaoyhactJson(HttpServletRequest request,HttpServletResponse response,HttpSession session,@RequestBody Xyyiliaoyh xyyiliaoyh){
        logger.info("请求访问updateXyyiliaoyhactJson...");
        HashMap<String, Object> map_result = new HashMap<>();
        //调用服务层
        xyyiliaoyhService.updateXyyiliaoyhactJson(request, session, xyyiliaoyh,map_result);

        return map_result;
    }

    @ResponseBody
    @RequestMapping("xyyiliaoyhListJson")
    public HashMap xyyiliaoyhListJson(HttpServletRequest request,HttpServletResponse response,HttpSession session){
        logger.info("请求访问xyyiliaoyhListJson...");
        HashMap<String, Object> map_result = new HashMap<>();
        //调用服务层
        xyyiliaoyhService.xyyiliaoyhListJson(request, session,map_result);

        return map_result;
    }



    // ====================role====================

}

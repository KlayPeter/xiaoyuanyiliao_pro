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
public class XyyiliaopaibanyuyueController {

private Logger logger = LoggerFactory.getLogger(XyyiliaopaibanyuyueController.class);

    @Autowired
    XyyiliaopaibanyuyueServiceImpl xyyiliaopaibanyuyueService;

    //=================Json=======================


    @ResponseBody
    @RequestMapping("addXyyiliaopaibanyuyueJson")
    public HashMap addXyyiliaopaibanyuyueJson(HttpServletRequest request, HttpServletResponse response, HttpSession session){
        logger.info("请求访问addXyyiliaopaibanyuyueJson...");
        HashMap<String, Object> map_result = new HashMap<>();
        //调用服务层
        xyyiliaopaibanyuyueService.addXyyiliaopaibanyuyueJson(request, session,map_result);

        return map_result;
    }

    @ResponseBody
    @RequestMapping("addXyyiliaopaibanyuyueactJson")
    public HashMap addXyyiliaopaibanyuyueactJson(HttpServletRequest request,HttpServletResponse response,HttpSession session,@RequestBody Xyyiliaopaibanyuyue xyyiliaopaibanyuyue){
        logger.info("请求访问addXyyiliaopaibanyuyueactJson...");
        HashMap<String, Object> map_result = new HashMap<>();
        //调用服务层
        xyyiliaopaibanyuyueService.addXyyiliaopaibanyuyueactJson(request, session, xyyiliaopaibanyuyue,map_result);

        return map_result;
    }

    @ResponseBody
    @RequestMapping("deleteXyyiliaopaibanyuyueJson")
    public HashMap deleteXyyiliaopaibanyuyueJson(HttpServletRequest request,HttpServletResponse response,HttpSession session,Integer id){
        logger.info("请求访问deleteXyyiliaopaibanyuyueJson...");
        HashMap<String, Object> map_result = new HashMap<>();
        //调用服务层
        xyyiliaopaibanyuyueService.deleteXyyiliaopaibanyuyueJson(request, session, id,map_result);

        return map_result;
    }

    @ResponseBody
    @RequestMapping("updateXyyiliaopaibanyuyueJson")
    public HashMap updateXyyiliaopaibanyuyueJson(HttpServletRequest request,HttpServletResponse response,HttpSession session,Integer id){
        logger.info("请求访问updateXyyiliaopaibanyuyueJson...");
        HashMap<String, Object> map_result = new HashMap<>();
        //调用服务层
        xyyiliaopaibanyuyueService.updateXyyiliaopaibanyuyueJson(request, session,id,map_result);

        return map_result;
    }

    @ResponseBody
    @RequestMapping("updateXyyiliaopaibanyuyueactJson")
    public HashMap updateXyyiliaopaibanyuyueactJson(HttpServletRequest request,HttpServletResponse response,HttpSession session,@RequestBody Xyyiliaopaibanyuyue xyyiliaopaibanyuyue){
        logger.info("请求访问updateXyyiliaopaibanyuyueactJson...");
        HashMap<String, Object> map_result = new HashMap<>();
        //调用服务层
        xyyiliaopaibanyuyueService.updateXyyiliaopaibanyuyueactJson(request, session, xyyiliaopaibanyuyue,map_result);

        return map_result;
    }

    @ResponseBody
    @RequestMapping("xyyiliaopaibanyuyueListJson")
    public HashMap xyyiliaopaibanyuyueListJson(HttpServletRequest request,HttpServletResponse response,HttpSession session){
        logger.info("请求访问xyyiliaopaibanyuyueListJson...");
        HashMap<String, Object> map_result = new HashMap<>();
        //调用服务层
        xyyiliaopaibanyuyueService.xyyiliaopaibanyuyueListJson(request, session,map_result);

        return map_result;
    }



    // ====================role====================
            @ResponseBody
            @RequestMapping("xiaoyuanyishengAddXyyiliaopaibanyuyueJson")
            public HashMap xiaoyuanyishengAddXyyiliaopaibanyuyueJson(HttpServletRequest request, HttpServletResponse response, HttpSession session){
                logger.info("请求访问addXyyiliaopaibanyuyueJson...");
                HashMap<String, Object> map_result = new HashMap<>();
                //调用服务层
                xyyiliaopaibanyuyueService.xiaoyuanyishengAddXyyiliaopaibanyuyueJson(request, session,map_result);

                return map_result;
            }

            @ResponseBody
            @RequestMapping("xiaoyuanyishengAddXyyiliaopaibanyuyueactJson")
            public HashMap xiaoyuanyishengAddXyyiliaopaibanyuyueactJson(HttpServletRequest request,HttpServletResponse response,HttpSession session,@RequestBody Xyyiliaopaibanyuyue xyyiliaopaibanyuyue){
                logger.info("请求访问xiaoyuanyishengAddXyyiliaopaibanyuyueactJson...");
                HashMap<String, Object> map_result = new HashMap<>();
                //调用服务层
                xyyiliaopaibanyuyueService.xiaoyuanyishengAddXyyiliaopaibanyuyueactJson(request, session, xyyiliaopaibanyuyue,map_result);

                return map_result;
            }

            @ResponseBody
            @RequestMapping("xiaoyuanyishengDeleteXyyiliaopaibanyuyueJson")
            public HashMap xiaoyuanyishengDeleteXyyiliaopaibanyuyueJson(HttpServletRequest request,HttpServletResponse response,HttpSession session,Integer id){
                logger.info("请求访问userDeleteBookJson...");
                HashMap<String, Object> map_result = new HashMap<>();
                //调用服务层
                xyyiliaopaibanyuyueService.xiaoyuanyishengDeleteXyyiliaopaibanyuyueJson(request, session, id,map_result);

                return map_result;
            }

            @ResponseBody
            @RequestMapping("xiaoyuanyishengUpdateXyyiliaopaibanyuyueJson")
            public HashMap xiaoyuanyishengUpdateXyyiliaopaibanyuyueJson(HttpServletRequest request,HttpServletResponse response,HttpSession session,Integer id){
                logger.info("请求访问xiaoyuanyishengUpdateXyyiliaopaibanyuyueJson...");
                HashMap<String, Object> map_result = new HashMap<>();
                //调用服务层
                xyyiliaopaibanyuyueService.xiaoyuanyishengUpdateXyyiliaopaibanyuyueJson(request, session,id,map_result);

                return map_result;
            }

            @ResponseBody
            @RequestMapping("xiaoyuanyishengUpdateXyyiliaopaibanyuyueactJson")
            public HashMap xiaoyuanyishengUpdateXyyiliaopaibanyuyueactJson(HttpServletRequest request,HttpServletResponse response,HttpSession session,@RequestBody Xyyiliaopaibanyuyue xyyiliaopaibanyuyue){
                logger.info("请求访问xiaoyuanyishengUpdateXyyiliaopaibanyuyueactJson...");
                HashMap<String, Object> map_result = new HashMap<>();
                //调用服务层
                xyyiliaopaibanyuyueService.xiaoyuanyishengUpdateXyyiliaopaibanyuyueactJson(request, session, xyyiliaopaibanyuyue,map_result);

                return map_result;
            }

            @ResponseBody
            @RequestMapping("xiaoyuanyishengXyyiliaopaibanyuyueListJson")
            public HashMap xiaoyuanyishengXyyiliaopaibanyuyueListJson(HttpServletRequest request,HttpServletResponse response,HttpSession session){
                logger.info("请求访问xiaoyuanyishengXyyiliaopaibanyuyueListJson...");
                HashMap<String, Object> map_result = new HashMap<>();
                //调用服务层
                xyyiliaopaibanyuyueService.xiaoyuanyishengXyyiliaopaibanyuyueListJson(request, session,map_result);

                return map_result;
            }
            @ResponseBody
            @RequestMapping("xyyiliaoyhAddXyyiliaopaibanyuyueJson")
            public HashMap xyyiliaoyhAddXyyiliaopaibanyuyueJson(HttpServletRequest request, HttpServletResponse response, HttpSession session){
                logger.info("请求访问addXyyiliaopaibanyuyueJson...");
                HashMap<String, Object> map_result = new HashMap<>();
                //调用服务层
                xyyiliaopaibanyuyueService.xyyiliaoyhAddXyyiliaopaibanyuyueJson(request, session,map_result);

                return map_result;
            }

            @ResponseBody
            @RequestMapping("xyyiliaoyhAddXyyiliaopaibanyuyueactJson")
            public HashMap xyyiliaoyhAddXyyiliaopaibanyuyueactJson(HttpServletRequest request,HttpServletResponse response,HttpSession session,@RequestBody Xyyiliaopaibanyuyue xyyiliaopaibanyuyue){
                logger.info("请求访问xyyiliaoyhAddXyyiliaopaibanyuyueactJson...");
                HashMap<String, Object> map_result = new HashMap<>();
                //调用服务层
                xyyiliaopaibanyuyueService.xyyiliaoyhAddXyyiliaopaibanyuyueactJson(request, session, xyyiliaopaibanyuyue,map_result);

                return map_result;
            }

            @ResponseBody
            @RequestMapping("xyyiliaoyhDeleteXyyiliaopaibanyuyueJson")
            public HashMap xyyiliaoyhDeleteXyyiliaopaibanyuyueJson(HttpServletRequest request,HttpServletResponse response,HttpSession session,Integer id){
                logger.info("请求访问userDeleteBookJson...");
                HashMap<String, Object> map_result = new HashMap<>();
                //调用服务层
                xyyiliaopaibanyuyueService.xyyiliaoyhDeleteXyyiliaopaibanyuyueJson(request, session, id,map_result);

                return map_result;
            }

            @ResponseBody
            @RequestMapping("xyyiliaoyhUpdateXyyiliaopaibanyuyueJson")
            public HashMap xyyiliaoyhUpdateXyyiliaopaibanyuyueJson(HttpServletRequest request,HttpServletResponse response,HttpSession session,Integer id){
                logger.info("请求访问xyyiliaoyhUpdateXyyiliaopaibanyuyueJson...");
                HashMap<String, Object> map_result = new HashMap<>();
                //调用服务层
                xyyiliaopaibanyuyueService.xyyiliaoyhUpdateXyyiliaopaibanyuyueJson(request, session,id,map_result);

                return map_result;
            }

            @ResponseBody
            @RequestMapping("xyyiliaoyhUpdateXyyiliaopaibanyuyueactJson")
            public HashMap xyyiliaoyhUpdateXyyiliaopaibanyuyueactJson(HttpServletRequest request,HttpServletResponse response,HttpSession session,@RequestBody Xyyiliaopaibanyuyue xyyiliaopaibanyuyue){
                logger.info("请求访问xyyiliaoyhUpdateXyyiliaopaibanyuyueactJson...");
                HashMap<String, Object> map_result = new HashMap<>();
                //调用服务层
                xyyiliaopaibanyuyueService.xyyiliaoyhUpdateXyyiliaopaibanyuyueactJson(request, session, xyyiliaopaibanyuyue,map_result);

                return map_result;
            }

            @ResponseBody
            @RequestMapping("xyyiliaoyhXyyiliaopaibanyuyueListJson")
            public HashMap xyyiliaoyhXyyiliaopaibanyuyueListJson(HttpServletRequest request,HttpServletResponse response,HttpSession session){
                logger.info("请求访问xyyiliaoyhXyyiliaopaibanyuyueListJson...");
                HashMap<String, Object> map_result = new HashMap<>();
                //调用服务层
                xyyiliaopaibanyuyueService.xyyiliaoyhXyyiliaopaibanyuyueListJson(request, session,map_result);

                return map_result;
            }

}

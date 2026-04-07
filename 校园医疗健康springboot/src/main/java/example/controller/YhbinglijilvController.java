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
public class YhbinglijilvController {

private Logger logger = LoggerFactory.getLogger(YhbinglijilvController.class);

    @Autowired
    YhbinglijilvServiceImpl yhbinglijilvService;

    //=================Json=======================


    @ResponseBody
    @RequestMapping("addYhbinglijilvJson")
    public HashMap addYhbinglijilvJson(HttpServletRequest request, HttpServletResponse response, HttpSession session){
        logger.info("请求访问addYhbinglijilvJson...");
        HashMap<String, Object> map_result = new HashMap<>();
        //调用服务层
        yhbinglijilvService.addYhbinglijilvJson(request, session,map_result);

        return map_result;
    }

    @ResponseBody
    @RequestMapping("addYhbinglijilvactJson")
    public HashMap addYhbinglijilvactJson(HttpServletRequest request,HttpServletResponse response,HttpSession session,@RequestBody Yhbinglijilv yhbinglijilv){
        logger.info("请求访问addYhbinglijilvactJson...");
        HashMap<String, Object> map_result = new HashMap<>();
        //调用服务层
        yhbinglijilvService.addYhbinglijilvactJson(request, session, yhbinglijilv,map_result);

        return map_result;
    }

    @ResponseBody
    @RequestMapping("deleteYhbinglijilvJson")
    public HashMap deleteYhbinglijilvJson(HttpServletRequest request,HttpServletResponse response,HttpSession session,Integer id){
        logger.info("请求访问deleteYhbinglijilvJson...");
        HashMap<String, Object> map_result = new HashMap<>();
        //调用服务层
        yhbinglijilvService.deleteYhbinglijilvJson(request, session, id,map_result);

        return map_result;
    }

    @ResponseBody
    @RequestMapping("updateYhbinglijilvJson")
    public HashMap updateYhbinglijilvJson(HttpServletRequest request,HttpServletResponse response,HttpSession session,Integer id){
        logger.info("请求访问updateYhbinglijilvJson...");
        HashMap<String, Object> map_result = new HashMap<>();
        //调用服务层
        yhbinglijilvService.updateYhbinglijilvJson(request, session,id,map_result);

        return map_result;
    }

    @ResponseBody
    @RequestMapping("updateYhbinglijilvactJson")
    public HashMap updateYhbinglijilvactJson(HttpServletRequest request,HttpServletResponse response,HttpSession session,@RequestBody Yhbinglijilv yhbinglijilv){
        logger.info("请求访问updateYhbinglijilvactJson...");
        HashMap<String, Object> map_result = new HashMap<>();
        //调用服务层
        yhbinglijilvService.updateYhbinglijilvactJson(request, session, yhbinglijilv,map_result);

        return map_result;
    }

    @ResponseBody
    @RequestMapping("yhbinglijilvListJson")
    public HashMap yhbinglijilvListJson(HttpServletRequest request,HttpServletResponse response,HttpSession session){
        logger.info("请求访问yhbinglijilvListJson...");
        HashMap<String, Object> map_result = new HashMap<>();
        //调用服务层
        yhbinglijilvService.yhbinglijilvListJson(request, session,map_result);

        return map_result;
    }



    // ====================role====================
            @ResponseBody
            @RequestMapping("xyyiliaoyhAddYhbinglijilvJson")
            public HashMap xyyiliaoyhAddYhbinglijilvJson(HttpServletRequest request, HttpServletResponse response, HttpSession session){
                logger.info("请求访问addYhbinglijilvJson...");
                HashMap<String, Object> map_result = new HashMap<>();
                //调用服务层
                yhbinglijilvService.xyyiliaoyhAddYhbinglijilvJson(request, session,map_result);

                return map_result;
            }

            @ResponseBody
            @RequestMapping("xyyiliaoyhAddYhbinglijilvactJson")
            public HashMap xyyiliaoyhAddYhbinglijilvactJson(HttpServletRequest request,HttpServletResponse response,HttpSession session,@RequestBody Yhbinglijilv yhbinglijilv){
                logger.info("请求访问xyyiliaoyhAddYhbinglijilvactJson...");
                HashMap<String, Object> map_result = new HashMap<>();
                //调用服务层
                yhbinglijilvService.xyyiliaoyhAddYhbinglijilvactJson(request, session, yhbinglijilv,map_result);

                return map_result;
            }

            @ResponseBody
            @RequestMapping("xyyiliaoyhDeleteYhbinglijilvJson")
            public HashMap xyyiliaoyhDeleteYhbinglijilvJson(HttpServletRequest request,HttpServletResponse response,HttpSession session,Integer id){
                logger.info("请求访问userDeleteBookJson...");
                HashMap<String, Object> map_result = new HashMap<>();
                //调用服务层
                yhbinglijilvService.xyyiliaoyhDeleteYhbinglijilvJson(request, session, id,map_result);

                return map_result;
            }

            @ResponseBody
            @RequestMapping("xyyiliaoyhUpdateYhbinglijilvJson")
            public HashMap xyyiliaoyhUpdateYhbinglijilvJson(HttpServletRequest request,HttpServletResponse response,HttpSession session,Integer id){
                logger.info("请求访问xyyiliaoyhUpdateYhbinglijilvJson...");
                HashMap<String, Object> map_result = new HashMap<>();
                //调用服务层
                yhbinglijilvService.xyyiliaoyhUpdateYhbinglijilvJson(request, session,id,map_result);

                return map_result;
            }

            @ResponseBody
            @RequestMapping("xyyiliaoyhUpdateYhbinglijilvactJson")
            public HashMap xyyiliaoyhUpdateYhbinglijilvactJson(HttpServletRequest request,HttpServletResponse response,HttpSession session,@RequestBody Yhbinglijilv yhbinglijilv){
                logger.info("请求访问xyyiliaoyhUpdateYhbinglijilvactJson...");
                HashMap<String, Object> map_result = new HashMap<>();
                //调用服务层
                yhbinglijilvService.xyyiliaoyhUpdateYhbinglijilvactJson(request, session, yhbinglijilv,map_result);

                return map_result;
            }

            @ResponseBody
            @RequestMapping("xyyiliaoyhYhbinglijilvListJson")
            public HashMap xyyiliaoyhYhbinglijilvListJson(HttpServletRequest request,HttpServletResponse response,HttpSession session){
                logger.info("请求访问xyyiliaoyhYhbinglijilvListJson...");
                HashMap<String, Object> map_result = new HashMap<>();
                //调用服务层
                yhbinglijilvService.xyyiliaoyhYhbinglijilvListJson(request, session,map_result);

                return map_result;
            }

}

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
public class YuyuepingjiaController {

private Logger logger = LoggerFactory.getLogger(YuyuepingjiaController.class);

    @Autowired
    YuyuepingjiaServiceImpl yuyuepingjiaService;

    //=================Json=======================


    @ResponseBody
    @RequestMapping("addYuyuepingjiaJson")
    public HashMap addYuyuepingjiaJson(HttpServletRequest request, HttpServletResponse response, HttpSession session){
        logger.info("请求访问addYuyuepingjiaJson...");
        HashMap<String, Object> map_result = new HashMap<>();
        //调用服务层
        yuyuepingjiaService.addYuyuepingjiaJson(request, session,map_result);

        return map_result;
    }

    @ResponseBody
    @RequestMapping("addYuyuepingjiaactJson")
    public HashMap addYuyuepingjiaactJson(HttpServletRequest request,HttpServletResponse response,HttpSession session,@RequestBody Yuyuepingjia yuyuepingjia){
        logger.info("请求访问addYuyuepingjiaactJson...");
        HashMap<String, Object> map_result = new HashMap<>();
        //调用服务层
        yuyuepingjiaService.addYuyuepingjiaactJson(request, session, yuyuepingjia,map_result);

        return map_result;
    }

    @ResponseBody
    @RequestMapping("deleteYuyuepingjiaJson")
    public HashMap deleteYuyuepingjiaJson(HttpServletRequest request,HttpServletResponse response,HttpSession session,Integer id){
        logger.info("请求访问deleteYuyuepingjiaJson...");
        HashMap<String, Object> map_result = new HashMap<>();
        //调用服务层
        yuyuepingjiaService.deleteYuyuepingjiaJson(request, session, id,map_result);

        return map_result;
    }

    @ResponseBody
    @RequestMapping("updateYuyuepingjiaJson")
    public HashMap updateYuyuepingjiaJson(HttpServletRequest request,HttpServletResponse response,HttpSession session,Integer id){
        logger.info("请求访问updateYuyuepingjiaJson...");
        HashMap<String, Object> map_result = new HashMap<>();
        //调用服务层
        yuyuepingjiaService.updateYuyuepingjiaJson(request, session,id,map_result);

        return map_result;
    }

    @ResponseBody
    @RequestMapping("updateYuyuepingjiaactJson")
    public HashMap updateYuyuepingjiaactJson(HttpServletRequest request,HttpServletResponse response,HttpSession session,@RequestBody Yuyuepingjia yuyuepingjia){
        logger.info("请求访问updateYuyuepingjiaactJson...");
        HashMap<String, Object> map_result = new HashMap<>();
        //调用服务层
        yuyuepingjiaService.updateYuyuepingjiaactJson(request, session, yuyuepingjia,map_result);

        return map_result;
    }

    @ResponseBody
    @RequestMapping("yuyuepingjiaListJson")
    public HashMap yuyuepingjiaListJson(HttpServletRequest request,HttpServletResponse response,HttpSession session){
        logger.info("请求访问yuyuepingjiaListJson...");
        HashMap<String, Object> map_result = new HashMap<>();
        //调用服务层
        yuyuepingjiaService.yuyuepingjiaListJson(request, session,map_result);

        return map_result;
    }



    // ====================role====================
            @ResponseBody
            @RequestMapping("xyyiliaoyhAddYuyuepingjiaJson")
            public HashMap xyyiliaoyhAddYuyuepingjiaJson(HttpServletRequest request, HttpServletResponse response, HttpSession session){
                logger.info("请求访问addYuyuepingjiaJson...");
                HashMap<String, Object> map_result = new HashMap<>();
                //调用服务层
                yuyuepingjiaService.xyyiliaoyhAddYuyuepingjiaJson(request, session,map_result);

                return map_result;
            }

            @ResponseBody
            @RequestMapping("xyyiliaoyhAddYuyuepingjiaactJson")
            public HashMap xyyiliaoyhAddYuyuepingjiaactJson(HttpServletRequest request,HttpServletResponse response,HttpSession session,@RequestBody Yuyuepingjia yuyuepingjia){
                logger.info("请求访问xyyiliaoyhAddYuyuepingjiaactJson...");
                HashMap<String, Object> map_result = new HashMap<>();
                //调用服务层
                yuyuepingjiaService.xyyiliaoyhAddYuyuepingjiaactJson(request, session, yuyuepingjia,map_result);

                return map_result;
            }

            @ResponseBody
            @RequestMapping("xyyiliaoyhDeleteYuyuepingjiaJson")
            public HashMap xyyiliaoyhDeleteYuyuepingjiaJson(HttpServletRequest request,HttpServletResponse response,HttpSession session,Integer id){
                logger.info("请求访问userDeleteBookJson...");
                HashMap<String, Object> map_result = new HashMap<>();
                //调用服务层
                yuyuepingjiaService.xyyiliaoyhDeleteYuyuepingjiaJson(request, session, id,map_result);

                return map_result;
            }

            @ResponseBody
            @RequestMapping("xyyiliaoyhUpdateYuyuepingjiaJson")
            public HashMap xyyiliaoyhUpdateYuyuepingjiaJson(HttpServletRequest request,HttpServletResponse response,HttpSession session,Integer id){
                logger.info("请求访问xyyiliaoyhUpdateYuyuepingjiaJson...");
                HashMap<String, Object> map_result = new HashMap<>();
                //调用服务层
                yuyuepingjiaService.xyyiliaoyhUpdateYuyuepingjiaJson(request, session,id,map_result);

                return map_result;
            }

            @ResponseBody
            @RequestMapping("xyyiliaoyhUpdateYuyuepingjiaactJson")
            public HashMap xyyiliaoyhUpdateYuyuepingjiaactJson(HttpServletRequest request,HttpServletResponse response,HttpSession session,@RequestBody Yuyuepingjia yuyuepingjia){
                logger.info("请求访问xyyiliaoyhUpdateYuyuepingjiaactJson...");
                HashMap<String, Object> map_result = new HashMap<>();
                //调用服务层
                yuyuepingjiaService.xyyiliaoyhUpdateYuyuepingjiaactJson(request, session, yuyuepingjia,map_result);

                return map_result;
            }

            @ResponseBody
            @RequestMapping("xyyiliaoyhYuyuepingjiaListJson")
            public HashMap xyyiliaoyhYuyuepingjiaListJson(HttpServletRequest request,HttpServletResponse response,HttpSession session){
                logger.info("请求访问xyyiliaoyhYuyuepingjiaListJson...");
                HashMap<String, Object> map_result = new HashMap<>();
                //调用服务层
                yuyuepingjiaService.xyyiliaoyhYuyuepingjiaListJson(request, session,map_result);

                return map_result;
            }

}

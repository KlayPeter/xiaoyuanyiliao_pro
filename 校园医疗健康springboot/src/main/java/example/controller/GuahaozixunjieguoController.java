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
public class GuahaozixunjieguoController {

private Logger logger = LoggerFactory.getLogger(GuahaozixunjieguoController.class);

    @Autowired
    GuahaozixunjieguoServiceImpl guahaozixunjieguoService;

    //=================Json=======================


    @ResponseBody
    @RequestMapping("addGuahaozixunjieguoJson")
    public HashMap addGuahaozixunjieguoJson(HttpServletRequest request, HttpServletResponse response, HttpSession session){
        logger.info("请求访问addGuahaozixunjieguoJson...");
        HashMap<String, Object> map_result = new HashMap<>();
        //调用服务层
        guahaozixunjieguoService.addGuahaozixunjieguoJson(request, session,map_result);

        return map_result;
    }

    @ResponseBody
    @RequestMapping("addGuahaozixunjieguoactJson")
    public HashMap addGuahaozixunjieguoactJson(HttpServletRequest request,HttpServletResponse response,HttpSession session,@RequestBody Guahaozixunjieguo guahaozixunjieguo){
        logger.info("请求访问addGuahaozixunjieguoactJson...");
        HashMap<String, Object> map_result = new HashMap<>();
        //调用服务层
        guahaozixunjieguoService.addGuahaozixunjieguoactJson(request, session, guahaozixunjieguo,map_result);

        return map_result;
    }

    @ResponseBody
    @RequestMapping("deleteGuahaozixunjieguoJson")
    public HashMap deleteGuahaozixunjieguoJson(HttpServletRequest request,HttpServletResponse response,HttpSession session,Integer id){
        logger.info("请求访问deleteGuahaozixunjieguoJson...");
        HashMap<String, Object> map_result = new HashMap<>();
        //调用服务层
        guahaozixunjieguoService.deleteGuahaozixunjieguoJson(request, session, id,map_result);

        return map_result;
    }

    @ResponseBody
    @RequestMapping("updateGuahaozixunjieguoJson")
    public HashMap updateGuahaozixunjieguoJson(HttpServletRequest request,HttpServletResponse response,HttpSession session,Integer id){
        logger.info("请求访问updateGuahaozixunjieguoJson...");
        HashMap<String, Object> map_result = new HashMap<>();
        //调用服务层
        guahaozixunjieguoService.updateGuahaozixunjieguoJson(request, session,id,map_result);

        return map_result;
    }

    @ResponseBody
    @RequestMapping("updateGuahaozixunjieguoactJson")
    public HashMap updateGuahaozixunjieguoactJson(HttpServletRequest request,HttpServletResponse response,HttpSession session,@RequestBody Guahaozixunjieguo guahaozixunjieguo){
        logger.info("请求访问updateGuahaozixunjieguoactJson...");
        HashMap<String, Object> map_result = new HashMap<>();
        //调用服务层
        guahaozixunjieguoService.updateGuahaozixunjieguoactJson(request, session, guahaozixunjieguo,map_result);

        return map_result;
    }

    @ResponseBody
    @RequestMapping("guahaozixunjieguoListJson")
    public HashMap guahaozixunjieguoListJson(HttpServletRequest request,HttpServletResponse response,HttpSession session){
        logger.info("请求访问guahaozixunjieguoListJson...");
        HashMap<String, Object> map_result = new HashMap<>();
        //调用服务层
        guahaozixunjieguoService.guahaozixunjieguoListJson(request, session,map_result);

        return map_result;
    }



    // ====================role====================
            @ResponseBody
            @RequestMapping("xiaoyuanyishengAddGuahaozixunjieguoJson")
            public HashMap xiaoyuanyishengAddGuahaozixunjieguoJson(HttpServletRequest request, HttpServletResponse response, HttpSession session){
                logger.info("请求访问addGuahaozixunjieguoJson...");
                HashMap<String, Object> map_result = new HashMap<>();
                //调用服务层
                guahaozixunjieguoService.xiaoyuanyishengAddGuahaozixunjieguoJson(request, session,map_result);

                return map_result;
            }

            @ResponseBody
            @RequestMapping("xiaoyuanyishengAddGuahaozixunjieguoactJson")
            public HashMap xiaoyuanyishengAddGuahaozixunjieguoactJson(HttpServletRequest request,HttpServletResponse response,HttpSession session,@RequestBody Guahaozixunjieguo guahaozixunjieguo){
                logger.info("请求访问xiaoyuanyishengAddGuahaozixunjieguoactJson...");
                HashMap<String, Object> map_result = new HashMap<>();
                //调用服务层
                guahaozixunjieguoService.xiaoyuanyishengAddGuahaozixunjieguoactJson(request, session, guahaozixunjieguo,map_result);

                return map_result;
            }

            @ResponseBody
            @RequestMapping("xiaoyuanyishengDeleteGuahaozixunjieguoJson")
            public HashMap xiaoyuanyishengDeleteGuahaozixunjieguoJson(HttpServletRequest request,HttpServletResponse response,HttpSession session,Integer id){
                logger.info("请求访问userDeleteBookJson...");
                HashMap<String, Object> map_result = new HashMap<>();
                //调用服务层
                guahaozixunjieguoService.xiaoyuanyishengDeleteGuahaozixunjieguoJson(request, session, id,map_result);

                return map_result;
            }

            @ResponseBody
            @RequestMapping("xiaoyuanyishengUpdateGuahaozixunjieguoJson")
            public HashMap xiaoyuanyishengUpdateGuahaozixunjieguoJson(HttpServletRequest request,HttpServletResponse response,HttpSession session,Integer id){
                logger.info("请求访问xiaoyuanyishengUpdateGuahaozixunjieguoJson...");
                HashMap<String, Object> map_result = new HashMap<>();
                //调用服务层
                guahaozixunjieguoService.xiaoyuanyishengUpdateGuahaozixunjieguoJson(request, session,id,map_result);

                return map_result;
            }

            @ResponseBody
            @RequestMapping("xiaoyuanyishengUpdateGuahaozixunjieguoactJson")
            public HashMap xiaoyuanyishengUpdateGuahaozixunjieguoactJson(HttpServletRequest request,HttpServletResponse response,HttpSession session,@RequestBody Guahaozixunjieguo guahaozixunjieguo){
                logger.info("请求访问xiaoyuanyishengUpdateGuahaozixunjieguoactJson...");
                HashMap<String, Object> map_result = new HashMap<>();
                //调用服务层
                guahaozixunjieguoService.xiaoyuanyishengUpdateGuahaozixunjieguoactJson(request, session, guahaozixunjieguo,map_result);

                return map_result;
            }

            @ResponseBody
            @RequestMapping("xiaoyuanyishengGuahaozixunjieguoListJson")
            public HashMap xiaoyuanyishengGuahaozixunjieguoListJson(HttpServletRequest request,HttpServletResponse response,HttpSession session){
                logger.info("请求访问xiaoyuanyishengGuahaozixunjieguoListJson...");
                HashMap<String, Object> map_result = new HashMap<>();
                //调用服务层
                guahaozixunjieguoService.xiaoyuanyishengGuahaozixunjieguoListJson(request, session,map_result);

                return map_result;
            }
            @ResponseBody
            @RequestMapping("xyyiliaoyhAddGuahaozixunjieguoJson")
            public HashMap xyyiliaoyhAddGuahaozixunjieguoJson(HttpServletRequest request, HttpServletResponse response, HttpSession session){
                logger.info("请求访问addGuahaozixunjieguoJson...");
                HashMap<String, Object> map_result = new HashMap<>();
                //调用服务层
                guahaozixunjieguoService.xyyiliaoyhAddGuahaozixunjieguoJson(request, session,map_result);

                return map_result;
            }

            @ResponseBody
            @RequestMapping("xyyiliaoyhAddGuahaozixunjieguoactJson")
            public HashMap xyyiliaoyhAddGuahaozixunjieguoactJson(HttpServletRequest request,HttpServletResponse response,HttpSession session,@RequestBody Guahaozixunjieguo guahaozixunjieguo){
                logger.info("请求访问xyyiliaoyhAddGuahaozixunjieguoactJson...");
                HashMap<String, Object> map_result = new HashMap<>();
                //调用服务层
                guahaozixunjieguoService.xyyiliaoyhAddGuahaozixunjieguoactJson(request, session, guahaozixunjieguo,map_result);

                return map_result;
            }

            @ResponseBody
            @RequestMapping("xyyiliaoyhDeleteGuahaozixunjieguoJson")
            public HashMap xyyiliaoyhDeleteGuahaozixunjieguoJson(HttpServletRequest request,HttpServletResponse response,HttpSession session,Integer id){
                logger.info("请求访问userDeleteBookJson...");
                HashMap<String, Object> map_result = new HashMap<>();
                //调用服务层
                guahaozixunjieguoService.xyyiliaoyhDeleteGuahaozixunjieguoJson(request, session, id,map_result);

                return map_result;
            }

            @ResponseBody
            @RequestMapping("xyyiliaoyhUpdateGuahaozixunjieguoJson")
            public HashMap xyyiliaoyhUpdateGuahaozixunjieguoJson(HttpServletRequest request,HttpServletResponse response,HttpSession session,Integer id){
                logger.info("请求访问xyyiliaoyhUpdateGuahaozixunjieguoJson...");
                HashMap<String, Object> map_result = new HashMap<>();
                //调用服务层
                guahaozixunjieguoService.xyyiliaoyhUpdateGuahaozixunjieguoJson(request, session,id,map_result);

                return map_result;
            }

            @ResponseBody
            @RequestMapping("xyyiliaoyhUpdateGuahaozixunjieguoactJson")
            public HashMap xyyiliaoyhUpdateGuahaozixunjieguoactJson(HttpServletRequest request,HttpServletResponse response,HttpSession session,@RequestBody Guahaozixunjieguo guahaozixunjieguo){
                logger.info("请求访问xyyiliaoyhUpdateGuahaozixunjieguoactJson...");
                HashMap<String, Object> map_result = new HashMap<>();
                //调用服务层
                guahaozixunjieguoService.xyyiliaoyhUpdateGuahaozixunjieguoactJson(request, session, guahaozixunjieguo,map_result);

                return map_result;
            }

            @ResponseBody
            @RequestMapping("xyyiliaoyhGuahaozixunjieguoListJson")
            public HashMap xyyiliaoyhGuahaozixunjieguoListJson(HttpServletRequest request,HttpServletResponse response,HttpSession session){
                logger.info("请求访问xyyiliaoyhGuahaozixunjieguoListJson...");
                HashMap<String, Object> map_result = new HashMap<>();
                //调用服务层
                guahaozixunjieguoService.xyyiliaoyhGuahaozixunjieguoListJson(request, session,map_result);

                return map_result;
            }

}

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
public class JiankangdanganController {

private Logger logger = LoggerFactory.getLogger(JiankangdanganController.class);

    @Autowired
    JiankangdanganServiceImpl jiankangdanganService;

    //=================Json=======================


    @ResponseBody
    @RequestMapping("addJiankangdanganJson")
    public HashMap addJiankangdanganJson(HttpServletRequest request, HttpServletResponse response, HttpSession session){
        logger.info("请求访问addJiankangdanganJson...");
        HashMap<String, Object> map_result = new HashMap<>();
        //调用服务层
        jiankangdanganService.addJiankangdanganJson(request, session,map_result);

        return map_result;
    }

    @ResponseBody
    @RequestMapping("addJiankangdanganactJson")
    public HashMap addJiankangdanganactJson(HttpServletRequest request,HttpServletResponse response,HttpSession session,@RequestBody Jiankangdangan jiankangdangan){
        logger.info("请求访问addJiankangdanganactJson...");
        HashMap<String, Object> map_result = new HashMap<>();
        //调用服务层
        jiankangdanganService.addJiankangdanganactJson(request, session, jiankangdangan,map_result);

        return map_result;
    }

    @ResponseBody
    @RequestMapping("deleteJiankangdanganJson")
    public HashMap deleteJiankangdanganJson(HttpServletRequest request,HttpServletResponse response,HttpSession session,Integer id){
        logger.info("请求访问deleteJiankangdanganJson...");
        HashMap<String, Object> map_result = new HashMap<>();
        //调用服务层
        jiankangdanganService.deleteJiankangdanganJson(request, session, id,map_result);

        return map_result;
    }

    @ResponseBody
    @RequestMapping("updateJiankangdanganJson")
    public HashMap updateJiankangdanganJson(HttpServletRequest request,HttpServletResponse response,HttpSession session,Integer id){
        logger.info("请求访问updateJiankangdanganJson...");
        HashMap<String, Object> map_result = new HashMap<>();
        //调用服务层
        jiankangdanganService.updateJiankangdanganJson(request, session,id,map_result);

        return map_result;
    }

    @ResponseBody
    @RequestMapping("updateJiankangdanganactJson")
    public HashMap updateJiankangdanganactJson(HttpServletRequest request,HttpServletResponse response,HttpSession session,@RequestBody Jiankangdangan jiankangdangan){
        logger.info("请求访问updateJiankangdanganactJson...");
        HashMap<String, Object> map_result = new HashMap<>();
        //调用服务层
        jiankangdanganService.updateJiankangdanganactJson(request, session, jiankangdangan,map_result);

        return map_result;
    }

    @ResponseBody
    @RequestMapping("jiankangdanganListJson")
    public HashMap jiankangdanganListJson(HttpServletRequest request,HttpServletResponse response,HttpSession session){
        logger.info("请求访问jiankangdanganListJson...");
        HashMap<String, Object> map_result = new HashMap<>();
        //调用服务层
        jiankangdanganService.jiankangdanganListJson(request, session,map_result);

        return map_result;
    }



    // ====================role====================
            @ResponseBody
            @RequestMapping("xyyiliaoyhAddJiankangdanganJson")
            public HashMap xyyiliaoyhAddJiankangdanganJson(HttpServletRequest request, HttpServletResponse response, HttpSession session){
                logger.info("请求访问addJiankangdanganJson...");
                HashMap<String, Object> map_result = new HashMap<>();
                //调用服务层
                jiankangdanganService.xyyiliaoyhAddJiankangdanganJson(request, session,map_result);

                return map_result;
            }

            @ResponseBody
            @RequestMapping("xyyiliaoyhAddJiankangdanganactJson")
            public HashMap xyyiliaoyhAddJiankangdanganactJson(HttpServletRequest request,HttpServletResponse response,HttpSession session,@RequestBody Jiankangdangan jiankangdangan){
                logger.info("请求访问xyyiliaoyhAddJiankangdanganactJson...");
                HashMap<String, Object> map_result = new HashMap<>();
                //调用服务层
                jiankangdanganService.xyyiliaoyhAddJiankangdanganactJson(request, session, jiankangdangan,map_result);

                return map_result;
            }

            @ResponseBody
            @RequestMapping("xyyiliaoyhDeleteJiankangdanganJson")
            public HashMap xyyiliaoyhDeleteJiankangdanganJson(HttpServletRequest request,HttpServletResponse response,HttpSession session,Integer id){
                logger.info("请求访问userDeleteBookJson...");
                HashMap<String, Object> map_result = new HashMap<>();
                //调用服务层
                jiankangdanganService.xyyiliaoyhDeleteJiankangdanganJson(request, session, id,map_result);

                return map_result;
            }

            @ResponseBody
            @RequestMapping("xyyiliaoyhUpdateJiankangdanganJson")
            public HashMap xyyiliaoyhUpdateJiankangdanganJson(HttpServletRequest request,HttpServletResponse response,HttpSession session,Integer id){
                logger.info("请求访问xyyiliaoyhUpdateJiankangdanganJson...");
                HashMap<String, Object> map_result = new HashMap<>();
                //调用服务层
                jiankangdanganService.xyyiliaoyhUpdateJiankangdanganJson(request, session,id,map_result);

                return map_result;
            }

            @ResponseBody
            @RequestMapping("xyyiliaoyhUpdateJiankangdanganactJson")
            public HashMap xyyiliaoyhUpdateJiankangdanganactJson(HttpServletRequest request,HttpServletResponse response,HttpSession session,@RequestBody Jiankangdangan jiankangdangan){
                logger.info("请求访问xyyiliaoyhUpdateJiankangdanganactJson...");
                HashMap<String, Object> map_result = new HashMap<>();
                //调用服务层
                jiankangdanganService.xyyiliaoyhUpdateJiankangdanganactJson(request, session, jiankangdangan,map_result);

                return map_result;
            }

            @ResponseBody
            @RequestMapping("xyyiliaoyhJiankangdanganListJson")
            public HashMap xyyiliaoyhJiankangdanganListJson(HttpServletRequest request,HttpServletResponse response,HttpSession session){
                logger.info("请求访问xyyiliaoyhJiankangdanganListJson...");
                HashMap<String, Object> map_result = new HashMap<>();
                //调用服务层
                jiankangdanganService.xyyiliaoyhJiankangdanganListJson(request, session,map_result);

                return map_result;
            }

}

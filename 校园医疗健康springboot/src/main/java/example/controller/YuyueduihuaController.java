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
public class YuyueduihuaController {

private Logger logger = LoggerFactory.getLogger(YuyueduihuaController.class);

    @Autowired
    YuyueduihuaServiceImpl yuyueduihuaService;

    //=================Json=======================


    @ResponseBody
    @RequestMapping("addYuyueduihuaJson")
    public HashMap addYuyueduihuaJson(HttpServletRequest request, HttpServletResponse response, HttpSession session){
        logger.info("请求访问addYuyueduihuaJson...");
        HashMap<String, Object> map_result = new HashMap<>();
        //调用服务层
        yuyueduihuaService.addYuyueduihuaJson(request, session,map_result);

        return map_result;
    }

    @ResponseBody
    @RequestMapping("addYuyueduihuaactJson")
    public HashMap addYuyueduihuaactJson(HttpServletRequest request,HttpServletResponse response,HttpSession session,@RequestBody Yuyueduihua yuyueduihua){
        logger.info("请求访问addYuyueduihuaactJson...");
        HashMap<String, Object> map_result = new HashMap<>();
        //调用服务层
        yuyueduihuaService.addYuyueduihuaactJson(request, session, yuyueduihua,map_result);

        return map_result;
    }

    @ResponseBody
    @RequestMapping("deleteYuyueduihuaJson")
    public HashMap deleteYuyueduihuaJson(HttpServletRequest request,HttpServletResponse response,HttpSession session,Integer id){
        logger.info("请求访问deleteYuyueduihuaJson...");
        HashMap<String, Object> map_result = new HashMap<>();
        //调用服务层
        yuyueduihuaService.deleteYuyueduihuaJson(request, session, id,map_result);

        return map_result;
    }

    @ResponseBody
    @RequestMapping("updateYuyueduihuaJson")
    public HashMap updateYuyueduihuaJson(HttpServletRequest request,HttpServletResponse response,HttpSession session,Integer id){
        logger.info("请求访问updateYuyueduihuaJson...");
        HashMap<String, Object> map_result = new HashMap<>();
        //调用服务层
        yuyueduihuaService.updateYuyueduihuaJson(request, session,id,map_result);

        return map_result;
    }

    @ResponseBody
    @RequestMapping("updateYuyueduihuaactJson")
    public HashMap updateYuyueduihuaactJson(HttpServletRequest request,HttpServletResponse response,HttpSession session,@RequestBody Yuyueduihua yuyueduihua){
        logger.info("请求访问updateYuyueduihuaactJson...");
        HashMap<String, Object> map_result = new HashMap<>();
        //调用服务层
        yuyueduihuaService.updateYuyueduihuaactJson(request, session, yuyueduihua,map_result);

        return map_result;
    }

    @ResponseBody
    @RequestMapping("yuyueduihuaListJson")
    public HashMap yuyueduihuaListJson(HttpServletRequest request,HttpServletResponse response,HttpSession session){
        logger.info("请求访问yuyueduihuaListJson...");
        HashMap<String, Object> map_result = new HashMap<>();
        //调用服务层
        yuyueduihuaService.yuyueduihuaListJson(request, session,map_result);

        return map_result;
    }



    // ====================role====================

}

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
public class YiliaoyaopingtixingController {

private Logger logger = LoggerFactory.getLogger(YiliaoyaopingtixingController.class);

    @Autowired
    YiliaoyaopingtixingServiceImpl yiliaoyaopingtixingService;

    //=================Json=======================


    @ResponseBody
    @RequestMapping("addYiliaoyaopingtixingJson")
    public HashMap addYiliaoyaopingtixingJson(HttpServletRequest request, HttpServletResponse response, HttpSession session){
        logger.info("请求访问addYiliaoyaopingtixingJson...");
        HashMap<String, Object> map_result = new HashMap<>();
        //调用服务层
        yiliaoyaopingtixingService.addYiliaoyaopingtixingJson(request, session,map_result);

        return map_result;
    }

    @ResponseBody
    @RequestMapping("addYiliaoyaopingtixingactJson")
    public HashMap addYiliaoyaopingtixingactJson(HttpServletRequest request,HttpServletResponse response,HttpSession session,@RequestBody Yiliaoyaopingtixing yiliaoyaopingtixing){
        logger.info("请求访问addYiliaoyaopingtixingactJson...");
        HashMap<String, Object> map_result = new HashMap<>();
        //调用服务层
        yiliaoyaopingtixingService.addYiliaoyaopingtixingactJson(request, session, yiliaoyaopingtixing,map_result);

        return map_result;
    }

    @ResponseBody
    @RequestMapping("deleteYiliaoyaopingtixingJson")
    public HashMap deleteYiliaoyaopingtixingJson(HttpServletRequest request,HttpServletResponse response,HttpSession session,Integer id){
        logger.info("请求访问deleteYiliaoyaopingtixingJson...");
        HashMap<String, Object> map_result = new HashMap<>();
        //调用服务层
        yiliaoyaopingtixingService.deleteYiliaoyaopingtixingJson(request, session, id,map_result);

        return map_result;
    }

    @ResponseBody
    @RequestMapping("updateYiliaoyaopingtixingJson")
    public HashMap updateYiliaoyaopingtixingJson(HttpServletRequest request,HttpServletResponse response,HttpSession session,Integer id){
        logger.info("请求访问updateYiliaoyaopingtixingJson...");
        HashMap<String, Object> map_result = new HashMap<>();
        //调用服务层
        yiliaoyaopingtixingService.updateYiliaoyaopingtixingJson(request, session,id,map_result);

        return map_result;
    }

    @ResponseBody
    @RequestMapping("updateYiliaoyaopingtixingactJson")
    public HashMap updateYiliaoyaopingtixingactJson(HttpServletRequest request,HttpServletResponse response,HttpSession session,@RequestBody Yiliaoyaopingtixing yiliaoyaopingtixing){
        logger.info("请求访问updateYiliaoyaopingtixingactJson...");
        HashMap<String, Object> map_result = new HashMap<>();
        //调用服务层
        yiliaoyaopingtixingService.updateYiliaoyaopingtixingactJson(request, session, yiliaoyaopingtixing,map_result);

        return map_result;
    }

    @ResponseBody
    @RequestMapping("yiliaoyaopingtixingListJson")
    public HashMap yiliaoyaopingtixingListJson(HttpServletRequest request,HttpServletResponse response,HttpSession session){
        logger.info("请求访问yiliaoyaopingtixingListJson...");
        HashMap<String, Object> map_result = new HashMap<>();
        //调用服务层
        yiliaoyaopingtixingService.yiliaoyaopingtixingListJson(request, session,map_result);

        return map_result;
    }



    // ====================role====================

}

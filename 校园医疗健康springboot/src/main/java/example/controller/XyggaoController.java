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
public class XyggaoController {

private Logger logger = LoggerFactory.getLogger(XyggaoController.class);

    @Autowired
    XyggaoServiceImpl xyggaoService;

    //=================Json=======================


    @ResponseBody
    @RequestMapping("addXyggaoJson")
    public HashMap addXyggaoJson(HttpServletRequest request, HttpServletResponse response, HttpSession session){
        logger.info("请求访问addXyggaoJson...");
        HashMap<String, Object> map_result = new HashMap<>();
        //调用服务层
        xyggaoService.addXyggaoJson(request, session,map_result);

        return map_result;
    }

    @ResponseBody
    @RequestMapping("addXyggaoactJson")
    public HashMap addXyggaoactJson(HttpServletRequest request,HttpServletResponse response,HttpSession session,@RequestBody Xyggao xyggao){
        logger.info("请求访问addXyggaoactJson...");
        HashMap<String, Object> map_result = new HashMap<>();
        //调用服务层
        xyggaoService.addXyggaoactJson(request, session, xyggao,map_result);

        return map_result;
    }

    @ResponseBody
    @RequestMapping("deleteXyggaoJson")
    public HashMap deleteXyggaoJson(HttpServletRequest request,HttpServletResponse response,HttpSession session,Integer id){
        logger.info("请求访问deleteXyggaoJson...");
        HashMap<String, Object> map_result = new HashMap<>();
        //调用服务层
        xyggaoService.deleteXyggaoJson(request, session, id,map_result);

        return map_result;
    }

    @ResponseBody
    @RequestMapping("updateXyggaoJson")
    public HashMap updateXyggaoJson(HttpServletRequest request,HttpServletResponse response,HttpSession session,Integer id){
        logger.info("请求访问updateXyggaoJson...");
        HashMap<String, Object> map_result = new HashMap<>();
        //调用服务层
        xyggaoService.updateXyggaoJson(request, session,id,map_result);

        return map_result;
    }

    @ResponseBody
    @RequestMapping("updateXyggaoactJson")
    public HashMap updateXyggaoactJson(HttpServletRequest request,HttpServletResponse response,HttpSession session,@RequestBody Xyggao xyggao){
        logger.info("请求访问updateXyggaoactJson...");
        HashMap<String, Object> map_result = new HashMap<>();
        //调用服务层
        xyggaoService.updateXyggaoactJson(request, session, xyggao,map_result);

        return map_result;
    }

    @ResponseBody
    @RequestMapping("xyggaoListJson")
    public HashMap xyggaoListJson(HttpServletRequest request,HttpServletResponse response,HttpSession session){
        logger.info("请求访问xyggaoListJson...");
        HashMap<String, Object> map_result = new HashMap<>();
        //调用服务层
        xyggaoService.xyggaoListJson(request, session,map_result);

        return map_result;
    }



    // ====================role====================


        @ResponseBody
        @RequestMapping("searchXyggaoJson")
        public HashMap searchXyggaoJson(HttpServletRequest request,HttpServletResponse response,HttpSession session,String search){
            logger.info("请求访问searchXyggaoJson中....");
            HashMap<String, Object> map_result = new HashMap<>();
            if (search == null){
                search = "";
            }
            xyggaoService.searchXyggaoJson(request,session,search,map_result);

            return map_result;
        }

        @ResponseBody
        @RequestMapping("xyggaoDetailsJson")
        public HashMap xyggaoDetailsJson(HttpServletRequest request,HttpServletResponse response,HttpSession session,Integer id){

            logger.info("请求访问xyggaoDetailsJson中....");

            HashMap<String, Object> map_result = new HashMap<>();

            xyggaoService.xyggaoDetailsJson(request,session,id,map_result);

            return map_result;
        }
}

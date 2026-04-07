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
public class XytijianshixiangController {

private Logger logger = LoggerFactory.getLogger(XytijianshixiangController.class);

    @Autowired
    XytijianshixiangServiceImpl xytijianshixiangService;

    //=================Json=======================


    @ResponseBody
    @RequestMapping("addXytijianshixiangJson")
    public HashMap addXytijianshixiangJson(HttpServletRequest request, HttpServletResponse response, HttpSession session){
        logger.info("请求访问addXytijianshixiangJson...");
        HashMap<String, Object> map_result = new HashMap<>();
        //调用服务层
        xytijianshixiangService.addXytijianshixiangJson(request, session,map_result);

        return map_result;
    }

    @ResponseBody
    @RequestMapping("addXytijianshixiangactJson")
    public HashMap addXytijianshixiangactJson(HttpServletRequest request,HttpServletResponse response,HttpSession session,@RequestBody Xytijianshixiang xytijianshixiang){
        logger.info("请求访问addXytijianshixiangactJson...");
        HashMap<String, Object> map_result = new HashMap<>();
        //调用服务层
        xytijianshixiangService.addXytijianshixiangactJson(request, session, xytijianshixiang,map_result);

        return map_result;
    }

    @ResponseBody
    @RequestMapping("deleteXytijianshixiangJson")
    public HashMap deleteXytijianshixiangJson(HttpServletRequest request,HttpServletResponse response,HttpSession session,Integer id){
        logger.info("请求访问deleteXytijianshixiangJson...");
        HashMap<String, Object> map_result = new HashMap<>();
        //调用服务层
        xytijianshixiangService.deleteXytijianshixiangJson(request, session, id,map_result);

        return map_result;
    }

    @ResponseBody
    @RequestMapping("updateXytijianshixiangJson")
    public HashMap updateXytijianshixiangJson(HttpServletRequest request,HttpServletResponse response,HttpSession session,Integer id){
        logger.info("请求访问updateXytijianshixiangJson...");
        HashMap<String, Object> map_result = new HashMap<>();
        //调用服务层
        xytijianshixiangService.updateXytijianshixiangJson(request, session,id,map_result);

        return map_result;
    }

    @ResponseBody
    @RequestMapping("updateXytijianshixiangactJson")
    public HashMap updateXytijianshixiangactJson(HttpServletRequest request,HttpServletResponse response,HttpSession session,@RequestBody Xytijianshixiang xytijianshixiang){
        logger.info("请求访问updateXytijianshixiangactJson...");
        HashMap<String, Object> map_result = new HashMap<>();
        //调用服务层
        xytijianshixiangService.updateXytijianshixiangactJson(request, session, xytijianshixiang,map_result);

        return map_result;
    }

    @ResponseBody
    @RequestMapping("xytijianshixiangListJson")
    public HashMap xytijianshixiangListJson(HttpServletRequest request,HttpServletResponse response,HttpSession session){
        logger.info("请求访问xytijianshixiangListJson...");
        HashMap<String, Object> map_result = new HashMap<>();
        //调用服务层
        xytijianshixiangService.xytijianshixiangListJson(request, session,map_result);

        return map_result;
    }



    // ====================role====================
            @ResponseBody
            @RequestMapping("xiaoyuanyishengAddXytijianshixiangJson")
            public HashMap xiaoyuanyishengAddXytijianshixiangJson(HttpServletRequest request, HttpServletResponse response, HttpSession session){
                logger.info("请求访问addXytijianshixiangJson...");
                HashMap<String, Object> map_result = new HashMap<>();
                //调用服务层
                xytijianshixiangService.xiaoyuanyishengAddXytijianshixiangJson(request, session,map_result);

                return map_result;
            }

            @ResponseBody
            @RequestMapping("xiaoyuanyishengAddXytijianshixiangactJson")
            public HashMap xiaoyuanyishengAddXytijianshixiangactJson(HttpServletRequest request,HttpServletResponse response,HttpSession session,@RequestBody Xytijianshixiang xytijianshixiang){
                logger.info("请求访问xiaoyuanyishengAddXytijianshixiangactJson...");
                HashMap<String, Object> map_result = new HashMap<>();
                //调用服务层
                xytijianshixiangService.xiaoyuanyishengAddXytijianshixiangactJson(request, session, xytijianshixiang,map_result);

                return map_result;
            }

            @ResponseBody
            @RequestMapping("xiaoyuanyishengDeleteXytijianshixiangJson")
            public HashMap xiaoyuanyishengDeleteXytijianshixiangJson(HttpServletRequest request,HttpServletResponse response,HttpSession session,Integer id){
                logger.info("请求访问userDeleteBookJson...");
                HashMap<String, Object> map_result = new HashMap<>();
                //调用服务层
                xytijianshixiangService.xiaoyuanyishengDeleteXytijianshixiangJson(request, session, id,map_result);

                return map_result;
            }

            @ResponseBody
            @RequestMapping("xiaoyuanyishengUpdateXytijianshixiangJson")
            public HashMap xiaoyuanyishengUpdateXytijianshixiangJson(HttpServletRequest request,HttpServletResponse response,HttpSession session,Integer id){
                logger.info("请求访问xiaoyuanyishengUpdateXytijianshixiangJson...");
                HashMap<String, Object> map_result = new HashMap<>();
                //调用服务层
                xytijianshixiangService.xiaoyuanyishengUpdateXytijianshixiangJson(request, session,id,map_result);

                return map_result;
            }

            @ResponseBody
            @RequestMapping("xiaoyuanyishengUpdateXytijianshixiangactJson")
            public HashMap xiaoyuanyishengUpdateXytijianshixiangactJson(HttpServletRequest request,HttpServletResponse response,HttpSession session,@RequestBody Xytijianshixiang xytijianshixiang){
                logger.info("请求访问xiaoyuanyishengUpdateXytijianshixiangactJson...");
                HashMap<String, Object> map_result = new HashMap<>();
                //调用服务层
                xytijianshixiangService.xiaoyuanyishengUpdateXytijianshixiangactJson(request, session, xytijianshixiang,map_result);

                return map_result;
            }

            @ResponseBody
            @RequestMapping("xiaoyuanyishengXytijianshixiangListJson")
            public HashMap xiaoyuanyishengXytijianshixiangListJson(HttpServletRequest request,HttpServletResponse response,HttpSession session){
                logger.info("请求访问xiaoyuanyishengXytijianshixiangListJson...");
                HashMap<String, Object> map_result = new HashMap<>();
                //调用服务层
                xytijianshixiangService.xiaoyuanyishengXytijianshixiangListJson(request, session,map_result);

                return map_result;
            }


        @ResponseBody
        @RequestMapping("searchXytijianshixiangJson")
        public HashMap searchXytijianshixiangJson(HttpServletRequest request,HttpServletResponse response,HttpSession session,String search){
            logger.info("请求访问searchXytijianshixiangJson中....");
            HashMap<String, Object> map_result = new HashMap<>();
            if (search == null){
                search = "";
            }
            xytijianshixiangService.searchXytijianshixiangJson(request,session,search,map_result);

            return map_result;
        }

        @ResponseBody
        @RequestMapping("xytijianshixiangDetailsJson")
        public HashMap xytijianshixiangDetailsJson(HttpServletRequest request,HttpServletResponse response,HttpSession session,Integer id){

            logger.info("请求访问xytijianshixiangDetailsJson中....");

            HashMap<String, Object> map_result = new HashMap<>();

            xytijianshixiangService.xytijianshixiangDetailsJson(request,session,id,map_result);

            return map_result;
        }
}

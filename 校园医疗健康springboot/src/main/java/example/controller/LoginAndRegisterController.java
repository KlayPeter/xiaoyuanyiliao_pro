package example.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import example.service.LoginAndRegisterServiceImpl;
import example.util.FileUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import java.io.IOException;
import java.util.HashMap;

@Controller()
@RequestMapping("/")
@MultipartConfig
public class LoginAndRegisterController {

    //创建日志记录器
    private Logger logger = LoggerFactory.getLogger(LoginAndRegisterController.class);

    @Autowired
    LoginAndRegisterServiceImpl loginAndRegisterService;

    //======================Json====================
    @ResponseBody
    @RequestMapping("loginactJson")
    public HashMap logonactJosn(HttpServletRequest request,HttpServletResponse response,HttpSession session,@RequestBody HashMap<String,String> rucan){
        logger.info("请求访问loginactJson中...");
        HashMap<String, Object> map_result = new HashMap<>();


        String role = rucan.get("role");

        if (role == null || "".equals(role)){
            // 未选择登录角色时,跳转到登录页面
            request.setAttribute("message", "请选择登录角色");
            map_result.put("message", "请选择登录角色");
            return map_result;
        }
        //验证账号和密码
        loginAndRegisterService.loginactJson(rucan,session,map_result);

        return map_result;
    }

    @ResponseBody
    @RequestMapping("registeractJson")
    public HashMap registeractJson(HttpServletRequest request,HttpServletResponse response,HttpSession session,@RequestBody HashMap<String,String> rucan){
        logger.info("请求访问registeractJson中...");
        HashMap<String, Object> map_result = new HashMap<>();

        String password = rucan.get("password");

        String repassword = rucan.get("repassword");

        String role = rucan.get("role");

        if (role == null || "".equals(role)){
            // 未选择登录角色时,进行提示
            map_result.put("message", "请选择注册角色");
            return map_result;
        }
        if (password == null || repassword == null || !password.equals(repassword)){
            // 两次输入密码不一致时,进行提示
            map_result.put("message", "输入密码不一致");
            return map_result;
        }
        //进行注册
        loginAndRegisterService.registeractJson(rucan, session,map_result);

        return map_result;
    }

    @ResponseBody
    @RequestMapping("logoutJson")
    public HashMap logoutJson(HttpServletRequest request, HttpServletResponse response, HttpSession session){
        logger.info("请求访问logoutJson中...");
        HashMap<String, Object> map_result = new HashMap<>();
        session.invalidate();
        return map_result;
    }

    @ResponseBody
    @RequestMapping("uploadFile")
    public HashMap uploadFile(HttpServletRequest request, HttpServletResponse response, HttpSession session, @RequestBody Part file) throws ServletException, IOException {
        logger.info("请求访问uploadFile中...");
        HashMap<String, Object> map_result = new HashMap<>();
        //判断上传的文件是否为空
        if (file !=null && file.getSize() != 0){
            String fileUrl = FileUtil.fileUpload(request, response, file);
            map_result.put("fileUrl", fileUrl);
        }
        return map_result;
    }
}

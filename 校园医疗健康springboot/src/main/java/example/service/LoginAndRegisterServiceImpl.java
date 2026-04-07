package example.service;

import example.dao.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import example.pojo.*;

import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class LoginAndRegisterServiceImpl {

    private Logger logger = LoggerFactory.getLogger(LoginAndRegisterServiceImpl.class);

                @Autowired
            private AdminMapper adminDao;
            @Autowired
            private XiaoyuanyishengMapper xiaoyuanyishengDao;
            @Autowired
            private XyyiliaoyhMapper xyyiliaoyhDao;

    public void loginactJson(HashMap<String, String> hashMap, HttpSession session,HashMap<String,Object> map_result) {
        //记录日志
        logger.info("进入loginactJson方法...");

                if ("管理员".equals(hashMap.get("role"))) {
                    AdminExample adminExample = new AdminExample();
                    adminExample.createCriteria().andUsernameEqualTo(hashMap.get("username")).andPasswordEqualTo(hashMap.get("password"));
                    List<Admin> admins = adminDao.selectByExample(adminExample);
                    if (admins.size() <= 0) {
                        map_result.put("message","账号或密码错误");
                        return ;
                    }
                    session.setAttribute("userinfo", admins.get(0));
                    session.setAttribute("role", hashMap.get("role"));
                    map_result.put("userinfo", admins.get(0));
                    map_result.put("role",hashMap.get("role"));
                    map_result.put("message", "登录成功");
                    return;
                }
                if ("校园医生".equals(hashMap.get("role"))) {
                    XiaoyuanyishengExample xiaoyuanyishengExample = new XiaoyuanyishengExample();
                    xiaoyuanyishengExample.createCriteria().andUsernameEqualTo(hashMap.get("username")).andPasswordEqualTo(hashMap.get("password"));
                    List<Xiaoyuanyisheng> xiaoyuanyishengs = xiaoyuanyishengDao.selectByExample(xiaoyuanyishengExample);
                    if (xiaoyuanyishengs.size() <= 0) {
                        map_result.put("message","账号或密码错误");
                        return ;
                    }
                    session.setAttribute("userinfo", xiaoyuanyishengs.get(0));
                    session.setAttribute("role", hashMap.get("role"));
                    map_result.put("userinfo", xiaoyuanyishengs.get(0));
                    map_result.put("role",hashMap.get("role"));
                    map_result.put("message", "登录成功");
                    return;
                }
                if ("校园用户".equals(hashMap.get("role"))) {
                    XyyiliaoyhExample xyyiliaoyhExample = new XyyiliaoyhExample();
                    xyyiliaoyhExample.createCriteria().andUsernameEqualTo(hashMap.get("username")).andPasswordEqualTo(hashMap.get("password"));
                    List<Xyyiliaoyh> xyyiliaoyhs = xyyiliaoyhDao.selectByExample(xyyiliaoyhExample);
                    if (xyyiliaoyhs.size() <= 0) {
                        map_result.put("message","账号或密码错误");
                        return ;
                    }
                    session.setAttribute("userinfo", xyyiliaoyhs.get(0));
                    session.setAttribute("role", hashMap.get("role"));
                    map_result.put("userinfo", xyyiliaoyhs.get(0));
                    map_result.put("role",hashMap.get("role"));
                    map_result.put("message", "登录成功");
                    return;
                }
    }

    public void registeractJson(HashMap<String, String> hashMap, HttpSession session,HashMap<String,Object> map_result) {
        //记录日志
        logger.info("进入registeract方法...");
                if ("管理员".equals(hashMap.get("role"))) {
                    AdminExample adminExample = new AdminExample();
                    adminExample.createCriteria().andUsernameEqualTo(hashMap.get("username"));
                    List<Admin> admins = adminDao.selectByExample(adminExample);
                    if (admins.size() > 0) {
                        map_result.put("message", "当前账号已存在，请重新输入");
                        return;
                    }
                    Admin admin = new Admin();
                    admin.setUsername(hashMap.get("username"));
                    admin.setPassword(hashMap.get("password"));
                    adminDao.insert(admin);
                    map_result.put("message", "注册成功，请登录");
                    return;
                }
                if ("校园医生".equals(hashMap.get("role"))) {
                    XiaoyuanyishengExample xiaoyuanyishengExample = new XiaoyuanyishengExample();
                    xiaoyuanyishengExample.createCriteria().andUsernameEqualTo(hashMap.get("username"));
                    List<Xiaoyuanyisheng> xiaoyuanyishengs = xiaoyuanyishengDao.selectByExample(xiaoyuanyishengExample);
                    if (xiaoyuanyishengs.size() > 0) {
                        map_result.put("message", "当前账号已存在，请重新输入");
                        return;
                    }
                    Xiaoyuanyisheng xiaoyuanyisheng = new Xiaoyuanyisheng();
                    xiaoyuanyisheng.setUsername(hashMap.get("username"));
                    xiaoyuanyisheng.setPassword(hashMap.get("password"));
                    xiaoyuanyishengDao.insert(xiaoyuanyisheng);
                    map_result.put("message", "注册成功，请登录");
                    return;
                }
                if ("校园用户".equals(hashMap.get("role"))) {
                    XyyiliaoyhExample xyyiliaoyhExample = new XyyiliaoyhExample();
                    xyyiliaoyhExample.createCriteria().andUsernameEqualTo(hashMap.get("username"));
                    List<Xyyiliaoyh> xyyiliaoyhs = xyyiliaoyhDao.selectByExample(xyyiliaoyhExample);
                    if (xyyiliaoyhs.size() > 0) {
                        map_result.put("message", "当前账号已存在，请重新输入");
                        return;
                    }
                    Xyyiliaoyh xyyiliaoyh = new Xyyiliaoyh();
                    xyyiliaoyh.setUsername(hashMap.get("username"));
                    xyyiliaoyh.setPassword(hashMap.get("password"));
                    xyyiliaoyh.setXyyiliaoyhname("神秘名称");
                    xyyiliaoyh.setXyyiliaoyhsex("男");
                    xyyiliaoyh.setXyyiliaoyhage("18");
                    xyyiliaoyh.setXyyiliaoyhphone("未知");
                    xyyiliaoyh.setXyyiliaoyhimg("img.png");
                    xyyiliaoyh.setCollege("未知");
                    xyyiliaoyhDao.insert(xyyiliaoyh);
                    map_result.put("message", "注册成功，请登录");
                    return;
                }
    }

}

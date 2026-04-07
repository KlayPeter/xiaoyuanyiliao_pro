package example.controller;

import example.dao.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import example.pojo.*;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Controller()
@RequestMapping("/")
public class IndexController {

    private Logger logger = LoggerFactory.getLogger(IndexController.class);

                @Autowired
            XiaoyuanyishengMapper xiaoyuanyishengDao;
            @Autowired
            XytijianshixiangMapper xytijianshixiangDao;
            @Autowired
            XyggaoMapper xyggaoDao;


    @ResponseBody
    @RequestMapping("/chat")
    public String chat(HttpServletRequest yuanshengrequest) {
        RestTemplate restTemplate = new RestTemplate();
        String message = yuanshengrequest.getParameter("message");
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json");
        headers.set("Authorization", "Bearer " + "sk-300cda58d7354dc5bf459afd1966509b");

        // 构建请求体
        DeepSeekRequest request = new DeepSeekRequest();
        request.setModel("deepseek-chat");
        request.setMessages(List.of(new DeepSeekRequest.Message("user", message+"。请用中文回答我。")));

        // 发送请求
        HttpEntity<DeepSeekRequest> entity = new HttpEntity<>(request, headers);
        ResponseEntity<DeepSeekResponse> response = restTemplate.exchange(
                "https://api.deepseek.com/v1/chat/completions", HttpMethod.POST, entity, DeepSeekResponse.class);

        // 解析响应
        if (response.getStatusCode().is2xxSuccessful() && response.getBody() != null) {
            return response.getBody().getChoices().get(0).getMessage().getContent();
        } else {
            throw new RuntimeException("Failed to call DeepSeek API: " + response.getStatusCode());
        }
    }

    @ResponseBody
    @RequestMapping("indexJson")
    public HashMap indexJson(HttpServletRequest request, HttpServletResponse response, HttpSession session){
        logger.info("请求访问indexJson中...");

        HashMap<String, Object> map_result = new HashMap<>();
                // 获取最新的6个校园医生信息
                List<Xiaoyuanyisheng> xiaoyuanyishengs = xiaoyuanyishengDao.selectByExample(new XiaoyuanyishengExample());
                //如果不足六个就展示全部
                if (xiaoyuanyishengs.size() >= 6){
                    List<Xiaoyuanyisheng> xiaoyuanyishengs1 = xiaoyuanyishengs.subList(xiaoyuanyishengs.size() - 6, xiaoyuanyishengs.size());
                    map_result.put("xiaoyuanyishengs", xiaoyuanyishengs1);
                }else {
                    map_result.put("xiaoyuanyishengs", xiaoyuanyishengs);
                }
                // 获取最新的6个校园体检事项信息
                List<Xytijianshixiang> xytijianshixiangs = xytijianshixiangDao.selectByExample(new XytijianshixiangExample());
                //如果不足六个就展示全部
                if (xytijianshixiangs.size() >= 6){
                    List<Xytijianshixiang> xytijianshixiangs1 = xytijianshixiangs.subList(xytijianshixiangs.size() - 6, xytijianshixiangs.size());
                    map_result.put("xytijianshixiangs", xytijianshixiangs1);
                }else {
                    map_result.put("xytijianshixiangs", xytijianshixiangs);
                }
                // 获取最新的6个校园公告信息
                List<Xyggao> xyggaos = xyggaoDao.selectByExample(new XyggaoExample());
                //如果不足六个就展示全部
                if (xyggaos.size() >= 6){
                    List<Xyggao> xyggaos1 = xyggaos.subList(xyggaos.size() - 6, xyggaos.size());
                    map_result.put("xyggaos", xyggaos1);
                }else {
                    map_result.put("xyggaos", xyggaos);
                }
        return map_result;
    }
}

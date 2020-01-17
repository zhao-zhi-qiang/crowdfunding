package com.uplooking.crowdfunding.controller.DispatcherController;

import com.uplooking.crowdfunding.bean.User;
import com.uplooking.crowdfunding.manager.service.UserService;
import com.uplooking.crowdfunding.utils.AjaxResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.support.SessionStatus;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class DispatcherController {
    @Autowired
    UserService userService;
//    @RequestMapping("/list")
//    public String findAllUser(Model model){
//        List<User> userList = userService.selectAll();
//        model.addAttribute("userList",userList);
//        return "userList";
//    }
    /*跳转首页*/
    @RequestMapping("/index")
    public String index(){
        return "index";
    }
    /*跳转登录*/
    @RequestMapping("/login")
    public String login(){
        return "login";
    }
    /*异步登录
    * 成功登录的用户数据存储到session
    * */
    @RequestMapping("/dologin")
    @ResponseBody
    public Object doLogin(String loginacct, String userpswd, String type, HttpSession session){
        //  异步请求返回的结果值
        AjaxResult ajaxResult=new AjaxResult();
        Map<String,Object> parammap=new HashMap<>();
        parammap.put("loginacct",loginacct);
        parammap.put("userpswd",userpswd);
        parammap.put("type",type);
        //比较用户登录的数据和数据库
        User user = userService.queryUserLogin(parammap);
        System.out.println(user);
        if (user != null ){
//            System.out.println("账号或密码为空");
            session.setAttribute("loginacct",loginacct);
            ajaxResult.setSuccess(true);
        }else {
            ajaxResult.setSuccess(false);
            System.out.println("账号或密码错误,请重新输入");
        }
        return ajaxResult;
    }
//    退出登录
@RequestMapping("/loginout")
public String loginout(SessionStatus status) {
    //销毁session
    status.setComplete();
    return "index";
}
}

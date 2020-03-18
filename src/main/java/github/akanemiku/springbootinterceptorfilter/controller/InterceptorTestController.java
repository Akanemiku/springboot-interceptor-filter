package github.akanemiku.springbootinterceptorfilter.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 拦截器
 */
@Controller
public class InterceptorTestController {


    @Deprecated
    @GetMapping("/admin/oldLogin")
    @ResponseBody
    public String oldLogin() {
        return "废弃页面";
    }

    @GetMapping("/admin/login")
    @ResponseBody
    public String login() {
        return "正在使用的页面";
    }
}

package com.web.utils;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @Auther: http://www.tanwei.com
 * @Date: 2019/7/24
 * @Description: com.web.utils
 * @versio: 1.0
 */
public class CheckCodeUtil {
    @RequestMapping("/checkcode")
    @ResponseBody
    public String accpt(@RequestParam String captcha, HttpServletRequest request) {
        if (captcha != request.getSession().getAttribute("code")) {
            return "验证码格式错误";
        }else{
            return null;
        }
    }
}

package com.example.demo.controller;
import com.example.demo.Result.Result;
import com.example.demo.Result.ResultEnum;
import com.example.demo.Result.ResultUtils;
import com.example.demo.Utils.CalculatorUtil;
import com.example.demo.Utils.SendmailUtil;
import com.example.demo.Utils.VerifyCodeUtil;
import com.example.demo.bean.User;
import com.example.demo.service.IUserService;
import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class MailController {
    @Autowired
    IUserService userService;
    /**
         * 发送自由编辑的邮件
         *
         * @param toEmailAddress 收件人邮箱
         * @param emailTitle 邮件主题
         * @param emailContent 邮件内容
         * @return
         */
    @RequestMapping(value={"/sendEmailOwn"},method={RequestMethod.GET, RequestMethod.POST})
    public String sendEmailOwn(@RequestParam("toEmailAddress") String toEmailAddress,
                               @RequestParam("emailTitle") String emailTitle, @RequestParam("emailContent") String emailContent){
        try{
            //发送邮件
            SendmailUtil.sendEmail(toEmailAddress, emailTitle, emailContent);
            return CalculatorUtil.getJSONString(0);
        }catch(Exception e){
            return CalculatorUtil.getJSONString(1,"邮件发送失败！");
        }
    }

    /**
         * 发送系统验证
         *
         * @param toEmailAddress 收件人邮箱
         * @return
         */
    @RequestMapping(value={"/sendEmailSystem"},method={RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public String sendEmailSystem(String toEmailAddress){
        //收件人邮箱:toEmailAddress
        User loginUser = userService.getUserByMail(toEmailAddress);
        if(toEmailAddress.equals(loginUser.getEmail())) {
            try {
                //生成验证码
                String verifyCode = VerifyCodeUtil.generateVerifyCode(6);

                //邮件主题
                String emailTitle = "【知识库】邮箱验证";

                //邮件内容
                String emailContent = "您正在【知识库】进行邮箱验证，您的验证码为：" + verifyCode + "，请于10分钟内完成验证！";

                //发送邮件
                SendmailUtil.sendEmail(toEmailAddress, emailTitle, emailContent);
                System.out.println(verifyCode);
                System.out.println(CalculatorUtil.getJSONString(loginUser.getId(), verifyCode));
                return CalculatorUtil.getJSONString(loginUser.getId(), verifyCode);
            } catch (Exception e) {
                return CalculatorUtil.getJSONString(-1, "邮件发送失败！");
            }
        }
        else{
            return CalculatorUtil.getJSONString(2, "该邮箱未注册！");
        }

    }
}

package pers.kuroko.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pers.kuroko.dto.ResponseData;
import pers.kuroko.entity.User;
import pers.kuroko.service.UserService;
import pers.kuroko.utils.JWTUtil;

@RestController("/userController")
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResponseData login(User user) {
        User login = userService.login(user);
        ResponseData responseData = ResponseData.ok();
        if (login != null) {
            // 生成token
            String token = JWTUtil.generateToken(login.getUid(), "Jersey-Security-Basic", login.getUname());
            // 向浏览器返回token，客户端收到此token后存入cookie中，或者h5的本地存储
            responseData.putDataValue("token", token);
            login.setUpwd("******");
            responseData.putDataValue("user", login);
        } else {
            // 用户名或者密码错误
            responseData = ResponseData.customerError();
        }
        return responseData;
    }

}

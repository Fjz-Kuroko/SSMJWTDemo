package pers.kuroko.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pers.kuroko.dto.ResponseData;

@RestController("indexController")
@RequestMapping("/index")
public class IndexController {

    @RequestMapping("/index")
    public ResponseData index() {
        return ResponseData.ok();
    }

}

package code2.controller;

import code2.controller.results.Code;
import code2.controller.results.Result;
import code2.domain.User;
import code2.service.UserService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user/")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("{startPage}/{pageSize}")
    public Result findAll(@PathVariable Integer startPage, @PathVariable Integer pageSize) {
        PageInfo<User> users = userService.findAll(startPage, pageSize);
        return new Result(null != users ? Code.GET_OK : Code.GET_FAILURE, users);
    }

    @GetMapping("{id}")
    public Result get(@PathVariable Integer id) {
        User user = userService.findById(id);
        //模拟出现异常，使用条件控制，便于测试结果
//        if (uuid == 10 ) throw new BusinessException("查询出错啦，请重试！",Code.GET_ERROR);
        Result result = new Result(null != user ? Code.GET_OK : Code.GET_FAILURE, user);
        return result;
    }
}

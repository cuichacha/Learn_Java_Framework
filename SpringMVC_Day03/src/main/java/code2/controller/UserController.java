package code2.controller;

import code2.controller.results.Code;
import code2.controller.results.Result;
import code2.domain.User;
import code2.exception.BusinessException;
import code2.service.UserService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/{startPage}/{pageSize}")
    public Result findAll(@PathVariable Integer startPage, @PathVariable Integer pageSize) {
        PageInfo<User> users = userService.findAll(startPage, pageSize);
        return new Result(null != users ? Code.GET_OK : Code.GET_FAILURE, users);
    }

    @GetMapping("/{id}")
    public Result findById(@PathVariable Integer id) {
        User user = userService.findById(id);
        //模拟出现异常，使用条件控制，便于测试结果
        if (id == 10 ) throw new BusinessException("查询出错啦，请重试！",Code.GET_FAILURE);
        Result result = new Result(null != user ? Code.GET_OK : Code.GET_FAILURE, user);
        return result;
    }

    @PostMapping
    public Result save(User user) {
        boolean flag = userService.save(user);
        Result result = new Result(flag ? Code.SAVE_OK : Code.SAVE_FAILURE, flag);
        return result;
    }

    @PutMapping
    public Result update(User user) {
        boolean flag = userService.update(user);
        Result result = new Result(flag ? Code.UPDATE_OK : Code.UPDATE_FAILURE, flag);
        return result;
    }

    @DeleteMapping
    public Result delete(Integer id) {
        boolean flag = userService.delete(id);
        Result result = new Result(flag ? Code.DELETE_OK : Code.DELETE_FAILURE, flag);
        return result;
    }

    @PostMapping("/login")
    public Result login(String username, String password) {
        User user = userService.login(username, password);
        Result result = new Result(null != user ? Code.GET_OK : Code.GET_FAILURE, user);
        return result;
    }

}

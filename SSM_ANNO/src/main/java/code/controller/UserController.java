package code.controller;

import code.controller.results.Code;
import code.controller.results.Result;
import code.domain.User;
//import code.exception.BusinessException;
import code.service.UserService;
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
        Result result = new Result(users != null ? Code.GET_OK : Code.GET_FAILURE, users);
        return result;
    }

    @GetMapping("/{id}")
    public Result findById(@PathVariable Integer id) {
        User user = userService.findById(id);
//        if (id == 10) {
//            throw new BusinessException("查询出错啦，请重试", Code.GET_FAILURE);
//        }
        Result result = new Result(user != null ? Code.GET_OK : Code.GET_FAILURE, user);
        return result;
    }

    @PostMapping
    public Result save(User user) {
        boolean flag = userService.save(user);
        Result result = new Result(flag ? Code.GET_OK : Code.GET_FAILURE, flag);
        return result;
    }

    @PutMapping
    public Result update(User user) {
        boolean flag = userService.update(user);
        Result result = new Result(flag ? Code.GET_OK : Code.GET_FAILURE, flag);
        return result;
    }

    @DeleteMapping
    public Result delete(Integer id) {
        boolean flag = userService.delete(id);
        Result result = new Result(flag ? Code.GET_OK : Code.GET_FAILURE, flag);
        return result;
    }

    @PostMapping("/login")
    public Result login(String username, String password) {
        User user = userService.login(username, password);
        Result result = new Result(user != null ? Code.GET_OK : Code.GET_FAILURE, user);
        return result;
    }
}

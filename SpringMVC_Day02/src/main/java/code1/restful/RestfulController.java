package code1.restful;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Restful/")
public class RestfulController {

    @GetMapping("{id}")
//    @RequestMapping(value = "/Restful/{id}",method = RequestMethod.GET)
    public String test1(@PathVariable Integer id) {
        System.out.println(id);
        return "Test1";
    }

    @PostMapping("{id}")
    public String test2(@PathVariable Integer id) {
        System.out.println(id);
        return "Test1";
    }

    @PutMapping("{id}")
    public String test3(@PathVariable Integer id) {
        System.out.println(id);
        return "Test1";
    }

    @DeleteMapping("{id}")
    public String test4(@PathVariable Integer id) {
        System.out.println(id);
        return "Test1";
    }

}

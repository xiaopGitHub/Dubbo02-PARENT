package com.xp.controller;

import com.xp.api.IComment;
import com.xp.api.IUser;
import com.xp.common.JSON;
import com.xp.vo.Comment;
import com.xp.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xp
 * @create 2018/11/29  17:19
 * @function 用户控制层
 */
@Controller
public class UserController {

    //类型注入,底层TCP返回对象
    @Autowired
    private IUser userService;
    @Autowired
    private IComment commentService;

    @RequestMapping("loginUser")
    public String Login(String username,String password){
        Map<String,Object> map=new HashMap<>();
        map.put("username", username);
        map.put("password", password);
        User user=userService.getUser(map);
        if(user!=null){
            return "comment";
        }else{
            return "redirect:login.jsp";
        }
    }

    @RequestMapping("/queryComment")
    public @ResponseBody
    JSON queryComment(Integer pageNumber, Integer pageSize) {
        Map<String,Integer> map=new HashMap<>();
        map.put("pageNumber", pageNumber);
        map.put("pageSize", pageSize);
        return commentService.selectComments(map);
    }

    @RequestMapping("/deleteComment")
    public @ResponseBody JSON deleteProduct(@RequestParam("id") Integer id) {
        //接收前端传递的数组@RequestParam("array[]") Integer[] array)
        int row=commentService.deleteComment(id);
        JSON json=new JSON(200,"success" ,row );
        return json;
    }

    @RequestMapping("/updateComment")
    public String updateProduct(@ModelAttribute Comment comment) {
        commentService.updateComment(comment);
        /*
        返回值通过视图解析器解析为实际视图,解析器通过prefix+返回值+suffix获取完整视图路径,
        然后做转发处理
         */
        return "comment";
    }

    @RequestMapping("/insertComment")
    public String insertProduct(@ModelAttribute Comment comment) {
        commentService.insertComment(comment);
        return "comment";
    }
}

package com.lagou.controller;

import com.github.pagehelper.PageInfo;
import com.lagou.domain.ResponseResult;
import com.lagou.domain.Role;
import com.lagou.domain.UseVo;
import com.lagou.domain.User;
import com.lagou.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

/**
 * @author Lihu
 * @PROJECT_NAME: lagou_edu_home_parent
 * @DESCRIPTION:
 * @USER: Irene-Jisoo
 * @DATE: 2022/4/1 12:35
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/findAllUserByPage")
    public ResponseResult findAllUserByPage(@RequestBody UseVo useVo) {
        PageInfo allUserByPag = userService.findAllUserByPag(useVo);

        ResponseResult responseResult = new ResponseResult(true, 200, "分页多条件查询成功", allUserByPag);
        return  responseResult;
    }

    /**
     * get 请求不用加上 @RequestBody
     * 用户登录
     * @param user
     * @return
     */
    @RequestMapping("/login")
    public ResponseResult login(User user, HttpServletRequest request) throws Exception {
        User loagin = userService.loagin(user);
        if (loagin != null) {
            // 保存用户id 及access_token 到session中
            HttpSession session = request.getSession();
            String access_token = UUID.randomUUID().toString();
            session.setAttribute("access_token", access_token);
            session.setAttribute("user_id", loagin.getId());
            // 将查出来的信息反映给前台
            HashMap<String, Object> map = new HashMap<>();
            map.put("access_token", access_token);
            map.put("user_id", loagin.getId());
            ResponseResult responseResult = new ResponseResult(true, 200, "登录成功", map);
            return  responseResult;
        } else {
            return new ResponseResult(true, 400, "用户名错误", null);
        }
    }


    /**
     *        分配角色（回显）
      * @param id
     * @return
     */
    @RequestMapping("/findUserRoleById")
    public ResponseResult findUserRelationRoleById(Integer id){

        List<Role> roleList = userService.findUserRelationRoleById(id);

        return  new ResponseResult(true,200,"分配角色回显成功",roleList);
    }


    /**
     *  分配角色
     * @param userVo
     * @return
     */
    @RequestMapping("/userContextRole")
    public ResponseResult userContextRole(@RequestBody UseVo userVo){

        userService.userContextRole(userVo);

        return new ResponseResult(true,200,"分配角色成功",null);
    }


    /**
     *   获取用户权限，进行菜单动态展示
      * @param request
     * @return
     */
    @RequestMapping("/getUserPermissions")
    public ResponseResult getUserPermissions(HttpServletRequest request){

        // 1.获取请求头中的token
        String header_token = request.getHeader("Authorization");

        // 2.获取session中token
        String session_token = (String) request.getSession().getAttribute("access_token");

        // 3.判断token是否一致
        if(header_token.equals(session_token)){
            // 获取用户id
            Integer user_id = (Integer) request.getSession().getAttribute("user_id");
            // 调用service,进行菜单信息查询
            ResponseResult responseResult = userService.getUserPermissions(user_id);
            return responseResult;
        }else {
            ResponseResult responseResult = new ResponseResult(false, 400, "获取菜单信息失败", null);
            return responseResult;
        }


    }

}

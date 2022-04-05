package com.lagou.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lagou.dao.UserMapper;
import com.lagou.domain.*;
import com.lagou.service.UserService;
import com.lagou.utils.Md5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @author Lihu
 * @PROJECT_NAME: lagou_edu_home_parent
 * @DESCRIPTION:
 * @USER: Irene-Jisoo
 * @DATE: 2022/4/1 12:32
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    /**
     * 分页查询用户信息
     *
     * @param useVo
     * @return
     */
    @Override
    public PageInfo findAllUserByPag(UseVo useVo) {
        PageHelper.startPage(useVo.getCurrentPage(), useVo.getPageSize());
        List<User> allUserByPage = userMapper.findAllUserByPage(useVo);
        PageInfo<User> userPageInfo = new PageInfo<>(allUserByPage);
        return userPageInfo;
    }

    /**
     * 用户登录
     *
     * @param user
     * @return
     */
    @Override
    public User loagin(User user) throws Exception {

        User login = userMapper.login(user);
        if (login != null && Md5.verify(user.getPassword(), "logou", login.getPassword())) {
            return login;
        } else {
            return null;
        }
    }

    /**
     * 分配角色（回显）
     *
     * @param id
     * @return
     */
    @Override
    public List<Role> findUserRelationRoleById(Integer id) {
        List<Role> list = userMapper.findUserRelationRoleById(id);

        return list;
    }

    /**
     * 用户关联角色
     *
     * @param userVo
     */
    @Override
    public void userContextRole(UseVo userVo) {

        // 1.根据用户ID清空中间表关联关系
        userMapper.deleteUserContextRole(userVo.getUserId());

        // 2.再从新建立关联关系
        for (Integer roleid : userVo.getRoleIdList()) {

            // 封装数据
            User_Role_relation user_role_relation = new User_Role_relation();
            user_role_relation.setUserId(userVo.getUserId());
            user_role_relation.setRoleId(roleid);

            Date date = new Date();
            user_role_relation.setCreatedTime(date);
            user_role_relation.setUpdatedTime(date);

            user_role_relation.setCreatedBy("system");
            user_role_relation.setUpdatedby("system");

            userMapper.userContextRole(user_role_relation);

        }


    }

    /**
     * 获取用户权限，进行菜单动态展示
     *
     * @param userid
     * @return
     */
    @Override
    public ResponseResult getUserPermissions(Integer userid) {


        // 1. 获取当前用户拥有的角色
        List<Role> roleList = userMapper.findUserRelationRoleById(userid);

        // 2. 获取角色ID，保存到List集合中
        ArrayList<Integer> roleIds = new ArrayList<>();

        for (Role role : roleList) {
            roleIds.add(role.getId());
        }

        // 3.根据角色ID查询父菜单
        List<Menu> parentMenu = userMapper.findParentMenuByRoleId(roleIds);

        // 4.查封封装父菜单关联的子菜单
        for (Menu menu : parentMenu) {
            List<Menu> subMenu = userMapper.findSubMenuByPid(menu.getId());
            menu.setSubMenuList(subMenu);
        }

        // 5.获取资源信息
        List<Resource> resourceList = userMapper.findResourceByRoleId(roleIds);


        // 6. 封装数据并返回
        Map<String, Object> map = new HashMap<>();
        map.put("menuList",parentMenu);
        map.put("resourceList",resourceList);



        return new ResponseResult(true,200,"获取用户权限信息成功",map);
    }
}

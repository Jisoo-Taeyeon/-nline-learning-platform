package com.lagou.service;

import com.github.pagehelper.PageInfo;
import com.lagou.domain.ResponseResult;
import com.lagou.domain.Role;
import com.lagou.domain.UseVo;
import com.lagou.domain.User;

import java.util.List;

/**
 * @author 流年安好
 */
public interface UserService {

    /**
     * 分页查询用户信息
     * @param useVo
     * @return
     */
    public PageInfo findAllUserByPag(UseVo useVo);

    /**
     * 用户登录
     * @param user
     * @return
     */
    public User loagin(User user) throws Exception;


    /**
     *   分配角色（回显）
      * @param id
     * @return
     */
    public List<Role> findUserRelationRoleById(Integer id);

    /**
     * 用户关联角色
     * @param userVo
     */
    public void userContextRole(UseVo userVo);

    /**
     *   获取用户权限，进行菜单动态展示
     * @param userid
     * @return
     */
    public ResponseResult getUserPermissions(Integer userid);
}

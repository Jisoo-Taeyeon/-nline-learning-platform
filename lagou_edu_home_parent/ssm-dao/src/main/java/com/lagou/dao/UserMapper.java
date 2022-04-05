package com.lagou.dao;

import com.lagou.domain.*;

import java.util.List;

/**
 * @author 流年安好
 */
public interface UserMapper {
    /**
     * 用户分页&多条件组合查询
     * @param userVo
     * @return
     */
    public List<User> findAllUserByPage(UseVo userVo);

    /**
     * 用户登录
     * @param user
     * @return
     */
    public User login(User user);


    /**
     * 根据用户ID清空中间表
     * @param userId
     */
    public void deleteUserContextRole(Integer userId);

    /**
     * 分配角色
     * @param user_role_relation
     */
    public void userContextRole(User_Role_relation user_role_relation);


    /**
     * 1. 根据用户ID查询关联的角色信息 多个角色
     * @param id
     * @return
     */
    public List<Role>  findUserRelationRoleById(Integer id);


    /**
     *        2. 根据角色ID，查询角色所拥有的顶级菜单（-1）
      * @param ids
     * @return
     */
    public List<Menu> findParentMenuByRoleId(List<Integer> ids);

    /**
     *        3. 根据PID，查询子菜单信息
     * @param pid
     * @return
     */
    public List<Menu> findSubMenuByPid(Integer pid);

    /**
     * 4.获取用户拥有的资源权限信息
     * @param ids
     * @return
     */
    public List<Resource> findResourceByRoleId(List<Integer> ids);




}

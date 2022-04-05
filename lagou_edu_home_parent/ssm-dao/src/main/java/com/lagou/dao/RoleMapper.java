package com.lagou.dao;

import com.lagou.domain.Role;
import com.lagou.domain.Role_menu_relation;

import java.util.List;

/**
 * @author 流年安好
 */
public interface RoleMapper {

    /**
     * 查询所有角色
     * @param role
     * @return
     */
    public List<Role> findAllRole(Role role);

    /**
     *  根据角色ID查询菜单信息
     * @param roleId
     * @return
     */
    List<String> findMenuByRoleId(Integer roleId);

    /**
     * 根据roleId 清空中间表的关联关系
     * @param rid
     */
    public void deleteRoleContextMenu(Integer rid);

    /**
     * 角色菜单关联
     * @param role_menu_relation
     */
    public void roleContextMenu(Role_menu_relation role_menu_relation);

    /**
     * 根据roleId删除角色
     * @param roleId
     */
    public void deleteRole(Integer roleId);


}

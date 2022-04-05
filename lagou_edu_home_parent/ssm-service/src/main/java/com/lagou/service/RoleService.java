package com.lagou.service;

import com.lagou.domain.Role;
import com.lagou.domain.RoleMenuVo;
import com.lagou.domain.Role_menu_relation;

import java.util.List;

/**
 * @author 流年安好
 */
public interface RoleService {

    /**
     * 有条件查询所有角色
     * @param role
     * @return
     */
    public List<Role> findAllRole(Role role);

    /**
     * 根据角色ID查询该角色关联的菜单信息ID [1,2,3,5]
     * @param roleid
     * @return
     */
    public List<String> findMenuByRoleId(Integer roleid);



    /**
     * 删除角色
     * @param roleId
     */
    public void deleteRole(Integer roleId);

    /**
     * 为角色分配菜单
     * @param roleMenuVo
     */
    public void roleContextMenu(RoleMenuVo roleMenuVo);



}

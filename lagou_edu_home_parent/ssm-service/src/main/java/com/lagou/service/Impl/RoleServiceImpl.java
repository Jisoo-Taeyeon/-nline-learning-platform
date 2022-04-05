package com.lagou.service.Impl;

import com.lagou.dao.RoleMapper;
import com.lagou.domain.Role;
import com.lagou.domain.RoleMenuVo;
import com.lagou.domain.Role_menu_relation;
import com.lagou.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author Lihu
 * @PROJECT_NAME: lagou_edu_home_parent
 * @DESCRIPTION:
 * @USER: Irene-Jisoo
 * @DATE: 2022/4/1 16:23
 */
@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleMapper roleMapper;

    /**
     * 有条件查询所有角色
     *
     * @param role
     * @return
     */
    @Override
    public List<Role> findAllRole(Role role) {
        return roleMapper.findAllRole(role);
    }

    /**
     * 根据角色ID查询该角色关联的菜单信息ID [1,2,3,5]
     *
     * @param roleid
     * @return
     */
    @Override
    public List<String> findMenuByRoleId(Integer roleid) {
        List<String> menuByRoleId = roleMapper.findMenuByRoleId(roleid);
        return menuByRoleId;
    }

    /**
     * 删除角色
     *
     * @param roleId
     */
    @Override
    public void deleteRole(Integer roleId) {
        // 调用根据roleId清空中间表的方法
        roleMapper.deleteRoleContextMenu(roleId);
        roleMapper.deleteRole(roleId);

    }

    /**
     * 为角色分配菜单
     *
     * @param roleMenuVo
     */
    @Override
    public void roleContextMenu(RoleMenuVo roleMenuVo) {
        //1. 清空中间表的关联关系
        roleMapper.deleteRoleContextMenu(roleMenuVo.getRoleId());
        //2. 为角色分配菜单
        for (Integer id : roleMenuVo.getMenuIdList()) {
            Role_menu_relation role_menu_relation = new Role_menu_relation();
            role_menu_relation.setRoleId(roleMenuVo.getRoleId());
            role_menu_relation.setMenuId(id);

            Date date = new Date();
            role_menu_relation.setCreatedTime(date);
            role_menu_relation.setUpdatedTime(date);
            role_menu_relation.setCreatedBy("system");
            role_menu_relation.setUpdatedby("system");
            roleMapper.roleContextMenu(role_menu_relation);
        }

    }
}

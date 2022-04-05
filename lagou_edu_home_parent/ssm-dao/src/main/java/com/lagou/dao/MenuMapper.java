package com.lagou.dao;

import com.lagou.domain.Menu;

import java.util.List;

/**
 * @author 流年安好
 */
public interface MenuMapper {
    /**
     * 查询所有父子菜单信息
     * @param pid
     * @return
     */
    public List<Menu> findSubMenuListByPid(int pid);

    /**
     * 查询所有菜单列表
     * @return
     */
    public List<Menu> findAllMenu();

    /**
     *根据菜单ID 查询菜单信息 菜单信息回显
     * @param id
     * @return
     */
    public Menu findMenuById(Integer id);

    /**
     * 更新菜单信息
     * @param menu
     */
    public void updateMenu(Menu menu);

    /**
     * 新增菜单
     * @param menu
     */
    public void saveMenu(Menu menu);
}

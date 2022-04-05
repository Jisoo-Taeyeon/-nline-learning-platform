package com.lagou.service;

import com.lagou.domain.Menu;

import java.util.List;

/**
 * @author 流年安好
 */
public interface MenuService {
    /**
     * 查询所有父子菜单信息
     * @param pid
     * @return
     */
    public List<Menu> findSubMenuListByPid(int pid);

    /**
     *  查询所有菜单信息
     * @return
     */
    public List<Menu> findAllMenu();

    /**
     * 根据id 查找菜单
     * @param id
     * @return
     */
    Menu findMenuById(Integer id);

    /**
     * 更新菜单信息
     * @param menu
     */
    public  void updateMenu(Menu menu);

    /**
     * 保存新的菜单信息
     * @param menu
     */
    public void saveMenu(Menu menu);


}

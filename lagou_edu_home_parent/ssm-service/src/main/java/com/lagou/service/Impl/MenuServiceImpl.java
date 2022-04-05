package com.lagou.service.Impl;

import com.lagou.dao.MenuMapper;
import com.lagou.domain.Menu;
import com.lagou.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Lihu
 * @PROJECT_NAME: lagou_edu_home_parent
 * @DESCRIPTION:
 * @USER: Irene-Jisoo
 * @DATE: 2022/4/1 22:02
 */
@Service
public class MenuServiceImpl implements MenuService {
    @Autowired
    private MenuMapper menuMapper;
    /**
     * 查询所有父子菜单信息
     *
     * @param pid
     * @return
     */
    @Override
    public List<Menu> findSubMenuListByPid(int pid) {
        List<Menu> subMenuListByPid = menuMapper.findSubMenuListByPid(pid);
        return subMenuListByPid;
    }

    /**
     * 查询所有菜单信息
     *
     * @return
     */
    @Override
    public List<Menu> findAllMenu() {
        return menuMapper.findAllMenu();
    }

    /**
     * 根据id 查找菜单
     *
     * @param id
     * @return
     */
    @Override
    public Menu findMenuById(Integer id) {
        return menuMapper.findMenuById(id);
    }

    /**
     * 更新菜单信息
     *
     * @param menu
     */
    @Override
    public void updateMenu(Menu menu) {
        menuMapper.updateMenu(menu);
    }

    /**
     * 保存新的菜单信息
     *
     * @param menu
     */
    @Override
    public void saveMenu(Menu menu) {
        menuMapper.saveMenu(menu);

    }
}

package com.lagou.controller;

import com.lagou.domain.Menu;
import com.lagou.domain.ResponseResult;
import com.lagou.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Lihu
 * @PROJECT_NAME: lagou_edu_home_parent
 * @DESCRIPTION:
 * @USER: Irene-Jisoo
 * @DATE: 2022/4/1 22:07
 */
@RestController
@RequestMapping("/menu")
public class MenuController {
    @Autowired
    private MenuService menuService;

    /**
     *  查询所有菜单信息
     * @return
     */
    @RequestMapping("/findAllMenu")
    public ResponseResult findAllMenu(){
        List<Menu> allMenu = menuService.findAllMenu();

        return  new ResponseResult(true,200,"查询所有菜单信息成功",allMenu);


    }

    /**
     * 回显菜单信息
     * @param id
     * @return
     */
    @RequestMapping("/findMenuInfoById")
    public ResponseResult findMenuInfoById(Integer id){

        // 根据id的值判断当前是更新还是添加操作 判断id的值是否为-1
        if(id == -1){
            // 添加 回显信息中不需要查询menu信息
            List<Menu> subMenuListByPid = menuService.findSubMenuListByPid(-1);

            // 封装数据
            Map<String, Object> map = new HashMap<>();
            map.put("menuInfo",null);
            map.put("parentMenuList",subMenuListByPid);

            return new ResponseResult(true,200,"添加回显成功",map);

        }else {

            //修改操作 回显所有menu信息
            Menu menu =  menuService.findMenuById(id);
            List<Menu> subMenuListByPid = menuService.findSubMenuListByPid(-1);

            // 封装数据
            Map<String, Object> map = new HashMap<>();
            map.put("menuInfo",menu);
            map.put("parentMenuList",subMenuListByPid);

            return new ResponseResult(true,200,"修改回显成功",map);

        }

    }

    /**
     * 添加&修改菜单
     * @param menu
     * @return
     */
    @RequestMapping("/saveOrUpdateMenu")
    public ResponseResult saveOrUpdateMenu(@RequestBody Menu menu){
        System.out.println("*********************************");
        System.out.println(menu);
        System.out.println("**********************************");
        if (menu.getId() != null) {
            Date date = new Date();
            menu.setUpdatedTime(date);
            menuService.updateMenu(menu);
            return new ResponseResult(true, 200, "更新成功", null);

        } else {
            Date date = new Date();
            menu.setUpdatedTime(date);
            menu.setCreatedTime(date);
            menuService.saveMenu(menu);
            return new ResponseResult(true, 200, "保存成功", null);

        }
    }



}

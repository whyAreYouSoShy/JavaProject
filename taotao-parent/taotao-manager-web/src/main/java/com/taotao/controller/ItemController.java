package com.taotao.controller;

import com.taotao.common.pojo.EasyUIDataGridResult;
import com.taotao.common.pojo.TaotaoResult;
import com.taotao.pojo.TbItem;
import com.taotao.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * Created by yeguizhong on 2017/7/27.
 */

/**
 * 商品管理controller
 */
@Controller
public class ItemController {

    @Resource
    private ItemService itemService;
    
    @RequestMapping("/item/{itemId}")
    @ResponseBody
    public TbItem getItemById(@PathVariable Long itemId) {
    
    
        TbItem item = itemService.getItemById(983521);
        System.out.println(item);
        return item;
    }
    

    @RequestMapping("/item/list")
    @ResponseBody
    public EasyUIDataGridResult getItemList(Integer page,Integer rows) {
        System.out.println("itemlist");
        return itemService.getItemList(page, rows);
    }

    @RequestMapping(value="/item/save",method = RequestMethod.POST)
    @ResponseBody
    public TaotaoResult addItem(TbItem item,String desc) {
        TaotaoResult taotaoResult = itemService.addItem(item, desc);
        return taotaoResult;

    }



}



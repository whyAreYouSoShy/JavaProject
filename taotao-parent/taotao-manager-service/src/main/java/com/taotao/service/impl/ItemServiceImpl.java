package com.taotao.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.common.pojo.EasyUIDataGridResult;
import com.taotao.mapper.TbItemMapper;
import com.taotao.pojo.TbItem;
import com.taotao.pojo.TbItemExample;
import com.taotao.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by yeguizhong on 2017/7/27.
 */

@Service
public class ItemServiceImpl implements ItemService {
    
    @Autowired
    public TbItemMapper tbItemMapper;
    /**
     * 根据主键查询商品详情
     * @param itemId
     * @return
     */
    public TbItem getItemById(long itemId) {
        TbItem tbItem = tbItemMapper.selectByPrimaryKey(itemId);
        return tbItem;
    }


    /**
     * 分页查询商品列表
     */
    public EasyUIDataGridResult getItemList(int page, int rows) {
        PageHelper.startPage(page, rows);
        System.out.println("itemlist");
        List<TbItem> itemList = tbItemMapper.selectByExample(new TbItemExample());
        PageInfo<TbItem> pageInfo = new PageInfo<TbItem>(itemList);

        EasyUIDataGridResult result = new EasyUIDataGridResult();
        result.setTotal(pageInfo.getTotal());
        result.setRows(itemList);

        return result;
    }
}

package com.taotao.service.impl;

import com.taotao.mapper.TbItemMapper;
import com.taotao.pojo.TbItem;
import com.taotao.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    
}

package com.taotao.service;

import com.taotao.common.pojo.EasyUIDataGridResult;
import com.taotao.common.pojo.TaotaoResult;
import com.taotao.pojo.TbItem;

/**
 * Created by yeguizhong on 2017/7/27.
 */
public interface ItemService {
    
    TbItem getItemById(long itemId);
    EasyUIDataGridResult getItemList(int page,int rows);
    TaotaoResult addItem(TbItem item, String desc);

}

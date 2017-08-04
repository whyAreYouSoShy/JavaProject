package com.taotao.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.common.pojo.EasyUIDataGridResult;
import com.taotao.common.pojo.TaotaoResult;
import com.taotao.common.utils.IDUtils;
import com.taotao.mapper.TbItemDescMapper;
import com.taotao.mapper.TbItemMapper;
import com.taotao.pojo.TbItem;
import com.taotao.pojo.TbItemDesc;
import com.taotao.pojo.TbItemExample;
import com.taotao.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * Created by yeguizhong on 2017/7/27.
 */

@Service
public class ItemServiceImpl implements ItemService {
    
    @Resource
    public TbItemMapper tbItemMapper;

    @Resource
    public TbItemDescMapper tbItemDescMapper;


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


    /**
     * 添加商品
     */
    public TaotaoResult addItem(TbItem item, String desc) {

        //生成商品id
        long id = IDUtils.genItemId();

        //补全item的属性
        item.setId(id);

        //商品状态,1-正常,2-下架,3-删除,新添加的商品默认是正常的
        item.setStatus((byte) 1);
        item.setCreated(new Date());
        item.setUpdated(new Date());

        //向商品表中插入数据
        tbItemMapper.insert(item);

        //创建商品描述表对应的pojo
        TbItemDesc itemDesc = new TbItemDesc();
        itemDesc.setItemId(id);
        itemDesc.setItemDesc(desc);
        itemDesc.setCreated(new Date());
        itemDesc.setUpdated(new Date());


        //向商品描述表插入数据
        tbItemDescMapper.insert(itemDesc);
        //返回结果

        return TaotaoResult.ok();
    }
}

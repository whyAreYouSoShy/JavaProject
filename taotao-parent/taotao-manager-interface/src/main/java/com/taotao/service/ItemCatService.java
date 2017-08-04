package com.taotao.service;

import com.taotao.common.pojo.EasyUITreeNode;

import java.util.List;

/**
 * Created by aichexiaowu on 2017/8/3.
 */
public interface ItemCatService {

    List<EasyUITreeNode> getItemCatList(long parentId);
}

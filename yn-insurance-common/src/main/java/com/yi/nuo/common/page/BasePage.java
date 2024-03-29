package com.yi.nuo.common.page;


import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.Data;

import java.io.Serializable;
import java.util.List;


/**
 * 通用Page组件
 *
 * @param <T>
 * @author 黄雪冬
 */
@Data
public class BasePage<T extends Serializable> implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 每页条数
     */
    private long pageSize = 10;

    /**
     * 当前第几页
     */
    private long pageNum = 1;

    /**
     * 查询集合
     */
    private List<T> list;

    /**
     * 查询集合
     */
    private long total;


    public BasePage() {
    }

    /**
     * 基本构造
     *
     * @param pageSize  每页行数
     * @param pageIndex 页码
     */
    public BasePage(long pageIndex, long pageSize) {
        //分页参数的传递,全部统一为Page对象,行数最大允许100行
        this.pageSize = pageSize > 100 ? 100 : pageSize;
        this.pageNum = pageIndex;
    }


    public BasePage(long pageIndex, long pageSize, List<T> list, long total) {
        this.pageSize = pageSize;
        this.pageNum = pageIndex;
        this.list = list;
        this.total = total;
    }

    public BasePage(IPage<T> iPage) {
        this.pageNum = iPage.getCurrent();
        this.pageSize = iPage.getSize();
        this.list = iPage.getRecords();
        this.total = iPage.getTotal();
    }


}

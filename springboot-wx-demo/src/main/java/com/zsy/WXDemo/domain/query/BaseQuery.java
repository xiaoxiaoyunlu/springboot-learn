package com.zsy.WXDemo.domain.query;

import java.util.Date;

import com.zsy.WXDemo.utils.DateUtils;
import com.zsy.WXDemo.utils.StringUtil;


/**
 * 基本查询实体类
 * @author zj
 *
 */
public abstract class BaseQuery {
    private Integer page=1;         // 当前页
    private Integer rows=10;        // 每页显示条数
    private String searchKey;       // 关键字
    
    private Date startDate;         // 开始日期
    private Date endDate;           // 结束日期
    
    /**
     * limit开始数
     * @return
     */
    public Integer getStartSize() {
        return (page - 1) * rows;
    }
    
    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getRows() {
        return rows;
    }

    public void setRows(Integer rows) {
        this.rows = rows;
    }

    public String getSearchKey() {
        if(StringUtil.INSTANCE.isEmpty(searchKey))
            return "%"+searchKey+"%";
        return searchKey;
    }

    public void setSearchKey(String searchKey) {
        this.searchKey = searchKey;
    }
    
    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setStartDateStr(String startDateStr) {
        if (StringUtil.INSTANCE.isEmpty(startDateStr)) {
            this.startDate = DateUtils.INSTANCE.getDate(startDateStr, DateUtils.DATE_FROMAT);
        } else {
            this.startDate = null;
        }
    }

    @SuppressWarnings("all")
    public void setEndDateStr(String endDateStr) {
        if (StringUtil.INSTANCE.isEmpty(endDateStr)) {
            Date date = DateUtils.INSTANCE.getDate(endDateStr, DateUtils.DATE_FROMAT);
            if (date != null) {
                date.setDate(date.getDate() + 1);
            }
            this.endDate = date;
        } else {
            this.endDate = null;
        }
    }

}

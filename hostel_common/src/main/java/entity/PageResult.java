package entity;

import java.util.List;

/**
 * @author 流星紫蝶雨
 * @version 1.0
 * @date 2020/5/11 6:21 上午
 */
public class PageResult<T> {

    private Long total;

    private List<T> rows;

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }

    public PageResult() {
    }

    public PageResult(Long total, List<T> rows) {
        this.total = total;
        this.rows = rows;
    }
}

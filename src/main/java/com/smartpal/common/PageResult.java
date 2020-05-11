package com.smartpal.common;

import java.util.List;

public class PageResult<T> extends PageInfo {
    //结果集
    private List<T> result;

    public List<T> getResult() {
        return result;
    }

    public void setResult(List<T> result) {
        this.result = result;
    }
}

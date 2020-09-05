package com.smartpal.monitor.bean;

import com.smartpal.common.PageInfo;

public class StoreGoodsQuery extends PageInfo {
    private long storePk;

    public long getStorePk() {
        return storePk;
    }

    public void setStorePk(long storePk) {
        this.storePk = storePk;
    }
}

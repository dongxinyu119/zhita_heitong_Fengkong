package com.zhita.Model;

//关联call_record_list_item_infos_two表
public class CallStatistics {
    private Integer id;

    private Integer crtwoid;//关联call_record_list_item_infos_two表

    private Integer totalCallCount;//总共通话次数

    private Integer totalCallDurationTime;//总共通话时长

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCrtwoid() {
        return crtwoid;
    }

    public void setCrtwoid(Integer crtwoid) {
        this.crtwoid = crtwoid;
    }

    public Integer getTotalCallCount() {
        return totalCallCount;
    }

    public void setTotalCallCount(Integer totalCallCount) {
        this.totalCallCount = totalCallCount;
    }

    public Integer getTotalCallDurationTime() {
        return totalCallDurationTime;
    }

    public void setTotalCallDurationTime(Integer totalCallDurationTime) {
        this.totalCallDurationTime = totalCallDurationTime;
    }
}
package com.zhita.Dao;

import java.util.List;

import com.zhita.Model.CommunicationTimeBucketInfo;

public interface CommunicationTimeBucketInfoMapper {
    int insert(CommunicationTimeBucketInfo record);

    //列表查询——通话时间段分布
    List<CommunicationTimeBucketInfo> queryAll(Integer userid);

}
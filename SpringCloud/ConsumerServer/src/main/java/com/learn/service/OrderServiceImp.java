package com.learn.service;

import com.learn.mapper.TOrderMapper;
import com.learn.pojo.TOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImp{

    @Autowired
    TOrderMapper orderMapper;

    public TOrder select() {
        TOrder tOrderExample = new TOrder();

        return orderMapper.selectByPrimaryKey(1);
    }
}

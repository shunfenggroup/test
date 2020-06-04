package com.ht.service;

import com.ht.bean.Pictures;

import java.util.List;

public interface IPicService {
    void  addpic(Pictures pic);

    List<Pictures> slepic();
}

package com.ht.dao;

import com.ht.bean.Pictures;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface PicDao {
    void  addpic(Pictures pic);

    List<Pictures> slepic();
}

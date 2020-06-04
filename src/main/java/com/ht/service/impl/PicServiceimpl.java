package com.ht.service.impl;

import com.ht.bean.Pictures;
import com.ht.dao.PicDao;
import com.ht.service.IPicService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class PicServiceimpl implements IPicService {
    @Resource
    private PicDao dao;

    @Override
    public void addpic(Pictures pic) {
        dao.addpic(pic);
    }

    @Override
    public List<Pictures> slepic() {
        return dao.slepic();
    }
}

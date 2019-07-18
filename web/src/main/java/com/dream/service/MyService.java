package com.dream.service;

import com.dream.bean.MoneyRecord;
import com.dream.bean.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class MyService {

    @Autowired
    private ImageInterface testInterface;

    public List getImages(){
        return testInterface.getImages();
    }
}

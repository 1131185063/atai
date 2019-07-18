package com.dream.service;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface ImageInterface {
    @Select("select * from share_image")
    List<Map> getImages();
}

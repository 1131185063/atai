package com.dream.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/image")
public class ImageController {

    @ApiOperation(value = "查询全部照片列表")
    @RequestMapping(value = "/selImages",method = RequestMethod.GET)
    public List<String> selImages(){
        List<String> urlList = new ArrayList<>();
        File file = new File("/home/ftp/data");
        File[] files = file.listFiles();
        String domaimPath = "http://lbxygt.top/image/";
        for(File f:files){
            String fileName = f.getName();
            urlList.add(domaimPath+fileName);
        }
        return urlList;
    }
}

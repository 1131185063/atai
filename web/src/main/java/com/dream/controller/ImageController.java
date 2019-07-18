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

    @ApiOperation(value = "批量重命名")
    @RequestMapping(value = "/renameImageName",method = RequestMethod.GET)
    public void renameImageName(){
        String dir = "/home/ftp/data";
        File file = new File(dir);
        String[] fileName = file.list();
        Integer number = fileName.length;
        File[] newFile = new File[number];
        for(int i=0; i<number; i++) {
            System.out.println("第"+(i+1)+"个文件名" + ":" + fileName[i]);    //查看所有文件
            newFile[i] = new File(dir+fileName[i]);
            FileUtils.re
        }
    }
}

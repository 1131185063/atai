package com.dream.controller;

import io.swagger.annotations.ApiOperation;
import net.coobird.thumbnailator.Thumbnails;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
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

    @ApiOperation(value = "requestBaidu")
    @RequestMapping(value = "/requestBaidu",method = RequestMethod.GET)
    public void requestBaidu(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("https://www.baidu.com").forward(request,response);
    }

    @ApiOperation(value = "压缩图片")
    @RequestMapping(value = "/pressImage",method = RequestMethod.GET)
    public void pressImage() throws Exception {
        String parentPath = "C:\\Users\\EDZ\\Desktop\\file";
        String imageName = "123.jpg";
        File file = new File(parentPath+imageName);
        Thumbnails.of(parentPath)
                .scale(0.5f)
                .outputQuality(0.5f)
                .toFile(parentPath+"\\newFile");
    }
}

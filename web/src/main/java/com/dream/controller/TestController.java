package com.dream.controller;

import com.dream.bean.MoneyRecord;
import com.dream.bean.Student;
import com.dream.service.MyService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class TestController {
    @Autowired
    private MyService myService;

    @ApiOperation(value = "学生信息查询")
    @RequestMapping(value = "/selStudentList",method = RequestMethod.GET)
    public List<Student> sayHello(){
        if(1==1){
            throw new RuntimeException("this is exception");
        }
        return myService.selStuList();
    }

    @ApiOperation(value = "资金记录查询")
    @RequestMapping(value = "/selMoneyRecords",method = RequestMethod.GET)
    public List<MoneyRecord> selMoneyRecords(){
        return myService.selMoneyRecords();
    }

    @ApiOperation(value = "资金记录查询 带分页")
    @RequestMapping(value = "/selMoneyRecordsPage",method = RequestMethod.GET)
    public Page selMoneyRecordsPage(@ApiParam(required = true,name = "page",value = "page")@RequestParam(required = true) Integer page,
                                    @ApiParam(required = true,name = "size",value = "size")@RequestParam(required = true) Integer size){
        return myService.selMoneyRecords(new PageRequest(page,size));
    }
}

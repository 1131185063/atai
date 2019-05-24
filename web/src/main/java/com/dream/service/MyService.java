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
    private TestInterface testInterface;

    public List selStuList(){
        Student student = new Student();
        student.setId(1);
        student.setAddress("吉林省榆树市");
        student.setAge(20);
        student.setName("小明");
        student.setSex("man");
        Student student1 = new Student();
        student1.setId(2);
        student1.setAddress("吉林省长春市");
        student1.setAge(22);
        student1.setName("小丽");
        student1.setSex("women");
        Student student2 = new Student();
        student2.setId(3);
        student2.setAddress("吉林省农安县");
        student2.setAge(23);
        student2.setName("小英");
        student2.setSex("women");
        List list = new ArrayList();
        list.add(student);
        list.add(student1);
        list.add(student2);
        return list;
    }
    public List selMoneyRecords(){
        List list = new ArrayList();
        for(int i=1;i<=20;i++){
            MoneyRecord moneyRecord = new MoneyRecord();
            moneyRecord.setId(i);
            moneyRecord.setCreateTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
            moneyRecord.setUpdateTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
            moneyRecord.setMoney(new BigDecimal(100).add(new BigDecimal(i)));
            moneyRecord.setName("代码"+i);
            if(i%2==0){
                moneyRecord.setType("支取");
            }else{
                moneyRecord.setType("存入");
            }
            list.add(moneyRecord);

        }
        return list;
    }
    public Page selMoneyRecords(Pageable page){
        List list = new ArrayList();
        for(int i=1;i<=20;i++){
            MoneyRecord moneyRecord = new MoneyRecord();
            moneyRecord.setId(i);
            moneyRecord.setCreateTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
            moneyRecord.setUpdateTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
            moneyRecord.setMoney(new BigDecimal(100).add(new BigDecimal(i)));
            moneyRecord.setName("姓名"+i);
            if(i%2==0){
                moneyRecord.setType("支取");
            }else{
                moneyRecord.setType("存入");
            }
            list.add(moneyRecord);

        }
        return new PageImpl(list.subList(page.getOffset(),page.getPageSize()),page,20);
    }

    public List selStu(){
        return testInterface.getStudent();
    }
}

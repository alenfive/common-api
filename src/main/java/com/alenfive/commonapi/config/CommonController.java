package com.alenfive.commonapi.config;

import com.alenfive.commonapi.entity.QueryReq;
import com.alenfive.commonapi.entity.SaveReq;
import com.alenfive.commonapi.entity.UpdateReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * 单表基础 增/查/改
 */
@RestController
@RequestMapping("common")
public class CommonController {

    @Autowired
    private CommonService commonService;

    @PostMapping("/query/{table}/{resultType}")
    public Object query(@Validated @RequestBody QueryReq queryReq,
                        @PathVariable("table") String table,
                        @PathVariable("resultType") QueryReq.ResultType resultType) {

        queryReq.setTable(table);
        queryReq.setResultType(resultType);
        return commonService.query(queryReq);
    }


    @PostMapping("/save/{table}")
    public void save(@PathVariable("table") String table,
                       @RequestBody Map<String,Object> saveObj){
        SaveReq saveReq = new SaveReq();
        saveReq.setTable(table);
        saveReq.setSaveObj(saveObj);
        commonService.save(saveReq);
    }

    @PutMapping("/save/{table}")
    public void update(@PathVariable("table") String table,
                     @RequestBody UpdateReq updateReq){

        updateReq.setTable(table);
        commonService.update(updateReq);
    }

}
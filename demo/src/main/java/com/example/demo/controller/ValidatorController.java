package com.example.demo.controller;

import com.example.demo.bean.DemoModel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.validator.constraints.Range;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

/**
 * @author zhangfei
 * @version 1.0
 * @date 2020-07-08 15:46
 */
@Api(tags = {"校验模块接口"})
@RestController
@Slf4j
@RequestMapping(value = "/validation")
@Validated
public class ValidatorController {

    @ApiOperation(value = "校验基本类型1", notes = "校验基本类型1")
    @PostMapping(value = "/check1", produces = "application/json;charset=UTF-8")
    public void check1(@RequestBody @Valid DemoModel demo, BindingResult result) {
        if(result.hasErrors()){
            for (ObjectError error : result.getAllErrors()) {
                System.out.println(error.getDefaultMessage());
            }
        }
    }

    @ApiOperation(value = "校验基本类型2", notes = "校验基本类型2")
    @RequestMapping(value = "/check2", method = RequestMethod.GET)
    public Object demo3(@Range(min = 1, max = 9, message = "年级只能从1-9") @RequestParam(name = "grade", required = true) int grade
            , @Min(value = 1, message = "班级最小只能1") @Max(value = 99, message = "班级最大只能99") @RequestParam(name = "classroom", required = true) int classroom) {
        System.out.println(grade + "," + classroom);
        return grade+ "," + classroom;
    }


}

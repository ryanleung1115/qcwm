package com.sky.controller.admin;

import com.sky.dto.DishDTO;
import com.sky.dto.DishPageQueryDTO;
import com.sky.result.PageResult;
import com.sky.result.Result;
import com.sky.service.DishService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/dish")
@Api(tags = "dish interface")
@Slf4j
public class DishController {
    @Autowired
    private DishService dishService;

    @PostMapping
    @ApiOperation("add dish")
    public Result save(@RequestBody DishDTO dishDTO) {
        dishService.saveWithFlavor(dishDTO);

        return Result.success();
    }

    @GetMapping("/page")
    @ApiOperation("dish page query")
    public Result page(DishPageQueryDTO dishPageQueryDTO) {
        PageResult pageResult = dishService.pageQuery(dishPageQueryDTO);

        return Result.success(pageResult);
    }

    @DeleteMapping
    @ApiOperation("batch delete")
    public Result delete(@RequestParam List<Long> ids){
        log.info("ids: {}",ids);
        dishService.deleteBatch(ids);

        return Result.success();
    }
}

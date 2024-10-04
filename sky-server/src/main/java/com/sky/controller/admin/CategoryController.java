package com.sky.controller.admin;

import com.sky.dto.CategoryDTO;
import com.sky.dto.CategoryPageQueryDTO;
import com.sky.entity.Category;
import com.sky.result.PageResult;
import com.sky.result.Result;
import com.sky.service.CategoryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author zazhi
 * @date 2024/10/4
 * @description: 分类模块相关接口
 */
@RestController
@RequestMapping("/admin/category")
@Slf4j
@Tag(name = "分类相关接口")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @Operation(summary = "添加分类")
    @PostMapping
    public Result add(@RequestBody CategoryDTO categoryDTO){
        categoryService.add(categoryDTO);
        return Result.success();
    }

    @Operation(summary = "分页查询分类")
    @GetMapping("/page")
    public Result<PageResult> page(CategoryPageQueryDTO categoryPageQueryDTO){
        PageResult result = categoryService.page(categoryPageQueryDTO);
        return Result.success(result);
    }
}

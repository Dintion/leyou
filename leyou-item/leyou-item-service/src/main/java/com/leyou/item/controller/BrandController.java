package com.leyou.item.controller;

import com.item.leyou.pojo.Brand;
import com.leyou.common.pojo.PageResult;
import com.leyou.item.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 品牌相关controller
 *
 * @author lc
 */
@Controller
@RequestMapping("brand")
public class BrandController {
    @Autowired
    private BrandService brandService;

    @GetMapping("page")
    public ResponseEntity<PageResult<Brand>> queryBrandByPage(
            @RequestParam(value = "key", required = false)String key,
            @RequestParam(value = "page", defaultValue = "1")Integer page,
            @RequestParam(value = "rows", defaultValue = "5")Integer rows,
            @RequestParam(value = "sortBy", required = false)String sortBy,
            @RequestParam(value = "desc", required = false)Boolean desc
    ) {
        PageResult<Brand> pageResult = brandService.queryBrandsByPage(key, page, rows, sortBy, desc);
        if (CollectionUtils.isEmpty(pageResult.getItems())) {
            return ResponseEntity.notFound().build();
        }
        System.out.println(pageResult);
            return ResponseEntity.ok(pageResult);
    }

    @PostMapping
    public ResponseEntity<Void> saveBrand(Brand brand, @RequestParam(value = "cids[]") List<Long> cids) {
        brandService.saveBrand(brand, cids);
        return ResponseEntity.status(201).build();
    }
}

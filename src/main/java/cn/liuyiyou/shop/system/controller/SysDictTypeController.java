package cn.liuyiyou.shop.system.controller;


import cn.liuyiyou.shop.common.response.Response;
import cn.liuyiyou.shop.common.response.Result;
import cn.liuyiyou.shop.system.annotation.Log;
import cn.liuyiyou.shop.system.entity.SysDictType;
import cn.liuyiyou.shop.system.service.ISysDictTypeService;
import cn.liuyiyou.shop.system.vo.req.DataTableVo;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;

/**
 * <p>
 * 字典类型表 前端控制器
 * </p>
 *
 * @author liuyiyou.cn
 * @since 2018-09-03
 */
@Controller
@RequestMapping("/system/dict")
public class SysDictTypeController {
    private String prefix = "system/dict/type";

    @Autowired
    private ISysDictTypeService dictTypeService;

    //    @RequiresPermissions("system:dict:view")
    @GetMapping()
    public String dictType() {
        return prefix + "/type";
    }

    @PostMapping("/list")
//    @RequiresPermissions("system:dict:list")
    @ResponseBody
    public Result<IPage<SysDictType>> list(@RequestBody DataTableVo dataTableVo) {
        Page<SysDictType> pageQuery = new Page<>(dataTableVo.getPageNo(), dataTableVo.getPageSize());
        LambdaQueryWrapper<SysDictType> queryWrapper = new QueryWrapper<SysDictType>().lambda().select();
        IPage<SysDictType> page = dictTypeService.page(pageQuery, queryWrapper);
        return Response.success(page);
    }

    /**
     * 修改字典类型
     */
    @Log(title = "系统管理", action = "字典管理-修改字典类型")
//    @RequiresPermissions("system:dict:edit")
    @GetMapping("/edit/{dictId}")
    public String edit(@PathVariable("dictId") Integer dictId, Model model) {
        SysDictType dict = dictTypeService.getById(dictId);
        model.addAttribute("dict", dict);
        return prefix + "/edit";
    }

    /**
     * 新增字典类型
     */
    @Log(title = "系统管理", action = "字典管理-新增字典类型")
//    @RequiresPermissions("system:dict:add")
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    /**
     * 保存字典类型
     */
    @Log(title = "系统管理", action = "字典管理-保存字典类型")
//    @RequiresPermissions("system:dict:save")
    @PostMapping("/save")
    @ResponseBody
    public Result<Boolean> save(SysDictType dict) {
        return Response.success(dictTypeService.save(dict));
    }

    /**
     * 删除
     */
    @Log(title = "系统管理", action = "字典管理-删除字典类型")
//    @RequiresPermissions("system:dict:remove")
    @RequestMapping("/remove/{dictId}")
    @ResponseBody
    public Result<Object> remove(@PathVariable("dictId") Integer dictId) {
        SysDictType dictType = dictTypeService.getById(dictId);
        if (dictType == null) {
            return Response.fail("字典不存在");
        }
        if (dictTypeService.removeById(dictId)) {
            return Response.success();
        }
        return Response.fail();
    }

    @Log(title = "系统管理", action = "字典类型-批量删除")
//    @RequiresPermissions("system:dict:batchRemove")
    @PostMapping("/batchRemove")
    @ResponseBody
    public Result<Object> batchRemove(@RequestParam("ids[]") Integer[] ids) {
        boolean rows = dictTypeService.removeByIds(Arrays.asList(ids));
        if (rows) {
            return Response.success();
        }
        return Response.fail();
    }

    /**
     * 查询字典详细
     */
    @Log(title = "系统管理", action = "字典管理-查询字典数据")
//    @RequiresPermissions("system:dict:list")
    @GetMapping("/detail/{dictId}")
    public String detail(@PathVariable("dictId") Long dictId, Model model) {
        SysDictType dict = dictTypeService.getById(dictId);
        model.addAttribute("dict", dict);
        return "system/dict/data/data";
    }

    /**
     * 校验字典类型
     */
    @PostMapping("/checkDictTypeUnique")
    @ResponseBody
    public String checkDictTypeUnique(SysDictType dictType) {
        String uniqueFlag = "0";
        if (dictType != null) {
            uniqueFlag = dictTypeService.checkDictTypeUnique(dictType);
        }
        return uniqueFlag;
    }
}


package cn.liuyiyou.shop.system.controller;


import cn.liuyiyou.shop.common.response.Response;
import cn.liuyiyou.shop.common.response.Result;
import cn.liuyiyou.shop.system.annotation.Log;
import cn.liuyiyou.shop.system.entity.SysDictData;
import cn.liuyiyou.shop.system.service.ISysDictDataService;
import cn.liuyiyou.shop.system.vo.req.DataTableVo;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
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
 * 字典数据表 前端控制器
 * </p>
 *
 * @author liuyiyou.cn
 * @since 2018-08-27
 */
@Controller
@RequestMapping("/system/dict/data")
public class SysDictDataController {

    private String prefix = "system/dict/data";

    @Autowired
    private ISysDictDataService dictDataService;

    //    @RequiresPermissions("system:dict:view")
    @PreAuthorize("hasPermission(#contact, 'system:dict:view')")
    @GetMapping()
    public String dictData() {
        return prefix + "/data";
    }

    @PostMapping("/list")
//    @RequiresPermissions("system:dict:list")
    @ResponseBody
    public Result<IPage<SysDictData>> list(@RequestBody DataTableVo dataTableVo) {
        Page<SysDictData> pageQuery = new Page<>(dataTableVo.getPageNo(), dataTableVo.getPageSize());
        LambdaQueryWrapper<SysDictData> queryWrapper = new QueryWrapper<SysDictData>().lambda().select();
        IPage<SysDictData> page = dictDataService.page(pageQuery, queryWrapper);
        return Response.success(page);
    }

    /**
     * 修改字典类型
     */
    @Log(title = "系统管理", action = "字典管理-修改字典数据")
//    @RequiresPermissions("system:dict:edit")
    @GetMapping("/edit/{dictCode}")
    public String edit(@PathVariable("dictCode") Integer dictCode, Model model) {
        SysDictData dict = dictDataService.getById(dictCode);
        model.addAttribute("dict", dict);
        return prefix + "/edit";
    }

    /**
     * 新增字典类型
     */
    @Log(title = "系统管理", action = "字典管理-新增字典数据")
//    @RequiresPermissions("system:dict:add")
    @GetMapping("/add/{dictType}")
    public String add(@PathVariable("dictType") String dictType, Model model) {
        model.addAttribute("dictType", dictType);
        return prefix + "/add";
    }

    /**
     * 保存字典类型
     */
    @Log(title = "系统管理", action = "字典管理-保存字典数据")
//    @RequiresPermissions("system:dict:save")
    @PostMapping("/save")
    @ResponseBody
    public Result save(SysDictData dict) {
        return Response.success(dictDataService.save(dict));
    }

    /**
     * 删除
     */
    @Log(title = "系统管理", action = "字典管理-删除字典数据")
//    @RequiresPermissions("system:dict:remove")
    @RequestMapping("/remove/{dictCode}")
    @ResponseBody
    public Result remove(@PathVariable("dictCode") Integer dictCode) {
        SysDictData dictData = dictDataService.getById(dictCode);
        if (dictData == null) {
            return Response.fail("字典数据不存在");
        }
        if (dictDataService.removeById(dictCode)) {
            return Response.success();
        }
        return Response.fail();
    }

    @Log(title = "系统管理", action = "字典类型-批量删除")
//    @RequiresPermissions("system:dict:batchRemove")
    @PostMapping("/batchRemove")
    @ResponseBody
    public Result batchRemove(@RequestParam("ids[]") Integer[] ids) {
        return Response.success(dictDataService.removeByIds(Arrays.asList(ids)));
    }
}


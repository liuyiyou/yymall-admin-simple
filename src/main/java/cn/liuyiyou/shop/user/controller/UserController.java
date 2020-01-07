package cn.liuyiyou.shop.user.controller;


import cn.liuyiyou.shop.common.response.Response;
import cn.liuyiyou.shop.common.response.Result;
import cn.liuyiyou.shop.common.web.BaseController;
import cn.liuyiyou.shop.prod.vo.req.ProdListReqVo;
import cn.liuyiyou.shop.system.vo.req.DataTableVo;
import cn.liuyiyou.shop.user.entity.User;
import cn.liuyiyou.shop.user.service.IUserService;
import cn.liuyiyou.shop.user.vo.Prod;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author liuyiyou.cn
 * @since 2018-11-12
 */
@RestController
@RequestMapping("/api/users")
//@CrossOrigin
public class UserController extends BaseController {

    @Autowired
    private IUserService userService;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/prods")
    public Result<Page<Prod>> prods() {
        ProdListReqVo prodListReqVo = new ProdListReqVo();
        String page = restTemplate.getForEntity("http://PROD-SERVICE/prod/list", String.class,prodListReqVo).getBody();
        Page<Prod> prodPage = JSONObject.parseObject(page, new TypeReference<Page<Prod>>() {});
        return Response.success(prodPage);
    }


    @GetMapping("/get")
    public Result get(HttpServletRequest request) {
        Integer uid = getUid(request);
        Optional.ofNullable(uid).orElseThrow(() -> new RuntimeException("未登陆"));
        return Response.success(userService.getById(Integer.valueOf(uid)));
    }


    @GetMapping("/list")
    public Result<List<User>> list() {
        LambdaQueryWrapper<User> userWrap = new QueryWrapper<User>()
                .lambda()
                .select().last("1= 1 limit 10");
        List<User> list = userService.list(userWrap);
        return Response.success(list);
    }

    @ApiOperation(value = "获取用户列表")
    @PostMapping()
    public Result<IPage<User>> list(DataTableVo dataTableVo) {
        Page<User> pageQuery = new Page<>(dataTableVo.getPageNo(), dataTableVo.getPageSize());
        IPage<User> sysUserPage = userService.page(pageQuery);
        return Response.success(sysUserPage);
    }
}


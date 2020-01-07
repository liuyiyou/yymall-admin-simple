package cn.liuyiyou.shop.user.controller.admin;

import cn.liuyiyou.shop.common.response.Response;
import cn.liuyiyou.shop.common.response.Result;
import cn.liuyiyou.shop.system.vo.req.DataTableVo;
import cn.liuyiyou.shop.user.entity.User;
import cn.liuyiyou.shop.user.service.IUserService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * 会员管理
 *
 * @author: liuyiyou.cn
 * @date: 2019/7/16
 * @version: V1.0
 */
@RestController
@RequestMapping("/user/admin")
@Api(description = "会员管理相关接口")
public class AdminUserController {

    private String prefix = "user";

    @Autowired
    private IUserService userService;

    @ApiOperation(value = "跳转到用户列表页面")
    @GetMapping()
    public ModelAndView list() {
        return new ModelAndView(prefix + "/user");
    }



}

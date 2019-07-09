package cn.liuyiyou.shop.system.controller;

import cn.liuyiyou.shop.common.exception.DefaultException;
import com.alibaba.fastjson.JSON;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.web.ErrorProperties;
import org.springframework.boot.autoconfigure.web.servlet.error.BasicErrorController;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @author: liuyiyou.cn
 * @date: 2018/12/24
 * @version: V1.0
 */
@RestController
@Slf4j
@Api(description = "自定义错误处理")
public class DefaultErrorController extends BasicErrorController {


    public DefaultErrorController() {
        super(new DefaultErrorAttributes(), new ErrorProperties());
    }

    private static final String PATH = "/error";

    @RequestMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    @Override
    public ResponseEntity error(HttpServletRequest request) {
        log.info("自定义错误处理");
        Map<String, Object> body = getErrorAttributes(request,
                isIncludeStackTrace(request, MediaType.ALL));
        throw new DefaultException(JSON.toJSONString(body));
    }

    @Override
    public String getErrorPath() {
        return PATH;
    }
}

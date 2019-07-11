package cn.liuyiyou.shop.config.validator;

import org.hibernate.validator.HibernateValidator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.validation.Validation;
import javax.validation.Validator;

/**
 * spring validator fail_fast 校验。 只要一个失败就返回
 *
 * @author: liuyiyou.cn
 * @date: 2018/12/28
 * @version: V1.0
 */
@Configuration
public class ValidatorConfiguration {
    @Bean
    public Validator validator() {
        return Validation.byProvider(HibernateValidator.class)
            .configure()
            .failFast(true)
            .buildValidatorFactory().getValidator();
    }
}

package cn.liuyiyou.yishop.mapper;

import cn.liuyiyou.yishop.entity.ValidateInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ValidateInfoMapper extends BaseMapper {

    public ValidateInfo queryByCode(String code);

    public List<ValidateInfo> queryValidValidateInfoByUserIdAndTargetAndType(@Param("userId") int userId, @Param("target") String target, @Param("type") String type);

    public void updateStatus(ValidateInfo validateInfo);

}

package cn.liuyiyou.yishop.biz.brand;

import java.io.File;

import cn.liuyiyou.yishop.common.util.ImageUtil;
import cn.liuyiyou.yishop.common.util.constansts.Constants;
import cn.liuyiyou.yishop.entity.Brand;
import cn.liuyiyou.yishop.entity.TempPic;
import cn.liuyiyou.yishop.service.BrandService;
import cn.liuyiyou.yishop.service.TempPicService;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BrandManager {

    @Autowired
    private BrandService brandService;

    @Autowired
    private TempPicService tempPicService;

    public void txAdd(Brand brand, int tempPicId) throws Exception {

        brandService.add(brand);

        if (tempPicId != 0) {
            TempPic tempPic = tempPicService.findById(tempPicId);
            if (tempPic == null) {
                return;
            }

            String path = ImageUtil.getImageDir(Constants.TYPE_BRAND).append(DigestUtils.md5Hex((brand.getId() + "").getBytes())).append(tempPic.getSuffix()).toString();

            FileUtils.copyFile(new File(tempPic.getPicPath()), new File(path));

            brandService.setLogo(brand.getId(), path);

            tempPicService.deleteTempPicById(tempPicId);
        }

    }
}

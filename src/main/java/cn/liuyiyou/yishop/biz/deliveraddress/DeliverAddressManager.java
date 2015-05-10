package cn.liuyiyou.yishop.biz.deliveraddress;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cn.liuyiyou.yishop.common.util.constansts.Constants;
import cn.liuyiyou.yishop.entity.DeliverAddress;
import cn.liuyiyou.yishop.service.DeliverAddressService;


@Component
public class DeliverAddressManager {

    @Autowired
    private DeliverAddressService deliverAddressService;

    public void txAddDeliverAddress(DeliverAddress deliverAddress) {
        if (Constants.STATUS_VALID.equals(deliverAddress.getDefaultStatus())) {
            deliverAddressService.modifyDefaultStatus(deliverAddress.getId(), deliverAddress.getUserId(), Constants.STATUS_INVALID);
        }
        deliverAddressService.add(deliverAddress);
    }

    public void txModifyDeliverAddress(int id, DeliverAddress deliverAddress) {
        if (Constants.STATUS_VALID.equals(deliverAddress.getDefaultStatus())) {
            deliverAddressService.modifyDefaultStatus(deliverAddress.getId(), deliverAddress.getUserId(), Constants.STATUS_INVALID);
        }
        deliverAddress.setId(id);
        deliverAddressService.edit(deliverAddress);
    }

    public void txSetDefaultStatus(int id, int userId) {

        deliverAddressService.modifyDefaultStatus(0, userId, Constants.STATUS_INVALID);

        deliverAddressService.modifyDefaultStatus(id, userId, Constants.STATUS_VALID);
    }

}

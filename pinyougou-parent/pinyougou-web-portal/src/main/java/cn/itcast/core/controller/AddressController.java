package cn.itcast.core.controller;

import cn.itcast.core.pojo.address.Address;
import cn.itcast.core.service.AddressService;
import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 收货地址管理
 */
@RestController
@RequestMapping("/address")
public class AddressController {

    @Reference
    private AddressService addressService;

    //根据当前登陆人查询收货地址集合
    @RequestMapping("/findListByLoginUser")
    public List<Address> findListByLoginUser(){
        //当前登陆人
        String name = SecurityContextHolder.getContext().getAuthentication().getName();

        return addressService.findListByLoginUser(name);
    }
}

package com.xzsd.app.clientorder.controller;

import com.xzsd.app.clientorder.service.ClientOrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * ClientOrderController
 * @author linxianghang
 * @date 2020-04-26
 */
@RestController
@RequestMapping("/clientOrder")
public class ClientOrderController {
    private static final Logger logger = LoggerFactory.getLogger(ClientOrderController.class);

    @Resource
    private ClientOrderService clientOrderService;


}

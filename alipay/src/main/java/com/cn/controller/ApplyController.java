package com.cn.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.domain.AlipayTradeAppPayModel;
import com.alipay.api.request.AlipayFundCouponOrderPagePayRequest;
import com.alipay.api.request.AlipayTradeAppPayRequest;
import com.alipay.api.response.AlipayFundCouponOrderPagePayResponse;
import com.alipay.api.response.AlipayTradeAppPayResponse;
import com.cn.config.AlipayConfig;
import com.cn.utils.ResultBean;

/**
 * 支付宝支付接口
 */
@Controller
public class ApplyController {

	private static AlipayClient alipayClient = new DefaultAlipayClient("https://openapi.alipay.com/gateway.do",
			AlipayConfig.app_id, AlipayConfig.private_key, "json", "UTF-8", AlipayConfig.ali_public_key, "RSA2");

	@RequestMapping(value = "/api/apply")
	@ResponseBody
	public ResultBean apply(@RequestParam String money) {
		System.out.println("调用支付接口");
		// 实例化客户端
		String mess = "";
		// 实例化具体API对应的request类,类名称和接口名称对应,当前调用接口名称：alipay.trade.app.pay
		AlipayTradeAppPayRequest request = new AlipayTradeAppPayRequest();
		// SDK已经封装掉了公共参数，这里只需要传入业务参数。以下方法为sdk的model入参方式(model和biz_content同时存在的情况下取biz_content)。
		AlipayTradeAppPayModel model = new AlipayTradeAppPayModel();
		model.setBody("商品描述");
		model.setSubject("商品名称");
		model.setOutTradeNo(UUID.randomUUID().toString());
		model.setTimeoutExpress("30m");
		model.setTotalAmount(money);
		model.setProductCode("QUICK_MSECURITY_PAY");
		request.setBizModel(model);
		request.setNotifyUrl(AlipayConfig.service);
		try {
			// 这里和普通的接口调用不同，使用的是sdkExecute
			AlipayTradeAppPayResponse response = alipayClient.sdkExecute(request);
			System.out.println("orderString:" + response.getBody());// 就是orderString 可以直接给客户端请求，无需再做处理。
			mess = response.getBody();
			Map<String, Object> map = new HashMap();
			map.put("orderString", mess);
			return ResultBean.ok(map);
		} catch (AlipayApiException e) {
			e.printStackTrace();
		}

		return ResultBean.error();
	}

	@RequestMapping(value = "/api/pagepay")
	@ResponseBody
	public ResultBean pagepay(@RequestParam String money) {
		AlipayFundCouponOrderPagePayRequest request = new AlipayFundCouponOrderPagePayRequest();
		request.setBizContent("{" + "\"out_order_no\":\"8077735255938023\","
				+ "\"out_request_no\":\"8077735255634078\"," + "\"order_title\":\"发送红包\"," + "\"amount\":100.00,"
				+ "\"pay_timeout\":\"1h\"," + "\"extra_param\":\"{\\\"merchantExt\\\":\\\"key=value\\\"}\"" + "  }");
		try {
			AlipayFundCouponOrderPagePayResponse response = alipayClient.execute(request);
			if (response.isSuccess()) {
				System.out.println("调用成功");
			} else {
				System.out.println("调用失败");
			}
		} catch (AlipayApiException e) {
			e.printStackTrace();
		}
		return ResultBean.error();
	}
}

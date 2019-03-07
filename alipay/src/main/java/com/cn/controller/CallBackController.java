package com.cn.controller;

import com.alipay.api.AlipayApiException;
import com.alipay.api.internal.util.AlipaySignature;
import com.cn.config.AlipayConfig;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/**
 * 支付宝回调接口
 */
@Controller
public class CallBackController {

    @RequestMapping(value = "/api/callBack")
    @ResponseBody
    private String callBack(HttpServletRequest request){
        System.out.println("调用回调接口");
        //获取支付宝POST过来反馈信息
        Map<String,String> params = new HashMap<String,String>();
        Map requestParams = request.getParameterMap();
        for (Iterator iter = requestParams.keySet().iterator(); iter.hasNext();) {
            String name = (String) iter.next();
            String[] values = (String[]) requestParams.get(name);
            String valueStr = "";
            for (int i = 0; i < values.length; i++) {
                valueStr = (i == values.length - 1) ? valueStr + values[i]
                        : valueStr + values[i] + ",";
            }
            //乱码解决，这段代码再出现乱码的时候使用
            //valueStr = new String(valueStr.getBytes("ISO-8859-1"), "utf-8");
            params.put(name, valueStr);
        }
        System.out.println("接收支付宝传过来的参数"+params.toString());
        String mess = "";
        //切记alipaypublickey是支付宝的公钥，请去open.alipay.com对应应用下查看。
        //boolean AlipaySignature.rsaCheckV1(Map<String, String> params, String publicKey, String charset, String sign_type)
        try {
            boolean flag = AlipaySignature.rsaCheckV1(params, AlipayConfig.ali_public_key, "UTF-8","RSA2");
            System.out.println("====================================================================================================" + flag);
            if (flag){
                /**
                 	*支付成功后的业务处理
                 */
                mess = "success";
            }else {
                /**
                 	*支付失败后的业务处理
                 */
                mess = "failure";
            }
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
        System.out.println("结果为"+mess);
        return mess;
    }

}

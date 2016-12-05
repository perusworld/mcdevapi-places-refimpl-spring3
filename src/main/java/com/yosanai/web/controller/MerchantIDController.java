package com.yosanai.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mastercard.api.core.model.RequestMap;
import com.mastercard.api.merchantidentifier.MerchantIdentifier;
import com.yosanai.web.model.MerchantIDRequest;

@Controller
public class MerchantIDController {

	@RequestMapping(value = "/query", method = RequestMethod.POST, produces = "application/json")
	public @ResponseBody MerchantIdentifier query(@RequestBody MerchantIDRequest req) throws Exception {
		RequestMap map = new RequestMap();
		map.set("Type", "FuzzyMatch");
		map.set("MerchantId", req.getMerchantId());
		return MerchantIdentifier.query(map);
	}

}

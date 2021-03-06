package com.ssg.potato.item.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.ssg.potato.item.model.AuctionThumb;
import com.ssg.potato.item.search.service.SearchService;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;

@Controller
@SessionAttributes({ "category", "productList" })
public class ListAuctionController {

	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(ListAuctionController.class);
	private SearchService service;

	@Autowired
	public void setAuctionService(SearchService service) {
		this.service = service;
	}

	@RequestMapping("/list/auction")
	public String joinPOST(ModelMap model) throws Exception {
		logger.info("auction list 출력");

		PagedListHolder<AuctionThumb> productList = new PagedListHolder<>(this.service.getAuctionsList());
		productList.setPageSize(3);
		model.put("category", "경매");
		model.put("productList", productList);

		return "searchAuction";
	}

	@RequestMapping("/list/auction2")
	public String handleRequest2(@RequestParam("page") String page, @ModelAttribute("category") String category,
			@ModelAttribute("productList") PagedListHolder<AuctionThumb> productList, BindingResult result)
			throws Exception {
		if (category == null || productList == null) {
			throw new IllegalStateException("Cannot find pre-loaded category and product list");
		}
		if ("next".equals(page)) {
			productList.nextPage();
		} else if ("previous".equals(page)) {
			productList.previousPage();
		}
		return "searchAuction";
	}

}

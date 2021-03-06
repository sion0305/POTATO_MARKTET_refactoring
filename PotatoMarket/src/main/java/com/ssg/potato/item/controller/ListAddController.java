package com.ssg.potato.item.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ssg.potato.account.controller.UserSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ssg.potato.item.model.AuctionThumb;
import com.ssg.potato.item.model.Group;
import com.ssg.potato.item.model.GroupThumb;
import com.ssg.potato.item.model.ItemThumb;
import com.ssg.potato.item.service.AuctionService;
import com.ssg.potato.item.service.BidService;
import com.ssg.potato.item.service.GroupService;
import com.ssg.potato.item.service.ItemService;
import com.ssg.potato.item.search.service.SearchService;

@Controller
public class ListAddController {

   private SearchService search;

   private GroupService group;
   private AuctionService auction;
   private ItemService item;
   private BidService bid;

   @Autowired
   public void setGroupService(GroupService service) {
      this.group = service;
   }

   @Autowired
   public void setSearchService(SearchService service) {
      this.search = service;
   }
   
   @Autowired
   public void seItemService(ItemService service) {
      this.item = service;
   }
   
   @Autowired
   public void seAuctionService(AuctionService service) {
      this.auction = service;
   }
   
   @Autowired
   public void setBidService(BidService service) {
      this.bid = service;
   }

   @RequestMapping("/check/addList")
   public String viewCart(
         HttpServletRequest request, 
         @RequestParam("category") String category, 
         ModelMap model
         )throws Exception {
      HttpSession session = request.getSession();
      String member_id = UserSession.getLoginMemberId(session);
      String move = "";
      switch (category) {
         case "?????????":
            List<ItemThumb> itemList = new ArrayList<>(this.search.getItemsAddList(member_id));
            model.put("productList", itemList);
            move = "itemAddList";
            break;
         case "??????":
            List<GroupThumb> groupList = new ArrayList<>(this.search.getGroupsAddList(member_id));
            model.put("productList", groupList);
            move = "groupAddList";
            break;
         case "??????":
            List<AuctionThumb> auctionList = new ArrayList<>(
                  this.search.getAuctionsAddList(member_id));
            model.put("productList", auctionList);
            move = "auctionAddList";
            break;
      }
      model.put("category", category);
      return move;
   }

   @RequestMapping("/delete/group") // ?????? ?????? ??????
   public String delete1(
         HttpServletRequest request,
         RedirectAttributes model,
         HttpServletResponse response,
         @ModelAttribute("group_id") int group_id
         ) throws Exception {
      Group tmp = group.selectGroup(group_id);
      if(tmp.getCurrentPeople() > 1) {
         response.setContentType("text/html; charset=UTF-8"); 
         RequestDispatcher dispatcher = request.getRequestDispatcher( "auctionAddList" );
         dispatcher.include( request, response );
         response.getWriter().write("<script> alert('??? ?????? : ???????????? ?????? ?????? ???????????? ??? ????????????.'); history.go(-1); </script>");
         response.getWriter().flush();
         return null;
      }else {
         group.delete(group_id);
         model.addAttribute("category", "??????");
      }
      
      return "redirect:/check/addList";
   }
   
   @RequestMapping("/delete/item") // ????????? ??????
   public String delete2(
         HttpServletRequest request,
         RedirectAttributes model,
         @ModelAttribute("item_id") int item_id
         ) throws Exception {
      item.delete(item_id);
      model.addAttribute("category", "?????????");
      return "redirect:/check/addList";
   }
   
   @RequestMapping("/delete/auction") // ?????? ??????
   public String delete2(
         HttpServletRequest request,
         RedirectAttributes model, 
         HttpServletResponse response,
         @ModelAttribute("auction_id") int auction_id
         ) throws Exception {

      if (bid.dataCountBidCheck(auction_id) != 0) {
         response.setContentType("text/html; charset=UTF-8"); 
         RequestDispatcher dispatcher = request.getRequestDispatcher( "auctionAddList" );
         dispatcher.include( request, response );
         response.getWriter().write("<script> alert('??? ?????? : ???????????? ???????????? ????????? ???????????? ??? ????????????.'); history.go(-1); </script>");
         response.getWriter().flush();
         return null;
      } else {
         auction.delete(auction_id);
         auction.deleteLike(auction_id);
      }
      model.addAttribute("category", "??????");
      return "redirect:/check/addList";
   }

   
   @RequestMapping("/update/selled") // ?????? ??????
   public String update(
         HttpServletRequest request,
         RedirectAttributes model,
         @ModelAttribute("item_id") int item_id
         ) throws Exception {
      HttpSession session = request.getSession();
      String member_id = UserSession.getLoginMemberId(session);
      item.updateComplete(item_id,member_id);
      model.addAttribute("category", "?????????");
      return "redirect:/check/addList";
   }

}
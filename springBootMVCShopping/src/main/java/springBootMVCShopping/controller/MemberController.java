package springBootMVCShopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import springBootMVCShopping.command.MemberCommand;
import springBootMVCShopping.service.AutoNumService;
import springBootMVCShopping.service.member.MemberDeleteService;
import springBootMVCShopping.service.member.MemberDetailService;
import springBootMVCShopping.service.member.MemberListService;
import springBootMVCShopping.service.member.MemberUpdateService;
import springBootMVCShopping.service.member.MemberWriteService;
import springBootMVCShopping.service.member.MembersDeleteService;

@Controller
@RequestMapping("member") // 공동주소 처리
public class MemberController {
	@Autowired
	MemberWriteService memberWriteSerivce;
	@Autowired
	AutoNumService autoNumService;
	@Autowired
	MemberListService memberListService;
	@Autowired
	MembersDeleteService membersDeleteSevice;
	@Autowired
	MemberDeleteService memberDeleteService;
	@Autowired
	MemberDetailService memberDetailService;
	@Autowired
	MemberUpdateService memberUpdateService;
	@GetMapping("memberList")
	public String list(
				 @RequestParam(value = "page", required=false, defaultValue = "1") Integer page
				,@RequestParam(value="searchWord", required=false) String searchWord
				, Model model) {
		memberListService.execute(searchWord, page, model);
		return "thymeleaf/member/memberList";  // html
		//return "member/memberList";   --> jsp
	}
	@GetMapping("memberWrite")
	public String write(Model model, String autoNum) {
		autoNum = autoNumService.execute("mem_", "member_num", 5, "members");
		MemberCommand memberCommand = new MemberCommand();
		memberCommand.setMemberNum(autoNum);
		model.addAttribute("memberCommand", memberCommand);
		return "thymeleaf/member/memberForm";
		//return "member/memberForm";
	}
	@PostMapping("memberRegist")
	public String write(@Validated MemberCommand memberCommand
			,BindingResult result
			,Model model) {
		if(result.hasErrors()) {
			return "thymeleaf/member/memberForm";
		}
		if(!memberCommand.isMemberPwEqualMemberPwCon()) {
			//model.addAttribute("errPw", "비밀번호가 일치하지 않습니다.");
			result.rejectValue("memberPwCon", "memberCommand.memberPwCon", "비밀번호가 일치하지 않습니다.");
			return "thymeleaf/member/memberForm";
		}
		memberWriteSerivce.execute(memberCommand);
		return "redirect:memberList";
	}
	
	@RequestMapping(value = "membersDelete")
	public String membersDelete(@RequestParam("nums") String memberNums []) {
		membersDeleteSevice.execute(memberNums);
		return "redirect:memberList";
	}
	//PathVariable --> 다음 주소는 무조건 ../써야함
	@GetMapping("memberDetail/{memberNum}")
	public  String memberDetail(@PathVariable("memberNum") String memberNum
			,Model model) {
		memberDetailService.execute(model, memberNum);
		return "thymeleaf/member/memberInfo";
	}
	@GetMapping("memberUpdate")
	public String memberUpdate(Model model, String memberNum) {
		memberDetailService.execute(model, memberNum);
		return "thymeleaf/member/memberUpdate";
	}
	@PostMapping("memberUpdate")
	public String memberUpdate(@Validated MemberCommand memberCommand
			,BindingResult result) {
		if(result.hasErrors()) {
			return "thymeleaf/member/memberUpdate";
		}
		System.out.println("memberCommand.getMemberName() : " + memberCommand.getMemberName());
		memberUpdateService.execute(memberCommand);
		return "redirect:memberDetail/" + memberCommand.getMemberNum();
	}
	@GetMapping("memberDelete/{memberNum}")
	public String memberDelete(@PathVariable("memberNum") String memberNum) {
		memberDeleteService.execute(memberNum);
		return "redirect:memberList";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

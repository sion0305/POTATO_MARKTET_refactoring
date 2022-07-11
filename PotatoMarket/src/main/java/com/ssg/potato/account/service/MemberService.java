package com.ssg.potato.account.service;

import com.ssg.potato.account.model.Member;

public interface MemberService {
	public void memberJoin(Member member) throws Exception;

	public Member loginMember(Member vo) throws Exception;
	
	public void memberUpdate(Member member) throws Exception;
	
	public Member findingMember(Member vo) throws Exception;

	public Member memberFind(String member_id) throws Exception;

	public void memberDelete(String member_id) throws Exception;
}

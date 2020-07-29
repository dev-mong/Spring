package di.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import di.dao.Dao;
import di.domain.Member;
import di.exception.IdPasswordNotMatchingException;
import di.exception.MemberNotFoundException;

@Component("memberPwSvc1")
public class ChangePasswordService3 {
	
	/* @Autowired */
	@Resource(name="dao")
	private Dao dao;


	public void changePassword(String email, String oldPwd, String newPwd) throws IdPasswordNotMatchingException, MemberNotFoundException {
		Member member = dao.selectByEmail(email);
		if (member == null)
			throw new MemberNotFoundException();

		member.changePassword(oldPwd, newPwd);

		dao.update(member);
	}

}

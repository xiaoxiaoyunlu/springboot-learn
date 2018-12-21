package oz.mano.online;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import oz.mano.online.domain.db.AccountUser;
import oz.mano.online.mapper.AccountMapper;
import oz.mano.online.mapper.ApkVersionMapper;

public class TestAccount extends SpringBootBaseTest {
	
	@Autowired
	private AccountMapper accountMapper;
	
	@Autowired
	private ApkVersionMapper apkVersionMapper;
	
	@Test
	public void testLogin()throws Exception{
		
		String phone="13534589075";
		AccountUser user = accountMapper.accountLogin(phone);
		System.out.println("result:"+user);
	}
	
	@Test
	public void testApk()throws Exception{
		System.out.println("11111111111111");
	}

}

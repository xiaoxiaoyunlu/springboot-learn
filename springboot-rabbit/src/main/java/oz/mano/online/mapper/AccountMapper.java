package oz.mano.online.mapper;

import org.apache.ibatis.annotations.Mapper;

import oz.mano.online.domain.db.AccountUser;

@Mapper
public interface AccountMapper extends BaseMapper<AccountUser> {
	
	AccountUser accountLogin(String phone)throws Exception;

}

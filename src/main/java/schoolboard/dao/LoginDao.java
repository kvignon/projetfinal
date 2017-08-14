package schoolboard.dao;

import schoolboard.model.Login;

public interface LoginDao extends Dao<Login,Long>{
	
	Login find(String login);

	Login checkLogin(String login, String password);

}

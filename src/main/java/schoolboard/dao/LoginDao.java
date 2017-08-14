package schoolboard.metier.dao;

import schoolboard.metier.model.Login;

public interface LoginDao extends Dao<Login,Long>{
	
	Login find(String login);

	Login checkLogin(String login, String password);

}

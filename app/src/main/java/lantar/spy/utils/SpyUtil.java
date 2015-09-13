package lantar.spy.utils;

import com.parse.ParseUser;

import lantar.spy.entity.Spy;

public class SpyUtil {

	public static Spy getUserForm(ParseUser parseUser) {
        Spy spy = new Spy();
		spy.setId(parseUser.getObjectId());
		spy.setEmail(parseUser.getEmail());
		spy.setFio(parseUser.getString(Constants.USER_FIO));
		spy.setPhone(parseUser.getString(Constants.USER_PHONE));
        spy.setRoute((int) parseUser.getNumber(Constants.USER_ROUTE));
        spy.setRole(parseUser.getString(Constants.USER_ROLE));
        spy.setBrigade(parseUser.getInt(Constants.USER_BRIGADE));
		return spy;
	}

	public static ParseUser getParseUserCreate(Spy spy) {
		ParseUser parseUser = new ParseUser();
		parseUser.setUsername(spy.getEmail());
		parseUser.setPassword(spy.getPass());
		parseUser.setEmail(spy.getEmail());
		parseUser.put(Constants.USER_NAME, spy.getEmail());
		parseUser.put(Constants.USER_FIO, spy.getFio());
        parseUser.put(Constants.USER_ROUTE, spy.getRoute());
        parseUser.put(Constants.USER_URL, spy.getUrl());
        parseUser.put(Constants.USER_ROLE, spy.getRole());
        if(spy.getBrigade() > 0)
        parseUser.put(Constants.USER_BRIGADE, spy.getBrigade());
		return parseUser;
	}


}

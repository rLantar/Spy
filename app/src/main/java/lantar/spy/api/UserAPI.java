package lantar.spy.api;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

import com.parse.GetCallback;
import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseFile;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;
import com.parse.RefreshCallback;
import com.parse.RequestPasswordResetCallback;
import com.parse.SignUpCallback;

import lantar.spy.entity.Spy;
import lantar.spy.utils.Constants;
import lantar.spy.utils.SpyUtil;

/**
 * Created by Lantar on 22.06.2015.
 */

public class UserAPI {

	private static Handler handler;


	private Spy user = new Spy();

	public UserAPI(Handler handler) {
		super();
		this.handler = handler;
	}

//	public UserAPI() {
//		super();
//	}

	public void create(final Spy spy) {
		Log.d(Constants.LOG, "Start create User ");
		final ParseUser parseUser = SpyUtil.getParseUserCreate(spy);
		this.user = spy;
		parseUser.signUpInBackground(new SignUpCallback() {
			@Override
			public void done(ParseException e) {
				if (e == null) {
					if (parseUser.getObjectId() != null) {
                        spy.setId(parseUser.getObjectId());
                        handler.sendEmptyMessage(HandlerResult.OK.getResult());
                        handler.sendMessage(getMessageWithObject(HandlerResult.USER_CREATE, spy));

						Log.d(Constants.LOG, "User created!");
					}
					return;
				} else {
					Log.d(Constants.LOG, e.toString());
					e.printStackTrace();
					error(e);
				}
			}
		});

	}

	public static void login(String email, String password) {
		ParseUser.logInInBackground(email, password, new LogInCallback() {
            public void done(ParseUser user, ParseException e) {
                if (user == null) {
                    handler.sendEmptyMessage(HandlerResult.ERROR.getResult());
                    return;
                }
                handler.sendEmptyMessage(HandlerResult.OK.getResult());
            }
        });
	}

	public static void logOut() {
		ParseUser.logOut();
	}

	public void update(final Spy spy) {
		Log.d(Constants.LOG, "Start update User sitaId");
		ParseUser parseUser;
		try {
			parseUser = ParseUser.logIn(spy.getEmail(), spy.getPass());
			ParseQuery<ParseUser> query = ParseUser.getQuery();
			query.getInBackground(parseUser.getObjectId(), new GetCallback<ParseUser>() {

				@Override
				public void done(ParseUser parseUser, ParseException e) {
					parseUser.saveInBackground(

					);
				}
			});
		} catch (ParseException e1) {
			e1.printStackTrace();
		}

	}

    public void update() {
        ParseUser.getCurrentUser().refreshInBackground(new RefreshCallback() {
            public void done(ParseObject object, ParseException e) {
                if (e == null) {
                    Log.i(Constants.LOG, "User update Success! Route: " + ParseUser.getCurrentUser().get(Constants.ROUTE_ROUTE));
                    success();
                } else {
                    error();
                    Log.i(Constants.LOG, "User update Failure!");
                }
            }
        });
    }

	public void update(final Spy spy, final ParseFile parseFile) {
		Log.d(Constants.LOG, "Start update User photo");
		ParseUser parseUser;
		try {
			parseUser = ParseUser.logIn(spy.getEmail(), spy.getPass());
			ParseQuery<ParseUser> query = ParseUser.getQuery();
			query.getInBackground(parseUser.getObjectId(), new GetCallback<ParseUser>() {

				@Override
				public void done(ParseUser parseUser, ParseException e) {
					parseUser.saveInBackground();
				}
			});
		} catch (ParseException e1) {
			e1.printStackTrace();
		}

	}

	public void sentPassword(String email) {
		ParseUser.requestPasswordResetInBackground(email, new RequestPasswordResetCallback() {
            public void done(ParseException e) {
                if (e == null) {
                    handler.sendEmptyMessage(HandlerResult.OK.getResult());
                } else {
                    handler.sendEmptyMessage(HandlerResult.ERROR.getResult());
                }
            }
        });
	}


	private Message messageToView(HandlerResult result) {
		Message msg = handler.obtainMessage();
		msg.what = result.getResult();
		return msg;
	}

	private Message getMessageWithObject(HandlerResult result, Object object) {
		Message msg = messageToView(result);
		msg.obj = object;
		return msg;
	}

	private void error(Exception e) {
		if (e.toString().equals(
				"com.parse.ParseRequest$ParseRequestException: username " + user.getEmail() + " already taken"))
			handler.sendEmptyMessage(HandlerResult.EMAIL_EXISTS.getResult());
		if (e.toString().equals("com.parse.ParseRequest$ParseRequestException: invalid email address"))
			handler.sendEmptyMessage(HandlerResult.WRONG_EMAIL.getResult());
	}

    private static void success() {
        handler.sendEmptyMessage(HandlerResult.OK.getResult());
    }

    private static void error() {
        handler.sendEmptyMessage(HandlerResult.ERROR.getResult());
    }

}

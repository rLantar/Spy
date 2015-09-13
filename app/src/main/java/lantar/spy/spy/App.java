package lantar.spy.spy;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseCrashReporting;
import com.parse.ParseInstallation;

/**
 * Created by Lantar on 07.09.2015.
 */
public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        ParseCrashReporting.enable(this);
        Parse.initialize(this, "dFEC4xOI0jvtDlCwpEcfoommqzco8L7Dv4O3vGdh", "w1FmwPCEpzOZmliz0ncgReTYsH3si4avBPOsbRkp");
        ParseInstallation.getCurrentInstallation().saveInBackground();

    }

}

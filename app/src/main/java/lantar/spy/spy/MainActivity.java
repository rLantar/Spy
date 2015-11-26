package lantar.spy.spy;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.parse.ParseUser;

import lantar.spy.R;
import lantar.spy.api.UserAPI;
import lantar.spy.entity.Route;
import lantar.spy.fragment.ReportsListFragment;
import lantar.spy.fragment.RoutsListFragment;
import lantar.spy.login.LoginActivity;
import lantar.spy.utils.Constants;


public class MainActivity extends ActionBarActivity
        implements NavigationDrawerFragment.NavigationDrawerCallbacks {

    /**
     * Fragment managing the behaviors, interactions and presentation of the navigation drawer.
     */
    private NavigationDrawerFragment mNavigationDrawerFragment;
    private static String routeName;
    private static int routeNumber;
    private static String reportId;
    private static String area;
    private static int annoncedCount;
    private static String BrigadirName;
    private static boolean cube;
    private static Route route = new Route();

    /**
     * Used to store the last screen title. For use in {@link #restoreActionBar()}.
     */
    private CharSequence mTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ParseUser.getCurrentUser().put("Version","1.5.0");
        ParseUser.getCurrentUser().saveInBackground();



        android.app.FragmentManager fm = getFragmentManager();
        android.app.Fragment fragment = fm.findFragmentById(R.id.fragment_container);
        if (fragment == null) {
            fragment = new RoutsListFragment();
            fm.beginTransaction()
                    .add(R.id.fragment_container, fragment)
                    .commit();
            fm.beginTransaction().isAddToBackStackAllowed();
        }

        mNavigationDrawerFragment = (NavigationDrawerFragment)
                getSupportFragmentManager().findFragmentById(R.id.navigation_drawer);
        mTitle = getTitle();

        // Set up the drawer.
        mNavigationDrawerFragment.setUp(
                R.id.navigation_drawer,
                (DrawerLayout) findViewById(R.id.drawer_layout));

    }

    @Override
    public void onNavigationDrawerItemSelected(int position) {

        getSupportActionBar().setTitle(ParseUser.getCurrentUser().getString(Constants.USER_FIO));

        // update the main content by replacing fragments
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.fragment_container, PlaceholderFragment.newInstance(position + 1))
                .commit();
    }

    public void onSectionAttached(int number) {

        android.app.FragmentManager fragmentManager = getFragmentManager();
        android.app.Fragment fragment = null;
        switch (number) {
            case 1:
                mTitle = getString(R.string.title_section1);
                fragment = new RoutsListFragment();
                break;
            case 2:
                mTitle = getString(R.string.title_section2);
                fragment = new ReportsListFragment();
                break;
            case 3:
                mTitle = getString(R.string.title_section3);
                UserAPI.logOut();
                Intent intent = new Intent(this, LoginActivity.class);
                startActivity(intent);
                finish();
                return;
        }
        fragmentManager.beginTransaction()
                .replace(R.id.fragment_container, fragment).commit();

    }




    public void restoreActionBar() {
        ActionBar actionBar = getSupportActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
        actionBar.setDisplayShowTitleEnabled(true);
        actionBar.setTitle(mTitle);
    }




    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            return rootView;
        }

        @Override
        public void onAttach(Activity activity) {
            super.onAttach(activity);
            ((MainActivity) activity).onSectionAttached(
                    getArguments().getInt(ARG_SECTION_NUMBER));
        }
    }

    public static String getRouteName() {
        return routeName;
    }

    public void onBackPressed() {
        Intent intent = new Intent();
        intent.setClass(this, MainActivity.class);
        intent.setAction(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        startActivity(intent);
        finish();


    }

//    @Override
//    public void onBackPressed() {
//
//        int count = getFragmentManager().getBackStackEntryCount();
//
//        if (count == 0) {
//            super.onBackPressed();
//
//        } else {
//            getFragmentManager().popBackStack();
//        }
//
//    }


    public static String getArea() {
        return area;
    }

    public static void setArea(String area) {
        MainActivity.area = area;
    }

    public static int getAnnoncedCount() {
        return annoncedCount;
    }

    public static void setAnnoncedCount(int annoncedCount) {
        MainActivity.annoncedCount = annoncedCount;
    }

    public static Route getRoute() {
        return route;
    }

    public static void setRoute(Route route) {
        route = route;
    }

    public static void setRouteName(String routeName) {
        MainActivity.routeName = routeName;
    }

    public static int getRouteNumber() {
        return routeNumber;
    }

    public static void setRouteNumber(int routeNumber) {
        MainActivity.routeNumber = routeNumber;
    }

    public static String getReportId() {
        return reportId;
    }

    public static void setReportId(String reportId) {
        MainActivity.reportId = reportId;
    }

    public static String getBrigadirName() {
        return BrigadirName;
    }

    public static void setBrigadirName(String brigadirName) {
        BrigadirName = brigadirName;
    }

    public static boolean isCube() {
        return cube;
    }

    public static void setCube(boolean cube) {
        MainActivity.cube = cube;
    }
}

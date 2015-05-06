package com.materialdesigndemo;

import android.app.job.JobScheduler;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;

import fragments.FragmentDrawer;


public class  MainActivity extends ActionBarActivity {


    private Toolbar toolbar;
    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;




    //int representing our 0th tab corresponding to the Fragment where search results are dispalyed
    public static final int TAB_SEARCH_RESULTS = 0;
    //int corresponding to our 1st tab corresponding to the Fragment where box office hits are dispalyed
    public static final int TAB_HITS = 1;
    //int corresponding to our 2nd tab corresponding to the Fragment where upcoming movies are displayed
    public static final int TAB_UPCOMING = 2;
    //int corresponding to the number of tabs in our Activity
    public static final int TAB_COUNT = 3;
    //int corresponding to the id of our JobSchedulerService
    private static final int JOB_ID = 100;
    //tag associated with the FAB menu button that sorts by name
    private static final String TAG_SORT_NAME = "sortName";
    //tag associated with the FAB menu button that sorts by date
    private static final String TAG_SORT_DATE = "sortDate";
    //tag associated with the FAB menu button that sorts by ratings
    private static final String TAG_SORT_RATINGS = "sortRatings";
    //Run the JobSchedulerService every 2 minutes
    private static final long POLL_FREQUENCY = 28800000;
    private JobScheduler mJobScheduler;
    private Toolbar mToolbar;
    //a layout grouping the toolbar and the tabs together
    private ViewGroup mContainerToolbar;
    private ViewPager mPager;

   private FragmentDrawer mDrawerFragment;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_screen_with_appbar);


       // setupFAB();
        //setupTabs();
        //setupJob();
       setupDrawer();


        /*toolbar= (Toolbar) findViewById(R.id.latestappbar);

        setSupportActionBar(toolbar);



        NavigationDrawerFragment drawerFragment=(NavigationDrawerFragment)
                getSupportFragmentManager().findFragmentById(R.id.fragment_navigation_drawer);

        drawerFragment.setup((DrawerLayout)findViewById(R.id.drawer_layout),toolbar);
*/
    }


    private void setupDrawer() {
        mToolbar = (Toolbar) findViewById(R.id.latestappbar);
        mContainerToolbar = (ViewGroup) findViewById(R.id.container_app_bar);
        //set the Toolbar as ActionBar
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        //setup the NavigationDrawer
        mDrawerFragment = (FragmentDrawer)
                getSupportFragmentManager().findFragmentById(R.id.fragment_navigation_drawer);
        mDrawerFragment.setUp(R.id.fragment_navigation_drawer, (DrawerLayout) findViewById(R.id.drawer_layout), mToolbar);
    }



 /*   public void onDrawerSlide(float slideOffset) {
        toggleTranslateFAB(slideOffset);
    }

    private void toggleTranslateFAB(float slideOffset) {
        if (mFABMenu != null) {
            if (mFABMenu.isOpen()) {
                mFABMenu.close(true);
            }
            mFAB.setTranslationX(slideOffset * 200);
        }
    }*/

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

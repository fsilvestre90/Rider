package filipesilvestre.rider;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import com.crashlytics.android.Crashlytics;
import com.ncapdevi.fragnav.FragNavController;
import filipesilvestre.rider.custom.SharedPref;
import filipesilvestre.rider.fragment.AlvinArrival;
import filipesilvestre.rider.fragment.BaseFragment;
import filipesilvestre.rider.fragment.JoelRequest;
import filipesilvestre.rider.fragment.CourtneyCancel;
import filipesilvestre.rider.fragment.MagsCancel;
import filipesilvestre.rider.fragment.OnlineSequence;
import filipesilvestre.rider.fragment.RiderArrive;
import filipesilvestre.rider.fragment.CourtneyOnTrip;
import filipesilvestre.rider.fragment.MagsOnTrip;
import filipesilvestre.rider.fragment.Settings;
import io.fabric.sdk.android.Fabric;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, BaseFragment.FragmentNavigation {

  private FragNavController mNavController;

  private final int ALVINARRIVAL = FragNavController.TAB1;
  private final int JOELREQUEST = FragNavController.TAB2;
  private final int COURTNEYCANCEL = FragNavController.TAB3;
  private final int MAGSCANCEL = FragNavController.TAB4;
  private final int RIDERARRIVE = FragNavController.TAB5;
  private final int COURTNEYONTRIP = 5;
  private final int MAGSONTRIP = 6;
  private final int ONLINEMAP = 7;
  private final int SETTINGS = 8;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    Fabric.with(this, new Crashlytics());
    setContentView(R.layout.activity_main);

    NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
    navigationView.setNavigationItemSelectedListener(this);

    List<Fragment> fragments = new ArrayList<>(5);

    fragments.add(AlvinArrival.newInstance(0));
    fragments.add(JoelRequest.newInstance(0));
    fragments.add(CourtneyCancel.newInstance(0));
    fragments.add(MagsCancel.newInstance(0));
    fragments.add(RiderArrive.newInstance(0));
    fragments.add(CourtneyOnTrip.newInstance(0));
    fragments.add(MagsOnTrip.newInstance(0));
    fragments.add(OnlineSequence.newInstance(0));
    fragments.add(Settings.newInstance(0));

    mNavController =
        new FragNavController(savedInstanceState, getSupportFragmentManager(), R.id.container, fragments, ALVINARRIVAL);
    mNavController.setTransitionMode(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
  }

  @Override
  public void onBackPressed() {
    DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
    if (drawer.isDrawerOpen(GravityCompat.START)) {
      drawer.closeDrawer(GravityCompat.START);
    }else if (mNavController.getCurrentStack().size() > 1) {
      mNavController.popFragment();
    } else {
      super.onBackPressed();
    }
  }

  @Override
  protected void onSaveInstanceState(Bundle outState) {
    super.onSaveInstanceState(outState);
    mNavController.onSaveInstanceState(outState);
  }

  @Override
  public boolean onNavigationItemSelected(MenuItem item) {
    switch (item.getItemId()) {
      case R.id.menu1:
        mNavController.switchTab(ALVINARRIVAL);
        break;
      case R.id.menu2:
        mNavController.switchTab(JOELREQUEST);
        break;
      case R.id.menu3:
        mNavController.switchTab(COURTNEYCANCEL);
        break;
      case R.id.menu4:
        mNavController.switchTab(MAGSCANCEL);
        break;
      case R.id.menu5:
        mNavController.switchTab(COURTNEYONTRIP);
        break;
      case R.id.menu6:
        mNavController.switchTab(MAGSONTRIP);
        break;
      case R.id.menu7:
        mNavController.switchTab(RIDERARRIVE);
        break;
      case R.id.menu8:
        mNavController.switchTab(ONLINEMAP);
        break;
      case R.id.menu9:
        mNavController.switchTab(SETTINGS);
        break;
    }
    DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
    drawer.closeDrawer(GravityCompat.START);
    return true;
  }

  @Override
  public void pushFragment(Fragment fragment) {
    mNavController.pushFragment(fragment);
  }

}
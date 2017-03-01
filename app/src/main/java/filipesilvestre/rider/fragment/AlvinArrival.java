package filipesilvestre.rider.fragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import filipesilvestre.rider.MainActivity;
import filipesilvestre.rider.R;
import filipesilvestre.rider.custom.SharedPref;

public class AlvinArrival extends Fragment {

  @BindView(R.id.sequence1_tv) TextView textView;
  @BindView(R.id.anim_button) ImageButton btn;

  private View cachedView;
  private SharedPreferences preferences;

  public static AlvinArrival newInstance(int index) {
    Bundle args = new Bundle();
    AlvinArrival fragment = new AlvinArrival();
    fragment.setArguments(args);
    return fragment;
  }

  @Override public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    if (cachedView == null) {
      cachedView = inflater.inflate(R.layout.sequence1, container, false);
      ButterKnife.bind(this, cachedView);

    }

    return cachedView;
  }

  @Override
  public void onResume() {
    super.onResume();
    this.preferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
    startAnimation();
  }

  private void startAnimation() {
    int seconds = preferences.getInt("ALVIN", 5);

    new Handler().postDelayed(new Runnable() {
      @Override
      public void run() {
        textView.setVisibility(View.VISIBLE);
      }
    }, seconds * 1000); // For 10 seconds
  }


  @OnClick(R.id.anim_button) public void startAnim() {
    textView.setVisibility(View.INVISIBLE);
    startAnimation();
  }
}

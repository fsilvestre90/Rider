package filipesilvestre.rider.fragment;

import android.animation.ObjectAnimator;
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
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import filipesilvestre.rider.MainActivity;
import filipesilvestre.rider.R;
import filipesilvestre.rider.custom.SharedPref;
import filipesilvestre.rider.custom.TypeWriter;

public class JoelRequest extends Fragment implements Animation.AnimationListener {

  @BindView(R.id.seq2_image1) ImageView img1;
  @BindView(R.id.seq2_image2) ImageView img2;
  @BindView(R.id.rider_icon) ImageView mIcon;
  @BindView(R.id.tagline_typewriter) TypeWriter mTw;

  private View cachedView;
  private AnimationSet set;
  private SharedPreferences preferences;

  public static JoelRequest newInstance(int index) {
    Bundle args = new Bundle();
    JoelRequest fragment = new JoelRequest();
    fragment.setArguments(args);
    return fragment;
  }



  @Override public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    if (cachedView == null) {
      cachedView = inflater.inflate(R.layout.sequence2, container, false);
      ButterKnife.bind(this, cachedView);
    }

    return cachedView;
  }

  @Override
  public void onResume() {
    super.onResume();
    this.preferences = PreferenceManager.getDefaultSharedPreferences(getActivity());

    this.set = new AnimationSet(true);
    Animation pulse = AnimationUtils.loadAnimation(getContext(), R.anim.pulse);
    pulse.setAnimationListener(this);
    pulse.setDuration(1500);
    AccelerateDecelerateInterpolator interpolator = new AccelerateDecelerateInterpolator();
    interpolator.getInterpolation(15f);
    pulse.setInterpolator(new AccelerateDecelerateInterpolator());
    pulse.setRepeatCount(ObjectAnimator.INFINITE);
    pulse.setRepeatMode(ObjectAnimator.REVERSE);

    AlphaAnimation blinkanimation = new AlphaAnimation(1f, .35f); // Change alpha from fully visible to partially
    blinkanimation.setDuration(1500);
    blinkanimation.setInterpolator(new LinearInterpolator()); // do not alter animation rate
    blinkanimation.setRepeatCount(ObjectAnimator.INFINITE); // Repeat animation infinitely
    blinkanimation.setRepeatMode(Animation.REVERSE);

    set.addAnimation(pulse);
    set.addAnimation(blinkanimation);

    startAnimation(set);
  }
  private void startAnimation(final AnimationSet set) {
    int seconds = preferences.getInt("JOEL", 5);

    new Handler().postDelayed(new Runnable() {
      @Override
      public void run() {
        img1.setVisibility(View.GONE);
        img2.setVisibility(View.VISIBLE);
        mIcon.setVisibility(View.VISIBLE);
        mTw.setVisibility(View.VISIBLE);

        mTw.setCharacterDelay(50);
        mTw.animateText("JOEL HAS REQUESTED A RIDE...");
        mIcon.setAnimation(set);

      }
    }, seconds * 1000);
  }

  @OnClick(R.id.rider_icon) public void reset() {
    img1.setVisibility(View.VISIBLE);
    img2.setVisibility(View.GONE);
    mIcon.setVisibility(View.GONE);
    mTw.setVisibility(View.GONE);

    mIcon.clearAnimation();
    mTw.setText("");

    startAnimation(set);
  }

  @Override public void onAnimationStart(Animation animation) {


  }

  @Override public void onAnimationEnd(Animation animation) {


  }

  @Override public void onAnimationRepeat(Animation animation) {

  }
}

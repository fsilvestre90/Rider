package filipesilvestre.rider.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import filipesilvestre.rider.R;

/**
 * Created by filipesilvestre on 2/19/17.
 */

public class MagsOnTrip extends BaseFragment {

  private View cachedView;

  public static MagsOnTrip newInstance(int index) {
    Bundle args = new Bundle();
    MagsOnTrip fragment = new MagsOnTrip();
    fragment.setArguments(args);
    return fragment;
  }

  @Override public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    if (cachedView == null) {
      cachedView = inflater.inflate(R.layout.sequence_ontrip_mags, container, false);
    }

    return cachedView;
  }
}

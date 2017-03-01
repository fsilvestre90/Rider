package filipesilvestre.rider.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import filipesilvestre.rider.R;

public class RiderArrive extends BaseFragment {

  private View cachedView;

  public static RiderArrive newInstance(int index) {
    Bundle args = new Bundle();
    RiderArrive fragment = new RiderArrive();
    fragment.setArguments(args);
    return fragment;
  }

  @Override public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    if (cachedView == null) {
      cachedView = inflater.inflate(R.layout.sequence4, container, false);
    }

    return cachedView;
  }
}

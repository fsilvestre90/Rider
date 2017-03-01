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

public class OnlineSequence extends BaseFragment {

  private View cachedView;

  public static OnlineSequence newInstance(int index) {
    Bundle args = new Bundle();
    OnlineSequence fragment = new OnlineSequence();
    fragment.setArguments(args);
    return fragment;
  }

  @Override public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    if (cachedView == null) {
      cachedView = inflater.inflate(R.layout.sequence_online, container, false);
    }

    return cachedView;
  }
}

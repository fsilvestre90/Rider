package filipesilvestre.rider.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.ButterKnife;
import filipesilvestre.rider.R;

public class CourtneyCancel extends Fragment {
  private View cachedView;

  public static CourtneyCancel newInstance(int index) {
    Bundle args = new Bundle();
    CourtneyCancel fragment = new CourtneyCancel();
    fragment.setArguments(args);
    return fragment;
  }

  @Override public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    if (cachedView == null) {
      cachedView = inflater.inflate(R.layout.sequence3courtney, container, false);
      ButterKnife.bind(this, cachedView);

    }

    return cachedView;
  }
}

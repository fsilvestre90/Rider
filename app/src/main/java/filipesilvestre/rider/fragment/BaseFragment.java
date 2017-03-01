package filipesilvestre.rider.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;

public abstract class BaseFragment extends Fragment {
  public static final String ARGS_INSTANCE = "argsInstance";
  private FragmentNavigation mFragmentNavigation;
  private int fragmentIndex;

  @Override public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    Bundle args = getArguments();
    if (args != null) {
      fragmentIndex = args.getInt(ARGS_INSTANCE);
    }

    // Keeps this Fragment alive during configuration changes
    setRetainInstance(true);
  }

  @Override public void onAttach(Context context) {
    super.onAttach(context);
    if (context instanceof FragmentNavigation) {
      mFragmentNavigation = (FragmentNavigation) context;
    }
  }

  public int getFragmentIndex() {
    return fragmentIndex;
  }

  public interface FragmentNavigation {
    void pushFragment(Fragment fragment);
  }
}
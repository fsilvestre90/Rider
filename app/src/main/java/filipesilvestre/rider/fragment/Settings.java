package filipesilvestre.rider.fragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import filipesilvestre.rider.MainActivity;
import filipesilvestre.rider.R;
import filipesilvestre.rider.custom.SharedPref;

public class Settings extends Fragment {

  @BindView(R.id.seq1_edit_text) EditText mSeq1;
  @BindView(R.id.seq2_edit_text) EditText mSeq2;
  @BindView(R.id.save_btn) Button mSave;

  private View cachedView;

  public static Settings newInstance(int index) {
    Bundle args = new Bundle();
    Settings fragment = new Settings();
    fragment.setArguments(args);
    return fragment;
  }

  @Override public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    if (cachedView == null) {
      cachedView = inflater.inflate(R.layout.settings, container, false);
      ButterKnife.bind(this, cachedView);
    }

    return cachedView;
  }

  @OnClick(R.id.save_btn) public void save() {
    SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
    SharedPreferences.Editor editor = preferences.edit();
    View view = getActivity().getCurrentFocus();

    editor.putInt("ALVIN", Integer.parseInt(mSeq1.getText().toString()));
    editor.putInt("JOEL", Integer.parseInt(mSeq2.getText().toString()));
    editor.apply();
    editor.commit();

    if (view != null) {
      InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
      imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    Toast.makeText(getActivity(), "Saved settings", Toast.LENGTH_SHORT).show();
  }

}
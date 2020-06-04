package com.sunwellsystem.stonefire;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatDialog;
import android.support.v7.app.AppCompatDialogFragment;
import android.app.ProgressDialog;

/**
 * Created by sunwell on 10/3/17.
 */

public class ProgressDialogFragment extends AppCompatDialogFragment {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        ProgressDialog _dialog = new ProgressDialog(getActivity());
        this.setStyle(STYLE_NO_TITLE, getTheme()); // You can use styles or inflate a view
        _dialog.setMessage("Loading.."); // set your messages if not inflated from XML
//        _dialog.setCancelable(false);
        return _dialog;
    }

}

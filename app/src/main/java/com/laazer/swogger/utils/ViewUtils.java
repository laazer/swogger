package com.laazer.swogger.utils;

import android.app.AlertDialog;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;

import com.laazer.swogger.R;

/**
 * Created by Laazer.
 */
public class ViewUtils {

    public final static void simpleAlertDialog(Context context, String text) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setMessage(text);
        builder.setCancelable(false);
        builder.setPositiveButton(R.string.ok_label,
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        // nothing
                    }
                });
        builder.show();
    }

    public final static void simpleFragmentStart(FragmentManager manager, int replacementFrame,
                                                 Fragment fragment, Bundle bundle) {
        FragmentTransaction ft = manager.beginTransaction();
        ft.replace(replacementFrame, fragment);
        if(bundle != null) fragment.setArguments(bundle);
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        ft.addToBackStack(null);
        ft.commit();
    }

    public final static void simpleFragmentStart(FragmentManager manager, int replacementFrame,
                                                 Fragment fragment) {
        simpleFragmentStart(manager, replacementFrame, fragment, null);
    }
}

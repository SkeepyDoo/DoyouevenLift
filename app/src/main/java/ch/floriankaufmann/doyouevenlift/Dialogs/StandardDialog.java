package ch.floriankaufmann.doyouevenlift.Dialogs;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;

import ch.floriankaufmann.doyouevenlift.MainActivity;
import ch.floriankaufmann.doyouevenlift.R;

public class StandardDialog extends DialogFragment {
    Context mContext;

    @Override
    public void onAttach(Context context) {
        mContext = context;
        super.onAttach(context);
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the Builder class for convenient dialog construction
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Delete everything")
                .setMessage("Do you really want to delete all your data for ever?")
                .setNegativeButton("No, thanks", null)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        ((MainActivity)mContext).clearList();
                    }
                });


        // Create the AlertDialog object and return it
        return builder.create();
    }
}

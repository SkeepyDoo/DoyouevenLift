package ch.floriankaufmann.doyouevenlift.Dialogs;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import ch.floriankaufmann.doyouevenlift.MainActivity;
import ch.floriankaufmann.doyouevenlift.R;
import ch.floriankaufmann.doyouevenlift.model.Exercise;

public class FloatingActionDialogFragment extends DialogFragment {
    Context mContext;

    @Override
    public void onAttach(Context context) {
        mContext = context;
        super.onAttach(context);
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        LayoutInflater inflater = getActivity().getLayoutInflater();
        Context context = getActivity();
        AlertDialog.Builder builder = new AlertDialog.Builder(context)
                .setTitle("Add Exercise")
                .setView(inflater.inflate(R.layout.dialog_add_exercise, null))
                .setNegativeButton("Cancel", null)
                .setPositiveButton("Save", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        ((MainActivity)mContext).addItem(
                                ((MainActivity)mContext).getExerciseName(),
                                ((MainActivity)mContext).getLiftedWeight()); // TO-DO fix this method
                    }
                });

        AlertDialog dialog = builder.create();
        return dialog;
    }
}

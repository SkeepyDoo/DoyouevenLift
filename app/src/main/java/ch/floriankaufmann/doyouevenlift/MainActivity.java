package ch.floriankaufmann.doyouevenlift;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import ch.floriankaufmann.doyouevenlift.Adapters.MyAdapter;
import ch.floriankaufmann.doyouevenlift.Dialogs.EditExerciseDialog;
import ch.floriankaufmann.doyouevenlift.Dialogs.FloatingActionDialogFragment;
import ch.floriankaufmann.doyouevenlift.Dialogs.StandardDialog;
import ch.floriankaufmann.doyouevenlift.model.Exercise;

public class MainActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private android.support.v7.widget.Toolbar toolbar;
    public List mResult;
    public int lengthOfRv = 2; //number of fake data items

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle("Do you even Lift");

        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view); // set RV
        mRecyclerView.setHasFixedSize(true); //items don't change size = true
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new MyAdapter(createList(lengthOfRv));
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    protected void onPause () {
        super.onPause();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    public void showStandardDialog(MenuItem item) {
        StandardDialog dialog = new StandardDialog();
        dialog.show(getFragmentManager(), "dialog");
    }

    public void showAddExerciseDialog(View view) {
        FloatingActionDialogFragment dialog = new FloatingActionDialogFragment();
        dialog.show(getFragmentManager(), "dialog");
    }

    public void showEditExerciseDialog(View view) {
        EditExerciseDialog dialog = new EditExerciseDialog();
        dialog.show(getFragmentManager(), "dialog");
    }

    public void clearList() {
        mResult.clear();
        mAdapter.notifyDataSetChanged();
    }

    /**
     * adds an item to the recycler view
     */
    public void addItem(String name, double lifted) {
        Exercise ex = new Exercise();
        ex.exerciseName = name;
        ex.lifted = lifted;
        mResult.add(ex);
        mAdapter.notifyDataSetChanged();
    }

    public String getExerciseName() {
        EditText editText = (EditText) findViewById(R.id.exercise_name_edit_text);
        String client = null;
        if (editText != null) {
            client = editText.getText().toString();
            Log.d("tag", "client is " + client);
        }
        return client;
    }

    public double getLiftedWeight() {
        EditText editText = (EditText) findViewById(R.id.lifted_edit_text);
        double client = 0;
        if (editText != null) {
            client = Double.parseDouble(editText.getText().toString());
            Log.d("tag", "client is " + client);
        }

        return client;
    }


    /**
     * Produce some fake data
     */

    public List createList(int size) {

        mResult = new ArrayList();

        for (int i = 0; i <= lengthOfRv; i++) {
            Exercise ex = new Exercise();
            ex.exerciseName = "Something";
            ex.lifted = 100;

            mResult.add(ex);
        }

        return mResult;
    }
}

package ch.floriankaufmann.doyouevenlift.Adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import ch.floriankaufmann.doyouevenlift.MainActivity;
import ch.floriankaufmann.doyouevenlift.model.Exercise;
import ch.floriankaufmann.doyouevenlift.R;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ContactViewHolder> {

    // Initalization for a List of Objects
    private List<Exercise> mExerciseList;

    public MyAdapter(List<Exercise> exerciseList) {
        mExerciseList = exerciseList;
    }

    // gets the size of the List of Objects
    @Override
    public int getItemCount() {
        return mExerciseList.size();
    }

    //sets the Text of the Recycler View item to an certain value from the Constructor class
    @Override
    public void onBindViewHolder(ContactViewHolder contactViewHolder, int i) {
        Exercise ex = mExerciseList.get(i);
        contactViewHolder.mExerciseName.setText(ex.exerciseName);
        contactViewHolder.mLifted.setText(ex.lifted + ""); // is an int

    }

    // set the layout to something and creates the View Holder
    @Override
    public ContactViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.
                from(viewGroup.getContext()).
                inflate(R.layout.my_text_view, viewGroup, false);

        return new ContactViewHolder(itemView);
    }

    public static class ContactViewHolder extends RecyclerView.ViewHolder {
        // Initialization of the Views
        protected TextView mExerciseName;
        protected TextView mLifted;

        public ContactViewHolder(View v) {
            super(v);
            // Set the views to a certain value
            mExerciseName = (TextView) v.findViewById(R.id.exercise_name);
            mLifted = (TextView) v.findViewById(R.id.lifted);
        }
    }
}

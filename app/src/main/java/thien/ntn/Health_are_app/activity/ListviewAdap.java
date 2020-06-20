package thien.ntn.Health_are_app.activity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import thien.ntn.myapplication.R;

public class ListviewAdap extends ArrayAdapter<ListviewContent> implements View.OnClickListener {

    private ArrayList<ListviewContent> stepTripData;
    Context mContext;

    // View lookup cache
    private static class ViewHolder {
        TextView txtrecordedTime;
        TextView txtstepsTaken;
        TextView txtdistance;
        TextView txttimeTaken;
    }

    public ListviewAdap(ArrayList<ListviewContent> data, Context context) {
        super(context, R.layout.row_view, data);
        this.stepTripData = data;
        this.mContext = context;
    }

    @Override
    public void onClick(View v) {

    }

    private int lastPosition = -1;

    @Override
    public View getView(int position, View newView, ViewGroup parent) {

        // Get the data item position
        ListviewContent listviewContent = getItem(position);

        // Existing view is being reused ???
        ViewHolder viewHolder;

        final View result;

        if (newView == null) {

            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            newView = inflater.inflate(R.layout.row_view, parent, false);
            viewHolder.txtrecordedTime = (TextView) newView.findViewById(R.id.recordedTime);
            viewHolder.txtstepsTaken = (TextView) newView.findViewById(R.id.stepsTaken);
            viewHolder.txtdistance = (TextView) newView.findViewById(R.id.distance);
            viewHolder.txttimeTaken = (TextView) newView.findViewById(R.id.timeTaken);

            result = newView;

            newView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) newView.getTag();
            result = newView;
        }

        lastPosition = position;

        viewHolder.txtrecordedTime.setText(listviewContent.getRecordedTime());
        viewHolder.txtstepsTaken.setText(listviewContent.getStepsTaken());
        viewHolder.txtdistance.setText(listviewContent.getDistance());
        viewHolder.txttimeTaken.setText(listviewContent.getTimeTaken());

        return newView;
    }
}

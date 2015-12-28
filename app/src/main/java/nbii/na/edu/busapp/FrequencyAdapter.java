package nbii.na.edu.busapp;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import nbii.na.edu.busapp.Model.Frequency;

/**
 * Created by namibia on 29/11/15.
 */
public class FrequencyAdapter<F> extends ArrayAdapter<Frequency> {

    Context context;
    int layoutResourceId;
    ArrayList<Frequency> frequencies;

    public FrequencyAdapter(Context context, int layoutResourceId, ArrayList<Frequency> frequencies) {
        super(context, layoutResourceId, frequencies);
        this.layoutResourceId = layoutResourceId;
        this.context = context;
        this.frequencies = frequencies;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        FrequencyHolder holder = null;

        if(row == null)
        {
            LayoutInflater inflater = LayoutInflater.from(context);
            row = inflater.inflate(layoutResourceId, parent, false);

            holder = new FrequencyHolder();
            holder.id = (TextView)row.findViewById(R.id.busno);
            holder.time = (TextView)row.findViewById(R.id.duration);

            row.setTag(holder);
        }
        else
        {
            holder = (FrequencyHolder)row.getTag();
        }

        Frequency frequency = this.frequencies.get(position);
        Resources res = this.context.getResources();
        holder.id.setText( frequency.getId());
        holder.time.setText(frequency.getTime());

        return row;
    }

    static class FrequencyHolder
    {
        TextView id;
        TextView time;

    }

}

package net.unibave.listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public abstract class TwoLineArrayAdapter<T> extends ArrayAdapter<T> {

    private int layout;

    public TwoLineArrayAdapter(Context context, List<T> list) {
        this(context, android.R.layout.two_line_list_item, list);
    }

    public TwoLineArrayAdapter(Context context, int layout, List<T> list) {
        super(context, layout, list);
        this.layout = layout;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (null == convertView) {
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(layout, parent, false);
        }

        TextView lineOneView = (TextView) view.findViewById(android.R.id.text1);
        TextView lineTwoView = (TextView) view.findViewById(android.R.id.text2);

        T t = getItem(position);
        lineOneView.setText(lineOneText(t));
        lineTwoView.setText(lineTwoText(t));

        return view;
    }

    public abstract String lineOneText(T t);

    public abstract String lineTwoText(T t);

}
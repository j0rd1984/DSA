package edu.upc.eetac.dsa.listapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Jordi on 11/11/2015.
 */
public class ExampleDataAdapter  extends BaseAdapter {
    private ArrayList<ExampleData> data;
    private LayoutInflater layoutInflater;

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.list_row_example_data, null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        String mainText = data.get(position).getMainText();
        String leftText = data.get(position).getLeftText();
        String rightText = data.get(position).getRightText();

        viewHolder.textViewMainText.setText(mainText);
        viewHolder.textViewLeftText.setText(leftText);
        viewHolder.textViewRightText.setText(rightText);
        return convertView;
    }

    public ExampleDataAdapter(Context context, ArrayList<ExampleData> data) {
        super();
        layoutInflater = LayoutInflater.from(context);
        this.data = data;
    }

    class ViewHolder{
        TextView textViewMainText;
        TextView textViewLeftText;
        TextView textViewRightText;

        ViewHolder(View row){
            this.textViewMainText = (TextView) row
                    .findViewById(R.id.textViewMainText);
            this.textViewLeftText = (TextView) row
                    .findViewById(R.id.textViewLeftText);
            this.textViewRightText = (TextView) row
                    .findViewById(R.id.textViewRightText);
        }
    }



}
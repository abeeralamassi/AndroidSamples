package iterator.ir.a042;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by mahmood on 3/9/17.
 */

public class CustomAdapter extends BaseExpandableListAdapter {

    private Context context;
    private ArrayList<HeaderInfo> cInfo;

    public CustomAdapter(Context context,ArrayList<HeaderInfo> cInfo)
    {
        this.context=context;
        this.cInfo=cInfo;
    }

    @Override
    public int getGroupCount() {
        return cInfo.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return cInfo.get(groupPosition).getCities().size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return cInfo.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return cInfo.get(groupPosition).getCities().get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {

        View view=convertView;

        if (view==null)
        {
            LayoutInflater layoutInflater=LayoutInflater.from(context);
            view=layoutInflater.inflate(R.layout.header_layout,parent,false);
        }

        HeaderInfo current=this.cInfo.get(groupPosition);

        if (current!=null)
        {
            TextView textViewProvinceName= (TextView) view.findViewById(R.id.textViewProvinceName);
            TextView textViewProvincePopulation= (TextView) view.findViewById(R.id.textViewProvincePopulation);

            textViewProvinceName.setText(current.getProvoniceName());
            textViewProvincePopulation.setText(String.valueOf(current.getPopulation()));
        }

        return view;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        View view=convertView;

        if (view==null)
        {
            LayoutInflater layoutInflater=LayoutInflater.from(context);
            view=layoutInflater.inflate(R.layout.detail_layout,parent,false);
        }

        DetailInfo current=this.cInfo.get(groupPosition).getCities().get(childPosition);

        if (current!=null)
        {
            TextView textViewCityName= (TextView) view.findViewById(R.id.textViewCityName);
            TextView textViewCityPopulation= (TextView) view.findViewById(R.id.textViewCityPopulation);

            textViewCityName.setText(current.getCityName());
            textViewCityPopulation.setText(String.valueOf(current.getPopulation()));
        }

        return view;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}

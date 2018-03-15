package com.example.sahil.requirement;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by sahil on 13/3/18.
 */

public class Requirement_list extends ArrayAdapter<RequirementDescription> {

    private Activity context;
    private List<RequirementDescription> requirementDescriptionList;

    public Requirement_list(Activity context, List<RequirementDescription> requirementDescriptionList) {

        super(context, R.layout.list_layout,requirementDescriptionList);
        this.context = context;
        this.requirementDescriptionList = requirementDescriptionList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();

        View listViewItem = inflater.inflate(R.layout.list_layout,null,true);

        TextView textname = (TextView) listViewItem.findViewById(R.id.text_name);
        TextView textDescription = (TextView) listViewItem.findViewById(R.id.text_description);

        RequirementDescription requirementDescription = requirementDescriptionList.get(position);

        textname.setText(requirementDescription.getSanstha());
        textDescription.setText(requirementDescription.getRequirementdescription());

        return listViewItem;
    }
}

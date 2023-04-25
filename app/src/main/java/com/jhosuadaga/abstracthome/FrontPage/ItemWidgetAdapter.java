package com.jhosuadaga.abstracthome.FrontPage;

import static android.view.View.inflate;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.jhosuadaga.abstracthome.R;
import com.jhosuadaga.abstracthome.WidgetObject.WidgetObject;

import org.w3c.dom.Text;

import java.util.List;

public class ItemWidgetAdapter extends ArrayAdapter<WidgetObject> {

    private List<WidgetObject> widgetObjects;
    private final int resource;

    public ItemWidgetAdapter(@NonNull Context context, int resource, @NonNull List<WidgetObject> objects) {
        super(context, resource, objects);
        this.widgetObjects = objects;
        this.resource = resource;
    }

    public void addWidget(WidgetObject widgetObject) {
        widgetObjects.add(widgetObject);
    }

    public void removeWidget(WidgetObject widgetObject) {
        widgetObjects.remove(widgetObject);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = inflate(getContext(), resource, null);

        TextView textView = view.findViewById(R.id.widget_name);
        ImageView imageView = view.findViewById(R.id.widget_icon);

        textView.setText(widgetObjects.get(position).getName());
        imageView.setImageResource(widgetObjects.get(position).getIcon());

        return view;
    }
}
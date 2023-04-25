package com.jhosuadaga.abstracthome.FrontPage;

import static android.graphics.Color.WHITE;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.DragEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.jhosuadaga.abstracthome.R;
import com.jhosuadaga.abstracthome.WidgetObject.WidgetObject;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class FrontPage extends Fragment {
    private GridLayout gridLayout;
    private ItemWidgetAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_front_page, container, false);
        gridLayout = view.findViewById(R.id.front_page_grid);

        final List<WidgetObject> widgetObjects = new ArrayList<>();

        addWidget(widgetObjects);
        addWidget(widgetObjects);

        adapter = new ItemWidgetAdapter(requireContext(), R.layout.widget_main, widgetObjects);

        for (int i = 0; i < adapter.getCount(); i++) {
            View view1 = LayoutInflater.from(requireContext()).inflate(R.layout.widget_main, gridLayout, false);
            TextView textView = view1.findViewById(R.id.widget_name);
            ImageView imageView = view1.findViewById(R.id.widget_icon);
            textView.setText(adapter.getItem(i).getName());
            imageView.setImageResource(adapter.getItem(i).getIcon());
            // Ability to resize widget
            // resizeWidget(view1);
            gridLayout.addView(view1);
        }

        return view;
    }

    public void resizeWidget(View viewWidget) {

        // Resize widget
        viewWidget.setOnTouchListener(new View.OnTouchListener() {
            private float lastX, lastY;
            int minWidth = 100, minHeight = 100;

            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {

                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        lastX = motionEvent.getX();
                        lastY = motionEvent.getY();
                        break;
                    case MotionEvent.ACTION_MOVE:
                        Toast.makeText(getContext(), "Touch MOVE", Toast.LENGTH_SHORT).show();

                        float deltaX = motionEvent.getRawX() - lastX;
                        float deltaY = motionEvent.getRawY() - lastY;

                        int newWidth = (int) (viewWidget.getWidth() + deltaX);
                        int newHeight = (int) (viewWidget.getHeight() + deltaY);

                        if (newWidth < minWidth) {
                            newWidth = minWidth;
                        } else if (newHeight < minHeight) {
                            newHeight = minHeight;
                        }

                        ViewGroup.LayoutParams params = viewWidget.getLayoutParams();
                        params.width = newWidth;
                        params.height = newHeight;
                        viewWidget.setLayoutParams(params);

                        lastX = motionEvent.getRawX();
                        lastY = motionEvent.getRawY();
                        break;
                }
                return true;
            }
        });
    }

    public void updateArrayAdapter() {
        adapter.clear();
        for (int i = 0; i < gridLayout.getChildCount(); i++) {
            View view2 = gridLayout.getChildAt(i);
            TextView textView = view2.findViewById(R.id.widget_name);
            ImageView imageView = view2.findViewById(R.id.widget_icon);
            adapter.addWidget(new WidgetObject(textView.getText().toString(),
                    imageView.getId(),
                    1,
                    1,
                    1,
                    1,
                    1));
        }
    }

    public void addWidget(List<WidgetObject> widgetObjects) {
        widgetObjects.add(new WidgetObject("App 2",
                R.drawable.ic_android_black_24dp,
                1,
                1,
                1,
                1,
                1));
    }

}
package com.jhosuadaga.abstracthome.AllApps;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ListAdapter;

import com.jhosuadaga.abstracthome.R;

import java.util.List;

public class AllApps extends Fragment {
    private ListAdapter adapter;
    private GridView gridView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_all_apps, container, false);

        adapter = new AllAppsAdapter(view.getContext().getApplicationContext(), R.layout.button_app, listApps(view));
        gridView = view.findViewById(R.id.all_apps_grid);
        gridView.setAdapter(adapter);
        return view;
    }

    private List<ResolveInfo> listApps(View view){
        Intent intent = new Intent(Intent.ACTION_MAIN, null);
        intent.addCategory(Intent.CATEGORY_LAUNCHER);
        return view.getContext().getPackageManager().queryIntentActivities(intent, 0);
    }
}
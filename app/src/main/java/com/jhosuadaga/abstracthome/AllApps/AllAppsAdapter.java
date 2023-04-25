package com.jhosuadaga.abstracthome.AllApps;

import static android.view.View.*;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.jhosuadaga.abstracthome.R;

import java.util.List;

public class AllAppsAdapter extends ArrayAdapter<ResolveInfo> {
    private Context context;
    private final int resource;
    private List<ResolveInfo> resolveInfos;

    public AllAppsAdapter(@NonNull Context context, int resource, @NonNull List<ResolveInfo> resolveInfos) {
        super(context, resource, resolveInfos);
        this.context = context;
        this.resource = resource;
        this.resolveInfos = resolveInfos;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = inflate(context, resource, null);

        TextView textView = view.findViewById(R.id.app_name);
        ImageView imageView = view.findViewById(R.id.app_icon);
        LinearLayout linearLayout = view.findViewById(R.id.button_app);

        imageView.setBackground(resolveInfos.get(position).loadIcon(context.getPackageManager()));
        textView.setText(resolveInfos.get(position).loadLabel(context.getPackageManager()));
        linearLayout.setOnClickListener(v -> {
            // Open the app
            try{
                Intent intent = context.getPackageManager().getLaunchIntentForPackage(resolveInfos.get(position).activityInfo.packageName);
                context.startActivity(intent);
            } catch (Exception e) {
                Toast.makeText(context, "Error to launch app." , Toast.LENGTH_SHORT).show();
                e.printStackTrace();
            }
        });

        linearLayout.setOnLongClickListener(v -> {
            // Uninstall the app
            try{
                Intent some = new Intent(Intent.ACTION_DELETE, Uri.parse("package:" + resolveInfos.get(position).activityInfo.packageName));
                context.startActivity(some);
            } catch (Exception e) {
                Toast.makeText(context, "Error to uninstall app." , Toast.LENGTH_SHORT).show();
                e.printStackTrace();
            }
            return true;
        });

        return view;
    }
}

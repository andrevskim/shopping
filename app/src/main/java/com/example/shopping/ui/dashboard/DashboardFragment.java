package com.example.shopping.ui.dashboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.shopping.App;
import com.example.shopping.R;
import com.example.shopping.db.AppDB;
import com.example.shopping.db.entity.ProductEntity;
import com.example.shopping.ui.CustomAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class DashboardFragment extends Fragment {

    private DashboardViewModel dashboardViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
            ViewGroup container, Bundle savedInstanceState) {
        dashboardViewModel =
                ViewModelProviders.of(this).get(DashboardViewModel.class);
        View root = inflater.inflate(R.layout.fragment_dashboard, container, false);

        AppDB db = ((App) getActivity().getApplication()).getDatabase();
        List<ProductEntity> productEntities = db.productDao().getPassive();
        ListView pasiveList;

        pasiveList = (ListView) root.findViewById(R.id.pasivelist);

        CustomAdapter adapter = new CustomAdapter(requireContext(), productEntities,db);

        FloatingActionButton deletelist = (FloatingActionButton) root.findViewById(R.id.deleteList);
        deletelist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db.productDao().deletePassive();
                adapter.notifyDataSetChanged();
                adapter.clear();


            }});


        pasiveList.setAdapter(adapter);
        pasiveList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                ProductEntity productEntity = productEntities.get(position);
                adapter.notifyDataSetChanged();

//                Snackbar.make(view, productEntities.getName()+"\n"+" API: "+dataModel.getVersion_number(), Snackbar.LENGTH_LONG)
//                        .setAction("No action", null).show();
            }
        });
//        final TextView textView = root.findViewById(R.id.text_dashboard);
//        dashboardViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
//            @Override
//            public void onChanged(@Nullable String s) {
//                textView.setText(s);
//            }
//        });

        return root;
    }
}

package com.example.shopping.ui.home;

import android.content.DialogInterface;
import android.os.Bundle;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.shopping.App;
import com.example.shopping.R;
import com.example.shopping.db.AppDB;
import com.example.shopping.db.entity.ProductEntity;
import com.example.shopping.ui.CustomAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);


        AppDB db = ((App) getActivity().getApplication()).getDatabase();
        List<ProductEntity> productEntities = db.productDao().getAll();
        ListView listView;

        listView = (ListView) root.findViewById(R.id.list);

        CustomAdapter adapter = new CustomAdapter(requireContext(), productEntities);

        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                ProductEntity productEntity = productEntities.get(position);

//                Snackbar.make(view, productEntities.getName()+"\n"+" API: "+dataModel.getVersion_number(), Snackbar.LENGTH_LONG)
//                        .setAction("No action", null).show();
            }
        });


        FloatingActionButton addlist = (FloatingActionButton) root.findViewById(R.id.plusButton);
        addlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final AlertDialog.Builder builder = new AlertDialog.Builder(requireContext());
                builder.setTitle("Нов продукт");

                final EditText input = new EditText(requireContext());
                input.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_NORMAL);
                builder.setView(input);

                builder.setPositiveButton("Внеси", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {


                        String m_Text = input.getText().toString();
                        String m_Status = "Активен";
                        ProductEntity product = new ProductEntity();
                        product.product = m_Text;
                        product.status = m_Status;
                        productEntities.add(product);
                        db.productDao().insertAll(product);


//                        db.productDao().insertAll(product);
//
//                        DataModel dataModel = new DataModel();
//                        dataModel.setName(m_Text);
//                        dataModel.setFeature(m_Status);
//
//
//
//
//                        dataModels.add(dataModel);
                        adapter.notifyDataSetChanged();


                        dialog.dismiss();

                    }
                });
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                builder.show();


            }
        });


//        final TextView textView = root.findViewById(R.id.text_home);
//        homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
//            @Override
//            public void onChanged(@Nullable String s) {
//                textView.setText(s);
//            }
//        });
        return root;
    }
}

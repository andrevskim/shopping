package com.example.shopping.ui;

import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.PopupMenu;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.shopping.R;
import com.example.shopping.db.AppDB;
import com.example.shopping.db.entity.ProductEntity;
import com.example.shopping.ui.home.HomeFragment;
import com.google.android.material.button.MaterialButton;

import java.util.List;
import java.util.Optional;

public class CustomAdapter extends ArrayAdapter<ProductEntity> {
    private AppDB db;
    private HomeFragment homeFragment;


    public CustomAdapter(@NonNull Context context, List<ProductEntity> productEntities, AppDB db) {
        super(context, 0, productEntities);
        this.db = db;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        final ProductEntity product = Optional.ofNullable(getItem(position)).orElse(new ProductEntity());

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.row_item, parent, false);
        }

        TextView name = convertView.findViewById(R.id.name);
        TextView status = convertView.findViewById(R.id.status);
        MaterialButton moreOpts = convertView.findViewById(R.id.more_options);

        name.setText(product.product);
        status.setText(product.status);
        moreOpts.setOnClickListener(v -> {
            PopupMenu menu = createPopupMenu(getContext(), moreOpts, product);
            menu.show();
        });

        return convertView;
    }

    private PopupMenu createPopupMenu(Context context, View view, ProductEntity product) {
        PopupMenu menu = new PopupMenu(context, view, Gravity.END);
        MenuInflater inflater = menu.getMenuInflater();
        inflater.inflate(R.menu.menu_more_opts, menu.getMenu());
        menu.setOnMenuItemClickListener(item -> {
            switch (item.getItemId()) {
                case R.id.edit:
//                    AlertDialog.Builder builder = new AlertDialog.Builder(context);
//                    builder.setTitle("Измени");
//                    EditText input = new EditText(context);
//                    input.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_NORMAL);
//                    builder.setView(input);
//                    builder.setPositiveButton("Внеси", new DialogInterface.OnClickListener() {
//                        @Override
//                        public void onClick(DialogInterface dialog, int which) {
//
//
//                            product.product = input.getText().toString();
//                            product.status = "Активен";
//
//                            db.productDao().update(product);
//                            notifyDataSetChanged();
//                        }
//                    });

                    return true;
                case R.id.delete:
                    product.status = "Пасивен";
                    db.productDao().update(product);
                    notifyDataSetChanged();
                    remove(product);
                    List<ProductEntity> dbResults = db.productDao().getPassive();
//                    notifyDataSetChanged();

                    return true;
            }
            return false;
        });
        return menu;
    }


}
//    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
//        final DataModel dataModel = Optional.ofNullable(getItem(position)).orElse(new DataModel());
//
//        if (convertView == null) {
//            convertView = LayoutInflater.from(getContext()).inflate(R.layout.row_item, parent, false);
//        }
//
//        TextView name = convertView.findViewById(R.id.name);
//        TextView status = convertView.findViewById(R.id.status);
//        MaterialButton moreOpts = convertView.findViewById(R.id.more_options);
//
//        name.setText(dataModel.getName());
//        status.setText(dataModel.getFeature());
//        moreOpts.setOnClickListener(v -> {
//            PopupMenu menu = createPopupMenu(getContext(), moreOpts, dataModel);
//            menu.show();
//        });
//
//        return convertView;
//    }
//
//    private PopupMenu createPopupMenu(Context context, View view, DataModel dataModel) {
//        PopupMenu menu = new PopupMenu(context, view, Gravity.END);
//        MenuInflater inflater = menu.getMenuInflater();
//        inflater.inflate(R.menu.menu_more_opts, menu.getMenu());
//        menu.setOnMenuItemClickListener(item -> {
//            switch (item.getItemId()) {
//                case R.id.edit:
//
//                    return true;
//                case R.id.delete:
//
//                    return true;
//            }
//            return false;
//        });
//        return menu;
//    }
//
//
//
//}
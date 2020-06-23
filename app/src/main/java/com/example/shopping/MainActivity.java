package com.example.shopping;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.shopping.ui.CustomAdapter;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;




public class MainActivity extends AppCompatActivity {

    FloatingActionButton fab_more, fab_edit, fab_alarm, fab_noalarm, fab_trash;
    private static CustomAdapter adapter;
//    Animation fabOpen,fabClose;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.


        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);


//        final ArrayList items = new ArrayList<String>();
//
//        final ArrayAdapter adapter = new ArrayAdapter<String>(this, R.layout.activity_main, items);
//
//        ListView listView = (ListView) findViewById(R.id.newItem);
//        listView.setAdapter(adapter);
//
//        final Context main = this;


        //TESTADAPTER!!

    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.bottom_nav_menu, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);





        //TESTADAPTEREND!

//        fab_more= findViewById(R.id.expButton);
//        fab_edit=findViewById(R.id.expButton4);
//        fab_alarm=findViewById(R.id.expButton2);
//        fab_noalarm=findViewById(R.id.expButton3);
//        fab_trash=findViewById(R.id.expButton1);

//        FloatingActionButton addlist = (FloatingActionButton) findViewById(R.id.plusButton);

//        addlist.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View arg) {
//                final AlertDialog.Builder builder = new AlertDialog.Builder(main);
//                builder.setTitle("New list");
//
//                final EditText input = new EditText(main);
//                input.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_NORMAL);
//                builder.setView(input);
//
//                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
////                        dialog.dismiss();
//
//                        String m_Text = input.getText().toString();
////                        adapter.add(m_Text);
//                        items.add(m_Text);
//
//                        dialog.dismiss();
//
//                    }
//                });
//                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        dialog.cancel();
//                    }
//                });
//                builder.show();
//            }
//        });


//        fab_alarm.setVisibility(View.INVISIBLE);

//        fabOpen= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fab_open);
//        fabClose= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fab_close);


    }


//}

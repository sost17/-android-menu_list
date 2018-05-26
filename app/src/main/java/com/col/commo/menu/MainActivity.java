package com.col.commo.menu;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.ContextMenu;
import android.view.SubMenu;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.Toast;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MainActivity extends Activity {

    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);

        imageView = (ImageView) findViewById(R.id.imageView);

        registerForContextMenu(imageView);

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.

        try{
            Class<?> menuClass =Class.forName("com.android.internal.view.menu.MenuBuilder");
            Method menuMethod = menuClass.getDeclaredMethod("setOptionalIconsVisible",boolean.class);
            menuMethod.setAccessible(true);
            menuMethod.invoke(menu, true);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
//        getMenuInflater().inflate(R.menu.menu_main, menu);

        MenuItem t1 = menu.add(0,Menu.FIRST,0,"1").setIcon(R.mipmap.ic_launcher);
        SubMenu t2 = menu.addSubMenu(0,Menu.FIRST+1,0,"2").setIcon(R.mipmap.ic_launcher);
        t2.setHeaderIcon(R.drawable.images1);
        t2.add(0,1,2,"2");
        return true;
    }

//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            Toast.makeText(MainActivity.this,"2222",Toast.LENGTH_SHORT).show();
//
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {

        super.onCreateContextMenu(menu, v, menuInfo);
        switch (v.getId()) {
            case R.id.imageView:
                menu.add(0, 200, 0, "1");
                menu.add(0, 201, 0, "2");
                menu.add(0, 202, 0, "3");
                menu.add(0, 203, 0, "4");
                menu.setHeaderIcon(R.mipmap.ic_launcher);
                menu.setHeaderTitle("ok......");
                break;

            default:
                break;
        }
    }
}

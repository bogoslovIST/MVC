package ru.bogoslov.myapplication;

import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

import com.scalified.fab.ActionButton;

import java.util.ArrayList;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class MainActivity extends ListActivity {

    private CustomAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("OpenSans-Light.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build()
        );
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        final String[] projectsArray = new String[]{"Семья", "Работа", "Прочее"};
        ArrayList<Todo> todos = new ArrayList<>();
        todos.add(new Todo("Заплатить за квартиру", false, 0));
        todos.add(new Todo("Купить продукты", false, 0));
        todos.add(new Todo("Забрать обувь с ремонта", true, 0));
        todos.add(new Todo("Заполнить отчет", false, 1));
        todos.add(new Todo("Отправить документы", false, 1));
        todos.add(new Todo("Позвонить заказчику", false, 1));
        todos.add(new Todo("Позвонить другу", false, 2));
        todos.add(new Todo("Подготовиться к поездке", false, 2));

        mAdapter = new CustomAdapter(this);
        mAdapter.itemCount(todos.size());
        int check = 0;
        for(int i = 0; i < todos.size(); i++){
            if(todos.get(i).projectRef == check){
                mAdapter.addSectionHeaderItem(projectsArray[check]);
                check++;
            }

            mAdapter.addItem(todos.get(i).text, todos.get(i).isCompleted, i);
        }
        setListAdapter(mAdapter);

        ActionButton newTodo = (ActionButton) findViewById(R.id.newtodo_fab);
        newTodo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getBaseContext(), CreateActivity.class);
                i.putExtra("projects", projectsArray);
                startActivity(i);
            }
        });
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }
}

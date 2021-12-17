package com.gmail.mateendev3.androidrecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements OnCarClickListener {
    List<Car> cars;
    CarAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.rcv_recycler_view);

        //Creating a list
        cars = new ArrayList<>();
        cars.add(new Car("BRV", R.drawable.brv));
        cars.add(new Car("Civic", R.drawable.civic));
        cars.add(new Car("Corolla", R.drawable.corolla));
        cars.add(new Car("Daimler", R.drawable.daimler));
        cars.add(new Car("Ferrari", R.drawable.ferrari));
        cars.add(new Car("Ford", R.drawable.ford));
        cars.add(new Car("Lamborghini", R.drawable.lamborghini));
        cars.add(new Car("Mercedes", R.drawable.mercedes));
        cars.add(new Car("Volkswagen", R.drawable.volkswagen));

        adapter = new CarAdapter(cars, this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

    }

    @Override
    public void onCarClick(int position) {
        Toast.makeText(MainActivity.this, cars.get(position).getCarName() + " clicked", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onCarLongClick(int position) {
        cars.remove(position);
        adapter.notifyItemRemoved(position);
    }
}
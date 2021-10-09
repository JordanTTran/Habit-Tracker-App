package com.example.individualhabit;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

import petrov.kristiyan.colorpicker.ColorPicker;

public class MainActivity extends AppCompatActivity {
    private Button button;
    private EditText editTextName;
    private int dayStreak = 54;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Button to go to IndividualPage
        button = (Button) findViewById(R.id.pageButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPage();
            }
        });

        //Edit text for Day Streak number
        editTextName = (EditText) findViewById(R.id.editDayStreakText);

        //Button to save Day Streak number
        button = (Button) findViewById(R.id.dayStreakButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editTextName.getText().toString();
                setDayStreak(Integer.parseInt(name));


            }
        });




        //Habit Colour Button Listener

        Button btnHabitColour = (Button) findViewById(R.id.btnColourPicker);
        Button btnCreate = (Button) findViewById(R.id.btnCreate);

        btnHabitColour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openColourPicker();
            }
        });

        //Create Habit Button Lister
        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });

    }

        public void setDayStreak(int day) {
            dayStreak = day;
        }

        public int getDayStreak() {
            return dayStreak;
        }

        public void openPage() {
            Intent intent = new Intent(this, IndividualPage.class);
            startActivity(intent);

        }

    //Function that opens the colour picker dialog box
    public void openColourPicker(){
        Button btnHabitColour = (Button) findViewById(R.id.btnColourPicker);
        Button btnCreate = (Button) findViewById(R.id.btnCreate);
        final ColorPicker colourPicker = new ColorPicker(this);
        ArrayList<String> colours = new ArrayList<>();
        colours.add("#fc5a4c");//red
        colours.add("#fca14c");//orange
        colours.add("#fce74c");//yellow
        colours.add("#a7fc4c");//light green
        colours.add("#06bf34");//green
        colours.add("#4cd3fc");//light blue
        colours.add("#1644db");//blue
        colours.add("#7e4cfc");//purple

        colourPicker.setColors(colours)
                .setColumns(4)
                .setRoundColorButton(true)
                .setOnChooseColorListener(new ColorPicker.OnChooseColorListener() {
                    @Override
                    public void onChooseColor(int position, int colour) {
                        //changes button colours to match colour chosen
                        btnHabitColour.setBackgroundColor(colour);
                        btnCreate.setBackgroundColor(colour);

                        //For later
                        IndividualPage individualPage = new IndividualPage();
                        individualPage.setColor(colours.get(position));

                        //Changes color
                        individualPage.color = colours.get(position);


                    }

                    @Override
                    public void onCancel() {
                        //does nothing
                    }
                }).show();
    }

}
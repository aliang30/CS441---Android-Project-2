package com.example.project2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    PaintPotView v_drawingPad;
    Button b_red, b_blue, b_green, b_cyan, b_yellow, b_black, b_white, b_magenta;
    Button b_reset, b_dotSizePlus, b_dotSizeMinus;

    private static final int DOT_SIZE_INCREMENT = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b_red = (Button)findViewById(R.id.red_b);
        b_blue = (Button)findViewById(R.id.blue_b);
        b_green = (Button)findViewById(R.id.green_b);
        b_yellow = (Button)findViewById(R.id.yellow_b);
        b_magenta = (Button)findViewById(R.id.magenta_b);
        b_black = (Button)findViewById(R.id.black_b);
        b_white = (Button)findViewById(R.id.white_b);
        b_cyan = (Button)findViewById(R.id.cyan_b);
        b_reset = (Button)findViewById(R.id.reset_b);
        b_dotSizePlus = (Button)findViewById(R.id.plus_b);
        b_dotSizeMinus = (Button)findViewById(R.id.minus_b);

        b_red.setOnClickListener(this);
        b_blue.setOnClickListener(this);
        b_green.setOnClickListener(this);
        b_yellow.setOnClickListener(this);
        b_magenta.setOnClickListener(this);
        b_black.setOnClickListener(this);
        b_white.setOnClickListener(this);
        b_cyan.setOnClickListener(this);
        b_reset.setOnClickListener(this);
        b_dotSizePlus.setOnClickListener(this);
        b_dotSizeMinus.setOnClickListener(this);
        v_drawingPad = (PaintPotView)findViewById(R.id.drawingPad_v);

    }


    @Override
    public void onClick(View view) {

        Button _b = (Button)findViewById(view.getId());

        switch (view.getId()) {
            case R.id.red_b:
                v_drawingPad.setPenColor(Color.RED);
                Log.d("Button Pressed: ", _b.getText() + "");
                break;
            case R.id.blue_b:
                v_drawingPad.setPenColor(Color.BLUE);
                Log.d("Button Pressed: ", _b.getText() + "");
                break;
            case R.id.green_b:
                v_drawingPad.setPenColor(Color.GREEN);
                Log.d("Button Pressed: ", _b.getText() + "");
                break;
            case R.id.cyan_b:
                v_drawingPad.setPenColor(Color.CYAN);
                Log.d("Button Pressed: ", _b.getText() + "");
                break;
            case R.id.black_b:
                v_drawingPad.setPenColor(Color.BLACK);
                Log.d("Button Pressed: ", _b.getText() + "");
                break;
            case R.id.yellow_b:
                v_drawingPad.setPenColor(Color.YELLOW);
                Log.d("Button Pressed: ", _b.getText() + "");
                break;
            case R.id.white_b:
                v_drawingPad.setPenColor(Color.WHITE);
                Log.d("Button Pressed: ", _b.getText() + "");
                break;
            case R.id.magenta_b:
                v_drawingPad.setPenColor(Color.MAGENTA);
                Log.d("Button Pressed: ", _b.getText() + "");
                break;
            case R.id.reset_b:
                v_drawingPad.reset();
                Log.d("Button Pressed: ", _b.getText() + "");
                break;
            case R.id.plus_b:
                v_drawingPad.changeDotSize(+DOT_SIZE_INCREMENT);
                Log.d("Button Pressed: ", _b.getText() + "");
                break;
            case R.id.minus_b:
                v_drawingPad.changeDotSize(-DOT_SIZE_INCREMENT);
                Log.d("Button Pressed: ", _b.getText() + "");
                break;
        }
    }
}

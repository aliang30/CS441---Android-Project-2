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
    Button b_red, b_blue, b_green;
    Button b_reset, b_dotSizePlus, b_dotSizeMinus;
    TextView tv_dotSize;

    private static final int DOT_SIZE_INCREMENT = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        b_red = (Button)findViewById(R.id.red_b);
        b_blue = (Button)findViewById(R.id.blue_b);
        b_green = (Button)findViewById(R.id.green_b);
        b_reset = (Button)findViewById(R.id.reset_b);
        b_dotSizePlus = (Button)findViewById(R.id.plus_b);
        b_dotSizeMinus = (Button)findViewById(R.id.minus_b);

        b_red.setOnClickListener(this);
        b_blue.setOnClickListener(this);
        b_green.setOnClickListener(this);
        b_reset.setOnClickListener(this);
        b_dotSizePlus.setOnClickListener(this);
        b_dotSizeMinus.setOnClickListener(this);
        v_drawingPad = (PaintPotView)findViewById(R.id.drawingPad_v);

        tv_dotSize = (TextView)findViewById(R.id.dotSize_tv);
        tv_dotSize.setText("DOT SIZE =" + v_drawingPad.getDotSize());

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
            case R.id.reset_b:
                v_drawingPad.reset();
                Log.d("Button Pressed: ", _b.getText() + "");
                break;
            case R.id.plus_b:
                v_drawingPad.changeDotSize(+DOT_SIZE_INCREMENT);
                tv_dotSize.setText("DOT SIZE = " + v_drawingPad.getDotSize());
                Log.d("Button Pressed: ", _b.getText() + "");
                break;
            case R.id.minus_b:
                v_drawingPad.changeDotSize(-DOT_SIZE_INCREMENT);
                tv_dotSize.setText("DOT SIZE = " + v_drawingPad.getDotSize());
                Log.d("Button Pressed: ", _b.getText() + "");
                break;
        }
    }
}

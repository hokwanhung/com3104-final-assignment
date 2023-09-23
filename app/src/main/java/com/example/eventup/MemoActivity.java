package com.example.eventup;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

public class MemoActivity extends AppCompatActivity
        implements View.OnTouchListener

{


    private ImageView imageView;


    private Bitmap bitmap;


    private Canvas canvas;


    private Paint paint;


    private float downX = 0, downY = 0, upX = 0, upY = 0;


    private float lastX, lastY;

    SeekBar sb;
    TextView tv_sb;

    ImageButton red_bt, blue_bt, black_bt;
    Button del_bt;

    @Override
    protected void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memo);

        // Get components from XML
        imageView = findViewById(R.id.imageView);
        red_bt = findViewById(R.id.imageButtonRed);
        blue_bt = findViewById(R.id.imageButtonBlue);
        black_bt = findViewById(R.id.imageButtonBlack);
        del_bt = findViewById(R.id.del_bt);

        // Determine dimensions of display (screen)
        Display currentDisplay = getWindowManager().getDefaultDisplay();
        int width = (int) currentDisplay.getWidth();
        int height = (int) currentDisplay.getHeight();

        // Create an area for drawing
        bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        canvas = new Canvas(bitmap);
        paint = new Paint();

        // Set line thickness and color
        paint.setStrokeWidth(10);
        paint.setColor(Color.RED);

        // Add drawing area to Image View
        imageView.setImageBitmap(bitmap);
        imageView.setOnTouchListener(this);

        sb = findViewById(R.id.sb);
        sb.setMax(20);
        sb.setProgress(10);
        tv_sb = findViewById(R.id.tv_sb);

        sb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress,
                                          boolean fromUser) {
                //Toast.makeText(getApplicationContext(),"seekbar progress: "+progress, Toast.LENGTH_SHORT).show();
                tv_sb.setText("Pen thickness [" + sb.getProgress() + "]:");
                paint.setStrokeWidth(sb.getProgress());
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                //Toast.makeText(getApplicationContext(),"seekbar touch started!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                //Toast.makeText(getApplicationContext(),"seekbar touch stopped!", Toast.LENGTH_SHORT).show();
            }
        });

        red_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                paint.setColor(Color.RED);
            }
        });

        blue_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                paint.setColor(Color.BLUE);
            }
        });

        black_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                paint.setColor(Color.BLACK);
            }
        });

        del_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                canvas.drawColor(Color.WHITE);
                imageView.invalidate();
            }
        });

    }

    @Override
    public boolean onTouch (View v, MotionEvent event){

        int action = event.getAction();
        switch (action) {
            case MotionEvent.ACTION_DOWN:
                //Record current point, which will later be previous point
                downX = event.getX();
                downY = event.getY();
                lastX = downX;
                lastY = downY;
                break;
            case MotionEvent.ACTION_MOVE:
                // Record current point
                upX = event.getX();
                upY = event.getY();

                // Draw line from previous point to current point
                canvas.drawLine(lastX, lastY, upX, upY, paint);
                imageView.invalidate();

                // Current point will later be previous point
                lastX = upX;
                lastY = upY;
                break;
            case MotionEvent.ACTION_UP:
                break;
        }


        return true;
    }


}



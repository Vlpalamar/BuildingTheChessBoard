package com.example.chessboard;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Color;
import android.graphics.Point;
import android.os.Bundle;
import android.view.Display;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    private static final int BLACKCOLLOR = Color.BLACK;
    private static final int WHITECOLOR = Color.GRAY;



    int screenWidth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        screenWidth = getScreenSize() ;

        buildTheChessBoard(8,8);
    }




    private void buildTheChessBoard(int  vertical , int horizontal)
    {

        

        LinearLayout linearLayout= new LinearLayout(this);
        LinearLayout.LayoutParams layoutParams= new LinearLayout.LayoutParams
                (ConstraintLayout.LayoutParams.WRAP_CONTENT, ConstraintLayout.LayoutParams.WRAP_CONTENT);
        linearLayout.setOrientation(LinearLayout.HORIZONTAL);

        for (int i = 0; i < horizontal ; i++) {

            LinearLayout linerHorizontal= new LinearLayout(this);
            LinearLayout.LayoutParams paramHorizontal= new LinearLayout.LayoutParams
                    (ConstraintLayout.LayoutParams.WRAP_CONTENT, ConstraintLayout.LayoutParams.WRAP_CONTENT);
            linerHorizontal.setOrientation(LinearLayout.VERTICAL);

            for (int j = 0; j < vertical; j++) {
                LinearLayout linerVertical= new LinearLayout(this);
                LinearLayout.LayoutParams paramVertical= new LinearLayout.LayoutParams
                        (ConstraintLayout.LayoutParams.WRAP_CONTENT, ConstraintLayout.LayoutParams.WRAP_CONTENT);
                linerVertical.setOrientation(LinearLayout.HORIZONTAL);

                Button button= new Button(this);
                button.setBackgroundColor(chooseColor(i,j));
                button.setMinimumWidth(0);
                button.setWidth(screenWidth/horizontal);
                linerVertical.addView(button);

                linerHorizontal.addView(linerVertical);
            }

            linearLayout.addView(linerHorizontal);

        }





        setContentView(linearLayout);

    }

    private int chooseColor(int i, int j) {
        if (i%2==0 && j%2==0) return  WHITECOLOR;
        else if (i%2==1 && j%2==1) return WHITECOLOR;
        else  return BLACKCOLLOR;
    }

    private int getScreenSize() {
        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        return size.x;
    }

}
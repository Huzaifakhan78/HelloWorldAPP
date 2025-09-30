package com.example.helloworldapp;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    // It's good practice to declare views you interact with as member variables
    // if you need to access them in multiple methods, though not strictly necessary here.
    private TextView firstlab;
    private Button changeColorButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // Find views
        firstlab = findViewById(R.id.firstlab); // Initialize firstlab here
        changeColorButton = findViewById(R.id.btnChangeColor);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets; // It's common to return insets or WindowInsetsCompat.CONSUMED
        });

        // Set the OnClickListener for the changeColorButton
        changeColorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Option 1: Change to a specific color (e.g., RED)
                // v.setBackgroundColor(Color.RED);

                // Option 2: Cycle through a few colors
                Drawable background = v.getBackground();
                int currentColor = Color.TRANSPARENT; // Default if not a ColorDrawable

                if (background instanceof ColorDrawable) {
                    currentColor = ((ColorDrawable) background).getColor();
                }

                if (currentColor == Color.BLUE) {
                    v.setBackgroundColor(Color.GREEN);
                } else if (currentColor == Color.GREEN) {
                    v.setBackgroundColor(Color.RED);
                } else if (currentColor == Color.RED) {
                    v.setBackgroundColor(Color.YELLOW);
                } else {
                    // Default or initial color if current color is not one of the above
                    // or if the background wasn't a solid color initially.
                    v.setBackgroundColor(Color.BLUE);
                }

                // If you wanted to change the text color of the button:
                // changeColorButton.setTextColor(Color.WHITE);

                // If you wanted to change the background color of 'firstlab' TextView:
                // firstlab.setBackgroundColor(Color.CYAN);

                // If you wanted to change the text color of 'firstlab' TextView:
                // firstlab.setTextColor(Color.MAGENTA);
            }
        });
    }

    // This method is presumably called by an android:onClick="ChangeTextClick" in your XML
    public void ChangeTextClick(View view) {
        // 'firstlab' is already initialized in onCreate, so we can use the member variable
        if (firstlab != null) {
            firstlab.setText("Hello World! Changed");
        }
    }
    //BranchChange
}

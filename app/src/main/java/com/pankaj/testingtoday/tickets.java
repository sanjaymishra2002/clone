package com.pankaj.testingtoday;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.WindowInsetsControllerCompat;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class tickets extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_tickets);
        TextView dateTextView = findViewById(R.id.bookingdate);

        Calendar calendar = Calendar.getInstance();
        Date today = calendar.getTime();
        // Subtract 10 days from today's date
        Calendar tenDaysAgoCalendar = Calendar.getInstance();
        tenDaysAgoCalendar.setTime(today);
        tenDaysAgoCalendar.add(Calendar.DAY_OF_YEAR, -11);
        Date tenDaysAgo = tenDaysAgoCalendar.getTime();

        // Format the date
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
        String formattedDate = dateFormat.format(tenDaysAgo);
        dateTextView.setText(formattedDate);

        LinearLayout linearLayout = findViewById(R.id.view);

        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an Intent to start a new activity
                Intent intent = new Intent(tickets.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }
}
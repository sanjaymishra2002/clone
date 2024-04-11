package com.pankaj.testingtoday;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ValueAnimator;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView dateTextView = findViewById(R.id.bookingdate);
        TextView dateTextView2 = findViewById(R.id.bookingdate2);
        TextView fromdate = findViewById(R.id.fromdate);
        TextView todate = findViewById(R.id.todate);

// Get today's date
        Calendar calendar = Calendar.getInstance();
        Date today = calendar.getTime();

// Subtract 10 days from today's date
        Calendar tenDaysAgoCalendar = Calendar.getInstance();
        tenDaysAgoCalendar.setTime(today);
        tenDaysAgoCalendar.add(Calendar.DAY_OF_YEAR, -11);
        Date tenDaysAgo = tenDaysAgoCalendar.getTime();

// Subtract 9 days from today's date
        Calendar nineDaysAgoCalendar = Calendar.getInstance();
        nineDaysAgoCalendar.setTime(today);
        nineDaysAgoCalendar.add(Calendar.DAY_OF_YEAR, -10);
        Date nineDaysAgo = nineDaysAgoCalendar.getTime();

// Add 20 days to today's date
        Calendar twentyDaysLaterCalendar = Calendar.getInstance();
        twentyDaysLaterCalendar.setTime(today);
        twentyDaysLaterCalendar.add(Calendar.DAY_OF_YEAR, 20);
        Date twentyDaysLater = twentyDaysLaterCalendar.getTime();

// Format the date
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
        String formattedDate = dateFormat.format(tenDaysAgo);
        String formattedDate2 = dateFormat.format(nineDaysAgo);
        String formattedDate3 = dateFormat.format(twentyDaysLater);

// Set the formatted date to the TextView
        dateTextView.setText(formattedDate);
        fromdate.setText(formattedDate2);
        todate.setText(formattedDate3);
        dateTextView2.setText("Booking Time: " + formattedDate + " 07:07");


        TextView movingText = findViewById(R.id.txtTitle);

// Calculate start and end X positions
        int screenWidth = getResources().getDisplayMetrics().widthPixels;
        float startX = screenWidth;
        float endX = -screenWidth;

// Create the animation
        Animation animation = new TranslateAnimation(startX, endX, 0, 0);
        animation.setDuration(5000);
        animation.setRepeatMode(Animation.RESTART);
        animation.setRepeatCount(Animation.INFINITE);

// Apply animation to TextView
        movingText.startAnimation(animation);


        TextView textView = findViewById(R.id.textView);

        String resetText = "it is recommended not to perform factory reset or change your handset whenever you are having valid ticket in the mobile. ";
        String linkText = "Click for Changing Handset with Valid Ticket";

        SpannableString spannableString = new SpannableString(resetText + linkText);

        // Set color for reset text
        spannableString.setSpan(new ForegroundColorSpan(getColor(R.color.grey)), 0, resetText.length(), SpannableString.SPAN_EXCLUSIVE_EXCLUSIVE);

        // Set color and click listener for link text
        ClickableSpan clickableSpan = new ClickableSpan() {
            @Override
            public void onClick(View widget) {
                // Handle click event here
                Toast.makeText(getApplicationContext(), "Link clicked", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void updateDrawState(android.text.TextPaint ds) {
                super.updateDrawState(ds);
                ds.setUnderlineText(true); // Enable underline for link text
                ds.setColor(Color.parseColor("#FFA500")); // Set link text color to orange
            }
        };
        spannableString.setSpan(clickableSpan, resetText.length(), resetText.length() + linkText.length(), SpannableString.SPAN_EXCLUSIVE_EXCLUSIVE);

        // Enable click on link text
        textView.setMovementMethod(LinkMovementMethod.getInstance());

        // Set spannable string to the text view
        textView.setText(spannableString);
    }
}
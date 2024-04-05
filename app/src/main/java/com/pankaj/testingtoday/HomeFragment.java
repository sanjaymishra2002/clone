package com.pankaj.testingtoday;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

public class HomeFragment extends Fragment {

    private View rootView;
    private RadioGroup radioGroup;
    private TextView resultTextView;
    private CardView cardHide;
    private CardView card3, card2;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_home, container, false);

        radioGroup = rootView.findViewById(R.id.radioGroup);
        resultTextView = rootView.findViewById(R.id.resultTextView);
        cardHide = rootView.findViewById(R.id.cardhide);
        card3 = rootView.findViewById(R.id.card3);
        card2 = rootView.findViewById(R.id.card2);
        card2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =  new Intent(requireActivity(), tickets.class);
                startActivity(intent);
            }
        });
        card3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =  new Intent(requireActivity(), MainActivity.class);
                startActivity(intent);

            }
        });

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.radioButton1:
                        showCard();
                        // Set text for radio button 1 with padding
                        String text1 = "* Use this option if you are outside station premises/Railway track" +
                                "<br>" +
                                "* Use show ticket option on mobile is the travel authority" +
                                "<br>" +
                                "* Set your phone GPS to high accuracy mode" +
                                "<br>" +
                                "<font color='#FF0000'>* No cancellation is allowed for paperless ticket</font>";
                        resultTextView.setText(Html.fromHtml(text1));
                        break;
                    case R.id.radioButton2:
                        showCard();
                        // Set text for radio button 2 with padding
                        String text2 = "* Book anywhere." +
                                "<br>" +
                                "* Print ticket at originating station." +
                                "<br>" +
                                "* PRINTED TICKET is travel authority." +
                                "<br>" +
                                "<font color='#FF0000'>* Travel without ticket printout is punishable</font>";
                        resultTextView.setText(Html.fromHtml(text2));
                        break;
                }
            }
        });

        return rootView;
    }

    private void showCard() {
        cardHide.setVisibility(View.VISIBLE);
    }
}

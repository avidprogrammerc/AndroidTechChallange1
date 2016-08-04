package com.captechconsulting.techchallange1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class DisplayDatesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_dates);

        TableLayout dates_table = (TableLayout) findViewById(R.id.dates_table);

        File file = new File(this.getFilesDir(), "saved_datetimes");
        BufferedReader bufferedReader;

        String currentLine;
        try {
            bufferedReader = new BufferedReader(new FileReader(file));

            while((currentLine = bufferedReader.readLine()) != null) {
                addTableRow(dates_table, currentLine);
            }

            bufferedReader.close();
        } catch (Exception e) {
            Log.e("FILE READER", e.getMessage());
        }
    }

    public void addTableRow(TableLayout layout, String text) {
        TableRow row = new TableRow(this);
        TableRow.LayoutParams layoutParams
                = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT);
        row.setLayoutParams(layoutParams);
        TextView textView = new TextView(this);
        textView.setText(text);
        textView.setTextSize(18);
        textView.setPadding(20, 0, 0, 20);
        row.addView(textView);
        layout.addView(row);
    }
}

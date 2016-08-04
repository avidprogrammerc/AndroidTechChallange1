package com.captechconsulting.techchallange1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import java.io.File;
import java.io.FileOutputStream;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        updateDates();
    }

    public void showDates(View view) {
        Intent intent = new Intent(this, DisplayDatesActivity.class);
        startActivity(intent);
    }

    @SuppressWarnings("deprecation")
    private void updateDates() {
        Locale currentLocale = getResources().getConfiguration().locale;
        File file = new File(this.getFilesDir(), "saved_datetimes");
        FileOutputStream outputStream;

        try {
            outputStream = new FileOutputStream(file, true);

            DateFormat formatter = DateFormat.getDateTimeInstance(DateFormat.DEFAULT,
                    DateFormat.DEFAULT, currentLocale);
            String date = formatter.format(new Date()) + "\n";

            outputStream.write(date.getBytes());
            outputStream.close();
        } catch (Exception e) {
            Log.e("FILE WRITTER", e.getMessage());
        }
    }
}

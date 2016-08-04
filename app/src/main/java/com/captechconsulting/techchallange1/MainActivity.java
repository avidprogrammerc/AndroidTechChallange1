package com.captechconsulting.techchallange1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import java.io.File;
import java.io.FileOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    private final String FILENAME = "saved_datetimes";

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

    private void updateDates() {
        File file = new File(this.getFilesDir(), FILENAME);
        FileOutputStream outputStream;

        try {
            outputStream = new FileOutputStream(file, true);

            DateFormat formatter = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
            String date = formatter.format(new Date()) + "\n";

            outputStream.write(date.getBytes());
            outputStream.close();
        } catch (Exception e) {
            Log.e("FILE WRITTER", e.getMessage());
        }
    }
}

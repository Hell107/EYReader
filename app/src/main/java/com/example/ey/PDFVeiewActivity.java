package com.example.ey;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.github.barteksc.pdfviewer.PDFView;
import com.github.barteksc.pdfviewer.util.FitPolicy;

public class PDFVeiewActivity extends AppCompatActivity {


    ImageView buttonReturn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p_d_f_veiew);
        PDFView pdfView = findViewById(R.id.pdfView);
        buttonReturn = (ImageView) findViewById(R.id.buttonReturn);
        buttonReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PDFVeiewActivity.this, ReadBook.class);
                startActivity(intent);
            }
        });

        pdfView.fromAsset("1984 Джорж Оурел.pdf")
                .pages() // all pages are displayed by default
                .enableSwipe(true) // allows to block changing pages using swipe
                .swipeHorizontal(false)
                .enableDoubletap(true)
                .defaultPage(0)
                .enableAnnotationRendering(false) // render annotations (such as comments, colors or forms)
                .password(null)
                .scrollHandle(null)
                .enableAntialiasing(true) // improve rendering a little bit on low-res screens

                .spacing(0)
                .pageFitPolicy(FitPolicy.WIDTH) // mode to fit pages in the view
                .load();
    }
}


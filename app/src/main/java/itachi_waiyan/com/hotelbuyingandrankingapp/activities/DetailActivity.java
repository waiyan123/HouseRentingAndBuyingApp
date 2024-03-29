package itachi_waiyan.com.hotelbuyingandrankingapp.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import itachi_waiyan.com.hotelbuyingandrankingapp.R;

public class DetailActivity extends BaseActivity {
    ImageView imgBack;

    public static final String EXTRA_ID_EXTRA = "eventIdExtra";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_layout);
        imgBack = findViewById(R.id.img_back);
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}

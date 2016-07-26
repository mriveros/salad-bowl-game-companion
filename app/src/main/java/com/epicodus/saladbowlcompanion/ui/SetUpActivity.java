package com.epicodus.saladbowlcompanion.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.epicodus.saladbowlcompanion.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class SetUpActivity extends AppCompatActivity implements View.OnClickListener {
    @Bind(R.id.quickModeButton)
    Button mQuickModeButton;
    @Bind(R.id.creativeModeButton)
    Button mCreativeModeButton;
    @Bind(R.id.teamEditText)
    EditText mTeamEditText;

    int team;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_up);
        ButterKnife.bind(this);

        mQuickModeButton.setOnClickListener(this);
        mCreativeModeButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (mTeamEditText.getText().toString().equals("")) {
            mTeamEditText.setError("Enter number of teams");

        } else if (view == mQuickModeButton) {
            team = Integer.parseInt(mTeamEditText.getText().toString());  // might refactor here
            Log.v("SetUpActivity", "the number of teams is: " + team);
            Intent intent = new Intent(SetUpActivity.this, QuickModeActivity.class);
            intent.putExtra("teams", team);
            startActivity(intent);
        } else if (view == mCreativeModeButton) {
            team = Integer.parseInt(mTeamEditText.getText().toString());
            Intent intent = new Intent(SetUpActivity.this, CreativeModeActivity.class);
            intent.putExtra("teams", team);
            startActivity(intent);

        }
    }
}


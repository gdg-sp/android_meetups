package br.gdgsp.android.demo.randomquestions;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class MainActivity extends Activity {

    private static final int REPEAT_RATE = 50;
    private static final int NO_DELAY = 0;

    @InjectView(R.id.txt_question_label) TextView questionLabel;

    private final UpdateLabel UPDATER = new UpdateLabel();

    private QuestionsRoulette roulette;
    private Question currentQuestion;
    private Timer timer;

    private boolean isRouletteRunnning = false;

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);
        roulette = new QuestionsRoulette(getResources().getStringArray(R.array.questions_array));
    }

    @Override public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(menuToInflate(), menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override public boolean onOptionsItemSelected(MenuItem item) {
        isRouletteRunnning = !isRouletteRunnning;
        Toast.makeText(this, "TO DO ...", Toast.LENGTH_SHORT).show();
        invalidateOptionsMenu();

        return super.onOptionsItemSelected(item);
    }

    @Override protected void onStart() {
        initTimer();
        super.onStart();
    }

    @Override protected void onStop() {
        stopTimer();
        super.onStop();
    }

    private int menuToInflate() {
        return (isRouletteRunnning) ? R.menu.menu_action_pause : R.menu.menu_action_play;
    }

    private void initTimer() {
        timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override public void run() {
                runOnUiThread(UPDATER);
            }
        }, NO_DELAY, REPEAT_RATE);
    }

    private void stopTimer() {
        timer.cancel();
        timer = null;
    }


    @OnClick(R.id.btn_pick_question) void showCurrentQuestion() {
        QuestionDialogFragment
                .newInstance(currentQuestion)
                .show(getFragmentManager(), Question.TAG);
    }

    private class UpdateLabel implements Runnable {

        @Override public void run() {
            currentQuestion = roulette.next();
            questionLabel.setText(currentQuestion.getNumber());
        }
    }
}

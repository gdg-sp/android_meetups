package br.gdgsp.android.demo.randomquestions;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;

/**
 * Created by @ubiratanfsoares on 5/5/14.
 */

public class QuestionDialogFragment extends DialogFragment {

    private static final String ARGUMENT_QUESTION = "argument_question";

    private Question randomizedQuestion;

    public static QuestionDialogFragment newInstance(Question question) {

        QuestionDialogFragment f = new QuestionDialogFragment();

        if (question != null) {
            final Bundle args = new Bundle();
            args.putSerializable(ARGUMENT_QUESTION, question);
            f.setArguments(args);
        }

        return f;
    }

    @Override public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            randomizedQuestion = (Question) getArguments().getSerializable(ARGUMENT_QUESTION);
        }
    }

    @Override public Dialog onCreateDialog(Bundle savedInstanceState) {
        return new AlertDialog.Builder(getActivity())
                .setTitle("Questão ".concat(randomizedQuestion.getNumber()))
                .setMessage(randomizedQuestion.getProblem())
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override public void onClick(DialogInterface dialog, int which) {
                        // DONE!
                    }
                })
                .create();
    }
}

package br.gdgsp.android.demo.randomquestions;

import java.io.Serializable;

/**
 * Created by @ubiratanfsoares on 5/5/14.
 */

public class Question implements Serializable {

    public static final String TAG = Question.class.getCanonicalName();

    private String number;
    private String problem;

    public static Question create(String label, String problem) {
        return new Question(label, problem);
    }

    private Question(String label, String problem) {
        this.number = label;
        this.problem = problem;
    }

    public String getNumber() {
        return number;
    }

    public String getProblem() {
        return problem;
    }
}

package br.gdgsp.android.demo.randomquestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Created by @ubiratanfsoares on 5/5/14.
 */

public class QuestionsRoulette {

    private static final Random RANDOM = new Random();

    private List<Question> questions;

    public QuestionsRoulette(String[] unumeredQuestions) {
        if(unumeredQuestions != null) {
            initWith(unumeredQuestions);
        }
    }

    public Question next() {
        final Question randomizedQuestion = questions.get(RANDOM.nextInt(questions.size()));
        return randomizedQuestion;
    }

    private void initWith(String[] questionsArray) {

        questions = new ArrayList<Question>(questionsArray.length);
        final List<String> unumered = Arrays.asList(questionsArray);

        for (int i = 0; i < unumered.size(); i++) {
            final String numberStr = String.valueOf(i);
            questions.add(Question.create(i < 10 ? "0".concat(numberStr) : numberStr, unumered.get(i)));
        }
    }

}

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Quiz implements Runnable{

    private boolean quizIsRunning = true;
    private BlockingQueue<ClientHandler> quizParticipants = new ArrayBlockingQueue<>(10);
    private BlockingQueue<QuizQuestion> quizQuestions = new ArrayBlockingQueue<>(5);

    @Override
    public void run() {
        boolean filledQuestionQueue = false;
        while (quizIsRunning) {
            if (!filledQuestionQueue) {
                fillQuestions();
                filledQuestionQueue = true;
            }
        }
    }

    public void quizRunning(boolean status) {
        if (quizIsRunning != status) {
            quizIsRunning = status;
        }
    }

    public void addQuizParticipant(ClientHandler cl) {
        quizParticipants.add(cl);
    }

    public boolean participantExists(ClientHandler cl) {
        for (ClientHandler c : quizParticipants) {
            if (cl == c) {
                return true;
            }
        }
        return false;
    }

    public QuizQuestion getQuizQuestion(int points) {
        QuizQuestion question = null;
        for (QuizQuestion qq : quizQuestions) {
            if (points == qq.points) {
                question = qq;
                break;
            }
        }
        if (question != null) {
            quizQuestions.remove(question);
            return question;
        }
        else {
            return null;
        }
    }

    public void addQuizQuestion(QuizQuestion quizQuestion) {
        quizQuestions.add(quizQuestion);
    }

    private void fillQuestions() {
        quizQuestions.add(new QuizQuestion(100, "What is 2 + 2", "4"));
        quizQuestions.add(new QuizQuestion(200, "What is 2 + 3", "5"));
        quizQuestions.add(new QuizQuestion(300, "What is 2 + 4", "6"));
        quizQuestions.add(new QuizQuestion(400, "What is 2 + 5", "7"));
        quizQuestions.add(new QuizQuestion(500, "What is 2 + 6", "8"));
    }
}

class QuizQuestion {
    int points;
    String question;
    String answer;

    public QuizQuestion(int points, String question, String answer) {
        this.points = points;
        this.question = question;
        this.answer = answer;
    }
}

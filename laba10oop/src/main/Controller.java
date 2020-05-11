package main;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Controller {
    @FXML private Label result;
    @FXML private Label time;
    @FXML private TextField namestep;
    @FXML private TextField nameThread;


    public void exit(ActionEvent actionEvent) {
        Platform.exit();
    }

    private double mainResult;
    private int finished;

    public void run() {
        double a = 1.0;
        double b = 9.0;
        int n = Integer.parseInt(namestep.getText());
        int nThread = Integer.parseInt(nameThread.getText());
        finished = 0;
        mainResult = 0;
        long start = System.currentTimeMillis();
        double d = (b-a)/nThread;
        int in = n/nThread;
        for (int i = 0; i < nThread; i++) {
            double ia = a + i*d;
            double ib = a + (i+1)*d;
            ThreadCalculator calculator = new ThreadCalculator(this, ia, ib, in, this::fun);
            new Thread(calculator).start();
        }
        try {
            synchronized (this) {
                while (finished < nThread) {
                    wait();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long finish = System.currentTimeMillis();
        long timee = finish - start;
        result.setText(String.format("Res = %f ", mainResult));
        time.setText(String.format("Time = %d", timee));
    }

    public double fun(double t){
        return 3 * Math.sqrt(t);
    }

    public synchronized void sendResult(double res) {
        finished++;
        mainResult += res;
        notify();
    }
}

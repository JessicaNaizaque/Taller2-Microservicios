package javeriana.ms.calculator.model;

import jakarta.persistence.*;

@Entity
@Table(name = "operations")
public class Operations {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String operation;
    private int num1;
    private int num2;
    private float answer;
    private String us;
    private String date;

    public Operations() {
    }
    
    public Operations(String operation, int num1, int num2, float answer, String us, String date) {
        this.operation = operation;
        this.num1 = num1;
        this.num2 = num2;
        this.answer = answer;
        this.us = us;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public int getNum1() {
        return num1;
    }

    public void setNum1(int num1) {
        this.num1 = num1;
    }

    public int getNum2() {
        return num2;
    }

    public void setNum2(int num2) {
        this.num2 = num2;
    }

    public float getAnswer() {
        return answer;
    }

    public void setAnswer(float answer) {
        this.answer = answer;
    }

    public String getUs() {
        return us;
    }

    public void setUs(String us) {
        this.us = us;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Operations{" + "id = " + id + ", num1 = " + num1 + ", num2 = " + num2 + ", answer = " + answer + ", us = " + us + ", date = " + date + '}';
    }    
    
}

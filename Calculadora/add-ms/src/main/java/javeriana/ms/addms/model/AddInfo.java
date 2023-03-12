package javeriana.ms.addms.model;

import jakarta.persistence.*;

@Entity
@Table(name = "add_info")
public class AddInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int num1;
    private int num2;
    private float answer;
    private String us;
    private String date;

    public AddInfo() {
    }

    public AddInfo(int num1, int num2, float answer, String us, String date) {
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
        return "AddInfo{" + "id = " + id + ", num1 = " + num1 + ", num2 = " + num2 + ", answer = " + answer + ", us = " + us + ", date = " + date + '}';
    }
}

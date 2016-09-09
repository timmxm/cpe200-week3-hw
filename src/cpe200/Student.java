package cpe200;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Student {

    public Student() {
        name = "John Doe";
        studentid = "560610000";
        yearofbirth = 1990;
        status =  false;
    }

    public Student(String n, String sid) {
        this.name = !n.equalsIgnoreCase("") ? n : "TBA";

        if(this.isValidStudent_id(sid)){
            this.studentid = sid;
        }else {
            this.studentid = "560610000";
        }
        yearofbirth = 1990;
        status =  false;
    }
    public Student(String n, String sid, int y) {
        this.name = !n.equalsIgnoreCase("") ? n : "TBA";

        if(this.isValidStudent_id(sid)){
            this.studentid = sid;
        }else{
            this.studentid  = "560610000";
        }
        if(this.isValidYOB(y)) {
            this.yearofbirth = y;
        }else{
            this.yearofbirth = 1990;
        }
        status =  false;
    }
    public Student(String n, String sid, int y, boolean stat) {
        this.name = !n.equalsIgnoreCase("") ? n : "TBA";

        if(this.isValidStudent_id(sid)){
            this.studentid = sid;
        }else{
            this.studentid  = "560610000";
        }
        if(this.isValidYOB(y)) {
            this.yearofbirth = y;
        }else{
            this.yearofbirth = 1990;
        }
        this.status = stat;
    }

    public String getName(){
        return this.name;
    }
    public void setName(String name) {
        this.name = !name.equalsIgnoreCase("")?name:this.name;
    }
    public String getStudent_id(){
        return this.studentid;
    }
    public void setStudent_id(String studentid) {
        this.studentid = isValidStudent_id(studentid)?studentid:this.studentid;
    }

    public int getYearOfBirth() {
        return this.yearofbirth;
    }

    public void setYearOfBirth(int yearofbirth) {
        if(yearofbirth >= 1990){
            this.yearofbirth = yearofbirth;
        }
    }

    public boolean getStatus(){
        return this.status;
    }

    public boolean isActive() {
        if (status == true) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        String n = "";
        if(this.isActive()== true){
            n = "ACTIVE";
        }
        else if(this.isActive()==false){
            n = "INACTIVE";
        }
        String o = this.name + " ("+this.studentid+") "+"was born in "+this.yearofbirth+" is an "+n+" student.";

        return o;
    }

    private boolean isValidYOB(int yob) {
        if(yob <1990){
            return false;
        }
        return true;
    }

    private String name;
    private String studentid;
    private int yearofbirth;
    private boolean status;

    private boolean isValidStudent_id(String id) {
        Pattern p = Pattern.compile(idREGEX);
        Matcher m = p.matcher(id);



        return m.matches();
    }

    // Regular expression for the Student ID pattern
    private static final String idREGEX = "^5([6-9]?)061([0-2]?)([0-9]{3})$";

}

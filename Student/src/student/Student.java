/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package student;

import java.util.Scanner;

/**
 *
 * @author bjmaclean
 */
public class Student {
    Scanner input = new Scanner(System.in);
    private String studentId;
    private String lastName, firstName, dob;
    public final static String RECORD_LAYOUT="000,               ,               ,00000000"+ //15 spaces each for first and last name
                    System.getProperty("line.separator");
    public final static int NUMBER_OF_RECORDS=100;
    
    
    public Student(){
        System.out.println("Please enter the student ID");
        studentId= input.nextLine();
        System.out.println("Please enter the student last name");
        lastName = input.nextLine();
        System.out.println("Please enter the student first name");
        firstName = input.nextLine();
        System.out.println("Please enter the student date of birth name (mmddyyyy)");
        dob = input.nextLine();
    }
    
    public void editStudent(){
        
    }
    
    public String toString(){
        return     "Student ID:   \t"+studentId
                +"\nFrist Name:   \t"+firstName
                +"\nLast Name:    \t"+lastName
                +"\nDate of Birth:\t"+dob;
    }
    public String fileOutputString(){
        return fixedLength(studentId,3)+","+fixedLength(firstName,15)+","+fixedLength(lastName,15)+","+fixedLength(dob,8);
    }
    
    public String fixedLength(String s, int length){ //formats a passed string to a specified length
        return String.format("%1$"+length+ "s", s);
    }

    public Scanner getInput() {
        return input;
    }

    public void setInput(Scanner input) {
        this.input = input;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }
    
}

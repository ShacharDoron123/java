package school;

import java.util.Date;

public class Student {
    private String firstName;
    private String lastName;
    private Date birthDate;
    private int classGroup;

    public Student(String first, String last, Date dob) {
        this.firstName = first;
        this.lastName = last;
        this.birthDate = dob;
        this.classGroup = 0;
    }

    public void setFirstName(String first) { this.firstName = first; }
    public void setLastName(String last) { this.lastName = last; }
    public void setBirthDate(Date dob) { this.birthDate = dob; }
    public Date getBirthDate() { return birthDate; }

    public void setClassGroup(Date dob) {
        if (dob.getYear() == 102 && dob.getMonth() < 11)
            this.classGroup = 2;
        else if ((dob.getYear() == 102 && dob.getMonth() == 11) || (dob.getYear() == 103 && dob.getMonth() > 11))
            this.classGroup = 1;
    }

    @Override
    public String toString() {
        return "Student: " + firstName + " " + lastName + ", Birth date: " + birthDate + ", Class Group: " + classGroup;
    }
}

package selab.mvc.models.entities;

import selab.mvc.models.Model;

import java.util.ArrayList;
import java.util.regex.Pattern;

public class Student implements Model {
    private String name;
    private String studentNo;

    private ArrayList<Course> Courses = null;

    @Override
    public String getPrimaryKey() {
        return this.studentNo;
    }

    public void setName(String value) { this.name = value; }
    public String getName() { return this.name; }

    public void setStudentNo(String value) {
        if (!validateStudentNo(value))
            throw new IllegalArgumentException("The format is not correct");

        this.studentNo = value;
    }
    public String getStudentNo() { return this.studentNo; }

    public float getAverage() {
        // TODO: Calculate and return the average of the points
        return 0;
    }

    public void addCourse(Course course) {
        // TODO: 29/07/2019
        //if (!validateStudent(student))
        //    throw new IllegalArgumentException("Invalid time format");

//        if (this.startTime != null && compareTime(value, this.startTime) != 1)
//            throw new IllegalArgumentException("The end time cannot be earlier than the start time.");

        this.Courses.add(course);
    }


    public String getCourses() {
        // TODO: Return a comma separated list of course names
        // doTODO: Return a comma separated list of student names
        StringBuilder name = null;
        String cumolatedNames = "";
        if (!this.Courses.isEmpty()){
            for (int i = 0; i<(this.Courses.size()-1) ; i++) {
                name.append(" , ").append(this.Courses.get(i).getTitle());
            }
            cumolatedNames = name.toString();

        }

        return cumolatedNames;
    }

    /**
     *
     * @param studentNo Student number to be checeked
     * @return true, if the format of the student number is correct
     */
    private boolean validateStudentNo(String studentNo) {
        Pattern pattern = Pattern.compile("^[8-9]\\d{7}$");
        return pattern.matcher(studentNo).find();
    }
}

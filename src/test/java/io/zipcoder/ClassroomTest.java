package io.zipcoder;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ClassroomTest {

    private Classroom classroom;
    private org.junit.Assert Assert;

    @Before
    public void setup() {
        //Initialize a new classroom object for each test
        classroom = new Classroom();
    }

    @Test
    public void testConstructorWithCapacity() {
        Classroom classWithCapacity = new Classroom(50);
        Assert.assertEquals(50, classWithCapacity.getStudents().size());
    }
}

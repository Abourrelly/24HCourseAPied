/**
 * 
 */
package fr.course.bll;

/**
 * @author var_dump
 *
 */
public class CourseManagerSing {
	
	public static CourseManager instance;

	public static CourseManager getInstance() {
		if (instance == null) {
			instance = new CourseManagerImpl();
		}
		return instance;
	}
	
}

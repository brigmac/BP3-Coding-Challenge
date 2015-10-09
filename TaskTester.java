//This class is for testing by changing the inputs of the Taskdoer.

package brigid_BP3CodingChallenge;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;



public class TaskTester
{

	public static void main(String[] args) throws java.text.ParseException 
	{
		List<Task> listOfTasks = JSONget.readJSONTaskList();
		if(listOfTasks == null)
		{
			System.out.println("List error occured");
			System.exit(1);
		}
		
		Taskdoer td = new Taskdoer();
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
		String dateString = "2014-11-20T00:32:27";
		Date dateObject = sdf.parse(dateString); // Handle the ParseException here
		td.openCloseTask(listOfTasks, dateObject);
		
		String startDateString = "2014-8-20T00:32:27";
		String endDateString = "2014-11-20T00:32:27";
		Date startDate = sdf.parse(startDateString);
		Date endDate = sdf.parse(endDateString);
		td.openCloseTaskRange(listOfTasks, startDate, endDate);
		
		td.getMostRecentTask(listOfTasks, 477);
		
		td.getCountOfTask(listOfTasks, 477);
		
		td.assigneeOpenCloseTasks(listOfTasks, "Impact 2014");
		
	}
}
l

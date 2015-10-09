//methods that answer the questions in the challenge

package brigid_BP3CodingChallenge;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;



public class Taskdoer
{
	//Given a specific date provide the current number of open and closed tasks
	public void openCloseTask(List<Task> tasks, Date inDate)
	{
		int openTasksCount = 0;
		int closedTasksCount = 0;
		
		for(Task t: tasks)
		{
		
			//the value 0 if the argument Date is equal to this Date; a value less than 
			//0 if this Date is before the Date argument; and a value greater than 0 
			//if this Date is after the Date argument.
			if (t.crtDate.compareTo(inDate) <= 0 && t.clsdDate != null && t.clsdDate.compareTo(inDate) >= 0)
			{
				openTasksCount++;
			}
			if (t.clsdDate != null && t.clsdDate.compareTo(inDate) <= 0 )
			{
				closedTasksCount++;
			}
		}
		
		System.out.println("The number of open tasks given " + inDate + " is: " + openTasksCount);
		System.out.println("The number of closed tasks given " + inDate + " is: " + closedTasksCount);
	}
	
	//Given a specific start and end date, how many tasks were opened 
	//and how many were closed in that range 
	public void openCloseTaskRange(List<Task> task, Date dateStart, Date dateEnd)
	{
		int openedTasksRangeCount = 0;
		int closedTasksRangeCount = 0;
		
		for(Task t: task)
		{
			if (t.crtDate.compareTo(dateStart) >= 0 && t.crtDate.compareTo(dateEnd) <= 0)
			{
				openedTasksRangeCount++;
			}
			if (t.clsdDate != null && t.clsdDate.compareTo(dateStart) >= 0 && t.clsdDate.compareTo(dateEnd) <= 0)
			{
				closedTasksRangeCount++;
			}
		}
		System.out.println("The number of tasks that were opened is: " + openedTasksRangeCount);
		System.out.println("The number of tasks that were closed is: " + closedTasksRangeCount);
	}
	
	//Given a particular instanceId, provide the name of the most recent task
	//Assuming "most recent" means most recently created
	public void getMostRecentTask(List<Task> tasks,long InstanceID)
	{
		Date mostRecentDate = null;

		int i; 
		
		//make sure set mostRecentDate to the first instance of 
		//instanceID == InstanceID in the list
		for (i = 0; i < tasks.size(); i++) 
		{
			if(tasks.get(i).instanceID == InstanceID)
			{	  
				mostRecentDate = tasks.get(i).crtDate;
				break; 
			}
		}

		if (mostRecentDate == null) 
		{
			System.out.println("No tasks of that given instanceID"); 
			return; 
		}

		//now compare the recentness of tasks in list only where instanceID == InstanceID
		for (int j = i+1; j < tasks.size(); j++)
		{
			if(tasks.get(i).instanceID == InstanceID) 
			{

				// compare 2 Dates, if currDate is greater than mostRecent
				// overwrite mostRecentDate
				if ((tasks.get(i).crtDate.compareTo(mostRecentDate)) > 0) 
				{
					mostRecentDate = tasks.get(i).crtDate; 
				}
			}
		}
		SimpleDateFormat dt1 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
		System.out.println("The most recent date given " + InstanceID + " is: " + dt1.format(mostRecentDate));
		
	}
	
	//Given a particular instanceId, provide the count of tasks
	public void getCountOfTask(List<Task> tasks, long instanceId_)
	{
		int taskcounter = 0;
		for (Task t: tasks)
		{
			if(t.instanceID == instanceId_)
			{
				taskcounter++;
			}
		}
		System.out.println("The number of tasks is: " + taskcounter);
	}
	
	//Given a particular assignee, provide the count of open and closed tasks for that assignee
	public void assigneeOpenCloseTasks(List<Task> tasks, String theAssignee_)
	{
		int assigneeOpenTaskCounter = 0;
		int assigneeClosedTaskCounter = 0;
		for (Task t: tasks)
		{
			if (t.theAssignee == theAssignee_)
			{
					if(t.taskStatus == "Closed")
					{
						assigneeClosedTaskCounter++;
					}
					else
					{
						assigneeOpenTaskCounter++;
					}
			} 
			
		}
		System.out.println("The number of open tasks for the assignee is: " + assigneeOpenTaskCounter); 
		System.out.println("The number of closed tasks for the assignee is: " + assigneeClosedTaskCounter); 
	}
	
}







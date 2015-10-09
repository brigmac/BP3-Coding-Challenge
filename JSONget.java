//This class parses the JSON file, creates java objects (tasks), and then puts the
//objects into a list. The list is the list of tasks.

//Needs a specific filepath to task-3.JSON

package brigid_BP3CodingChallenge;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.FileReader;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import java.text.DateFormat;
import java.text.SimpleDateFormat;



public class JSONget
{
	public static List<Task> readJSONTaskList() 
	{
		JSONParser parser = new JSONParser();
		try 
		{
			List<Task> myTaskList = new LinkedList<Task>();
			
			// needs a specific file path
			JSONArray arr = (JSONArray) parser.parse(new FileReader("/Users/brigmac/Downloads/task-3.json"));
			
			for (Object o: arr) 
			{
				// the () means casting
				JSONObject task = (JSONObject) o;
				
				//gets the instanceId
				long instanceId = (long) task.get("instanceId");
				
				//gets the assignee
				String theAssignee = (String) task.get("assignee");
				
				//gets the task status
				String taskStatus = (String) task.get("status");
				
				//gets the createDate
				String theCreateDate = (String) task.get("createDate");
				DateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
				Date crtDate = format.parse(theCreateDate);
		
				//gets the closeDate
				String theEndDate = (String) task.get("closeDate");
				Date clsdDate; 
				
				//accounts for nulls aka they haven't been closed yet
				if (theEndDate != null) 
				{
					DateFormat format1 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
					clsdDate = format1.parse(theEndDate);
				}
				else 
				{
					clsdDate = null; 
				}
				
				//gets the task id
				String theTaskId = (String) task.get("id");
				
				//get the task name
				String theTaskName = (String) task.get("name");
				
				//adds elements to the task
				Task t = new Task(instanceId, theAssignee, taskStatus, crtDate, clsdDate, theTaskId, theTaskName);
				
				//adds the task to the list
				myTaskList.add(t);
	
		  }
			return myTaskList;
		}

		catch (ParseException p) 
		{
			System.out.println("Failed during parse");
	  }
		catch (IOException fileNotFound) 
		{
			System.out.println("Could not find file");
	  }
		catch (java.text.ParseException e)
		{
			System.out.println("Date failed");
		}
	return null;
	}

}
	

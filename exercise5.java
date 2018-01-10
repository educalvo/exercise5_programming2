package nl.ru.ai.exercise5;

import static nl.ru.ai.exercise5.Maze.*;

import java.util.ArrayList;

public class Exercise5
{
  public static void main(String[] arguments)
  {
    ArrayList<Candidate> candidates=new ArrayList<Candidate>();
    candidates.add(new Candidate(new Attempt(1,7),0));
    boolean found=false;
    int c=0;
    while(c<candidates.size() & !found)
    {
      if (hasRabbit(candidates.get(c).attempt.row, candidates.get(c).attempt.col)) {
    	  showPath(candidates, c);
    	  found = true;
      }
      else {
    	  if (!hasWall(candidates.get(c).attempt.row - 1, candidates.get(c).attempt.col)) {
    		candidates.add(new Candidate(new Attempt(candidates.get(c).attempt.row - 1, candidates.get(c).attempt.col),c));
    		//add (A',c) to C
    	  }
    	  if (!hasWall(candidates.get(c).attempt.row + 1, candidates.get(c).attempt.col)) {
    		candidates.add(new Candidate(new Attempt(candidates.get(c).attempt.row + 1, candidates.get(c).attempt.col),c));
    		//add (A',c) to C
    	  }  
    	  if (!hasWall(candidates.get(c).attempt.row, candidates.get(c).attempt.col - 1)) {
    		candidates.add(new Candidate(new Attempt(candidates.get(c).attempt.row, candidates.get(c).attempt.col - 1),c));
    		//add (A',c) to C
    	  }
    	  if (!hasWall(candidates.get(c).attempt.row, candidates.get(c).attempt.col + 1)) {
    		candidates.add(new Candidate(new Attempt(candidates.get(c).attempt.row, candidates.get(c).attempt.col + 1),c));
    		//add (A',c) to C
    	  }
    	  c ++;
      }   	  
    }
  }

private static void showPath(ArrayList<Candidate> candidates, int c) {
	if (c == 0) {
		System.out.println("Done");
		return;
	}
	System.out.println(candidates.get(c).attempt.col);
	System.out.print(", " +candidates.get(c).attempt.row);
	showPath(candidates, c - 1);
}

}

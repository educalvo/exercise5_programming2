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
      if (hasRabbit(candidates.attempt.row, candidates.attempt.col)) {
    	  showPath(); //shows solution. how is the path stored???
    	  found = true;
      }
      else {
    	  if (!hasWall(candidates.attempt.row - 1, candidates.attempt.col)) {
    		candidates.add(new Candidate(new Attempt(candidates.attempt.row - 1, candidates.attempt.col),c));
    		//add (A',c) to C
    	  }
    	  if (!hasWall(candidates.attempt.row + 1, candidates.attempt.col)) {
    		candidates.add(new Candidate(new Attempt(candidates.attempt.row + 1, candidates.attempt.col),c));
    		//add (A',c) to C
    	  }  
    	  if (!hasWall(candidates.attempt.row, candidates.attempt.col - 1)) {
    		candidates.add(new Candidate(new Attempt(candidates.attempt.row, candidates.attempt.col - 1),c));
    		//add (A',c) to C
    	  }
    	  if (!hasWall(candidates.attempt.row, candidates.attempt.col + 1)) {
    		candidates.add(new Candidate(new Attempt(candidates.attempt.row, candidates.attempt.col + 1),c));
    		//add (A',c) to C
    	  }
    	  c += 1;
      }   	  
    }
  }
}

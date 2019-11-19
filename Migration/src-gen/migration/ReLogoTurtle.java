package migration;

import static repast.simphony.relogo.Utility.*;
import static repast.simphony.relogo.UtilityG.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import groovy.lang.Closure;
import repast.simphony.relogo.*;
import repast.simphony.relogo.builder.GeneratedByReLogoBuilder;
import repast.simphony.relogo.builder.ReLogoBuilderGeneratedFor;
import repast.simphony.space.SpatialException;
import repast.simphony.space.grid.Grid;
import repast.simphony.space.grid.GridPoint;

@GeneratedByReLogoBuilder
@SuppressWarnings({"unused","rawtypes","unchecked"})
public class ReLogoTurtle extends BaseTurtle{

	/**
	 * Makes a number of new humans and then executes a set of commands on the
	 * created humans.
	 * 
	 * @param number
	 *            a number
	 * @param closure
	 *            a set of commands
	 * @return created humans
	 */
	@ReLogoBuilderGeneratedFor("migration.relogo.Human")
	public AgentSet<migration.relogo.Human> hatchHumans(int number, Closure closure) {
		AgentSet<migration.relogo.Human> result = new AgentSet<>();
		AgentSet<Turtle> createResult = this.hatch(number,closure,"Human");
		for (Turtle t : createResult){
			if (t instanceof migration.relogo.Human){
				result.add((migration.relogo.Human)t);
			}
		} 
		return result;
	}

	/**
	 * Makes a number of new humans and then executes a set of commands on the
	 * created humans.
	 * 
	 * @param number
	 *            a number
	 * @param closure
	 *            a set of commands
	 * @return created humans
	 */
	@ReLogoBuilderGeneratedFor("migration.relogo.Human")
	public AgentSet<migration.relogo.Human> hatchHumans(int number) {
		return hatchHumans(number,null);
	}

	/**
	 * Returns an agentset of humans from the patch of the caller.
	 * 
	 * @return agentset of humans from the caller's patch
	 */
	@ReLogoBuilderGeneratedFor("migration.relogo.Human")
	public AgentSet<migration.relogo.Human> humansHere(){
	  Grid grid = getMyObserver().getGrid();
	  GridPoint gridPoint = grid.getLocation(this);
	  AgentSet<migration.relogo.Human> result = new AgentSet<migration.relogo.Human>();
	  for (Turtle t : Utility.getTurtlesOnGridPoint(gridPoint,getMyObserver(),"human")){
			if (t instanceof migration.relogo.Human)
			result.add((migration.relogo.Human)t);
		}
		return result;
	}

	/**
	 * Returns the agentset of humans on the patch at the direction (ndx, ndy) from the
	 * caller.
	 * 
	 * @param nX
	 *            a number
	 * @param nY
	 *            a number
	 * @returns agentset of humans at the direction (nX, nY) from the caller
	 */
	@ReLogoBuilderGeneratedFor("migration.relogo.Human")
	public AgentSet<migration.relogo.Human> humansAt(Number nX, Number nY){
		double dx = nX.doubleValue();
		double dy = nY.doubleValue();
		double[] displacement = {dx,dy};

		try{
		GridPoint gridPoint = Utility.getGridPointAtDisplacement(getTurtleLocation(),displacement,getMyObserver());
		AgentSet<migration.relogo.Human> result = new AgentSet<migration.relogo.Human>();						
		for (Turtle t : Utility.getTurtlesOnGridPoint(gridPoint,getMyObserver(),"human")){
			if (t instanceof migration.relogo.Human)
			result.add((migration.relogo.Human)t);
		}
		return result;
		}
		catch(SpatialException e){
			return new AgentSet<migration.relogo.Human>();
		}
	}

	/**
	 * Returns an agentset of humans on a given patch.
	 * 
	 * @param p
	 *            a patch
	 * @return agentset of humans on patch p
	 */
	@ReLogoBuilderGeneratedFor("migration.relogo.Human")
	public AgentSet<migration.relogo.Human> humansOn(Patch p){
		AgentSet<migration.relogo.Human> result = new AgentSet<migration.relogo.Human>();						
		for (Turtle t : Utility.getTurtlesOnGridPoint(p.getGridLocation(),getMyObserver(),"human")){
			if (t instanceof migration.relogo.Human)
			result.add((migration.relogo.Human)t);
		}
		return result;
	}

	/**
	 * Returns an agentset of humans on the same patch as a turtle.
	 * 
	 * @param t
	 *            a turtle
	 * @return agentset of humans on the same patch as turtle t
	 */
	@ReLogoBuilderGeneratedFor("migration.relogo.Human")
	public AgentSet<migration.relogo.Human> humansOn(Turtle t){
		AgentSet<migration.relogo.Human> result = new AgentSet<migration.relogo.Human>();						
		for (Turtle tt : Utility.getTurtlesOnGridPoint(Utility.ndPointToGridPoint(t.getTurtleLocation()),getMyObserver(),"human")){
			if (tt instanceof migration.relogo.Human)
			result.add((migration.relogo.Human)tt);
		}
		return result;
	}

	/**
	 * Returns an agentset of humans on the patches in a collection or on the patches
	 * that a collection of turtles are.
	 * 
	 * @param a
	 *            a collection
	 * @return agentset of humans on the patches in collection a or on the patches
	 *         that collection a turtles are
	 */
	@ReLogoBuilderGeneratedFor("migration.relogo.Human")
	public AgentSet<migration.relogo.Human> humansOn(Collection c){

		if (c == null || c.isEmpty()){
			return new AgentSet<migration.relogo.Human>();
		}

		Set<migration.relogo.Human> total = new HashSet<migration.relogo.Human>();
		if (c.iterator().next() instanceof Turtle){
			for (Object o : c){
				if (o instanceof Turtle){
					Turtle t = (Turtle) o;
					total.addAll(humansOn(t));
				}
			}
		}
		else {
			for (Object o : c){
				if (o instanceof Patch){
					Patch p = (Patch) o;
					total.addAll(humansOn(p));
				}
			}
		}
		return new AgentSet<migration.relogo.Human>(total);
	}

	/**
	 * Queries if object is a human.
	 * 
	 * @param o
	 *            an object
	 * @return true or false based on whether the object is a human
	 */
	@ReLogoBuilderGeneratedFor("migration.relogo.Human")
	public boolean isHumanQ(Object o){
		return (o instanceof migration.relogo.Human);
	}

	/**
	 * Returns an agentset containing all humans.
	 * 
	 * @return agentset of all humans
	 */
	@ReLogoBuilderGeneratedFor("migration.relogo.Human")
	public AgentSet<migration.relogo.Human> humans(){
		AgentSet<migration.relogo.Human> a = new AgentSet<migration.relogo.Human>();
		for (Object e : this.getMyObserver().getContext().getObjects(migration.relogo.Human.class)) {
			if (e instanceof migration.relogo.Human){
				a.add((migration.relogo.Human)e);
			}
		}
		return a;
	}

	/**
	 * Returns the human with the given who number.
	 * 
	 * @param number
	 *            a number
	 * @return turtle number
	 */
	@ReLogoBuilderGeneratedFor("migration.relogo.Human")
	public migration.relogo.Human human(Number number){
		Turtle turtle = Utility.turtleU(number.intValue(), getMyObserver());
		if (turtle instanceof migration.relogo.Human)
			return (migration.relogo.Human) turtle;
		return null;
	}

	/**
	 * Makes a number of new maps and then executes a set of commands on the
	 * created maps.
	 * 
	 * @param number
	 *            a number
	 * @param closure
	 *            a set of commands
	 * @return created maps
	 */
	@ReLogoBuilderGeneratedFor("migration.relogo.Map")
	public AgentSet<migration.relogo.Map> hatchMaps(int number, Closure closure) {
		AgentSet<migration.relogo.Map> result = new AgentSet<>();
		AgentSet<Turtle> createResult = this.hatch(number,closure,"Map");
		for (Turtle t : createResult){
			if (t instanceof migration.relogo.Map){
				result.add((migration.relogo.Map)t);
			}
		} 
		return result;
	}

	/**
	 * Makes a number of new maps and then executes a set of commands on the
	 * created maps.
	 * 
	 * @param number
	 *            a number
	 * @param closure
	 *            a set of commands
	 * @return created maps
	 */
	@ReLogoBuilderGeneratedFor("migration.relogo.Map")
	public AgentSet<migration.relogo.Map> hatchMaps(int number) {
		return hatchMaps(number,null);
	}

	/**
	 * Returns an agentset of maps from the patch of the caller.
	 * 
	 * @return agentset of maps from the caller's patch
	 */
	@ReLogoBuilderGeneratedFor("migration.relogo.Map")
	public AgentSet<migration.relogo.Map> mapsHere(){
	  Grid grid = getMyObserver().getGrid();
	  GridPoint gridPoint = grid.getLocation(this);
	  AgentSet<migration.relogo.Map> result = new AgentSet<migration.relogo.Map>();
	  for (Turtle t : Utility.getTurtlesOnGridPoint(gridPoint,getMyObserver(),"map")){
			if (t instanceof migration.relogo.Map)
			result.add((migration.relogo.Map)t);
		}
		return result;
	}

	/**
	 * Returns the agentset of maps on the patch at the direction (ndx, ndy) from the
	 * caller.
	 * 
	 * @param nX
	 *            a number
	 * @param nY
	 *            a number
	 * @returns agentset of maps at the direction (nX, nY) from the caller
	 */
	@ReLogoBuilderGeneratedFor("migration.relogo.Map")
	public AgentSet<migration.relogo.Map> mapsAt(Number nX, Number nY){
		double dx = nX.doubleValue();
		double dy = nY.doubleValue();
		double[] displacement = {dx,dy};

		try{
		GridPoint gridPoint = Utility.getGridPointAtDisplacement(getTurtleLocation(),displacement,getMyObserver());
		AgentSet<migration.relogo.Map> result = new AgentSet<migration.relogo.Map>();						
		for (Turtle t : Utility.getTurtlesOnGridPoint(gridPoint,getMyObserver(),"map")){
			if (t instanceof migration.relogo.Map)
			result.add((migration.relogo.Map)t);
		}
		return result;
		}
		catch(SpatialException e){
			return new AgentSet<migration.relogo.Map>();
		}
	}

	/**
	 * Returns an agentset of maps on a given patch.
	 * 
	 * @param p
	 *            a patch
	 * @return agentset of maps on patch p
	 */
	@ReLogoBuilderGeneratedFor("migration.relogo.Map")
	public AgentSet<migration.relogo.Map> mapsOn(Patch p){
		AgentSet<migration.relogo.Map> result = new AgentSet<migration.relogo.Map>();						
		for (Turtle t : Utility.getTurtlesOnGridPoint(p.getGridLocation(),getMyObserver(),"map")){
			if (t instanceof migration.relogo.Map)
			result.add((migration.relogo.Map)t);
		}
		return result;
	}

	/**
	 * Returns an agentset of maps on the same patch as a turtle.
	 * 
	 * @param t
	 *            a turtle
	 * @return agentset of maps on the same patch as turtle t
	 */
	@ReLogoBuilderGeneratedFor("migration.relogo.Map")
	public AgentSet<migration.relogo.Map> mapsOn(Turtle t){
		AgentSet<migration.relogo.Map> result = new AgentSet<migration.relogo.Map>();						
		for (Turtle tt : Utility.getTurtlesOnGridPoint(Utility.ndPointToGridPoint(t.getTurtleLocation()),getMyObserver(),"map")){
			if (tt instanceof migration.relogo.Map)
			result.add((migration.relogo.Map)tt);
		}
		return result;
	}

	/**
	 * Returns an agentset of maps on the patches in a collection or on the patches
	 * that a collection of turtles are.
	 * 
	 * @param a
	 *            a collection
	 * @return agentset of maps on the patches in collection a or on the patches
	 *         that collection a turtles are
	 */
	@ReLogoBuilderGeneratedFor("migration.relogo.Map")
	public AgentSet<migration.relogo.Map> mapsOn(Collection c){

		if (c == null || c.isEmpty()){
			return new AgentSet<migration.relogo.Map>();
		}

		Set<migration.relogo.Map> total = new HashSet<migration.relogo.Map>();
		if (c.iterator().next() instanceof Turtle){
			for (Object o : c){
				if (o instanceof Turtle){
					Turtle t = (Turtle) o;
					total.addAll(mapsOn(t));
				}
			}
		}
		else {
			for (Object o : c){
				if (o instanceof Patch){
					Patch p = (Patch) o;
					total.addAll(mapsOn(p));
				}
			}
		}
		return new AgentSet<migration.relogo.Map>(total);
	}

	/**
	 * Queries if object is a map.
	 * 
	 * @param o
	 *            an object
	 * @return true or false based on whether the object is a map
	 */
	@ReLogoBuilderGeneratedFor("migration.relogo.Map")
	public boolean isMapQ(Object o){
		return (o instanceof migration.relogo.Map);
	}

	/**
	 * Returns an agentset containing all maps.
	 * 
	 * @return agentset of all maps
	 */
	@ReLogoBuilderGeneratedFor("migration.relogo.Map")
	public AgentSet<migration.relogo.Map> maps(){
		AgentSet<migration.relogo.Map> a = new AgentSet<migration.relogo.Map>();
		for (Object e : this.getMyObserver().getContext().getObjects(migration.relogo.Map.class)) {
			if (e instanceof migration.relogo.Map){
				a.add((migration.relogo.Map)e);
			}
		}
		return a;
	}

	/**
	 * Returns the map with the given who number.
	 * 
	 * @param number
	 *            a number
	 * @return turtle number
	 */
	@ReLogoBuilderGeneratedFor("migration.relogo.Map")
	public migration.relogo.Map map(Number number){
		Turtle turtle = Utility.turtleU(number.intValue(), getMyObserver());
		if (turtle instanceof migration.relogo.Map)
			return (migration.relogo.Map) turtle;
		return null;
	}

	/**
	 * Makes a number of new migrants and then executes a set of commands on the
	 * created migrants.
	 * 
	 * @param number
	 *            a number
	 * @param closure
	 *            a set of commands
	 * @return created migrants
	 */
	@ReLogoBuilderGeneratedFor("migration.relogo.Migrant")
	public AgentSet<migration.relogo.Migrant> hatchMigrants(int number, Closure closure) {
		AgentSet<migration.relogo.Migrant> result = new AgentSet<>();
		AgentSet<Turtle> createResult = this.hatch(number,closure,"Migrant");
		for (Turtle t : createResult){
			if (t instanceof migration.relogo.Migrant){
				result.add((migration.relogo.Migrant)t);
			}
		} 
		return result;
	}

	/**
	 * Makes a number of new migrants and then executes a set of commands on the
	 * created migrants.
	 * 
	 * @param number
	 *            a number
	 * @param closure
	 *            a set of commands
	 * @return created migrants
	 */
	@ReLogoBuilderGeneratedFor("migration.relogo.Migrant")
	public AgentSet<migration.relogo.Migrant> hatchMigrants(int number) {
		return hatchMigrants(number,null);
	}

	/**
	 * Returns an agentset of migrants from the patch of the caller.
	 * 
	 * @return agentset of migrants from the caller's patch
	 */
	@ReLogoBuilderGeneratedFor("migration.relogo.Migrant")
	public AgentSet<migration.relogo.Migrant> migrantsHere(){
	  Grid grid = getMyObserver().getGrid();
	  GridPoint gridPoint = grid.getLocation(this);
	  AgentSet<migration.relogo.Migrant> result = new AgentSet<migration.relogo.Migrant>();
	  for (Turtle t : Utility.getTurtlesOnGridPoint(gridPoint,getMyObserver(),"migrant")){
			if (t instanceof migration.relogo.Migrant)
			result.add((migration.relogo.Migrant)t);
		}
		return result;
	}

	/**
	 * Returns the agentset of migrants on the patch at the direction (ndx, ndy) from the
	 * caller.
	 * 
	 * @param nX
	 *            a number
	 * @param nY
	 *            a number
	 * @returns agentset of migrants at the direction (nX, nY) from the caller
	 */
	@ReLogoBuilderGeneratedFor("migration.relogo.Migrant")
	public AgentSet<migration.relogo.Migrant> migrantsAt(Number nX, Number nY){
		double dx = nX.doubleValue();
		double dy = nY.doubleValue();
		double[] displacement = {dx,dy};

		try{
		GridPoint gridPoint = Utility.getGridPointAtDisplacement(getTurtleLocation(),displacement,getMyObserver());
		AgentSet<migration.relogo.Migrant> result = new AgentSet<migration.relogo.Migrant>();						
		for (Turtle t : Utility.getTurtlesOnGridPoint(gridPoint,getMyObserver(),"migrant")){
			if (t instanceof migration.relogo.Migrant)
			result.add((migration.relogo.Migrant)t);
		}
		return result;
		}
		catch(SpatialException e){
			return new AgentSet<migration.relogo.Migrant>();
		}
	}

	/**
	 * Returns an agentset of migrants on a given patch.
	 * 
	 * @param p
	 *            a patch
	 * @return agentset of migrants on patch p
	 */
	@ReLogoBuilderGeneratedFor("migration.relogo.Migrant")
	public AgentSet<migration.relogo.Migrant> migrantsOn(Patch p){
		AgentSet<migration.relogo.Migrant> result = new AgentSet<migration.relogo.Migrant>();						
		for (Turtle t : Utility.getTurtlesOnGridPoint(p.getGridLocation(),getMyObserver(),"migrant")){
			if (t instanceof migration.relogo.Migrant)
			result.add((migration.relogo.Migrant)t);
		}
		return result;
	}

	/**
	 * Returns an agentset of migrants on the same patch as a turtle.
	 * 
	 * @param t
	 *            a turtle
	 * @return agentset of migrants on the same patch as turtle t
	 */
	@ReLogoBuilderGeneratedFor("migration.relogo.Migrant")
	public AgentSet<migration.relogo.Migrant> migrantsOn(Turtle t){
		AgentSet<migration.relogo.Migrant> result = new AgentSet<migration.relogo.Migrant>();						
		for (Turtle tt : Utility.getTurtlesOnGridPoint(Utility.ndPointToGridPoint(t.getTurtleLocation()),getMyObserver(),"migrant")){
			if (tt instanceof migration.relogo.Migrant)
			result.add((migration.relogo.Migrant)tt);
		}
		return result;
	}

	/**
	 * Returns an agentset of migrants on the patches in a collection or on the patches
	 * that a collection of turtles are.
	 * 
	 * @param a
	 *            a collection
	 * @return agentset of migrants on the patches in collection a or on the patches
	 *         that collection a turtles are
	 */
	@ReLogoBuilderGeneratedFor("migration.relogo.Migrant")
	public AgentSet<migration.relogo.Migrant> migrantsOn(Collection c){

		if (c == null || c.isEmpty()){
			return new AgentSet<migration.relogo.Migrant>();
		}

		Set<migration.relogo.Migrant> total = new HashSet<migration.relogo.Migrant>();
		if (c.iterator().next() instanceof Turtle){
			for (Object o : c){
				if (o instanceof Turtle){
					Turtle t = (Turtle) o;
					total.addAll(migrantsOn(t));
				}
			}
		}
		else {
			for (Object o : c){
				if (o instanceof Patch){
					Patch p = (Patch) o;
					total.addAll(migrantsOn(p));
				}
			}
		}
		return new AgentSet<migration.relogo.Migrant>(total);
	}

	/**
	 * Queries if object is a migrant.
	 * 
	 * @param o
	 *            an object
	 * @return true or false based on whether the object is a migrant
	 */
	@ReLogoBuilderGeneratedFor("migration.relogo.Migrant")
	public boolean isMigrantQ(Object o){
		return (o instanceof migration.relogo.Migrant);
	}

	/**
	 * Returns an agentset containing all migrants.
	 * 
	 * @return agentset of all migrants
	 */
	@ReLogoBuilderGeneratedFor("migration.relogo.Migrant")
	public AgentSet<migration.relogo.Migrant> migrants(){
		AgentSet<migration.relogo.Migrant> a = new AgentSet<migration.relogo.Migrant>();
		for (Object e : this.getMyObserver().getContext().getObjects(migration.relogo.Migrant.class)) {
			if (e instanceof migration.relogo.Migrant){
				a.add((migration.relogo.Migrant)e);
			}
		}
		return a;
	}

	/**
	 * Returns the migrant with the given who number.
	 * 
	 * @param number
	 *            a number
	 * @return turtle number
	 */
	@ReLogoBuilderGeneratedFor("migration.relogo.Migrant")
	public migration.relogo.Migrant migrant(Number number){
		Turtle turtle = Utility.turtleU(number.intValue(), getMyObserver());
		if (turtle instanceof migration.relogo.Migrant)
			return (migration.relogo.Migrant) turtle;
		return null;
	}

	/**
	 * Makes a number of new userTurtles and then executes a set of commands on the
	 * created userTurtles.
	 * 
	 * @param number
	 *            a number
	 * @param closure
	 *            a set of commands
	 * @return created userTurtles
	 */
	@ReLogoBuilderGeneratedFor("migration.relogo.UserTurtle")
	public AgentSet<migration.relogo.UserTurtle> hatchUserTurtles(int number, Closure closure) {
		AgentSet<migration.relogo.UserTurtle> result = new AgentSet<>();
		AgentSet<Turtle> createResult = this.hatch(number,closure,"UserTurtle");
		for (Turtle t : createResult){
			if (t instanceof migration.relogo.UserTurtle){
				result.add((migration.relogo.UserTurtle)t);
			}
		} 
		return result;
	}

	/**
	 * Makes a number of new userTurtles and then executes a set of commands on the
	 * created userTurtles.
	 * 
	 * @param number
	 *            a number
	 * @param closure
	 *            a set of commands
	 * @return created userTurtles
	 */
	@ReLogoBuilderGeneratedFor("migration.relogo.UserTurtle")
	public AgentSet<migration.relogo.UserTurtle> hatchUserTurtles(int number) {
		return hatchUserTurtles(number,null);
	}

	/**
	 * Returns an agentset of userTurtles from the patch of the caller.
	 * 
	 * @return agentset of userTurtles from the caller's patch
	 */
	@ReLogoBuilderGeneratedFor("migration.relogo.UserTurtle")
	public AgentSet<migration.relogo.UserTurtle> userTurtlesHere(){
	  Grid grid = getMyObserver().getGrid();
	  GridPoint gridPoint = grid.getLocation(this);
	  AgentSet<migration.relogo.UserTurtle> result = new AgentSet<migration.relogo.UserTurtle>();
	  for (Turtle t : Utility.getTurtlesOnGridPoint(gridPoint,getMyObserver(),"userTurtle")){
			if (t instanceof migration.relogo.UserTurtle)
			result.add((migration.relogo.UserTurtle)t);
		}
		return result;
	}

	/**
	 * Returns the agentset of userTurtles on the patch at the direction (ndx, ndy) from the
	 * caller.
	 * 
	 * @param nX
	 *            a number
	 * @param nY
	 *            a number
	 * @returns agentset of userTurtles at the direction (nX, nY) from the caller
	 */
	@ReLogoBuilderGeneratedFor("migration.relogo.UserTurtle")
	public AgentSet<migration.relogo.UserTurtle> userTurtlesAt(Number nX, Number nY){
		double dx = nX.doubleValue();
		double dy = nY.doubleValue();
		double[] displacement = {dx,dy};

		try{
		GridPoint gridPoint = Utility.getGridPointAtDisplacement(getTurtleLocation(),displacement,getMyObserver());
		AgentSet<migration.relogo.UserTurtle> result = new AgentSet<migration.relogo.UserTurtle>();						
		for (Turtle t : Utility.getTurtlesOnGridPoint(gridPoint,getMyObserver(),"userTurtle")){
			if (t instanceof migration.relogo.UserTurtle)
			result.add((migration.relogo.UserTurtle)t);
		}
		return result;
		}
		catch(SpatialException e){
			return new AgentSet<migration.relogo.UserTurtle>();
		}
	}

	/**
	 * Returns an agentset of userTurtles on a given patch.
	 * 
	 * @param p
	 *            a patch
	 * @return agentset of userTurtles on patch p
	 */
	@ReLogoBuilderGeneratedFor("migration.relogo.UserTurtle")
	public AgentSet<migration.relogo.UserTurtle> userTurtlesOn(Patch p){
		AgentSet<migration.relogo.UserTurtle> result = new AgentSet<migration.relogo.UserTurtle>();						
		for (Turtle t : Utility.getTurtlesOnGridPoint(p.getGridLocation(),getMyObserver(),"userTurtle")){
			if (t instanceof migration.relogo.UserTurtle)
			result.add((migration.relogo.UserTurtle)t);
		}
		return result;
	}

	/**
	 * Returns an agentset of userTurtles on the same patch as a turtle.
	 * 
	 * @param t
	 *            a turtle
	 * @return agentset of userTurtles on the same patch as turtle t
	 */
	@ReLogoBuilderGeneratedFor("migration.relogo.UserTurtle")
	public AgentSet<migration.relogo.UserTurtle> userTurtlesOn(Turtle t){
		AgentSet<migration.relogo.UserTurtle> result = new AgentSet<migration.relogo.UserTurtle>();						
		for (Turtle tt : Utility.getTurtlesOnGridPoint(Utility.ndPointToGridPoint(t.getTurtleLocation()),getMyObserver(),"userTurtle")){
			if (tt instanceof migration.relogo.UserTurtle)
			result.add((migration.relogo.UserTurtle)tt);
		}
		return result;
	}

	/**
	 * Returns an agentset of userTurtles on the patches in a collection or on the patches
	 * that a collection of turtles are.
	 * 
	 * @param a
	 *            a collection
	 * @return agentset of userTurtles on the patches in collection a or on the patches
	 *         that collection a turtles are
	 */
	@ReLogoBuilderGeneratedFor("migration.relogo.UserTurtle")
	public AgentSet<migration.relogo.UserTurtle> userTurtlesOn(Collection c){

		if (c == null || c.isEmpty()){
			return new AgentSet<migration.relogo.UserTurtle>();
		}

		Set<migration.relogo.UserTurtle> total = new HashSet<migration.relogo.UserTurtle>();
		if (c.iterator().next() instanceof Turtle){
			for (Object o : c){
				if (o instanceof Turtle){
					Turtle t = (Turtle) o;
					total.addAll(userTurtlesOn(t));
				}
			}
		}
		else {
			for (Object o : c){
				if (o instanceof Patch){
					Patch p = (Patch) o;
					total.addAll(userTurtlesOn(p));
				}
			}
		}
		return new AgentSet<migration.relogo.UserTurtle>(total);
	}

	/**
	 * Queries if object is a userTurtle.
	 * 
	 * @param o
	 *            an object
	 * @return true or false based on whether the object is a userTurtle
	 */
	@ReLogoBuilderGeneratedFor("migration.relogo.UserTurtle")
	public boolean isUserTurtleQ(Object o){
		return (o instanceof migration.relogo.UserTurtle);
	}

	/**
	 * Returns an agentset containing all userTurtles.
	 * 
	 * @return agentset of all userTurtles
	 */
	@ReLogoBuilderGeneratedFor("migration.relogo.UserTurtle")
	public AgentSet<migration.relogo.UserTurtle> userTurtles(){
		AgentSet<migration.relogo.UserTurtle> a = new AgentSet<migration.relogo.UserTurtle>();
		for (Object e : this.getMyObserver().getContext().getObjects(migration.relogo.UserTurtle.class)) {
			if (e instanceof migration.relogo.UserTurtle){
				a.add((migration.relogo.UserTurtle)e);
			}
		}
		return a;
	}

	/**
	 * Returns the userTurtle with the given who number.
	 * 
	 * @param number
	 *            a number
	 * @return turtle number
	 */
	@ReLogoBuilderGeneratedFor("migration.relogo.UserTurtle")
	public migration.relogo.UserTurtle userTurtle(Number number){
		Turtle turtle = Utility.turtleU(number.intValue(), getMyObserver());
		if (turtle instanceof migration.relogo.UserTurtle)
			return (migration.relogo.UserTurtle) turtle;
		return null;
	}

	/**
	 * Returns the value from the getName() method of the underlying patch.
	 * 
	 * @return getName() of type java.lang.Object
	 */
	@ReLogoBuilderGeneratedFor("migration.relogo.UserPatch")
	public java.lang.Object getName(){
		migration.relogo.UserPatch p = (migration.relogo.UserPatch)patchHere();
		return p.getName();
	}

	/**
	 * Calls the setName(java.lang.Object) method of the underlying patch.
	 * 
	 */
	@ReLogoBuilderGeneratedFor("migration.relogo.UserPatch")
	public void setName(java.lang.Object value){
		migration.relogo.UserPatch p = (migration.relogo.UserPatch)patchHere();
		p.setName(value);
	}

	/**
	 * Returns the value from the getPopulation() method of the underlying patch.
	 * 
	 * @return getPopulation() of type java.lang.Object
	 */
	@ReLogoBuilderGeneratedFor("migration.relogo.UserPatch")
	public java.lang.Object getPopulation(){
		migration.relogo.UserPatch p = (migration.relogo.UserPatch)patchHere();
		return p.getPopulation();
	}

	/**
	 * Calls the setPopulation(java.lang.Object) method of the underlying patch.
	 * 
	 */
	@ReLogoBuilderGeneratedFor("migration.relogo.UserPatch")
	public void setPopulation(java.lang.Object value){
		migration.relogo.UserPatch p = (migration.relogo.UserPatch)patchHere();
		p.setPopulation(value);
	}

	/**
	 * Returns the value from the getMigrants() method of the underlying patch.
	 * 
	 * @return getMigrants() of type java.lang.Object
	 */
	@ReLogoBuilderGeneratedFor("migration.relogo.UserPatch")
	public java.lang.Object getMigrants(){
		migration.relogo.UserPatch p = (migration.relogo.UserPatch)patchHere();
		return p.getMigrants();
	}

	/**
	 * Calls the setMigrants(java.lang.Object) method of the underlying patch.
	 * 
	 */
	@ReLogoBuilderGeneratedFor("migration.relogo.UserPatch")
	public void setMigrants(java.lang.Object value){
		migration.relogo.UserPatch p = (migration.relogo.UserPatch)patchHere();
		p.setMigrants(value);
	}

	/**
	 * Returns the value from the getGdp() method of the underlying patch.
	 * 
	 * @return getGdp() of type java.lang.Object
	 */
	@ReLogoBuilderGeneratedFor("migration.relogo.UserPatch")
	public java.lang.Object getGdp(){
		migration.relogo.UserPatch p = (migration.relogo.UserPatch)patchHere();
		return p.getGdp();
	}

	/**
	 * Calls the setGdp(java.lang.Object) method of the underlying patch.
	 * 
	 */
	@ReLogoBuilderGeneratedFor("migration.relogo.UserPatch")
	public void setGdp(java.lang.Object value){
		migration.relogo.UserPatch p = (migration.relogo.UserPatch)patchHere();
		p.setGdp(value);
	}

	/**
	 * Returns the value from the getUnemployment() method of the underlying patch.
	 * 
	 * @return getUnemployment() of type java.lang.Object
	 */
	@ReLogoBuilderGeneratedFor("migration.relogo.UserPatch")
	public java.lang.Object getUnemployment(){
		migration.relogo.UserPatch p = (migration.relogo.UserPatch)patchHere();
		return p.getUnemployment();
	}

	/**
	 * Calls the setUnemployment(java.lang.Object) method of the underlying patch.
	 * 
	 */
	@ReLogoBuilderGeneratedFor("migration.relogo.UserPatch")
	public void setUnemployment(java.lang.Object value){
		migration.relogo.UserPatch p = (migration.relogo.UserPatch)patchHere();
		p.setUnemployment(value);
	}

	/**
	 * Returns the value from the getCoeff() method of the underlying patch.
	 * 
	 * @return getCoeff() of type java.lang.Object
	 */
	@ReLogoBuilderGeneratedFor("migration.relogo.UserPatch")
	public java.lang.Object getCoeff(){
		migration.relogo.UserPatch p = (migration.relogo.UserPatch)patchHere();
		return p.getCoeff();
	}

	/**
	 * Calls the setCoeff(java.lang.Object) method of the underlying patch.
	 * 
	 */
	@ReLogoBuilderGeneratedFor("migration.relogo.UserPatch")
	public void setCoeff(java.lang.Object value){
		migration.relogo.UserPatch p = (migration.relogo.UserPatch)patchHere();
		p.setCoeff(value);
	}

	/**
	 * Returns the value from the getAttr() method of the underlying patch.
	 * 
	 * @return getAttr() of type java.lang.Object
	 */
	@ReLogoBuilderGeneratedFor("migration.relogo.UserPatch")
	public java.lang.Object getAttr(){
		migration.relogo.UserPatch p = (migration.relogo.UserPatch)patchHere();
		return p.getAttr();
	}

	/**
	 * Calls the setAttr(java.lang.Object) method of the underlying patch.
	 * 
	 */
	@ReLogoBuilderGeneratedFor("migration.relogo.UserPatch")
	public void setAttr(java.lang.Object value){
		migration.relogo.UserPatch p = (migration.relogo.UserPatch)patchHere();
		p.setAttr(value);
	}

	/**
	 * Returns the value from the getPrev_gdp() method of the underlying patch.
	 * 
	 * @return getPrev_gdp() of type java.lang.Object
	 */
	@ReLogoBuilderGeneratedFor("migration.relogo.UserPatch")
	public java.lang.Object getPrev_gdp(){
		migration.relogo.UserPatch p = (migration.relogo.UserPatch)patchHere();
		return p.getPrev_gdp();
	}

	/**
	 * Calls the setPrev_gdp(java.lang.Object) method of the underlying patch.
	 * 
	 */
	@ReLogoBuilderGeneratedFor("migration.relogo.UserPatch")
	public void setPrev_gdp(java.lang.Object value){
		migration.relogo.UserPatch p = (migration.relogo.UserPatch)patchHere();
		p.setPrev_gdp(value);
	}

	/**
	 * Makes a directed userLink from a turtle to the caller then executes a set of
	 * commands on the created userLink.
	 * 
	 * @param t
	 *            a turtle
	 * @param closure
	 *            a set of commands
	 * @return created userLink
	 */
	@ReLogoBuilderGeneratedFor("migration.relogo.UserLink")
	public migration.relogo.UserLink createUserLinkFrom(Turtle t, Closure closure){
		migration.relogo.UserLink link = (migration.relogo.UserLink)this.getMyObserver().getNetwork("UserLink").addEdge(t,this);
		if (closure != null){
			this.ask(link,closure);
		}
		return link;
	}

	/**
	 * Makes a directed userLink from a turtle to the caller.
	 * 
	 * @param t
	 *            a turtle
	 * @return created userLink
	 */
	@ReLogoBuilderGeneratedFor("migration.relogo.UserLink")
	public migration.relogo.UserLink createUserLinkFrom(Turtle t){
			return createUserLinkFrom(t,null);
	}

	/**
	 * Makes directed userLinks from a collection to the caller then executes a set
	 * of commands on the created userLinks.
	 * 
	 * @param a
	 *            a collection
	 * @param closure
	 *            a set of commands
	 * @return created userLinks
	 */
	@ReLogoBuilderGeneratedFor("migration.relogo.UserLink")
	public AgentSet<migration.relogo.UserLink> createUserLinksFrom(Collection<? extends Turtle> a, Closure closure){
		AgentSet<migration.relogo.UserLink> links = new AgentSet<migration.relogo.UserLink>();
		for(Turtle t : a){
			links.add((migration.relogo.UserLink)this.getMyObserver().getNetwork("UserLink").addEdge(t,this));
		}
		if (closure != null){
			this.ask(links,closure);
		}
		return links;
	}

	/**
	 * Makes directed userLinks from a collection to the caller.
	 * 
	 * @param a
	 *            a collection
	 * @return created userLinks
	 */
	@ReLogoBuilderGeneratedFor("migration.relogo.UserLink")
	public AgentSet<migration.relogo.UserLink> createUserLinksFrom(Collection<? extends Turtle> a){
		return createUserLinksFrom(a,null);
	}

	/**
	 * Makes a directed userLink to a turtle from the caller then executes a set of
	 * commands on the created userLink.
	 * 
	 * @param t
	 *            a turtle
	 * @param closure
	 *            a set of commands
	 * @return created userLink
	 */
	@ReLogoBuilderGeneratedFor("migration.relogo.UserLink")
	public migration.relogo.UserLink createUserLinkTo(Turtle t, Closure closure){
		migration.relogo.UserLink link = (migration.relogo.UserLink)this.getMyObserver().getNetwork("UserLink").addEdge(this,t);
		if (closure != null){
			this.ask(link,closure);
		}
		return link;
	}

	/**
	 * Makes a directed userLink to a turtle from the caller.
	 * 
	 * @param t
	 *            a turtle
	 * @return created userLink
	 */
	@ReLogoBuilderGeneratedFor("migration.relogo.UserLink")
	public migration.relogo.UserLink createUserLinkTo(Turtle t){
			return createUserLinkTo(t,null);
	}

	/**
	 * Makes directed userLinks to a collection from the caller then executes a set
	 * of commands on the created userLinks.
	 * 
	 * @param a
	 *            a collection
	 * @param closure
	 *            a set of commands
	 * @return created userLinks
	 */
	@ReLogoBuilderGeneratedFor("migration.relogo.UserLink")
	public AgentSet<migration.relogo.UserLink> createUserLinksTo(Collection<? extends Turtle> a, Closure closure){
		AgentSet<migration.relogo.UserLink> links = new AgentSet<migration.relogo.UserLink>();
		for(Object t : a){
			if (t instanceof Turtle){
				links.add((migration.relogo.UserLink)this.getMyObserver().getNetwork("UserLink").addEdge(this,(Turtle)t));
			}
		}
		if (closure != null){
			this.ask(links,closure);
		}
		return links;
	}

	/**
	 * Makes directed userLinks to a collection from the caller.
	 * 
	 * @param a
	 *            a collection
	 * @return created userLinks
	 */
	@ReLogoBuilderGeneratedFor("migration.relogo.UserLink")
	public AgentSet<migration.relogo.UserLink> createUserLinksTo(Collection<? extends Turtle> a){
		return createUserLinksTo(a,null);
	}

	/**
	 * Queries if there is a directed userLink from a turtle to the caller.
	 * 
	 * @param t
	 *            a turtle
	 * @return true or false based on whether there is a directed userLink from
	 *         turtle t to the caller
	 */
	@ReLogoBuilderGeneratedFor("migration.relogo.UserLink")
	public boolean inUserLinkNeighborQ(Turtle t){
		return this.getMyObserver().getNetwork("UserLink").isPredecessor(t, this);
	}

	/**
	 * Returns the agentset with directed userLinks to the caller.
	 * 
	 * @return agentset with directed userLinks to the caller
	 */
	@ReLogoBuilderGeneratedFor("migration.relogo.UserLink")
	public AgentSet inUserLinkNeighbors(){
		AgentSet result = new AgentSet();
		for(Object o : this.getMyObserver().getNetwork("UserLink").getPredecessors(this)){
			result.add(o);
		}
		return result;
	}

	/**
	 * Returns the directed userLink from a turtle to the caller.
	 * 
	 * @param t
	 *            a turtle
	 * @return directed userLink from turtle t to the caller
	 */
	@ReLogoBuilderGeneratedFor("migration.relogo.UserLink")
	public migration.relogo.UserLink inUserLinkFrom(Turtle t){
		return (migration.relogo.UserLink)this.getMyObserver().getNetwork("UserLink").getEdge(t,this);
	}

	/**
	 * Returns an agentset of directed userLinks from other turtles to the caller.
	 * 
	 * @return agentset of directed userLinks from other turtles to the caller
	 */
	@ReLogoBuilderGeneratedFor("migration.relogo.UserLink")
	public AgentSet<migration.relogo.UserLink> myInUserLinks(){
		AgentSet<migration.relogo.UserLink> result = new AgentSet<migration.relogo.UserLink>();
		for(Object o :  this.getMyObserver().getNetwork("UserLink").getInEdges(this)){
			if (o instanceof migration.relogo.UserLink){
				result.add((migration.relogo.UserLink) o);
			}
		}
		return result;
	}

	/**
	 * Returns an agentset of directed userLinks to other turtles from the caller.
	 * 
	 * @return agentset of directed userLinks to other turtles from the caller
	 */
	@ReLogoBuilderGeneratedFor("migration.relogo.UserLink")
	public AgentSet<migration.relogo.UserLink> myOutUserLinks(){
		AgentSet<migration.relogo.UserLink> result = new AgentSet<migration.relogo.UserLink>();
		for(Object o :  this.getMyObserver().getNetwork("UserLink").getOutEdges(this)){
			if (o instanceof migration.relogo.UserLink){
				result.add((migration.relogo.UserLink) o);
			}
		}
		return result;
	}

	/**
	 * Queries if there is a directed userLink to a turtle from the caller.
	 * 
	 * @param t
	 *            a turtle
	 * @return true or false based on whether there is a directed userLink to
	 *         turtle t from the caller
	 */
	@ReLogoBuilderGeneratedFor("migration.relogo.UserLink")
	public boolean outUserLinkNeighborQ(Turtle t){
		return this.getMyObserver().getNetwork("UserLink").isPredecessor(this, t);
	}

	/**
	 * Returns the agentset with directed userLinks from the caller.
	 * 
	 * @return agentset with directed userLinks from the caller
	 */
	@ReLogoBuilderGeneratedFor("migration.relogo.UserLink")
	public AgentSet outUserLinkNeighbors(){
		AgentSet result = new AgentSet();
		for(Object o : this.getMyObserver().getNetwork("UserLink").getSuccessors(this)){
			result.add(o);
		}
		return result;
	}

	/**
	 * Returns the directed userLink to a turtle from the caller.
	 * 
	 * @param t
	 *            a turtle
	 * @return directed userLink to turtle t from the caller
	 */
	@ReLogoBuilderGeneratedFor("migration.relogo.UserLink")
	public migration.relogo.UserLink outUserLinkTo(Turtle t){
		return (migration.relogo.UserLink)this.getMyObserver().getNetwork("UserLink").getEdge(this, t);
	}

	/**
	 * Reports true if there is a userLink connecting t and the caller.
	 */
	@ReLogoBuilderGeneratedFor("migration.relogo.UserLink")
	public boolean userLinkNeighborQ(Turtle t){
		return this.getMyObserver().getNetwork("UserLink").isAdjacent(this, t);
	}

	/**
	 * Returns the agentset of all turtles found at the other end of
	 * userLinks connected to the calling turtle.
	 */
	@ReLogoBuilderGeneratedFor("migration.relogo.UserLink")
	public AgentSet userLinkNeighbors(){
		AgentSet result = new AgentSet();
		for(Object o : this.getMyObserver().getNetwork("UserLink").getAdjacent(this)){
			result.add(o);
		}
		return result;
	}

	/**
	 * Returns an agentset of the caller's userLinks.
	 * 
	 * @return agentset of the caller's userLinks
	 */
	@ReLogoBuilderGeneratedFor("migration.relogo.UserLink")
	public AgentSet<migration.relogo.UserLink> myUserLinks(){
		AgentSet<migration.relogo.UserLink> result = new AgentSet<migration.relogo.UserLink>();
		for(Object o : this.getMyObserver().getNetwork("UserLink").getEdges(this)){
			if (o instanceof migration.relogo.UserLink){
				result.add((migration.relogo.UserLink)o);
			}
		}
		return result;
	}

	/**
	 * Queries if object is a userLink.
	 * 
	 * @param o
	 *            an object
	 * @return true or false based on whether the object is a userLink
	 */
	@ReLogoBuilderGeneratedFor("migration.relogo.UserLink")
	public boolean isUserLinkQ(Object o){
		return (o instanceof migration.relogo.UserLink);
	}

	/**
	 * Returns an agentset containing all userLinks.
	 * 
	 * @return agentset of all userLinks
	 */
	@ReLogoBuilderGeneratedFor("migration.relogo.UserLink")
	public AgentSet<migration.relogo.UserLink> userLinks(){
		AgentSet<migration.relogo.UserLink> a = new AgentSet<migration.relogo.UserLink>();
		for (Object e : this.getMyObserver().getContext().getObjects(migration.relogo.UserLink.class)) {
			if (e instanceof migration.relogo.UserLink){
				a.add((migration.relogo.UserLink)e);
			}
		}
		return a;
	}

	/**
	 * Returns the userLink between two turtles.
	 * 
	 * @param oneEnd
	 *            an integer
	 * @param otherEnd
	 *            an integer
	 * @return userLink between two turtles
	 */
	@ReLogoBuilderGeneratedFor("migration.relogo.UserLink")
	public migration.relogo.UserLink userLink(Number oneEnd, Number otherEnd) {
		return (migration.relogo.UserLink)(this.getMyObserver().getNetwork("UserLink").getEdge(turtle(oneEnd),turtle(otherEnd)));
	}

	/**
	 * Returns the userLink between two turtles.
	 * 
	 * @param oneEnd
	 *            a turtle
	 * @param otherEnd
	 *            a turtle
	 * @return userLink between two turtles
	 */
	@ReLogoBuilderGeneratedFor("migration.relogo.UserLink")
	public migration.relogo.UserLink userLink(Turtle oneEnd, Turtle otherEnd) {
		return userLink(oneEnd.getWho(), otherEnd.getWho());
	}

	/**
	 * Returns the value of the global variable countriesList.
	 *
	 * @return the value of the global variable countriesList
	 */
	@ReLogoBuilderGeneratedFor("global: countriesList")
	public Object getCountriesList(){
		return repast.simphony.relogo.ReLogoModel.getInstance().getModelParam("countriesList");
	}

	/**
	 * Sets the value of the global variable countriesList.
	 *
	 * @param value
	 *            a value
	 */
	@ReLogoBuilderGeneratedFor("global: countriesList")
	public void setCountriesList(Object value){
		repast.simphony.relogo.ReLogoModel.getInstance().setModelParam("countriesList",value);
	}

	/**
	 * Returns the value of the global variable gdp_weight.
	 *
	 * @return the value of the global variable gdp_weight
	 */
	@ReLogoBuilderGeneratedFor("global: gdp_weight")
	public Object getGdp_weight(){
		return repast.simphony.relogo.ReLogoModel.getInstance().getModelParam("gdp_weight");
	}

	/**
	 * Sets the value of the global variable gdp_weight.
	 *
	 * @param value
	 *            a value
	 */
	@ReLogoBuilderGeneratedFor("global: gdp_weight")
	public void setGdp_weight(Object value){
		repast.simphony.relogo.ReLogoModel.getInstance().setModelParam("gdp_weight",value);
	}

	/**
	 * Returns the value of the global variable unmpl_weight.
	 *
	 * @return the value of the global variable unmpl_weight
	 */
	@ReLogoBuilderGeneratedFor("global: unmpl_weight")
	public Object getUnmpl_weight(){
		return repast.simphony.relogo.ReLogoModel.getInstance().getModelParam("unmpl_weight");
	}

	/**
	 * Sets the value of the global variable unmpl_weight.
	 *
	 * @param value
	 *            a value
	 */
	@ReLogoBuilderGeneratedFor("global: unmpl_weight")
	public void setUnmpl_weight(Object value){
		repast.simphony.relogo.ReLogoModel.getInstance().setModelParam("unmpl_weight",value);
	}

	/**
	 * Returns the value of the global variable rnd_weight.
	 *
	 * @return the value of the global variable rnd_weight
	 */
	@ReLogoBuilderGeneratedFor("global: rnd_weight")
	public Object getRnd_weight(){
		return repast.simphony.relogo.ReLogoModel.getInstance().getModelParam("rnd_weight");
	}

	/**
	 * Sets the value of the global variable rnd_weight.
	 *
	 * @param value
	 *            a value
	 */
	@ReLogoBuilderGeneratedFor("global: rnd_weight")
	public void setRnd_weight(Object value){
		repast.simphony.relogo.ReLogoModel.getInstance().setModelParam("rnd_weight",value);
	}

	/**
	 * Returns the value of the global variable migrants_weight.
	 *
	 * @return the value of the global variable migrants_weight
	 */
	@ReLogoBuilderGeneratedFor("global: migrants_weight")
	public Object getMigrants_weight(){
		return repast.simphony.relogo.ReLogoModel.getInstance().getModelParam("migrants_weight");
	}

	/**
	 * Sets the value of the global variable migrants_weight.
	 *
	 * @param value
	 *            a value
	 */
	@ReLogoBuilderGeneratedFor("global: migrants_weight")
	public void setMigrants_weight(Object value){
		repast.simphony.relogo.ReLogoModel.getInstance().setModelParam("migrants_weight",value);
	}

	/**
	 * Returns the value of the global variable attr_const.
	 *
	 * @return the value of the global variable attr_const
	 */
	@ReLogoBuilderGeneratedFor("global: attr_const")
	public Object getAttr_const(){
		return repast.simphony.relogo.ReLogoModel.getInstance().getModelParam("attr_const");
	}

	/**
	 * Sets the value of the global variable attr_const.
	 *
	 * @param value
	 *            a value
	 */
	@ReLogoBuilderGeneratedFor("global: attr_const")
	public void setAttr_const(Object value){
		repast.simphony.relogo.ReLogoModel.getInstance().setModelParam("attr_const",value);
	}

	/**
	 * Returns the value of the global variable curiosity_prob.
	 *
	 * @return the value of the global variable curiosity_prob
	 */
	@ReLogoBuilderGeneratedFor("global: curiosity_prob")
	public Object getCuriosity_prob(){
		return repast.simphony.relogo.ReLogoModel.getInstance().getModelParam("curiosity_prob");
	}

	/**
	 * Sets the value of the global variable curiosity_prob.
	 *
	 * @param value
	 *            a value
	 */
	@ReLogoBuilderGeneratedFor("global: curiosity_prob")
	public void setCuriosity_prob(Object value){
		repast.simphony.relogo.ReLogoModel.getInstance().setModelParam("curiosity_prob",value);
	}

	/**
	 * Returns the value of the global variable emig_weight.
	 *
	 * @return the value of the global variable emig_weight
	 */
	@ReLogoBuilderGeneratedFor("global: emig_weight")
	public Object getEmig_weight(){
		return repast.simphony.relogo.ReLogoModel.getInstance().getModelParam("emig_weight");
	}

	/**
	 * Sets the value of the global variable emig_weight.
	 *
	 * @param value
	 *            a value
	 */
	@ReLogoBuilderGeneratedFor("global: emig_weight")
	public void setEmig_weight(Object value){
		repast.simphony.relogo.ReLogoModel.getInstance().setModelParam("emig_weight",value);
	}

	/**
	 * Returns the value of the global variable turtle_mult.
	 *
	 * @return the value of the global variable turtle_mult
	 */
	@ReLogoBuilderGeneratedFor("global: turtle_mult")
	public Object getTurtle_mult(){
		return repast.simphony.relogo.ReLogoModel.getInstance().getModelParam("turtle_mult");
	}

	/**
	 * Sets the value of the global variable turtle_mult.
	 *
	 * @param value
	 *            a value
	 */
	@ReLogoBuilderGeneratedFor("global: turtle_mult")
	public void setTurtle_mult(Object value){
		repast.simphony.relogo.ReLogoModel.getInstance().setModelParam("turtle_mult",value);
	}


}
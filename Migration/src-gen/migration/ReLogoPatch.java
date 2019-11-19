package migration;

import static repast.simphony.relogo.Utility.*;
import static repast.simphony.relogo.UtilityG.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import groovy.lang.Closure;
import repast.simphony.relogo.*;
import repast.simphony.relogo.ast.Diffusible;
import repast.simphony.relogo.builder.GeneratedByReLogoBuilder;
import repast.simphony.relogo.builder.ReLogoBuilderGeneratedFor;
import repast.simphony.space.SpatialException;
import repast.simphony.space.grid.Grid;
import repast.simphony.space.grid.GridPoint;

@GeneratedByReLogoBuilder
@SuppressWarnings({"unused","rawtypes","unchecked"})
public class ReLogoPatch extends BasePatch{

	/**
	 * Sprouts (makes) a number of new humans and then executes a set of commands on the
	 * created humans.
	 * 
	 * @param number
	 *            a number
	 * @param closure
	 *            a set of commands
	 * @return created humans
	 */
	@ReLogoBuilderGeneratedFor("migration.relogo.Human")
	public AgentSet<migration.relogo.Human> sproutHumans(int number, Closure closure) {
		AgentSet<migration.relogo.Human> result = new AgentSet<>();
		AgentSet<Turtle> createResult = this.sprout(number,closure,"Human");
		for (Turtle t : createResult){
			if (t instanceof migration.relogo.Human){
				result.add((migration.relogo.Human)t);
			}
		} 
		return result;
	}

	/**
	 * Sprouts (makes) a number of new humans and then executes a set of commands on the
	 * created humans.
	 * 
	 * @param number
	 *            a number
	 * @param closure
	 *            a set of commands
	 * @return created humans
	 */
	@ReLogoBuilderGeneratedFor("migration.relogo.Human")
	public AgentSet<migration.relogo.Human> sproutHumans(int number) {
		return sproutHumans(number,null);
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
		GridPoint gridPoint = Utility.getGridPointAtDisplacement(getGridLocationAsNdPoint(),displacement,getMyObserver());
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
	 * Sprouts (makes) a number of new maps and then executes a set of commands on the
	 * created maps.
	 * 
	 * @param number
	 *            a number
	 * @param closure
	 *            a set of commands
	 * @return created maps
	 */
	@ReLogoBuilderGeneratedFor("migration.relogo.Map")
	public AgentSet<migration.relogo.Map> sproutMaps(int number, Closure closure) {
		AgentSet<migration.relogo.Map> result = new AgentSet<>();
		AgentSet<Turtle> createResult = this.sprout(number,closure,"Map");
		for (Turtle t : createResult){
			if (t instanceof migration.relogo.Map){
				result.add((migration.relogo.Map)t);
			}
		} 
		return result;
	}

	/**
	 * Sprouts (makes) a number of new maps and then executes a set of commands on the
	 * created maps.
	 * 
	 * @param number
	 *            a number
	 * @param closure
	 *            a set of commands
	 * @return created maps
	 */
	@ReLogoBuilderGeneratedFor("migration.relogo.Map")
	public AgentSet<migration.relogo.Map> sproutMaps(int number) {
		return sproutMaps(number,null);
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
		GridPoint gridPoint = Utility.getGridPointAtDisplacement(getGridLocationAsNdPoint(),displacement,getMyObserver());
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
	 * Sprouts (makes) a number of new userTurtles and then executes a set of commands on the
	 * created userTurtles.
	 * 
	 * @param number
	 *            a number
	 * @param closure
	 *            a set of commands
	 * @return created userTurtles
	 */
	@ReLogoBuilderGeneratedFor("migration.relogo.UserTurtle")
	public AgentSet<migration.relogo.UserTurtle> sproutUserTurtles(int number, Closure closure) {
		AgentSet<migration.relogo.UserTurtle> result = new AgentSet<>();
		AgentSet<Turtle> createResult = this.sprout(number,closure,"UserTurtle");
		for (Turtle t : createResult){
			if (t instanceof migration.relogo.UserTurtle){
				result.add((migration.relogo.UserTurtle)t);
			}
		} 
		return result;
	}

	/**
	 * Sprouts (makes) a number of new userTurtles and then executes a set of commands on the
	 * created userTurtles.
	 * 
	 * @param number
	 *            a number
	 * @param closure
	 *            a set of commands
	 * @return created userTurtles
	 */
	@ReLogoBuilderGeneratedFor("migration.relogo.UserTurtle")
	public AgentSet<migration.relogo.UserTurtle> sproutUserTurtles(int number) {
		return sproutUserTurtles(number,null);
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
		GridPoint gridPoint = Utility.getGridPointAtDisplacement(getGridLocationAsNdPoint(),displacement,getMyObserver());
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
	 * Returns the value of the global variable threshold.
	 *
	 * @return the value of the global variable threshold
	 */
	@ReLogoBuilderGeneratedFor("global: threshold")
	public Object getThreshold(){
		return repast.simphony.relogo.ReLogoModel.getInstance().getModelParam("threshold");
	}

	/**
	 * Sets the value of the global variable threshold.
	 *
	 * @param value
	 *            a value
	 */
	@ReLogoBuilderGeneratedFor("global: threshold")
	public void setThreshold(Object value){
		repast.simphony.relogo.ReLogoModel.getInstance().setModelParam("threshold",value);
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
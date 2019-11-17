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

@GeneratedByReLogoBuilder
@SuppressWarnings({"unused","rawtypes","unchecked"})
public class ReLogoObserver extends BaseObserver{

	/**
	 * Makes a number of randomly oriented humans and then executes a set of commands on the
	 * created humans.
	 * 
	 * @param number
	 *            a number
	 * @param closure
	 *            a set of commands
	 * @return created humans
	 */
	@ReLogoBuilderGeneratedFor("migration.relogo.Human")
	public AgentSet<migration.relogo.Human> createHumans(int number, Closure closure) {
		AgentSet<migration.relogo.Human> result = new AgentSet<>();
		AgentSet<Turtle> createResult = this.crt(number,closure,"Human");
		for (Turtle t : createResult){
			if (t instanceof migration.relogo.Human){
				result.add((migration.relogo.Human)t);
			}
		} 
		return result; 
	}

	/**
	 * Makes a number of randomly oriented humans and then executes a set of commands on the
	 * created humans.
	 * 
	 * @param number
	 *            a number
	 * @param closure
	 *            a set of commands
	 * @return created humans
	 */
	@ReLogoBuilderGeneratedFor("migration.relogo.Human")
	public AgentSet<migration.relogo.Human> createHumans(int number) {
		return createHumans(number,null);
	}

	/**
	 * Makes a number of uniformly fanned humans and then executes a set of commands on the
	 * created humans.
	 * 
	 * @param number
	 *            a number
	 * @param closure
	 *            a set of commands
	 * @return created humans
	 */
	@ReLogoBuilderGeneratedFor("migration.relogo.Human")
	public AgentSet<migration.relogo.Human> createOrderedHumans(int number, Closure closure) {
		AgentSet<migration.relogo.Human> result = new AgentSet<>();
		AgentSet<Turtle> createResult = this.cro(number,closure,"Human");
		for (Turtle t : createResult){
			if (t instanceof migration.relogo.Human){
				result.add((migration.relogo.Human)t);
			}
		} 
		return result; 
	}

	/**
	 * Makes a number of uniformly fanned humans and then executes a set of commands on the
	 * created humans.
	 * 
	 * @param number
	 *            a number
	 * @param closure
	 *            a set of commands
	 * @return created humans
	 */
	@ReLogoBuilderGeneratedFor("migration.relogo.Human")
	public AgentSet<migration.relogo.Human> createOrderedHumans(int number) {
		return createOrderedHumans(number,null);
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
		for (Object e : this.getContext().getObjects(migration.relogo.Human.class)) {
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
		Turtle turtle = Utility.turtleU(number.intValue(), this);
		if (turtle instanceof migration.relogo.Human)
			return (migration.relogo.Human) turtle;
		return null;
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
		for (Turtle t : Utility.getTurtlesOnGridPoint(p.getGridLocation(),this,"human")){
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
		for (Turtle tt : Utility.getTurtlesOnGridPoint(Utility.ndPointToGridPoint(t.getTurtleLocation()),this,"human")){
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
	 * Makes a number of randomly oriented maps and then executes a set of commands on the
	 * created maps.
	 * 
	 * @param number
	 *            a number
	 * @param closure
	 *            a set of commands
	 * @return created maps
	 */
	@ReLogoBuilderGeneratedFor("migration.relogo.Map")
	public AgentSet<migration.relogo.Map> createMaps(int number, Closure closure) {
		AgentSet<migration.relogo.Map> result = new AgentSet<>();
		AgentSet<Turtle> createResult = this.crt(number,closure,"Map");
		for (Turtle t : createResult){
			if (t instanceof migration.relogo.Map){
				result.add((migration.relogo.Map)t);
			}
		} 
		return result; 
	}

	/**
	 * Makes a number of randomly oriented maps and then executes a set of commands on the
	 * created maps.
	 * 
	 * @param number
	 *            a number
	 * @param closure
	 *            a set of commands
	 * @return created maps
	 */
	@ReLogoBuilderGeneratedFor("migration.relogo.Map")
	public AgentSet<migration.relogo.Map> createMaps(int number) {
		return createMaps(number,null);
	}

	/**
	 * Makes a number of uniformly fanned maps and then executes a set of commands on the
	 * created maps.
	 * 
	 * @param number
	 *            a number
	 * @param closure
	 *            a set of commands
	 * @return created maps
	 */
	@ReLogoBuilderGeneratedFor("migration.relogo.Map")
	public AgentSet<migration.relogo.Map> createOrderedMaps(int number, Closure closure) {
		AgentSet<migration.relogo.Map> result = new AgentSet<>();
		AgentSet<Turtle> createResult = this.cro(number,closure,"Map");
		for (Turtle t : createResult){
			if (t instanceof migration.relogo.Map){
				result.add((migration.relogo.Map)t);
			}
		} 
		return result; 
	}

	/**
	 * Makes a number of uniformly fanned maps and then executes a set of commands on the
	 * created maps.
	 * 
	 * @param number
	 *            a number
	 * @param closure
	 *            a set of commands
	 * @return created maps
	 */
	@ReLogoBuilderGeneratedFor("migration.relogo.Map")
	public AgentSet<migration.relogo.Map> createOrderedMaps(int number) {
		return createOrderedMaps(number,null);
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
		for (Object e : this.getContext().getObjects(migration.relogo.Map.class)) {
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
		Turtle turtle = Utility.turtleU(number.intValue(), this);
		if (turtle instanceof migration.relogo.Map)
			return (migration.relogo.Map) turtle;
		return null;
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
		for (Turtle t : Utility.getTurtlesOnGridPoint(p.getGridLocation(),this,"map")){
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
		for (Turtle tt : Utility.getTurtlesOnGridPoint(Utility.ndPointToGridPoint(t.getTurtleLocation()),this,"map")){
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
	 * Makes a number of randomly oriented userTurtles and then executes a set of commands on the
	 * created userTurtles.
	 * 
	 * @param number
	 *            a number
	 * @param closure
	 *            a set of commands
	 * @return created userTurtles
	 */
	@ReLogoBuilderGeneratedFor("migration.relogo.UserTurtle")
	public AgentSet<migration.relogo.UserTurtle> createUserTurtles(int number, Closure closure) {
		AgentSet<migration.relogo.UserTurtle> result = new AgentSet<>();
		AgentSet<Turtle> createResult = this.crt(number,closure,"UserTurtle");
		for (Turtle t : createResult){
			if (t instanceof migration.relogo.UserTurtle){
				result.add((migration.relogo.UserTurtle)t);
			}
		} 
		return result; 
	}

	/**
	 * Makes a number of randomly oriented userTurtles and then executes a set of commands on the
	 * created userTurtles.
	 * 
	 * @param number
	 *            a number
	 * @param closure
	 *            a set of commands
	 * @return created userTurtles
	 */
	@ReLogoBuilderGeneratedFor("migration.relogo.UserTurtle")
	public AgentSet<migration.relogo.UserTurtle> createUserTurtles(int number) {
		return createUserTurtles(number,null);
	}

	/**
	 * Makes a number of uniformly fanned userTurtles and then executes a set of commands on the
	 * created userTurtles.
	 * 
	 * @param number
	 *            a number
	 * @param closure
	 *            a set of commands
	 * @return created userTurtles
	 */
	@ReLogoBuilderGeneratedFor("migration.relogo.UserTurtle")
	public AgentSet<migration.relogo.UserTurtle> createOrderedUserTurtles(int number, Closure closure) {
		AgentSet<migration.relogo.UserTurtle> result = new AgentSet<>();
		AgentSet<Turtle> createResult = this.cro(number,closure,"UserTurtle");
		for (Turtle t : createResult){
			if (t instanceof migration.relogo.UserTurtle){
				result.add((migration.relogo.UserTurtle)t);
			}
		} 
		return result; 
	}

	/**
	 * Makes a number of uniformly fanned userTurtles and then executes a set of commands on the
	 * created userTurtles.
	 * 
	 * @param number
	 *            a number
	 * @param closure
	 *            a set of commands
	 * @return created userTurtles
	 */
	@ReLogoBuilderGeneratedFor("migration.relogo.UserTurtle")
	public AgentSet<migration.relogo.UserTurtle> createOrderedUserTurtles(int number) {
		return createOrderedUserTurtles(number,null);
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
		for (Object e : this.getContext().getObjects(migration.relogo.UserTurtle.class)) {
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
		Turtle turtle = Utility.turtleU(number.intValue(), this);
		if (turtle instanceof migration.relogo.UserTurtle)
			return (migration.relogo.UserTurtle) turtle;
		return null;
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
		for (Turtle t : Utility.getTurtlesOnGridPoint(p.getGridLocation(),this,"userTurtle")){
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
		for (Turtle tt : Utility.getTurtlesOnGridPoint(Utility.ndPointToGridPoint(t.getTurtleLocation()),this,"userTurtle")){
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
		for (Object e : this.getContext().getObjects(migration.relogo.UserLink.class)) {
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
		return (migration.relogo.UserLink)(this.getNetwork("UserLink").getEdge(turtle(oneEnd),turtle(otherEnd)));
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
	 * Returns the value of the global variable gdp_slider.
	 *
	 * @return the value of the global variable gdp_slider
	 */
	@ReLogoBuilderGeneratedFor("global: gdp_slider")
	public Object getGdp_slider(){
		return repast.simphony.relogo.ReLogoModel.getInstance().getModelParam("gdp_slider");
	}

	/**
	 * Sets the value of the global variable gdp_slider.
	 *
	 * @param value
	 *            a value
	 */
	@ReLogoBuilderGeneratedFor("global: gdp_slider")
	public void setGdp_slider(Object value){
		repast.simphony.relogo.ReLogoModel.getInstance().setModelParam("gdp_slider",value);
	}

	/**
	 * Returns the value of the global variable unmpl_slider.
	 *
	 * @return the value of the global variable unmpl_slider
	 */
	@ReLogoBuilderGeneratedFor("global: unmpl_slider")
	public Object getUnmpl_slider(){
		return repast.simphony.relogo.ReLogoModel.getInstance().getModelParam("unmpl_slider");
	}

	/**
	 * Sets the value of the global variable unmpl_slider.
	 *
	 * @param value
	 *            a value
	 */
	@ReLogoBuilderGeneratedFor("global: unmpl_slider")
	public void setUnmpl_slider(Object value){
		repast.simphony.relogo.ReLogoModel.getInstance().setModelParam("unmpl_slider",value);
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
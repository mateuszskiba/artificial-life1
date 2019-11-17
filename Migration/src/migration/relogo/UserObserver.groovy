package migration.relogo

import static repast.simphony.relogo.Utility.*;
import static repast.simphony.relogo.UtilityG.*;
import repast.simphony.relogo.Stop;
import repast.simphony.relogo.Utility;
import repast.simphony.relogo.UtilityG;
import repast.simphony.relogo.schedule.Go;
import repast.simphony.relogo.schedule.Setup;
import migration.ReLogoObserver;

class UserObserver extends ReLogoObserver{
	
		@Setup 
		def setup(){
			clearAll()
			createMaps(1) {
				setxy(worldWidth()/2-0.5, worldHeight()/2-0.5)
			}
			//def countriesList = []
			String fileContents = new File("datasets/countriesdata2.txt").text
			fileContents.eachLine(){ line ->
				def A = line.split()
				def x = A[0].toInteger()
				def y = A[1].toInteger()
				patch(x, y).name = A[2]
				patch(x, y).population = Math.round(A[3].toInteger()/turtle_mult).toInteger()
				patch(x, y).gdp = A[4].toInteger()
				patch(x, y).unemployment = A[5].toFloat()
				patch(x, y).coeff = [A[6].toFloat(), A[7].toFloat(), A[8].toFloat(), A[9].toFloat()]
				countriesList.add(patch(x,y))
			}
			
			ask(countriesList) {
				setPlabel(getPopulation())
				sproutHumans(getPopulation())
				
				ask(humansOn(it)) {
					setNationality(getName())
				}
			}
		}
		

		
	
		@Go
		def go(){
		
			// Ask humans about migration decision
			ask(humans()) {
				step()
			}
			
			// Ask countries to update variables
			ask(countriesList) {
				step()
			}
			
			// Ask countries to update their attractiveness
			ask(countriesList) {
				count_attractiveness()
				setPlabel(getPopulation())
			}
			
		}
}
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
			
			def countriesList = []
			String fileContents = new File("datasets/countriesdata2.txt").text
			fileContents.eachLine(){ line ->
				def A = line.split()
				def x = A[0].toInteger()
				def y = A[1].toInteger()
				patch(x, y).name = A[2]
				patch(x, y).population = A[3].toInteger()
				countriesList.add(patch(x,y))
			}
			
			ask(countriesList) {
				setPlabel(getPopulation())
			}
		}
		

		
	
//		@Go
//		def go(){
//		}
}
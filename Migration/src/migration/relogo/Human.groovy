package migration.relogo

import static repast.simphony.relogo.Utility.*
import static repast.simphony.relogo.UtilityG.*

import migration.ReLogoTurtle
import repast.simphony.relogo.Plural
import repast.simphony.relogo.Stop
import repast.simphony.relogo.Utility
import repast.simphony.relogo.UtilityG
import repast.simphony.relogo.schedule.Go
import repast.simphony.relogo.schedule.Setup

class Human extends ReLogoTurtle {
	def nationality = "None"
	def country = "None"
	def migrant = false
	def family = false
	
	def step() {
		// First decision if turtle migrates
		Random random = new Random()
		def rnd = random.nextInt(100)
		if (rnd < patchHere().attr) {
			// Choose target country of migration
			def max_attr = maxOneOf(getCountriesList()) {
				it.getAttr()
			}
			def target_country = patchHere()
//			while (target_country.attr <= patchHere().attr && target_country.attr != max_attr) {
//				target_country = oneOf(getCountriesList())
//			}
			target_country = oneOf(getCountriesList())

			
			//Update patch variables
			target_country.imigrant_update()
			patchHere().emigrant_update(migrant)
			
			// Update turtle variables
			setxy(target_country.getPxcor(), target_country.getPycor())
			migrant = true
		}

	}
}

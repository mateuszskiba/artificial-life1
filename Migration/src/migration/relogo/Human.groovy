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
		def rnd = random.nextDouble()
		def will_to_emig = rnd - emig_weight*random.nextDouble()
		def curiosity = random.nextDouble()
		if ( will_to_emig > attr || curiosity < curiosity_prob ) {
			// Choose target country of migration
			def max_attr = maxOneOf(getCountriesList()) {
				it.getAttr()
			}
			def target_country = patchHere()
			
			def sum_attr = 0
			def attr_list = []
			ask(getCountriesList()) {
				sum_attr += it.getAttr()
				attr_list.add(it.getAttr())
			}
			
			def power = 10000
			def rnd_index = random.nextInt((sum_attr*power).toInteger())
			def tmp_sum = 0
			def i = 0
			while (tmp_sum < rnd_index) {
				tmp_sum += countriesList[i++].getAttr()*power
			}			
			target_country = countriesList[i-1]
			
//			while (target_country.attr <= patchHere().attr && target_country.attr != max_attr) {
//				target_country = oneOf(getCountriesList())
//			}
//			target_country = oneOf(getCountriesList())

			
			//Update patch variables
			target_country.imigrant_update()
			patchHere().emigrant_update(migrant)
			
			// Update turtle variables
			setxy(target_country.getPxcor(), target_country.getPycor())
			migrant = true
		}

	}
}

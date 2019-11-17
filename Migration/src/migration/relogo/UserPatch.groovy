package migration.relogo

import static repast.simphony.relogo.Utility.*;
import static repast.simphony.relogo.UtilityG.*;
import repast.simphony.relogo.Stop;
import repast.simphony.relogo.Utility;
import repast.simphony.relogo.UtilityG;
import repast.simphony.relogo.ast.Diffusible;
import repast.simphony.relogo.schedule.Go;
import repast.simphony.relogo.schedule.Setup;
import migration.ReLogoPatch;

class UserPatch extends ReLogoPatch{
	def name = "None"
	def population = 0
	def migrants = 0
	def gdp = 0
	def unemployment = 0
	def coeff = [0, 0, 0, 0]
	def attr = 10
	def prev_gdp = 0
	
	def step() {
		prev_gdp = gdp
		gdp = coeff[0]*(migrants*turtle_mult) + coeff[1]
		unemployment = coeff[2]*(migrants*turtle_mult) + coeff[3]
	}
	
	def count_attractiveness() {
		// Let 0.5 be the weight of improvement and 0.5 the weight of comparison4
		// to other countries
		// Improvement - e.g. 5% increase in gdb means 100, 4% - 80, 4% decrease is -80 and so on
		// Comparison to other countries - e.g. 5 if 95% other countries have heigher gdp and 95 if 5% have higher gdp

		// Counting percentile
		def lower_gdp = 0
		def percentile = 0
		ask(getCountriesList()) {
			if (getGdp() < it.gdp) {
				lower_gdp++
				println lower_gdp
			}
		percentile = lower_gdp/count(countriesList)
		}
		
		def gdp_attr = 0.5*20*(gdp/prev_gdp-1)+0.5*percentile
		def unmpl_attr = (100-unemployment)
		
		attr = (gdp_weight*gdp_attr + unmpl_weight*unmpl_attr)/(gdp_weight+unmpl_weight)
	}
	
	def imigrant_update() {
		migrants++
		population++
	}
	
	def emigrant_update(migrant) {
		// descrease population by 1 and number of migrants by 1 if a migrant was already a migrant
		population--
		if (migrant == true) {
			migrants--
		}
	}
}
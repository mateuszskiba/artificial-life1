package migration.relogo

import repast.simphony.relogo.factories.AbstractReLogoGlobalsAndPanelFactory

public class UserGlobalsAndPanelFactory extends AbstractReLogoGlobalsAndPanelFactory{
	public void addGlobalsAndPanelComponents(){
		
		/**
		 * Place custom panels and globals below, for example:
		 * 
	        addGlobal("globalVariable1")	// Globally accessible variable ( variable name)
	        // Slider with label ( variable name, slider label, minimum value, increment, maximum value, initial value )
	        addSliderWL("sliderVariable", "Slider Variable", 0, 1, 10, 5)
	        // Slider without label ( variable name, minimum value, increment, maximum value, initial value )
	        addSlider("sliderVariable2", 0.2, 0.1, 0.8, 0.5)
	        // Chooser with label  ( variable name, chooser label, list of choices , zero-based index of initial value )
	        addChooserWL("chooserVariable", "Chooser Variable", ["yes","no","maybe"], 2)
	        // Chooser without label  ( variable name, list of choices , zero-based index of initial value )
	        addChooser("chooserVariable2", [1, 66, "seven"], 0)
	        // State change button (method name in observer)
	        addStateChangeButton("change")
	        // State change button with label (method name in observer, label)
	        addStateChangeButtonWL("changeSomething","Change Something")
	        
		 */
		addGlobal("countriesList", [])
		addSliderWL("gdp_weight", "GDP weight", 1, 1, 100, 10)
		addSliderWL("unmpl_weight", "Unemployment weight", 1, 1, 100, 15)
		addSliderWL("rnd_weight", "Weight of random country attr", 1, 1, 100, 70)
		addSliderWL("migrants_weight", "Weight of migrants attr", 0, 0.01, 1, 0.1)
		addSliderWL("attr_const", "Attractiveness constant", 0, 0.01, 1, 0.1)
		addSliderWL("curiosity_prob", "Prob of emigr due to curiosity", 0, 0.01, 1, 0.1)
		addSliderWL("emig_weight", "Weight of emigration willingness", 0, 0.01, 100, 55)
//		addSliderWL("threshold", "Migration threshold", 0, 0.01, 1, 0.5)
		addChooserWL("turtle_mult", "Turtle is how many people?", [1, 10, 100, 1000, 10000, 100000], 4)

	}
}
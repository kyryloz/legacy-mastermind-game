package main;

public class ViewFactory {
	IView view;
	
	public IView getView(String type, IController controller, IModel model) {
		if (type.equals("gui")) {
			view = new ViewGUI(controller, model);
		}
		if (type.equals("consol")) {
			view = new ViewConsol(controller, model);
		}
		if (type.equals("numbersgui")) {
			view = new NumbersGUI (controller, model);
		}
		return view;
	}
}

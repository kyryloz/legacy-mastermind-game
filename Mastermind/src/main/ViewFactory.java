package main;

public class ViewFactory {
	IView view;
	
	public IView getView(String type, IController controller, IModel model) {
		if (type == "gui") {
			view = new ViewGUI(controller, model);
		}
		if (type == "consol") {
			view = new ViewConsol(controller, model);
		}
		if (type == "numbersgui") {
			view = new NumbersGUI (controller, model);
		}
		return view;
	}
}

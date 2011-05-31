package main;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;


public class MainClass {

	/**
	 * @param args
	 *
	 */
	public static void main(final String[] args) {
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				try {
					for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
						if ("Nimbus".equals(info.getName())) {
							UIManager.setLookAndFeel(info.getClassName());
							break;}}
				} catch (Exception e) {
				}
				
				String viewType = "gui";
				if (args.length > 0) {
					if (args[0].equals("-cosol")) {
						viewType = "consol";
					}
					if (args[0].equals("-numbersgui")) {
						viewType = "numbersgui";
					}
				}
				IModel model = new Model();
				new Controller(model, viewType);
			}
			
		});

	}

}

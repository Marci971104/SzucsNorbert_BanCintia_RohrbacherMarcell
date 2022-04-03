
import control.Controller;
import view.LifeForm;
import control.RapiController;
import control.ViewController;







public class LifeStyle {

	public static void main(String[] args) {
		try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LifeForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        new Controller();
        
	}

}
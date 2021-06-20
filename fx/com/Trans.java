package fx.com;

import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

public class Trans {

	public Trans(TextField tf, TextFlow tfw, ChoiceBox<String> cbox) {
		
		String conversionStr  = tf.getText().replace(":", "%3A");
		Text inputText = (Text)tfw.getChildren().get(0);
		
		String ipStr = cbox.getSelectionModel().getSelectedItem();
		
		String newstr = "http://" + ipStr + ":25500/sub?target=clash&url=" + conversionStr + "&insert=false&config=http%3A%2F%2F" + ipStr + ":8090%2Fcordcloud_custom.ini&emoji=true&list=false&udp=true&tfo=false&scv=false&fdn=false&sort=false&new_name=true";
		 
		inputText.setText(newstr);
		
	}

}

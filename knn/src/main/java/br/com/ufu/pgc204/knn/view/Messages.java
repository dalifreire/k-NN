package br.com.ufu.pgc204.knn.view;

import java.awt.Component;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

/**
 * @author Dali Freire <i>dalifreire@gmail.com</i>
 * @since 04/2018
 */
public class Messages {

	private static final ResourceBundle bundle = ResourceBundle.getBundle("br.com.ufu.pgc204.knn.i18n.messages");

	public static void showInformationMessage(Component frame, String message) {
		JOptionPane.showMessageDialog(frame, message, bundle.getString("titulo"), JOptionPane.INFORMATION_MESSAGE);
	}

	public static int showQuestionMessage(Component frame, String mensagem, Object[] opcoes) {
		return JOptionPane.showOptionDialog(frame, mensagem, bundle.getString("titulo"), JOptionPane.YES_NO_OPTION,
				JOptionPane.QUESTION_MESSAGE, null, opcoes, opcoes[1]);
	}

	public static void showWarningMessage(Component frame, String message) {
		JOptionPane.showMessageDialog(frame, message, bundle.getString("titulo"), JOptionPane.WARNING_MESSAGE);
	}

	public static void showErrorMessage(Component frame, String message) {
		JOptionPane.showMessageDialog(frame, message, bundle.getString("titulo"), JOptionPane.ERROR_MESSAGE);
	}

}

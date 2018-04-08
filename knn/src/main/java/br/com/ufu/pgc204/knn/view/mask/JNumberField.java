package br.com.ufu.pgc204.knn.view.mask;

import java.awt.Toolkit;

import javax.swing.JTextField;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.PlainDocument;

/**
 * @author Dali Freire <i>dalifreire@gmail.com</i>
 * @since 04/2018
 */
public class JNumberField extends JTextField {
	
	private static final long serialVersionUID = 5027743120665886075L;

	private Toolkit toolkit;
	private final int MAX_DIGITOS;

	public JNumberField(int maxDigitos) {
		this.MAX_DIGITOS = maxDigitos;
		toolkit = Toolkit.getDefaultToolkit();
	}

	protected Document createDefaultModel() {
		return new WholeNumberDocument();
	}

	protected class WholeNumberDocument extends PlainDocument {

		private static final long serialVersionUID = -3651848909013481338L;

		public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
			if (verificaEntrada(offs, str)) {
				String texto = getText(0, getLength());
				if (texto.length() < MAX_DIGITOS) {
					super.insertString(offs, str, a);
				}
			}
		}
	}

	/**
	 * verifica se os caracteres digitado eh valido.
	 * 
	 * @param offs
	 * @param str
	 * @return boolean. retorna true se os caracteres digitados forem validos
	 */
	private boolean verificaEntrada(int offs, String str) {
		char[] source = str.toCharArray();
		for (int i = 0; i < source.length; i++) {
			if (!Character.isDigit(source[i])) {
				toolkit.beep();
				return false;
			}
		}
		return true;
	}

}
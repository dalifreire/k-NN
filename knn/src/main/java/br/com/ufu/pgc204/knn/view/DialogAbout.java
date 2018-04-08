package br.com.ufu.pgc204.knn.view;

import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Rectangle;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * @author Dal� Freire <i>dalifreire@gmail.com</i>
 * @author Marques Melo <i>mbisonho@gmail.com</i>
 * @since 05/2009
 */
public class DialogAbout extends JDialog 
{

	private static final long serialVersionUID = 1L;
	private final String TITULO = "Sobre o Block Nested Loop Join";
	private final String IMAGEM_SOBRE = "/imagens/bnl.png";  

	private JPanel jContentPane = null;
	private JLabel jLabelImagem = null;

	/**
	 * This method initializes jLabelImagem	
	 * 	
	 * @return javax.swing.JLabel	
	 */
	private JLabel getJLabelImagem() {
		if (jLabelImagem == null) {
			jLabelImagem = new JLabel();
			jLabelImagem.setText("");
			jLabelImagem.setIcon(new ImageIcon(getClass().getResource( IMAGEM_SOBRE )));
			jLabelImagem.setBounds(new Rectangle(0, 0, 530, 485));
		}
		return jLabelImagem;
	}

	/**
	 * @param owner
	 */
	public DialogAbout(Frame owner) {
		super( owner, true );
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(540, 520);
		this.setTitle( TITULO );
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();	
		this.setLocation( (dimension.width - this.getSize().width) / 2, (dimension.height - this.getSize().height) / 2 );
		this.setContentPane(getJContentPane());
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(getJLabelImagem(), null);
		}
		return jContentPane;
	}

}  //  @jve:decl-index=0:visual-constraint="10,10"

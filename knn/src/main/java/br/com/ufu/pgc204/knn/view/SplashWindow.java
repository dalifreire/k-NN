package br.com.ufu.pgc204.knn.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.JWindow;

/**
 * Tela de splash para a aplicacao.
 * 
 * @author Dali Freire <i>dalifreire@gmail.com</i>
 * @since 04/2018
 */
public class SplashWindow extends JWindow implements WindowListener {

	private static final long serialVersionUID = 3031594260654050042L;
	private JLabel imagem = null;
	private JProgressBar jProgressBar = null;

	/**
	 * Construtor, rebece uma String com o endereco da imagem que sera exibida na
	 * tela de splash.
	 * 
	 * @param splash
	 *            String com o endereco da imagem exibida na tela de splash
	 */
	public SplashWindow(String splash) {
		imagem = new JLabel();
		imagem.setIcon(new ImageIcon(getClass().getResource(splash)));
		imagem.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		imagem.add(getJProgressBar());
	}

	/**
	 * Exibe e remove a tela de splash de acordo com o tempo temo passado.
	 * 
	 * @param sleepTime
	 *            - int que informa o tempo de exibicao, em milisegundos, da tela de
	 *            splash.
	 * @return void
	 */
	public void show(int sleepTime) {
		this.open();
		this.sleep(sleepTime);
		this.close();
	}

	/**
	 * Exibe a tela de splash. <br>
	 * 
	 * @return void
	 */
	public void open() {
		this.getContentPane().add(imagem);
		this.setSize(imagem.getIcon().getIconWidth(),
				imagem.getIcon().getIconHeight() + getJProgressBar().getHeight() + 15);
		// this.pack();
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation((dimension.width - getSize().width) / 2, (dimension.height - getSize().height) / 2);
		this.addWindowListener(this);
		this.setVisible(true);

	}

	/**
	 * Aguarda um tempo em milisegundos
	 * 
	 * @param sleepTime
	 *            int que representa o tempo, em milisegundos, que sera aguardado.
	 * @exception InterruptedException
	 * @exception Exception
	 * @return void
	 */
	public void sleep(int sleepTime) {
		try {
			Thread.sleep(sleepTime);
		} catch (InterruptedException ie) {
			ie.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Fecha a janela de splash
	 * 
	 * @return void
	 */
	public void close() {
		dispose();
	}

	/**
	 * This method initializes jProgressBar
	 * 
	 * @return javax.swing.JProgressBar
	 */
	private JProgressBar getJProgressBar() {
		if (jProgressBar == null) {
			jProgressBar = new JProgressBar();
			jProgressBar.setIndeterminate(true);
			jProgressBar.setSize(imagem.getIcon().getIconWidth(), 20);
			jProgressBar.setLocation(0, imagem.getIcon().getIconHeight() + 15);
		}
		return jProgressBar;
	}

	/**
	 * metodo main teste da classe
	 * 
	 * @param args
	 * @return void
	 */
	public static void main(String[] args) {
		/*
		 * exemplo de funcionamento
		 */
		SplashWindow splash = new SplashWindow("/br/com/ufu/pgc204/knn/images/knn.png");
		splash.show(5000);
	}

	/**
	 * @param windowevent
	 * @return void
	 */
	public void windowOpened(WindowEvent windowevent) {
		Graphics2D graphics2d = (Graphics2D) getGlassPane().getGraphics();
		graphics2d.setColor(new Color(51, 102, 153));
		graphics2d.setFont(new Font("SansSerif", 0, 16));
	}

	/**
	 * @param windowevent
	 * @return void
	 */
	public void windowActivated(WindowEvent windowevent) {
	}

	/**
	 * @param windowevent
	 * @return coid
	 */
	public void windowClosed(WindowEvent windowevent) {
	}

	/**
	 * @param windowevent
	 * @return void
	 */
	public void windowClosing(WindowEvent windowevent) {
	}

	/**
	 * @param windowevent
	 * @return void
	 */
	public void windowDeactivated(WindowEvent windowevent) {
	}

	/**
	 * @param windowevent
	 * @return void
	 */
	public void windowDeiconified(WindowEvent windowevent) {
	}

	/**
	 * @param windowevent
	 * @return void
	 */
	public void windowIconified(WindowEvent windowevent) {
	}

}
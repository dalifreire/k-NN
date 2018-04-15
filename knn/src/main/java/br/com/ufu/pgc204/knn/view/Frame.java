package br.com.ufu.pgc204.knn.view;

import java.awt.Container;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.util.ResourceBundle;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

import br.com.ufu.pgc204.knn.view.mask.JNumberField;

public class Frame extends JFrame {

	private static final long serialVersionUID = -8670755714965188181L;

	private ResourceBundle bundle = ResourceBundle.getBundle("br.com.ufu.pgc204.knn.i18n.messages");

	private JLabel lblAmostras;
	private JTextField txtAmostras;
	private JButton btnSearch;
	private JLabel lblAbout;
	private JLabel lblKFold;
	private JTextField txtKFold;
	private JCheckBox chkZScore;
	private JLabel lblNumeroVizinhos;
	private JTextField txtNumeroVizinhos;

	private JButton btnExecute;

	private JScrollPane scrollPaneResults;
	private JTextArea textAreaResults;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frame frame = new Frame();
					frame.setVisible(true);
					frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Frame() {
		initialize();
	}

	private void initialize() {

		this.setSize(600, 449);
		this.setTitle(this.bundle.getString("titulo"));
		this.setResizable(false);
		this.setVisible(false);

		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation((screenSize.width - this.getSize().width) / 2,
				(screenSize.height - this.getSize().height) / 2);
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		addComponents(this.getContentPane());
	}

	private void addComponents(Container pane) {

		pane.setLayout(new GridBagLayout());

		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0; // primeira coluna
		c.gridy = 0; // primeira linha
		pane.add(getLblAmostras(), c);

		c.gridx = 1; // segunda coluna
		pane.add(getTxtAmostras(), c);

		c.gridx = 2; // terceira coluna
		pane.add(getBtnSearch(), c);

		c.gridx = 3; // quarta coluna
		pane.add(getLblAbout(), c);

		c.gridx = 0; // primeira coluna
		c.gridy = 1; // segunda linha
		pane.add(getLblKFold(), c);

		c.gridx = 1; // segunda coluna
		pane.add(getTxtKFold(), c);

		c.gridx = 2; // terceira coluna
		c.gridwidth = 2; // ocupa duas colunas
		pane.add(getChkZScore(), c);

		c.gridx = 0; // primeira coluna
		c.gridy = 2;	//terceira linha
		c.gridwidth = 1;
		pane.add(getLblNumeroVizinhos(), c);
		
		c.gridx = 1; // segunda coluna
		pane.add(getTxtNumeroVizinhos(), c);

		c.gridx = 2; // terceira coluna
		c.gridy = 3; // quarta linha
		c.gridwidth = 2; // ocupa duas colunas
		c.insets = new Insets(10, 0, 0, 0); // top padding
		pane.add(getBtnExecute(), c);

		c.gridx = 0; // primeira coluna
		c.gridy = 4; // quinta linha
		c.gridwidth = 4; // ocupa 4 colunas
		c.insets = new Insets(0, 0, 0, 0);
		pane.add(getScrollPaneResults(), c);
	}

	private JLabel getLblAmostras() {
		if (this.lblAmostras == null) {
			this.lblAmostras = new JLabel();
			this.lblAmostras.setText(bundle.getString("lblAmostras.text") + ":");
		}
		return lblAmostras;
	}

	public JTextField getTxtAmostras() {
		if (this.txtAmostras == null) {
			this.txtAmostras = new JTextField();
			this.txtAmostras.setEditable(false);
			this.txtAmostras.setText(bundle.getString("txtAmostras.text"));
		}
		return txtAmostras;
	}

	public JButton getBtnSearch() {
		if (this.btnSearch == null) {
			this.btnSearch = new JButton();
			this.btnSearch.setToolTipText(bundle.getString("btnSearch.toolTipText"));
			this.btnSearch.setIcon(new ImageIcon(getClass().getResource("/br/com/ufu/pgc204/knn/images/procurar.gif")));
			this.btnSearch.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			this.btnSearch.setPreferredSize(new Dimension(36, 26));
		}
		return this.btnSearch;
	}

	public JLabel getLblAbout() {
		if (this.lblAbout == null) {
			this.lblAbout = new JLabel();
			this.lblAbout.setPreferredSize(new Dimension(28, 26));
			this.lblAbout.setIcon(new ImageIcon(getClass().getResource("/br/com/ufu/pgc204/knn/images/sobre.gif")));
			this.lblAbout.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			this.lblAbout.setToolTipText(bundle.getString("lblAbout.toolTipText"));
		}
		return this.lblAbout;
	}

	private JLabel getLblKFold() {
		if (this.lblKFold == null) {
			this.lblKFold = new JLabel();
			this.lblKFold.setText(bundle.getString("lblKFold.text") + ":");
		}
		return this.lblKFold;
	}

	public JTextField getTxtKFold() {
		if (this.txtKFold == null) {
			this.txtKFold = new JNumberField(2);
			this.txtKFold.setText("10");
		}
		return this.txtKFold;
	}

	public JCheckBox getChkZScore() {
		if (this.chkZScore == null) {
			this.chkZScore = new JCheckBox();
			this.chkZScore.setText(bundle.getString("chkZScore.text"));
			this.chkZScore.setSelected(true);
		}
		return this.chkZScore;
	}
	
	private JLabel getLblNumeroVizinhos() {
		if (this.lblNumeroVizinhos == null) {
			this.lblNumeroVizinhos = new JLabel();
			this.lblNumeroVizinhos.setText(bundle.getString("lblNumeroVizinhos.text") + ":");
		}
		return this.lblNumeroVizinhos;
	}

	public JTextField getTxtNumeroVizinhos() {
		if (this.txtNumeroVizinhos == null) {
			this.txtNumeroVizinhos = new JNumberField(2);
			this.txtNumeroVizinhos.setText("5");
		}
		return this.txtNumeroVizinhos;
	}

	public JButton getBtnExecute() {
		if (this.btnExecute == null) {
			this.btnExecute = new JButton();
			this.btnExecute.setText(bundle.getString("btnExecute.text"));
			this.btnExecute.setIcon(new ImageIcon(getClass().getResource("/br/com/ufu/pgc204/knn/images/accept.png")));
			this.btnExecute.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		}
		return this.btnExecute;
	}

	public JScrollPane getScrollPaneResults() {
		if (this.scrollPaneResults == null) {
			this.scrollPaneResults = new JScrollPane();
			this.scrollPaneResults.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
			this.scrollPaneResults.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
			this.scrollPaneResults.setViewportView(getTextAreaResults());
			this.scrollPaneResults.setPreferredSize(new Dimension(4, 250));
		}
		return this.scrollPaneResults;
	}

	public JTextArea getTextAreaResults() {
		if (this.textAreaResults == null) {
			this.textAreaResults = new JTextArea();
			this.textAreaResults.setEditable(false);
		}
		return this.textAreaResults;
	}

}

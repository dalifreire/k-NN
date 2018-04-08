package br.com.ufu.pgc204.knn.view;

import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.util.ResourceBundle;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;

import br.com.ufu.pgc204.knn.view.mask.JNumberField;

public class Frame extends JFrame {

	private static final long serialVersionUID = -8670755714965188181L;

	private JPanel contentPane;
	private ResourceBundle bundle = ResourceBundle.getBundle("br.com.ufu.pgc204.knn.i18n.messages");
	
	private JPanel panelFields;
	private JLabel lblAmostras;
	private JTextField txtAmostras;
	private JPanel panelRow1_1;
	private JButton btnSearch;
	private JLabel lblAbout;
	private JLabel lblKFold;
	private JTextField txtKFold;
	private JCheckBox chkZScore;

	private JPanel panelButtons;
	private JButton btnExecute;

	private JPanel panelResults;
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
		this.setLocation((screenSize.width - this.getSize().width) / 2, (screenSize.height - this.getSize().height) / 2);
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.setContentPane(getJContentPane());

	}

	private JPanel getJContentPane() {
		if (this.contentPane == null) {
			this.contentPane = new JPanel();
			this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			this.contentPane.setLayout(new GridBagLayout());
			((GridBagLayout)this.contentPane.getLayout()).columnWidths = new int[] {0, 0};
			((GridBagLayout)this.contentPane.getLayout()).rowHeights = new int[] {0, 0, 0, 0};
			((GridBagLayout)this.contentPane.getLayout()).columnWeights = new double[] {1.0, 1.0E-4};
			((GridBagLayout)this.contentPane.getLayout()).rowWeights = new double[] {1.0, 1.0, 1.0, 1.0E-4};
			
			this.contentPane.add(getPanelFields(), new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
					GridBagConstraints.CENTER, GridBagConstraints.BOTH,
					new Insets(0, 0, 0, 0), 0, 0));
			this.contentPane.add(getPanelButtons(), new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
					GridBagConstraints.CENTER, GridBagConstraints.BOTH,
					new Insets(0, 0, 0, 0), 0, 0));
			this.contentPane.add(getPanelResults(), new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0,
					GridBagConstraints.CENTER, GridBagConstraints.BOTH,
					new Insets(0, 0, 0, 0), 0, 0));
		}
		return this.contentPane;
	}
	
	private JPanel getPanelFields() {
		if (this.panelFields == null) {
			this.panelFields = new JPanel();
			this.panelFields.setLayout(new GridLayout(0, 3));
			
			this.panelFields.add(getLblAmostras());
			this.panelFields.add(getTxtAmostras());
			this.panelFields.add(getPanelRow1_1());
			this.panelFields.add(getLblKFold());
			this.panelFields.add(getTxtKFold());
			this.panelFields.add(getChkZScore());
		}
		return this.panelFields;
	}
	
	private JLabel getLblAmostras() {
		if (this.lblAmostras == null) {
			this.lblAmostras = new JLabel();
			this.lblAmostras.setText(bundle.getString("lblAmostras.text"));
			this.lblAmostras.setPreferredSize(new Dimension(49, 20));
		}
		return lblAmostras;
	}
	
	public JTextField getTxtAmostras() {
		if (this.txtAmostras == null) {
			this.txtAmostras = new JTextField();
			this.txtAmostras.setEditable(false);
			this.txtAmostras.setText(bundle.getString("txtAmostras.text"));
			this.txtAmostras.setPreferredSize(new Dimension(200, 20));
		}
		return txtAmostras;
	}
	
	private JPanel getPanelRow1_1() {
		if (this.panelRow1_1 == null) {
			this.panelRow1_1 = new JPanel();
			this.panelRow1_1.setLayout(new FlowLayout(FlowLayout.LEFT));
			
			this.panelRow1_1.add(getBtnSearch());
			this.panelRow1_1.add(getLblAbout());
		}
		return this.panelRow1_1;
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
			this.lblKFold.setText(bundle.getString("lblKFold.text"));
			this.lblKFold.setPreferredSize(new Dimension(78, 20));
		}
		return this.lblKFold;
	}
	
	public JTextField getTxtKFold() {
		if (this.txtKFold == null) {
			this.txtKFold = new JNumberField(2);
			this.txtKFold.setText(bundle.getString("txtKFold.text"));
		}
		return this.txtKFold;
	}
	
	public JCheckBox getChkZScore() {
		if (this.chkZScore == null) {
			this.chkZScore = new JCheckBox();
			this.chkZScore.setText(bundle.getString("chkZScore.text"));
			this.chkZScore.setSelected(true);
			this.chkZScore.setPreferredSize(new Dimension(153, 20));
		}
		return this.chkZScore;
	}
	
	
	
	
	/*
	 * PAINEL DOS BOTOES
	 */
	private JPanel getPanelButtons() {
		if (this.panelButtons == null) {
			this.panelButtons = new JPanel();
			this.panelButtons.setLayout(new FlowLayout(FlowLayout.RIGHT));
			
			this.panelButtons.add(getBtnExecute());
		}
		return this.panelButtons;
	}
	
	public JButton getBtnExecute() {
		if (this.btnExecute == null) {
			this.btnExecute = new JButton();
			this.btnExecute.setText(bundle.getString("btnExecute.text"));
			this.btnExecute.setIcon(new ImageIcon(getClass().getResource("/br/com/ufu/pgc204/knn/images/accept.png")));
			this.btnExecute.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			this.btnExecute.setPreferredSize(new Dimension(120, 26));
		}
		return this.btnExecute;
	}
	
	
	
	/*
	 * PAINEL DOS RESULTADOS
	 */
	private JPanel getPanelResults() {
		if (this.panelResults == null) {
			this.panelResults = new JPanel();
			this.panelResults.setLayout(new GridLayout(0, 1));
			
			this.panelResults.add(getScrollPaneResults());
		}
		return this.panelResults;
	}
	
	public JScrollPane getScrollPaneResults() {
		if (this.scrollPaneResults == null) {
			this.scrollPaneResults = new JScrollPane();
			this.scrollPaneResults.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
			this.scrollPaneResults.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
			this.scrollPaneResults.setViewportView(getTextAreaResults());
		}
		return this.scrollPaneResults;
	}

	public JTextArea getTextAreaResults() {
		if (this.textAreaResults == null) {
			this.textAreaResults = new JTextArea();
			this.textAreaResults.setEditable(false);
			this.textAreaResults.setPreferredSize(new Dimension(4, 250));
		}
		return this.textAreaResults;
	}
}

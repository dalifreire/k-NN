/*
 * Created by JFormDesigner on Sun Apr 08 12:10:35 BRT 2018
 */

package br.com.ufu.pgc204.knn.view;

import java.awt.*;
import java.util.*;
import javax.swing.*;

/**
 * @author Giovanni Michielin
 */
public class Panel extends JPanel {
	public Panel() {
		initComponents();
	}

	public JLabel getLblAmostras() {
		return lblAmostras;
	}

	public JTextField getTxtAmostras() {
		return txtAmostras;
	}

	public JButton getBtnSearch() {
		return btnSearch;
	}

	public JLabel getLblKFold() {
		return lblKFold;
	}

	public JTextField getTxtKFold() {
		return txtKFold;
	}

	public JCheckBox getChkZScore() {
		return chkZScore;
	}

	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
		ResourceBundle bundle = ResourceBundle.getBundle("br.com.ufu.pgc204.knn.i18n.messages");
		panelFields = new JPanel();
		lblAmostras = new JLabel();
		txtAmostras = new JTextField();
		panelRow1_1 = new JPanel();
		btnSearch = new JButton();
		lblAbout = new JLabel();
		lblKFold = new JLabel();
		txtKFold = new JTextField();
		chkZScore = new JCheckBox();
		panelButtons = new JPanel();
		btnExecute = new JButton();
		panelResults = new JPanel();
		scrollPaneResults = new JScrollPane();
		textAreaResults = new JTextArea();

		//======== this ========
		setLayout(new GridBagLayout());
		((GridBagLayout)getLayout()).columnWidths = new int[] {0, 0};
		((GridBagLayout)getLayout()).rowHeights = new int[] {0, 0, 0, 0};
		((GridBagLayout)getLayout()).columnWeights = new double[] {1.0, 1.0E-4};
		((GridBagLayout)getLayout()).rowWeights = new double[] {1.0, 1.0, 1.0, 1.0E-4};

		//======== panelFields ========
		{
			panelFields.setLayout(new GridLayout(0, 3));

			//---- lblAmostras ----
			lblAmostras.setText(bundle.getString("lblAmostras.text"));
			lblAmostras.setPreferredSize(new Dimension(49, 20));
			panelFields.add(lblAmostras);

			//---- txtAmostras ----
			txtAmostras.setEditable(false);
			txtAmostras.setText(bundle.getString("txtAmostras.text"));
			txtAmostras.setPreferredSize(new Dimension(200, 20));
			panelFields.add(txtAmostras);

			//======== panelRow1_1 ========
			{
				panelRow1_1.setLayout(new FlowLayout(FlowLayout.LEFT));

				//---- btnSearch ----
				btnSearch.setToolTipText(bundle.getString("btnSearch.toolTipText"));
				btnSearch.setIcon(new ImageIcon(getClass().getResource("/br/com/ufu/pgc204/knn/images/procurar.gif")));
				btnSearch.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				btnSearch.setPreferredSize(new Dimension(36, 26));
				panelRow1_1.add(btnSearch);

				//---- lblAbout ----
				lblAbout.setPreferredSize(new Dimension(28, 26));
				lblAbout.setIcon(new ImageIcon(getClass().getResource("/br/com/ufu/pgc204/knn/images/sobre.gif")));
				lblAbout.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				lblAbout.setToolTipText(bundle.getString("lblAbout.toolTipText"));
				panelRow1_1.add(lblAbout);
			}
			panelFields.add(panelRow1_1);

			//---- lblKFold ----
			lblKFold.setText(bundle.getString("lblKFold.text"));
			lblKFold.setPreferredSize(new Dimension(78, 20));
			panelFields.add(lblKFold);

			//---- txtKFold ----
			txtKFold.setText(bundle.getString("txtKFold.text"));
			panelFields.add(txtKFold);

			//---- chkZScore ----
			chkZScore.setText(bundle.getString("chkZScore.text"));
			chkZScore.setSelected(true);
			chkZScore.setPreferredSize(new Dimension(153, 20));
			panelFields.add(chkZScore);
		}
		add(panelFields, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
			GridBagConstraints.CENTER, GridBagConstraints.BOTH,
			new Insets(0, 0, 0, 0), 0, 0));

		//======== panelButtons ========
		{
			panelButtons.setLayout(new FlowLayout(FlowLayout.RIGHT));

			//---- btnExecute ----
			btnExecute.setText(bundle.getString("btnExecute.text"));
			btnExecute.setIcon(new ImageIcon(getClass().getResource("/br/com/ufu/pgc204/knn/images/accept.png")));
			btnExecute.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btnExecute.setPreferredSize(new Dimension(120, 26));
			panelButtons.add(btnExecute);
		}
		add(panelButtons, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
			GridBagConstraints.CENTER, GridBagConstraints.BOTH,
			new Insets(0, 0, 0, 0), 0, 0));

		//======== panelResults ========
		{
			panelResults.setLayout(new GridLayout(0, 1));

			//======== scrollPaneResults ========
			{
				scrollPaneResults.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
				scrollPaneResults.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

				//---- textAreaResults ----
				textAreaResults.setEditable(false);
				textAreaResults.setPreferredSize(new Dimension(4, 250));
				scrollPaneResults.setViewportView(textAreaResults);
			}
			panelResults.add(scrollPaneResults);
		}
		add(panelResults, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0,
			GridBagConstraints.CENTER, GridBagConstraints.BOTH,
			new Insets(0, 0, 0, 0), 0, 0));
		// JFormDesigner - End of component initialization  //GEN-END:initComponents
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
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
	// JFormDesigner - End of variables declaration  //GEN-END:variables
}

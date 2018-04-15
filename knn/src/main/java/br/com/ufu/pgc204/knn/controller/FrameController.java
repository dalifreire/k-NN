package br.com.ufu.pgc204.knn.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.nio.charset.StandardCharsets;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;

import br.com.ufu.pgc204.knn.math.ZScore;
import br.com.ufu.pgc204.knn.model.SampleDto;
import br.com.ufu.pgc204.knn.model.SampleFileDto;
import br.com.ufu.pgc204.knn.view.DialogAbout;
import br.com.ufu.pgc204.knn.view.Frame;
import br.com.ufu.pgc204.knn.view.Messages;
import br.com.ufu.pgc204.knn.view.SplashWindow;

/**
 * @author Dali Freire <i>dalifreire@gmail.com</i>
 * @since 04/2018
 */
public class FrameController {

	private final ResourceBundle bundle = ResourceBundle.getBundle("br.com.ufu.pgc204.knn.i18n.messages");

	private SplashWindow splash;
	private Frame frame;

	public FrameController() {

		/* exibe a tela de splash */
		this.splash = new SplashWindow("/br/com/ufu/pgc204/knn/images/knn.png");
		this.splash.open();

		/* prepara a exibicao inicial do sistema */
		this.frame = new Frame();
		addListeners();
		this.frame.setVisible(true);

		/* fecha a tela de splash */
		this.splash.close();
	}

	/**
	 * Registra os eventos/acoes dos botoes da tela.
	 */
	private void addListeners() {

		/* registra o evento/acao ao tentar fechar a janela do sistema */
		WindowListener sair = new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				Object[] options = { bundle.getString("msg.sair"), bundle.getString("msg.cancelar") };
				int selected = Messages.showQuestionMessage(frame, bundle.getString("msg.confirmacao.sair.sistema"),
						options);
				if (selected == JOptionPane.YES_OPTION) {
					System.exit(0);
				}
			}
		};
		this.frame.addWindowListener(sair);

		/* registra o evento/acao ao clicar no botao 'sobre' */
		this.frame.getLblAbout().addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				DialogAbout sobre = new DialogAbout(frame);
				sobre.setVisible(true);
			}
		});

		/* registra o evento/acao ao clicar no botao 'selecionar amostras' */
		this.frame.getBtnSearch().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnSelectSamplesFile();
			}
		});
		this.frame.getTxtAmostras().addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				frame.getBtnSearch().doClick();
			}
		});

		/* registra o evento/acao ao clicar no botao 'executar' */
		this.frame.getBtnExecute().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnExecute();
			}
		});
	}

	/**
	 * Exibe janela para selecao do arquivo de amostras.
	 */
	private void btnSelectSamplesFile() {
		try {

			JFileChooser fileChooser = new JFileChooser(".");
			fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
			fileChooser.setMultiSelectionEnabled(false);
			fileChooser.showOpenDialog(this.frame);
			File selectedFile = fileChooser.getSelectedFile();
			if (selectedFile != null) {

				String sampleFile = FileUtils.readFileToString(selectedFile, StandardCharsets.UTF_8);
				this.frame.getTxtAmostras().setText(selectedFile.getAbsolutePath());
				this.frame.getTextAreaResults().setText(sampleFile);

			} else {

				this.frame.getTxtAmostras().setText(this.bundle.getString("txtAmostras.text"));
				this.frame.getTextAreaResults().setText("");

			}

		} catch (Exception e) {
			Messages.showErrorMessage(this.frame, this.bundle.getString("msg.falha.carregar.arquivo.amostras"));
			this.frame.getTxtAmostras().setText("");
			this.frame.getTextAreaResults().setText("");
		}
	}

	/**
	 * Inicia a execucao do classificador de acord com os parametros informados.
	 */
	private void btnExecute() {
		if (checkFields()) {

			SampleFileDto sampleFile = readSampleFile();
			System.out.println(sampleFile);
			Integer kfold = Integer.parseInt(this.frame.getTxtKFold().getText());

			// TODO
		}
	}

	/**
	 * Realiza a leitura do arquivo de amostras.
	 * 
	 * @return {@link SampleFileDto}
	 */
	private SampleFileDto readSampleFile() {
		try {

			File samplesFile = new File(this.frame.getTxtAmostras().getText());
			List<String> linesFile = FileUtils.readLines(samplesFile, StandardCharsets.UTF_8);
			String[] header = StringUtils.split(linesFile.get(0), " ");
			Integer numberOfSamples = Integer.parseInt(header[0]);
			Integer attributesPerSample = Integer.parseInt(header[1]);

			double[][] attributes = new double[attributesPerSample][numberOfSamples];
			List<SampleDto> samples = new ArrayList<SampleDto>();
			for (int i = 1; i < linesFile.size(); i++) {

				List<Double> sampleAttr = new ArrayList<Double>();
				String[] sample = StringUtils.split(linesFile.get(i), " ");
				for (int j = 0; j < (sample.length - 1); j++) {

					double value = Double.parseDouble(sample[j]);
					sampleAttr.add(value);
					attributes[j][i - 1] = value;
				}
				samples.add(new SampleDto(sample[sample.length - 1], sampleAttr));
			}

			double[][] attributesZscore = new double[attributesPerSample][numberOfSamples];
			for (int i = 0; i < attributesPerSample; i++) {
				for (int j = 0; j < attributes[i].length; j++) {

					double zscore = new ZScore(attributes[i][j], attributes[i]).calculate();
					attributesZscore[i][j] = zscore;
				}
			}

			return new SampleFileDto(numberOfSamples, attributesPerSample, attributes, attributesZscore, samples);

		} catch (Exception e) {
			e.printStackTrace();
			Messages.showErrorMessage(this.frame, this.bundle.getString("msg.arquivo.amostras.invalido"));
			return null;
		}
	}

	/**
	 * Verifica se os campos obrigatorios foram preenchidos corretamente.
	 * 
	 * @return {@link Boolean}
	 */
	private boolean checkFields() {

		File samplesFile = new File(this.frame.getTxtAmostras().getText());
		if (!samplesFile.exists()) {
			String msg = MessageFormat.format(this.bundle.getString("msg.campo.xxx.obrigatorio"),
					this.bundle.getString("lblAmostras.text"));
			Messages.showWarningMessage(this.frame, msg);
			return false;
		}
		try {
			Integer.parseInt(this.frame.getTxtKFold().getText());
		} catch (Exception e) {
			String msg = MessageFormat.format(this.bundle.getString("msg.campo.xxx.obrigatorio"),
					this.bundle.getString("lblKFold.text"));
			Messages.showWarningMessage(this.frame, msg);
			return false;
		}

		return true;
	}

	/**
	 * Inicia a execucao do sistema.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		ResourceBundle bundle = ResourceBundle.getBundle("br.com.ufu.pgc204.knn.i18n.messages");
		try {

			try {
				UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			} catch (Exception e) {
				e.printStackTrace();
				Messages.showErrorMessage(null, bundle.getString("msg.falha.carregar.lookandfeel"));
			}

			new FrameController();

		} catch (Exception e) {
			e.printStackTrace();
			Messages.showErrorMessage(null, bundle.getString("msg.falha.iniciar.sistema"));
			System.exit(1);
		}
	}

}

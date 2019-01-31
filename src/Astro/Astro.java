package Astro;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class Astro {
	static String nomeArq;
	static int posicaoInicial = 0, posicaoFinal = 0, index = 0, indexD = 0;
	static String nomeTabelaFilha = "";
	static String caminhoSaida = "";
static String titulo = "Astro Conversion";
	public static void main(String[] args) throws FileNotFoundException {

//		nomeArq = //JOptionPane.showInputDialog("Informe o local do arquivo texto:\n",
//				("C:\\Users\\FSAGOMES\\Desktop\\java.txt");
		
		JOptionPane.showMessageDialog(null, "       	  Ao gerar o Script,\n    --Desmarcar indexFKs--" +
				"\nEscolha o seu Arq para conversão", titulo, 1);
		escolherArquivos(nomeArq);

//		// GRAVANDO EM NOVO ARQUIVO
		PrintStream saida = new PrintStream(new File(caminhoSaida));
		System.setOut(saida);

		try {
			FileReader arq = new FileReader(nomeArq);
			BufferedReader lerArq = new BufferedReader(arq);
			String linha;
			while (lerArq.ready()) {
				linha = lerArq.readLine();

//				if (linha.contains("CREATE TABLE")) {
//					posicaoInicial = linha.indexOf("TABLE") + 6;
//					posicaoFinal = linha.indexOf('(') - 2;
//					nomeTabelaFilha = linha.substring(posicaoInicial, posicaoFinal);
//					nomeTabelaFilha = nomeTabelaFilha.substring(0, 1).toUpperCase()
//							.concat(nomeTabelaFilha.substring(1));
//					index = 0;
//				}
//				if (linha.contains("CREATE INDEX")) {
//					index++;
//				}
//				index = 
				Tratamento.trataArquivo(linha);
				

			}
			arq.close();
			
			JOptionPane.showMessageDialog(null, "Muito Obrigado, Concluído com Sucesso", titulo, 1);
		} catch (IOException e) {
			JOptionPane.showInputDialog("Erro na abertura do arquivo: %s.\n", e.getMessage());
		}
	}

	// METODO PARA ESCOLHA DE ARQUIVO
	public static String escolherArquivos(String entrada) {
		File[] arquivos = null;
		JFileChooser fc = new JFileChooser();
		fc.setDialogTitle("Escolha o arquivo para Conversão");
		fc.setDialogType(JFileChooser.OPEN_DIALOG);
		fc.setApproveButtonText("Ok");
		fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
		fc.setMultiSelectionEnabled(true);
		int resultado = fc.showOpenDialog(fc);
		if (resultado == JFileChooser.CANCEL_OPTION) {
			System.exit(1);
		}
		arquivos = fc.getSelectedFiles();
		for (File f : arquivos) {
			// System.out.println(f.getParentFile()+ "\\" + f.getName());
			Astro.nomeArq = (f.getParentFile() + "\\" + f.getName());
			caminhoSaida = (f.getParentFile() + "\\Modificado_" + f.getName());
		}
		return null;
	}

}
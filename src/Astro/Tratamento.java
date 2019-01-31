package Astro;

public class Tratamento {
	static String nomeTabelaPai = null;

	public static void trataArquivo(String texto) {
		String palavra[] = new String[99];
		String nomeTabelaFilha = null;
		String id = null, FKs = null, aspasN = null;
		int tamanho, posicaoInicial = 0, posicaoFinal = 0;
		String aspas = null;

		if (texto.contains("TABLE") && texto.contains("(")) {
			posicaoInicial = texto.indexOf("TABLE") + 6;
			posicaoFinal = texto.indexOf('(') - 1;
			aspas = texto.substring(posicaoInicial, posicaoFinal);
			aspasN = ("\"" + aspas + "\"");
			texto = texto.replace(aspas, aspasN);
			System.out.println(texto);
		}
		if (texto.contains("REFERENCES")) {
			posicaoInicial = texto.indexOf("REFERENCES") + 11;
			posicaoFinal = texto.indexOf('(');
			aspas = texto.substring(posicaoInicial, posicaoFinal);
			aspasN = ("\"" + aspas + "\"");
			texto = texto.replace(aspas, aspasN);
		}

		if (texto.contains("INDEX")) {
			posicaoInicial = texto.indexOf("INDEX") + 6;
			posicaoFinal = texto.indexOf('(') - 1;
			aspas = texto.substring(posicaoInicial, posicaoFinal);
			palavra = aspas.split(" ");
			for (int j = 0; j < palavra.length; j++) {
				aspas = palavra[j];
				if (aspas.contains("ON")) {
				} else {
					aspasN = ("\"" + aspas + "\"");
					texto = texto.replace(aspas, aspasN);
				}
			}

		}

		if (texto.contains(" KEY") || texto.contains("INDEX") || texto.contains("REFERENCES")) {
			posicaoInicial = texto.indexOf('(') + 1;
			posicaoFinal = texto.indexOf(')');
			FKs = texto.substring(posicaoInicial, posicaoFinal);
			if (!FKs.contains(",")) {
				aspas = ("\"" + FKs + "\"");
				texto = texto.replace(FKs, aspas);
				System.out.println(texto);
			} else if (FKs.contains(",")) {
				palavra = FKs.split(", ");
				int i = 0;
				for (String palavra2 : palavra) {
					tamanho = palavra2.split(",").length + 1;
					aspas = palavra[i++];
					aspasN = ("\"" + aspas + "\"");
					texto = texto.replace(aspas, aspasN);
				}
				System.out.println(texto);
			}
		}
		// Colocando ASpas nome das Colunas
		else if (texto.contains(",") && !texto.contains("KEY") && !texto.contains("REFERENCES")
				&& !texto.contains(" INDEX")) {
			posicaoInicial = texto.indexOf(" ") + 2;
			posicaoFinal = texto.indexOf(",");
			aspas = texto.substring(posicaoInicial, posicaoFinal);
			palavra = aspas.split(" ");
			aspas = palavra[0];
			aspasN = ("\"" + aspas + "\"");
			texto = texto.replace(aspas, aspasN);
			System.out.println(texto);
		}

//		// Tratamento de INDEX
//		if (texto.contains("INDEX IFK")) {
//			posicaoInicial = texto.indexOf("INDEX") + 6;
//			posicaoFinal = texto.indexOf("ON");
//			createIndex = texto.substring(posicaoInicial, posicaoFinal);
//			createIndex = texto.replaceFirst(createIndex, "IXN"+ index+ nomeTabelaPai + "x" + nomeTabelaFilha + " ");
//			if (createIndex.contains("INDEX IFK")) {
//				posicaoInicial = createIndex.indexOf('(') + 1;
//				posicaoFinal = createIndex.indexOf(')');
//				FKs = createIndex.substring(posicaoInicial, posicaoFinal);
//				palavra = FKs.split(",");
//				for (String palavra3 : palavra) {
//					tamanho = palavra3.split("_").length;
//					id = palavra3.split("_")[tamanho - 1];
//					createIndex = createIndex.replaceFirst(palavra3, id);
//				}
//			}
//			System.out.println(createIndex);
//		}
//		// Tratamento de INDEX FK
//		else if (texto.contains("INDEX") && texto.contains("FKI")) {
//			posicaoInicial = texto.indexOf("INDEX") + 6;
//			posicaoFinal = texto.indexOf("ON");
//			createIndex = texto.substring(posicaoInicial, posicaoFinal);
//			palavra = createIndex.split("ON");
//			for (String palavra2 : palavra) {
//				tamanho = palavra2.split("_").length;
//				id = palavra2.split("_")[tamanho - 1].toString();
//				createIndex = texto.replaceFirst(palavra2, " " + id);
//				if (createIndex.contains("INDEX")) {
//					posicaoInicial = createIndex.indexOf('(') + 1;
//					posicaoFinal = createIndex.indexOf(')');
//					FKs = createIndex.substring(posicaoInicial, posicaoFinal);
//					palavra = FKs.split(",");
//					for (String palavra3 : palavra) {
//						tamanho = palavra3.split("_").length;
//						id = palavra3.split("_")[tamanho - 1];
//						createIndex = createIndex.replaceFirst(palavra3, id);
//					}
//				}
//				if (createIndex.contains("FKI")) {
//					posicaoInicial = texto.indexOf("FK") + 2;
//					posicaoFinal = texto.indexOf("ON");
//					indIndex = texto.substring(posicaoInicial, posicaoFinal);
//					createFK = (index + nomeTabelaPai + "x" + nomeTabelaFilha + " ");
//					createIndex = createIndex.replaceFirst(indIndex, createFK);
//				}
//			}
//			System.out.println(createIndex);
//		} else if (texto.contains("_")) {
//			palavra = texto.split("_");
//			System.out.println(palavra[palavra.length - 1].toString() + "	");
//		} 
		else {
			System.out.println("\n");
		}
		// return index;
	}

}
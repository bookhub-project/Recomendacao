	package br.bookhub;

		import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;
		import org.apache.mahout.cf.taste.model.DataModel;

			import java.io.File;
			import java.io.IOException;
//nesta classe est� a rela��o dos modelos de filmes e livros para a serem recomendados
			public class Recomendador {

				public DataModel getModeloLivros() throws IOException {
        //arquivo usado com a base de usu�rios, os c�digos dos livros e as notas atribu�das
					return getModelo("livros.csv");
    }

    		private DataModel getModelo(String path) throws IOException {
    				File file = new File("src/main/resources/" + path);
    				return new FileDataModel(file);
    				}



			}
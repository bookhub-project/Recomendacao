package br.bookhub;

import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.recommender.Recommender;


import java.io.IOException;
import java.util.List;

public class RecomendaLivros {

			public static void main(String[] args) throws TasteException, IOException {
					DataModel produtos = new Recomendador().getModeloLivros();
					Recommender recommender = new RecomendadorBuilder().buildRecommender(produtos);
        //listamos as recomeda��es para o usu�rio solicitado
					System.out.println("usuario 1");
					List<RecommendedItem> recommendations = recommender.recommend(1, 4);
					for (RecommendedItem recommendation : recommendations) {
						System.out.println("usu�rio 1, estes livros combinam com voce");
            			System.out.println(recommendation);
					}

						System.out.println("usuario 2");
        recommendations = recommender.recommend(2, 4);
        		for (RecommendedItem recommendation : recommendations) {
        				System.out.println("usu�rio 2, estes livros combinam com voce");
        				System.out.println(recommendation);
        }       
  }
}
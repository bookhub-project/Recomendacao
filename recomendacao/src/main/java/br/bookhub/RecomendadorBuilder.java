package br.bookhub;

import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.eval.RecommenderBuilder;
import org.apache.mahout.cf.taste.impl.neighborhood.ThresholdUserNeighborhood;
import org.apache.mahout.cf.taste.impl.recommender.GenericUserBasedRecommender;
import org.apache.mahout.cf.taste.impl.similarity.PearsonCorrelationSimilarity;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.neighborhood.UserNeighborhood;
import org.apache.mahout.cf.taste.recommender.Recommender;
import org.apache.mahout.cf.taste.recommender.UserBasedRecommender;
import org.apache.mahout.cf.taste.similarity.UserSimilarity;



//aqui connstruimos nosso recomendador
	public class RecomendadorBuilder implements RecommenderBuilder {
		public Recommender buildRecommender(DataModel model) throws TasteException {
        //ele ir� se basear na similaridade entre os usu�rios para contruir recomenda��es.
        UserSimilarity similarity = new PearsonCorrelationSimilarity(model);
        //pega a maior similaridade (vizinhan�a) entre os usu�rios do nosso modelo
        UserNeighborhood neighborhood = new ThresholdUserNeighborhood(0.1, similarity, model);
        //fazemos nossa recomenda��o baseada no usu�rio, que � retornada no recommender 
        UserBasedRecommender recommender = new GenericUserBasedRecommender(model, neighborhood, similarity);
        return recommender;
    }
}
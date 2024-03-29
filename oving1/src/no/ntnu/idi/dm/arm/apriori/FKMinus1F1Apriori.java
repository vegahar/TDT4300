package no.ntnu.idi.dm.arm.apriori;

import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class FKMinus1F1Apriori<V> extends BaseApriori<V> {

	public FKMinus1F1Apriori(List<ItemSet<V>> transactions) {
		super(transactions);
	}

	@Override
	public List<ItemSet<V>> aprioriGen(List<ItemSet<V>> frequentCandidatesKMinus1) {
		Collections.sort(frequentCandidatesKMinus1);
		int allGeneratedCandidatesCounter = 0;
		Set<ItemSet<V>> frequentCandidateSet = new HashSet<ItemSet<V>>();

        for(ItemSet<V> extend : frequentCandidatesKMinus1){

            for(ItemSet<V> frequent1 : frequent1Itemsets){

                ItemSet<V> temp = new ItemSet<V>();

                for (V item : extend.getItems()){
                    temp.addItem(item);
                }

                temp = temp.union(frequent1);

                if(temp.size() != extend.size()+1){
                    continue;
                }

                allGeneratedCandidatesCounter++;
                getAndCacheSupportForItemset(temp);
                frequentCandidateSet.add(temp);


            }
        }

		return new LinkedList<ItemSet<V>>(frequentCandidateSet);
	}
}

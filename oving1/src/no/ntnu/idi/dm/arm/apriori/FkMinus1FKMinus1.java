package no.ntnu.idi.dm.arm.apriori;

import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class FkMinus1FKMinus1<V> extends BaseApriori<V> {

	public FkMinus1FKMinus1(List<ItemSet<V>> transactions) {
		super(transactions);
	}

	@Override
	public List<ItemSet<V>> aprioriGen(List<ItemSet<V>> frequentCandidatesKMinus1) {

		Collections.sort(frequentCandidatesKMinus1);
		int allGeneratedCandidatesCounter = 0;
		Set<ItemSet<V>> frequentCandidateSet = new HashSet<ItemSet<V>>();


		for(ItemSet<V> itemSet1 : frequentCandidatesKMinus1){

    		for(ItemSet<V> itemSet2 : frequentCandidatesKMinus1){
                /*if(itemSet1.equals(itemSet2)){
                    continue;
                } */

                ItemSet<V> temp = new ItemSet<V>();

                if(itemSet1.firstKItemsIdentical(itemSet2) == itemSet1.size()-1){
                    temp = itemSet1.union(itemSet2);
                }

                if(temp.size() != itemSet1.size()+1){
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
